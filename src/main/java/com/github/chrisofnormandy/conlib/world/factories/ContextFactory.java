package com.github.chrisofnormandy.conlib.world.factories;

import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.LazyArea;

public class ContextFactory extends LazyAreaLayerContext implements AreaInterface<LazyArea> {
    Long seed;

    public ContextFactory(int p_i51285_1_, long seed, long p_i51285_4_) {
        super(p_i51285_1_, seed, p_i51285_4_);
        this.seed = seed;
    }

    @Override
    public Long getWorldSeed() {
        return this.seed;
    }
}