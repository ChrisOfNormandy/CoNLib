package com.github.chrisofnormandy.conlib.blocks.basic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Stairs {

    public static final StairBlock create(String name) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS));
    }

    public static final StairBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS), creativeTab);
    }

    public static final StairBlock create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock));
    }

    public static final StairBlock create(String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), creativeTab);
    }

    public static final StairBlock create(String name, Properties properties) {
        return create(name, properties, new Block(properties));
    }

    public static final StairBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, new Block(properties), creativeTab);
    }

    public static final StairBlock create(String name, Properties properties, Block sourceBlock) {
        StairBlock stairs = new StairBlock(() -> sourceBlock.defaultBlockState(), properties);

        return BlockRegistry.register(name, stairs);
    }

    public static final StairBlock create(String name, Properties properties, Block sourceBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        StairBlock stairs = new StairBlock(() -> sourceBlock.defaultBlockState(), properties);

        return BlockRegistry.register(name, stairs, creativeTab);
    }
}
