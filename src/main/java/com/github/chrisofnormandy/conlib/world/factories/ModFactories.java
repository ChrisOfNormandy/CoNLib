package com.github.chrisofnormandy.conlib.world.factories;

import java.util.HashMap;
import java.util.function.LongFunction;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.world.generators.GeneratorSettings;
import com.github.chrisofnormandy.conlib.world.layers.ModClimateLayer;
import com.github.chrisofnormandy.conlib.world.layers.RainfallLayer;
import com.github.chrisofnormandy.conlib.world.layers.TemperatureLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModBiomeLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModEdgeBiomeLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModIslandLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModOceanLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModRiverLayer;
import com.github.chrisofnormandy.conlib.world.layers.overworld.ModSubBiomeLayer;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.*;

public class ModFactories {
    public static HashMap<String, Tuple<TemperatureLayer, Long>> temperatureLayers = new HashMap<String, Tuple<TemperatureLayer, Long>>();
    public static HashMap<String, Tuple<RainfallLayer, Long>> rainfallLayers = new HashMap<String, Tuple<RainfallLayer, Long>>();

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> modBiomeFactory(
            IAreaFactory<T> landSeaAreaFactory, IAreaFactory<T> climateAreaFactory, LongFunction<C> contextFactory) {
        IAreaFactory<T> biomeFactory = ModBiomeLayer.INSTANCE.run(contextFactory.apply(200L), landSeaAreaFactory,
                climateAreaFactory);

        biomeFactory = AddBambooForestLayer.INSTANCE.run(contextFactory.apply(1001L), biomeFactory);
        biomeFactory = ModEdgeBiomeLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory);

        biomeFactory = LayerUtil.zoom(1000L, ZoomLayer.NORMAL, biomeFactory, 2, contextFactory);

        return biomeFactory;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> modClimateFactory(
            LongFunction<C> contextFactory, GeneratorSettings settings) {

        // Default will have to be supplied somehow from the settings.
        return ModClimateLayer.INSTANCE.run(contextFactory.apply(103L),
                temperatureLayers.get("default").x.run(contextFactory.apply(temperatureLayers.get("default").y)),
                rainfallLayers.get("default").x.run(contextFactory.apply(rainfallLayers.get("default").y)));
    }

    public static <A extends IArea, B extends IExtendedNoiseRandom<A>> IAreaFactory<A> modWorldFactory(
            LongFunction<B> contextFactory) {

        IAreaFactory<A> factory = IslandLayer.INSTANCE.run(contextFactory.apply(1L));

        factory = ZoomLayer.FUZZY.run(contextFactory.apply(2000L), factory);
        factory = ZoomLayer.NORMAL.run(contextFactory.apply(2001L), factory);
        // factory = ZoomLayer.NORMAL.run(contextFactory.apply(2002L), factory);
        // factory = ZoomLayer.NORMAL.run(contextFactory.apply(2003L), factory);

        factory = RemoveTooMuchOceanLayer.INSTANCE.run(contextFactory.apply(2L), factory);

        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(1L), factory);
        // factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(4L), factory);
        // factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(3L), factory);
        // factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(2L), factory);
        // factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(50L), factory);
        // factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(70L), factory);

        return factory;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createAreaFactories(
            GeneratorSettings settings, LongFunction<C> contextFactory) {

        // These need to be supplied by the settings.
        Integer biomeSize = 4;
        Integer riverSize = biomeSize;

        // net.minecraft.world.gen.layer.AddBambooForestLayer
        // net.minecraft.world.gen.layer.AddIslandLayer
        // net.minecraft.world.gen.layer.AddMushroomIslandLayer
        // net.minecraft.world.gen.layer.AddSnowLayer
        // net.minecraft.world.gen.layer.BiomeLayer
        // net.minecraft.world.gen.layer.DeepOceanLayer
        // net.minecraft.world.gen.layer.EdgeBiomeLayer
        // net.minecraft.world.gen.layer.EdgeLayer
        // net.minecraft.world.gen.layer.HillsLayer
        // net.minecraft.world.gen.layer.IslandLayer
        // net.minecraft.world.gen.layer.MixOceansLayer
        // net.minecraft.world.gen.layer.MixRiverLayer
        // net.minecraft.world.gen.layer.OceanLayer
        // net.minecraft.world.gen.layer.RareBiomeLayer
        // net.minecraft.world.gen.layer.RiverLayer
        // net.minecraft.world.gen.layer.ShoreLayer
        // net.minecraft.world.gen.layer.SmoothLayer

        IAreaFactory<T> worldFactory = modWorldFactory(contextFactory);
        worldFactory = DeepOceanLayer.INSTANCE.run(contextFactory.apply(4L), worldFactory);
        worldFactory = AddMushroomIslandLayer.INSTANCE.run(contextFactory.apply(5L), worldFactory);

        IAreaFactory<T> climateFactory = modClimateFactory(contextFactory, settings);
        worldFactory = ModIslandLayer.INSTANCE.run(contextFactory.apply(5L), worldFactory, climateFactory);

        IAreaFactory<T> biomeFactory = modBiomeFactory(worldFactory, climateFactory, contextFactory);

        IAreaFactory<T> rivSubFactory = LayerUtil.zoom(1000L, ZoomLayer.NORMAL,
                StartRiverLayer.INSTANCE.run(contextFactory.apply(100L), worldFactory), 2, contextFactory);
        biomeFactory = ModSubBiomeLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory, rivSubFactory);

        IAreaFactory<T> riverFactory = SmoothLayer.INSTANCE.run(contextFactory.apply(1000L),
                RiverLayer.INSTANCE.run(contextFactory.apply(1L),
                        LayerUtil.zoom(1000L, ZoomLayer.NORMAL, rivSubFactory, riverSize, contextFactory)));
        biomeFactory = RareBiomeLayer.INSTANCE.run(contextFactory.apply(1001L), biomeFactory);
        biomeFactory = ModRiverLayer.INSTANCE.run(contextFactory.apply(100L),
                SmoothLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory), riverFactory);
        climateFactory = LayerUtil.zoom(2001L, ZoomLayer.NORMAL, climateFactory, biomeSize + 2, contextFactory);

        IAreaFactory<T> oceanFactory = LayerUtil.zoom(2001L, ZoomLayer.NORMAL,
                OceanLayer.INSTANCE.run(contextFactory.apply(2L)), 6, contextFactory);
        biomeFactory = ModOceanLayer.INSTANCE.run(contextFactory.apply(100L), biomeFactory, oceanFactory,
                climateFactory);

        // for (int i = 0; i < biomeSize; ++i) {
        // biomeFactory = ZoomLayer.NORMAL.run(contextFactory.apply((long) (1000 + i)),
        // biomeFactory);

        // if (i == 0) // Only generate Islands
        // biomeFactory = AddIslandLayer.INSTANCE.run(contextFactory.apply(3L),
        // biomeFactory);
        // if (i == 1 || biomeSize == 1) // Include beaches
        // biomeFactory = ModBeachLayer.INSTANCE.run(contextFactory.apply(1000L),
        // biomeFactory);
        // }

        return biomeFactory;
    }
}
