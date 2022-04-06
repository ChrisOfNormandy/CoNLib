package com.github.chrisofnormandy.conlib.world;

import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.github.chrisofnormandy.conlib.world.generators.GeneratorSettings;
import com.github.chrisofnormandy.conlib.world.layers.LayerHelper;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModNetherBiomeProvider extends BiomeProvider {

    private static final List<RegistryKey<Biome>> vanillaBiomes = ImmutableList.of(Biomes.NETHER_WASTES,
            Biomes.SOUL_SAND_VALLEY, Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);

    private final long seed;
    private final Layer noiseBiomeLayer;
    private final Registry<Biome> biomes;

    public static final Codec<ModNetherBiomeProvider> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder
                .group(Codec.LONG.fieldOf("seed").stable().forGetter((biomeProvider) -> biomeProvider.seed),
                        RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
                                .forGetter((biomeProvider) -> biomeProvider.biomes))
                .apply(builder, builder.stable(ModNetherBiomeProvider::new));
    });

    public ModNetherBiomeProvider(long seed, Registry<Biome> biomeRegistry) {
        super(Stream.concat(vanillaBiomes.stream(), ModRegister.getNetherBiomes()).map(biomeRegistry::get)
                .collect(Collectors.toList()));
        this.seed = seed;
        this.noiseBiomeLayer = LayerHelper.createLayer(seed, new GeneratorSettings());
        this.biomes = biomeRegistry;
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return CODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return new ModNetherBiomeProvider(seed, this.biomes);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return this.noiseBiomeLayer.get(this.biomes, x, z);
    }
}
