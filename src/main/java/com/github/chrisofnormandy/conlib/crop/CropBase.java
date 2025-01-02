package com.github.chrisofnormandy.conlib.crop;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;

public class CropBase extends CropBlock {
    public CropBase() {
        super(Block.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP));
    }
}