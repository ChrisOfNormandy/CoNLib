package com.github.chrisofnormandy.conlib.crops.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemNameBlockItem;

public class SeedBase extends ItemNameBlockItem {
    public SeedBase(Block cropBlock, Properties properties) {
        super(cropBlock, properties);
    }
}