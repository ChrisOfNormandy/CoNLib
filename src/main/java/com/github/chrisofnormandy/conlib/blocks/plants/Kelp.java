package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Kelp {
    public static class KelpStalks {
        public static final KelpPlantBlock create(String name) {
            return create(name, Properties.copy(Blocks.KELP_PLANT));
        }

        public static final KelpPlantBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.KELP_PLANT), creativeTab);
        }

        public static final KelpPlantBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new KelpPlantBlock(properties));
        }

        public static final KelpPlantBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new KelpPlantBlock(properties), creativeTab);
        }
    }

    public static class KelpTops {
        public static final KelpBlock create(String name) {
            return create(name, Properties.copy(Blocks.KELP));
        }

        public static final KelpBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.KELP), creativeTab);
        }

        public static final KelpBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new KelpBlock(properties));
        }

        public static final KelpBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new KelpBlock(properties), creativeTab);
        }
    }

    public static final Tuple<KelpPlantBlock, KelpBlock> create(String name) {
        return create(name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT));
    }

    public static final Tuple<KelpPlantBlock, KelpBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT), creativeTab);
    }

    public static final Tuple<KelpPlantBlock, KelpBlock> create(String name, Properties kelpProperties,
            Properties kelpPlantProperties) {
        KelpBlock stalk = KelpTops.create(name + "_plant", kelpPlantProperties);
        KelpPlantBlock top = KelpStalks.create(name, kelpProperties);

        return new Tuple<KelpPlantBlock, KelpBlock>(top, stalk);
    }

    public static final Tuple<KelpPlantBlock, KelpBlock> create(String name, Properties kelpProperties,
            Properties kelpPlantProperties, ResourceKey<CreativeModeTab> creativeTab) {
        KelpBlock stalk = KelpTops.create(name + "_plant", kelpPlantProperties, creativeTab);
        KelpPlantBlock top = KelpStalks.create(name, kelpProperties, creativeTab);

        return new Tuple<KelpPlantBlock, KelpBlock>(top, stalk);
    }
}
