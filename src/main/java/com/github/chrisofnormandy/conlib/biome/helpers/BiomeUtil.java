package com.github.chrisofnormandy.conlib.biome.helpers;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeUtil {
    /**
     * 
     * @param biome
     * @return
     */
    public static RegistryKey<Biome> createKey(Biome biome) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName());
    }

    /**
     * 
     * @param key
     * @return
     */
    public static Biome biomeFromKey(RegistryKey<Biome> key) {
        return ForgeRegistries.BIOMES.getValue(key.location());
    }

    /**
     * 
     * @param key
     * @return
     */
    public static Boolean exists(RegistryKey<Biome> key) {
        return ForgeRegistries.BIOMES.containsKey(key.location());
    }

    /**
     * 
     * @param name
     * @return
     */
    public static RegistryKey<Biome> createKey(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModRegister.getModId(), name));
    }

    /**
     * 
     * @param key
     * @return
     */
    public static BiomeBuilder copy(RegistryKey<Biome> key) {
        Biome biome = ForgeRegistries.BIOMES.getValue(key.location());
        if (biome == null)
            return null;

        BiomeBuilder builder = new BiomeBuilder(key, biome);

        return builder;
    }

    /**
     * 
     * @param biome
     * @return
     */
    public static BiomeBuilder getBuilder(RegistryKey<Biome> biome) {
        return ModRegister.biomeBuilders.computeIfAbsent(biome, BiomeUtil::copy);
    }
}
