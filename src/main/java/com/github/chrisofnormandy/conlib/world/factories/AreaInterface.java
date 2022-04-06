package com.github.chrisofnormandy.conlib.world.factories;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;

public interface AreaInterface<T extends IArea> extends IExtendedNoiseRandom<T> {
    Long getWorldSeed();
}
