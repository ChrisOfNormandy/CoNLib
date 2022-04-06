package com.github.chrisofnormandy.conlib.block.transportation;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DetectorRailBlock;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.RailBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;

public class Rails {
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_rail(String name) {
        return BlockRegistry.register(name, new RailBlock(Properties.copy(Blocks.RAIL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_rail(String name, ItemGroup group) {
        return BlockRegistry.register(name, new RailBlock(Properties.copy(Blocks.RAIL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_rail(String name, Properties properties) {
        return BlockRegistry.register(name, new RailBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_rail(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RailBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_poweredRail(String name) {
        return BlockRegistry.register(name, new PoweredRailsBase(Properties.copy(Blocks.POWERED_RAIL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_poweredRail(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PoweredRailsBase(Properties.copy(Blocks.POWERED_RAIL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_poweredRail(String name, Properties properties) {
        return BlockRegistry.register(name, new PoweredRailsBase(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_poweredRail(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PoweredRailsBase(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_detectorRail(String name) {
        return BlockRegistry.register(name, new DetectorRailBlock(Properties.copy(Blocks.DETECTOR_RAIL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_detectorRail(String name, ItemGroup group) {
        return BlockRegistry.register(name, new DetectorRailBlock(Properties.copy(Blocks.DETECTOR_RAIL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_detectorRail(String name, Properties properties) {
        return BlockRegistry.register(name, new DetectorRailBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_detectorRail(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new DetectorRailBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_activatorRail(String name) {
        return BlockRegistry.register(name, new PoweredRailBlock(Properties.copy(Blocks.ACTIVATOR_RAIL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_activatorRail(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PoweredRailBlock(Properties.copy(Blocks.ACTIVATOR_RAIL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_activatorRail(String name, Properties properties) {
        return BlockRegistry.register(name, new PoweredRailBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_activatorRail(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PoweredRailBlock(properties), group);
    }
}
