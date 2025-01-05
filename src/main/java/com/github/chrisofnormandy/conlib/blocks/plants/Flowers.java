package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Flowers {

    public static class Tall {
        public static final Block create_tallFlower(String name) {
            return BlockRegistry.register(name, new TallFlowerBlock(Properties.copy(Blocks.ROSE_BUSH)));
        }

        public static final Block create_tallFlower(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TallFlowerBlock(Properties.copy(Blocks.ROSE_BUSH)), creativeTab);
        }

        public static final Block create_tallFlower(String name, Properties properties) {
            return BlockRegistry.register(name, new TallFlowerBlock(properties));
        }

        public static final Block create_tallFlower(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new TallFlowerBlock(properties), creativeTab);
        }
    }

    public static final Block create_flower(String name, MobEffect effect, Integer duration) {
        return BlockRegistry.register(name, new FlowerBlock(() -> effect, duration, Properties.copy(Blocks.POPPY)));
    }

    public static final Block create_flower(String name, MobEffect effect, Integer duration,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerBlock(() -> effect, duration, Properties.copy(Blocks.POPPY)),
                creativeTab);
    }

    public static final Block create_flower(String name, MobEffect effect, Integer duration, Properties properties) {
        return BlockRegistry.register(name, new FlowerBlock(() -> effect, duration, properties));
    }

    public static final Block create_flower(String name,
            MobEffect effect, Integer duration, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FlowerBlock(() -> effect, duration, properties), creativeTab);
    }
}
