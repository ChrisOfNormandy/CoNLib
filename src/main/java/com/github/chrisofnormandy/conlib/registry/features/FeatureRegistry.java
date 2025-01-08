package com.github.chrisofnormandy.conlib.registry.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.chrisofnormandy.conlib.Main;
import com.github.chrisofnormandy.conlib.collections.Tuple;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class FeatureRegistry {

    public static RuleTest STONE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static RuleTest DEEPSLATE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static RuleTest NETHERRACK_REPLACEABLES = new BlockMatchTest(Blocks.NETHERRACK);
    public static RuleTest ENDSTONE_REPLACEABLES = new BlockMatchTest(Blocks.END_STONE);

    public static class OreFeatureRegistry {
        public static final Map<String, Tuple<ResourceKey<ConfiguredFeature<?, ?>>, List<OreConfiguration.TargetBlockState>>> ORES = new HashMap<>();

        /*
         * Example:
         * List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(
         * OreConfiguration.target(STONE_REPLACEABLES,
         * Blocks.IRON_ORE.defaultBlockState()),
         * OreConfiguration.target(DEEPSLATE_REPLACEABLES,
         * Blocks.DEEPSLATE_IRON_ORE.defaultBlockState()));
         */
        public static final void register(String name, List<OreConfiguration.TargetBlockState> ore) {
            ORES.put(name, new Tuple<>(FeatureRegistry.registerKey(name), ore));
        }
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        OreFeatureRegistry.ORES.forEach((key, value) -> {
            register(context, value.x, Feature.ORE, new OreConfiguration(value.y, 9));
        });
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Main.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
