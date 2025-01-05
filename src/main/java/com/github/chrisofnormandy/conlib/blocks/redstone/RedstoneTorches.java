package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RedstoneTorches {
    public static final Block create(String name) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(Properties.copy(Blocks.REDSTONE_TORCH)));
    }

    public static final Block create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(Properties.copy(Blocks.REDSTONE_TORCH)),
                creativeTab);
    }

    public static final Block create(String name, Properties properties) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(properties));
    }

    public static final Block create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(properties), creativeTab);
    }
}
