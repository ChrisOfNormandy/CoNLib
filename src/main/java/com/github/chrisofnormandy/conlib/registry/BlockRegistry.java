package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.Main;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

    public static final <T extends Block> T register(String name, T block) {
        return register(name, block, false);
    }

    public static final <T extends Block> T register(String name, T block, ResourceKey<CreativeModeTab> creativeTab) {
        return register(name, block, false, creativeTab);
    }

    public static final <T extends Block> T register(String name, T block, Boolean transparent,
            ResourceKey<CreativeModeTab> creativeTab) {
        BlockItem blockItem = new BlockItem(block, new Item.Properties());

        return register(name, block, blockItem, creativeTab);
    }

    public static final <T extends Block> T register(String name, T block, Boolean transparent) {
        BlockItem blockItem = new BlockItem(block, new Item.Properties());

        return register(name, block, blockItem);
    }

    public static final <T extends Block> T register(String name, T block, BlockItem item) {
        ForgeRegistries.BLOCKS.register(name, block);
        ModRegister.blocks.put(name, block);

        Main.LOG.info("Registered new block: " + block.getName());

        ItemRegistry.register(name, item);

        return block;
    }

    public static final <T extends Block> T register(String name, T block, BlockItem item,
            ResourceKey<CreativeModeTab> creativeTab) {
        ForgeRegistries.BLOCKS.register(name, block);
        ModRegister.blocks.put(name, block);

        Main.LOG.info("Registered new block: " + block.getName());

        ItemRegistry.register(name, item, creativeTab);

        return block;
    }
}
