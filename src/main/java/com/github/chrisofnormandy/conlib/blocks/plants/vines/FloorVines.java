package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import com.github.chrisofnormandy.conlib.blocks.plants.vines.types.FloorVineBodyBlock;
import com.github.chrisofnormandy.conlib.blocks.plants.vines.types.FloorVineHeadBlock;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class FloorVines {
    public static class FloorVineBodies {

        public static final RegistryObject<FloorVineBodyBlock> create(String name) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT),
                    (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT),
                    (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name, Properties properties) {
            return create(name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name, GrowingPlantHeadBlock headBlock) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name,
                GrowingPlantHeadBlock headBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock, creativeTab);
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name,
                Properties properties,
                GrowingPlantHeadBlock headBlock) {
            return BlockRegistry.register(name, () -> new FloorVineBodyBlock(properties, headBlock));
        }

        public static final RegistryObject<FloorVineBodyBlock> create(String name,
                Properties properties,
                GrowingPlantHeadBlock headBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new FloorVineBodyBlock(properties, headBlock), creativeTab);
        }
    }

    public static class FloorVineTips {

        public static final RegistryObject<FloorVineHeadBlock> create(String name) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name, Properties properties) {
            return create(name, properties, Blocks.TWISTING_VINES_PLANT);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name, Block bodyBlock) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name,
                Block bodyBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock, creativeTab);
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name,
                Properties properties,
                Block bodyBlock) {
            return BlockRegistry.register(name, () -> new FloorVineHeadBlock(properties, bodyBlock));
        }

        public static final RegistryObject<FloorVineHeadBlock> create(String name,
                Properties properties,
                Block bodyBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new FloorVineHeadBlock(properties, bodyBlock), creativeTab);
        }
    }

    public static final Tuple<RegistryObject<FloorVineHeadBlock>, RegistryObject<FloorVineBodyBlock>> create(
            String name) {
        return create(name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT));
    }

    public static final Tuple<RegistryObject<FloorVineHeadBlock>, RegistryObject<FloorVineBodyBlock>> create(
            String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT),
                creativeTab);
    }

    public static final Tuple<RegistryObject<FloorVineHeadBlock>, RegistryObject<FloorVineBodyBlock>> create(
            String name,
            Properties topProperties, Properties bodyProperties) {
        var top = FloorVineTips.create(name, topProperties);
        var body = FloorVineBodies.create(name + "_plant", bodyProperties, top.get());
        top.get().setBodyBlock(body.get());

        return new Tuple<>(top, body);
    }

    public static final Tuple<RegistryObject<FloorVineHeadBlock>, RegistryObject<FloorVineBodyBlock>> create(
            String name,
            Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var top = FloorVineTips.create(name, topProperties, creativeTab);
        var body = FloorVineBodies.create(name + "_plant", bodyProperties, top.get(), creativeTab);
        top.get().setBodyBlock(body.get());

        return new Tuple<>(top, body);
    }
}
