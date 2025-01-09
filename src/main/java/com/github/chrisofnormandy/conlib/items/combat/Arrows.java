package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Arrows {

    public static final RegistryObject<ArrowItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<ArrowItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<ArrowItem> create(String name, Properties properties) {
        var arrow = ItemRegistry.register(name, () -> new ArrowItem(properties));
        ModRegister.weapons.put(name, arrow);

        return arrow;
    }

    public static final RegistryObject<ArrowItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var arrow = ItemRegistry.register(name, () -> new ArrowItem(properties), creativeTab);
        ModRegister.weapons.put(name, arrow);

        return arrow;
    }
}
