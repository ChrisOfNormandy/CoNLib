package com.github.chrisofnormandy.conlib.husbandry.types;

import java.util.function.Consumer;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Egg<T extends Animal> extends Block {
    public final int MAX_HATCH_LEVEL = 2;
    public final IntegerProperty HATCH = BlockStateProperties.HATCH;

    private final int REGULAR_HATCH_TIME_TICKS = 24000;
    private final int BOOSTED_HATCH_TIME_TICKS = 12000;
    private final int RANDOM_HATCH_OFFSET_TICKS = 300;

    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 2.0D, 15.0D, 16.0D, 14.0D);

    private EntityType<T> creature; // The entity type for the animal
    private TagKey<Block> nestingBlockTag;
    private Consumer<T> birthEvent;

    public Egg(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return SHAPE;
    }

    public int getHatchLevel(BlockState blockState) {
        return blockState.getValue(HATCH);
    }

    private boolean isReadyToHatch(BlockState blockState) {
        return this.getHatchLevel(blockState) == MAX_HATCH_LEVEL;
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!this.isReadyToHatch(blockState)) {
            serverLevel.playSound((Player) null, blockPos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 0.7F,
                    0.9F + randomSource.nextFloat() * 0.2F);
            serverLevel.setBlock(blockPos,
                    blockState.setValue(HATCH, Integer.valueOf(this.getHatchLevel(blockState) + 1)),
                    2);
        } else {
            serverLevel.playSound((Player) null, blockPos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS, 0.7F,
                    0.9F + randomSource.nextFloat() * 0.2F);
            serverLevel.destroyBlock(blockPos, false);

            T newCreature = creature.create(serverLevel);

            if (newCreature != null) {
                if (birthEvent != null)
                    birthEvent.accept(newCreature);

                Vec3 vec3 = blockPos.getCenter();
                newCreature.setBaby(true);

                newCreature.moveTo(vec3.x(), vec3.y(), vec3.z(),
                        Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F),
                        0.0F);

                serverLevel.addFreshEntity(newCreature);
            }
        }
    }

    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState _blockState,
            boolean unused) {
        boolean flag = hatchBoost(level, blockPos);

        if (!level.isClientSide() && flag)
            level.levelEvent(3009, blockPos, 0);

        int i = flag
                ? BOOSTED_HATCH_TIME_TICKS
                : REGULAR_HATCH_TIME_TICKS;
        int j = i / 3;

        level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(blockState));
        level.scheduleTick(blockPos, this, j + level.random.nextInt(RANDOM_HATCH_OFFSET_TICKS));
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            PathComputationType pathComputationType) {
        return false;
    }

    public boolean hatchBoost(BlockGetter blockGetter, BlockPos blockPos) {
        if (nestingBlockTag == null)
            return false;

        return blockGetter.getBlockState(blockPos.below()).is(nestingBlockTag);
    }
}
