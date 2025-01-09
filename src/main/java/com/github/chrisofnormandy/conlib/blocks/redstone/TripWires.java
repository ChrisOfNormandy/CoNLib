package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class TripWires {

    public static class TripWireHooks {
        public static final RegistryObject<TripWireHookBlock> create(String name) {
            return create(name, Properties.copy(Blocks.TRIPWIRE_HOOK));
        }

        public static final RegistryObject<TripWireHookBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TRIPWIRE_HOOK), creativeTab);
        }

        public static final RegistryObject<TripWireHookBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new TripWireHookBlock(properties));
        }

        public static final RegistryObject<TripWireHookBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new TripWireHookBlock(properties), creativeTab);
        }
    }

    public static final RegistryObject<TripWireBlock> create(String name, TripWireHookBlock hookBlock) {
        return create(name, hookBlock, Properties.copy(Blocks.TRIPWIRE));
    }

    public static final RegistryObject<TripWireBlock> create(String name, TripWireHookBlock hookBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, hookBlock, Properties.copy(Blocks.TRIPWIRE), creativeTab);
    }

    public static final RegistryObject<TripWireBlock> create(String name, TripWireHookBlock hookBlock,
            Properties properties) {
        return BlockRegistry.register(name, () -> new TripWireBlock(hookBlock, properties));
    }

    public static final RegistryObject<TripWireBlock> create(String name, TripWireHookBlock hookBlock,
            Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TripWireBlock(hookBlock, properties), creativeTab);
    }
}
