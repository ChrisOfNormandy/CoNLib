package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CaveVinesPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

// Need custom implementation and berries...

public class CaveVines {
    public static class CaveVineBodies {

        public static final RegistryObject<CaveVinesPlantBlock> create(String name) {
            return create(name, Properties.copy(Blocks.CAVE_VINES_PLANT));
        }

        public static final RegistryObject<CaveVinesPlantBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CAVE_VINES_PLANT), creativeTab);
        }

        public static final RegistryObject<CaveVinesPlantBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new CaveVinesPlantBlock(properties));
        }

        public static final RegistryObject<CaveVinesPlantBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new CaveVinesPlantBlock(properties), creativeTab);
        }
    }

    public static class CaveVineTips {

        public static final RegistryObject<CaveVinesBlock> create(String name) {
            return create(name, Properties.copy(Blocks.CAVE_VINES));
        }

        public static final RegistryObject<CaveVinesBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CAVE_VINES), creativeTab);
        }

        public static final RegistryObject<CaveVinesBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new CaveVinesBlock(properties));
        }

        public static final RegistryObject<CaveVinesBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new CaveVinesBlock(properties), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<CaveVinesBlock>, RegistryObject<CaveVinesPlantBlock>> create(String name) {
        return create(name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT));
    }

    public static final Tuple<RegistryObject<CaveVinesBlock>, RegistryObject<CaveVinesPlantBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT),
                creativeTab);
    }

    public static final Tuple<RegistryObject<CaveVinesBlock>, RegistryObject<CaveVinesPlantBlock>> create(String name,
            Properties topProperties, Properties bodyProperties) {
        var top = CaveVineTips.create(name, topProperties);
        var body = CaveVineBodies.create(name + "_plant", bodyProperties);

        return new Tuple<>(top, body);
    }

    public static final Tuple<RegistryObject<CaveVinesBlock>, RegistryObject<CaveVinesPlantBlock>> create(String name,
            Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var top = CaveVineTips.create(name, topProperties, creativeTab);
        var body = CaveVineBodies.create(name + "_plant", bodyProperties, creativeTab);

        return new Tuple<>(top, body);
    }
}
