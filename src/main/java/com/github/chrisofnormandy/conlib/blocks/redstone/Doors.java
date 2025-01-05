package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Doors {

    public static final Block create(String name) {
        return create(name, Blocks.OAK_DOOR, BlockSetType.OAK);
    }

    public static final Block create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Blocks.OAK_DOOR, BlockSetType.OAK, creativeTab);
    }

    public static final Block create(String name, Properties properties) {
        return create(name, properties, BlockSetType.OAK);
    }

    public static final Block create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, BlockSetType.OAK, creativeTab);
    }

    public static final Block create(String name, BlockSetType blockSetType) {
        return create(name, Blocks.OAK_DOOR, blockSetType);
    }

    public static final Block create(String name, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Blocks.OAK_DOOR, blockSetType, creativeTab);
    }

    public static final Block create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock), BlockSetType.OAK);
    }

    public static final Block create(String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), BlockSetType.OAK, creativeTab);
    }

    public static final Block create(String name, Block sourceBlock, BlockSetType blockSetType) {
        return create(name, Properties.copy(sourceBlock), blockSetType);
    }

    public static final Block create(String name, Block sourceBlock, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), blockSetType, creativeTab);
    }

    public static final Block create(String name, Properties properties, BlockSetType blockSetType) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), blockSetType));
    }

    public static final Block create(String name, Properties properties, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), blockSetType), creativeTab);
    }
}