package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class StaticLand {
    public static final RegistryObject<SnowyDirtBlock> create(String name) {
        return create(name, Properties.copy(Blocks.PODZOL));
    }

    public static final RegistryObject<SnowyDirtBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.PODZOL), creativeTab);
    }

    public static final RegistryObject<SnowyDirtBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SnowyDirtBlock(properties));
    }

    public static final RegistryObject<SnowyDirtBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SnowyDirtBlock(properties), creativeTab);
    }
}
