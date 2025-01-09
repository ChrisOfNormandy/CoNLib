package com.github.chrisofnormandy.conlib.blocks.fluids;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Ice {

    public static final RegistryObject<CustomIce> create(String name) {
        return create(name, Properties.copy(Blocks.ICE));
    }

    public static final RegistryObject<CustomIce> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ICE), creativeTab);
    }

    public static final RegistryObject<CustomIce> create(String name, Block meltedBlock) {
        return create(name, Properties.copy(Blocks.ICE), meltedBlock);
    }

    public static final RegistryObject<CustomIce> create(String name, Block meltedBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ICE), meltedBlock, creativeTab);
    }

    public static final RegistryObject<CustomIce> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new CustomIce(properties));
    }

    public static final RegistryObject<CustomIce> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CustomIce(properties), creativeTab);
    }

    public static final RegistryObject<CustomIce> create(String name, Properties properties, Block meltedBlock) {
        return BlockRegistry.register(name, () -> new CustomIce(properties, meltedBlock));
    }

    public static final RegistryObject<CustomIce> create(String name, Properties properties, Block meltedBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CustomIce(properties, meltedBlock), creativeTab);
    }
}
