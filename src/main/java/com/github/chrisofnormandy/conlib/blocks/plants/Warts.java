package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Warts {
    public static final NetherWartBlock create(String name) {
        return create(name, Properties.copy(Blocks.GLOW_LICHEN));
    }

    public static final NetherWartBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GLOW_LICHEN), creativeTab);
    }

    public static final NetherWartBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new NetherWartBlock(properties));
    }

    public static final NetherWartBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new NetherWartBlock(properties), creativeTab);
    }
}
