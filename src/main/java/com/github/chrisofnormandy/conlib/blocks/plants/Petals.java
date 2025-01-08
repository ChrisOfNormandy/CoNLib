package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Petals {

    public static final PinkPetalsBlock create(String name) {
        return create(name, Properties.copy(Blocks.PINK_PETALS));
    }

    public static final PinkPetalsBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.PINK_PETALS), creativeTab);
    }

    public static final PinkPetalsBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new PinkPetalsBlock(properties));
    }

    public static final PinkPetalsBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PinkPetalsBlock(properties), creativeTab);
    }
}
