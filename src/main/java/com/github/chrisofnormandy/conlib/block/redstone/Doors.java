package com.github.chrisofnormandy.conlib.block.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;

public class Doors {
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_fenceGate(String name) {
        return BlockRegistry.register(name, new FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_fenceGate(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_fenceGate(String name, Properties properties) {
        return BlockRegistry.register(name, new FenceGateBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_fenceGate(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new FenceGateBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_door(String name) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.OAK_DOOR)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_door(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.OAK_DOOR)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_door(String name, Properties properties) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion()));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_door(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion()), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_door_triggered(String name) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.IRON_DOOR)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_door_triggered(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.IRON_DOOR)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_door_triggered(String name, Properties properties) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion()));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_door_triggered(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion()), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_trapdoor(String name) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_trapdoor(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_trapdoor(String name, Properties properties) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion()));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_trapdoor(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion()), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_trapdoor_triggered(String name) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.IRON_TRAPDOOR)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.IRON_TRAPDOOR)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, Properties properties) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion()));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion()), group);
    }
}
