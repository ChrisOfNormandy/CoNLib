package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.CraftingTool;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

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
    public static final Item registerCrafting(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        CraftingTool item = new CraftingTool(properties);
        ModRegister.tools.put(name, item);
        return ItemRegistry.register(name, item, creativeTab);
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
    public static final Item registerPickaxe(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item pick = new PickaxeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick, creativeTab);
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
    public static final Item registerShovel(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item pick = new ShovelItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick, creativeTab);
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
    public static final Item registerAxe(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item pick = new AxeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick, creativeTab);
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
    public static final Item registerHoe(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Item pick = new HoeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, pick);
        return ItemRegistry.register(name, pick, creativeTab);
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
    public static final Item[] registerAll(String name, Tier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return new Item[] { registerPickaxe(name, tier, attackDamage, attackSpeed, properties, creativeTab),
                registerAxe(name, tier, attackDamage, attackSpeed, properties, creativeTab),
                registerShovel(name, tier, attackDamage, attackSpeed, properties, creativeTab),
                registerHoe(name, tier, attackDamage, attackSpeed, properties, creativeTab) };
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerFlintAndSteel(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item fas = new FlintAndSteelItem(properties);
        ModRegister.tools.put(name, fas);
        return ItemRegistry.register(name, fas, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerFishingRod(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item rod = new FishingRodItem(properties);
        ModRegister.tools.put(name, rod);
        return ItemRegistry.register(name, rod, creativeTab);
    }

    public static final Item registerBucket(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return registerBucket(name, Fluids.EMPTY, properties, creativeTab);
    }

    public static final Item registerBucket(String name, Fluid fluid, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item bucket = new BucketItem(() -> fluid, properties);
        ModRegister.tools.put(name, bucket);
        return ItemRegistry.register(name, bucket, creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Item registerShearsItem(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item shears = new ShearsItem(properties);
        ModRegister.tools.put(name, shears);
        return ItemRegistry.register(name, shears, creativeTab);
    }
}
