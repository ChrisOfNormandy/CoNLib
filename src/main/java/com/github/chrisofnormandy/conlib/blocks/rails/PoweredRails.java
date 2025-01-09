package com.github.chrisofnormandy.conlib.blocks.rails;

import com.github.chrisofnormandy.conlib.blocks.rails.types.PoweredRailsBase;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class PoweredRails {

    public static final RegistryObject<PoweredRailsBase> create(String name) {
        return create(name, Properties.copy(Blocks.POWERED_RAIL));
    }

    public static final RegistryObject<PoweredRailsBase> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.POWERED_RAIL), creativeTab);
    }

    public static final RegistryObject<PoweredRailsBase> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new PoweredRailsBase(properties));
    }

    public static final RegistryObject<PoweredRailsBase> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new PoweredRailsBase(properties), creativeTab);
    }
}
