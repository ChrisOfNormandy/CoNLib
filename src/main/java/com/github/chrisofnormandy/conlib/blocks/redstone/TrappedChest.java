package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class TrappedChest {

    public static final RegistryObject<TrappedChestBlock> create(String name) {
        return create(name, Properties.copy(Blocks.TRAPPED_CHEST));
    }

    public static final RegistryObject<TrappedChestBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TRAPPED_CHEST), creativeTab);
    }

    public static final RegistryObject<TrappedChestBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new TrappedChestBlock(properties));
    }

    public static final RegistryObject<TrappedChestBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TrappedChestBlock(properties), creativeTab);
    }
}
