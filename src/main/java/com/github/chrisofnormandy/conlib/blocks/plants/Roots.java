package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangroveRootsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Roots {

    public static final MangroveRootsBlock create(String name) {
        return create(name, Properties.copy(Blocks.MANGROVE_ROOTS));
    }

    public static final MangroveRootsBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.MANGROVE_ROOTS), creativeTab);
    }

    public static final MangroveRootsBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new MangroveRootsBlock(properties));
    }

    public static final MangroveRootsBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new MangroveRootsBlock(properties), creativeTab);
    }
}
