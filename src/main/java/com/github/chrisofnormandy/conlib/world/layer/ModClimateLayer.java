package com.github.chrisofnormandy.conlib.world.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum ModClimateLayer implements IAreaTransformer2, IDimOffset0Transformer {
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
    public int applyPixel(INoiseRandom p_215723_1_, IArea p_215723_2_, IArea p_215723_3_, int p_215723_4_,
            int p_215723_5_) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
