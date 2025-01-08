package com.github.chrisofnormandy.conlib.blocks.decoration.infested;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InfestedBlocks {
    public static final InfestedBlock create(String name, Block hostBlock) {
        return create(name, hostBlock, Properties.copy(hostBlock));
    }

    public static final InfestedBlock create(String name, Block hostBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, hostBlock, Properties.copy(hostBlock), creativeTab);
    }

    public static final InfestedBlock create(String name, Block hostBlock, Properties properties) {
        return BlockRegistry.register(name, new InfestedBlock(hostBlock, properties));
    }

    public static final InfestedBlock create(String name, Block hostBlock, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new InfestedBlock(hostBlock, properties), creativeTab);
    }
}
