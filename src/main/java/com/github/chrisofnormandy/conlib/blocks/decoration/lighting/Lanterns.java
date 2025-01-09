package com.github.chrisofnormandy.conlib.blocks.decoration.lighting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Lanterns {

    public static final RegistryObject<LanternBlock> create(String name) {
        return create(name, Properties.copy(Blocks.LANTERN));
    }

    public static final RegistryObject<LanternBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LANTERN), creativeTab);
    }

    public static final RegistryObject<LanternBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new LanternBlock(properties));
    }

    public static final RegistryObject<LanternBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new LanternBlock(properties), creativeTab);
    }
}
