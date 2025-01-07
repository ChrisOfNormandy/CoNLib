package com.github.chrisofnormandy.conlib.blocks.plants.gourds;

import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.CarvedGourd;
import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.EquipableCarvedGourd;
import com.github.chrisofnormandy.conlib.blocks.plants.gourds.types.Gourd;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.crops.Stems;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;

public class GourdSets {
    public static final Block[] create(String name, Item seeds) {
        // CarvedGourd carved = CarvedGourds.create(name);
        EquipableCarvedGourd weableCarved = EquipableGourds.create(name);
        CarvedGourd lantern = CarvedGourdLanterns.create(name);

        Gourd gourd = Gourds.create(name)
                .setCarvedBlock(weableCarved)
                .setSeeds(seeds);

        Tuple<StemBlock, AttachedStemBlock> stems = Stems.create(name, gourd, seeds);

        gourd.setStemBlock(stems.x)
                .setAttachedStemBlock(stems.y);

        return new Block[] {
                gourd,
                weableCarved,
                lantern,
                stems.x,
                stems.y
        };
    }
}
