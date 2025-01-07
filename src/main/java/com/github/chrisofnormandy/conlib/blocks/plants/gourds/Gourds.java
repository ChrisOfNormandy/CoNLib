package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.Gourd;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Gourds {

    public static final Gourd create(String name) {
        Gourd gourd = new Gourd(Properties.copy(Blocks.PUMPKIN));
        return BlockRegistry.register(name, gourd);
    }

    public static final Gourd create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        Gourd gourd = new Gourd(Properties.copy(Blocks.PUMPKIN));
        return BlockRegistry.register(name, gourd, creativeTab);
    }

    public static final Gourd create(String name, Properties properties) {
        Gourd gourd = new Gourd(properties);
        return BlockRegistry.register(name, gourd);
    }

    public static final Gourd create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        Gourd gourd = new Gourd(properties);
        return BlockRegistry.register(name, gourd, creativeTab);
    }

    public static final Gourd create(String name,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds) {
        Gourd gourd = new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds);
        return BlockRegistry.register(name, gourd);
    }

    public static final Gourd create(String name,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds,
            ResourceKey<CreativeModeTab> creativeTab) {
        Gourd gourd = new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds);
        return BlockRegistry.register(name, gourd, creativeTab);
    }

    public static final Gourd create(String name,
            Properties properties,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds) {
        Gourd gourd = new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds);
        return BlockRegistry.register(name, gourd);
    }

    public static final Gourd create(String name,
            Properties properties,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds,
            ResourceKey<CreativeModeTab> creativeTab) {
        Gourd gourd = new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds);
        return BlockRegistry.register(name, gourd, creativeTab);
    }
}
