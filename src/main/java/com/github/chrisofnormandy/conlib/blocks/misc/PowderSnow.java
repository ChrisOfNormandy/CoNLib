package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PowderSnow {

    public static final PowderSnowBlock create(String name) {
        return create(name, Properties.copy(Blocks.MAGMA_BLOCK));
    }

    public static final PowderSnowBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.MAGMA_BLOCK), creativeTab);
    }

    public static final PowderSnowBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new PowderSnowBlock(properties));
    }

    public static final PowderSnowBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PowderSnowBlock(properties), creativeTab);
    }
}
