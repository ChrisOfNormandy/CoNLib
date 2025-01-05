package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TwistingVinesBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WeepingVinesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Vines {
    public static class Weeping {
        public static final Block create_weepingVines(String name) {
            return BlockRegistry.register(name, new WeepingVinesBlock(Properties.copy(Blocks.WEEPING_VINES))); // WeepingVinesPlant
                                                                                                               // = top
        }

        public static final Block create_weepingVines(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new WeepingVinesBlock(Properties.copy(Blocks.WEEPING_VINES)),
                    creativeTab);
        }

        public static final Block create_weepingVines(String name, Properties properties) {
            return BlockRegistry.register(name, new WeepingVinesBlock(properties));
        }

        public static final Block create_weepingVines(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new WeepingVinesBlock(properties), creativeTab);
        }
    }

    public static class Twisting {
        public static final Block create_twistingVines(String name) {
            return BlockRegistry.register(name, new TwistingVinesBlock(Properties.copy(Blocks.TWISTING_VINES))); // TwistedVinesPlant
                                                                                                                 // =
                                                                                                                 // top
        }

        public static final Block create_twistingVines(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TwistingVinesBlock(Properties.copy(Blocks.TWISTING_VINES)),
                    creativeTab);
        }

        public static final Block create_twistingVines(String name, Properties properties) {
            return BlockRegistry.register(name, new TwistingVinesBlock(properties));
        }

        public static final Block create_twistingVines(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TwistingVinesBlock(properties), creativeTab);
        }
    }

    public static final Block create_vines(String name) {
        return BlockRegistry.register(name, new VineBlock(Properties.copy(Blocks.VINE)));
    }

    public static final Block create_vines(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new VineBlock(Properties.copy(Blocks.VINE)), creativeTab);
    }

    public static final Block create_vines(String name, Properties properties) {
        return BlockRegistry.register(name, new VineBlock(properties));
    }

    public static final Block create_vines(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new VineBlock(properties), creativeTab);
    }
}
