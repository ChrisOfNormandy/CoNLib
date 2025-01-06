package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class PressurePlates {

    public static final PressurePlateBlock create(String name) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final PressurePlateBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE,
                creativeTab);
    }

    public static final PressurePlateBlock create(String name, Properties properties) {
        return create(name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final PressurePlateBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE, creativeTab);
    }

    public static final PressurePlateBlock create(String name, Sensitivity sensitivity) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE);
    }

    public static final PressurePlateBlock create(String name, Sensitivity sensitivity,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final PressurePlateBlock create(String name, Properties properties, Sensitivity sensitivity) {
        return create(name, properties, sensitivity, BlockSetType.STONE);
    }

    public static final PressurePlateBlock create(String name, Properties properties, Sensitivity sensitivity,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final PressurePlateBlock create(String name, BlockSetType blockSetType) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType);
    }

    public static final PressurePlateBlock create(String name, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType,
                creativeTab);
    }

    public static final PressurePlateBlock create(String name, Properties properties, BlockSetType blockSetType) {
        return create(name, properties, Sensitivity.EVERYTHING, blockSetType);
    }

    public static final PressurePlateBlock create(String name, Properties properties, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Sensitivity.EVERYTHING, blockSetType, creativeTab);
    }

    public static final PressurePlateBlock create(String name, Sensitivity sensitivity, BlockSetType blockSetType) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType);
    }

    public static final PressurePlateBlock create(String name, Sensitivity sensitivity, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType, creativeTab);
    }

    public static final PressurePlateBlock create(String name, Properties properties, Sensitivity sensitivity,
            BlockSetType blockSetType) {
        PressurePlateBlock pressurePlate = new PressurePlateBlock(sensitivity, properties, blockSetType);
        return BlockRegistry.register(name, pressurePlate);
    }

    public static final PressurePlateBlock create(String name, Properties properties, Sensitivity sensitivity,
            BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        PressurePlateBlock pressurePlate = new PressurePlateBlock(sensitivity, properties, blockSetType);
        return BlockRegistry.register(name, pressurePlate, creativeTab);
    }
}
