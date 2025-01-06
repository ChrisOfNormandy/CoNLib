package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Vines {

    public static final VineBlock create(String name) {
        return create(name, Properties.copy(Blocks.VINE));
    }

    public static final VineBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.VINE), creativeTab);
    }

    public static final VineBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new VineBlock(properties));
    }

    public static final VineBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new VineBlock(properties), creativeTab);
    }
}
