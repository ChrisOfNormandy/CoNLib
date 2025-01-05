package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShearsItem;

public class Shears {

    public static final Item create(String name) {
        return create(name, new Item.Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        Item shears = new ShearsItem(properties);
        ModRegister.tools.put(name, shears);

        return ItemRegistry.register(name, shears);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item shears = new ShearsItem(properties);
        ModRegister.tools.put(name, shears);

        return ItemRegistry.register(name, shears, creativeTab);
    }
}
