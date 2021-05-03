package com.github.chrisofnormandy.conlib.world.layer;

import com.github.chrisofnormandy.conlib.biome.ModClimate;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

public enum ModIslandLayer implements IAreaTransformer2, IDimOffset1Transformer {
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
    public int applyPixel(INoiseRandom context, IArea terrainArea, IArea climateArea, int x,
            int z) {
                int n = terrainArea.get(x + 1, z + 0);
                int e = terrainArea.get(x + 2, z + 1);
                int s = terrainArea.get(x + 1, z + 2);
                int w = terrainArea.get(x + 0, z + 1);
                int c = terrainArea.get(x + 1, z + 1);

                int a = climateArea.get(x, z);

                ModClimate climate;
                
        return 0;
    }
}
