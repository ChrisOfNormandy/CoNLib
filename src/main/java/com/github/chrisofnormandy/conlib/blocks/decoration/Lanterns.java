package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Lanterns {
    public static final Block create_lantern(String name) {
        return BlockRegistry.register(name, new LanternBlock(Properties.copy(Blocks.LANTERN)));
    }

    public static final Block create_lantern(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LanternBlock(Properties.copy(Blocks.LANTERN)), creativeTab);
    }

    public static final Block create_lantern(String name, Properties properties) {
        return BlockRegistry.register(name, new LanternBlock(properties));
    }

    public static final Block create_lantern(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LanternBlock(properties), creativeTab);
    }
}
