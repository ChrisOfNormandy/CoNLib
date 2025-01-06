package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Torches {
    public static final TorchBlock create(String name) {
        return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);
    }

    public static final TorchBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, creativeTab);
    }

    public static final TorchBlock create(String name, Properties properties) {
        return create(name, properties, ParticleTypes.FLAME);
    }

    public static final TorchBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, ParticleTypes.FLAME, creativeTab);
    }

    public static final TorchBlock create(String name, Properties properties, ParticleOptions particle) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle));
    }

    public static final TorchBlock create(String name, Properties properties,
            ParticleOptions particle,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle), creativeTab);
    }
}
