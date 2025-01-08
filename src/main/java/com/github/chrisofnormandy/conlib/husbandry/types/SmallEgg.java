package com.github.chrisofnormandy.conlib.husbandry.types;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;

public class SmallEgg<T extends Animal> extends Block {
    public final int MAX_HATCH_LEVEL = 2;
    public final int MIN_EGGS = 1;
    public final int MAX_EGGS = 4;
    private final int RANDOM_HATCH_CHANCE = 500; // Higher = lower chance

    private final VoxelShape ONE_EGG_AABB = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 7.0D, 12.0D);
    private final VoxelShape MULTIPLE_EGGS_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 7.0D, 15.0D);
    public final IntegerProperty HATCH = BlockStateProperties.HATCH;
    public final IntegerProperty EGGS = BlockStateProperties.EGGS;

    private boolean destroyOnStep = true;
    private boolean destroyOnFall = true;
    private int destroyOnStepChange = 100; // Larger = lower chance
    private int destroyOnFallChange = 3; // Larger = lower chance

    private EntityType<T> creature; // The entity type for the animal
    private TagKey<Block> nestingBlockTag = BlockTags.SAND;
    private Consumer<T> birthEvent;

    public SmallEgg(Properties properties) {
        super(properties);
        BlockState blockState = this.stateDefinition.any()
                .setValue(HATCH, Integer.valueOf(0))
                .setValue(EGGS, Integer.valueOf(1));
        this.registerDefaultState(blockState);
    }

    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (this.destroyOnStep && !entity.isSteppingCarefully())
            this.destroyEgg(level, blockState, blockPos, entity, destroyOnStepChange);

        super.stepOn(level, blockPos, blockState, entity);
    }

    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float unknown) {
        if (this.destroyOnFall && !(entity instanceof Zombie))
            this.destroyEgg(level, blockState, blockPos, entity, destroyOnFallChange);

        super.fallOn(level, blockState, blockPos, entity, unknown);
    }

    private void destroyEgg(Level level, BlockState blockState, BlockPos blockPos, Entity entity,
            int chance) {
        if (this.canDestroyEgg(level, entity)) {
            if (!level.isClientSide
                    && level.random.nextInt(chance) == 0
                    && blockState.is(this)) {
                this.decreaseEggs(level, blockPos, blockState);
            }
        }
    }

    private void decreaseEggs(Level level, BlockPos blockPos, BlockState blockState) {
        level.playSound((Player) null, blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F,
                0.9F + level.random.nextFloat() * 0.2F);

        int i = blockState.getValue(EGGS);

        if (i <= 1) {
            level.destroyBlock(blockPos, false);
        } else {
            level.setBlock(blockPos, blockState.setValue(EGGS, Integer.valueOf(i - 1)), 2);
            level.gameEvent(GameEvent.BLOCK_DESTROY, blockPos, GameEvent.Context.of(blockState));
            level.levelEvent(2001, blockPos, Block.getId(blockState));
        }
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos,
            RandomSource randomSource) {
        if (this.shouldUpdateHatchLevel(serverLevel) && onAllowedNestingBlock(serverLevel, blockPos)) {
            int i = blockState.getValue(HATCH);

            if (i < 2) {
                // Increase hatch stage

                serverLevel.playSound((Player) null, blockPos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F,
                        0.9F + randomSource.nextFloat() * 0.2F);

                serverLevel.setBlock(blockPos, blockState.setValue(HATCH, Integer.valueOf(i + 1)), 2);
            } else {
                // Hatch the eggs

                serverLevel.playSound((Player) null, blockPos, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 0.7F,
                        0.9F + randomSource.nextFloat() * 0.2F);
                serverLevel.removeBlock(blockPos, false);

                // Spawn a new creature for each egg in the set:

                for (int j = 0; j < blockState.getValue(EGGS); ++j) {
                    serverLevel.levelEvent(2001, blockPos, Block.getId(blockState));

                    T newCreature = creature.create(serverLevel);

                    if (newCreature != null) {
                        if (birthEvent != null)
                            birthEvent.accept(newCreature);

                        // newCreature.setAge(-24000); // Needed?
                        // newCreature.setHomePos(blockPos);
                        newCreature.setBaby(true);
                        newCreature.moveTo((double) blockPos.getX() + 0.3D + (double) j * 0.2D,
                                (double) blockPos.getY(),
                                (double) blockPos.getZ() + 0.3D, 0.0F, 0.0F);

                        serverLevel.addFreshEntity(newCreature);
                    }
                }
            }
        }
    }

    public boolean onAllowedNestingBlock(BlockGetter blockGetter, BlockPos blockPos) {
        return isNestingBlock(blockGetter, blockPos.below());
    }

    public boolean isNestingBlock(BlockGetter blockGetter, BlockPos blockPos) {
        return blockGetter.getBlockState(blockPos).is(nestingBlockTag);
    }

    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState _blockState,
            boolean unknown) {
        if (onAllowedNestingBlock(level, blockPos) && !level.isClientSide)
            level.levelEvent(2005, blockPos, 0);
    }

    private boolean shouldUpdateHatchLevel(Level level) {
        float f = level.getTimeOfDay(1.0F);

        if ((double) f < 0.69D && (double) f > 0.65D)
            return true;

        return level.random.nextInt(RANDOM_HATCH_CHANCE) == 0;
    }

    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState,
            @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        this.decreaseEggs(level, blockPos, blockState);
    }

    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext context) {
        if (!context.isSecondaryUseActive()
                && context.getItemInHand().is(this.asItem())
                && blockState.getValue(EGGS) < MAX_EGGS)
            return true;

        return super.canBeReplaced(blockState, context);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_57761_) {
        BlockState blockstate = p_57761_.getLevel().getBlockState(p_57761_.getClickedPos());
        return blockstate.is(this)
                ? blockstate.setValue(EGGS, Integer.valueOf(Math.min(4, blockstate.getValue(EGGS) + 1)))
                : super.getStateForPlacement(p_57761_);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return blockState.getValue(EGGS) > 1
                ? MULTIPLE_EGGS_AABB
                : ONE_EGG_AABB;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH, EGGS);
    }

    private boolean canDestroyEgg(Level level, Entity entity) {
        // Creatures spawned from this egg cannot destroy them.
        if (creature.equals(entity.getType()))
            return false;

        // The player can always destroy eggs, and all other mobs if mob griefing is
        // enabled.
        return entity instanceof Player
                || ForgeEventFactory.getMobGriefingEvent(level, entity);
    }
}
