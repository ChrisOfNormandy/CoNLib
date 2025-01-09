package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class SeaFoliage {

    public static final RegistryObject<SeagrassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SEAGRASS));
    }

    public static final RegistryObject<SeagrassBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SEAGRASS), creativeTab);
    }

    public static final RegistryObject<SeagrassBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SeagrassBlock(properties));
    }

    public static final RegistryObject<SeagrassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SeagrassBlock(properties), creativeTab);
    }
}
