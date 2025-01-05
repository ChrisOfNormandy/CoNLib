package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class FishingRods {

    public static final Item create(String name) {
        return create(name, new Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        Item rod = new FishingRodItem(properties);
        ModRegister.tools.put(name, rod);

        return ItemRegistry.register(name, rod);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item rod = new FishingRodItem(properties);
        ModRegister.tools.put(name, rod);

        return ItemRegistry.register(name, rod, creativeTab);
    }
}
