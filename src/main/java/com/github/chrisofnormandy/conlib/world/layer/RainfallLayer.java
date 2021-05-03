package com.github.chrisofnormandy.conlib.world.layer;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.world.factories.AreaInterface;
import com.github.chrisofnormandy.conlib.world.transformers.AreaTransformer0;

public class RainfallLayer implements AreaTransformer0 {

    Double scale;

    Long seed;
    Tuple<Double, Double> offset;

    public RainfallLayer(Double scale) {
        this.scale = scale;
    }

    @Override
    public int applyPixel(AreaInterface<?> context, Integer x, Integer z) {
        // TODO Auto-generated method stub
        return 0;
    }
}
