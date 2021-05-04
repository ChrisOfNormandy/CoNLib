package com.github.chrisofnormandy.conlib.world.layers;

import com.github.chrisofnormandy.conlib.biome.ModClimate;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum ModClimateLayer implements IAreaTransformer2, IDimOffset0Transformer {
    INSTANCE;

    int[] map = new int[9 * 12];

    ModClimateLayer() {
        ModRegister.climates.values().forEach((ModClimate climate) -> {
            map[climate.temperature * 9 + climate.rainfall] = climate.type.ordinal();
        });

        int current = map[0] > 0 ? map[0] : 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > current)
                current = map[i];
            map[i] = current;
        }
    }

    // @Override
    // public int getParentX(int p_215721_1_) {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    // @Override
    // public int getParentY(int p_215722_1_) {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    @Override
    public int applyPixel(INoiseRandom context, IArea temp, IArea rain, int x, int z) {
    int temperature = temp.get(x, z); // 0 - 8
    int rainfall = rain.get(x, z); // 0 - 11
    
    int index = ( MathHelper.clamp(temperature, 0, 8) * 12 ) + MathHelper.clamp(rainfall, 0, 11);
        return this.map[index];
    }
}