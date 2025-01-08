package com.github.chrisofnormandy.conlib.registry.features;

import java.util.HashMap;
import java.util.Map;

import com.github.chrisofnormandy.conlib.Main;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.features.PlacedFeatureRegistry.PlacedOreFeatureRegistry;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeFeatureRegistry {
    public static class BiomeOreFeatureRegistry {
        public static final Map<String, Tuple<TagKey<Biome>, ResourceKey<PlacedFeature>>> MODIFIERS = new HashMap<>();

        public static final void register(String name, TagKey<Biome> biome,
                ResourceKey<PlacedFeature> placedFeatureKey) {
            Tuple<TagKey<Biome>, ResourceKey<PlacedFeature>> value = new Tuple<>(biome, placedFeatureKey);
            MODIFIERS.put(name, value);
        }
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        BiomeOreFeatureRegistry.MODIFIERS.forEach((key, value) -> {
            var placedFeatureKey = PlacedOreFeatureRegistry.KEYS.get(key);

            var feature = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(value.x),
                    HolderSet.direct(placedFeatures.getOrThrow(placedFeatureKey)),
                    GenerationStep.Decoration.UNDERGROUND_ORES);

            context.register(registerKey(key), feature);
        });
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Main.MOD_ID, name));
    }
}
