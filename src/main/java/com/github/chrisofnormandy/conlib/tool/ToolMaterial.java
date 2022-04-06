package com.github.chrisofnormandy.conlib.tool;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item.Properties;

public class ToolMaterial {

    private int level;
    private int maxDamage;
    private boolean immuneToFire;
    private Rarity rarity;
    private boolean noRepair;

    public enum type {
        gem, ingot, material
    };

    private type resource_type;

    private Properties properties;

    /**
     * 
     * @param level
     * @param maxDamage
     * @param immuneToFire
     * @param rarity
     * @param noRepair
     * @param resource_type
     */
    public ToolMaterial(int level, int maxDamage, boolean immuneToFire, Rarity rarity, boolean noRepair,
            type resource_type) {
        this.level = level;
        this.maxDamage = maxDamage;
        this.immuneToFire = immuneToFire;
        this.rarity = rarity;
        this.noRepair = noRepair;
        this.resource_type = resource_type;

        this.properties = new Properties().durability(maxDamage).rarity(rarity);

        if (immuneToFire)
            this.properties = properties.fireResistant();
        if (noRepair)
            this.properties = properties.setNoRepair();
    }

    /**
     * 
     * @return
     */
    public Properties getProperties() {
        return this.properties;
    }

    /**
     * 
     * @return
     */
    public int level() {
        return level;
    }

    /**
     * 
     * @return
     */
    public int maxDamage() {
        return maxDamage;
    }

    /**
     * 
     * @return
     */
    public boolean isImmuneToFire() {
        return immuneToFire;
    }

    /**
     * 
     * @return
     */
    public Rarity rarity() {
        return rarity;
    }

    /**
     * 
     * @return
     */
    public boolean noRepair() {
        return noRepair;
    }

    /**
     * 
     * @return
     */
    public type getType() {
        return resource_type;
    }
}
