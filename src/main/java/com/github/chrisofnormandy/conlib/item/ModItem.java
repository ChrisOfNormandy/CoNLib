package com.github.chrisofnormandy.conlib.item;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;

public class ModItem {
    public static final String[] dyes = new String[] { "red", "orange", "yellow", "lime", "green", "cyan", "light_blue",
            "blue", "magenta", "purple", "pink", "white", "light_gray", "gray", "black", "brown" };

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item create(String name, Properties properties, CreativeModeTab group) {
        Item item = ItemRegistry.register(name, properties, group);
        return item;
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Item create(String name, Properties properties) {
        Item item = ItemRegistry.register(name, properties);
        return item;
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item[] registerDyedSuite(String name, Properties properties, CreativeModeTab group) {
        Item[] items = new Item[dyes.length];

        for (int i = 0; i < dyes.length; i++) {
            items[i] = ItemRegistry.register(dyes[i] + "_" + name, properties, group);
        }

        return items;
    }
}