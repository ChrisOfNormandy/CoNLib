package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Brush {

    public static final RegistryObject<DeadBushBlock> create(String name) {
        return create(name, Properties.copy(Blocks.DEAD_BUSH));
    }

    public static final RegistryObject<DeadBushBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DEAD_BUSH), creativeTab);
    }

    public static final RegistryObject<DeadBushBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new DeadBushBlock(properties));
    }

    public static final RegistryObject<DeadBushBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new DeadBushBlock(properties), creativeTab);
    }
}
