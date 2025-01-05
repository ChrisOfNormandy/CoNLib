package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;

public class Fires {

    public static final Block create_fire(String name) {
        return BlockRegistry.register(name, new FireBlock(Properties.copy(Blocks.FIRE)));
    }

    public static final Block create_fire(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FireBlock(Properties.copy(Blocks.FIRE)), creativeTab);
    }

    public static final Block create_fire(String name, Properties properties) {
        return BlockRegistry.register(name, new FireBlock(properties));
    }

    public static final Block create_fire(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FireBlock(properties), creativeTab);
    }
}