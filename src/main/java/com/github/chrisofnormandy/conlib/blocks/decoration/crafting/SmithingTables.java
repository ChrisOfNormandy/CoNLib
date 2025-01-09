package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class SmithingTables {

    public static final RegistryObject<SmithingTableBlock> create(String name) {
        return create(name, Properties.copy(Blocks.SMITHING_TABLE));
    }

    public static final RegistryObject<SmithingTableBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.SMITHING_TABLE), creativeTab);
    }

    public static final RegistryObject<SmithingTableBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new SmithingTableBlock(properties));
    }

    public static final RegistryObject<SmithingTableBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new SmithingTableBlock(properties), creativeTab);
    }
}
