package com.github.chrisofnormandy.conlib.husbandry;

import com.github.chrisofnormandy.conlib.husbandry.types.SmallEgg;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class SmallEggs {

    public static final <T extends Animal> RegistryObject<SmallEgg<T>> create(String name) {
        return create(name, Properties.copy(Blocks.TURTLE_EGG));
    }

    public static final <T extends Animal> RegistryObject<SmallEgg<T>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TURTLE_EGG), creativeTab);
    }

    public static final <T extends Animal> RegistryObject<SmallEgg<T>> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SmallEgg<T>(properties));
    }

    public static final <T extends Animal> RegistryObject<SmallEgg<T>> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SmallEgg<T>(properties), creativeTab);
    }
}
