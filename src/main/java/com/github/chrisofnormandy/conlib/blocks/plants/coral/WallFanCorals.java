package com.github.chrisofnormandy.conlib.blocks.plants.coral;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralWallFanBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class WallFanCorals {

    public static final RegistryObject<CoralWallFanBlock> create(String name) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_WALL_FAN), Blocks.DEAD_FIRE_CORAL_WALL_FAN);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_WALL_FAN), Blocks.DEAD_FIRE_CORAL_WALL_FAN, creativeTab);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Properties properties) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL_WALL_FAN);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Blocks.DEAD_FIRE_CORAL_WALL_FAN, creativeTab);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Block deadBlock) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_WALL_FAN), deadBlock);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Block deadBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FIRE_CORAL_WALL_FAN), deadBlock, creativeTab);
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Properties properties, Block deadBlock) {
        return BlockRegistry.register(name, () -> new CoralWallFanBlock(deadBlock, properties));
    }

    public static final RegistryObject<CoralWallFanBlock> create(String name, Properties properties, Block deadBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CoralWallFanBlock(deadBlock, properties), creativeTab);
    }
}
