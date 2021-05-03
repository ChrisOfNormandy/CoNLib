package com.github.chrisofnormandy.conlib.world.transformers;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.traits.IDimTransformer;

public interface AreaTransformer3 extends IDimTransformer {
    default <R extends IArea> IAreaFactory<R> run(IExtendedNoiseRandom<R> context, IAreaFactory<R> areaFactory1,
            IAreaFactory<R> areaFactory2, IAreaFactory<R> areaFactory3) {
        return () -> {
            R area1 = areaFactory1.make();
            R area2 = areaFactory2.make();
            R area3 = areaFactory3.make();

            return context.createResult((x, z) -> {
                context.initRandom((long) x, (long) z);
                return this.applyPixel(context, area1, area2, area3, x, z);
            });
        };
    }

    int applyPixel(INoiseRandom context, IArea area1, IArea area2, IArea area3, int x, int z);
}