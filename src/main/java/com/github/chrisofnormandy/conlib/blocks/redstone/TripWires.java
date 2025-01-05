package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TripWires {

    public static class Hook {
        public static final Block create(String name) {
            return BlockRegistry.register(name, new TripWireHookBlock(Properties.copy(Blocks.TRIPWIRE_HOOK)));
        }

        public static final Block create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TripWireHookBlock(Properties.copy(Blocks.TRIPWIRE_HOOK)),
                    creativeTab);
        }

        public static final Block create(String name, Properties properties) {
            return BlockRegistry.register(name, new TripWireHookBlock(properties));
        }

        public static final Block create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TripWireHookBlock(properties), creativeTab);
        }
    }

    public static class Wire {

        public static final Block create(String name, TripWireHookBlock hookBlock) {
            return BlockRegistry.register(name, new TripWireBlock(hookBlock, Properties.copy(Blocks.TRIPWIRE)));
        }

        public static final Block create(String name, TripWireHookBlock hookBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TripWireBlock(hookBlock, Properties.copy(Blocks.TRIPWIRE)),
                    creativeTab);
        }

        public static final Block create(String name, TripWireHookBlock hookBlock, Properties properties) {
            return BlockRegistry.register(name, new TripWireBlock(hookBlock, properties));
        }

        public static final Block create(String name, TripWireHookBlock hookBlock, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TripWireBlock(hookBlock, properties), creativeTab);
        }
    }
}
