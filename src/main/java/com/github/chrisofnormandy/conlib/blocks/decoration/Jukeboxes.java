package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Jukeboxes {

    public static final JukeboxBlock create(String name) {
        return create(name, Properties.copy(Blocks.JUKEBOX));
    }

    public static final JukeboxBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.JUKEBOX), creativeTab);
    }

    public static final JukeboxBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new JukeboxBlock(properties));
    }

    public static final JukeboxBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new JukeboxBlock(properties), creativeTab);
    }
}
