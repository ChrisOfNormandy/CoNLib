package com.github.chrisofnormandy.conlib.block.decoration;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlastFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.block.CartographyTableBlock;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.FletchingTableBlock;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LoomBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.item.DyeColor;

public class Utility {
    /**
     * 
     * @param color
     * @param parent
     * @return
     */
    public static final Block create_bed(DyeColor color, Block parent) {
        return new BedBlock(color, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_ladder(Block parent) {
        return new LadderBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_craftingTable(Block parent) {
        return new CraftingTableBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_furnace(Block parent) {
        return new FurnaceBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_grindstone(Block parent) {
        return new GrindstoneBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_composter(Block parent) {
        return new ComposterBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_brewingStand(Block parent) {
        return new BrewingStandBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_cauldron(Block parent) {
        return new CauldronBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_stonecutter(Block parent) {
        return new StonecutterBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_fletchingTable(Block parent) {
        return new FletchingTableBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_barrel(Block parent) {
        return new BarrelBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param color
     * @param parent
     * @return
     */
    public static final Block create_shulker(DyeColor color, Block parent) {
        return new ShulkerBoxBlock(color, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_loom(Block parent) {
        return new LoomBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_smoker(Block parent) {
        return new SmokerBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_blastFurnace(Block parent) {
        return new BlastFurnaceBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_cartographyTable(Block parent) {
        return new CartographyTableBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_smithingTable(Block parent) {
        return new SmithingTableBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static final Block create_beehive(Block parent) {
        return new BeehiveBlock(Block.Properties.copy(parent));
    }
}
