package com.github.chrisofnormandy.conlib.dimensions.portals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorizontalPortal extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    private ResourceKey<Level> dimension;

    public HorizontalPortal(Properties properties, ResourceKey<Level> dimension) {
        super(properties);
        this.dimension = dimension;
    }

    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TheEndPortalBlockEntity(blockPos, blockState);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext context) {
        return SHAPE;
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (level instanceof ServerLevel && entity.canChangeDimensions()
                && Shapes.joinIsNotEmpty(
                        Shapes.create(entity.getBoundingBox().move((double) (-blockPos.getX()),
                                (double) (-blockPos.getY()), (double) (-blockPos.getZ()))),
                        blockState.getShape(level, blockPos), BooleanOp.AND)) {
            ResourceKey<Level> resourcekey = level.dimension() == this.dimension
                    ? Level.OVERWORLD
                    : this.dimension;

            ServerLevel serverlevel = ((ServerLevel) level).getServer().getLevel(resourcekey);

            if (serverlevel == null)
                return;

            entity.changeDimension(serverlevel);
        }
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        double d0 = (double) blockPos.getX() + randomSource.nextDouble();
        double d1 = (double) blockPos.getY() + 0.8D;
        double d2 = (double) blockPos.getZ() + randomSource.nextDouble();

        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    public ItemStack getCloneItemStack(BlockGetter p_53021_, BlockPos p_53022_, BlockState p_53023_) {
        return ItemStack.EMPTY;
    }

    public boolean canBeReplaced(BlockState p_53035_, Fluid p_53036_) {
        return false;
    }
}
