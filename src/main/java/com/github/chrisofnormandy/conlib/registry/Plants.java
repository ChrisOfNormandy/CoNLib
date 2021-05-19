package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.block.types.PlantBase;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.PlantType;

public class Plants {
    /**
     * 
     * @param name The generic block name, like "my_plant."
     * @param plantType The type of plant, such as desert, nether or water.
     * @param group The creative tab the item should be grouped in.
     * @return Block
     */
    public static Block registerPlant(String name, PlantType plantType, ItemGroup group) {
        Block.Properties properties = Block.Properties.of(Material.PLANT).sound(SoundType.CROP).strength(0.0F)
                .noCollission();
        return Blocks.register(name, new PlantBase(properties, plantType), group);
    }

    /**
     * 
     * @param name The generic block name, like "my_plant."
     * @param plantType The type of plant, such as desert, nether or water.
     * @return Block
     */
    public static Block registerPlant(String name, PlantType plantType) {
        Block.Properties properties = Block.Properties.of(Material.PLANT).sound(SoundType.CROP).strength(0.0F)
                .noCollission();
        return Blocks.register(name, new PlantBase(properties, plantType));
    }

    /**
     * 
     * @param name The generic crop name, like "my_crop."
     * @param crop The crop block instance.
     * @return Block
     */
    public static Block registerCrop(String name, CropsBlock crop) {
        return Blocks.register(name, crop);
    }
}
