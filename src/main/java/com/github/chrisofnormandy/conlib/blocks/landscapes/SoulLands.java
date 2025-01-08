package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SoulLands {

    public static final SoulSandBlock create(String name) {
        return create(name, Properties.copy(Blocks.SOUL_SAND));
    }

    public static final SoulSandBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SOUL_SAND), creativeTab);
    }

    public static final SoulSandBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new SoulSandBlock(properties));
    }

    public static final SoulSandBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SoulSandBlock(properties), creativeTab);
    }
}
