package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.TwistingVinesBlock;

public class FloorVineHeadBlock extends TwistingVinesBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);
    private Block bodyBlock;

    public FloorVineHeadBlock(Properties properties, Block bodyBlock) {
        super(properties);
        this.bodyBlock = bodyBlock;
    }

    public FloorVineHeadBlock(Properties properties) {
        super(properties);
    }

    public void setBodyBlock(Block bodyBlock) {
        this.bodyBlock = bodyBlock;
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return NetherVines.getBlocksToGrowWhenBonemealed(randomSource);
    }

    protected Block getBodyBlock() {
        return this.bodyBlock;
    }

    protected boolean canGrowInto(BlockState blockState) {
        return NetherVines.isValidGrowthState(blockState);
    }
}
