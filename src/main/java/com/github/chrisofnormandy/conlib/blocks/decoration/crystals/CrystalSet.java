package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.RegistryObject;

public class CrystalSet {
    public static final RegistryObject<?>[] create(String name) {
        var smallCrystal = SmallCrystals.create("small_" + name + "_bud");
        var mediumCrystal = MediumCrystals.create("medium_" + name + "_bud");
        var largeCrystal = LargeCrystals.create("large_" + name + "_bud");
        var fullCrystal = FullCrystals.create(name + "_cluster");
        var buddingCrystal = CrystalBudBlocks.create("budding_" + name,
                smallCrystal.get(),
                mediumCrystal.get(),
                largeCrystal.get(),
                fullCrystal.get());
        var block = CrystalBlocks.create(name + "_block");

        return new RegistryObject<?>[] {
                smallCrystal,
                mediumCrystal,
                largeCrystal,
                fullCrystal,
                buddingCrystal,
                block
        };
    }

    public static final RegistryObject<?>[] create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        var smallCrystal = SmallCrystals.create("small_" + name + "_bud", creativeTab);
        var mediumCrystal = MediumCrystals.create("medium_" + name + "_bud", creativeTab);
        var largeCrystal = LargeCrystals.create("large_" + name + "_bud", creativeTab);
        var fullCrystal = FullCrystals.create(name + "_cluster", creativeTab);
        var buddingCrystal = CrystalBudBlocks.create("budding_" + name,
                smallCrystal.get(),
                mediumCrystal.get(),
                largeCrystal.get(),
                fullCrystal.get(),
                creativeTab);
        var block = CrystalBlocks.create(name + "_block", creativeTab);

        return new RegistryObject<?>[] {
                smallCrystal,
                mediumCrystal,
                largeCrystal,
                fullCrystal,
                buddingCrystal,
                block
        };
    }
}
