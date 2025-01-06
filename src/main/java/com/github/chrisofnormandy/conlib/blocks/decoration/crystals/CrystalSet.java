package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class CrystalSet {
    public static final Block[] create(String name) {
        Block smallCrystal = SmallCrystals.create("small_" + name + "_bud");
        Block mediumCrystal = MediumCrystals.create("medium_" + name + "_bud");
        Block largeCrystal = LargeCrystals.create("large_" + name + "_bud");
        Block fullCrystal = FullCrystals.create(name + "_cluster");
        Block buddingCrystal = CrystalBudBlocks.create("budding_" + name, smallCrystal, mediumCrystal, largeCrystal,
                fullCrystal);
        Block block = FullBlocks.create(name + "_block");

        return new Block[] { smallCrystal, mediumCrystal, largeCrystal, fullCrystal, buddingCrystal, block };
    }

    public static final Block[] create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        Block smallCrystal = SmallCrystals.create("small_" + name + "_bud", creativeTab);
        Block mediumCrystal = MediumCrystals.create("medium_" + name + "_bud", creativeTab);
        Block largeCrystal = LargeCrystals.create("large_" + name + "_bud", creativeTab);
        Block fullCrystal = FullCrystals.create(name + "_cluster", creativeTab);
        Block buddingCrystal = CrystalBudBlocks.create("budding_" + name, smallCrystal, mediumCrystal, largeCrystal,
                fullCrystal, creativeTab);
        Block block = FullBlocks.create(name + "_block", creativeTab);

        return new Block[] { smallCrystal, mediumCrystal, largeCrystal, fullCrystal, buddingCrystal, block };
    }
}
