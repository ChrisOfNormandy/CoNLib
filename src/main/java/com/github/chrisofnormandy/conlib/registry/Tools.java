package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.tool.CraftingTool;
import com.github.chrisofnormandy.conlib.tool.ToolBase;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.common.ToolType;

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

    /**
     * 
     * @param name         The generic item name, like "my_pickaxe."
     * @param toolMaterial The tool material the item is defined to use.
     * @param toolType     The type of tool - pickaxe, shovel, axe, hoe.
     * @param level        The level of the tool.
     * @param group        The creative tab the item should be grouped in.
     * @return Item
     */
    public static Item register(String name, ToolMaterial toolMaterial, ToolType toolType, Integer level,
            ItemGroup group) {
        ToolBase item = new ToolBase(toolMaterial.getProperties().tab(group), toolType, level);
        ModRegister.tools.put(name, item);
        return Items.register(name, item);
    }

    /**
     * 
     * @param name     The generic base name, like "my_."
     * @param material The tool material the items are defined to use.
     * @param group    The creative tab the item should be grouped in.
     */
    public static void registerAll(String name, ToolMaterial material, ItemGroup group) {
        register(name + "_shovel", material, ToolType.SHOVEL, material.level(), group);
        register(name + "_pickaxe", material, ToolType.PICKAXE, material.level(), group);
        register(name + "_axe", material, ToolType.AXE, material.level(), group);
        register(name + "_hoe", material, ToolType.HOE, material.level(), group);
        // Sword?
    }
}
