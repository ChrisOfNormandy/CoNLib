package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Observers {

    public static final RegistryObject<ObserverBlock> create(String name) {
        return create(name, Properties.copy(Blocks.OBSERVER));
    }

    public static final RegistryObject<ObserverBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OBSERVER), creativeTab);
    }

    public static final RegistryObject<ObserverBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new ObserverBlock(properties));
    }

    public static final RegistryObject<ObserverBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new ObserverBlock(properties), creativeTab);
    }
}
