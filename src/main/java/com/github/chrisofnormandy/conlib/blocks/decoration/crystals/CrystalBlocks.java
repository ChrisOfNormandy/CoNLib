package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class CrystalBlocks {

    public static final RegistryObject<AmethystBlock> create(String name) {
        return create(name, Properties.copy(Blocks.AMETHYST_BLOCK));
    }

    public static final RegistryObject<AmethystBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.AMETHYST_BLOCK), creativeTab);
    }

    public static final RegistryObject<AmethystBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new AmethystBlock(properties));
    }

    public static final RegistryObject<AmethystBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new AmethystBlock(properties), creativeTab);
    }
}
