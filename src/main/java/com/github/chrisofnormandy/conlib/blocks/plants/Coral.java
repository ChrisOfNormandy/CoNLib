package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.CoralFanBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Coral {

    public static class FullBlock {
        public static final Block create_coralBlock(String name, Block deadBlock) {
            return BlockRegistry.register(name, new CoralBlock(deadBlock, Properties.copy(Blocks.FIRE_CORAL_BLOCK)));
        }

        public static final Block create_coralBlock(String name, Block deadBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CoralBlock(deadBlock, Properties.copy(Blocks.FIRE_CORAL_BLOCK)),
                    creativeTab);
        }

        public static final Block create_coralBlock(String name, Block deadBlock, Properties properties) {
            return BlockRegistry.register(name, new CoralBlock(deadBlock, properties));
        }

        public static final Block create_coralBlock(String name, Block deadBlock, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CoralBlock(deadBlock, properties), creativeTab);
        }
    }

    public static class Fan {
        public static final Block create_coralFan(String name) {
            return BlockRegistry.register(name,
                    new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL_FAN)));
        }

        public static final Block create_coralFan(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name,
                    new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL_FAN)), creativeTab);
        }

        public static final Block create_coralFan(String name, Properties properties) {
            return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties));
        }

        public static final Block create_coralFan(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties), creativeTab);
        }
    }

    public static final Block create_coral(String name) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL)));
    }

    public static final Block create_coral(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL,
                Properties.copy(Blocks.FIRE_CORAL)), creativeTab);
    }

    public static final Block create_coral(String name, Properties properties) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties));
    }

    public static final Block create_coral(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties), creativeTab);
    }
}
