package com.github.chrisofnormandy.conlib.husbandry;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class DragonEgg {

    public static final RegistryObject<DragonEggBlock> create(String name) {
        return create(name, Properties.copy(Blocks.DRAGON_EGG));
    }

    public static final RegistryObject<DragonEggBlock> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DRAGON_EGG), creativeTab);
    }

    public static final RegistryObject<DragonEggBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new DragonEggBlock(properties));
    }

    public static final RegistryObject<DragonEggBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new DragonEggBlock(properties), creativeTab);
    }
}
