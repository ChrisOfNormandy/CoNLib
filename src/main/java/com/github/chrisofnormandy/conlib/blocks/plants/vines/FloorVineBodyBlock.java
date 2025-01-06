package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.TwistingVinesPlantBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FloorVineBodyBlock extends TwistingVinesPlantBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private GrowingPlantHeadBlock headBlock;

    public FloorVineBodyBlock(Properties properties, GrowingPlantHeadBlock headBlock) {
        super(properties);
        this.headBlock = headBlock;
    }

    public FloorVineBodyBlock(Properties properties) {
        super(properties);
    }

    public void setHeadBlock(GrowingPlantHeadBlock headBlock) {
        this.headBlock = headBlock;
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return headBlock;
    }
}
