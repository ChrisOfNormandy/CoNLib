package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Pots {

    public static final RegistryObject<DecoratedPotBlock> create(String name) {
        return create(name, Properties.copy(Blocks.DECORATED_POT));
    }

    public static final RegistryObject<DecoratedPotBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DECORATED_POT), creativeTab);
    }

    public static final RegistryObject<DecoratedPotBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new DecoratedPotBlock(properties));
    }

    public static final RegistryObject<DecoratedPotBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new DecoratedPotBlock(properties), creativeTab);
    }
}
