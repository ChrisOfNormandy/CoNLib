package com.github.chrisofnormandy.conlib.biome.helpers;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeUtil {
    public static RegistryKey<Biome> createKey(Biome biome) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName());
    }

    public static Biome biomeFromKey(RegistryKey<Biome> key) {
        return ForgeRegistries.BIOMES.getValue(key.location());
    }

    public static Boolean exists(RegistryKey<Biome> key) {
        return ForgeRegistries.BIOMES.containsKey(key.location());
    }

    public static RegistryKey<Biome> createKey(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModRegister.getModId(), name));
    }

    public static BiomeBuilder copy(RegistryKey<Biome> key) {
        Biome biome = ForgeRegistries.BIOMES.getValue(key.location());
        if (biome == null)
            return null;
        
        BiomeBuilder builder = new BiomeBuilder(key, biome);
        
        return builder;
    }

    public static BiomeBuilder getBuilder(RegistryKey<Biome> biome) {
        return ModRegister.biomeBuilders.computeIfAbsent(biome, BiomeUtil::copy);
    }
}
