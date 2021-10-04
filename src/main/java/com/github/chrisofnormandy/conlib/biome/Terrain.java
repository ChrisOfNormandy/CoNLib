package com.github.chrisofnormandy.conlib.biome;

import java.util.Random;

import com.github.chrisofnormandy.conlib.registry.WorldGenRegistry;
import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Terrain {
    public Double frequency = 1.0D;

    Surface surface;
    // At some point allowing more than one surface config should be implemented.
    // HashMap<Double, SurfaceBuilderConfig> surfaces = new HashMap<Double,
    // SurfaceBuilderConfig>();
    SurfaceBuilderConfig primary;
    SurfaceBuilderConfig secondary;

    ConfiguredSurfaceBuilder<?> builder;

    /**
     * 
     * @param name
     * @param primary
     * @param secondary
     * @param limit
     * @return
     */
    public Surface registerSurface(String name, SurfaceBuilderConfig primary, SurfaceBuilderConfig secondary,
            Double limit) {
        this.primary = primary;
        this.secondary = secondary;

        Surface s = new Surface(SurfaceBuilderConfig.CODEC.stable(), limit);

        s.primary = primary;
        s.secondary = secondary;

        return WorldGenRegistry.registerSurfaceBuilder(name, s);
    }

    /**
     * 
     * @param name
     * @param surface
     * @param config
     * @return
     */
    public ConfiguredSurfaceBuilder registerConfiguredSurface(String name, Surface surface,
            SurfaceBuilderConfig config) {
        return WorldGenRegistry.registerConfiguredSurfaceBuilder(name, new ConfiguredSurfaceBuilder(surface, config));
    }

    /**
     * 
     * @param name
     * @param primary
     * @param secondary
     * @param limit
     */
    public Terrain(String name, SurfaceBuilderConfig primary, SurfaceBuilderConfig secondary, Double limit) {
        this.surface = registerSurface(name, primary, secondary, limit);
        this.builder = registerConfiguredSurface(name, this.surface, this.primary);
    }

    /**
     * 
     */
    public class Surface extends SurfaceBuilder<SurfaceBuilderConfig> {
        SurfaceBuilderConfig primary;
        SurfaceBuilderConfig secondary;

        Double limit;

        public Surface(Codec<SurfaceBuilderConfig> codec, Double limit) {
            super(codec);
            this.limit = limit;
        }

        @Override
        public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed,
                SurfaceBuilderConfig config) {

            if (noise <= this.limit)
                SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                        defaultFluid, seaLevel, seed, primary);
            else
                SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                        defaultFluid, seaLevel, seed, secondary);
        }
    }
}
