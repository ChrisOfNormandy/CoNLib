package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.registries.RegistryObject;

public class Shields {

    public static final RegistryObject<ShieldItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<ShieldItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<ShieldItem> create(String name, Properties properties) {
        var shield = ItemRegistry.register(name, () -> new ShieldItem(properties));
        ModRegister.weapons.put(name, shield);

        return shield;
    }

    public static final RegistryObject<ShieldItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var shield = ItemRegistry.register(name, () -> new ShieldItem(properties), creativeTab);
        ModRegister.weapons.put(name, shield);

        return shield;
    }
}
