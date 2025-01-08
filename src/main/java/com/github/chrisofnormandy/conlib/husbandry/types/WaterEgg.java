package com.github.chrisofnormandy.conlib.husbandry.types;

import java.util.function.Consumer;

import com.google.common.annotations.VisibleForTesting;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WaterEgg<T extends Animal> extends Block {
    private static final int MIN_SPAWN = 2;
    private static final int MAX_SPAWN = 5;
    private static final int DEFAULT_MIN_HATCH_TICK_DELAY = 3600;
    private static final int DEFAULT_MAX_HATCH_TICK_DELAY = 12000;

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.5D, 16.0D);

    private static int minHatchTickDelay = DEFAULT_MIN_HATCH_TICK_DELAY;
    private static int maxHatchTickDelay = DEFAULT_MAX_HATCH_TICK_DELAY;

    private EntityType<T> creature; // The entity type for the animal
    private FlowingFluid fluid = Fluids.WATER;
    private Consumer<T> birthEvent;

    public WaterEgg(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return SHAPE;
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return mayPlaceOn(levelReader, blockPos.below());
    }

    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState _blockState,
            boolean unused) {
        level.scheduleTick(blockPos, this, getHatchDelay(level.getRandom()));
    }

    private static int getHatchDelay(RandomSource randomSource) {
        return randomSource.nextInt(minHatchTickDelay, maxHatchTickDelay);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState nextBlockState,
            LevelAccessor levelAccessor, BlockPos oldBlockPos, BlockPos newBlockPos) {
        return !this.canSurvive(blockState, levelAccessor, oldBlockPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(blockState, direction, nextBlockState, levelAccessor, oldBlockPos, newBlockPos);
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!this.canSurvive(blockState, serverLevel, blockPos))
            this.destroyBlock(serverLevel, blockPos);
        else
            this.hatchCreatures(serverLevel, blockPos, randomSource);
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (entity.getType().equals(EntityType.FALLING_BLOCK))
            this.destroyBlock(level, blockPos);
    }

    private boolean mayPlaceOn(BlockGetter blockGetter, BlockPos blockPos) {
        FluidState fluidstate = blockGetter.getFluidState(blockPos);
        FluidState fluidstate1 = blockGetter.getFluidState(blockPos.above());

        return fluidstate.getType() == fluid && fluidstate1.getType() == Fluids.EMPTY;
    }

    private void hatchCreatures(ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.destroyBlock(serverLevel, blockPos);
        serverLevel.playSound((Player) null, blockPos, SoundEvents.FROGSPAWN_HATCH, SoundSource.BLOCKS, 1.0F, 1.0F);
        this.spawnCreatures(serverLevel, blockPos, randomSource);
    }

    private void destroyBlock(Level level, BlockPos blockPos) {
        level.destroyBlock(blockPos, false);
    }

    private void spawnCreatures(ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        int i = randomSource.nextInt(MIN_SPAWN, MAX_SPAWN);

        // Spawn random number of creatures:

        for (int j = 1; j <= i; ++j) {
            T newCreature = this.creature.create(serverLevel);

            if (newCreature != null) {
                if (birthEvent != null)
                    birthEvent.accept(newCreature);

                double d0 = (double) blockPos.getX() + this.getRandomOffset(randomSource);
                double d1 = (double) blockPos.getZ() + this.getRandomOffset(randomSource);

                int k = randomSource.nextInt(1, 361);

                newCreature.moveTo(d0, (double) blockPos.getY() - 0.5D, d1, (float) k, 0.0F);
                newCreature.setPersistenceRequired();

                serverLevel.addFreshEntity(newCreature);
            }
        }
    }

    private double getRandomOffset(RandomSource randomSource) {
        return Mth.clamp(randomSource.nextDouble(), 0.5, 1.0D - 0.5);
    }

    @VisibleForTesting
    public static void setHatchDelay(int min, int max) {
        minHatchTickDelay = min;
        maxHatchTickDelay = max;
    }

    @VisibleForTesting
    public static void setDefaultHatchDelay() {
        minHatchTickDelay = DEFAULT_MIN_HATCH_TICK_DELAY;
        maxHatchTickDelay = DEFAULT_MAX_HATCH_TICK_DELAY;
    }
}
