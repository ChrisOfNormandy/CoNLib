package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bells {

    public static final BellBlock create(String name) {
        return create(name, Properties.copy(Blocks.BELL));
    }

    public static final BellBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BELL), creativeTab);
    }

    public static final BellBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new BellBlock(properties));
    }

    public static final BellBlock create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BellBlock(properties), creativeTab);
    }
}
