package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.EquipableCarvedGourd;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class EquipableGourds {

    public static final RegistryObject<EquipableCarvedGourd> create(String name) {
        return create(name, Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    public static final RegistryObject<EquipableCarvedGourd> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CARVED_PUMPKIN), creativeTab);
    }

    public static final RegistryObject<EquipableCarvedGourd> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new EquipableCarvedGourd(properties));
    }

    public static final RegistryObject<EquipableCarvedGourd> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new EquipableCarvedGourd(properties), creativeTab);
    }
}
