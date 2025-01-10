package com.github.chrisofnormandy.conlib.blocks;

import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.Slabs;
import com.github.chrisofnormandy.conlib.blocks.basic.Stairs;
import com.github.chrisofnormandy.conlib.blocks.basic.WallBlocks;
import com.github.chrisofnormandy.conlib.blocks.redstone.Buttons;
import com.github.chrisofnormandy.conlib.blocks.redstone.PressurePlates;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class StoneBlockSet {

    public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        BlockSetType blockSetType = new BlockSetType(name);
        BlockSetType.register(blockSetType);

        var stoneProperties = Properties.copy(Blocks.STONE);
        var stone = FullBlocks.create(name, stoneProperties, creativeTab);

        var slab = Slabs.create(name + "_slab", stoneProperties, creativeTab);
        var stairs = Stairs.create(name + "_stairs", stoneProperties, () -> stone.get(), creativeTab);
        var wall = WallBlocks.create(name + "_wall", stoneProperties, creativeTab);

        var pressurePlate = PressurePlates.create(name + "_pressure_plate", stoneProperties, Sensitivity.EVERYTHING,
                blockSetType,
                creativeTab);
        var button = Buttons.create(name + "_button", stoneProperties, creativeTab);
    }
}
