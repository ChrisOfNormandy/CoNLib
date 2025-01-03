package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item.Properties;

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
    public static final Item registerSword(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item pick = new SwordItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerShield(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item shield = new ShieldItem(properties);
        ModRegister.weapons.put(name, shield);
        return ItemRegistry.register(name, shield, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerBow(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item bow = new BowItem(properties);
        ModRegister.weapons.put(name, bow);
        return ItemRegistry.register(name, bow, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerCrossbow(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item crossbow = new CrossbowItem(properties);
        ModRegister.weapons.put(name, crossbow);
        return ItemRegistry.register(name, crossbow, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerArrow(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item arrow = new ArrowItem(properties);
        ModRegister.weapons.put(name, arrow);
        return ItemRegistry.register(name, arrow, creativeTab);
    }
}
