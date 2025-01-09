package com.github.chrisofnormandy.conlib.blocks.basic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class WallBlocks {

    public static final RegistryObject<WallBlock> create(String name) {
        return create(name, Properties.copy(Blocks.COBBLESTONE_WALL));
    }

    public static final RegistryObject<WallBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.COBBLESTONE_WALL), creativeTab);
    }

    public static final RegistryObject<WallBlock> create(String name, Block sourceBlock) {
        return create(name, Properties.copy(sourceBlock));
    }

    public static final RegistryObject<WallBlock> create(String name, Block sourceBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(sourceBlock), creativeTab);
    }

    public static final RegistryObject<WallBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new WallBlock(properties));
    }

    public static final RegistryObject<WallBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new WallBlock(properties), creativeTab);
    }
}
