package com.github.chrisofnormandy.conlib.block.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.ChorusPlantBlock;
import net.minecraft.block.CoralBlock;
import net.minecraft.block.CoralFanBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.KelpBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.MushroomBlock;
// import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.TwistingVinesBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.block.WeepingVinesBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;

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
    // public static final Block create_sapling(String name, ItemGroup group) {
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
    // ItemGroup group) {
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
    public static final Block create_leaves(String name, ItemGroup group) {
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
    public static final Block create_leaves(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_foliage(String name, ItemGroup group) {
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
    public static final Block create_foliage(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_seaPickle(String name, ItemGroup group) {
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
    public static final Block create_seaPickle(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SeaPickleBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_flower(String name, Effect effect, Integer duration) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, Properties.copy(Blocks.POPPY)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_flower(String name, Effect effect, Integer duration, ItemGroup group) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, Properties.copy(Blocks.POPPY)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_flower(String name, Effect effect, Integer duration, Properties properties) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_flower(String name, Effect effect, Integer duration, Properties properties,
            ItemGroup group) {
        return BlockRegistry.register(name, new FlowerBlock(effect, duration, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_mushroom(String name) {
        return BlockRegistry.register(name, new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_mushroom(String name, ItemGroup group) {
        return BlockRegistry.register(name, new MushroomBlock(Properties.copy(Blocks.RED_MUSHROOM)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_mushroom(String name, Properties properties) {
        return BlockRegistry.register(name, new MushroomBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_mushroom(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new MushroomBlock(properties), group);
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
    public static final Block create_weepingVines(String name, ItemGroup group) {
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
    public static final Block create_weepingVines(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_twistingVines(String name, ItemGroup group) {
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
    public static final Block create_twistingVines(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_reeds(String name, ItemGroup group) {
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
    public static final Block create_reeds(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_kelp(String name, ItemGroup group) {
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
    public static final Block create_kelp(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_bamboo(String name, ItemGroup group) {
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
    public static final Block create_bamboo(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_chorusPlant(String name, ItemGroup group) {
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
    public static final Block create_chorusPlant(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_cactus(String name, ItemGroup group) {
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
    public static final Block create_cactus(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_vines(String name, ItemGroup group) {
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
    public static final Block create_vines(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new VineBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_lilyPad(String name) {
        return BlockRegistry.register(name, new LilyPadBlock(Properties.copy(Blocks.LILY_PAD)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_lilyPad(String name, ItemGroup group) {
        return BlockRegistry.register(name, new LilyPadBlock(Properties.copy(Blocks.LILY_PAD)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_lilyPad(String name, Properties properties) {
        return BlockRegistry.register(name, new LilyPadBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_lilyPad(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new LilyPadBlock(properties), group);
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
    public static final Block create_tallGrass(String name, ItemGroup group) {
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
    public static final Block create_tallGrass(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_tallFlower(String name, ItemGroup group) {
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
    public static final Block create_tallFlower(String name, Properties properties, ItemGroup group) {
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
    public static final Block create_coralBlock(String name, Block deadBlock, ItemGroup group) {
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
    public static final Block create_coralBlock(String name, Block deadBlock, Properties properties, ItemGroup group) {
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
        return BlockRegistry.register(name, new CoralFanBlock(Properties.copy(Blocks.FIRE_CORAL_FAN)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_coralFan(String name, ItemGroup group) {
        return BlockRegistry.register(name, new CoralFanBlock(Properties.copy(Blocks.FIRE_CORAL_FAN)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_coralFan(String name, Properties properties) {
        return BlockRegistry.register(name, new CoralFanBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_coralFan(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CoralFanBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_coral(String name) {
        return BlockRegistry.register(name, new CoralFanBlock(Properties.copy(Blocks.FIRE_CORAL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_coral(String name, ItemGroup group) {
        return BlockRegistry.register(name, new CoralFanBlock(Properties.copy(Blocks.FIRE_CORAL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_coral(String name, Properties properties) {
        return BlockRegistry.register(name, new CoralFanBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_coral(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CoralFanBlock(properties), group);
    }
}
