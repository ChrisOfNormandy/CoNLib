package com.github.chrisofnormandy.conlib.blocks.decoration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlowerPots {
    public static class PotWithFlower {
        public static FlowerPotBlock create(String name, Block flower) {
            return create(name, Properties.copy(Blocks.FLOWER_POT), flower);
        }

        public static FlowerPotBlock create(String name, Block flower, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.FLOWER_POT), flower, creativeTab);
        }

        // Can't use "create" methods here because null is allowed for creative tabs.

        public static FlowerPotBlock create(String name, Properties properties, Block flower) {
            return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties));
        }

        public static FlowerPotBlock create(String name, Properties properties, Block flower,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties), creativeTab);
        }

        public static FlowerPotBlock create(String name, Properties properties, Block flower,
                @Nullable Supplier<FlowerPotBlock> emptyPot) {
            return BlockRegistry.register(name, new FlowerPotBlock(emptyPot, () -> flower, properties));
        }

        public static FlowerPotBlock create(String name, Properties properties, Block flower,
                @Nullable Supplier<FlowerPotBlock> emptyPot,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new FlowerPotBlock(emptyPot, () -> flower, properties));
        }

        public static List<FlowerPotBlock> create(String name, List<Block> flowers) {
            List<FlowerPotBlock> pots = new ArrayList<FlowerPotBlock>();

            flowers.forEach(
                    (Block flower) -> pots.add(create(name, Properties.copy(Blocks.FLOWER_POT), flower)));

            return pots;
        }

        public static List<FlowerPotBlock> create(String name, List<Block> flowers, Properties properties) {
            List<FlowerPotBlock> pots = new ArrayList<FlowerPotBlock>();

            flowers.forEach((Block flower) -> pots.add(create(name, properties, flower)));

            return pots;
        }
    }

    public static FlowerPotBlock create(String name) {
        return create(name, Properties.copy(Blocks.FLOWER_POT));
    }

    public static FlowerPotBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FLOWER_POT), creativeTab);
    }

    public static FlowerPotBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties));
    }

    public static FlowerPotBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties), creativeTab);
    }
}
