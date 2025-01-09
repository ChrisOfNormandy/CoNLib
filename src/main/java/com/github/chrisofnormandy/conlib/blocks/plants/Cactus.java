package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Cactus {

    public static final RegistryObject<CactusBlock> create(String name) {
        return create(name, Properties.copy(Blocks.CACTUS));
    }

    public static final RegistryObject<CactusBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CACTUS), creativeTab);
    }

    public static final RegistryObject<CactusBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new CactusBlock(properties));
    }

    public static final RegistryObject<CactusBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new CactusBlock(properties), creativeTab);
    }
}
