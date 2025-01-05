package com.github.chrisofnormandy.conlib.blocks.basic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Slabs {

    public static final SlabBlock create(String name) {
        return create(name, Properties.copy(Blocks.SMOOTH_STONE_SLAB));
    }

    public static final SlabBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SMOOTH_STONE_SLAB), creativeTab);
    }

    public static final SlabBlock create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock));
    }

    public static final SlabBlock create(String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), creativeTab);
    }

    public static final SlabBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new SlabBlock(properties));
    }

    public static final SlabBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SlabBlock(properties), creativeTab);
    }
}
