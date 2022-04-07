package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.PlantBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.PlantType;

public class PlantRegistry {
    /**
     * 
     * @param name
     * @param plantType
     * @param group
     * @return
     */
    public static final Block registerPlant(String name, PlantType plantType, CreativeModeTab group) {
        Block.Properties properties = Block.Properties.of(net.minecraft.world.level.material.Material.PLANT)
                .sound(SoundType.CROP).strength(0.0F)
                .noCollission();
        return BlockRegistry.register(name, new PlantBase(properties, plantType), group);
    }

    /**
     * 
     * @param name
     * @param plantType
     * @return
     */
    public static final Block registerPlant(String name, PlantType plantType) {
        Block.Properties properties = Block.Properties.of(Material.PLANT).sound(SoundType.CROP).strength(0.0F)
                .noCollission();
        return BlockRegistry.register(name, new PlantBase(properties, plantType));
    }

    /**
     * 
     * @param name
     * @param crop
     * @return
     */
    public static final Block registerCrop(String name, CropBlock crop) {
        return BlockRegistry.register(name, crop);
    }
}
