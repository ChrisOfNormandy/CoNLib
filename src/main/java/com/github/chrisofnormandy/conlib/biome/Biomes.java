package com.github.chrisofnormandy.conlib.biome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class Biomes {
    public static class Helpers {
        public static RegistryKey<Biome> createKey(Biome biome) {
            return RegistryKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName());
        }

        public static Biome biomeFromKey(RegistryKey<Biome> key) {
            return ForgeRegistries.BIOMES.getValue(key.location());
        }

        public static boolean exists(RegistryKey<Biome> key) {
            return ForgeRegistries.BIOMES.containsKey(key.location());
        }
    }

    public static HashMap<String, ModClimate> climates = new HashMap<String, ModClimate>();

    private static HashMap<RegistryType, ArrayList<BiomeRegistration<?>>> preRegistrations = new HashMap<RegistryType, ArrayList<BiomeRegistration<?>>>();

    private static <T extends RegistrationBase> void preRegister(RegistryType type, T data) {
        if (!preRegistrations.containsKey(type))
            preRegistrations.put(type, new ArrayList<BiomeRegistration<?>>());

        BiomeRegistration<T> reg = new BiomeRegistration<T>((Consumer<T>) type.function, data);
        preRegistrations.get(type).add(reg);
    }

    public static void register(String name, ModBiome biome, Biome.Category category, Biome.RainType rainType) {
        biome.setCategory(category);
        biome.setRainType(rainType);

        GenericBiome a = new GenericBiome(biome, name);
        Biome b = a.getBiome();

        a.getClimates().forEach((ModClimate climate, Integer weight) -> {
            if (weight > 0)
                climate.addBiome(b);
        });
        
        ForgeRegistries.BIOMES.register(b.setRegistryName(new ResourceLocation(Main.MOD_ID, name)));
        
        preRegister(RegistryType.STANDARD, a);
    }

    public static void registerAll() {
        preRegistrations.get(RegistryType.STANDARD).forEach((BiomeRegistration<?> registry) -> registry.register());
    }

    public enum RegistryType {
        STANDARD((GenericBiome data) -> {
            data.getClimates().forEach((ModClimate climate, Integer weight) -> {
                if (weight > 0)
                    climate.addBiome(data.getBiome());
            });
        });

        public Consumer<?> function;
        RegistryType(Consumer<?> func) {
            this.function = func;
        }
    }

    static class RegistrationBase {
        private Biome biome;

        public RegistrationBase(ModBiome biome) {
            this.biome = biome.Build();
        }

        public Biome getBiome() {
            return this.biome;
        }
    }

    private static class GenericBiome extends RegistrationBase {
        private String name;
        private HashMap<ModClimate, Integer> climates;

        public GenericBiome(ModBiome biome, String name) {
            super(biome);
            this.name = name;
            this.climates = biome.getClimates();
        }

        public String getName() {
            return this.name;
        }

        public HashMap<ModClimate, Integer> getClimates() {
            return this.climates;
        }
    }
}