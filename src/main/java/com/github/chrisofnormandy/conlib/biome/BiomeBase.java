package com.github.chrisofnormandy.conlib.biome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.chrisofnormandy.conlib.collections.Quartet;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.Biome.TemperatureModifier;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.entity.EntityType;

public class BiomeBase {
    RegistryKey<Biome> biome;

    RegistryKey<Biome> beach = Biomes.BEACH;
    RegistryKey<Biome> river = Biomes.RIVER;

    HashMap<ModClimate, Integer> climates = new HashMap<ModClimate, Integer>();

    Biome.RainType rainType = Biome.RainType.RAIN;
    Biome.Category category = Biome.Category.NONE;

    Float depth;
    Float scale;
    Float temperature;
    Float downfall;

    TemperatureModifier temperatureModifier = TemperatureModifier.NONE;
    MoodSoundAmbience ambience = MoodSoundAmbience.LEGACY_CAVE_SETTINGS;

    Integer waterColor;
    Integer waterFogColor;
    Integer fogColor;
    Integer skyColor;

    Terrain terrain;

    public BiomeBase(Terrain terrain) {
        this.terrain = terrain;
    }

    public RegistryKey<Biome> getKey() {
        return this.biome;
    }

    public HashMap<ModClimate, Integer> getClimates() {
        return this.climates;
    }

    public void addClimate(ModClimate climate, Integer weight) {
        this.climates.put(climate, weight);
    }

    public Integer getClimateWeight(ModClimate climate) {
        return this.climates.get(climate);
    }

    List<Quartet<EntityType<?>, Integer, Integer, Integer>> spawnable = new ArrayList<Quartet<EntityType<?>, Integer, Integer, Integer>>();

    public void addSpawnableMob(EntityType<?> mob, Integer weight, Integer min, Integer max) {
        Quartet<EntityType<?>, Integer, Integer, Integer> mobItem = new Quartet<EntityType<?>, Integer, Integer, Integer>(mob, weight, min, max);
        spawnable.add(mobItem);
    }

    List<ConfiguredFeature<?, ?>> vegetation = new ArrayList<ConfiguredFeature<?, ?>>();

    public void addVegetation(ConfiguredFeature<?, ?> feature) {
        vegetation.add(feature);
    }

    List<ConfiguredFeature<?, ?>> undergroundResources = new ArrayList<ConfiguredFeature<?, ?>>();

    public void addResource(ConfiguredFeature<?, ?> feature) {
        undergroundResources.add(feature);
    }

    List<ConfiguredFeature<?, ?>> structures = new ArrayList<ConfiguredFeature<?, ?>>();

    public void addStructure(ConfiguredFeature<?, ?> feature) {
        structures.add(feature);
    }

    private Biome.Builder biomeSetup(Biome.Builder builder) {
        builder.precipitation(this.rainType).biomeCategory(this.category).depth(this.depth).scale(this.scale).temperature(this.temperature).downfall(this.downfall).temperatureAdjustment(this.temperatureModifier);
        builder.specialEffects(new BiomeAmbience.Builder().waterColor(this.waterColor).waterFogColor(this.waterFogColor).fogColor(this.fogColor).skyColor(this.skyColor).ambientMoodSound(this.ambience).build());
        return builder;
    }

    private BiomeGenerationSettings.Builder genSetup(BiomeGenerationSettings.Builder builder) {

        builder.surfaceBuilder(this.terrain.builder);

        DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);

        undergroundResources.forEach((ConfiguredFeature<?, ?> feature) -> {
            builder.addFeature(Decoration.UNDERGROUND_ORES, feature);
        });

        vegetation.forEach((ConfiguredFeature<?, ?> feature) -> {
            builder.addFeature(Decoration.VEGETAL_DECORATION, feature);
        });

        structures.forEach((ConfiguredFeature<?, ?> feature) -> {
            builder.addFeature(Decoration.SURFACE_STRUCTURES, feature);
        });
        
        return builder;
    }

    private MobSpawnInfo.Builder spawnSetup(MobSpawnInfo.Builder builder) {
        spawnable.forEach((Quartet<EntityType<?>, Integer, Integer, Integer> mob) -> {
            builder.addSpawn(mob.w.getCategory(), new MobSpawnInfo.Spawners(mob.w, mob.x, mob.y, mob.z));
        });

        builder.setPlayerCanSpawn();

        return builder;
    }

    public Biome Build() {
        Biome.Builder builder = new Biome.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder();
        MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();

        builder.generationSettings(genSetup(genBuilder).build());
        builder.mobSpawnSettings(spawnSetup(spawnBuilder).build());

        return biomeSetup(builder).build();
    }

    public void setBeach(RegistryKey<Biome> beach) {
        this.beach = beach;
    }

    public void setRiver(RegistryKey<Biome> river) {
        this.river = river;
    }

    public void setBiome(RegistryKey<Biome> biome) {
        this.biome = biome;
    }
}