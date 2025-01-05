package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class EndRods {
    public static Block create_endRod(String name) {
        return BlockRegistry.register(name, new EndRodBlock(Properties.copy(Blocks.END_ROD)));
    }

    public static Block create_endRod(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EndRodBlock(Properties.copy(Blocks.END_ROD)), creativeTab);
    }

    public static Block create_endRod(String name, Properties properties) {
        return BlockRegistry.register(name, new EndRodBlock(properties));
    }

    public static Block create_endRod(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EndRodBlock(properties), creativeTab);
    }
}
