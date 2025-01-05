package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Carpets {
    public static Block create_carpet(String name) {
        return BlockRegistry.register(name, new CarpetBlock(Properties.copy(Blocks.WHITE_CARPET)));
    }

    public static Block create_carpet(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CarpetBlock(Properties.copy(Blocks.WHITE_CARPET)), creativeTab);
    }

    public static Block create_carpet(String name, Properties properties) {
        return BlockRegistry.register(name, new CarpetBlock(properties));
    }

    public static Block create_carpet(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CarpetBlock(properties), creativeTab);
    }
}
