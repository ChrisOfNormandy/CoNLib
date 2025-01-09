package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Furnaces {

    public static final RegistryObject<FurnaceBlock> create(String name) {
        return create(name, Properties.copy(Blocks.FURNACE));
    }

    public static final RegistryObject<FurnaceBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FURNACE), creativeTab);
    }

    public static final RegistryObject<FurnaceBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new FurnaceBlock(properties));
    }

    public static final RegistryObject<FurnaceBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new FurnaceBlock(properties), creativeTab);
    }
}
