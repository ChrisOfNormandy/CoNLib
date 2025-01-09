package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Lamps {

    public static final RegistryObject<RedstoneLampBlock> create(String name) {
        return create(name, Properties.copy(Blocks.REDSTONE_LAMP));
    }

    public static final RegistryObject<RedstoneLampBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.REDSTONE_LAMP), creativeTab);
    }

    public static final RegistryObject<RedstoneLampBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new RedstoneLampBlock(properties));
    }

    public static final RegistryObject<RedstoneLampBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new RedstoneLampBlock(properties), creativeTab);
    }
}
