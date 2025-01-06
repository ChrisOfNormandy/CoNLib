package com.github.chrisofnormandy.conlib.blocks.plants.coral;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CoralPlants {
    public static final CoralPlantBlock create(String name) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL), Blocks.DEAD_FIRE_CORAL);
    }

    public static final CoralPlantBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL), Blocks.DEAD_FIRE_CORAL, creativeTab);
    }

    public static final CoralPlantBlock create(String name, Properties properties) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL);
    }

    public static final CoralPlantBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL, creativeTab);
    }

    public static final CoralPlantBlock create(String name, Block deadBlock) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL), deadBlock);
    }

    public static final CoralPlantBlock create(String name, Block deadBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL), deadBlock, creativeTab);
    }

    public static final CoralPlantBlock create(String name, Properties properties, Block deadBlock) {
        return BlockRegistry.register(name, new CoralPlantBlock(deadBlock, properties));
    }

    public static final CoralPlantBlock create(String name, Properties properties, Block deadBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CoralPlantBlock(deadBlock, properties), creativeTab);
    }
}
