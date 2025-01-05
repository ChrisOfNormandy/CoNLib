package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Levers {
    public static final Block create_lever(String name) {
        return BlockRegistry.register(name, new LeverBlock(Properties.copy(Blocks.LEVER)));
    }

    public static final Block create_lever(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LeverBlock(Properties.copy(Blocks.LEVER)), creativeTab);
    }

    public static final Block create_lever(String name, Properties properties) {
        return BlockRegistry.register(name, new LeverBlock(properties));
    }

    public static final Block create_lever(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LeverBlock(properties), creativeTab);
    }
}
