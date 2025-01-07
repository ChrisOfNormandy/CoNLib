package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Liquid filled ones...

public class Cauldrons {

    public static final CauldronBlock create(String name) {
        return create(name, Properties.copy(Blocks.CAULDRON));
    }

    public static final CauldronBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAULDRON), creativeTab);
    }

    public static final CauldronBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new CauldronBlock(properties));
    }

    public static final CauldronBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CauldronBlock(properties), creativeTab);
    }
}
