package com.github.chrisofnormandy.conlib.blocks.ores;

import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.registry.ItemRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Ore {

    public static class Gem {
        public static final void create(String name,
                net.minecraft.world.item.Item.Properties toolProperties,
                Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Block) {
            ItemRegistry.register(name, new Item.Properties(), creativeTab_Item);
            Ore.create(name + "_ore", creativeTab_Block);
        }
    }

    public static class Metal {
        public static final void create(String name,
                net.minecraft.world.item.Item.Properties ingotProperties,
                net.minecraft.world.item.Item.Properties toolProperties,
                Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item,
                ResourceKey<CreativeModeTab> creativeTab_Block) {
            ItemRegistry.register(name + "_ingot", ingotProperties, creativeTab_Item);
            ItemRegistry.register(name + "_nugget", ingotProperties, creativeTab_Item);
            Ore.create(name + "_ore", creativeTab_Block);
        }
    }

    public static final Block create(String name) {
        return create(name, Properties.copy(Blocks.IRON_ORE));
    }

    public static final Block create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.IRON_ORE), creativeTab);
    }

    public static final Block create(String name, Properties properties) {
        return FullBlocks.create(name, properties.requiresCorrectToolForDrops());
    }

    public static final Block create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return FullBlocks.create(name, properties.requiresCorrectToolForDrops(), creativeTab);
    }
}
