package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlastFurnaces {

    public static final BlastFurnaceBlock create(String name) {
        return create(name, Properties.copy(Blocks.BLAST_FURNACE));
    }

    public static final BlastFurnaceBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BLAST_FURNACE), creativeTab);
    }

    public static final BlastFurnaceBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(properties));
    }

    public static final BlastFurnaceBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(properties), creativeTab);
    }
}
