package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class FireStarters {

    public static final RegistryObject<FlintAndSteelItem> create(String name) {
        return create(name, new Properties());
    }

    public static final RegistryObject<FlintAndSteelItem> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final RegistryObject<FlintAndSteelItem> create(String name, Properties properties) {
        var fas = ItemRegistry.register(name, () -> new FlintAndSteelItem(properties));
        ModRegister.tools.put(name, fas);

        return fas;
    }

    public static final RegistryObject<FlintAndSteelItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var fas = ItemRegistry.register(name, () -> new FlintAndSteelItem(properties), creativeTab);
        ModRegister.tools.put(name, fas);

        return fas;
    }
}
