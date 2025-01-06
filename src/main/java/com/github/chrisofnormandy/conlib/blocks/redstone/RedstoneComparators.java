package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RedstoneComparators {

    public static final ComparatorBlock create(String name) {
        return create(name, Properties.copy(Blocks.COMPARATOR));
    }

    public static final ComparatorBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.COMPARATOR), creativeTab);
    }

    public static final ComparatorBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new ComparatorBlock(properties));
    }

    public static final ComparatorBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ComparatorBlock(properties), creativeTab);
    }
}
