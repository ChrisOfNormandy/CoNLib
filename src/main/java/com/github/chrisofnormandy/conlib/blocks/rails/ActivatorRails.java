package com.github.chrisofnormandy.conlib.blocks.rails;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class ActivatorRails {

    public static final RegistryObject<PoweredRailBlock> create(String name) {
        return create(name, Properties.copy(Blocks.ACTIVATOR_RAIL));
    }

    public static final RegistryObject<PoweredRailBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ACTIVATOR_RAIL), creativeTab);
    }

    public static final RegistryObject<PoweredRailBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new PoweredRailBlock(properties));
    }

    public static final RegistryObject<PoweredRailBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new PoweredRailBlock(properties), creativeTab);
    }
}
