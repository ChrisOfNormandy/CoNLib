package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PondFoliage {

    public static final SmallDripleafBlock create(String name) {
        return create(name, Properties.copy(Blocks.SMALL_DRIPLEAF));
    }

    public static final SmallDripleafBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SMALL_DRIPLEAF), creativeTab);
    }

    public static final SmallDripleafBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new SmallDripleafBlock(properties));
    }

    public static final SmallDripleafBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SmallDripleafBlock(properties), creativeTab);
    }
}
