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
import net.minecraftforge.registries.RegistryObject;

public class Gourds {

    public static final RegistryObject<Gourd> create(String name) {
        return create(name, Properties.copy(Blocks.PUMPKIN));
    }

    public static final RegistryObject<Gourd> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.PUMPKIN), creativeTab);
    }

    public static final RegistryObject<Gourd> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new Gourd(properties));
    }

    public static final RegistryObject<Gourd> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new Gourd(properties), creativeTab);
    }

    public static final RegistryObject<Gourd> create(String name,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds) {
        return BlockRegistry.register(name,
                () -> new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds));
    }

    public static final RegistryObject<Gourd> create(String name,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                () -> new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds),
                creativeTab);
    }

    public static final RegistryObject<Gourd> create(String name,
            Properties properties,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds) {
        return BlockRegistry.register(name,
                () -> new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds));
    }

    public static final RegistryObject<Gourd> create(String name,
            Properties properties,
            Block carvedBlock,
            StemBlock stemBlock,
            AttachedStemBlock attachedStemBlock,
            Item seeds,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                () -> new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds), creativeTab);
    }
}
