package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.itemgroup.Groups;

import net.minecraft.block.Block;
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
        return register(name, new Item(properties).setRegistryName(name));
    }

    /**
     * 
     * @param name       The generic item name, such as "my_item."
     * @param properties A set of properties defining the item.
     * @param group      The creative tab the item should be grouped in.
     * @return Item
     */
    public static Item register(String name, Properties properties, ItemGroup group) {
        return register(name, new Item(properties.tab(group)).setRegistryName(name));
    }

    /**
     * 
     * @param name          The generic creative tab name, such as "my_item."
     * @param icon_itemName The generic item or block name, such as "my_item" or
     *                      "my_block."
     * @return ItemGroup
     */
    public static Groups createGroup(String name, String icon_itemName) {
        Groups group = Groups.createGroup(name, icon_itemName);
        ModRegister.groups.put(name, group);
        return group;
    }

    /**
     * 
     * @param name  The generic creative tab name, such as "my_item."
     * @param block The generic block name, such as "my_block."
     * @return ItemGroup
     */
    public static Groups createGroup(String name, Block block) {
        Groups group = Groups.createGroup(name, block);
        ModRegister.groups.put(name, group);
        return group;
    }

    /**
     * 
     * @param name The generic creative tab name, such as "my_item."
     * @param item The generic item name, such as "my_item."
     * @return ItemGroup
     */
    public static Groups createGroup(String name, Item item) {
        Groups group = Groups.createGroup(name, item);
        ModRegister.groups.put(name, group);
        return group;
    }
}
