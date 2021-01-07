package com.github.chrisofnormandy.conlib.tool;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;

public class ToolMaterial {

    private int level;
    private int maxDamage;
    private boolean immuneToFire;
    private Rarity rarity;
    private boolean noRepair;

    public enum type{gem, ingot, material};
    private type resource_type;

    private Properties properties;

    public ToolMaterial (int level, int maxDamage, boolean immuneToFire, Rarity rarity, boolean noRepair, type resource_type) {
        this.level = level;
        this.maxDamage = maxDamage;
        this.immuneToFire = immuneToFire;
        this.rarity = rarity;
        this.noRepair = noRepair;
        this.resource_type = resource_type;
        
        this.properties = new Properties().maxDamage(maxDamage).rarity(rarity);

        if (immuneToFire)
            this.properties = properties.isImmuneToFire();
        if (noRepair)
            this.properties = properties.setNoRepair();
    }

    public Properties getProperties() {
        return this.properties;
    }

    public int level() {
        return level;
    }

    public int maxDamage() {
        return maxDamage;
    }

    public boolean isImmuneToFire() {
        return immuneToFire;
    }

    public Rarity rarity() {
        return rarity;
    }

    public boolean noRepair() {
        return noRepair;
    }

    public type getType() {
        return resource_type;
    }
}
