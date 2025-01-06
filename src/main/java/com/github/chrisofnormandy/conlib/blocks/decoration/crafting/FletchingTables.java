package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FletchingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FletchingTables {

    public static final FletchingTableBlock create(String name) {
        return create(name, Properties.copy(Blocks.FLETCHING_TABLE));
    }

    public static final FletchingTableBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FLETCHING_TABLE), creativeTab);
    }

    public static final FletchingTableBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new FletchingTableBlock(properties));
    }

    public static final FletchingTableBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FletchingTableBlock(properties), creativeTab);
    }
}
