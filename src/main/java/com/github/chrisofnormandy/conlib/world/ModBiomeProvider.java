package com.github.chrisofnormandy.conlib.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.github.chrisofnormandy.conlib.world.generators.GeneratorSettings;
import com.github.chrisofnormandy.conlib.world.layers.LayerHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class ModBiomeProvider extends BiomeProvider {
    private Long seed;
    private Layer layer;
    private Registry<Biome> biomeRegistry;

    private static final List<RegistryKey<Biome>> vanillaBiomes = new ArrayList<RegistryKey<Biome>>(Arrays.asList(
            Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.SWAMP,
            Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS,
            Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.WOODED_HILLS,
            Biomes.TAIGA_HILLS, Biomes.MOUNTAIN_EDGE, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE,
            Biomes.DEEP_OCEAN, Biomes.STONE_SHORE, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS,
            Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA,
            Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
            Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.WARM_OCEAN,
            Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN,
            Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES,
            Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS,
            Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.TALL_BIRCH_FOREST,
            Biomes.TALL_BIRCH_HILLS, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA,
            Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA,
            Biomes.SHATTERED_SAVANNA_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU,
            Biomes.MODIFIED_BADLANDS_PLATEAU));

    public ModBiomeProvider(long seed, Registry<Biome> biomeRegistry) {
        super(Stream.concat(vanillaBiomes.stream(), ModRegister.getOverworldBiomes()).map(biomeRegistry::get)
                .collect(Collectors.toList()));
        this.seed = seed;
        this.layer = LayerHelper.createLayer(seed, new GeneratorSettings());
        this.biomeRegistry = biomeRegistry;
    }

    public BiomeProvider get() {
        return this;
    }

    public static Codec<ModBiomeProvider> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder
                .group(Codec.LONG.fieldOf("seed").stable().forGetter((biomeProvider) -> biomeProvider.seed),
                        RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
                                .forGetter((biomeProvider) -> biomeProvider.biomeRegistry))
                .apply(builder, builder.stable(ModBiomeProvider::new));
    });

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return this.layer.get(this.biomeRegistry, x, z);
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return CODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return new ModBiomeProvider(seed, this.biomeRegistry);
    }
}
