package com.github.chrisofnormandy.conlib.world.factories;

import java.util.HashMap;
import java.util.function.LongFunction;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.world.generator.GeneratorSettings;
import com.github.chrisofnormandy.conlib.world.layer.ModBeachLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModBiomeLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModClimateLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModEdgeBiomeLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModIslandLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModOceanLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModRiverLayer;
import com.github.chrisofnormandy.conlib.world.layer.ModSubBiomeLayer;
import com.github.chrisofnormandy.conlib.world.layer.RainfallLayer;
import com.github.chrisofnormandy.conlib.world.layer.TemperatureLayer;

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
        factory = ZoomLayer.NORMAL.run(contextFactory.apply(2002L), factory);
        factory = ZoomLayer.NORMAL.run(contextFactory.apply(2003L), factory);

        factory = RemoveTooMuchOceanLayer.INSTANCE.run(contextFactory.apply(2L), factory);

        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(1L), factory);
        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(4L), factory);
        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(3L), factory);
        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(2L), factory);
        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(50L), factory);
        factory = AddIslandLayer.INSTANCE.run(contextFactory.apply(70L), factory);

        return factory;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createAreaFactories(
            GeneratorSettings settings, LongFunction<C> contextFactory) {

                // These need to be supplied by the settings.
                Integer biomeSize = 4;
                Integer riverSize = biomeSize;

        // Land stuff
        IAreaFactory<T> worldFactory = modWorldFactory(contextFactory);

        // Water stuff
        IAreaFactory<T> oceanFactory = LayerUtil.zoom(2001L, ZoomLayer.NORMAL, OceanLayer.INSTANCE.run(contextFactory.apply(2L)), 6, contextFactory);
        worldFactory = DeepOceanLayer.INSTANCE.run(contextFactory.apply(4L), worldFactory);

        // Climate stuff
        IAreaFactory<T> climateFactory = modClimateFactory(contextFactory, settings);

        // Shroom Islands
        worldFactory = AddMushroomIslandLayer.INSTANCE.run(contextFactory.apply(5L), worldFactory);

        // Islands
        worldFactory = ModIslandLayer.INSTANCE.run(contextFactory.apply(5L), worldFactory, climateFactory);

        // Biomes
        IAreaFactory<T> biomeFactory = modBiomeFactory(worldFactory, climateFactory, contextFactory);

        // Rivers + SubBiomes
        IAreaFactory<T> rivSubFactory = LayerUtil.zoom(1000L, ZoomLayer.NORMAL, StartRiverLayer.INSTANCE.run(contextFactory.apply(100L),
                worldFactory), 2,
                contextFactory);

        biomeFactory = ModSubBiomeLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory,
                rivSubFactory);

        // Rivers only
        IAreaFactory<T> riverFactory = SmoothLayer.INSTANCE.run(contextFactory.apply(1000L), RiverLayer.INSTANCE.run(contextFactory.apply(1L), LayerUtil.zoom(1000L, ZoomLayer.NORMAL, rivSubFactory,
        riverSize, contextFactory)));

        // Rare biomes
        biomeFactory = RareBiomeLayer.INSTANCE.run(contextFactory.apply(1001L), biomeFactory);

        for (int i = 0; i < biomeSize; ++i) {
            biomeFactory = ZoomLayer.NORMAL.run(contextFactory.apply((long) (1000 + i)), biomeFactory);
            
            if (i == 0) // Only generate Islands
                biomeFactory = AddIslandLayer.INSTANCE.run(contextFactory.apply(3L), biomeFactory);
            if (i == 1 || biomeSize == 1) // Include beaches
                biomeFactory = ModBeachLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory);
        }

        biomeFactory = ModRiverLayer.INSTANCE.run(contextFactory.apply(100L), SmoothLayer.INSTANCE.run(contextFactory.apply(1000L), biomeFactory), riverFactory);

        climateFactory = LayerUtil.zoom(2001L, ZoomLayer.NORMAL, climateFactory, biomeSize + 2, contextFactory);

        biomeFactory = ModOceanLayer.INSTANCE.run(contextFactory.apply(100L), biomeFactory, oceanFactory,
                climateFactory);
                
        return biomeFactory;
    }
}
