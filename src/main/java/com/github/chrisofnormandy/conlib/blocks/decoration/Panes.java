package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Panes {
    public static final Block create_pane(String name) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.GLASS_PANE)));
    }

    public static final Block create_pane_bars(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.IRON_BARS)), creativeTab);
    }

    public static final Block create_pane_bars(String name) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.IRON_BARS)));
    }

    public static final Block create_pane(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.GLASS_PANE)), creativeTab);
    }

    public static final Block create_pane(String name, Properties properties) {
        return BlockRegistry.register(name, new IronBarsBlock(properties));
    }

    public static final Block create_pane(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new IronBarsBlock(properties), creativeTab);
    }
}
