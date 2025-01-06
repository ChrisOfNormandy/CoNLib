package com.github.chrisofnormandy.conlib.blocks.decoration.storage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ShulkerBoxes {
    public static final ShulkerBoxBlock create(String name, DyeColor color) {
        return create(name, color, Properties.copy(Blocks.WHITE_SHULKER_BOX));
    }

    public static final ShulkerBoxBlock create(String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, color, Properties.copy(Blocks.WHITE_SHULKER_BOX), creativeTab);
    }

    public static final ShulkerBoxBlock create(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, properties));
    }

    public static final ShulkerBoxBlock create(String name, DyeColor color, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, properties), creativeTab);
    }
}
