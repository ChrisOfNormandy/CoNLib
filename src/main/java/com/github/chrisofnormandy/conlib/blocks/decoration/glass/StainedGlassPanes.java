package com.github.chrisofnormandy.conlib.blocks.decoration.glass;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class StainedGlassPanes {
    public static final StainedGlassPaneBlock create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), DyeColor.WHITE);
    }

    public static final StainedGlassPaneBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), DyeColor.WHITE, creativeTab);
    }

    public static final StainedGlassPaneBlock create(String name, Properties properties) {
        return create(name, properties, DyeColor.WHITE);
    }

    public static final StainedGlassPaneBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, DyeColor.WHITE, creativeTab);
    }

    public static final StainedGlassPaneBlock create(String name, DyeColor color) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), color);
    }

    public static final StainedGlassPaneBlock create(String name, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), color, creativeTab);
    }

    public static final StainedGlassPaneBlock create(String name, Properties properties, DyeColor color) {
        return BlockRegistry.register(name, new StainedGlassPaneBlock(color, properties));
    }

    public static final StainedGlassPaneBlock create(String name, Properties properties, DyeColor color,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new StainedGlassPaneBlock(color, properties), creativeTab);
    }
}
