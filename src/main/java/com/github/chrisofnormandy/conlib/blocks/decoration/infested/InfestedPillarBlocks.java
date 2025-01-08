package com.github.chrisofnormandy.conlib.blocks.decoration.infested;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedRotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InfestedPillarBlocks {
    public static final InfestedRotatedPillarBlock create(String name, Block hostBlock) {
        return create(name, hostBlock, Properties.copy(hostBlock));
    }

    public static final InfestedRotatedPillarBlock create(String name, Block hostBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, hostBlock, Properties.copy(hostBlock), creativeTab);
    }

    public static final InfestedRotatedPillarBlock create(String name, Block hostBlock, Properties properties) {
        return BlockRegistry.register(name, new InfestedRotatedPillarBlock(hostBlock, properties));
    }

    public static final InfestedRotatedPillarBlock create(String name, Block hostBlock, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new InfestedRotatedPillarBlock(hostBlock, properties), creativeTab);
    }
}
