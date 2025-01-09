package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ArmorItem.Type;

public class Wearables {

    public static final RegistryObject<ArmorItem> create(String name, Type armorType) {
        return create(name, new Properties(), armorType, ArmorMaterials.CHAIN);
    }

    public static final RegistryObject<ArmorItem> create(String name, Type armorType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), armorType, ArmorMaterials.CHAIN, creativeTab);
    }

    public static final RegistryObject<ArmorItem> create(String name, Type armorType, ArmorMaterial armorMaterial) {
        return create(name, new Properties(), armorType, armorMaterial);
    }

    public static final RegistryObject<ArmorItem> create(String name, Type armorType, ArmorMaterial armorMaterial,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), armorType, armorMaterial, creativeTab);
    }

    public static final RegistryObject<ArmorItem> create(String name, Properties properties, Type armorType) {
        return create(name, properties, armorType, ArmorMaterials.CHAIN);
    }

    public static final RegistryObject<ArmorItem> create(String name, Properties properties, Type armorType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, armorType, ArmorMaterials.CHAIN, creativeTab);
    }

    public static final RegistryObject<ArmorItem> create(String name, Properties properties, Type armorType,
            ArmorMaterial armorMaterial) {
        var item = ItemRegistry.register(name, () -> new ArmorItem(armorMaterial, armorType, properties));
        ModRegister.wearable.put(name, item);

        return item;
    }

    public static final RegistryObject<ArmorItem> create(String name, Properties properties, Type armorType,
            ArmorMaterial armorMaterial, ResourceKey<CreativeModeTab> creativeTab) {
        var item = ItemRegistry.register(name, () -> new ArmorItem(armorMaterial, armorType, properties), creativeTab);
        ModRegister.wearable.put(name, item);

        return item;
    }
}
