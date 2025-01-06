package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Wires {

    public static final RedStoneWireBlock create(String name) {
        return create(name, Properties.copy(Blocks.REDSTONE_WIRE));
    }

    public static final RedStoneWireBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.REDSTONE_WIRE), creativeTab);
    }

    public static final RedStoneWireBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new RedStoneWireBlock(properties));
    }

    public static final RedStoneWireBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedStoneWireBlock(properties), creativeTab);
    }
}
