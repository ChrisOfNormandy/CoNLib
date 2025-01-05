package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Observers {
    public static final Block create_observer(String name) {
        return BlockRegistry.register(name, new ObserverBlock(Properties.copy(Blocks.OBSERVER)));
    }

    public static final Block create_observer(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ObserverBlock(Properties.copy(Blocks.OBSERVER)), creativeTab);
    }

    public static final Block create_observer(String name, Properties properties) {
        return BlockRegistry.register(name, new ObserverBlock(properties));
    }

    public static final Block create_observer(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ObserverBlock(properties), creativeTab);
    }
}
