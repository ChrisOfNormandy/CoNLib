package com.github.chrisofnormandy.conlib.blocks.plants.melons;

import com.github.chrisofnormandy.conlib.blocks.plants.melons.types.Melon;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Melons {

    public static final Melon create(String name) {
        return create(name, Properties.copy(Blocks.MELON));
    }

    public static final Melon create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.MELON), creativeTab);
    }

    public static final Melon create(String name, Properties properties) {
        return BlockRegistry.register(name, new Melon(properties));
    }

    public static final Melon create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new Melon(properties), creativeTab);
    }
}
