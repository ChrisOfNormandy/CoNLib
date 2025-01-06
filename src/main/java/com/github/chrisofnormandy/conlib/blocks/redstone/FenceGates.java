package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FenceGates {

    public static final FenceGateBlock create(String name) {
        return create(name, Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
    }

    public static final FenceGateBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK, creativeTab);
    }

    public static final FenceGateBlock create(String name, Properties properties) {
        return create(name, properties, WoodType.OAK);
    }

    public static final FenceGateBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, WoodType.OAK, creativeTab);
    }

    public static final FenceGateBlock create(String name, WoodType woodType) {
        return create(name, Properties.copy(Blocks.OAK_FENCE_GATE), woodType);
    }

    public static final FenceGateBlock create(String name, WoodType woodType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_FENCE_GATE), woodType, creativeTab);
    }

    public static final FenceGateBlock create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock), WoodType.OAK);
    }

    public static final FenceGateBlock create(String name, Block sourceBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), WoodType.OAK, creativeTab);
    }

    public static final FenceGateBlock create(String name, Block sourceBlock, WoodType woodType) {
        return create(name, Properties.copy(sourceBlock), woodType);
    }

    public static final FenceGateBlock create(String name, Block sourceBlock, WoodType woodType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), woodType, creativeTab);
    }

    public static final FenceGateBlock create(String name, Properties properties, WoodType woodType) {
        FenceGateBlock fence = new FenceGateBlock(properties, woodType);
        return BlockRegistry.register(name, fence);
    }

    public static final FenceGateBlock create(String name, Properties properties, WoodType woodType,
            ResourceKey<CreativeModeTab> creativeTab) {
        FenceGateBlock fence = new FenceGateBlock(properties, woodType);
        return BlockRegistry.register(name, fence, creativeTab);
    }
}
