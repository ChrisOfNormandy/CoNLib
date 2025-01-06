package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bars {
    public static final IronBarsBlock create(String name) {
        return create(name, Properties.copy(Blocks.IRON_BARS));
    }

    public static final IronBarsBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.IRON_BARS), creativeTab);
    }

    public static final IronBarsBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new IronBarsBlock(properties));
    }

    public static final IronBarsBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new IronBarsBlock(properties), creativeTab);
    }
}
