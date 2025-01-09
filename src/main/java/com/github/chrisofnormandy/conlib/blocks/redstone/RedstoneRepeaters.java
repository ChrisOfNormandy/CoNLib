package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class RedstoneRepeaters {

    public static final RegistryObject<RepeaterBlock> create(String name) {
        return create(name, Properties.copy(Blocks.REPEATER));
    }

    public static final RegistryObject<RepeaterBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.REPEATER), creativeTab);
    }

    public static final RegistryObject<RepeaterBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new RepeaterBlock(properties));
    }

    public static final RegistryObject<RepeaterBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new RepeaterBlock(properties), creativeTab);
    }
}
