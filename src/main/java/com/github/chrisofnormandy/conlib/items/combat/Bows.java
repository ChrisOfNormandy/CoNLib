package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Bows {

    public static final RegistryObject<BowItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<BowItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<BowItem> create(String name, Properties properties) {
        var bow = ItemRegistry.register(name, () -> new BowItem(properties));
        ModRegister.weapons.put(name, bow);

        return bow;
    }

    public static final RegistryObject<BowItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var bow = ItemRegistry.register(name, () -> new BowItem(properties), creativeTab);
        ModRegister.weapons.put(name, bow);

        return bow;
    }
}
