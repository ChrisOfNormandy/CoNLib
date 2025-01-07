package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.CarvedGourd;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Basically identical to CarvedGourds, but this one applies lighting.

public class CarvedGourdLanterns {

    public static final CarvedGourd create(String name) {
        return create(name, Properties.copy(Blocks.JACK_O_LANTERN), 15);
    }

    public static final CarvedGourd create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.JACK_O_LANTERN), 15, creativeTab);
    }

    public static final CarvedGourd create(String name, Properties properties) {
        return create(name, properties, 15);
    }

    public static final CarvedGourd create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, 15, creativeTab);
    }

    public static final CarvedGourd create(String name, Properties properties, int lightLevel) {
        return BlockRegistry.register(name, new CarvedGourd(properties.lightLevel((blockState) -> lightLevel)));
    }

    public static final CarvedGourd create(String name, Properties properties,
            int lightLevel,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CarvedGourd(properties.lightLevel((blockState) -> lightLevel)),
                creativeTab);
    }
}
