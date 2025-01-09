package com.github.chrisofnormandy.conlib.blocks.plants.leaves;

import com.github.chrisofnormandy.conlib.blocks.plants.leaves.types.CustomLeaves;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Leaves {

    public static final RegistryObject<CustomLeaves> create(String name) {
        return create(name, Properties.copy(Blocks.OAK_LEAVES));
    }

    public static final RegistryObject<CustomLeaves> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_LEAVES), creativeTab);
    }

    public static final RegistryObject<CustomLeaves> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new CustomLeaves(properties));
    }

    public static final RegistryObject<CustomLeaves> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CustomLeaves(properties), creativeTab);
    }

    // Adding particles makes the leaves like cherry blossom leaves instead of
    // defaults.

    public static final RegistryObject<CustomLeaves> create(String name, Properties properties,
            ParticleOptions particles) {
        return BlockRegistry.register(name, () -> new CustomLeaves(properties, particles));
    }

    public static final RegistryObject<CustomLeaves> create(String name, Properties properties,
            ParticleOptions particles,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CustomLeaves(properties, particles), creativeTab);
    }
}
