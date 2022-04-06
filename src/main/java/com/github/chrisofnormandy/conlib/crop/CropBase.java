package com.github.chrisofnormandy.conlib.crop;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CropBase extends CropsBlock {
    /**
     * 
     */
    public CropBase() {
        super(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS));
        // this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(),
        // Integer.valueOf(0)));
    }

    /**
     * 
     * @param state
     * @param worldIn
     * @param pos
     * @return
     */
    protected boolean validGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() instanceof FarmlandBlock;
    }
}