package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class StickyBlocks {
    public static class Slime {
        public static final Block create_slimeBlock(String name) {
            return BlockRegistry.register(name, new SlimeBlock(Properties.copy(Blocks.SLIME_BLOCK)));
        }

        public static final Block create_slimeBlock(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new SlimeBlock(Properties.copy(Blocks.SLIME_BLOCK)), creativeTab);
        }

        public static final Block create_slimeBlock(String name, Properties properties) {
            return BlockRegistry.register(name, new SlimeBlock(properties));
        }

        public static final Block create_slimeBlock(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new SlimeBlock(properties), creativeTab);
        }
    }

    public static class Honey {
        public static final Block create_honeyBlock(String name) {
            return BlockRegistry.register(name, new HoneyBlock(Properties.copy(Blocks.HONEY_BLOCK)));
        }

        public static final Block create_honeyBlock(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new HoneyBlock(Properties.copy(Blocks.HONEY_BLOCK)), creativeTab);
        }

        public static final Block create_honeyBlock(String name, Properties properties) {
            return BlockRegistry.register(name, new HoneyBlock(properties));
        }

        public static final Block create_honeyBlock(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new HoneyBlock(properties), creativeTab);
        }
    }
}
