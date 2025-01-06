package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SeaPickles {

    public static final SeaPickleBlock create(String name) {
        return create(name, Properties.copy(Blocks.SEA_PICKLE));
    }

    public static final SeaPickleBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SEA_PICKLE), creativeTab);
    }

    public static final SeaPickleBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new SeaPickleBlock(properties));
    }

    public static final SeaPickleBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SeaPickleBlock(properties), creativeTab);
    }
}
