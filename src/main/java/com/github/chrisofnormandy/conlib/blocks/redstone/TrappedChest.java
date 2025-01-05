package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TrappedChest {
    public static final Block create_trappedChest(String name) {
        return BlockRegistry.register(name, new TrappedChestBlock(Properties.copy(Blocks.TRAPPED_CHEST)));
    }

    public static final Block create_trappedChest(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrappedChestBlock(Properties.copy(Blocks.TRAPPED_CHEST)),
                creativeTab);
    }

    public static final Block create_trappedChest(String name, Properties properties) {
        return BlockRegistry.register(name, new TrappedChestBlock(properties));
    }

    public static final Block create_trappedChest(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrappedChestBlock(properties), creativeTab);
    }
}
