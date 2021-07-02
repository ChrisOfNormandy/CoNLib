package com.github.chrisofnormandy.conlib.block.subsets;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallBlock;

public class Subsets {
    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_slab(Block parent) {
        return new SlabBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_stairs(Block parent) {
        return new StairsBlock(() -> parent.defaultBlockState(), Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_wall(Block parent) {
        return new WallBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_fence(Block parent) {
        return new FenceBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_fenceGate(Block parent) {
        return new FenceGateBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_door(Block parent) {
        return new DoorBlock(Block.Properties.copy(parent));
    }

    /**
     * 
     * @param parent
     * @return
     */
    public static Block create_trapdoor(Block parent) {
        return new TrapDoorBlock(Block.Properties.copy(parent));
    }
}
