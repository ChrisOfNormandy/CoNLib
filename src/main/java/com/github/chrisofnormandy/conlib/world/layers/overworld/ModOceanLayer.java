package com.github.chrisofnormandy.conlib.world.layers.overworld;

import com.github.chrisofnormandy.conlib.world.transformers.AreaTransformer3;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum ModOceanLayer implements AreaTransformer3, IDimOffset0Transformer {
    INSTANCE;

    @Override
    public int getParentX(int p_215721_1_) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getParentY(int p_215722_1_) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int applyPixel(INoiseRandom context, IArea area1, IArea area2, IArea area3, int x, int z) {
        // TODO Auto-generated method stub
        return 0;
    }
}