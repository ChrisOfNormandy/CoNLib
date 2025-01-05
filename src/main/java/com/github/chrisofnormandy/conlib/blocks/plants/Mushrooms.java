package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Mushrooms {
    public static final Block create_mushroom(String name) {
        return BlockRegistry.register(name,
                new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM));
    }

    public static final Block create_mushroom(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM), creativeTab);
    }

    public static final Block create_mushroom(String name, Properties properties) {
        return BlockRegistry.register(name, new MushroomBlock(properties, TreeFeatures.HUGE_RED_MUSHROOM));
    }

    public static final Block create_mushroom(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new MushroomBlock(properties, TreeFeatures.HUGE_RED_MUSHROOM), creativeTab);
    }
}
