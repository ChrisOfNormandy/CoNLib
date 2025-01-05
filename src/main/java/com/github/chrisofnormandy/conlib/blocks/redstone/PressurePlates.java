package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class PressurePlates {
    public static class Weighted {

        public static final Block create(String name, Integer maxWeight) {
            return BlockRegistry.register(name,
                    new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE),
                            BlockSetType.IRON));
        }

        public static final Block create(String name, Integer maxWeight,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name,
                    new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE),
                            BlockSetType.IRON),
                    creativeTab);
        }

        public static final Block create(String name, Integer maxWeight, Properties properties) {
            return BlockRegistry.register(name,
                    new WeightedPressurePlateBlock(maxWeight, properties, BlockSetType.IRON));
        }

        public static final Block create(String name, Integer maxWeight, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name,
                    new WeightedPressurePlateBlock(maxWeight, properties, BlockSetType.IRON),
                    creativeTab);
        }
    }

    public static final Block create(String name) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final Block create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE,
                creativeTab);
    }

    public static final Block create(String name, Properties properties) {
        return create(name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final Block create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE, creativeTab);
    }

    public static final Block create(String name, Sensitivity sensitivity) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE);
    }

    public static final Block create(String name, Sensitivity sensitivity, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final Block create(String name, Properties properties, Sensitivity sensitivity) {
        return create(name, properties, sensitivity, BlockSetType.STONE);
    }

    public static final Block create(String name, Properties properties, Sensitivity sensitivity,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final Block create(String name, BlockSetType blockSetType) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType);
    }

    public static final Block create(String name, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType,
                creativeTab);
    }

    public static final Block create(String name, Properties properties, BlockSetType blockSetType) {
        return create(name, properties, Sensitivity.EVERYTHING, blockSetType);
    }

    public static final Block create(String name, Properties properties, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Sensitivity.EVERYTHING, blockSetType, creativeTab);
    }

    public static final Block create(String name, Sensitivity sensitivity, BlockSetType blockSetType) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType);
    }

    public static final Block create(String name, Sensitivity sensitivity, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType, creativeTab);
    }

    public static final Block create(String name, Properties properties, Sensitivity sensitivity,
            BlockSetType blockSetType) {
        PressurePlateBlock pressurePlate = new PressurePlateBlock(sensitivity, properties, blockSetType);
        return BlockRegistry.register(name, pressurePlate);
    }

    public static final Block create(String name, Properties properties, Sensitivity sensitivity,
            BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        PressurePlateBlock pressurePlate = new PressurePlateBlock(sensitivity, properties, blockSetType);
        return BlockRegistry.register(name, pressurePlate, creativeTab);
    }
}
