package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Lichen {

    public static final RegistryObject<GlowLichenBlock> create(String name) {
        return create(name, Properties.copy(Blocks.GLOW_LICHEN));
    }

    public static final RegistryObject<GlowLichenBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GLOW_LICHEN), creativeTab);
    }

    public static final RegistryObject<GlowLichenBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new GlowLichenBlock(properties));
    }

    public static final RegistryObject<GlowLichenBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new GlowLichenBlock(properties), creativeTab);
    }
}
