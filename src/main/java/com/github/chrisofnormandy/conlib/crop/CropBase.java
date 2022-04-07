package com.github.chrisofnormandy.conlib.crop;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CropBase extends CropBlock {
    /**
     * 
     */
    public CropBase() {
        super(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS));
        // this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(),
        // Integer.valueOf(0)));
    }
}