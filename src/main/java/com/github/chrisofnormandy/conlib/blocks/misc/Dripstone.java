package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Dripstone {

    public static final PointedDripstoneBlock create(String name) {
        return create(name, Properties.copy(Blocks.POINTED_DRIPSTONE));
    }

    public static final PointedDripstoneBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.POINTED_DRIPSTONE), creativeTab);
    }

    public static final PointedDripstoneBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new PointedDripstoneBlock(properties));
    }

    public static final PointedDripstoneBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PointedDripstoneBlock(properties), creativeTab);
    }
}
