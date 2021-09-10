package com.github.chrisofnormandy.conlib.tool;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;

public class ToolBase extends ToolItem {

    /**
     * 
     * @param attackDamage
     * @param attackSpeed
     * @param tier
     * @param blockSet
     * @param properties
     */
    public ToolBase(Float attackDamage, Float attackSpeed, ItemTier tier, Set<Block> blockSet,
            Item.Properties properties) {
        super(attackDamage, attackSpeed, tier, blockSet, properties);
    }
}