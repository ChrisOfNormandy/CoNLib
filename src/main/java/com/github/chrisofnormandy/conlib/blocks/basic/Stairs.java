package com.github.chrisofnormandy.conlib.blocks.basic;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Stairs {

    public static final RegistryObject<StairBlock> create(String name) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS), () -> Blocks.STONE);
    }

    public static final RegistryObject<StairBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS), () -> Blocks.STONE, creativeTab);
    }

    public static final RegistryObject<StairBlock> create(String name, Supplier<Block> sourceBlock) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS), sourceBlock);
    }

    public static final RegistryObject<StairBlock> create(String name, Supplier<Block> sourceBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.STONE_STAIRS), sourceBlock, creativeTab);
    }

    public static final RegistryObject<StairBlock> create(String name, Properties properties,
            Supplier<Block> sourceBlock) {
        return BlockRegistry.register(name,
                () -> new StairBlock(() -> sourceBlock.get().defaultBlockState(), properties));
    }

    public static final RegistryObject<StairBlock> create(String name, Properties properties,
            Supplier<Block> sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                () -> new StairBlock(() -> sourceBlock.get().defaultBlockState(), properties),
                creativeTab);
    }
}
