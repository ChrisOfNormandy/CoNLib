package com.github.chrisofnormandy.conlib.block.types.custom;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NodeBase extends Block {
    public enum Tier{CRUDE, NORMAL, RICH};

    private Tier tier;
    private int damage;

    private Item item;

    public NodeBase(Properties properties, Tier tier, int damage, Item drop) {
        super(properties);

        this.tier = tier;
        this.damage = damage;
        this.item = drop;
    }

    public Tier getTier() {
        return this.tier;
    }

    public int getDamage() {
        return this.damage;
    }

    public Item getDropItem() {
        return this.item;
    }

    public ItemStack getDrop(@Nullable Random rand) {
        int max = this.tier == Tier.CRUDE ? 1 : tier == Tier.NORMAL ? 2 : 3;
        
        int count = (rand != null)
            ? rand.nextInt(max + 1) + 1
            : max;

        return new ItemStack(this.item, count);
    }
}
