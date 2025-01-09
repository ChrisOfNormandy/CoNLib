package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Lily {

    public static final RegistryObject<WaterlilyBlock> create(String name) {
        return create(name, Properties.copy(Blocks.LILY_PAD));
    }

    public static final RegistryObject<WaterlilyBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LILY_PAD), creativeTab);
    }

    public static final RegistryObject<WaterlilyBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new WaterlilyBlock(properties));
    }

    public static final RegistryObject<WaterlilyBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new WaterlilyBlock(properties), creativeTab);
    }
}
