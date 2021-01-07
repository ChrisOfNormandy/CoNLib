package com.github.chrisofnormandy.conlib.item;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;

public class Main {
    public static String[] dyes = new String[] {"red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "magenta", "purple", "pink", "white", "light_gray", "gray", "black", "brown"};

    public static Item create(String name, Properties properties, ItemGroup group) {
        Item item = ModRegister.registerItem(name, properties, group);
        return item;
    }

    public static Item create(String name, Properties properties) {
        Item item = ModRegister.registerItem(name, properties);
        return item;
    }

    /**
     * 
     * @param name Only the base name. The dye name is added automatically. "dirt" -> "red_dirt" | "light_blue_dirt", etc...
     * @param properties
     */
    public static Item[] registerDyedSuite(String name, Properties properties, ItemGroup group) {
        Item[] items = new Item[dyes.length];

        for (int i = 0; i < dyes.length; i++) {
            items[i] = ModRegister.registerItem(dyes[i] + "_" + name, properties, group);
        }

        return items;
    }
}