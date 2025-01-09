package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Saplings {

    public static final RegistryObject<SaplingBlock> create(String name, AbstractTreeGrower treeGrower) {
        return create(name, Properties.copy(Blocks.OAK_SAPLING), treeGrower);
    }

    public static final RegistryObject<SaplingBlock> create(String name, AbstractTreeGrower treeGrower,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.OAK_SAPLING), treeGrower, creativeTab);
    }

    public static final RegistryObject<SaplingBlock> create(String name, Properties properties,
            AbstractTreeGrower treeGrower) {
        return BlockRegistry.register(name, () -> new SaplingBlock(treeGrower, properties));
    }

    public static final RegistryObject<SaplingBlock> create(String name, Properties properties,
            AbstractTreeGrower treeGrower,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SaplingBlock(treeGrower, properties), creativeTab);
    }
}
