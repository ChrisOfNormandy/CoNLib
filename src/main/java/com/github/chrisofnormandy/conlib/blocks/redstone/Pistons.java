package com.github.chrisofnormandy.conlib.blocks.redstone;

import com.github.chrisofnormandy.conlib.collections.Triplet;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Pistons {

    public static class PistonBases {
        public static PistonBaseBlock create(String name, boolean sticky) {
            return create(name, Properties.copy(Blocks.PISTON), sticky);
        }

        public static PistonBaseBlock create(String name, boolean sticky, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.PISTON), sticky, creativeTab);
        }

        public static PistonBaseBlock create(String name, Properties properties, boolean sticky) {
            return BlockRegistry.register(name, new PistonBaseBlock(sticky, properties));
        }

        public static PistonBaseBlock create(String name, Properties properties, boolean sticky,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new PistonBaseBlock(sticky, properties), creativeTab);
        }
    }

    public static class PistonHeads {
        public static PistonHeadBlock create(String name) {
            return create(name, Properties.copy(Blocks.PISTON_HEAD));
        }

        public static PistonHeadBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.PISTON_HEAD), creativeTab);
        }

        public static PistonHeadBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new PistonHeadBlock(properties));
        }

        public static PistonHeadBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new PistonHeadBlock(properties), creativeTab);
        }
    }

    public static class MovingPistons {
        public static MovingPistonBlock create(String name) {
            return create(name, Properties.copy(Blocks.MOVING_PISTON));
        }

        public static MovingPistonBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.MOVING_PISTON), creativeTab);
        }

        public static MovingPistonBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new MovingPistonBlock(properties));
        }

        public static MovingPistonBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new MovingPistonBlock(properties), creativeTab);
        }
    }

    public static final Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock> createSticky(String name) {
        return create(name, false);
    }

    public static final Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock> createSticky(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, false, creativeTab);
    }

    public static final Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock> create(String name,
            boolean sticky) {
        PistonBaseBlock pistonBaseBlock = PistonBases.create(name, sticky);
        PistonHeadBlock pistonHeadBlock = PistonHeads.create(name + "_head");
        MovingPistonBlock movingPistonBlock = MovingPistons.create("moving_" + name);

        return new Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock>(pistonBaseBlock, pistonHeadBlock,
                movingPistonBlock);
    }

    public static final Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock> create(String name, boolean sticky,
            ResourceKey<CreativeModeTab> creativeTab) {
        PistonBaseBlock pistonBaseBlock = PistonBases.create(name, sticky, creativeTab);
        PistonHeadBlock pistonHeadBlock = PistonHeads.create(name + "_head", creativeTab);
        MovingPistonBlock movingPistonBlock = MovingPistons.create("moving_" + name, creativeTab);

        return new Triplet<PistonBaseBlock, PistonHeadBlock, MovingPistonBlock>(pistonBaseBlock, pistonHeadBlock,
                movingPistonBlock);
    }
}
