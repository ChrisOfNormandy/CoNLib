package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class TallSeaFoliage {

    public static final RegistryObject<TallSeagrassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.TALL_SEAGRASS));
    }

    public static final RegistryObject<TallSeagrassBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TALL_SEAGRASS), creativeTab);
    }

    public static final RegistryObject<TallSeagrassBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new TallSeagrassBlock(properties));
    }

    public static final RegistryObject<TallSeagrassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TallSeagrassBlock(properties), creativeTab);
    }
}
