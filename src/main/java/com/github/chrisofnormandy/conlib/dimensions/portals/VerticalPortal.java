package com.github.chrisofnormandy.conlib.dimensions.portals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VerticalPortal extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final int AABB_OFFSET = 2;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    // This should be a set:
    private EntityType<?>[] spawnableEntities = new EntityType<?>[] {};
    private SoundEvent ambientSound = SoundEvents.PORTAL_AMBIENT;
    private ParticleOptions particles = ParticleTypes.PORTAL;

    public VerticalPortal(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        if ((Direction.Axis) blockState.getValue(AXIS) == Direction.Axis.Z)
            return Z_AXIS_AABB;

        return X_AXIS_AABB;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos,
            RandomSource randomSource) {
        if (spawnableEntities.length == 0)
            return;

        boolean spawningAllowed = serverLevel.dimensionType().natural()
                && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING);
        boolean onRand = randomSource.nextInt(2000) < serverLevel.getDifficulty().getId();

        if (spawningAllowed && onRand) {
            while (serverLevel.getBlockState(blockPos).is(this))
                blockPos = blockPos.below();

            EntityType<?> entityToSpawn = this.spawnableEntities[randomSource.nextInt(spawnableEntities.length)];

            if (serverLevel.getBlockState(blockPos).isValidSpawn(serverLevel, blockPos, entityToSpawn)) {
                Entity entity = entityToSpawn.spawn(serverLevel, blockPos.above(), MobSpawnType.STRUCTURE);

                if (entity != null)
                    entity.setPortalCooldown();
            }
        }
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState sourceBlockState,
            LevelAccessor levelAccessor,
            BlockPos blockPos, BlockPos blockPosY) {
        Direction.Axis direction$axis = direction.getAxis();
        Direction.Axis direction$axis1 = blockState.getValue(AXIS);

        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();

        return !flag
                && !sourceBlockState.is(this)
                && !(new PortalShape(levelAccessor, blockPos, direction$axis1)).isComplete()
                        ? Blocks.AIR.defaultBlockState()
                        : blockState;
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (entity.canChangeDimensions())
            entity.handleInsidePortal(blockPos);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(100) == 0) {
            level.playLocalSound((double) blockPos.getX() + 0.5D,
                    (double) blockPos.getY() + 0.5D,
                    (double) blockPos.getZ() + 0.5D,
                    this.ambientSound,
                    SoundSource.BLOCKS,
                    0.5F,
                    randomSource.nextFloat() * 0.4F + 0.8F,
                    false);
        }

        for (int i = 0; i < 4; ++i) {
            double d0 = (double) blockPos.getX() + randomSource.nextDouble();
            double d1 = (double) blockPos.getY() + randomSource.nextDouble();
            double d2 = (double) blockPos.getZ() + randomSource.nextDouble();
            double d3 = ((double) randomSource.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double) randomSource.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double) randomSource.nextFloat() - 0.5D) * 0.5D;
            int j = randomSource.nextInt(2) * 2 - 1;
            if (!level.getBlockState(blockPos.west()).is(this)
                    && !level.getBlockState(blockPos.east()).is(this)) {
                d0 = (double) blockPos.getX() + 0.5D + 0.25D * (double) j;
                d3 = (double) (randomSource.nextFloat() * 2.0F * (float) j);
            } else {
                d2 = (double) blockPos.getZ() + 0.5D + 0.25D * (double) j;
                d5 = (double) (randomSource.nextFloat() * 2.0F * (float) j);
            }

            level.addParticle(this.particles, d0, d1, d2, d3, d4, d5);
        }
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return ItemStack.EMPTY;
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis) blockState.getValue(AXIS)) {
                    case Z:
                        return blockState.setValue(AXIS, Direction.Axis.X);
                    case X:
                        return blockState.setValue(AXIS, Direction.Axis.Z);
                    default:
                        return blockState;
                }
            default:
                return blockState;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}
