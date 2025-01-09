package com.github.chrisofnormandy.conlib.blocks.misc;

import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Concrete {
    public static class ConcretePowders {

        public static final RegistryObject<ConcretePowderBlock> create(String name, Block hardenedBlock) {
            return create(name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), hardenedBlock);
        }

        public static final RegistryObject<ConcretePowderBlock> create(String name, Block hardenedBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), hardenedBlock, creativeTab);
        }

        public static final RegistryObject<ConcretePowderBlock> create(String name, Properties properties,
                Block hardenedBlock) {
            return BlockRegistry.register(name, () -> new ConcretePowderBlock(hardenedBlock, properties));
        }

        public static final RegistryObject<ConcretePowderBlock> create(String name, Properties properties,
                Block hardenedBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new ConcretePowderBlock(hardenedBlock, properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<Block>, RegistryObject<ConcretePowderBlock>> create(String name) {
        return create(name, Properties.copy(Blocks.WHITE_CONCRETE), Properties.copy(Blocks.WHITE_CONCRETE_POWDER));
    }

    public static final Tuple<RegistryObject<Block>, RegistryObject<ConcretePowderBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.WHITE_CONCRETE), Properties.copy(Blocks.WHITE_CONCRETE_POWDER),
                creativeTab);
    }

    public static final Tuple<RegistryObject<Block>, RegistryObject<ConcretePowderBlock>> create(String name,
            Properties hardenedProperties,
            Properties powderProperties) {
        var solid = FullBlocks.create(name, hardenedProperties);
        var powder = ConcretePowders.create(name, powderProperties, solid.get());

        return new Tuple<>(solid, powder);
    }

    public static final Tuple<RegistryObject<Block>, RegistryObject<ConcretePowderBlock>> create(String name,
            Properties hardenedProperties,
            Properties powderProperties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var solid = FullBlocks.create(name, hardenedProperties, creativeTab);
        var powder = ConcretePowders.create(name, powderProperties, solid.get(), creativeTab);

        return new Tuple<>(solid, powder);
    }
}
