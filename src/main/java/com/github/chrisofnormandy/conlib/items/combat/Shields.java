package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShieldItem;

public class Shields {

    public static final Item create(String name) {
        return create(name, new Item.Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        Item shield = new ShieldItem(properties);
        ModRegister.weapons.put(name, shield);

        return ItemRegistry.register(name, shield);
    }

    public static final Item create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item shield = new ShieldItem(properties);
        ModRegister.weapons.put(name, shield);

        return ItemRegistry.register(name, shield, creativeTab);
    }
}
