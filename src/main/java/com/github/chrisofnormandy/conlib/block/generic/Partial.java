package com.github.chrisofnormandy.conlib.block.generic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;

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
    public static final Block create_slab(String name, Properties properties, CreativeModeTab group) {
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
                new StairBlock(() -> new Block(properties).defaultBlockState(), properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_stairs(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name,
                new StairBlock(() -> new Block(properties).defaultBlockState(), properties), group);
    }
}
