package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.CraftingTool;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.item.AxeItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item.Properties;

public class ToolRegistry {

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
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerCrafting(String name, Properties properties, ItemGroup group) {
        CraftingTool item = new CraftingTool(properties.tab(group));
        ModRegister.tools.put(name, item);
        return ItemRegistry.register(name, item);
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
    public static final Item registerPickaxe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new PickaxeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick);
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
    public static final Item registerShovel(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new ShovelItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick);
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
    public static final Item registerAxe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new AxeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick);
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
    public static final Item registerHoe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new HoeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick);
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
    public static final Item[] registerAll(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        return new Item[] { registerPickaxe(name, tier, attackDamage, attackSpeed, properties, group),
                registerAxe(name, tier, attackDamage, attackSpeed, properties, group),
                registerShovel(name, tier, attackDamage, attackSpeed, properties, group),
                registerHoe(name, tier, attackDamage, attackSpeed, properties, group) };
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerFlintAndSteel(String name, Properties properties, ItemGroup group) {
        Item fas = new FlintAndSteelItem(properties.tab(group));
        ModRegister.tools.put(name, fas);
        return ItemRegistry.register(name, fas);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerFishingRod(String name, Properties properties, ItemGroup group) {
        Item rod = new FishingRodItem(properties.tab(group));
        ModRegister.tools.put(name, rod);
        return ItemRegistry.register(name, rod);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerShearsItem(String name, Properties properties, ItemGroup group) {
        Item shears = new ShearsItem(properties.tab(group));
        ModRegister.tools.put(name, shears);
        return ItemRegistry.register(name, shears);
    }
}
