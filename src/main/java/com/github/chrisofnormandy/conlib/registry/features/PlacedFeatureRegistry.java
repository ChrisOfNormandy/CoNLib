package com.github.chrisofnormandy.conlib.registry.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.registry.features.FeatureRegistry.OreFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class PlacedFeatureRegistry {
    public static class PlacedOreFeatureRegistry {
        public static final Map<String, ResourceKey<PlacedFeature>> KEYS = new HashMap<>();

        public static List<PlacementModifier> orePlacement(PlacementModifier modifier1, PlacementModifier modifier2) {
            return List.of(modifier1, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
        }

        public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
            return orePlacement(CountPlacement.of(pCount), pHeightRange);
        }

        public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
            return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
        }

        public static final ResourceKey<PlacedFeature> register(String name) {
            ResourceKey<PlacedFeature> key = PlacedFeatureRegistry.registerKey(name);
            KEYS.put(name, key);

            return key;
        }
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacedOreFeatureRegistry.KEYS.forEach((key, value) -> {
            var placedFeatureKey = PlacedOreFeatureRegistry.KEYS.get(key);
            var oreFeatureKey = OreFeatureRegistry.ORES.get(key).x;

            register(context,
                    placedFeatureKey,
                    configuredFeatures.getOrThrow(oreFeatureKey),
                    PlacedOreFeatureRegistry.commonOrePlacement(12,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        });
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CoNLib.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
