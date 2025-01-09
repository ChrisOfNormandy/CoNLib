package com.github.chrisofnormandy.conlib.blocks.plants.vines.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WeepingVinesPlantBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RoofVineBodyBlock extends WeepingVinesPlantBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    private GrowingPlantHeadBlock headBlock;

    public RoofVineBodyBlock(Properties properties, GrowingPlantHeadBlock headBlock) {
        super(properties);
        this.headBlock = headBlock;
    }

    public RoofVineBodyBlock(Properties properties) {
        super(properties);
    }

    public void setHeadBlock(GrowingPlantHeadBlock headBlock) {
        this.headBlock = headBlock;
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return this.headBlock;
    }
}
