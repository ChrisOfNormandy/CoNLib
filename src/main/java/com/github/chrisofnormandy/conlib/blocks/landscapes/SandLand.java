package com.github.chrisofnormandy.conlib.blocks.landscapes;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class SandLand {
    public static final int SAND_DUST_COLOR = 14406560;
    public static final int RED_SAND_DUST_COLOR = 11098145;

    public static final RegistryObject<SandBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SAND), SAND_DUST_COLOR);
    }

    public static final RegistryObject<SandBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SAND), SAND_DUST_COLOR, creativeTab);
    }

    public static final RegistryObject<SandBlock> create(String name, Properties properties) {
        return create(name, properties, SAND_DUST_COLOR);
    }

    public static final RegistryObject<SandBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, SAND_DUST_COLOR, creativeTab);
    }

    public static final RegistryObject<SandBlock> create(String name, Properties properties, int dustColor) {
        return BlockRegistry.register(name, () -> new SandBlock(dustColor, properties));
    }

    public static final RegistryObject<SandBlock> create(String name, Properties properties, int dustColor,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SandBlock(dustColor, properties), creativeTab);
    }
}
