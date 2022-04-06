package com.github.chrisofnormandy.conlib.world.layers;

import java.util.Random;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.common.Noise;
import com.github.chrisofnormandy.conlib.world.factories.AreaInterface;
import com.github.chrisofnormandy.conlib.world.transformers.AreaTransformer0;

public class TemperatureLayer implements AreaTransformer0 {

    Long seed;
    Tuple<Double, Double> offset;

    Double frequency = 1d;
    Integer height = 9;
    Double power = 1d;

    public TemperatureLayer(Double frequency) {
        this.frequency = frequency;
    }

    public TemperatureLayer(Double frequency, Double power) {
        this.frequency = frequency;
        this.power = power;
    }

    public TemperatureLayer(Double frequency, Integer height, Double power) {
        this.frequency = frequency;
        this.height = height;
        this.power = power;
    }

    @Override
    public int applyPixel(AreaInterface<?> context, Integer x, Integer z) {
        long seed = context.getWorldSeed();

        if (this.seed != seed) {
            Random random = new Random(seed + 123);
            this.offset = new Tuple<Double, Double>((random.nextDouble() - 0.5) * 8192,
                    (random.nextDouble() - 0.5) * 8192);
            this.seed = seed;
        }

        Double n = (Noise.noise((x + this.offset.x) * this.frequency, 0, (z + this.offset.y) * this.frequency) + 1)
                * 0.5;
        n = this.height * Math.pow(n, this.power);

        return (int) (n % this.height);
    }
}
