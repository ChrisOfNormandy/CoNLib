package com.github.chrisofnormandy.conlib.block.generic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;

public class Partial {
    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_slab(String name, Properties properties) {
        return BlockRegistry.register(name, new SlabBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_slab(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SlabBlock(properties), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_stairs(String name, Properties properties) {
        return BlockRegistry.register(name,
                new StairsBlock(() -> new Block(properties).defaultBlockState(), properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_stairs(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name,
                new StairsBlock(() -> new Block(properties).defaultBlockState(), properties), group);
    }
}
