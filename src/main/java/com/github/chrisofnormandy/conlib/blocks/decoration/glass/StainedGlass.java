package com.github.chrisofnormandy.conlib.blocks.decoration.glass;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class StainedGlass {

    public static final RegistryObject<StainedGlassBlock> create(String name) {
        return create(name, Properties.copy(Blocks.IRON_BARS));
    }

    public static final RegistryObject<StainedGlassBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.GLASS_PANE), creativeTab);
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, DyeColor color) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS), color);
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS), color, creativeTab);
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, Properties properties) {
        return create(name, properties, DyeColor.WHITE);
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, DyeColor.WHITE, creativeTab);
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, Properties properties, DyeColor color) {
        return BlockRegistry.register(name, () -> new StainedGlassBlock(color, properties));
    }

    public static final RegistryObject<StainedGlassBlock> create(String name, Properties properties, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new StainedGlassBlock(color, properties), creativeTab);
    }
}
