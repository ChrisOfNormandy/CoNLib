package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CryingObsidianBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Crying {

    public static final CryingObsidianBlock create(String name) {
        return create(name, Properties.copy(Blocks.CRYING_OBSIDIAN));
    }

    public static final CryingObsidianBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CRYING_OBSIDIAN), creativeTab);
    }

    public static final CryingObsidianBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new CryingObsidianBlock(properties));
    }

    public static final CryingObsidianBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CryingObsidianBlock(properties), creativeTab);
    }
}
