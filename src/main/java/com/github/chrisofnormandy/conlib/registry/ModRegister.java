package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.stream.Stream;

import com.github.chrisofnormandy.conlib.Main;
import com.github.chrisofnormandy.conlib.biome.ModBiome;
import com.github.chrisofnormandy.conlib.biome.ModClimate;
import com.github.chrisofnormandy.conlib.biome.helpers.BiomeBuilder;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.collections.JsonBuilder.JsonObject;
import com.github.chrisofnormandy.conlib.event.BlockBreak;
import com.github.chrisofnormandy.conlib.tool.ToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModRegister {
    private static String mod_id;

    public static String getModId() {
        return mod_id;
    }

    public static void Init() {
        mod_id = Main.MOD_ID;
        
        events.put("block_break", BlockBreak.class);

        events.forEach((String key, Object event) -> Events.register(event));
    }

    public static void Init(String modId) {
        mod_id = modId;
        
        events.put("block_break", BlockBreak.class);

        events.forEach((String key, Object event) -> Events.register(event));
    }

    // EVENTS
    public static HashMap<String, Object> events = new HashMap<String, Object>();

    // ITEM GROUPS
    public static HashMap<String, ItemGroup> groups = new HashMap<String, ItemGroup>();

    // MATERIALS
    public static HashMap<String, Material> materials = new HashMap<String, Material>();
    public static HashMap<String, ToolMaterial> toolMaterials = new HashMap<String, ToolMaterial>();

    // BLOCKS
    public static HashMap<String, Block> blocks = new HashMap<String, Block>();

    // ITEMS
    public static HashMap<String, Item> items = new HashMap<String, Item>();

    // TOOLS
    public static HashMap<String, Item> tools = new HashMap<String, Item>();

    // FOODS
    public static HashMap<String, Item> foods = new HashMap<String, Item>();

    // WORLD GEN
    public static HashMap<String, Biome> biomes = new HashMap<String, Biome>();

    public static HashMap<RegistryKey<Biome>, BiomeBuilder> biomeBuilders = new HashMap<RegistryKey<Biome>, BiomeBuilder>();
    public static HashMap<String, RegistryKey<Biome>> overworldKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> netherKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> endKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<String, RegistryKey<Biome>> customKeys = new HashMap<String, RegistryKey<Biome>>();
    public static HashMap<RegistryKey<Biome>, RegistryKey<Biome>> biomeRemaps = new HashMap<>();

    public static HashMap<String, ModBiome> modBiomes = new HashMap<String, ModBiome>();

    public static HashMap<String, ModClimate> climates = new HashMap<String, ModClimate>();

    public static HashMap<String, Feature<?>> generators = new HashMap<String, Feature<?>>();

    public static HashMap<String, SurfaceBuilder<?>> surfaceBuilders = new HashMap<String, SurfaceBuilder<?>>();
    public static HashMap<String, SurfaceBuilderConfig> surfaceBuilderConfigs = new HashMap<String, SurfaceBuilderConfig>();
    public static HashMap<String, ConfiguredSurfaceBuilder<?>> configSurfaceBuilders = new HashMap<String, ConfiguredSurfaceBuilder<?>>();

    public static HashMap<String, JsonObject> worldgen_biome = new HashMap<String, JsonObject>();

    /**
     * 
     * @return Stream of Biome RegistryKeys.
     */
    public static Stream<RegistryKey<Biome>> getOverworldBiomes() {
        return overworldKeys.values().stream();
    }

    /**
     * 
     * @return Stream of Biome RegistryKeys.
     */
    public static Stream<RegistryKey<Biome>> getNetherBiomes() {
        return netherKeys.values().stream();
    }

    /**
     * 
     * @return Stream of Biome RegistryKeys.
     */
    public static Stream<RegistryKey<Biome>> getEndBiomes() {
        return endKeys.values().stream();
    }

    // SPECIAL
    public static HashMap<String, Block> blocks_unbreakable = new HashMap<String, Block>();
    public static HashMap<String, Tuple<Block, Block>> blocks_replaceable = new HashMap<String, Tuple<Block, Block>>();

    /**
     * 
     * @param <T> Any class that extends the Minecraft Block class.
     * @param block The block instance.
     * @return
     */
    public static <T extends Block> T setBlock_unbreakable(T block) {
        blocks_unbreakable.put(block.getRegistryName().toString(), block);
        return block;
    }

    /**
     * 
     * @param <T> Any class that extends the Minecraft Block class.
     * @param blockIn The block being broken.
     * @param blockOut The block that replaces the broken block.
     * @return
     */
    public static <T extends Block> T setBlock_replaceable(T blockIn, T blockOut) {
        blocks_replaceable.put(blockIn.getRegistryName().toString(), new Tuple<Block, Block>(blockIn, blockOut));
        return blockOut;
    }
}