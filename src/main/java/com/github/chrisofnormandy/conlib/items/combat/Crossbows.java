package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Crossbows {

    public static final RegistryObject<CrossbowItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<CrossbowItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<CrossbowItem> create(String name, Properties properties) {
        var crossbow = ItemRegistry.register(name, () -> new CrossbowItem(properties));
        ModRegister.weapons.put(name, crossbow);

        return crossbow;
    }

    public static final RegistryObject<CrossbowItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var crossbow = ItemRegistry.register(name, () -> new CrossbowItem(properties), creativeTab);
        ModRegister.weapons.put(name, crossbow);

        return crossbow;
    }
}
