package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    /**
     * 
     * @param <T>  Any class that extends the Minecraft Item class.
     * @param name The generic item name, such as "my_item."
     * @param item The item instance.
     * @return Item
     */
    public static <T extends Item> T register(String name, T item) {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        ModRegister.items.put(name, item);
        return item;
    }

    /**
     * 
     * @param name       The generic item name, such as "my_item."
     * @param properties A set of properties defining the item.
     * @return Item
     */
    public static Item register(String name, Properties properties) {
        return register(name, new Item(properties));
    }

    /**
     * 
     * @param name       The generic item name, such as "my_item."
     * @param properties A set of properties defining the item.
     * @param group      The creative tab the item should be grouped in.
     * @return Item
     */
    public static Item register(String name, Properties properties, ItemGroup group) {
        return register(name, new Item(properties.tab(group)));
    }

    /**
     * 
     * @param name The generic item name, such as "my_item."
     * @return Item
     */
    public static Item register(String name) {
        return register(name, new Item(new Properties()));
    }
}
