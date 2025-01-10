package com.github.chrisofnormandy.conlib.blocks.landscapes;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class BrushableLand {
    public static final RegistryObject<BrushableBlock> create(String name, Supplier<Block> dustedBlock) {
        return create(name, Properties.copy(Blocks.SAND), dustedBlock);
    }

    public static final RegistryObject<BrushableBlock> create(String name, Supplier<Block> dustedBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SAND), dustedBlock, SoundEvents.BRUSH_SAND,
                SoundEvents.BRUSH_SAND_COMPLETED, creativeTab);
    }

    public static final RegistryObject<BrushableBlock> create(String name, Properties properties,
            Supplier<Block> dustedBlock) {
        return create(name, properties, dustedBlock, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED);
    }

    public static final RegistryObject<BrushableBlock> create(String name, Properties properties,
            Supplier<Block> dustedBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, dustedBlock, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED,
                creativeTab);
    }

    public static final RegistryObject<BrushableBlock> create(String name,
            Properties properties,
            Supplier<Block> dustedBlock,
            SoundEvent dustingSound,
            SoundEvent dustingCompletedSound) {
        return BlockRegistry.register(name,
                () -> new BrushableBlock(dustedBlock.get(), properties, dustingSound, dustingCompletedSound));
    }

    public static final RegistryObject<BrushableBlock> create(String name,
            Properties properties,
            Supplier<Block> dustedBlock,
            SoundEvent dustingSound,
            SoundEvent dustingCompletedSound,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                () -> new BrushableBlock(dustedBlock.get(), properties, dustingSound, dustingCompletedSound),
                creativeTab);
    }
}
