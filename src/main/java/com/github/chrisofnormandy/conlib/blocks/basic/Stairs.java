package com.github.chrisofnormandy.conlib.blocks.basic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Stairs {

    public static final Block create(String name, Properties properties) {
        return BlockRegistry.register(name,
                new StairBlock(() -> new Block(properties).defaultBlockState(), properties));
    }

    public static final Block create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new StairBlock(() -> new Block(properties).defaultBlockState(), properties), creativeTab);
    }
}
