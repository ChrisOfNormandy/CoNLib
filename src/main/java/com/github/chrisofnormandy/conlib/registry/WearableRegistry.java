package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item.Properties;

public class WearableRegistry {
    /**
     * 
     * @param name
     * @param item
     * @return
     */
    private static final ArmorItem _register(String name, ArmorItem item) {
        ModRegister.wearable.put(name, item);
        return ItemRegistry.register(name, item);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerHead(String name, Properties properties, CreativeModeTab group) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, EquipmentSlot.HEAD, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerChest(String name, Properties properties, CreativeModeTab group) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, EquipmentSlot.CHEST, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerLegs(String name, Properties properties, CreativeModeTab group) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, EquipmentSlot.LEGS, properties.tab(group)));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerFeet(String name, Properties properties, CreativeModeTab group) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, EquipmentSlot.FEET, properties.tab(group)));
    }
}
