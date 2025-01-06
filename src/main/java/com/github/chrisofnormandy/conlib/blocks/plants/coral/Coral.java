package com.github.chrisofnormandy.conlib.blocks.plants.coral;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Coral {

    public static final CoralBlock create(String name) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), Blocks.DEAD_FIRE_CORAL_BLOCK);
    }

    public static final CoralBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), Blocks.DEAD_FIRE_CORAL_BLOCK, creativeTab);
    }

    public static final CoralBlock create(String name, Properties properties) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL_BLOCK);
    }

    public static final CoralBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL_BLOCK, creativeTab);
    }

    public static final CoralBlock create(String name, Block deadBlock) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), deadBlock);
    }

    public static final CoralBlock create(String name, Block deadBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), deadBlock, creativeTab);
    }

    public static final CoralBlock create(String name, Properties properties, Block deadBlock) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, properties));
    }

    public static final CoralBlock create(String name, Properties properties, Block deadBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, properties), creativeTab);
    }
}
