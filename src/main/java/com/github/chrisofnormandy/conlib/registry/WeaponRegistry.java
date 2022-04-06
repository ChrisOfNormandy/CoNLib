package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;

public class WeaponRegistry {

    /**
     * 
     * @param name
     * @param level
     * @param maxDamage
     * @param immuneToFire
     * @param rarity
     * @param noRepair
     * @param resource_type
     * @return
     */
    public static final ToolMaterial registerMaterial(String name, Integer level, Integer maxDamage,
            Boolean immuneToFire, Rarity rarity, Boolean noRepair, ToolMaterial.type resource_type) {
        ToolMaterial material = new ToolMaterial(level, maxDamage, immuneToFire, rarity, noRepair, resource_type);
        ModRegister.toolMaterials.put(name, material);
        return material;
    }

    /**
     * 
     * @param name
     * @param tier
     * @param attackDamage
     * @param attackSpeed
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerSword(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new SwordItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerShield(String name, Properties properties, ItemGroup group) {
        Item shield = new ShieldItem(properties.tab(group));
        ModRegister.weapons.put(name, shield);
        return ItemRegistry.register(name, shield);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerBow(String name, Properties properties, ItemGroup group) {
        Item bow = new BowItem(properties.tab(group));
        ModRegister.weapons.put(name, bow);
        return ItemRegistry.register(name, bow);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerCrossbow(String name, Properties properties, ItemGroup group) {
        Item crossbow = new CrossbowItem(properties.tab(group));
        ModRegister.weapons.put(name, crossbow);
        return ItemRegistry.register(name, crossbow);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerArrow(String name, Properties properties, ItemGroup group) {
        Item arrow = new ArrowItem(properties.tab(group));
        ModRegister.weapons.put(name, arrow);
        return ItemRegistry.register(name, arrow);
    }
}
