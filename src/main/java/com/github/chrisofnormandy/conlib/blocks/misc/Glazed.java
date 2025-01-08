package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Glazed {

    public static final GlazedTerracottaBlock create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA));
    }

    public static final GlazedTerracottaBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), creativeTab);
    }

    public static final GlazedTerracottaBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new GlazedTerracottaBlock(properties));
    }

    public static final GlazedTerracottaBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GlazedTerracottaBlock(properties), creativeTab);
    }
}
