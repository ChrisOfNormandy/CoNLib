package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class FireStarters {

    public static final Item create(String name) {
        return create(name, new Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        Item fas = new FlintAndSteelItem(properties);
        ModRegister.tools.put(name, fas);

        return ItemRegistry.register(name, fas);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item fas = new FlintAndSteelItem(properties);
        ModRegister.tools.put(name, fas);

        return ItemRegistry.register(name, fas, creativeTab);
    }
}
