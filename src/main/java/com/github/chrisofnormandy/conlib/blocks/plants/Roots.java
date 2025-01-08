package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangroveRootsBlock;
import net.minecraft.world.level.block.RootedDirtBlock;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Roots {

    public static class HangingRoots {
        public static final RootsBlock create(String name) {
            return create(name, Properties.copy(Blocks.HANGING_ROOTS));
        }

        public static final RootsBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.HANGING_ROOTS), creativeTab);
        }

        public static final RootsBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new RootsBlock(properties));
        }

        public static final RootsBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new RootsBlock(properties), creativeTab);
        }
    }

    public static class SolidRoots {
        public static final MangroveRootsBlock create(String name) {
            return create(name, Properties.copy(Blocks.MANGROVE_ROOTS));
        }

        public static final MangroveRootsBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.MANGROVE_ROOTS), creativeTab);
        }

        public static final MangroveRootsBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new MangroveRootsBlock(properties));
        }

        public static final MangroveRootsBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new MangroveRootsBlock(properties), creativeTab);
        }
    }

    public static class SoilRoots {
        public static final RootedDirtBlock create(String name) {
            return create(name, Properties.copy(Blocks.ROOTED_DIRT));
        }

        public static final RootedDirtBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.ROOTED_DIRT), creativeTab);
        }

        public static final RootedDirtBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new RootedDirtBlock(properties));
        }

        public static final RootedDirtBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new RootedDirtBlock(properties), creativeTab);
        }
    }
}
