package com.github.chrisofnormandy.conlib.biome;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class ModClimate {
    public String name;
    public BiomeType type;
    public Integer weight;

    public Integer temperature;
    public Integer rainfall;

    private final List<RegistryKey<Biome>> biomes = new ArrayList<RegistryKey<Biome>>();

    /**
     * 
     */
    private void setup() {
        switch (this.type) {
            case DESERT: {
                this.temperature = 8;
                this.rainfall = 0;
                break;
            }
            case DESERT_LEGACY: {
                this.temperature = 8;
                this.rainfall = 0;
                break;
            }
            case WARM: {
                this.temperature = 6;
                this.rainfall = 11;
                break;
            }
            case COOL: {
                this.temperature = 3;
                this.rainfall = 8;
                break;
            }
            case ICY: {
                this.temperature = 0;
                this.rainfall = 6;
                break;
            }
        }
    }

    /**
     * 
     * @param name
     * @param type
     */
    public ModClimate(String name, BiomeType type) {
        this.name = name;
        this.type = type;
        this.weight = 1;
        setup();
    }

    /**
     * 
     * @param name
     * @param type
     * @param weight
     */
    public ModClimate(String name, BiomeType type, Integer weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        setup();
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return
     */
    public Integer getWeight() {
        return this.weight;
    }

    /**
     * 
     * @return
     */
    public List<RegistryKey<Biome>> getBiomes() {
        return this.biomes;
    }

    /**
     * 
     * @param biome
     * @return
     */
    public Boolean hasBiome(RegistryKey<Biome> biome) {
        return this.biomes.contains(biome);
    }

    /**
     * 
     * @param value
     */
    public void setTemperature(Integer value) {
        this.temperature = value;
    }

    /**
     * 
     * @param value
     */
    public void setRainfall(Integer value) {
        this.rainfall = value;
    }
}
