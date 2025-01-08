package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Need custom bush, this only produces sweet berries.

public class Bushes {

    public static final SweetBerryBushBlock create(String name) {
        return create(name, Properties.copy(Blocks.SWEET_BERRY_BUSH));
    }

    public static final SweetBerryBushBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SWEET_BERRY_BUSH), creativeTab);
    }

    public static final SweetBerryBushBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new SweetBerryBushBlock(properties));
    }

    public static final SweetBerryBushBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SweetBerryBushBlock(properties), creativeTab);
    }
}
