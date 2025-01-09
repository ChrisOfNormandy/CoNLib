package com.github.chrisofnormandy.conlib.crops;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Haybales {

    public static final RegistryObject<HayBlock> create(String name) {
        return create(name, Properties.copy(Blocks.HAY_BLOCK));
    }

    public static final RegistryObject<HayBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.HAY_BLOCK), creativeTab);
    }

    public static final RegistryObject<HayBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new HayBlock(properties));
    }

    public static final RegistryObject<HayBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new HayBlock(properties), creativeTab);
    }
}
