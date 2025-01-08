package com.github.chrisofnormandy.conlib.registry.features;

import java.util.List;

import com.github.chrisofnormandy.conlib.registry.features.BiomeFeatureRegistry.BiomeOreFeatureRegistry;
import com.github.chrisofnormandy.conlib.registry.features.FeatureRegistry.OreFeatureRegistry;
import com.github.chrisofnormandy.conlib.registry.features.PlacedFeatureRegistry.PlacedOreFeatureRegistry;

import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;

public class OreFeature {
    public static final void register(String name, Block ore) {
        var oreList = List.of(
                OreConfiguration.target(FeatureRegistry.STONE_REPLACEABLES, ore.defaultBlockState()));

        register(name, oreList, BiomeTags.IS_OVERWORLD);
    }

    public static final void register(String name, Block ore, Block deepslateOre) {
        var oreList = List.of(
                OreConfiguration.target(FeatureRegistry.STONE_REPLACEABLES, ore.defaultBlockState()),
                OreConfiguration.target(FeatureRegistry.DEEPSLATE_REPLACEABLES, deepslateOre.defaultBlockState()));

        register(name, oreList, BiomeTags.IS_OVERWORLD);
    }

    public static final void register(String name, List<TargetBlockState> oreList, TagKey<Biome> biome) {
        OreFeatureRegistry.register(name, oreList);
        var placedFeatureKey = PlacedOreFeatureRegistry.register(name);
        BiomeOreFeatureRegistry.register(name, biome, placedFeatureKey);
    }
}
