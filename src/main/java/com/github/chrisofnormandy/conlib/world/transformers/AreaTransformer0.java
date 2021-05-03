package com.github.chrisofnormandy.conlib.world.transformers;

import com.github.chrisofnormandy.conlib.world.factories.AreaInterface;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IAreaFactory;

public interface AreaTransformer0 {
    default <T extends IArea> IAreaFactory<T> run(IExtendedNoiseRandom<T> context)
    {
        AreaInterface<T> ctx = (AreaInterface<T>)context;

        return () -> context.createResult((x, z) -> {
                context.initRandom((long)(x), (long)(z));
                return this.applyPixel(ctx, x, z);
            });
    }

    int applyPixel(AreaInterface<?> context, Integer x, Integer z);
}
