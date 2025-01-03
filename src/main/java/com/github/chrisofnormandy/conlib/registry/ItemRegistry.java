package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    /**
     *
     * @param <T>
     * @param name
     * @param item
     * @return
     */
    public static final <T extends Item> T register(String name, T item) {
        ForgeRegistries.ITEMS.register(name, item);
        ModRegister.items.put(name, item);
        return item;
    }

    public static final <T extends Item> T register(String name, T item, ResourceKey<CreativeModeTab> creativeTab) {
        return ModRegister.useCreativeTab(creativeTab, register(name, item));
    }

    /**
     *
     * @param name
     * @return
     */
    public static final Item register(String name) {
        return register(name, new Item(new Properties()));
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Item register(String name, Properties properties) {
        return register(name, new Item(properties));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Item register(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return ModRegister.useCreativeTab(creativeTab, register(name, new Item(new Properties())));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item register(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return ModRegister.useCreativeTab(creativeTab, register(name, new Item(properties)));
    }
}
