package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Hoppers {
    public static final Block create_hopper(String name) {
        return BlockRegistry.register(name, new HopperBlock(Properties.copy(Blocks.HOPPER)));
    }

    public static final Block create_hopper(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new HopperBlock(Properties.copy(Blocks.HOPPER)), creativeTab);
    }

    public static final Block create_hopper(String name, Properties properties) {
        return BlockRegistry.register(name, new HopperBlock(properties));
    }

    public static final Block create_hopper(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new HopperBlock(properties), creativeTab);
    }
}
