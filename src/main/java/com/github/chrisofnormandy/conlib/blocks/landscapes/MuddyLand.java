package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class MuddyLand {

    public static final MudBlock create(String name) {
        return create(name, Properties.copy(Blocks.MUD));
    }

    public static final MudBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.MUD), creativeTab);
    }

    public static final MudBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new MudBlock(properties));
    }

    public static final MudBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new MudBlock(properties), creativeTab);
    }
}
