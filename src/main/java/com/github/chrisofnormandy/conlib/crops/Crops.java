package com.github.chrisofnormandy.conlib.crops;

import com.github.chrisofnormandy.conlib.crops.types.Crop;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Crops {

    public static final RegistryObject<Crop> create(String name, Item seed) {
        return BlockRegistry.register(name, () -> new Crop(seed));
    }

    public static final RegistryObject<Crop> create(String name, Properties properties, Item seed) {
        return BlockRegistry.register(name, () -> new Crop(properties, seed));
    }
}
