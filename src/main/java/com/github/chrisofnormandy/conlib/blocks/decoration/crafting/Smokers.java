package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class Smokers {

    public static final RegistryObject<SmokerBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SMOKER));
    }

    public static final RegistryObject<SmokerBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SMOKER), creativeTab);
    }

    public static final RegistryObject<SmokerBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SmokerBlock(properties));
    }

    public static final RegistryObject<SmokerBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SmokerBlock(properties), creativeTab);
    }
}
