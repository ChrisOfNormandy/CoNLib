package com.github.chrisofnormandy.conlib.blocks.plants.melons.types;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class Melon extends StemGrownBlock {

    private StemBlock stemBlock;
    private AttachedStemBlock attachedStemBlock;

    public Melon(Properties properties) {
        super(properties);
    }

    public StemBlock getStem() {
        return this.stemBlock;
    }

    public Melon setStem(StemBlock stemBlock) {
        this.stemBlock = stemBlock;
        return this;
    }

    public AttachedStemBlock getAttachedStem() {
        return this.attachedStemBlock;
    }

    public Melon setAttachedStem(AttachedStemBlock attachedStemBlock) {
        this.attachedStemBlock = attachedStemBlock;
        return this;
    }
}
