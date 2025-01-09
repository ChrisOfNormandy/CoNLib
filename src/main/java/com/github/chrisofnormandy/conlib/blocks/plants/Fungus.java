package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.registries.RegistryObject;

public class Fungus {

    public static final RegistryObject<FungusBlock> create(String name, Block requiredBlock) {
        return create(name, Properties.copy(Blocks.WARPED_FUNGUS), TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock);
    }

    public static final RegistryObject<FungusBlock> create(String name, Block requiredBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WARPED_FUNGUS), TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock,
                creativeTab);
    }

    public static final RegistryObject<FungusBlock> create(String name, Properties properties, Block requiredBlock) {
        return create(name, properties, TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock);
    }

    public static final RegistryObject<FungusBlock> create(String name, Properties properties, Block requiredBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock, creativeTab);
    }

    public static final RegistryObject<FungusBlock> create(String name,
            ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock) {
        return create(name, Properties.copy(Blocks.WARPED_FUNGUS), feature, requiredBlock);
    }

    public static final RegistryObject<FungusBlock> create(String name,
            ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name,
                Properties.copy(Blocks.WARPED_FUNGUS), feature, requiredBlock, creativeTab);
    }

    public static final RegistryObject<FungusBlock> create(String name, Properties properties,
            ResourceKey<ConfiguredFeature<?, ?>> feature,
            Block requiredBlock) {
        return BlockRegistry.register(name, () -> new FungusBlock(properties, feature, requiredBlock));
    }

    public static final RegistryObject<FungusBlock> create(String name, Properties properties,
            ResourceKey<ConfiguredFeature<?, ?>> feature,
            Block requiredBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new FungusBlock(properties, feature, requiredBlock), creativeTab);
    }
}
