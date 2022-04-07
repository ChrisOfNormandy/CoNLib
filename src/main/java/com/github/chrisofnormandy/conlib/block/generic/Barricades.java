package com.github.chrisofnormandy.conlib.block.generic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;

public class Barricades {

    public static final Block create_wall(String name, Properties properties) {
        return BlockRegistry.register(name, new WallBlock(properties));
    }

    public static final Block create_wall(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new WallBlock(properties), group);
    }

    ////

    public static final Block create_fence(String name, Properties properties) {
        return BlockRegistry.register(name, new FenceBlock(properties));
    }

    public static final Block create_fence(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new FenceBlock(properties), group);
    }
}
