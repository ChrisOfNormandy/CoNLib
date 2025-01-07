package com.github.chrisofnormandy.conlib.blocks.plants.flowers;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Flowers {

    public static final CustomFlower create(String name) {
        return create(name, Properties.copy(Blocks.POPPY), MobEffects.HEAL, 0);
    }

    public static final CustomFlower create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.POPPY), MobEffects.HEAL, 0, creativeTab);
    }

    public static final CustomFlower create(String name, Properties properties) {
        return create(name, properties, MobEffects.HEAL, 0);
    }

    public static final CustomFlower create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, MobEffects.HEAL, 0, creativeTab);
    }

    public static final CustomFlower create(String name,
            MobEffect effect,
            Integer duration) {
        return create(name, Properties.copy(Blocks.POPPY), effect, duration);
    }

    public static final CustomFlower create(String name,
            MobEffect effect,
            Integer duration,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.POPPY), effect, duration, creativeTab);
    }

    public static final CustomFlower create(String name,
            Properties properties,
            MobEffect effect,
            Integer duration) {
        return BlockRegistry.register(name, new CustomFlower(() -> effect, duration, properties));
    }

    public static final CustomFlower create(String name,
            Properties properties,
            MobEffect effect,
            Integer duration,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CustomFlower(() -> effect, duration, properties), creativeTab);
    }
}
