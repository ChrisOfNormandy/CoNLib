package com.github.chrisofnormandy.conlib.blocks.plants.sponges;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SpongeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class Sponge extends SpongeBlock {
    private static final Direction[] ALL_DIRECTIONS = Direction.values();
    private Block[] seaFoliage = new Block[] { Blocks.KELP, Blocks.KELP_PLANT, Blocks.SEAGRASS, Blocks.TALL_SEAGRASS };
    private Block wetSponge = Blocks.WET_SPONGE;
    private Block liquid = Blocks.WATER;

    public Sponge(Properties properties) {
        super(properties);
    }

    public Sponge setWetSponge(Block wetSponge) {
        this.wetSponge = wetSponge;

        return this;
    }

    public Sponge setSeaFoliage(Block[] seaFoliage) {
        this.seaFoliage = seaFoliage;

        return this;
    }

    public Sponge setLiquid(Block liquid) {
        this.liquid = liquid;

        return this;
    }

    protected void tryAbsorbWater(Level level, BlockPos blockPos) {
        if (this.removeWaterBreadthFirstSearch(level, blockPos)) {
            level.setBlock(blockPos, this.wetSponge.defaultBlockState(), 2);
            level.levelEvent(2001, blockPos, Block.getId(this.liquid.defaultBlockState()));
        }
    }

    private boolean checkSeaFoliage(BlockState blockState) {
        for (Block foliage : this.seaFoliage) {
            if (blockState.is(foliage)) {
                return false;
            }
        }

        return true;
    }

    private boolean removeWaterBreadthFirstSearch(Level level, BlockPos blockPos) {
        BlockState spongeState = level.getBlockState(blockPos);

        return BlockPos.breadthFirstTraversal(blockPos, 6, 65, (relBlockPos, blockPosConsumer) -> {
            for (Direction direction : ALL_DIRECTIONS) {
                blockPosConsumer.accept(relBlockPos.relative(direction));
            }
        }, (checkBlockPos) -> {
            if (checkBlockPos.equals(blockPos)) {
                return true;
            } else {
                BlockState blockstate = level.getBlockState(checkBlockPos);
                FluidState fluidstate = level.getFluidState(checkBlockPos);

                if (!spongeState.canBeHydrated(level, blockPos, fluidstate, checkBlockPos)) {
                    return false;
                }

                Block block = blockstate.getBlock();

                if (block instanceof BucketPickup) {
                    BucketPickup bucketpickup = (BucketPickup) block;

                    if (!bucketpickup.pickupBlock(level, checkBlockPos, blockstate).isEmpty()) {
                        return true;
                    }
                }

                if (blockstate.getBlock() instanceof LiquidBlock) {
                    level.setBlock(checkBlockPos, Blocks.AIR.defaultBlockState(), 3);
                } else {
                    if (checkSeaFoliage(blockstate)) {
                        return false;
                    }

                    BlockEntity blockentity = blockstate.hasBlockEntity()
                            ? level.getBlockEntity(checkBlockPos)
                            : null;

                    dropResources(blockstate, level, checkBlockPos, blockentity);

                    level.setBlock(checkBlockPos, Blocks.AIR.defaultBlockState(), 3);
                }

                return true;
            }
        }) > 1;
    }
}
