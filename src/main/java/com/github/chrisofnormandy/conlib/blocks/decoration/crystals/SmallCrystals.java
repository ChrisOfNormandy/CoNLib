package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class SmallCrystals {
    public static final RegistryObject<AmethystClusterBlock> create(String name) {
        return create(name, Properties.copy(Blocks.AMETHYST_CLUSTER));
    }

    public static final RegistryObject<AmethystClusterBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.AMETHYST_CLUSTER), creativeTab);
    }

    public static final RegistryObject<AmethystClusterBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new AmethystClusterBlock(3, 4, properties));
    }

    public static final RegistryObject<AmethystClusterBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new AmethystClusterBlock(3, 4, properties), creativeTab);
    }
}
