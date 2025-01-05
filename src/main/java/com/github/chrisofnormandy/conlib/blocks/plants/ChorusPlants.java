package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ChorusPlants {
    public static final Block create_chorusPlant(String name) {
        return BlockRegistry.register(name, new ChorusPlantBlock(Properties.copy(Blocks.CHORUS_PLANT)));
    }

    public static final Block create_chorusPlant(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChorusPlantBlock(Properties.copy(Blocks.CHORUS_PLANT)), creativeTab);
    }

    public static final Block create_chorusPlant(String name, Properties properties) {
        return BlockRegistry.register(name, new ChorusPlantBlock(properties));
    }

    public static final Block create_chorusPlant(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ChorusPlantBlock(properties), creativeTab);
    }
}
