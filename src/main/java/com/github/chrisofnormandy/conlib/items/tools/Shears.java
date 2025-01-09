package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShearsItem;
import net.minecraftforge.registries.RegistryObject;

public class Shears {

    public static final RegistryObject<ShearsItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<ShearsItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<ShearsItem> create(String name, Properties properties) {
        var shears = ItemRegistry.register(name, () -> new ShearsItem(properties));
        ModRegister.tools.put(name, shears);

        return shears;
    }

    public static final RegistryObject<ShearsItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var shears = ItemRegistry.register(name, () -> new ShearsItem(properties), creativeTab);
        ModRegister.tools.put(name, shears);

        return shears;
    }
}
