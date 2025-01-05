package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Webs {
    public static final Block create_web(String name) {
        return BlockRegistry.register(name, new WebBlock(Properties.copy(Blocks.COBWEB)));
    }

    public static final Block create_web(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new WebBlock(Properties.copy(Blocks.COBWEB)), creativeTab);
    }

    public static final Block create_web(String name, Properties properties) {
        return BlockRegistry.register(name, new WebBlock(properties));
    }

    public static final Block create_web(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new WebBlock(properties), creativeTab);
    }
}
