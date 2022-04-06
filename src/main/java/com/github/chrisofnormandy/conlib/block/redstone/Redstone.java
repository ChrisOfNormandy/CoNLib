package com.github.chrisofnormandy.conlib.block.redstone;

import com.github.chrisofnormandy.conlib.block.types.ButtonBase;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.DaylightDetectorBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.DropperBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.NoteBlock;
import net.minecraft.block.ObserverBlock;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.TNTBlock;
import net.minecraft.block.TargetBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.block.TripWireBlock;
import net.minecraft.block.TripWireHookBlock;
import net.minecraft.block.WeightedPressurePlateBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.item.ItemGroup;

public class Redstone {
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_wood(String name) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, ItemGroup group) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, Properties properties) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.EVERYTHING, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_wood(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.EVERYTHING, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_stone(String name) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.MOBS, Properties.copy(Blocks.STONE_PRESSURE_PLATE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, ItemGroup group) {
        return BlockRegistry.register(name,
                new PressurePlateBlock(Sensitivity.MOBS, Properties.copy(Blocks.STONE_PRESSURE_PLATE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, Properties properties) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.MOBS, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_stone(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PressurePlateBlock(Sensitivity.MOBS, properties), group);
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
        return BlockRegistry.register(name, new PressurePlateBlock(sensitivity, properties));
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
            ItemGroup group) {
        return BlockRegistry.register(name, new PressurePlateBlock(sensitivity, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_button_wood(String name) {
        return BlockRegistry.register(name, new ButtonBase(true, Properties.copy(Blocks.OAK_BUTTON)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_button_wood(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ButtonBase(true, Properties.copy(Blocks.OAK_BUTTON)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_button_wood(String name, Properties properties) {
        return BlockRegistry.register(name, new ButtonBase(true, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_button_wood(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ButtonBase(true, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_button_stone(String name) {
        return BlockRegistry.register(name, new ButtonBase(false, Properties.copy(Blocks.STONE_BUTTON)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_button_stone(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ButtonBase(false, Properties.copy(Blocks.STONE_BUTTON)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_button_stone(String name, Properties properties) {
        return BlockRegistry.register(name, new ButtonBase(false, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_button_stone(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ButtonBase(false, properties), group);
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
    public static final Block create_lever(String name, ItemGroup group) {
        return BlockRegistry.register(name, new LeverBlock(Properties.copy(Blocks.LEVER)), group);
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
    public static final Block create_lever(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new LeverBlock(properties), group);
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
    public static final Block create_dispenser(String name, ItemGroup group) {
        return BlockRegistry.register(name, new DispenserBlock(Properties.copy(Blocks.DISPENSER)), group);
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
    public static final Block create_dispenser(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new DispenserBlock(properties), group);
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
    public static final Block create_noteBlock(String name, ItemGroup group) {
        return BlockRegistry.register(name, new NoteBlock(Properties.copy(Blocks.NOTE_BLOCK)), group);
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
    public static final Block create_noteBlock(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new NoteBlock(properties), group);
    }

    ////
    // Needs head?
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_stickyPiston(String name) {
        return BlockRegistry.register(name, new PistonBlock(true, Properties.copy(Blocks.PISTON)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_stickyPiston(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PistonBlock(true, Properties.copy(Blocks.PISTON)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_stickyPiston(String name, Properties properties) {
        return BlockRegistry.register(name, new PistonBlock(true, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_stickyPiston(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PistonBlock(true, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_piston(String name) {
        return BlockRegistry.register(name, new PistonBlock(false, Properties.copy(Blocks.PISTON)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_piston(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PistonBlock(false, Properties.copy(Blocks.PISTON)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_piston(String name, Properties properties) {
        return BlockRegistry.register(name, new PistonBlock(false, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_piston(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PistonBlock(false, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_tnt(String name) {
        return BlockRegistry.register(name, new TNTBlock(Properties.copy(Blocks.TNT)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tnt(String name, ItemGroup group) {
        return BlockRegistry.register(name, new TNTBlock(Properties.copy(Blocks.TNT)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tnt(String name, Properties properties) {
        return BlockRegistry.register(name, new TNTBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tnt(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new TNTBlock(properties), group);
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
    public static final Block create_redstoneTorch(String name, ItemGroup group) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(Properties.copy(Blocks.REDSTONE_TORCH)), group);
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
    public static final Block create_redstoneTorch(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RedstoneTorchBlock(properties), group);
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
    public static final Block create_lamp(String name, ItemGroup group) {
        return BlockRegistry.register(name, new RedstoneLampBlock(Properties.copy(Blocks.REDSTONE_LAMP)), group);
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
    public static final Block create_lamp(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RedstoneLampBlock(properties), group);
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
    public static final Block create_tripwireHook(String name, ItemGroup group) {
        return BlockRegistry.register(name, new TripWireHookBlock(Properties.copy(Blocks.TRIPWIRE_HOOK)), group);
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
    public static final Block create_tripwireHook(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new TripWireHookBlock(properties), group);
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
    public static final Block create_tripwire(String name, TripWireHookBlock hookBlock, ItemGroup group) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, Properties.copy(Blocks.TRIPWIRE)), group);
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
            ItemGroup group) {
        return BlockRegistry.register(name, new TripWireBlock(hookBlock, properties), group);
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
    public static final Block create_trappedChest(String name, ItemGroup group) {
        return BlockRegistry.register(name, new TrappedChestBlock(Properties.copy(Blocks.TRAPPED_CHEST)), group);
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
    public static final Block create_trappedChest(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new TrappedChestBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight) {
        return BlockRegistry.register(name,
                new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight, ItemGroup group) {
        return BlockRegistry.register(name,
                new WeightedPressurePlateBlock(maxWeight, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)),
                group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight, Properties properties) {
        return BlockRegistry.register(name, new WeightedPressurePlateBlock(maxWeight, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pressurePlate_weighted(String name, Integer maxWeight, Properties properties,
            ItemGroup group) {
        return BlockRegistry.register(name, new WeightedPressurePlateBlock(maxWeight, properties), group);
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
    public static final Block create_daylightDetector(String name, ItemGroup group) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(Properties.copy(Blocks.DAYLIGHT_DETECTOR)),
                group);
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
    public static final Block create_daylightDetector(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new DaylightDetectorBlock(properties), group);
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
    public static final Block create_hopper(String name, ItemGroup group) {
        return BlockRegistry.register(name, new HopperBlock(Properties.copy(Blocks.HOPPER)), group);
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
    public static final Block create_hopper(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new HopperBlock(properties), group);
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
    public static final Block create_dropper(String name, ItemGroup group) {
        return BlockRegistry.register(name, new DropperBlock(Properties.copy(Blocks.DROPPER)), group);
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
    public static final Block create_dropper(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new DropperBlock(properties), group);
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
    public static final Block create_observer(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ObserverBlock(Properties.copy(Blocks.OBSERVER)), group);
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
    public static final Block create_observer(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ObserverBlock(properties), group);
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
    public static final Block create_repeater(String name, ItemGroup group) {
        return BlockRegistry.register(name, new RepeaterBlock(Properties.copy(Blocks.REPEATER)), group);
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
    public static final Block create_repeater(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RepeaterBlock(properties), group);
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
    public static final Block create_comparator(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ComparatorBlock(Properties.copy(Blocks.COMPARATOR)), group);
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
    public static final Block create_comparator(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ComparatorBlock(properties), group);
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
    // public static final Block create_wire(String name, ItemGroup group) {
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
    // ItemGroup group) {
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
    public static final Block create_targetBlock(String name, ItemGroup group) {
        return BlockRegistry.register(name, new TargetBlock(Properties.copy(Blocks.TARGET)), group);
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
    public static final Block create_targetBlock(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new TargetBlock(properties), group);
    }
}
