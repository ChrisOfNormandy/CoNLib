package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.github.chrisofnormandy.conlib.block.Node;
import com.github.chrisofnormandy.conlib.block.OreBase;
import com.github.chrisofnormandy.conlib.event.BlockBreak;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.tool.CraftingTool;
import com.github.chrisofnormandy.conlib.tool.Tool;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModRegister {
    private static String mod_id;

    public ModRegister() {
    }

    public static void Init(String modId) {
        mod_id = modId;
        MinecraftForge.EVENT_BUS.register(BlockBreak.class);
    }

    public static final Logger LOG = LogManager.getLogger();

    // ITEM GROUPS
    public static HashMap<String, ItemGroup> groups = new HashMap<String, ItemGroup>();

    public static Groups itemGroup(String name, String icon_itemName) {
        Groups group = Groups.createGroup(name, icon_itemName);
        groups.put(name, group);
        return group;
    }

    public static Groups itemGroup(String name, Block block) {
        Groups group = Groups.createGroup(name, block);
        groups.put(name, group);
        return group;
    }

    public static Groups itemGroup(String name, Item item) {
        Groups group = Groups.createGroup(name, item);
        groups.put(name, group);
        return group;
    }

    // BLOCK TYPES
    public static Block registerCrop(CropsBlock crop, String name) {
        return registerBlock(name, crop);
    }


    // RESOURCES
    public static HashMap<String, Material> materials = new HashMap<String, Material>();
    public static HashMap<String, ToolMaterial> toolMaterials = new HashMap<String, ToolMaterial>();

    public static Material registerMaterial(String name, MaterialColor color, boolean isLiquid, boolean isSolid, boolean blocksMovement, boolean isOpaque, boolean flammable, boolean replaceable, PushReaction pushReaction) {
        Material material = new Material(color, isLiquid, isSolid, blocksMovement, isOpaque, flammable, replaceable, pushReaction);
        materials.put(name, material);
        return material;
    }

    public static ToolMaterial registerToolMaterial(String name, int level, int maxDamage, boolean immuneToFire, Rarity rarity, boolean noRepair, ToolMaterial.type resource_type) {
        ToolMaterial material = new ToolMaterial(level, maxDamage, immuneToFire, rarity, noRepair, resource_type);
        toolMaterials.put(name, material);
        return material;
    }

    /**
     * 
     * @param name
     * @param oreBase
     * @param group
     * @return
     */
    public static Block registerOre(String name, OreBase oreBase, ItemGroup group) {
        Block block = registerBlock(name, oreBase, group);
        return block;
    }

    /**
     * 
     * @param name Only supply the pure resource name
     * @param toolMaterial Use registerToolMaterial
     * @param oreBase Use registerOre
     * @param isFuel
     * @param generateTools
     */
    public static void registerResource(String name, ToolMaterial toolMaterial, @Nullable OreBase oreBase, ItemGroup group, boolean generateTools) {
        if (generateTools) {
            registerTool(name + "_shovel", toolMaterial, ToolType.SHOVEL, toolMaterial.level(), group);
            registerTool(name + "_pickaxe", toolMaterial, ToolType.PICKAXE, toolMaterial.level(), group);
            registerTool(name + "_axe", toolMaterial, ToolType.AXE, toolMaterial.level(), group);
            registerTool(name + "_hoe", toolMaterial, ToolType.HOE, toolMaterial.level(), group);
        }
    }

    // public static Block registerPlant(String name, PlantType plantType, ItemGroup group) {
    //     Block.Properties properties = Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.0F).doesNotBlockMovement();
    //     return registerBlock(new PlantBase(properties, name, plantType), name, group);
    // }


    // BLOCKS
    public static HashMap<String, Block> blocks = new HashMap<String, Block>();

    /**
     * Registers new Block and new ItemBlock.
     * @param block
     * @param name
     * @param group
     * @return
     */
    public static Block registerBlock(String name, Block block, ItemGroup group)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(group));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        blocks.put(name, block);
        LOG.info("Registered new block: " + block.getRegistryName());
        return block;
    }

    /**
     * Registers new Block without an ItemBlock.
     * @param block
     * @param name
     * @return
     */
    public static Block registerBlock(String name, Block block)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties());
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        blocks.put(name, block);
        LOG.info("Registered new block without group: " + block.getRegistryName());
        return block;
    }

    // ITEMS
    public static HashMap<String, Item> items = new HashMap<String, Item>();

    public static Item registerItem(String name, Properties properties, ItemGroup group) {
        Item item = new Item(properties.group(group)).setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        items.put(name, item);
        return item;
    }

    public static Item registerItem(String name, Properties properties) {
        Item item = new Item(properties).setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        items.put(name, item);
        return item;
    }

    public static <T extends Item> T registerItem(String name, T item) {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        items.put(name, item);
        return item;
    }

    // TOOLS
    public static HashMap<String, Item> tools = new HashMap<String, Item>();

    public static Item registerCraftingTool(String name, Properties properties, ItemGroup group) {
        CraftingTool item = new CraftingTool(properties.group(group));
        tools.put(name, item);
        return registerItem(name, item);
    }

    public static Item registerTool(String name, ToolMaterial toolMaterial, ToolType toolType, int level, ItemGroup group) {
        Tool item = new Tool(toolMaterial.getProperties().group(group), toolType, level);
        tools.put(name, item);
        return registerItem(name, item);
    }

    // FOODS
    public static Food registerFoodNoItem(int hunger, float saturation) {
        return (new Food.Builder()).saturation(saturation).hunger(hunger).build();
    }

    public static Item registerFood(String name, int hunger, float saturation, ItemGroup group) {
        Food food = (new Food.Builder()).saturation(saturation).hunger(hunger).build();
        return registerItem(name, new Item.Properties().food(food), group);
    }

    public static Item registerFood(String name, Food food, ItemGroup group) {
        return registerItem(name, new Item.Properties().food(food), group);
    }

    // WORLD GEN
    public static HashMap<String, Feature<?>> generators = new HashMap<String, Feature<?>>();

    public static Feature<NoFeatureConfig> registerPlantGen(String name, String mod_id, Feature<NoFeatureConfig> feature) {
        return registerGenFeature(name, mod_id, feature);
    }

    public static Feature<NoFeatureConfig> registerGenFeature(String name, String mod_id, Feature<NoFeatureConfig> entry) {
        entry.setRegistryName(new ResourceLocation(mod_id, name));
        ForgeRegistries.FEATURES.register(entry);
        generators.put(name, entry);
        return entry;
    }

    // EVENTS

    

    // SPECIAL
    public static HashMap<String, Block> blocks_unbreakable = new HashMap<String, Block>();
    public static HashMap<String, Block> blocks_replaceable = new HashMap<String, Block>();
    public static HashMap<String, Node> nodes = new HashMap<String, Node>();

    public static <T extends Block> T setBlock_unbreakable(T block) {
        blocks_unbreakable.put(block.getRegistryName().toString(), block);
        return block;
    }

    public static <T extends Block> T setBlock_replaceable(T blockIn, T blockOut) {
        blocks_replaceable.put(blockIn.getRegistryName().toString(), blockOut);
        return blockOut;
    }

    public static Node registerNode(String name, Node node) {
        LOG.info("Registered node: " + name + " -> " + node.getRegistryName().toString());
        nodes.put(name, node);
        return node;
    }
}