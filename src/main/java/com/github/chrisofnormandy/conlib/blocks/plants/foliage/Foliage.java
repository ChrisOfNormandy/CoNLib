package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Foliage {

    public static final GrassBlock create(String name) {
        return create(name, Properties.copy(Blocks.GRASS));
    }

    public static final GrassBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GRASS), creativeTab);
    }

    public static final GrassBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new GrassBlock(properties));
    }

    public static final GrassBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GrassBlock(properties), creativeTab);
    }
}
