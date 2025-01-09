package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class EndRods {

    public static RegistryObject<EndRodBlock> create(String name) {
        return create(name, Properties.copy(Blocks.END_ROD));
    }

    public static RegistryObject<EndRodBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.END_ROD), creativeTab);
    }

    public static RegistryObject<EndRodBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new EndRodBlock(properties));
    }

    public static RegistryObject<EndRodBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new EndRodBlock(properties), creativeTab);
    }
}
