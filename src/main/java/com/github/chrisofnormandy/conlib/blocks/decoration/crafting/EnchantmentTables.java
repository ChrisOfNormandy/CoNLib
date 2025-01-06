package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class EnchantmentTables {

    public static final EnchantmentTableBlock create(String name) {
        return create(name, Properties.copy(Blocks.ENCHANTING_TABLE));
    }

    public static final EnchantmentTableBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ENCHANTING_TABLE), creativeTab);
    }

    public static final EnchantmentTableBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(properties));
    }

    public static final EnchantmentTableBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(properties), creativeTab);
    }
}
