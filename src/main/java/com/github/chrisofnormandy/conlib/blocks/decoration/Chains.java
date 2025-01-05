package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Chains {
    public static final Block create_chain(String name) {
        return BlockRegistry.register(name, new ChainBlock(Properties.copy(Blocks.CHAIN)));
    }

    public static final Block create_chain(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChainBlock(Properties.copy(Blocks.CHAIN)), creativeTab);
    }

    public static final Block create_chain(String name, Properties properties) {
        return BlockRegistry.register(name, new ChainBlock(properties));
    }

    public static final Block create_chain(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChainBlock(properties), creativeTab);
    }
}
