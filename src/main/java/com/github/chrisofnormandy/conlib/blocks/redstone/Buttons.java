package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.blocks.redstone.types.ButtonBase;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Buttons {

    public static final ButtonBase create(String name) {
        return create(name, Properties.copy(Blocks.STONE_BUTTON));
    }

    public static final ButtonBase create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_BUTTON), creativeTab);
    }

    public static final ButtonBase create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock));
    }

    public static final ButtonBase create(String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), creativeTab);
    }

    public static final ButtonBase create(String name, Properties properties) {
        return BlockRegistry.register(name, new ButtonBase(properties));
    }

    public static final ButtonBase create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ButtonBase(properties), creativeTab);
    }
}