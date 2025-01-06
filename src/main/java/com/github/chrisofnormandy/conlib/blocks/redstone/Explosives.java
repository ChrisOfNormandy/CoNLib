package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Explosives {

    public static final TntBlock create(String name) {
        return create(name, Properties.copy(Blocks.TNT));
    }

    public static final TntBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TNT), creativeTab);
    }

    public static final TntBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new TntBlock(properties));
    }

    public static final TntBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TntBlock(properties), creativeTab);
    }
}
