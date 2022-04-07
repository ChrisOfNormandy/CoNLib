package com.github.chrisofnormandy.conlib.block.types;

import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.common.PlantType;

public class PlantBase extends BushBlock {
    private PlantType plantType;

    /**
     * 
     * @param properties
     * @param plantType
     */
    public PlantBase(Properties properties, PlantType plantType) {
        super(properties);
        this.plantType = plantType;
    }
}