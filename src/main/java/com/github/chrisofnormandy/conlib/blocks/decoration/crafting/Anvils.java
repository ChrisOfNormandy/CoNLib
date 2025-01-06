package com.github.chrisofnormandy.conlib.blocks.decoration.crafting;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Anvils {

    public static final AnvilBlock create(String name) {
        return create(name, Properties.copy(Blocks.ANVIL));
    }

    public static final AnvilBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.ANVIL), creativeTab);
    }

    public static final AnvilBlock create(String name, Properties properties) {
        return BlockRegistry.register(name, new AnvilBlock(properties));
    }

    public static final AnvilBlock create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new AnvilBlock(properties), creativeTab);
    }
}
