package com.github.chrisofnormandy.conlib.block.redstone;

import com.github.chrisofnormandy.conlib.block.types.ButtonBase;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComparatorBlock;
import net.minecraft.world.level.block.DaylightDetectorBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.TargetBlock;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Redstone {
    /**
     *
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_wood(String name) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                        BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                        BlockSetType.OAK),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, Properties properties) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, properties, BlockSetType.OAK));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, properties, BlockSetType.OAK), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_stone(String name) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.MOBS,
                        Properties.copy(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.MOBS, Properties.copy(Blocks.STONE_PRESSURE_PLATE),
                        BlockSetType.STONE),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, Properties properties) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.MOBS, properties, BlockSetType.STONE));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.MOBS, properties, BlockSetType.STONE),
                creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @param sensitivity
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate(String name, Sensitivity sensitivity, Properties properties) {
        return BlockRegistry.register(name, new PressurePlateBlock(sensitivity, properties, BlockSetType.STONE));
    }

    /**
     *
     * @param name
     * @param sensitivity
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate(String name, Sensitivity sensitivity, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PressurePlateBlock(sensitivity, properties, BlockSetType.STONE),
                creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_button_wood(String name) {
        return BlockRegistry.register(name, new ButtonBase(Properties.copy(Blocks.OAK_BUTTON)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_button_wood(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ButtonBase(Properties.copy(Blocks.OAK_BUTTON)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_button_wood(String name, Properties properties) {
        return BlockRegistry.register(name, new ButtonBase(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_button_wood(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ButtonBase(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_button_stone(String name) {
        return BlockRegistry.register(name, new ButtonBase(Properties.copy(Blocks.STONE_BUTTON)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_button_stone(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ButtonBase(Properties.copy(Blocks.STONE_BUTTON)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_button_stone(String name, Properties properties) {
        return BlockRegistry.register(name, new ButtonBase(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_button_stone(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ButtonBase(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_lever(String name) {
        return BlockRegistry.register(name, new LeverBlock(Properties.copy(Blocks.LEVER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_lever(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LeverBlock(Properties.copy(Blocks.LEVER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_lever(String name, Properties properties) {
        return BlockRegistry.register(name, new LeverBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_lever(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LeverBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_dispenser(String name) {
        return BlockRegistry.register(name, new DispenserBlock(Properties.copy(Blocks.DISPENSER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_dispenser(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DispenserBlock(Properties.copy(Blocks.DISPENSER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_dispenser(String name, Properties properties) {
        return BlockRegistry.register(name, new DispenserBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_dispenser(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DispenserBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_noteBlock(String name) {
        return BlockRegistry.register(name, new NoteBlock(Properties.copy(Blocks.NOTE_BLOCK)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_noteBlock(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new NoteBlock(Properties.copy(Blocks.NOTE_BLOCK)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_noteBlock(String name, Properties properties) {
        return BlockRegistry.register(name, new NoteBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_noteBlock(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new NoteBlock(properties), creativeTab);
    }

    ////
    // Needs head?
    /**
     *
     * @param name
     * @return
     */
    public static final Block create_stickyPiston(String name) {
        return BlockRegistry.register(name, new PistonBaseBlock(true, Properties.copy(Blocks.PISTON)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_stickyPiston(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PistonBaseBlock(true, Properties.copy(Blocks.PISTON)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_stickyPiston(String name, Properties properties) {
        return BlockRegistry.register(name, new PistonBaseBlock(true, properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_stickyPiston(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PistonBaseBlock(true, properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_piston(String name) {
        return BlockRegistry.register(name, new PistonBaseBlock(false, Properties.copy(Blocks.PISTON)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_piston(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PistonBaseBlock(false, Properties.copy(Blocks.PISTON)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_piston(String name, Properties properties) {
        return BlockRegistry.register(name, new PistonBaseBlock(false, properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_piston(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new PistonBaseBlock(false, properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_tnt(String name) {
        return BlockRegistry.register(name, new TntBlock(Properties.copy(Blocks.TNT)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tnt(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TntBlock(Properties.copy(Blocks.TNT)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tnt(String name, Properties properties) {
        return BlockRegistry.register(name, new TntBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tnt(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TntBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_redstoneTorch(String name) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(Properties.copy(Blocks.REDSTONE_TORCH)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_redstoneTorch(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(Properties.copy(Blocks.REDSTONE_TORCH)),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_redstoneTorch(String name, Properties properties) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_redstoneTorch(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_lamp(String name) {
        return BlockRegistry.register(name, new RedstoneLampBlock(Properties.copy(Blocks.REDSTONE_LAMP)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_lamp(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneLampBlock(Properties.copy(Blocks.REDSTONE_LAMP)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_lamp(String name, Properties properties) {
        return BlockRegistry.register(name, new RedstoneLampBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_lamp(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RedstoneLampBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_tripwireHook(String name) {
        return BlockRegistry.register(name, new TripWireHookBlock(Properties.copy(Blocks.TRIPWIRE_HOOK)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tripwireHook(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TripWireHookBlock(Properties.copy(Blocks.TRIPWIRE_HOOK)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tripwireHook(String name, Properties properties) {
        return BlockRegistry.register(name, new TripWireHookBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tripwireHook(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TripWireHookBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_tripwire(String name, TripWireHookBlock hookBlock) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, Properties.copy(Blocks.TRIPWIRE)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tripwire(String name, TripWireHookBlock hookBlock,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, Properties.copy(Blocks.TRIPWIRE)),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tripwire(String name, TripWireHookBlock hookBlock, Properties properties) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tripwire(String name, TripWireHookBlock hookBlock, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_trappedChest(String name) {
        return BlockRegistry.register(name, new TrappedChestBlock(Properties.copy(Blocks.TRAPPED_CHEST)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_trappedChest(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrappedChestBlock(Properties.copy(Blocks.TRAPPED_CHEST)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_trappedChest(String name, Properties properties) {
        return BlockRegistry.register(name, new TrappedChestBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_trappedChest(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TrappedChestBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight) {
        return BlockRegistry.register(name,
                new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE),
                        BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name,
                new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE),
                        BlockSetType.IRON),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight, Properties properties) {
        return BlockRegistry.register(name, new WeightedPressurePlateBlock(maxWeight, properties, BlockSetType.IRON));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new WeightedPressurePlateBlock(maxWeight, properties, BlockSetType.IRON),
                creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_daylightDetector(String name) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(Properties.copy(Blocks.DAYLIGHT_DETECTOR)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_daylightDetector(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(Properties.copy(Blocks.DAYLIGHT_DETECTOR)),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_daylightDetector(String name, Properties properties) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_daylightDetector(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_hopper(String name) {
        return BlockRegistry.register(name, new HopperBlock(Properties.copy(Blocks.HOPPER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_hopper(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new HopperBlock(Properties.copy(Blocks.HOPPER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_hopper(String name, Properties properties) {
        return BlockRegistry.register(name, new HopperBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_hopper(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new HopperBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_dropper(String name) {
        return BlockRegistry.register(name, new DropperBlock(Properties.copy(Blocks.DROPPER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_dropper(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DropperBlock(Properties.copy(Blocks.DROPPER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_dropper(String name, Properties properties) {
        return BlockRegistry.register(name, new DropperBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_dropper(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new DropperBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_observer(String name) {
        return BlockRegistry.register(name, new ObserverBlock(Properties.copy(Blocks.OBSERVER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_observer(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ObserverBlock(Properties.copy(Blocks.OBSERVER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_observer(String name, Properties properties) {
        return BlockRegistry.register(name, new ObserverBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_observer(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ObserverBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_repeater(String name) {
        return BlockRegistry.register(name, new RepeaterBlock(Properties.copy(Blocks.REPEATER)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_repeater(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RepeaterBlock(Properties.copy(Blocks.REPEATER)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_repeater(String name, Properties properties) {
        return BlockRegistry.register(name, new RepeaterBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_repeater(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RepeaterBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_comparator(String name) {
        return BlockRegistry.register(name, new ComparatorBlock(Properties.copy(Blocks.COMPARATOR)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_comparator(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ComparatorBlock(Properties.copy(Blocks.COMPARATOR)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_comparator(String name, Properties properties) {
        return BlockRegistry.register(name, new ComparatorBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_comparator(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ComparatorBlock(properties), creativeTab);
    }

    ////

    // /**
    // *
    // * @param name
    // * @return
    // */
    // public static final Block create_wire(String name) {
    // return BlockRegistry.register(name, new );
    // }

    // /**
    // *
    // * @param name
    // * @param group
    // * @return
    // */
    // public static final Block create_wire(String name,
    // ResourceKey<CreativeModeTab> creativeTab) {
    // return BlockRegistry.register(name, new , group);
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @return
    // */
    // public static final Block create_wire(String name, Properties properties) {
    // return BlockRegistry.register(name, new );
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @param group
    // * @return
    // */
    // public static final Block create_wire(String name, Properties properties,
    // ResourceKey<CreativeModeTab> creativeTab) {
    // return BlockRegistry.register(name, new , group);
    // }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_targetBlock(String name) {
        return BlockRegistry.register(name, new TargetBlock(Properties.copy(Blocks.TARGET)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_targetBlock(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TargetBlock(Properties.copy(Blocks.TARGET)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_targetBlock(String name, Properties properties) {
        return BlockRegistry.register(name, new TargetBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_targetBlock(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new TargetBlock(properties), creativeTab);
    }
}
