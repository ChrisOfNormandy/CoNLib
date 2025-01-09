package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

public class WeightedPressurePlates {
    public static final int LIGHT_WEIGHT = 15;
    public static final int HEAVY_WEIGHT = 150;

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name) {
        return create(name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), LIGHT_WEIGHT);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), LIGHT_WEIGHT, creativeTab);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties) {
        return create(name, properties, LIGHT_WEIGHT);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, LIGHT_WEIGHT, creativeTab);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Integer maxWeight) {
        return create(name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), maxWeight);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Integer maxWeight,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), maxWeight, creativeTab);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties,
            Integer maxWeight) {
        return create(name, properties, maxWeight, BlockSetType.IRON);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties,
            Integer maxWeight,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, maxWeight, BlockSetType.IRON, creativeTab);
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties,
            Integer maxWeight,
            BlockSetType blockSetType) {
        return BlockRegistry.register(name, () -> new WeightedPressurePlateBlock(maxWeight, properties, blockSetType));
    }

    public static final RegistryObject<WeightedPressurePlateBlock> create(String name, Properties properties,
            Integer maxWeight,
            BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new WeightedPressurePlateBlock(maxWeight, properties, blockSetType),
                creativeTab);
    }
}
