package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Kelp {
    public static class KelpStalks {

        public static final RegistryObject<KelpPlantBlock> create(String name) {
            return create(name, Properties.copy(Blocks.KELP_PLANT));
        }

        public static final RegistryObject<KelpPlantBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.KELP_PLANT), creativeTab);
        }

        public static final RegistryObject<KelpPlantBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new KelpPlantBlock(properties));
        }

        public static final RegistryObject<KelpPlantBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new KelpPlantBlock(properties), creativeTab);
        }
    }

    public static class KelpTops {

        public static final RegistryObject<KelpBlock> create(String name) {
            return create(name, Properties.copy(Blocks.KELP));
        }

        public static final RegistryObject<KelpBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.KELP), creativeTab);
        }

        public static final RegistryObject<KelpBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new KelpBlock(properties));
        }

        public static final RegistryObject<KelpBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new KelpBlock(properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<KelpPlantBlock>, RegistryObject<KelpBlock>> create(String name) {
        return create(name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT));
    }

    public static final Tuple<RegistryObject<KelpPlantBlock>, RegistryObject<KelpBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT), creativeTab);
    }

    public static final Tuple<RegistryObject<KelpPlantBlock>, RegistryObject<KelpBlock>> create(String name,
            Properties kelpProperties,
            Properties kelpPlantProperties) {
        var stalk = KelpTops.create(name + "_plant", kelpPlantProperties);
        var top = KelpStalks.create(name, kelpProperties);

        return new Tuple<>(top, stalk);
    }

    public static final Tuple<RegistryObject<KelpPlantBlock>, RegistryObject<KelpBlock>> create(String name,
            Properties kelpProperties,
            Properties kelpPlantProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var stalk = KelpTops.create(name + "_plant", kelpPlantProperties, creativeTab);
        var top = KelpStalks.create(name, kelpProperties, creativeTab);

        return new Tuple<>(top, stalk);
    }
}
