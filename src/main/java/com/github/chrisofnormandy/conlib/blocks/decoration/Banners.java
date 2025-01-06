package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Banners {
    public static final BannerBlock create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE);
    }

    public static final BannerBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE, creativeTab);
    }

    public static final BannerBlock create(String name, Properties properties) {
        return create(name, properties, DyeColor.WHITE);
    }

    public static final BannerBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, DyeColor.WHITE, creativeTab);
    }

    public static final BannerBlock create(String name, DyeColor color) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), color);
    }

    public static final BannerBlock create(String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), color, creativeTab);
    }

    public static final BannerBlock create(String name, Properties properties, DyeColor color) {
        return BlockRegistry.register(name, new BannerBlock(color, properties));
    }

    public static final BannerBlock create(String name, Properties properties, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BannerBlock(color, properties), creativeTab);
    }
}
