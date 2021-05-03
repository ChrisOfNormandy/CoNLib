package com.github.chrisofnormandy.conlib.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.Biome.TemperatureModifier;

public class ModBiome extends BiomeBase {
    public ModBiome(ModClimate climate, Integer weight, Terrain terrain) {
        super(terrain);
        this.addClimate(climate, weight);
    }

    public void setRainType(Biome.RainType rainType) {
        this.rainType = rainType;
    }

    public void setCategory(Biome.Category category) {
        this.category = category;
    }

    public ModBiome configure(Float depth, Float scale, Float temperature, Float downfall) {
        this.depth = depth;
        this.scale = scale;
        this.temperature = temperature;
        this.downfall = downfall;
        return this;
    }

    public ModBiome configureClient(Integer waterColor, Integer waterFogColor, Integer fogColor, Integer skyColor) {
        this.waterColor = waterColor;
        this.waterFogColor = waterFogColor;
        this.fogColor = fogColor;
        this.skyColor = skyColor;
        return this;
    }

    public void isFrozen() {
        this.temperatureModifier = TemperatureModifier.FROZEN;
    }

    public void setAmbience(MoodSoundAmbience ambience) {
        this.ambience = ambience;
    }
}
