package com.github.chrisofnormandy.conlib.world.layers;

import com.github.chrisofnormandy.conlib.world.factories.ContextFactory;
import com.github.chrisofnormandy.conlib.world.factories.ModFactories;
import com.github.chrisofnormandy.conlib.world.generators.GeneratorSettings;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.Layer;

public class LayerHelper {
    public static Layer createLayer(long seed, GeneratorSettings settings) {
        return new Layer(ModFactories.createAreaFactories(settings, (seedModifier) -> {
            return new ContextFactory(1, seed, seedModifier);
        }));
    }

    public interface AreaInterface<T extends IArea> extends IExtendedNoiseRandom<T> {
        Long getWorldSeed();
    }
}