package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GravelLand {
    public static final GravelBlock create(String name) {
        return create(name, Properties.copy(Blocks.GRAVEL));
    }

    public static final GravelBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GRAVEL), creativeTab);
    }

    public static final GravelBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new GravelBlock(properties));
    }

    public static final GravelBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GravelBlock(properties), creativeTab);
    }
}
