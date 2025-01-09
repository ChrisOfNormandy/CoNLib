package com.github.chrisofnormandy.conlib.items;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {

    public static final RegistryObject<Item> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<Item> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<Item> create(String name, Properties properties) {
        return ItemRegistry.register(name, () -> new Item(properties));
    }

    public static final RegistryObject<Item> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return ItemRegistry.register(name, () -> new Item(properties), creativeTab);
    }
}