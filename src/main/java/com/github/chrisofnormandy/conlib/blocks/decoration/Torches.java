package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Torches {
    public static final Block create_torch(String name) {
        return BlockRegistry.register(name, new TorchBlock(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME));
    }

    public static final Block create_torch(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TorchBlock(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME),
                creativeTab);
    }

    public static final Block create_torch(String name, Properties properties, ParticleOptions particle) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle));
    }

    public static final Block create_torch(String name, Properties properties,
            ParticleOptions particle,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle), creativeTab);
    }
}
