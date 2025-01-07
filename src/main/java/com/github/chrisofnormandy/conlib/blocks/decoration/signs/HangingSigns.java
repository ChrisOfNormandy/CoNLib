package com.github.chrisofnormandy.conlib.blocks.decoration.signs;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HangingSigns {
    public static class CeilingHangingSigns {
        public static final CeilingHangingSignBlock create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final CeilingHangingSignBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final CeilingHangingSignBlock create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final CeilingHangingSignBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final CeilingHangingSignBlock create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, new CeilingHangingSignBlock(properties, woodType));
        }

        public static final CeilingHangingSignBlock create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CeilingHangingSignBlock(properties, woodType), creativeTab);
        }
    }

    public static class WallHangingSigns {
        public static final WallHangingSignBlock create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final WallHangingSignBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final WallHangingSignBlock create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final WallHangingSignBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final WallHangingSignBlock create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, new WallHangingSignBlock(properties, woodType));
        }

        public static final WallHangingSignBlock create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new WallHangingSignBlock(properties, woodType), creativeTab);
        }
    }

    public static final Tuple<WallHangingSignBlock, CeilingHangingSignBlock> create(String name) {
        CeilingHangingSignBlock ceiling = CeilingHangingSigns.create(name);
        WallHangingSignBlock wall = WallHangingSigns.create(name);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<WallHangingSignBlock, CeilingHangingSignBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        CeilingHangingSignBlock ceiling = CeilingHangingSigns.create(name, creativeTab);
        WallHangingSignBlock wall = WallHangingSigns.create(name, creativeTab);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<WallHangingSignBlock, CeilingHangingSignBlock> create(String name,
            Properties properties) {
        CeilingHangingSignBlock ceiling = CeilingHangingSigns.create(name, properties);
        WallHangingSignBlock wall = WallHangingSigns.create(name, properties);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<WallHangingSignBlock, CeilingHangingSignBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        CeilingHangingSignBlock ceiling = CeilingHangingSigns.create(name, properties, creativeTab);
        WallHangingSignBlock wall = WallHangingSigns.create(name, properties, creativeTab);

        return new Tuple<>(wall, ceiling);
    }
}
