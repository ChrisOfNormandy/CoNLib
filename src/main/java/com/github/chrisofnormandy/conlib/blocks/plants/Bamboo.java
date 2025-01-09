package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Bamboo {
    public static class BambooStalks {

        public static final RegistryObject<BambooStalkBlock> create(String name) {
            return create(name, Properties.copy(Blocks.BAMBOO));
        }

        public static final RegistryObject<BambooStalkBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.BAMBOO), creativeTab);
        }

        public static final RegistryObject<BambooStalkBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new BambooStalkBlock(properties));
        }

        public static final RegistryObject<BambooStalkBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new BambooStalkBlock(properties), creativeTab);
        }
    }

    public static class BambooSaplings {

        public static final RegistryObject<BambooSaplingBlock> create(String name) {
            return create(name, Properties.copy(Blocks.BAMBOO_SAPLING));
        }

        public static final RegistryObject<BambooSaplingBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.BAMBOO_SAPLING), creativeTab);
        }

        public static final RegistryObject<BambooSaplingBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new BambooSaplingBlock(properties));
        }

        public static final RegistryObject<BambooSaplingBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new BambooSaplingBlock(properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<BambooStalkBlock>, RegistryObject<BambooSaplingBlock>> create(
            String name) {
        return create(name, Properties.copy(Blocks.BAMBOO), Properties.copy(Blocks.BAMBOO_SAPLING));
    }

    public static final Tuple<RegistryObject<BambooStalkBlock>, RegistryObject<BambooSaplingBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BAMBOO), Properties.copy(Blocks.BAMBOO_SAPLING), creativeTab);
    }

    public static final Tuple<RegistryObject<BambooStalkBlock>, RegistryObject<BambooSaplingBlock>> create(String name,
            Properties stalkProperties,
            Properties saplingProperties) {
        return new Tuple<>(
                BambooStalks.create(name, stalkProperties),
                BambooSaplings.create(name, saplingProperties));
    }

    public static final Tuple<RegistryObject<BambooStalkBlock>, RegistryObject<BambooSaplingBlock>> create(String name,
            Properties stalkProperties,
            Properties saplingProperties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return new Tuple<>(
                BambooStalks.create(name, stalkProperties, creativeTab),
                BambooSaplings.create(name, saplingProperties, creativeTab));
    }
}
