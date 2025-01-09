package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class LightningRod {

    public static final RegistryObject<LightningRodBlock> create(String name) {
        return create(name, Properties.copy(Blocks.LIGHTNING_ROD));
    }

    public static final RegistryObject<LightningRodBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.LIGHTNING_ROD), creativeTab);
    }

    public static final RegistryObject<LightningRodBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new LightningRodBlock(properties));
    }

    public static final RegistryObject<LightningRodBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new LightningRodBlock(properties), creativeTab);
    }
}
