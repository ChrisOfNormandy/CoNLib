package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Beam

public class Beacons {

    public static final RegistryObject<BeaconBlock> create(String name) {
        return create(name, Properties.copy(Blocks.BEACON));
    }

    public static final RegistryObject<BeaconBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BEACON), creativeTab);
    }

    public static final RegistryObject<BeaconBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new BeaconBlock(properties));
    }

    public static final RegistryObject<BeaconBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new BeaconBlock(properties), creativeTab);
    }
}
