package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Reeds {
    public static final Block create_reeds(String name) {
        return BlockRegistry.register(name, new SugarCaneBlock(Properties.copy(Blocks.SUGAR_CANE)));
    }

    public static final Block create_reeds(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SugarCaneBlock(Properties.copy(Blocks.SUGAR_CANE)), creativeTab);
    }

    public static final Block create_reeds(String name, Properties properties) {
        return BlockRegistry.register(name, new SugarCaneBlock(properties));
    }

    public static final Block create_reeds(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SugarCaneBlock(properties), creativeTab);
    }
}
