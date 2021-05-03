package com.github.chrisofnormandy.conlib.world.generator;

import java.util.HashMap;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.world.factories.ModFactories;
import com.github.chrisofnormandy.conlib.world.layer.RainfallLayer;
import com.github.chrisofnormandy.conlib.world.layer.TemperatureLayer;

public class GeneratorSettings {
    HashMap<String, ModGenerator> generators = new HashMap<String, ModGenerator>();

    public GeneratorSettings() {
        generators.put("temperature", new ModGenerator());
        generators.get("temperature").add("default", 0);
        TemperatureLayer temp = new TemperatureLayer(1.0d);
        ModFactories.temperatureLayers.put("default", new Tuple<TemperatureLayer, Long>(temp, 0l));

        generators.put("rainfall", new ModGenerator());
        generators.get("rainfall").add("default", 0);
        RainfallLayer rain = new RainfallLayer(1.0d);
        ModFactories.rainfallLayers.put("default", new Tuple<RainfallLayer, Long>(rain, 0l));
    }

    public ModGenerator getGenerator(String name) {
        return generators.get(name);
    }
}
