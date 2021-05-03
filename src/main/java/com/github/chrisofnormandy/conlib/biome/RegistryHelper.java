package com.github.chrisofnormandy.conlib.biome;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class RegistryHelper {
    String name;
    Terrain terrain;

    SurfaceBuilderConfig primarySurface;
    SurfaceBuilderConfig secondarySurface;

    ModClimate climate;
    Integer weight;

    ModBiome biome;

    public RegistryHelper(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

    public SurfaceBuilderConfig getPrimary() {
        return this.primarySurface;
    }

    public SurfaceBuilderConfig getSecondary() {
        return this.secondarySurface;
    }

    public ModClimate getClimate() {
        return this.climate;
    }

    public ModBiome getBiome() {
        return this.biome;
    }

    public SurfaceBuilderConfig surfaceBuilder(String name, Block surface, Block underground, Block underwater) {
        return ModRegister.registerSurfaceBuilderConfig(name, new SurfaceBuilderConfig(surface.defaultBlockState(), underground.defaultBlockState(), underwater.defaultBlockState()));
    }

    public void setPrimarySurface(SurfaceBuilderConfig config) {
        this.primarySurface = config;
    }

    public void setSecondarySurface(SurfaceBuilderConfig config) {
        this.secondarySurface = config;
    }

    public Terrain terrainBuilder(String name, SurfaceBuilderConfig primary, SurfaceBuilderConfig secondary, Double limit) {
        this.terrain = new Terrain(name, primary, secondary, limit);
        return this.terrain;
    }

    public Terrain terrainBuilder(String name, Double limit) {
        this.terrain = new Terrain(name, this.primarySurface, this.secondarySurface, limit);
        return this.terrain;
    }

    public ModClimate climateBuilder(String name, BiomeType type, Integer weight) {
        this.weight = weight;
        this.climate = new ModClimate(name, type);
        return ModRegister.registerClimate(name, this.climate);
    }

    public ModBiome biomeBuilder(Float depth, Float scale, Float temperature, Float downfall) {
        this.biome = new ModBiome(this.climate, this.weight, this.terrain);
        this.biome.configure(depth, scale, temperature, downfall);
        return this.biome;
    }

    public ModBiome configureClient(Integer waterColor, Integer waterFogColor, Integer fogColor, Integer skyColor) {
        this.biome.configureClient(waterColor, waterFogColor, fogColor, skyColor);
        return this.biome;
    }

    public void isFrozen() {
        this.biome.isFrozen();
    }

    public void setRainType(RainType rainType) {
        this.biome.setRainType(rainType);
    }

    public void setAmbience(MoodSoundAmbience ambience) {
        this.biome.setAmbience(ambience);
    }

    public void addVegetation(ConfiguredFeature<?, ?> feature) {
        this.biome.addVegetation(feature);
    }

    public void addSturcture(ConfiguredFeature<?, ?> feature) {
        this.biome.addStructure(feature);
    }

    public void addMobSpawn(EntityType<?> mob, Integer weight, Integer min, Integer max) {
        this.biome.addSpawnableMob(mob, weight, min, max);
    }

    public ModBiome register() {
        ModRegister.registerBiome(this.name, this.biome, this.biome.category, this.biome.rainType);
        return this.biome;
    }

    public Integer floatToInt(float f) {
        Float x = MathHelper.clamp(f / 3.0F, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - x * 0.05F, 0.5F + x * 0.1F, 1.0F);
    }
}
