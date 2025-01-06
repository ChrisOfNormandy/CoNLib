package com.github.chrisofnormandy.conlib.blocks.plants.flowers;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TallFlowers {

    public static final TallFlowerBlock create(String name) {
        return create(name, Properties.copy(Blocks.ROSE_BUSH));
    }

    public static final TallFlowerBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ROSE_BUSH), creativeTab);
    }

    public static final TallFlowerBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new TallFlowerBlock(properties));
    }

    public static final TallFlowerBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TallFlowerBlock(properties), creativeTab);
    }
}
