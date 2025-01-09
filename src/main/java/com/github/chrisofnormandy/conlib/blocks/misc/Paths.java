package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Custom path definition to define default state when destroyed (dirt)

public class Paths {

    public static final RegistryObject<DirtPathBlock> create(String name) {
        return create(name, Properties.copy(Blocks.DIRT_PATH));
    }

    public static final RegistryObject<DirtPathBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DIRT_PATH), creativeTab);
    }

    public static final RegistryObject<DirtPathBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new DirtPathBlock(properties));
    }

    public static final RegistryObject<DirtPathBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new DirtPathBlock(properties), creativeTab);
    }
}
