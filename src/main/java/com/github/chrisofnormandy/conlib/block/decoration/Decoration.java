package com.github.chrisofnormandy.conlib.block.decoration;

import java.util.ArrayList;
import java.util.List;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.BannerBlock;
import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.EndRodBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.HoneyBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.ScaffoldingBlock;
// import net.minecraft.block.SkullBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WebBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;

/*
    Unfinished:
    - Skulls
    - Updated annotations
*/

public class Decoration {
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_web(String name) {
        return BlockRegistry.register(name, new WebBlock(Properties.copy(Blocks.COBWEB)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_web(String name, ItemGroup group) {
        return BlockRegistry.register(name, new WebBlock(Properties.copy(Blocks.COBWEB)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_web(String name, Properties properties) {
        return BlockRegistry.register(name, new WebBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_web(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new WebBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_torch(String name) {
        return BlockRegistry.register(name, new TorchBlock(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_torch(String name, ItemGroup group) {
        return BlockRegistry.register(name, new TorchBlock(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param particle
     * @return
     */
    public static final Block create_torch(String name, Properties properties, IParticleData particle) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param particle
     * @param group
     * @return
     */
    public static final Block create_torch(String name, Properties properties, IParticleData particle,
            ItemGroup group) {
        return BlockRegistry.register(name, new TorchBlock(properties, particle), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static Block create_emptyPot(String name) {
        return BlockRegistry.register(name,
                new FlowerPotBlock(null, () -> Blocks.AIR, Properties.copy(Blocks.FLOWER_POT)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static Block create_emptyPot(String name, ItemGroup group) {
        return BlockRegistry.register(name,
                new FlowerPotBlock(null, () -> Blocks.AIR, Properties.copy(Blocks.FLOWER_POT)), group);
    }

    /**
     * 
     * @param name
     * @param flower
     * @return
     */
    public static Block create_flowerPot(String name, Block flower) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, Properties.copy(Blocks.FLOWER_POT)));
    }

    /**
     * 
     * @param name
     * @param flower
     * @param group
     * @return
     */
    public static Block create_flowerPot(String name, Block flower, ItemGroup group) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, Properties.copy(Blocks.FLOWER_POT)),
                group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static Block create_emptyPot(String name, Properties properties) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static Block create_emptyPot(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> Blocks.AIR, properties), group);
    }

    /**
     * 
     * @param name
     * @param flower
     * @param properties
     * @return
     */
    public static Block create_flowerPot(String name, Block flower, Properties properties) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties));
    }

    /**
     * 
     * @param name
     * @param flower
     * @param properties
     * @param group
     * @return
     */
    public static Block create_flowerPot(String name, Block flower, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FlowerPotBlock(null, () -> flower, properties), group);
    }

    /**
     * 
     * @param name
     * @param flowers
     * @return
     */
    public static List<Block> create_flowerPotsFromList(String name, List<Block> flowers) {
        List<Block> pots = new ArrayList<Block>();

        flowers.forEach((Block flower) -> pots.add(create_flowerPot(name, flower, Properties.copy(Blocks.FLOWER_POT))));

        return pots;
    }

    /**
     * 
     * @param name
     * @param flowers
     * @param properties
     * @return
     */
    public static List<Block> create_flowerPotsFromList(String name, List<Block> flowers, Properties properties) {
        List<Block> pots = new ArrayList<Block>();

        flowers.forEach((Block flower) -> pots.add(create_flowerPot(name, flower, properties)));

        return pots;
    }

    ////

    /**
     * 
     * @param name
     * @param color
     * @return
     */
    public static Block create_carpet(String name, DyeColor color) {
        return BlockRegistry.register(name, new CarpetBlock(color, Properties.copy(Blocks.WHITE_CARPET)));
    }

    /**
     * 
     * @param name
     * @param color
     * @param group
     * @return
     */
    public static Block create_carpet(String name, DyeColor color, ItemGroup group) {
        return BlockRegistry.register(name, new CarpetBlock(color, Properties.copy(Blocks.WHITE_CARPET)), group);
    }

    /**
     * 
     * @param name
     * @param color
     * @param properties
     * @return
     */
    public static Block create_carpet(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new CarpetBlock(color, properties));
    }

    /**
     * 
     * @param name
     * @param color
     * @param properties
     * @param group
     * @return
     */
    public static Block create_carpet(String name, DyeColor color, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CarpetBlock(color, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static Block create_endRod(String name) {
        return BlockRegistry.register(name, new EndRodBlock(Properties.copy(Blocks.END_ROD)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static Block create_endRod(String name, ItemGroup group) {
        return BlockRegistry.register(name, new EndRodBlock(Properties.copy(Blocks.END_ROD)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static Block create_endRod(String name, Properties properties) {
        return BlockRegistry.register(name, new EndRodBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static Block create_endRod(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new EndRodBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_ladder(String name) {
        return BlockRegistry.register(name, new LadderBlock(Properties.copy(Blocks.LADDER)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_ladder(String name, ItemGroup group) {
        return BlockRegistry.register(name, new LadderBlock(Properties.copy(Blocks.LADDER)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_ladder(String name, Properties properties) {
        return BlockRegistry.register(name, new LadderBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_ladder(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new LadderBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pile(String name) {
        return BlockRegistry.register(name, new SnowBlock(Properties.copy(Blocks.SNOW)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pile(String name, ItemGroup group) {
        return BlockRegistry.register(name, new SnowBlock(Properties.copy(Blocks.SNOW)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pile(String name, Properties properties) {
        return BlockRegistry.register(name, new SnowBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pile(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SnowBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pane(String name) {
        return BlockRegistry.register(name, new PaneBlock(Properties.copy(Blocks.GLASS_PANE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pane_bars(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PaneBlock(Properties.copy(Blocks.IRON_BARS)), group);
    }

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pane_bars(String name) {
        return BlockRegistry.register(name, new PaneBlock(Properties.copy(Blocks.IRON_BARS)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pane(String name, ItemGroup group) {
        return BlockRegistry.register(name, new PaneBlock(Properties.copy(Blocks.GLASS_PANE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pane(String name, Properties properties) {
        return BlockRegistry.register(name, new PaneBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pane(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new PaneBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_chain(String name) {
        return BlockRegistry.register(name, new ChainBlock(Properties.copy(Blocks.CHAIN)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_chain(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ChainBlock(Properties.copy(Blocks.CHAIN)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_chain(String name, Properties properties) {
        return BlockRegistry.register(name, new ChainBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_chain(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ChainBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_slimeBlock(String name) {
        return BlockRegistry.register(name, new SlimeBlock(Properties.copy(Blocks.SLIME_BLOCK)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_slimeBlock(String name, ItemGroup group) {
        return BlockRegistry.register(name, new SlimeBlock(Properties.copy(Blocks.SLIME_BLOCK)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_slimeBlock(String name, Properties properties) {
        return BlockRegistry.register(name, new SlimeBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_slimeBlock(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SlimeBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_honeyBlock(String name) {
        return BlockRegistry.register(name, new HoneyBlock(Properties.copy(Blocks.HONEY_BLOCK)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_honeyBlock(String name, ItemGroup group) {
        return BlockRegistry.register(name, new HoneyBlock(Properties.copy(Blocks.HONEY_BLOCK)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_honeyBlock(String name, Properties properties) {
        return BlockRegistry.register(name, new HoneyBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_honeyBlock(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new HoneyBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_scaffolding(String name) {
        return BlockRegistry.register(name, new ScaffoldingBlock(Properties.copy(Blocks.SCAFFOLDING)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_scaffolding(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ScaffoldingBlock(Properties.copy(Blocks.SCAFFOLDING)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_scaffolding(String name, Properties properties) {
        return BlockRegistry.register(name, new ScaffoldingBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_scaffolding(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ScaffoldingBlock(properties), group);
    }

    ////

    // /**
    // *
    // * @param name
    // * @return
    // */
    // public static final Block create_skull(String name) {
    // return BlockRegistry.register(name, new SkullBlock(p_i48332_1_,
    // p_i48332_2_));
    // }

    // /**
    // *
    // * @param name
    // * @param group
    // * @return
    // */
    // public static final Block create_skull(String name, ItemGroup group) {
    // return BlockRegistry.register(name, new SkullBlock(p_i48332_1_, p_i48332_2_),
    // group);
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @return
    // */
    // public static final Block create_skull(String name, Properties properties) {
    // return BlockRegistry.register(name, new SkullBlock(p_i48332_1_,
    // p_i48332_2_));
    // }

    // /**
    // *
    // * @param name
    // * @param properties
    // * @param group
    // * @return
    // */
    // public static final Block create_skull(String name, Properties properties,
    // ItemGroup group) {
    // return BlockRegistry.register(name, new SkullBlock(p_i48332_1_, p_i48332_2_),
    // group);
    // }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_banner(String name, DyeColor color) {
        return BlockRegistry.register(name, new BannerBlock(color, Properties.copy(Blocks.WHITE_BANNER)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_banner(String name, DyeColor color, ItemGroup group) {
        return BlockRegistry.register(name, new BannerBlock(color, Properties.copy(Blocks.WHITE_BANNER)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_banner(String name, DyeColor color, Properties properties) {
        return BlockRegistry.register(name, new BannerBlock(color, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_banner(String name, DyeColor color, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BannerBlock(color, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_bell(String name) {
        return BlockRegistry.register(name, new BellBlock(Properties.copy(Blocks.BELL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_bell(String name, ItemGroup group) {
        return BlockRegistry.register(name, new BellBlock(Properties.copy(Blocks.BELL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_bell(String name, Properties properties) {
        return BlockRegistry.register(name, new BellBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_bell(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BellBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_lantern(String name) {
        return BlockRegistry.register(name, new LanternBlock(Properties.copy(Blocks.LANTERN)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_lantern(String name, ItemGroup group) {
        return BlockRegistry.register(name, new LanternBlock(Properties.copy(Blocks.LANTERN)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_lantern(String name, Properties properties) {
        return BlockRegistry.register(name, new LanternBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_lantern(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new LanternBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage) {
        return BlockRegistry.register(name,
                new CampfireBlock(spawnParticles, fireDamage, Properties.copy(Blocks.CAMPFIRE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            ItemGroup group) {
        return BlockRegistry.register(name,
                new CampfireBlock(spawnParticles, fireDamage, Properties.copy(Blocks.CAMPFIRE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            Properties properties) {
        return BlockRegistry.register(name, new CampfireBlock(spawnParticles, fireDamage, properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_campfire(String name, Boolean spawnParticles, Integer fireDamage,
            Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CampfireBlock(spawnParticles, fireDamage, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_fire(String name) {
        return BlockRegistry.register(name, new FireBlock(Properties.copy(Blocks.FIRE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_fire(String name, ItemGroup group) {
        return BlockRegistry.register(name, new FireBlock(Properties.copy(Blocks.FIRE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_fire(String name, Properties properties) {
        return BlockRegistry.register(name, new FireBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_fire(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FireBlock(properties), group);
    }
}