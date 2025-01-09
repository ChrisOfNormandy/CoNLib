package com.github.chrisofnormandy.conlib.crops;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Farmland {

    public static final RegistryObject<FarmBlock> create(String name) {
        return create(name, Properties.copy(Blocks.FARMLAND));
    }

    public static final RegistryObject<FarmBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.FARMLAND), creativeTab);
    }

    public static final RegistryObject<FarmBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new FarmBlock(properties));
    }

    public static final RegistryObject<FarmBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new FarmBlock(properties), creativeTab);
    }
}
