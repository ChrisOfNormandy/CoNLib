package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bells {
    public static final Block create_bell(String name) {
        return BlockRegistry.register(name, new BellBlock(Properties.copy(Blocks.BELL)));
    }

    public static final Block create_bell(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BellBlock(Properties.copy(Blocks.BELL)), creativeTab);
    }

    public static final Block create_bell(String name, Properties properties) {
        return BlockRegistry.register(name, new BellBlock(properties));
    }

    public static final Block create_bell(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BellBlock(properties), creativeTab);
    }
}
