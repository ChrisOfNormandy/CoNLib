package com.github.chrisofnormandy.conlib.blocks.plants;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;

public class ChorusPlants {
    public static class ChorusStalks {

        public static final RegistryObject<ChorusPlantBlock> create(String name) {
            return create(name, Properties.copy(Blocks.CHORUS_PLANT));
        }

        public static final RegistryObject<ChorusPlantBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CHORUS_PLANT), creativeTab);
        }

        public static final RegistryObject<ChorusPlantBlock> create(String name, Properties properties) {
            return BlockRegistry.register(name, () -> new ChorusPlantBlock(properties));
        }

        public static final RegistryObject<ChorusPlantBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new ChorusPlantBlock(properties), creativeTab);
        }
    }

    public static class ChorusFlowers {

        public static final RegistryObject<ChorusFlowerBlock> create(String name) {
            return create(name, Properties.copy(Blocks.CHORUS_FLOWER));
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CHORUS_FLOWER), creativeTab);
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, ChorusPlantBlock plantBlock) {
            return create(name, Properties.copy(Blocks.CHORUS_FLOWER), plantBlock);
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, ChorusPlantBlock plantBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, Properties.copy(Blocks.CHORUS_FLOWER), plantBlock, creativeTab);
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, Properties properties) {
            return create(name, properties, (ChorusPlantBlock) Blocks.CHORUS_PLANT);
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, Properties properties,
                ResourceKey<CreativeModeTab> creativeTab) {
            return create(name, properties, (ChorusPlantBlock) Blocks.CHORUS_PLANT, creativeTab);
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, Properties properties,
                ChorusPlantBlock plantBlock) {
            return BlockRegistry.register(name, () -> new ChorusFlowerBlock(plantBlock, properties));
        }

        public static final RegistryObject<ChorusFlowerBlock> create(String name, Properties properties,
                ChorusPlantBlock plantBlock,
                ResourceKey<CreativeModeTab> creativeTab) {
            return BlockRegistry.register(name, () -> new ChorusFlowerBlock(plantBlock, properties));
        }
    }

    public static final Tuple<RegistryObject<ChorusPlantBlock>, RegistryObject<ChorusFlowerBlock>> create(String name) {
        var plantBlock = ChorusStalks.create(name);
        var flowerBlock = ChorusFlowers.create(name, plantBlock.get());

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<RegistryObject<ChorusPlantBlock>, RegistryObject<ChorusFlowerBlock>> create(String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        var plantBlock = ChorusStalks.create(name, creativeTab);
        var flowerBlock = ChorusFlowers.create(name, plantBlock.get(), creativeTab);

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<RegistryObject<ChorusPlantBlock>, RegistryObject<ChorusFlowerBlock>> create(String name,
            Properties stalkProperties,
            Properties flowerProperties) {
        var plantBlock = ChorusStalks.create(name, stalkProperties);
        var flowerBlock = ChorusFlowers.create(name, flowerProperties, plantBlock.get());

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<RegistryObject<ChorusPlantBlock>, RegistryObject<ChorusFlowerBlock>> create(String name,
            Properties stalkProperties,
            Properties flowerProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var plantBlock = ChorusStalks.create(name, stalkProperties, creativeTab);
        var flowerBlock = ChorusFlowers.create(name, flowerProperties, plantBlock.get(), creativeTab);

        return new Tuple<>(plantBlock, flowerBlock);
    }
}
