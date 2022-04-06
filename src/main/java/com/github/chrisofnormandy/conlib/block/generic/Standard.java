package com.github.chrisofnormandy.conlib.block.generic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;

public class Standard {
    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create(String name, Properties properties) {
        return BlockRegistry.register(name, new Block(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new Block(properties), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block createColumn(String name, Properties properties) {
        return BlockRegistry.register(name, new RotatedPillarBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block createColumn(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RotatedPillarBlock(properties), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block createFalling(String name, Properties properties) {
        return BlockRegistry.register(name, new FallingBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block createFalling(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FallingBlock(properties), group);
    }
}
