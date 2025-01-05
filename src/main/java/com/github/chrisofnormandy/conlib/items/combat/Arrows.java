package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Arrows {

    public static final Item create(String name) {
        return create(name, new Item.Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        Item arrow = new ArrowItem(properties);
        ModRegister.weapons.put(name, arrow);

        return ItemRegistry.register(name, arrow);
    }

    public static final Item create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item arrow = new ArrowItem(properties);
        ModRegister.weapons.put(name, arrow);

        return ItemRegistry.register(name, arrow, creativeTab);
    }
}
