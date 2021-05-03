package com.github.chrisofnormandy.conlib.biome;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class ModClimate {
    public String name;
    public BiomeType type;

    private List<RegistryKey<Biome>> biomes = new ArrayList<RegistryKey<Biome>>();

    public ModClimate(String name, BiomeType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public List<RegistryKey<Biome>> getBiomes() {
        return this.biomes;
    }

    public Boolean hasBiome(RegistryKey<Biome> biome) {
        return this.biomes.contains(biome);
    }

    public void addBiome(Biome biome) {
        this.biomes.add(Biomes.Helpers.createKey(biome));
    }
}
