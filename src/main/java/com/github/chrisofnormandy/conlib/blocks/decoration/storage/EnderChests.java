package com.github.chrisofnormandy.conlib.blocks.decoration.storage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class EnderChests {

    public static final RegistryObject<EnderChestBlock> create(String name) {
        return create(name, Properties.copy(Blocks.ENDER_CHEST));
    }

    public static final RegistryObject<EnderChestBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ENDER_CHEST), creativeTab);
    }

    public static final RegistryObject<EnderChestBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new EnderChestBlock(properties));
    }

    public static final RegistryObject<EnderChestBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new EnderChestBlock(properties), creativeTab);
    }
}
