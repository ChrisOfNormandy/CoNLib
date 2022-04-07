package com.github.chrisofnormandy.conlib.block.decoration;

import java.util.ArrayList;
import java.util.List;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.ScaffoldingBlock;
// import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;

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
    public static final Block create_web(String name, CreativeModeTab group) {
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
    public static final Block create_web(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_torch(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new TorchBlock(Properties.copy(Blocks.TORCH), ParticleTypes.FLAME), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @param particle
     * @return
     */
    public static final Block create_torch(String name, Properties properties, ParticleOptions particle) {
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
    public static final Block create_torch(String name, Properties properties,
            ParticleOptions particle,
            CreativeModeTab group) {
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
    public static Block create_emptyPot(String name, CreativeModeTab group) {
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
    public static Block create_flowerPot(String name, Block flower, CreativeModeTab group) {
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
    public static Block create_emptyPot(String name, Properties properties, CreativeModeTab group) {
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
    public static Block create_flowerPot(String name, Block flower, Properties properties, CreativeModeTab group) {
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
    public static Block create_carpet(String name) {
        return BlockRegistry.register(name, new CarpetBlock(Properties.copy(Blocks.WHITE_CARPET)));
    }

    /**
     * 
     * @param name
     * @param color
     * @param group
     * @return
     */
    public static Block create_carpet(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new CarpetBlock(Properties.copy(Blocks.WHITE_CARPET)), group);
    }

    /**
     * 
     * @param name
     * @param color
     * @param properties
     * @return
     */
    public static Block create_carpet(String name, Properties properties) {
        return BlockRegistry.register(name, new CarpetBlock(properties));
    }

    /**
     * 
     * @param name
     * @param color
     * @param properties
     * @param group
     * @return
     */
    public static Block create_carpet(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new CarpetBlock(properties), group);
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
    public static Block create_endRod(String name, CreativeModeTab group) {
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
    public static Block create_endRod(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_ladder(String name, CreativeModeTab group) {
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
    public static final Block create_ladder(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new LadderBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pile(String name) {
        return BlockRegistry.register(name, new SnowLayerBlock(Properties.copy(Blocks.SNOW)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pile(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new SnowLayerBlock(Properties.copy(Blocks.SNOW)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pile(String name, Properties properties) {
        return BlockRegistry.register(name, new SnowLayerBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pile(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new SnowLayerBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pane(String name) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.GLASS_PANE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pane_bars(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.IRON_BARS)), group);
    }

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_pane_bars(String name) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.IRON_BARS)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_pane(String name, CreativeModeTab group) {
        return BlockRegistry.register(name, new IronBarsBlock(Properties.copy(Blocks.GLASS_PANE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_pane(String name, Properties properties) {
        return BlockRegistry.register(name, new IronBarsBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_pane(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new IronBarsBlock(properties), group);
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
    public static final Block create_chain(String name, CreativeModeTab group) {
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
    public static final Block create_chain(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_slimeBlock(String name, CreativeModeTab group) {
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
    public static final Block create_slimeBlock(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_honeyBlock(String name, CreativeModeTab group) {
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
    public static final Block create_honeyBlock(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_scaffolding(String name, CreativeModeTab group) {
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
    public static final Block create_scaffolding(String name, Properties properties, CreativeModeTab group) {
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
    // public static final Block create_skull(String name, CreativeModeTab group) {
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
    // CreativeModeTab group) {
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
    public static final Block create_banner(String name, DyeColor color, CreativeModeTab group) {
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
    public static final Block create_banner(String name, DyeColor color, Properties properties, CreativeModeTab group) {
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
    public static final Block create_bell(String name, CreativeModeTab group) {
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
    public static final Block create_bell(String name, Properties properties, CreativeModeTab group) {
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
    public static final Block create_lantern(String name, CreativeModeTab group) {
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
    public static final Block create_lantern(String name, Properties properties, CreativeModeTab group) {
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
            CreativeModeTab group) {
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
            Properties properties, CreativeModeTab group) {
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
    public static final Block create_fire(String name, CreativeModeTab group) {
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
    public static final Block create_fire(String name, Properties properties, CreativeModeTab group) {
        return BlockRegistry.register(name, new FireBlock(properties), group);
    }
}