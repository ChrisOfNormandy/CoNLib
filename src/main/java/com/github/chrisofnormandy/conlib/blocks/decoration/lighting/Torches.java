package com.github.chrisofnormandy.conlib.blocks.decoration.lighting;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Torches {
    public static class StandingTorches {

        public static final RegistryObject<TorchBlock> create(String name) {
            return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);
        }

        public static final RegistryObject<TorchBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, creativeTab);
        }

        public static final RegistryObject<TorchBlock> create(String name, Properties properties) {
            return create(name, properties, ParticleTypes.FLAME);
        }

        public static final RegistryObject<TorchBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, ParticleTypes.FLAME, creativeTab);
        }

        public static final RegistryObject<TorchBlock> create(String name, Properties properties,
                ParticleOptions particle) {
            return BlockRegistry.register(name, () -> new TorchBlock(properties, particle));
        }

        public static final RegistryObject<TorchBlock> create(String name, Properties properties,
                ParticleOptions particle,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new TorchBlock(properties, particle), creativeTab);
        }
    }

    public static class WallTorches {

        public static final RegistryObject<WallTorchBlock> create(String name) {
            return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);
        }

        public static final RegistryObject<WallTorchBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, creativeTab);
        }

        public static final RegistryObject<WallTorchBlock> create(String name, Properties properties) {
            return create(name, properties, ParticleTypes.FLAME);
        }

        public static final RegistryObject<WallTorchBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, ParticleTypes.FLAME, creativeTab);
        }

        public static final RegistryObject<WallTorchBlock> create(String name, Properties properties,
                ParticleOptions particle) {
            return BlockRegistry.register(name, () -> new WallTorchBlock(properties, particle));
        }

        public static final RegistryObject<WallTorchBlock> create(String name, Properties properties,
                ParticleOptions particle,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new WallTorchBlock(properties, particle), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<TorchBlock>, RegistryObject<WallTorchBlock>> create(String name) {
        var standing = StandingTorches.create(name);
        var wall = WallTorches.create("wall_" + name);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<RegistryObject<TorchBlock>, RegistryObject<WallTorchBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingTorches.create(name, creativeTab);
        var wall = WallTorches.create("wall_" + name);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<RegistryObject<TorchBlock>, RegistryObject<WallTorchBlock>> create(String name,
            Properties properties) {
        var standing = StandingTorches.create(name, properties);
        var wall = WallTorches.create("wall_" + name, properties);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<RegistryObject<TorchBlock>, RegistryObject<WallTorchBlock>> create(String name,
            Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingTorches.create(name, properties, creativeTab);
        var wall = WallTorches.create("wall_" + name, properties);

        return new Tuple<>(standing, wall);
    }
}
