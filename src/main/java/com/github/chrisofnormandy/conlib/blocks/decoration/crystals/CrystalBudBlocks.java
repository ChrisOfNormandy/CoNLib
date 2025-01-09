package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import com.github.chrisofnormandy.conlib.blocks.decoration.crystals.types.BuddingCrystal;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class CrystalBudBlocks {

    public static final RegistryObject<BuddingCrystal> create(String name) {
        return create(name, Properties.copy(Blocks.BUDDING_AMETHYST));
    }

    public static final RegistryObject<BuddingCrystal> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BUDDING_AMETHYST), creativeTab);
    }

    public static final RegistryObject<BuddingCrystal> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new BuddingCrystal(properties));
    }

    public static final RegistryObject<BuddingCrystal> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new BuddingCrystal(properties), creativeTab);
    }

    public static final RegistryObject<BuddingCrystal> create(String name, Block smallCrystal,
            Block mediumCrystal, Block largeCrystal, Block fullCrystal) {
        return BlockRegistry.register(name,
                () -> new BuddingCrystal(Properties.copy(Blocks.BUDDING_AMETHYST), smallCrystal, mediumCrystal,
                        largeCrystal,
                        fullCrystal));
    }

    public static final RegistryObject<BuddingCrystal> create(String name,
            Block smallCrystal, Block mediumCrystal, Block largeCrystal, Block fullCrystal,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                () -> new BuddingCrystal(Properties.copy(Blocks.BUDDING_AMETHYST), smallCrystal, mediumCrystal,
                        largeCrystal,
                        fullCrystal),
                creativeTab);
    }

    public static final RegistryObject<BuddingCrystal> create(String name, Properties properties, Block smallCrystal,
            Block mediumCrystal, Block largeCrystal, Block fullCrystal) {
        return BlockRegistry.register(name,
                () -> new BuddingCrystal(properties, smallCrystal, mediumCrystal, largeCrystal, fullCrystal));
    }

    public static final RegistryObject<BuddingCrystal> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab,
            Block smallCrystal, Block mediumCrystal, Block largeCrystal, Block fullCrystal) {
        return BlockRegistry.register(name,
                () -> new BuddingCrystal(properties, smallCrystal, mediumCrystal, largeCrystal, fullCrystal),
                creativeTab);
    }
}
