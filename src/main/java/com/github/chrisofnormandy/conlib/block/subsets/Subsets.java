package com.github.chrisofnormandy.conlib.block.subsets;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;

public class Subsets {
    public static Block create_slab(Block parent) {
        return new SlabBlock(Block.Properties.copy(parent));
    }

    // public static Block create_stairs(Block parent) {
    //     return new StairsBlock(() -> parent.getDefaultState(), Block.Properties.copy(parent));
    // }

    public static Block create_wall(Block parent) {
        return new WallBlock(Block.Properties.copy(parent));
    }

    public static Block create_fence(Block parent) {
        return new FenceBlock(Block.Properties.copy(parent));
    }

    public static Block create_fenceGate(Block parent) {
        return new FenceGateBlock(Block.Properties.copy(parent));
    }
}
