package com.github.chrisofnormandy.conlib.block.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.CoralFanBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MushroomBlock;
// import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.TwistingVinesBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.WeepingVinesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;

/*
    Unfinished:
    - Saplings (need trees)
    - Bamboo needs sapling and top
    - Chorus needs flower
    - Fan coral needs wall version
    - Weeping and twisted vines need tops
    - Kelp needs a top
*/

public class Plants {
    // /**
    // *
    // * @param name
    // * @return
    // */
    // public static final Block create_sapling(String name) {
    // return BlockRegistry.register(name, new SaplingBlock(p_i48337_1_,
    // Properties.copy(Blocks.OAK_SAPLING)));
    // }

    // /**
    // *
    // * @param name
    // * @param group
    // * @return
    // */
    // public static final Block create_sapling(String name, CreativeModeTab group)
    // {
    // return BlockRegistry.register(name, new SaplingBlock(p_i48337_1_,
    // Properties.copy(Blocks.OAK_SAPLING)), group);
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @return
    // */
    // public static final Block create_sapling(String name, Properties properties)
    // {
    // return BlockRegistry.register(name, new SaplingBlock(p_i48337_1_,
    // properties));
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @param group
    // * @return
    // */
    // public static final Block create_sapling(String name, Properties properties,
    // CreativeModeTab group) {
    // return BlockRegistry.register(name, new SaplingBlock(p_i48337_1_,
    // properties), group);
    // }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_leaves(String name) {
        return BlockRegistry.register(name, new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_leaves(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_leaves(String name, Properties properties) {
        return BlockRegistry.register(name, new LeavesBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_leaves(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new LeavesBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_foliage(String name) {
        return BlockRegistry.register(name, new GrassBlock(Properties.copy(Blocks.GRASS)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_foliage(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new GrassBlock(Properties.copy(Blocks.GRASS)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_foliage(String name, Properties properties) {
        return BlockRegistry.register(name, new GrassBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_foliage(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new GrassBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_seaPickle(String name) {
        return BlockRegistry.register(name, new SeaPickleBlock(Properties.copy(Blocks.SEA_PICKLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_seaPickle(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new SeaPickleBlock(Properties.copy(Blocks.SEA_PICKLE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_seaPickle(String name, Properties properties) {
        return BlockRegistry.register(name, new SeaPickleBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_seaPickle(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new SeaPickleBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_flower(String name, MobEffect effect, Integer duration) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, Properties.copy(Blocks.POPPY)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_flower(String name, MobEffect effect, Integer duration, CreativeModeTab group) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, Properties.copy(Blocks.POPPY)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_flower(String name, MobEffect effect, Integer duration, Properties properties) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_flower(String name,
            MobEffect effect, Integer duration, Properties properties,
            CreativeModeTab group) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_mushroom(String name) {
        return BlockRegistry.register(name, new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM), () -> {
            return TreeFeatures.HUGE_RED_MUSHROOM;
        }));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_mushroom(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM), () -> {
            return TreeFeatures.HUGE_RED_MUSHROOM;
        }), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_mushroom(String name, Properties properties) {
        return BlockRegistry.register(name, new MushroomBlock(properties, () -> {
            return TreeFeatures.HUGE_RED_MUSHROOM;
        }));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_mushroom(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new MushroomBlock(properties, () -> {
            return TreeFeatures.HUGE_RED_MUSHROOM;
        }), group);
    }

    ////
    // These require multiple blocks...
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_weepingVines(String name) {
        return BlockRegistry.register(name, new WeepingVinesBlock(Properties.copy(Blocks.WEEPING_VINES))); // WeepingVinesPlant
                                                                                                           // = top
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_weepingVines(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new WeepingVinesBlock(Properties.copy(Blocks.WEEPING_VINES)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_weepingVines(String name, Properties properties) {
        return BlockRegistry.register(name, new WeepingVinesBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_weepingVines(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new WeepingVinesBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_twistingVines(String name) {
        return BlockRegistry.register(name, new TwistingVinesBlock(Properties.copy(Blocks.TWISTING_VINES))); // TwistedVinesPlant
                                                                                                             // = top
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_twistingVines(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TwistingVinesBlock(Properties.copy(Blocks.TWISTING_VINES)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_twistingVines(String name, Properties properties) {
        return BlockRegistry.register(name, new TwistingVinesBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_twistingVines(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new TwistingVinesBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_reeds(String name) {
        return BlockRegistry.register(name, new SugarCaneBlock(Properties.copy(Blocks.SUGAR_CANE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_reeds(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new SugarCaneBlock(Properties.copy(Blocks.SUGAR_CANE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_reeds(String name, Properties properties) {
        return BlockRegistry.register(name, new SugarCaneBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_reeds(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new SugarCaneBlock(properties), group);
    }

    ////
    // These require multiple too...
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_kelp(String name) {
        return BlockRegistry.register(name, new KelpBlock(Properties.copy(Blocks.KELP_PLANT))); // Kelp = top
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_kelp(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new KelpBlock(Properties.copy(Blocks.KELP_PLANT)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_kelp(String name, Properties properties) {
        return BlockRegistry.register(name, new KelpBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_kelp(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new KelpBlock(properties), group);
    }

    ////
    // These have a sapling and multiple blocks...
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_bamboo(String name) {
        return BlockRegistry.register(name, new BambooBlock(Properties.copy(Blocks.BAMBOO)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_bamboo(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new BambooBlock(Properties.copy(Blocks.BAMBOO)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_bamboo(String name, Properties properties) {
        return BlockRegistry.register(name, new BambooBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_bamboo(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new BambooBlock(properties), group);
    }

    ////
    // These have a flower block / sapling
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_chorusPlant(String name) {
        return BlockRegistry.register(name, new ChorusPlantBlock(Properties.copy(Blocks.CHORUS_PLANT)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_chorusPlant(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new ChorusPlantBlock(Properties.copy(Blocks.CHORUS_PLANT)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_chorusPlant(String name, Properties properties) {
        return BlockRegistry.register(name, new ChorusPlantBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_chorusPlant(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new ChorusPlantBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_cactus(String name) {
        return BlockRegistry.register(name, new CactusBlock(Properties.copy(Blocks.CACTUS)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_cactus(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new CactusBlock(Properties.copy(Blocks.CACTUS)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_cactus(String name, Properties properties) {
        return BlockRegistry.register(name, new CactusBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_cactus(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new CactusBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_vines(String name) {
        return BlockRegistry.register(name, new VineBlock(Properties.copy(Blocks.VINE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_vines(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new VineBlock(Properties.copy(Blocks.VINE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_vines(String name, Properties properties) {
        return BlockRegistry.register(name, new VineBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_vines(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new VineBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_lilyPad(String name) {
        return BlockRegistry.register(name, new WaterlilyBlock(Properties.copy(Blocks.LILY_PAD)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_lilyPad(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new WaterlilyBlock(Properties.copy(Blocks.LILY_PAD)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_lilyPad(String name, Properties properties) {
        return BlockRegistry.register(name, new WaterlilyBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_lilyPad(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new WaterlilyBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_tallGrass(String name) {
        return BlockRegistry.register(name, new TallGrassBlock(Properties.copy(Blocks.TALL_GRASS)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tallGrass(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TallGrassBlock(Properties.copy(Blocks.TALL_GRASS)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tallGrass(String name, Properties properties) {
        return BlockRegistry.register(name, new TallGrassBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tallGrass(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new TallGrassBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_tallFlower(String name) {
        return BlockRegistry.register(name, new TallFlowerBlock(Properties.copy(Blocks.ROSE_BUSH)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_tallFlower(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TallFlowerBlock(Properties.copy(Blocks.ROSE_BUSH)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_tallFlower(String name, Properties properties) {
        return BlockRegistry.register(name, new TallFlowerBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_tallFlower(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new TallFlowerBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_coralBlock(String name, Block deadBlock) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, Properties.copy(Blocks.FIRE_CORAL_BLOCK)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_coralBlock(String name, Block deadBlock, CreativeModeTab group) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, Properties.copy(Blocks.FIRE_CORAL_BLOCK)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_coralBlock(String name, Block deadBlock, Properties properties) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_coralBlock(String name, Block deadBlock, Properties properties,
            CreativeModeTab group) {
        return BlockRegistry.register(name, new CoralBlock(deadBlock, properties), group);
    }

    ////
    // Wall version exists too...
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_coralFan(String name) {
        return BlockRegistry.register(name,
                new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL_FAN)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_coralFan(String name, CreativeModeTab group) {
        return BlockRegistry.register(name,
                new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL_FAN)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_coralFan(String name, Properties properties) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_coralFan(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_coral(String name) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, Properties.copy(Blocks.FIRE_CORAL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_coral(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL,
                Properties.copy(Blocks.FIRE_CORAL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_coral(String name, Properties properties) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_coral(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new CoralFanBlock(Blocks.FIRE_CORAL, properties), group);
    }
}
