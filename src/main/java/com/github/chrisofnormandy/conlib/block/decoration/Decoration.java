package com.github.chrisofnormandy.conlib.block.decoration;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.client.particle.Particle;
import net.minecraft.item.DyeColor;
import net.minecraft.particles.IParticleData;

public class Decoration {
    /**
     * 
     * @param flower
     * @param parent
     * @return
     */
    public static Block create_pot(Block flower, Block parent) {
        return new FlowerPotBlock(null, () -> flower, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param flower
     * @param properties
     * @return
     */
    public static Block create_pot(Block flower, Block.Properties properties) {
        return new FlowerPotBlock(null, () -> flower, properties);
    }

    /**
     * 
     * @param empty
     * @param flower
     * @param parent
     * @return
     */
    public static Block create_pot(FlowerPotBlock empty, Block flower, Block parent) {
        return new FlowerPotBlock(() -> empty, () -> flower, Block.Properties.copy(parent));
    }

    /**
     * 
     * @param empty
     * @param flower
     * @param properties
     * @return
     */
    public static Block create_pot(FlowerPotBlock empty, Block flower, Block.Properties properties) {
        return new FlowerPotBlock(() -> empty, () -> flower, properties);
    }

    /**
     * 
     * @param flowers
     * @param parent
     */
    public static void create_pots(List<Block> flowers, Block parent) {
        flowers.forEach((Block flower) -> create_pot(flower, parent));
    }

    /**
     * 
     * @param flowers
     * @param empty
     * @param parent
     */
    public static void create_pots(List<Block> flowers, FlowerPotBlock empty, Block parent) {
        flowers.forEach((Block flower) -> create_pot(empty, flower, parent));
    }

    /**
     * 
     * @param color
     * @param parent
     * @return
     */
    public static Block create_carpet(DyeColor color, Block parent) {
        return new CarpetBlock(color, Block.Properties.copy(parent));
    }

    // public static Block create_torch(Block parent) {
    //     return new TorchBlock(Properties.copy(parent), Particle)
    // }
}
