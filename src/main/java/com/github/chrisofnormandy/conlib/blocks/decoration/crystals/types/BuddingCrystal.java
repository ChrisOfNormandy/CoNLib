package com.github.chrisofnormandy.conlib.blocks.decoration.crystals.types;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingCrystal extends BuddingAmethystBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    private Block smallCrystal = Blocks.SMALL_AMETHYST_BUD;
    private Block mediumCrystal = Blocks.MEDIUM_AMETHYST_BUD;
    private Block largeCrystal = Blocks.LARGE_AMETHYST_BUD;
    private Block fullCrystal = Blocks.AMETHYST_CLUSTER;

    public BuddingCrystal(Properties properties) {
        super(properties);
    }

    public BuddingCrystal(Properties properties, Block smallCrystal, Block mediumCrystal, Block largeCrystal,
            Block fullCrystal) {
        super(properties);

        this.smallCrystal = smallCrystal;
        this.mediumCrystal = mediumCrystal;
        this.largeCrystal = largeCrystal;
        this.fullCrystal = fullCrystal;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos,
            RandomSource randomSource) {
        if (randomSource.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[randomSource.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = blockPos.relative(direction);
            BlockState blockstate = serverLevel.getBlockState(blockpos);
            Block block = null;

            if (canClusterGrowAtState(blockstate)) {
                block = this.smallCrystal;
            } else if (blockstate.is(this.smallCrystal)
                    && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.mediumCrystal;
            } else if (blockstate.is(this.mediumCrystal)
                    && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.largeCrystal;
            } else if (blockstate.is(this.largeCrystal)
                    && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.fullCrystal;
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction)
                        .setValue(AmethystClusterBlock.WATERLOGGED,
                                Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                serverLevel.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }
}
