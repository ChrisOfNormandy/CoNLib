package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Lamps {
    public static final Block create_lamp(String name) {
        return BlockRegistry.register(name, new RedstoneLampBlock(Properties.copy(Blocks.REDSTONE_LAMP)));
    }

    public static final Block create_lamp(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneLampBlock(Properties.copy(Blocks.REDSTONE_LAMP)),
                creativeTab);
    }

    public static final Block create_lamp(String name, Properties properties) {
        return BlockRegistry.register(name, new RedstoneLampBlock(properties));
    }

    public static final Block create_lamp(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneLampBlock(properties), creativeTab);
    }
}
