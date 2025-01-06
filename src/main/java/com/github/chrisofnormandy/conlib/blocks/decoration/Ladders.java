package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Ladders {
    public static final LadderBlock create(String name) {
        return create(name, Properties.copy(Blocks.LADDER));
    }

    public static final LadderBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LADDER), creativeTab);
    }

    public static final LadderBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new LadderBlock(properties));
    }

    public static final LadderBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LadderBlock(properties), creativeTab);
    }
}
