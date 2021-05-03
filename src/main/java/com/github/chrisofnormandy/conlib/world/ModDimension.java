package com.github.chrisofnormandy.conlib.world;

import java.util.OptionalLong;

import com.google.common.base.Supplier;
import com.mojang.serialization.Lifecycle;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class ModDimension extends DimensionType {
    public ModDimension(OptionalLong p_i241973_1_, boolean p_i241973_2_, boolean p_i241973_3_, boolean p_i241973_4_, boolean p_i241973_5_, double p_i241973_6_, boolean p_i241973_8_, boolean p_i241973_9_, boolean p_i241973_10_, boolean p_i241973_11_, boolean p_i241973_12_, int p_i241973_13_, IBiomeMagnifier p_i241973_14_, ResourceLocation p_i241973_15_, ResourceLocation p_i241973_16_, float p_i241973_17_) {
        super(p_i241973_1_, p_i241973_2_, p_i241973_3_, p_i241973_4_, p_i241973_5_, p_i241973_6_, p_i241973_8_, p_i241973_9_, p_i241973_10_, p_i241973_11_, p_i241973_12_, p_i241973_13_, p_i241973_14_, p_i241973_15_, p_i241973_16_, p_i241973_17_);
    }

    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry,
            Registry<DimensionSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
        Supplier<DimensionSettings> sup = () -> dimensionSettingsRegistry.get(DimensionSettings.OVERWORLD);
        BiomeProvider provider = new ModBiomeProvider(seed, biomeRegistry).get();
        return new NoiseChunkGenerator(provider, seed, sup);
    }

    public static SimpleRegistry<Dimension> dimensions(Registry<Biome> biomeRegistry,
            Registry<DimensionSettings> dimensionSettingsRegistry, long seed) {
        SimpleRegistry<Dimension> registry = new SimpleRegistry<>(Registry.LEVEL_STEM_REGISTRY,
                Lifecycle.experimental());
        // registry.register(Dimension.NETHER, new Dimension(() -> DEFAULT_NETHER,
        // ModConfig.GenerationConfig.useBopNether.get() ?
        // bopNetherGenerator(biomeRegistry, dimensionSettingsRegistry, seed) :
        // DimensionType.defaultNetherGenerator(biomeRegistry,
        // dimensionSettingsRegistry, seed)), Lifecycle.stable());
        // registry.register(Dimension.END, new Dimension(() -> DEFAULT_END,
        // DimensionType.defaultEndGenerator(biomeRegistry, dimensionSettingsRegistry,
        // seed)), Lifecycle.stable());
        return registry;
    }
}
