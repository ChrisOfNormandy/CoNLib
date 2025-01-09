package com.github.chrisofnormandy.conlib.blocks.decoration.glass;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TintedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class TintedGlass {

    public static final RegistryObject<TintedGlassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.TINTED_GLASS));
    }

    public static final RegistryObject<TintedGlassBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TINTED_GLASS), creativeTab);
    }

    public static final RegistryObject<TintedGlassBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new TintedGlassBlock(properties));
    }

    public static final RegistryObject<TintedGlassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new TintedGlassBlock(properties), creativeTab);
    }
}
