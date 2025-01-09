package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

public class TrapDoors {

    public static final RegistryObject<TrapDoorBlock> create(String name) {
        return create(name, Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, creativeTab);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, Properties properties) {
        return create(name, properties, BlockSetType.OAK);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, BlockSetType.OAK, creativeTab);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, BlockSetType blockSetType) {
        return create(name, Properties.copy(Blocks.OAK_TRAPDOOR), blockSetType);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_TRAPDOOR), blockSetType, creativeTab);
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, Properties properties,
            BlockSetType blockSetType) {
        return BlockRegistry.register(name, () -> new TrapDoorBlock(properties, blockSetType));
    }

    public static final RegistryObject<TrapDoorBlock> create(String name, Properties properties,
            BlockSetType blockSetType,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TrapDoorBlock(properties, blockSetType), creativeTab);
    }
}
