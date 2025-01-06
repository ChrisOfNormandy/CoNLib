package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class StickyBlocks {
    public static class SlimeBlocks {
        public static final SlimeBlock create(String name) {
            return create(name, Properties.copy(Blocks.SLIME_BLOCK));
        }

        public static final SlimeBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.SLIME_BLOCK), creativeTab);
        }

        public static final SlimeBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new SlimeBlock(properties));
        }

        public static final SlimeBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new SlimeBlock(properties), creativeTab);
        }
    }

    public static class HoneyBlocks {
        public static final HoneyBlock create(String name) {
            return create(name, Properties.copy(Blocks.HONEY_BLOCK));
        }

        public static final HoneyBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.HONEY_BLOCK), creativeTab);
        }

        public static final HoneyBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new HoneyBlock(properties));
        }

        public static final HoneyBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new HoneyBlock(properties), creativeTab);
        }
    }
}
