package com.github.chrisofnormandy.conlib.blocks.decoration.storage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Chests {
    public static final ChestBlock create(String name) {
        return create(name, Properties.copy(Blocks.CHEST), BlockEntityType.CHEST);
    }

    public static final ChestBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CHEST), BlockEntityType.CHEST, creativeTab);
    }

    public static final ChestBlock create(String name, Properties properties) {
        return create(name, properties, BlockEntityType.CHEST);
    }

    public static final ChestBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, BlockEntityType.CHEST, creativeTab);
    }

    public static final <T extends ChestBlockEntity> ChestBlock create(String name, Properties properties,
            BlockEntityType<T> blockEntityType) {
        return BlockRegistry.register(name, new ChestBlock(properties, () -> blockEntityType));
    }

    public static final <T extends ChestBlockEntity> ChestBlock create(String name, Properties properties,
            BlockEntityType<T> blockEntityType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChestBlock(properties, () -> blockEntityType), creativeTab);
    }
}
