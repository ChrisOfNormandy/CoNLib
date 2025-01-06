package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DaylightDetectorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DaylightDetectors {

    public static final DaylightDetectorBlock create(String name) {
        return create(name, Properties.copy(Blocks.DAYLIGHT_DETECTOR));
    }

    public static final DaylightDetectorBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DAYLIGHT_DETECTOR), creativeTab);
    }

    public static final DaylightDetectorBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(properties));
    }

    public static final DaylightDetectorBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(properties), creativeTab);
    }
}
