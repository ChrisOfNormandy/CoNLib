package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Beehives {

    public static final BeehiveBlock create(String name) {
        return create(name, Properties.copy(Blocks.BEEHIVE));
    }

    public static final BeehiveBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BEEHIVE), creativeTab);
    }

    public static final BeehiveBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new BeehiveBlock(properties));
    }

    public static final BeehiveBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BeehiveBlock(properties), creativeTab);
    }
}
