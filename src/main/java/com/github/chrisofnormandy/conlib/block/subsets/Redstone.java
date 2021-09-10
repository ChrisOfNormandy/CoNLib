package com.github.chrisofnormandy.conlib.block.subsets;

import com.github.chrisofnormandy.conlib.block.types.ButtonBase;

import net.minecraft.block.Block;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;

public class Redstone {
    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_pressurePlate_wood(Block parent) {
        return new PressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_wood(Block.Properties properties) {
        return new PressurePlateBlock(Sensitivity.EVERYTHING, properties);
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_pressurePlate_stone(Block parent) {
        return new PressurePlateBlock(Sensitivity.MOBS, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param properties
     * @return
     */
    public static final Block create_pressurePlate_stone(Block.Properties properties) {
        return new PressurePlateBlock(Sensitivity.MOBS, properties);
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_button_wood(Block parent) {
        return new ButtonBase(true, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param properties
     * @return
     */
    public static final Block create_button_wood(Block.Properties properties) {
        return new ButtonBase(true, properties);
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_button_stone(Block parent) {
        return new ButtonBase(false, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param properties
     * @return
     */
    public static final Block create_button_stone(Block.Properties properties) {
        return new ButtonBase(false, properties);
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_lever(Block parent) {
        return new LeverBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param properties
     * @return
     */
    public static final Block create_lever(Block.Properties properties) {
        return new LeverBlock(properties);
    }
}
