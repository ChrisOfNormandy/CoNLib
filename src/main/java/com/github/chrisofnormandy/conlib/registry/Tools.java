package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.CraftingTool;
// import com.github.chrisofnormandy.conlib.tool.ToolBase;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item.Properties;
// import net.minecraftforge.common.ToolType;

public class Tools {

    /**
     * 
     * @param name          The generic material name, such as "my_material."
     * @param level         The level of the tool material.
     * @param maxDamage     What is the max tool durability?
     * @param immuneToFire  Does this tool burn when you "Cast it into the fire!" ?
     * @param rarity        The item rarity of this material - common, uncommon,
     *                      rare or epic?
     * @param noRepair      Is this tool material repairable?
     * @param resource_type Is this material based on a gem, ingot or other
     *                      resource? Used by this library, NOT Minecraft.
     * @return
     */
    public static ToolMaterial registerMaterial(String name, Integer level, Integer maxDamage, Boolean immuneToFire,
            Rarity rarity, Boolean noRepair, ToolMaterial.type resource_type) {
        ToolMaterial material = new ToolMaterial(level, maxDamage, immuneToFire, rarity, noRepair, resource_type);
        ModRegister.toolMaterials.put(name, material);
        return material;
    }

    /**
     * 
     * @param name       The generic item name, like "my_item."
     * @param properties A set of properties defining the item.
     * @param group      The creative tab the item should be grouped in.
     * @return Item
     */
    public static Item registerCrafting(String name, Properties properties, ItemGroup group) {
        CraftingTool item = new CraftingTool(properties.tab(group));
        ModRegister.tools.put(name, item);
        return Items.register(name, item);
    }

    // /**
    //  * 
    //  * @param name         The generic item name, like "my_pickaxe."
    //  * @param toolMaterial The tool material the item is defined to use.
    //  * @param toolType     The type of tool - pickaxe, shovel, axe, hoe.
    //  * @param level        The level of the tool.
    //  * @param group        The creative tab the item should be grouped in.
    //  * @return Item
    //  */
    // public static Item register(String name, ToolMaterial toolMaterial, ToolType toolType, Integer level,
    //         ItemGroup group) {
    //     ToolBase item = new ToolBase(toolMaterial.getProperties().tab(group), toolType, level);
    //     ModRegister.tools.put(name, item);
    //     return Items.register(name, item);
    // }

    public static Item registerPickaxe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed, Properties properties, ItemGroup group) {
        Item pick = new PickaxeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return Items.register(name, pick);
    }

    public static Item registerShovel(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new ShovelItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return Items.register(name, pick);
    }

    public static Item registerAxe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new AxeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return Items.register(name, pick);
    }

    public static Item registerHoe(String name, ItemTier tier, Integer attackDamage, Float attackSpeed,
            Properties properties, ItemGroup group) {
        Item pick = new HoeItem(tier, attackDamage, attackSpeed, properties.tab(group));
        ModRegister.tools.put(name, pick);
        return Items.register(name, pick);
    }

    public static Item[] registerAll(String name, ItemTier tier, Integer attackDamage, Float attackSpeed, Properties properties, ItemGroup group) {
        return new Item[]{
            registerPickaxe(name, tier, attackDamage, attackSpeed, properties, group),
            registerAxe(name, tier, attackDamage, attackSpeed, properties, group),
            registerShovel(name, tier, attackDamage, attackSpeed, properties, group),
            registerHoe(name, tier, attackDamage, attackSpeed, properties, group)
        };
    }
}
