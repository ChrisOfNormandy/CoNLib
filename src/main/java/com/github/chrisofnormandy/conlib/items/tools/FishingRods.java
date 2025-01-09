package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;

public class FishingRods {

    public static final RegistryObject<FishingRodItem> create(String name) {
        return create(name, new Properties());
    }

    public static final RegistryObject<FishingRodItem> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), creativeTab);
    }

    public static final RegistryObject<FishingRodItem> create(String name, Properties properties) {
        var fas = ItemRegistry.register(name, () -> new FishingRodItem(properties));
        ModRegister.tools.put(name, fas);

        return fas;
    }

    public static final RegistryObject<FishingRodItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var fas = ItemRegistry.register(name, () -> new FishingRodItem(properties), creativeTab);
        ModRegister.tools.put(name, fas);

        return fas;
    }
}
