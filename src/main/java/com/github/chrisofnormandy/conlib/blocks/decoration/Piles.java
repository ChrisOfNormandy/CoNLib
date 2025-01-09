package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Piles {

    public static final RegistryObject<SnowLayerBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SNOW));
    }

    public static final RegistryObject<SnowLayerBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SNOW), creativeTab);
    }

    public static final RegistryObject<SnowLayerBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SnowLayerBlock(properties));
    }

    public static final RegistryObject<SnowLayerBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SnowLayerBlock(properties), creativeTab);
    }
}
