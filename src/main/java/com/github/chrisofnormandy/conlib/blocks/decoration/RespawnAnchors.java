package com.github.chrisofnormandy.conlib.blocks.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class RespawnAnchors {

    public static final RegistryObject<RespawnAnchorBlock> create(String name) {
        return create(name, Properties.copy(Blocks.RESPAWN_ANCHOR));
    }

    public static final RegistryObject<RespawnAnchorBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.RESPAWN_ANCHOR), creativeTab);
    }

    public static final RegistryObject<RespawnAnchorBlock> create(String name, Properties properties) {
        return BlockRegistry.register(name, () -> new RespawnAnchorBlock(properties));
    }

    public static final RegistryObject<RespawnAnchorBlock> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, () -> new RespawnAnchorBlock(properties), creativeTab);
    }
}
