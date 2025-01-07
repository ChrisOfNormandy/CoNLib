package com.github.chrisofnormandy.conlib.blocks.decoration.signs;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class Signs {
    public static class StandingSigns {
        public static final StandingSignBlock create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final StandingSignBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final StandingSignBlock create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final StandingSignBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final StandingSignBlock create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, new StandingSignBlock(properties, woodType));
        }

        public static final StandingSignBlock create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new StandingSignBlock(properties, woodType), creativeTab);
        }
    }

    public static class WallSigns {
        public static final WallSignBlock create(String name) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final WallSignBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final WallSignBlock create(String name, Properties properties) {
            return create(name, properties, WoodType.OAK);
        }

        public static final WallSignBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, WoodType.OAK, creativeTab);
        }

        public static final WallSignBlock create(String name, Properties properties,
                WoodType woodType) {
            return BlockRegistry.register(name, new WallSignBlock(properties, woodType));
        }

        public static final WallSignBlock create(String name, Properties properties,
                WoodType woodType,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new WallSignBlock(properties, woodType), creativeTab);
        }
    }

    public static final Tuple<WallSignBlock, StandingSignBlock> create(String name) {
        StandingSignBlock standing = StandingSigns.create(name);
        WallSignBlock wall = WallSigns.create(name);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<WallSignBlock, StandingSignBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        StandingSignBlock standing = StandingSigns.create(name, creativeTab);
        WallSignBlock wall = WallSigns.create(name, creativeTab);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<WallSignBlock, StandingSignBlock> create(String name, Properties properties) {
        StandingSignBlock standing = StandingSigns.create(name, properties);
        WallSignBlock wall = WallSigns.create(name, properties);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<WallSignBlock, StandingSignBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        StandingSignBlock standing = StandingSigns.create(name, properties, creativeTab);
        WallSignBlock wall = WallSigns.create(name, properties, creativeTab);

        return new Tuple<>(wall, standing);
    }
}
