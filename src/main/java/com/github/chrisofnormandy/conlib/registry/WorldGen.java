package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.biome.Biomes;
import com.github.chrisofnormandy.conlib.biome.ModBiome;
import com.github.chrisofnormandy.conlib.biome.ModClimate;
import com.github.chrisofnormandy.conlib.biome.Terrain;

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
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGen {
    /**
     * 
     * @param name
     * @param feature
     * @return
     */
    public static Feature<NoFeatureConfig> registerPlantGen(String name, Feature<NoFeatureConfig> feature) {
        return registerGenFeature(name, feature);
    }

    /**
     * 
     * @param name
     * @param entry
     * @return
     */
    public static Feature<NoFeatureConfig> registerGenFeature(String name, Feature<NoFeatureConfig> entry) {
        entry.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ForgeRegistries.FEATURES.register(entry);
        ModRegister.generators.put(name, entry);
        return entry;
    }

    /**
     * 
     * @param name
     * @param config
     * @return
     */
    public static SurfaceBuilderConfig registerSurfaceBuilderConfig(String name, SurfaceBuilderConfig config) {
        ModRegister.surfaceBuilderConfigs.put(name, config);
        return config;
    }

    /**
     * 
     * @param <A>
     * @param <B>
     * @param name
     * @param builder
     * @return
     */
    public static <A extends ISurfaceBuilderConfig, B extends ConfiguredSurfaceBuilder<A>> B registerConfiguredSurfaceBuilder(
            String name, B builder) {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(ModRegister.getModId(), name), builder);
        ModRegister.configSurfaceBuilders.put(name, builder);
        return builder;
    }

    /**
     * 
     * @param <A>
     * @param <B>
     * @param name
     * @param builder
     * @return
     */
    public static <A extends ISurfaceBuilderConfig, B extends SurfaceBuilder<A>> B registerSurfaceBuilder(String name,
            B builder) {
        builder.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ForgeRegistries.SURFACE_BUILDERS.register(builder);
        ModRegister.surfaceBuilders.put(name, builder);
        return builder;
    }

    /**
     * 
     * @param name
     * @param biome
     * @param types
     * @return
     */
    public static Biome registerOverworldBiome(String name, Biome biome, Type... types) {
        biome.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ModRegister.biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        ModRegister.overworldKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    /**
     * 
     * @param name
     * @param biome
     * @param types
     * @return
     */
    public static Biome registerNetherBiome(String name, Biome biome, Type... types) {
        biome.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ModRegister.biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        ModRegister.netherKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    /**
     * 
     * @param name
     * @param biome
     * @param types
     * @return
     */
    public static Biome registerEndBiome(String name, Biome biome, Type... types) {
        biome.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ModRegister.biomes.put(name, biome);
        ForgeRegistries.BIOMES.register(biome);
        RegistryKey<Biome> key = Biomes.Helpers.createKey(biome);
        ModRegister.endKeys.put(name, key);
        BiomeDictionary.addTypes(key, types);
        return biome;
    }

    /**
     * 
     * @param name
     * @param category
     * @param rainType
     * @param climate
     * @param weight
     * @param terrain
     * @param depth
     * @param scale
     * @param temperature
     * @param downfall
     * @return
     */
    public static ModBiome registerBiome(String name, Category category, RainType rainType, ModClimate climate, Integer weight, Terrain terrain, Float depth, Float scale, Float temperature, Float downfall) {
        ModBiome biome = new ModBiome(climate, weight, terrain);
        biome.configure(depth, scale, temperature, downfall);
        Biomes.register(name, biome, category, rainType);
        ModRegister.modBiomes.put(name, biome);
        return biome;
    }

    /**
     * 
     * @param name
     * @param biome
     * @param category
     * @param rainType
     */
    public static void registerBiome(String name, ModBiome biome, Category category, RainType rainType) {
        Biomes.register(name, biome, category, rainType);
    }

    /**
     * 
     */
    public static void registerBiomes() {
        Biomes.registerAll();
    }

    /**
     * 
     * @param name
     * @param climate
     * @return
     */
    public static ModClimate registerClimate(String name, ModClimate climate) {
        ModRegister.climates.put(name, climate);
        return climate;
    }
}
