package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Banners {
    public static class StandingBanners {

        public static final RegistryObject<BannerBlock> create(String name) {
            return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE);
        }

        public static final RegistryObject<BannerBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE, creativeTab);
        }

        public static final RegistryObject<BannerBlock> create(String name, Properties properties) {
            return create(name, properties, DyeColor.WHITE);
        }

        public static final RegistryObject<BannerBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, DyeColor.WHITE, creativeTab);
        }

        public static final RegistryObject<BannerBlock> create(String name, DyeColor color) {
            return create(name, Properties.copy(Blocks.WHITE_BANNER), color);
        }

        public static final RegistryObject<BannerBlock> create(String name, DyeColor color,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WHITE_BANNER), color, creativeTab);
        }

        public static final RegistryObject<BannerBlock> create(String name, Properties properties, DyeColor color) {
            return BlockRegistry.register(name, () -> new BannerBlock(color, properties));
        }

        public static final RegistryObject<BannerBlock> create(String name, Properties properties, DyeColor color,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new BannerBlock(color, properties), creativeTab);
        }
    }

    public static class WallBanners {

        public static final RegistryObject<WallBannerBlock> create(String name) {
            return create(name, Properties.copy(Blocks.WHITE_WALL_BANNER), DyeColor.WHITE);
        }

        public static final RegistryObject<WallBannerBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WHITE_WALL_BANNER), DyeColor.WHITE, creativeTab);
        }

        public static final RegistryObject<WallBannerBlock> create(String name, Properties properties) {
            return create(name, properties, DyeColor.WHITE);
        }

        public static final RegistryObject<WallBannerBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, DyeColor.WHITE, creativeTab);
        }

        public static final RegistryObject<WallBannerBlock> create(String name, DyeColor color) {
            return create(name, Properties.copy(Blocks.WHITE_WALL_BANNER), color);
        }

        public static final RegistryObject<WallBannerBlock> create(String name, DyeColor color,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WHITE_WALL_BANNER), color, creativeTab);
        }

        public static final RegistryObject<WallBannerBlock> create(String name, Properties properties, DyeColor color) {
            return BlockRegistry.register(name, () -> new WallBannerBlock(color, properties));
        }

        public static final RegistryObject<WallBannerBlock> create(String name, Properties properties, DyeColor color,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new WallBannerBlock(color, properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), DyeColor.WHITE, creativeTab);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            Properties properties) {
        return create(name, properties, DyeColor.WHITE);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, DyeColor.WHITE, creativeTab);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            DyeColor color) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), color);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_BANNER), color, creativeTab);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            Properties properties, DyeColor color) {
        var standing = StandingBanners.create(name, properties, color);
        var wall = WallBanners.create(name, properties, color);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<RegistryObject<BannerBlock>, RegistryObject<WallBannerBlock>> create(String name,
            Properties properties, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingBanners.create(name, properties, color, creativeTab);
        var wall = WallBanners.create(name, properties, color);

        return new Tuple<>(standing, wall);
    }
}
