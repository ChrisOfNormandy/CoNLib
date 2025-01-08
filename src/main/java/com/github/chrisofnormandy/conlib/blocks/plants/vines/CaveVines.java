package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CaveVinesPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Need custom implementation and berries...

public class CaveVines {
    public static class CaveVineBodies {
        public static final CaveVinesPlantBlock create(String name) {
            return create(name, Properties.copy(Blocks.CAVE_VINES_PLANT));
        }

        public static final CaveVinesPlantBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CAVE_VINES_PLANT), creativeTab);
        }

        public static final CaveVinesPlantBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new CaveVinesPlantBlock(properties));
        }

        public static final CaveVinesPlantBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CaveVinesPlantBlock(properties), creativeTab);
        }
    }

    public static class CaveVineTips {
        public static final CaveVinesBlock create(String name) {
            return create(name, Properties.copy(Blocks.CAVE_VINES));
        }

        public static final CaveVinesBlock create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CAVE_VINES), creativeTab);
        }

        public static final CaveVinesBlock create(String name, Properties properties) {
            return BlockRegistry.register(name, new CaveVinesBlock(properties));
        }

        public static final CaveVinesBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new CaveVinesBlock(properties), creativeTab);
        }
    }

    public static final Tuple<CaveVinesBlock, CaveVinesPlantBlock> create(String name) {
        return create(name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT));
    }

    public static final Tuple<CaveVinesBlock, CaveVinesPlantBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT),
                creativeTab);
    }

    public static final Tuple<CaveVinesBlock, CaveVinesPlantBlock> create(String name,
            Properties topProperties, Properties bodyProperties) {
        CaveVinesBlock top = CaveVineTips.create(name, topProperties);
        CaveVinesPlantBlock body = CaveVineBodies.create(name + "_plant", bodyProperties);

        return new Tuple<>(top, body);
    }

    public static final Tuple<CaveVinesBlock, CaveVinesPlantBlock> create(String name,
            Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        CaveVinesBlock top = CaveVineTips.create(name, topProperties, creativeTab);
        CaveVinesPlantBlock body = CaveVineBodies.create(name + "_plant", bodyProperties, creativeTab);

        return new Tuple<>(top, body);
    }
}
