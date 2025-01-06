package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.item.Item;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final Item register(String name) {
        return register(name, new Item(new Properties()));
    }

    public static final Item register(String name, Properties properties) {
        return register(name, new Item(properties));
    }

    public static final <T extends Item> T register(String name, T item, ResourceKey<CreativeModeTab> creativeTab) {
        return ModRegister.useCreativeTab(creativeTab, register(name, item));
    }

    public static final Item register(String name, ResourceKey<CreativeModeTab> creativeTab) {
        Main.LOG.info("Registered new item: " + name);

        return ModRegister.useCreativeTab(creativeTab, register(name, new Item(new Properties())));
    }

    public static final Item register(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Main.LOG.info("Registered new item: " + name);

        return ModRegister.useCreativeTab(creativeTab, register(name, new Item(properties)));
    }

    public static final <T extends Item> T register(String name, T item) {
        ForgeRegistries.ITEMS.register(name, item);
        ModRegister.items.put(name, item);
        return item;
    }
}
