package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LoomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Looms {

    public static final RegistryObject<LoomBlock> create(String name) {
        return create(name, Properties.copy(Blocks.LOOM));
    }

    public static final RegistryObject<LoomBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LOOM), creativeTab);
    }

    public static final RegistryObject<LoomBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new LoomBlock(properties));
    }

    public static final RegistryObject<LoomBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new LoomBlock(properties), creativeTab);
    }
}
