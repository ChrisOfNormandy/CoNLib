package com.github.chrisofnormandy.conlib.blocks.plants.melons;

import com.github.chrisofnormandy.conlib.blocks.plants.melons.types.Melon;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.crops.Stems;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;

public class MelonSets {
    public static final Block[] create(String name, Item seeds) {
        Melon melon = Melons.create(name);

        Tuple<StemBlock, AttachedStemBlock> stems = Stems.create(name, melon, seeds);
        melon.setStem(stems.x)
                .setAttachedStem(stems.y);

        return new Block[] { melon, stems.x, stems.y };
    }
}
