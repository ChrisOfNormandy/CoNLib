package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;

public class Wearable {
    /**
     * 
     * @param name
     * @param item
     * @return
     */
    private static final ArmorItem _register(String name, ArmorItem item) {
        ModRegister.wearable.put(name, item);
        return Items.register(name, item);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerHead(String name, Properties properties, ItemGroup group) {
        return _register(name, new ArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.HEAD, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerChest(String name, Properties properties, ItemGroup group) {
        return _register(name, new ArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.CHEST, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerLegs(String name, Properties properties, ItemGroup group) {
        return _register(name, new ArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.LEGS, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerFeet(String name, Properties properties, ItemGroup group) {
        return _register(name, new ArmorItem(ArmorMaterial.CHAIN, EquipmentSlotType.FEET, properties.tab(group)));
    }
}
