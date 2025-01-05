package com.github.chrisofnormandy.conlib.blocks.rails;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DetectorRailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DetectorRails {
    public static final Block create_detectorRail(String name) {
        return BlockRegistry.register(name, new DetectorRailBlock(Properties.copy(Blocks.DETECTOR_RAIL)));
    }

    public static final Block create_detectorRail(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DetectorRailBlock(Properties.copy(Blocks.DETECTOR_RAIL)), creativeTab);
    }

    public static final Block create_detectorRail(String name, Properties properties) {
        return BlockRegistry.register(name, new DetectorRailBlock(properties));
    }

    public static final Block create_detectorRail(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DetectorRailBlock(properties), creativeTab);
    }
}
