package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NyliumLand {

    public static final NyliumBlock create(String name) {
        return create(name, Properties.copy(Blocks.WARPED_NYLIUM));
    }

    public static final NyliumBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WARPED_NYLIUM), creativeTab);
    }

    public static final NyliumBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new NyliumBlock(properties));
    }

    public static final NyliumBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new NyliumBlock(properties), creativeTab);
    }
}
