package com.github.chrisofnormandy.conlib.husbandry;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FrogspawnBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Needs custom implementation...

public class WaterEggs {

    public static final FrogspawnBlock create(String name) {
        return create(name, Properties.copy(Blocks.FROGSPAWN));
    }

    public static final FrogspawnBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FROGSPAWN), creativeTab);
    }

    public static final FrogspawnBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new FrogspawnBlock(properties));
    }

    public static final FrogspawnBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FrogspawnBlock(properties), creativeTab);
    }
}
