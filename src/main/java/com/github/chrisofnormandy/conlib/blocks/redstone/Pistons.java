package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.collections.Triplet;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Pistons {

    public static class Base {

    }

    public static class Head {

    }

    public static class Moving {

    }

    public static final Triplet<Block, Block, Block> createSticky(String name) {
        return create(name, false);
    }

    public static final Triplet<Block, Block, Block> createSticky(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, false, creativeTab);
    }

    public static final Triplet<Block, Block, Block> create(String name, boolean sticky,
            ResourceKey<CreativeModeTab> creativeTab) {
        PistonBaseBlock pistonBaseBlock = new PistonBaseBlock(sticky, Properties.copy(Blocks.PISTON));
        PistonHeadBlock pistonHeadBlock = new PistonHeadBlock(Properties.copy(Blocks.PISTON_HEAD));
        MovingPistonBlock movingPistonBlock = new MovingPistonBlock(Properties.copy(Blocks.MOVING_PISTON));

        return new Triplet<Block, Block, Block>(BlockRegistry.register(name, pistonBaseBlock, creativeTab),
                BlockRegistry.register(name + "_head", pistonHeadBlock),
                BlockRegistry.register(name + "_moving", movingPistonBlock));
    }

    public static final Triplet<Block, Block, Block> create(String name, boolean sticky) {
        PistonBaseBlock pistonBaseBlock = new PistonBaseBlock(sticky, Properties.copy(Blocks.PISTON));
        PistonHeadBlock pistonHeadBlock = new PistonHeadBlock(Properties.copy(Blocks.PISTON_HEAD));
        MovingPistonBlock movingPistonBlock = new MovingPistonBlock(Properties.copy(Blocks.MOVING_PISTON));

        return new Triplet<Block, Block, Block>(BlockRegistry.register(name, pistonBaseBlock),
                BlockRegistry.register(name + "_head", pistonHeadBlock),
                BlockRegistry.register(name + "_moving", movingPistonBlock));
    }
}
