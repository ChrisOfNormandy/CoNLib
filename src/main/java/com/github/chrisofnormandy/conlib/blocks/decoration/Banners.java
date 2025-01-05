package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Banners {
    public static final Block create_banner(String name, DyeColor color) {
        return BlockRegistry.register(name, new BannerBlock(color, Properties.copy(Blocks.WHITE_BANNER)));
    }

    public static final Block create_banner(String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BannerBlock(color, Properties.copy(Blocks.WHITE_BANNER)), creativeTab);
    }

    public static final Block create_banner(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new BannerBlock(color, properties));
    }

    public static final Block create_banner(String name, DyeColor color, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BannerBlock(color, properties), creativeTab);
    }
}
