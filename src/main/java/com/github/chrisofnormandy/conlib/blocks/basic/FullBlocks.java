package com.github.chrisofnormandy.conlib.blocks.basic;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class FullBlocks {

    public static final RegistryObject<Block> create(String name) {
        return create(name, Properties.copy(Blocks.DIRT));
    }

    public static final RegistryObject<Block> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.DIRT), creativeTab);
    }

    /**
     * Creates and registers a standard block.
     *
     * @param name       The name of the block.
     * @param properties The properties of the block.
     * @return The registered block.
     */
    public static final RegistryObject<Block> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new Block(properties));
    }

    /**
     * Creates and registers a standard block with a specified creative tab.
     *
     * @param name        The name of the block.
     * @param properties  The properties of the block.
     * @param creativeTab The creative tab to which the block belongs.
     * @return The registered block.
     */
    public static final RegistryObject<Block> create(String name,
            Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new Block(properties), creativeTab);
    }
}
