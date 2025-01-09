package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AzaleaBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Needs custom implementation...

public class TreeBushes {

    public static final RegistryObject<AzaleaBlock> create(String name) {
        return create(name, Properties.copy(Blocks.AZALEA));
    }

    public static final RegistryObject<AzaleaBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.AZALEA), creativeTab);
    }

    public static final RegistryObject<AzaleaBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new AzaleaBlock(properties));
    }

    public static final RegistryObject<AzaleaBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new AzaleaBlock(properties), creativeTab);
    }
}
