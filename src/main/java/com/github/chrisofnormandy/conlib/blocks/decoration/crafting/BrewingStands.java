package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrewingStandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class BrewingStands {

    public static final RegistryObject<BrewingStandBlock> create(String name) {
        return create(name, Properties.copy(Blocks.BREWING_STAND));
    }

    public static final RegistryObject<BrewingStandBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.BREWING_STAND), creativeTab);
    }

    public static final RegistryObject<BrewingStandBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new BrewingStandBlock(properties));
    }

    public static final RegistryObject<BrewingStandBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new BrewingStandBlock(properties), creativeTab);
    }
}
