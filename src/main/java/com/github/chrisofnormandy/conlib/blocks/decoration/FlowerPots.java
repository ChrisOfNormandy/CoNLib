package com.github.chrisofnormandy.conlib.blocks.decoration;

import java.util.ArrayList;
import java.util.List;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlowerPots {
    @SuppressWarnings("null")
    public static Block create_emptyPot(String name) {
        return BlockRegistry.register(name,
                new FlowerPotBlock(null, () -> Blocks.AIR, Properties.copy(Blocks.FLOWER_POT)));
    }

    @SuppressWarnings("null")
    public static Block create_emptyPot(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new FlowerPotBlock(null, () -> Blocks.AIR, Properties.copy(Blocks.FLOWER_POT)), creativeTab);
    }

    @SuppressWarnings("null")
    public static Block create_flowerPot(String name, Block flower) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, Properties.copy(Blocks.FLOWER_POT)));
    }

    @SuppressWarnings("null")
    public static Block create_flowerPot(String name, Block flower, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, Properties.copy(Blocks.FLOWER_POT)),
                creativeTab);
    }

    @SuppressWarnings("null")
    public static Block create_emptyPot(String name, Properties properties) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties));
    }

    @SuppressWarnings("null")
    public static Block create_emptyPot(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties), creativeTab);
    }

    @SuppressWarnings("null")
    public static Block create_flowerPot(String name, Block flower, Properties properties) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties));
    }

    @SuppressWarnings("null")
    public static Block create_flowerPot(String name, Block flower, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties), creativeTab);
    }

    public static List<Block> create_flowerPotsFromList(String name, List<Block> flowers) {
        List<Block> pots = new ArrayList<Block>();

        flowers.forEach((Block flower) -> pots.add(create_flowerPot(name, flower, Properties.copy(Blocks.FLOWER_POT))));

        return pots;
    }

    public static List<Block> create_flowerPotsFromList(String name, List<Block> flowers, Properties properties) {
        List<Block> pots = new ArrayList<Block>();

        flowers.forEach((Block flower) -> pots.add(create_flowerPot(name, flower, properties)));

        return pots;
    }
}
