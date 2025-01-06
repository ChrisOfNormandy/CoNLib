package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Beds {

    public static final BedBlock create(String name) {
        return create(name, DyeColor.WHITE, Properties.copy(Blocks.WHITE_BED));
    }

    public static final BedBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, DyeColor.WHITE, Properties.copy(Blocks.WHITE_BED), creativeTab);
    }

    public static final BedBlock create(String name, DyeColor color) {
        return create(name, color, Properties.copy(Blocks.WHITE_BED));
    }

    public static final BedBlock create(String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, color, Properties.copy(Blocks.WHITE_BED), creativeTab);
    }

    public static final BedBlock create(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new BedBlock(color, properties));
    }

    public static final BedBlock create(String name, DyeColor color, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BedBlock(color, properties), creativeTab);
    }
}
