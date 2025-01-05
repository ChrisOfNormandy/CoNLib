package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class StorageBlocks {
    /**
     *
     * @param name
     * @return
     */
    public static final Block create_chest(String name) {
        return BlockRegistry.register(name, new ChestBlock(Properties.copy(Blocks.CHEST), () -> {
            return BlockEntityType.CHEST;
        }));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_chest(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChestBlock(Properties.copy(Blocks.CHEST), () -> {
            return BlockEntityType.CHEST;
        }), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_chest(String name, Properties properties) {
        return BlockRegistry.register(name, new ChestBlock(properties, () -> {
            return BlockEntityType.CHEST;
        }));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_chest(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChestBlock(properties, () -> {
            return BlockEntityType.CHEST;
        }), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_barrel(String name) {
        return BlockRegistry.register(name, new BarrelBlock(Properties.copy(Blocks.BARREL)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_barrel(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BarrelBlock(Properties.copy(Blocks.BARREL)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_barrel(String name, Properties properties) {
        return BlockRegistry.register(name, new BarrelBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_barrel(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BarrelBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @param color
     * @return
     */
    public static final Block create_shulker(String name, DyeColor color) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, Properties.copy(Blocks.WHITE_SHULKER_BOX)));
    }

    /**
     *
     * @param name
     * @param color
     * @param group
     * @return
     */
    public static final Block create_shulker(String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, Properties.copy(Blocks.WHITE_SHULKER_BOX)),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param color
     * @param properties
     * @return
     */
    public static final Block create_shulker(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, properties));
    }

    /**
     *
     * @param name
     * @param color
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_shulker(String name, DyeColor color, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ShulkerBoxBlock(color, properties), creativeTab);
    }
}
