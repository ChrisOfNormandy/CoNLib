package com.github.chrisofnormandy.conlib.block.generic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;

public class Barricades {

    public static final Block create_wall(String name, Properties properties) {
        return BlockRegistry.register(name, new WallBlock(properties));
    }

    public static final Block create_wall(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new WallBlock(properties), group);
    }

    ////

    public static final Block create_fence(String name, Properties properties) {
        return BlockRegistry.register(name, new FenceBlock(properties));
    }

    public static final Block create_fence(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FenceBlock(properties), group);
    }
}
