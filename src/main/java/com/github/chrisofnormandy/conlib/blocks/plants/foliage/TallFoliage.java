package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class TallFoliage {

    public static final RegistryObject<TallGrassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.TALL_GRASS));
    }

    public static final RegistryObject<TallGrassBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TALL_GRASS), creativeTab);
    }

    public static final RegistryObject<TallGrassBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new TallGrassBlock(properties));
    }

    public static final RegistryObject<TallGrassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TallGrassBlock(properties), creativeTab);
    }
}
