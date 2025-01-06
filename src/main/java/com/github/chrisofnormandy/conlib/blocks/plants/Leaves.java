package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Leaves {
    public static final LeavesBlock create(String name) {
        return create(name, Properties.copy(Blocks.OAK_LEAVES));
    }

    public static final LeavesBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_LEAVES), creativeTab);
    }

    public static final LeavesBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new LeavesBlock(properties));
    }

    public static final LeavesBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LeavesBlock(properties), creativeTab);
    }
}
