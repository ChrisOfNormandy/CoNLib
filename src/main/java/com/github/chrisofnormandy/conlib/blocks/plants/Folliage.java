package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Folliage {

    public static class Tall {
        public static final Block create_tallGrass(String name) {
            return BlockRegistry.register(name, new TallGrassBlock(Properties.copy(Blocks.TALL_GRASS)));
        }

        public static final Block create_tallGrass(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TallGrassBlock(Properties.copy(Blocks.TALL_GRASS)), creativeTab);
        }

        public static final Block create_tallGrass(String name, Properties properties) {
            return BlockRegistry.register(name, new TallGrassBlock(properties));
        }

        public static final Block create_tallGrass(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TallGrassBlock(properties), creativeTab);
        }
    }

    public static final Block create_foliage(String name) {
        return BlockRegistry.register(name, new GrassBlock(Properties.copy(Blocks.GRASS)));
    }

    public static final Block create_foliage(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GrassBlock(Properties.copy(Blocks.GRASS)), creativeTab);
    }

    public static final Block create_foliage(String name, Properties properties) {
        return BlockRegistry.register(name, new GrassBlock(properties));
    }

    public static final Block create_foliage(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GrassBlock(properties), creativeTab);
    }
}
