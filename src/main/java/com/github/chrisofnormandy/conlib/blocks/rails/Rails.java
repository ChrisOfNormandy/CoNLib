package com.github.chrisofnormandy.conlib.blocks.rails;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Rails {

    public static final Block create_rail(String name) {
        return BlockRegistry.register(name, new RailBlock(Properties.copy(Blocks.RAIL)));
    }

    public static final Block create_rail(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RailBlock(Properties.copy(Blocks.RAIL)), creativeTab);
    }

    public static final Block create_rail(String name, Properties properties) {
        return BlockRegistry.register(name, new RailBlock(properties));
    }

    public static final Block create_rail(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RailBlock(properties), creativeTab);
    }
}
