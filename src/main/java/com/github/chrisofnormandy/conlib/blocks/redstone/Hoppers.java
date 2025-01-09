package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Hoppers {

    public static final RegistryObject<HopperBlock> create(String name) {
        return create(name, Properties.copy(Blocks.HOPPER));
    }

    public static final RegistryObject<HopperBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.HOPPER), creativeTab);
    }

    public static final RegistryObject<HopperBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new HopperBlock(properties));
    }

    public static final RegistryObject<HopperBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new HopperBlock(properties), creativeTab);
    }
}
