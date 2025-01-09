package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SporeBlossomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Needs custom implementation...

public class Blossoms {

    public static final RegistryObject<SporeBlossomBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SPORE_BLOSSOM));
    }

    public static final RegistryObject<SporeBlossomBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SPORE_BLOSSOM), creativeTab);
    }

    public static final RegistryObject<SporeBlossomBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SporeBlossomBlock(properties));
    }

    public static final RegistryObject<SporeBlossomBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SporeBlossomBlock(properties), creativeTab);
    }
}
