package com.github.chrisofnormandy.conlib.blocks.plants.coral;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BaseCoralPlantBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class DeadCoral {

    public static final RegistryObject<BaseCoralPlantBlock> create(String name) {
        return create(name, Properties.copy(Blocks.DEAD_FIRE_CORAL));
    }

    public static final RegistryObject<BaseCoralPlantBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DEAD_FIRE_CORAL), creativeTab);
    }

    public static final RegistryObject<BaseCoralPlantBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new BaseCoralPlantBlock(properties));
    }

    public static final RegistryObject<BaseCoralPlantBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new BaseCoralPlantBlock(properties), creativeTab);
    }
}
