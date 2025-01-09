package com.github.chrisofnormandy.conlib.blocks.fluids;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.RegistryObject;

// Need some way to define liquid states for flowing fluids.

public class Liquid {

    public static final RegistryObject<LiquidBlock> create(String name) {
        return create(name, Properties.copy(Blocks.WATER), () -> Fluids.WATER);
    }

    public static final RegistryObject<LiquidBlock> create(String name, Supplier<? extends FlowingFluid> flowingFluid) {
        return create(name, Properties.copy(Blocks.WATER), flowingFluid);
    }

    public static final RegistryObject<LiquidBlock> create(String name,
            Properties properties,
            Supplier<? extends FlowingFluid> flowingFluid) {
        return BlockRegistry.register(name, () -> new LiquidBlock(flowingFluid, properties));
    }
}
