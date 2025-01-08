package com.github.chrisofnormandy.conlib.husbandry;

import com.github.chrisofnormandy.conlib.husbandry.types.Egg;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Eggs {

    public static final <T extends Animal> Egg<T> create(String name) {
        return create(name, Properties.copy(Blocks.SNIFFER_EGG));
    }

    public static final <T extends Animal> Egg<T> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SNIFFER_EGG), creativeTab);
    }

    public static final <T extends Animal> Egg<T> create(String name, Properties properties) {
        return BlockRegistry.register(name, new Egg<T>(properties));
    }

    public static final <T extends Animal> Egg<T> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new Egg<T>(properties), creativeTab);
    }
}
