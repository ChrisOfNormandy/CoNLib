package com.github.chrisofnormandy.conlib.blocks.plants.foliage;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BigDripleafBlock;
import net.minecraft.world.level.block.BigDripleafStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Needs custom implementation...

public class TallPondFoliage {
    public static class TallPondFoliageLeaves {

        public static final RegistryObject<BigDripleafBlock> create(String name) {
            return create(name, Properties.copy(Blocks.BIG_DRIPLEAF));
        }

        public static final RegistryObject<BigDripleafBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.BIG_DRIPLEAF), creativeTab);
        }

        public static final RegistryObject<BigDripleafBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new BigDripleafBlock(properties));
        }

        public static final RegistryObject<BigDripleafBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new BigDripleafBlock(properties), creativeTab);
        }
    }

    public static class TallPondFoliageStems {

        public static final RegistryObject<BigDripleafStemBlock> create(String name) {
            return create(name, Properties.copy(Blocks.BIG_DRIPLEAF_STEM));
        }

        public static final RegistryObject<BigDripleafStemBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.BIG_DRIPLEAF_STEM), creativeTab);
        }

        public static final RegistryObject<BigDripleafStemBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new BigDripleafStemBlock(properties));
        }

        public static final RegistryObject<BigDripleafStemBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new BigDripleafStemBlock(properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<BigDripleafBlock>, RegistryObject<BigDripleafStemBlock>> create(
            String name) {
        return create(name, Properties.copy(Blocks.BIG_DRIPLEAF_STEM));
    }

    public static final Tuple<RegistryObject<BigDripleafBlock>, RegistryObject<BigDripleafStemBlock>> create(
            String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BIG_DRIPLEAF_STEM), creativeTab);
    }

    public static final Tuple<RegistryObject<BigDripleafBlock>, RegistryObject<BigDripleafStemBlock>> create(
            String name, Properties properties) {
        var leaves = TallPondFoliageLeaves.create(name, properties);
        var stem = TallPondFoliageStems.create(name, properties);

        return new Tuple<>(leaves, stem);
    }

    public static final Tuple<RegistryObject<BigDripleafBlock>, RegistryObject<BigDripleafStemBlock>> create(
            String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var leaves = TallPondFoliageLeaves.create(name, properties, creativeTab);
        var stem = TallPondFoliageStems.create(name, properties);

        return new Tuple<>(leaves, stem);
    }
}
