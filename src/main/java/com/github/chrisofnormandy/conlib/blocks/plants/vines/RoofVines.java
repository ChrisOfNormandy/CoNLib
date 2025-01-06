package com.github.chrisofnormandy.conlib.blocks.plants.vines;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RoofVines {

    public static class RoofVineBodies {
        public static final RoofVineBodyBlock create(String name) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT),
                    (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final RoofVineBodyBlock create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT),
                    (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final RoofVineBodyBlock create(String name, Properties properties) {
            return create(name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final RoofVineBodyBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final RoofVineBodyBlock create(String name, GrowingPlantHeadBlock headBlock) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock);
        }

        public static final RoofVineBodyBlock create(String name,
                GrowingPlantHeadBlock headBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock, creativeTab);
        }

        public static final RoofVineBodyBlock create(String name,
                Properties properties,
                GrowingPlantHeadBlock headBlock) {
            return BlockRegistry.register(name, new RoofVineBodyBlock(properties, headBlock));
        }

        public static final RoofVineBodyBlock create(String name,
                Properties properties,
                GrowingPlantHeadBlock headBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new RoofVineBodyBlock(properties, headBlock), creativeTab);
        }
    }

    public static class RoofVineTips {
        public static final RoofVineHeadBlock create(String name) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT);
        }

        public static final RoofVineHeadBlock create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final RoofVineHeadBlock create(String name, Properties properties) {
            return create(name, properties, Blocks.TWISTING_VINES_PLANT);
        }

        public static final RoofVineHeadBlock create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final RoofVineHeadBlock create(String name, Block bodyBlock) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock);
        }

        public static final RoofVineHeadBlock create(String name,
                Block bodyBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock, creativeTab);
        }

        public static final RoofVineHeadBlock create(String name,
                Properties properties,
                Block bodyBlock) {
            return BlockRegistry.register(name, new RoofVineHeadBlock(properties, bodyBlock));
        }

        public static final RoofVineHeadBlock create(String name,
                Properties properties,
                Block bodyBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, new RoofVineHeadBlock(properties, bodyBlock), creativeTab);
        }
    }

    public static final Tuple<RoofVineHeadBlock, RoofVineBodyBlock> create(String name) {
        return create(name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT));
    }

    public static final Tuple<RoofVineHeadBlock, RoofVineBodyBlock> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT),
                creativeTab);
    }

    public static final Tuple<RoofVineHeadBlock, RoofVineBodyBlock> create(String name,
            Properties topProperties, Properties bodyProperties) {
        RoofVineHeadBlock top = RoofVineTips.create(name, topProperties);
        RoofVineBodyBlock body = RoofVineBodies.create(name + "_plant", bodyProperties, top);
        top.setBodyBlock(body);

        return new Tuple<RoofVineHeadBlock, RoofVineBodyBlock>(top, body);
    }

    public static final Tuple<RoofVineHeadBlock, RoofVineBodyBlock> create(String name,
            Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        RoofVineHeadBlock top = RoofVineTips.create(name, topProperties, creativeTab);
        RoofVineBodyBlock body = RoofVineBodies.create(name + "_plant", bodyProperties, top, creativeTab);
        top.setBodyBlock(body);

        return new Tuple<RoofVineHeadBlock, RoofVineBodyBlock>(top, body);
    }
}
