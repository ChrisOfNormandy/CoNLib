package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.stream.Stream;

import com.github.chrisofnormandy.conlib.biome.Biomes;
import com.github.chrisofnormandy.conlib.biome.ModBiome;
import com.github.chrisofnormandy.conlib.biome.ModClimate;
import com.github.chrisofnormandy.conlib.biome.Terrain;
import com.github.chrisofnormandy.conlib.block.types.NodeBase;
import com.github.chrisofnormandy.conlib.block.types.OreBase;
import com.github.chrisofnormandy.conlib.event.BlockBreak;
import com.github.chrisofnormandy.conlib.itemgroup.Groups;
import com.github.chrisofnormandy.conlib.tool.CraftingTool;
import com.github.chrisofnormandy.conlib.tool.ToolBase;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.BiomeDictionary.Type;
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

    public static Block registerOre(String name, OreBase oreBase, ItemGroup group) {
        Block block = registerBlock(name, oreBase, group);
        return block;
    }

    // PLANTS
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
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().tab(group));
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
        Item item = new Item(properties.tab(group)).setRegistryName(name);
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
        CraftingTool item = new CraftingTool(properties.tab(group));
        tools.put(name, item);
        return registerItem(name, item);
    }

    public static Item registerTool(String name, ToolMaterial toolMaterial, ToolType toolType, int level, ItemGroup group) {
        ToolBase item = new ToolBase(toolMaterial.getProperties().tab(group), toolType, level);
        tools.put(name, item);
        return registerItem(name, item);
    }

    public static void registerTools(String name, ToolMaterial material, ItemGroup group) {
        registerTool(name + "_shovel", material, ToolType.SHOVEL, material.level(), group);
        registerTool(name + "_pickaxe", material, ToolType.PICKAXE, material.level(), group);
        registerTool(name + "_axe", material, ToolType.AXE, material.level(), group);
        registerTool(name + "_hoe", material, ToolType.HOE, material.level(), group);
        // Sword?
    }

    // FOODS
    public static Food registerFoodNoItem(int hunger, float saturation) {
        return (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
    }

    public static Item registerFood(String name, int hunger, float saturation, ItemGroup group) {
        Food food = (new Food.Builder()).saturationMod(saturation).nutrition(hunger).build();
        return registerItem(name, new Item.Properties().food(food), group);
    }

    public static Item registerFood(String name, Food food, ItemGroup group) {
        return registerItem(name, new Item.Properties().food(food), group);
    }

    // WORLD GEN
    public static HashMap<String, Biome> biomes = new HashMap<String, Biome>();

    public static HashMap<String, RegistryKey<Biome>> overworldKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> netherKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> endKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> customKeys = new HashMap<String, RegistryKey<Biome>>();

    public static HashMap<String, ModBiome> modBiomes = new HashMap<String, ModBiome>();

    public static HashMap<String, ModClimate> climates = new HashMap<String, ModClimate>();

    public static HashMap<String, Feature<?>> generators = new HashMap<String, Feature<?>>();

    public static HashMap<String, SurfaceBuilder<?>> surfaceBuilders = new HashMap<String, SurfaceBuilder<?>>();
    public static HashMap<String, SurfaceBuilderConfig> surfaceBuilderConfigs = new HashMap<String, SurfaceBuilderConfig>();
    public static HashMap<String, ConfiguredSurfaceBuilder<?>> configSurfaceBuilders = new HashMap<String, ConfiguredSurfaceBuilder<?>>();

    public static Feature<NoFeatureConfig> registerPlantGen(String name, Feature<NoFeatureConfig> feature) {
        return registerGenFeature(name, feature);
    }

    public static Feature<NoFeatureConfig> registerGenFeature(String name, Feature<NoFeatureConfig> entry) {
        entry.setRegistryName(new ResourceLocation(mod_id, name));
        ForgeRegistries.FEATURES.register(entry);
        generators.put(name, entry);
        return entry;
    }

    public static SurfaceBuilderConfig registerSurfaceBuilderConfig(String name, SurfaceBuilderConfig config) {
        surfaceBuilderConfigs.put(name, config);
        return config;
    }

    public static <A extends ISurfaceBuilderConfig, B extends ConfiguredSurfaceBuilder<A>> B registerConfiguredSurfaceBuilder(String name, B builder) {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(mod_id, name), builder);
        configSurfaceBuilders.put(name, builder);
        return builder;
    }

    public static <A extends ISurfaceBuilderConfig, B extends SurfaceBuilder<A>> B registerSurfaceBuilder(String name, B builder) {
        builder.setRegistryName(new ResourceLocation(mod_id, name));
        ForgeRegistries.SURFACE_BUILDERS.register(builder);
        surfaceBuilders.put(name, builder);
        return builder;
    }

    public static Biome registerOverworldBiome(String name, Biome biome, Type...types) {
        biome.setRegistryName(new ResourceLocation(mod_id, name));
        biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        overworldKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    public static Biome registerNetherBiome(String name, Biome biome, Type...types) {
        biome.setRegistryName(new ResourceLocation(mod_id, name));
        biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        netherKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    public static Biome registerEndBiome(String name, Biome biome, Type...types) {
        biome.setRegistryName(new ResourceLocation(mod_id, name));
        biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        endKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    public static Stream<RegistryKey<Biome>> getOverworldBiomes() {
        return overworldKeys.values().stream();
    }

    public static Stream<RegistryKey<Biome>> getNetherBiomes() {
        return netherKeys.values().stream();
    }

    public static Stream<RegistryKey<Biome>> getEndBiomes() {
        return endKeys.values().stream();
    }

    public static ModBiome registerBiome(String name, Category category, RainType rainType, ModClimate climate, Integer weight, Terrain terrain, Float depth, Float scale, Float temperature, Float downfall) {
        ModBiome biome = new ModBiome(climate, weight, terrain);
        biome.configure(depth, scale, temperature, downfall);
        Biomes.register(name, biome, category, rainType);
        modBiomes.put(name, biome);
        return biome;
    }

    public static void registerBiome(String name, ModBiome biome, Category category, RainType rainType) {
        Biomes.register(name, biome, category, rainType);
    }

    public static void registerBiomes() {
        Biomes.registerAll();
    }

    public static ModClimate registerClimate(String name, ModClimate climate) {
        climates.put(name, climate);
        return climate;
    }

    // EVENTS
    public static PaintingType registerPainting(String name, PaintingType painting) {
        painting.setRegistryName(new ResourceLocation(mod_id, name));
        ForgeRegistries.PAINTING_TYPES.register(painting);
        return painting;
    }
    

    // SPECIAL
    public static HashMap<String, Block> blocks_unbreakable = new HashMap<String, Block>();
    public static HashMap<String, Block> blocks_replaceable = new HashMap<String, Block>();
    public static HashMap<String, NodeBase> nodes = new HashMap<String, NodeBase>();

    public static <T extends Block> T setBlock_unbreakable(T block) {
        blocks_unbreakable.put(block.getRegistryName().toString(), block);
        return block;
    }

    public static <T extends Block> T setBlock_replaceable(T blockIn, T blockOut) {
        blocks_replaceable.put(blockIn.getRegistryName().toString(), blockOut);
        return blockOut;
    }

    public static NodeBase registerNode(String name, NodeBase node) {
        LOG.info("Registered node: " + name + " -> " + node.getRegistryName().toString());
        nodes.put(name, node);
        return node;
    }

    // MISC

}