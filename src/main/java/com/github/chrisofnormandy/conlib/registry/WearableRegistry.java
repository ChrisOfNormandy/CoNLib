package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.resources.ResourceKey;
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
    private static final ArmorItem _register(String name, ArmorItem item, ResourceKey<CreativeModeTab> creativeTab) {
        ModRegister.wearable.put(name, item);
        return ItemRegistry.register(name, item, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerHead(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.HELMET, properties), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerChest(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.CHESTPLATE, properties), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerLegs(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.LEGGINGS, properties), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final ArmorItem registerFeet(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return _register(name, new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.BOOTS, properties), creativeTab);
    }
}
