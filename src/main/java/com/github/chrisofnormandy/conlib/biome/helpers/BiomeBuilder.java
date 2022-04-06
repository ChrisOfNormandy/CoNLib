package com.github.chrisofnormandy.conlib.biome.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeBuilder extends Biome.Builder {
    private final Biome parentBiome;

    private RegistryKey<Biome> parentKey;
    private BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();
    private MobSpawnInfo.Builder spawnSettings = new MobSpawnInfo.Builder();

    private int weight = -1;
    private BiomeType type = null;
    private final List<BiomeDictionary.Type> dictionaryTypes = new ArrayList<BiomeDictionary.Type>();

    /**
     * 
     * @param key
     * @param biome
     */
    public BiomeBuilder(RegistryKey<Biome> key, Biome biome) {
        this.parentBiome = biome;
        this.parentKey = key;
        this.dictionaryTypes.addAll(BiomeDictionary.getTypes(parentKey));
    }

    /**
     * 
     * @param parentKey
     */
    public void setParentKey(RegistryKey<Biome> parentKey) {
        this.parentKey = parentKey;
    }

    /**
     * 
     * @return
     */
    public RegistryKey<Biome> getParentKey() {
        return parentKey;
    }

    /**
     * 
     * @param key
     */
    public void registerTypes(RegistryKey<Biome> key) {
        dictionaryTypes.forEach(type -> BiomeDictionary.addTypes(key, type));
        BiomeDictionary.addTypes(key, BiomeDictionary.Type.OVERWORLD);
    }

    /**
     * 
     * @param key
     */
    public void registerWeight(RegistryKey<Biome> key) {
        if (type == null)
            return;

        if (weight > 0)
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
        else if (BiomeDictionary.getTypes(key).contains(BiomeDictionary.Type.RARE))
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, 2));
        else if (BiomeDictionary.getTypes(key).contains(BiomeDictionary.Type.FOREST))
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, 5));
        else
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, 10));

    }

    /**
     * 
     * @param type
     */
    public void type(BiomeManager.BiomeType type) {
        this.type = type;
    }

    /**
     * 
     * @param weight
     */
    public void weight(int weight) {
        this.weight = weight;
    }

    /**
     * 
     * @param types
     */
    public void setType(BiomeDictionary.Type... types) {
        dictionaryTypes.clear();
        addType(types);
    }

    /**
     * 
     * @param types
     */
    public void addType(BiomeDictionary.Type... types) {
        Collections.addAll(dictionaryTypes, types);
    }

    /**
     * 
     * @param key
     */
    public void copyAmbience(RegistryKey<Biome> key) {
        Biome biome = ForgeRegistries.BIOMES.getValue(key.location());
        if (biome == null) {
            return;
        }
        specialEffects(biome.getSpecialEffects());
    }

    /**
     * 
     * @return
     */
    public Biome getBiome() {
        return parentBiome;
    }

    /**
     * 
     * @return
     */
    public BiomeGenerationSettings.Builder getGenSettings() {
        return this.genSettings;
    }

    /**
     * 
     * @return
     */
    public MobSpawnInfo.Builder getSpawnSettings() {
        return this.spawnSettings;
    }

    /**
     * 
     * @return
     */
    public BiomeBuilder init() {
        dictionaryTypes.retainAll(BiomeDictionary.getTypes(parentKey));
        return this;
    }

    /**
     * 
     * @param key
     * @return
     */
    public Biome build(RegistryKey<Biome> key) {
        generationSettings(this.genSettings.build());
        return super.build().setRegistryName(key.location());
    }
}
