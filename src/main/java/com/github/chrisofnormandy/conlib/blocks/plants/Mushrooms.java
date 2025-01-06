package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Mushrooms {

    public static final MushroomBlock create(String name) {
        return create(name, Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM);
    }

    public static final MushroomBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM, creativeTab);
    }

    // Cannot define methods that implement features and creative tab because
    // they're the same type.

    public static final MushroomBlock create(String name,
            Properties properties,
            ResourceKey<ConfiguredFeature<?, ?>> feature) {
        return BlockRegistry.register(name, new MushroomBlock(properties, feature));
    }

    public static final MushroomBlock create(String name,
            Properties properties,
            ResourceKey<ConfiguredFeature<?, ?>> feature,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new MushroomBlock(properties, feature), creativeTab);
    }
}
