package com.github.chrisofnormandy.conlib.blocks;

import com.github.chrisofnormandy.conlib.blocks.basic.FenceBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.PillarBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.Slabs;
import com.github.chrisofnormandy.conlib.blocks.basic.Stairs;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.HangingSigns;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.Signs;
import com.github.chrisofnormandy.conlib.blocks.redstone.Buttons;
import com.github.chrisofnormandy.conlib.blocks.redstone.Doors;
import com.github.chrisofnormandy.conlib.blocks.redstone.FenceGates;
import com.github.chrisofnormandy.conlib.blocks.redstone.PressurePlates;
import com.github.chrisofnormandy.conlib.blocks.redstone.TrapDoors;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodBlockSet {

    public static class LogSets {
        public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            var log = PillarBlocks.create(name + "_log", creativeTab);
            var strippedLog = PillarBlocks.create("stripped_" + name + "_log", creativeTab);
            var wood = FullBlocks.create(name + "_wood", creativeTab);
            var strippedWood = FullBlocks.create("stripped_" + name + "_wood", creativeTab);
        }
    }

    public static class PlankSets {
        public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            BlockSetType blockSetType = new BlockSetType(name);
            BlockSetType.register(blockSetType);
            WoodType woodType = new WoodType(name, blockSetType);
            WoodType.register(woodType);

            var plankProperties = Properties.copy(Blocks.OAK_PLANKS);
            var planks = FullBlocks.create(name + "_planks", plankProperties, creativeTab);

            var slab = Slabs.create(name + "_slab", plankProperties, creativeTab);
            var stairs = Stairs.create(name + "_stairs", plankProperties, () -> planks.get(), creativeTab);
            var fence = FenceBlocks.create(name + "_fence", plankProperties, creativeTab);
            var fenceGate = FenceGates.create(name + "_fence_gate", plankProperties, woodType, creativeTab);
            var door = Doors.create(name + "_door", plankProperties, blockSetType, creativeTab);
            var trapdoor = TrapDoors.create(name + "_trapdoor", plankProperties, blockSetType, creativeTab);

            var pressurePlate = PressurePlates.create(name + "_pressure_plate", plankProperties, Sensitivity.EVERYTHING,
                    blockSetType,
                    creativeTab);
            var button = Buttons.create(name + "_button", plankProperties, creativeTab);

            Signs.create(name, plankProperties, creativeTab);
            HangingSigns.create(name, plankProperties, creativeTab);
        }
    }

    public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        LogSets.create(name, creativeTab);
        PlankSets.create(name, creativeTab);

        // Boats
    }
}
