package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
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
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        ModRegister.items.put(name, item);
        return item;
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
    public static final Item register(String name, ItemGroup group) {
        return register(name, new Item(new Properties().tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item register(String name, Properties properties, ItemGroup group) {
        return register(name, new Item(properties.tab(group)));
    }
}
