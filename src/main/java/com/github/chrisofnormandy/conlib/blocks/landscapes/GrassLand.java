package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class GrassLand {

    public static final RegistryObject<GrassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.GRASS_BLOCK));
    }

    public static final RegistryObject<GrassBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GRASS_BLOCK), creativeTab);
    }

    public static final RegistryObject<GrassBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new GrassBlock(properties));
    }

    public static final RegistryObject<GrassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new GrassBlock(properties), creativeTab);
    }
}
