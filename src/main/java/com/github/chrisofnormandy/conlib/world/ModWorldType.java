package com.github.chrisofnormandy.conlib.world;

import java.util.function.Supplier;

import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;

public class ModWorldType extends ForgeWorldType {
    public ModWorldType() {
        super(null);
    }

    public ModWorldType(IBasicChunkGeneratorFactory factory) {
        super(factory);
    }

    @Override
    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<DimensionSettings> dimensionSettingsRegistry, long seed, String generatorSettings)
    {
        Supplier<DimensionSettings> sup = () -> dimensionSettingsRegistry.get(DimensionSettings.OVERWORLD);
        BiomeProvider provider = new ModBiomeProvider(seed, biomeRegistry).get();
        return new NoiseChunkGenerator(provider, seed, sup);
    }

    @Override
    public DimensionGeneratorSettings createSettings(DynamicRegistries dynamicRegistries, long seed, boolean generateFeatures, boolean generateBonusChest, String generatorSettings)
    {
        Registry<Biome> biomeRegistry = dynamicRegistries.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<DimensionSettings> dimensionSettingsRegistry = dynamicRegistries.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
        Registry<DimensionType> dimensionTypeRegistry = dynamicRegistries.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);

        return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest, DimensionGeneratorSettings.withOverworld(dimensionTypeRegistry, ModDimension.dimensions(biomeRegistry, dimensionSettingsRegistry, seed), createChunkGenerator(biomeRegistry, dimensionSettingsRegistry, seed, generatorSettings)));
    }
}