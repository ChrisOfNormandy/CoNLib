package com.github.chrisofnormandy.conlib.block.redstone;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Doors {
    /**
     *
     * @param name
     * @return
     */
    public static final Block create_fenceGate(String name) {
        return BlockRegistry.register(name, new FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_fenceGate(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_fenceGate(String name, Properties properties) {
        return BlockRegistry.register(name, new FenceGateBlock(properties, WoodType.OAK));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_fenceGate(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FenceGateBlock(properties, WoodType.OAK), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_door(String name) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_door(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_door(String name, Properties properties) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_door(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), BlockSetType.OAK), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_door_triggered(String name) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.IRON_DOOR), BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_door_triggered(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DoorBlock(Properties.copy(Blocks.IRON_DOOR), BlockSetType.IRON),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_door_triggered(String name, Properties properties) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_door_triggered(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DoorBlock(properties.noOcclusion(), BlockSetType.IRON), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_trapdoor(String name) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_trapdoor(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_trapdoor(String name, Properties properties) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion(), BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_trapdoor(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion(), BlockSetType.OAK), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_trapdoor_triggered(String name) {
        return BlockRegistry.register(name,
                new TrapDoorBlock(Properties.copy(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrapDoorBlock(Properties.copy(Blocks.IRON_TRAPDOOR), BlockSetType.IRON),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, Properties properties) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion(), BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_trapdoor_triggered(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrapDoorBlock(properties.noOcclusion(), BlockSetType.IRON),
                creativeTab);
    }
}
