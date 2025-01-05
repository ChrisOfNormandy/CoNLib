package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bamboo {
    public static final Block create_bamboo(String name) {
        return BlockRegistry.register(name, new BambooStalkBlock(Properties.copy(Blocks.BAMBOO)));
    }

    public static final Block create_bamboo(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BambooStalkBlock(Properties.copy(Blocks.BAMBOO)), creativeTab);
    }

    public static final Block create_bamboo(String name, Properties properties) {
        return BlockRegistry.register(name, new BambooStalkBlock(properties));
    }

    public static final Block create_bamboo(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BambooStalkBlock(properties), creativeTab);
    }
}
