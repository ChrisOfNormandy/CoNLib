package com.github.chrisofnormandy.conlib.items;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;

public class ModItem {

    public static class Dyed {

        public static final String[] dyes = new String[] { "red", "orange", "yellow", "lime", "green", "cyan",
                "light_blue",
                "blue", "magenta", "purple", "pink", "white", "light_gray", "gray", "black", "brown" };

        public static final Item[] createDyed(String name, Properties properties) {
            Item[] items = new Item[dyes.length];

            for (int i = 0; i < dyes.length; i++) {
                items[i] = ModItem.create(dyes[i] + "_" + name, properties);
            }

            return items;
        }

        public static final Item[] createDyed(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            Item[] items = new Item[dyes.length];

            for (int i = 0; i < dyes.length; i++) {
                items[i] = ModItem.create(dyes[i] + "_" + name, properties, creativeTab);
            }

            return items;
        }
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return ItemRegistry.register(name, properties, creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return ItemRegistry.register(name, properties);
    }
}