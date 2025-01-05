package com.github.chrisofnormandy.conlib.items.combat;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Swords {

    public static final Item create(String name) {
        return create(name, new Item.Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, Tiers.IRON, 3, -2.4F);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Tiers.IRON, 3, -2.4F, creativeTab);
    }

    public static final Item create(String name, Properties properties, Tier tier) {
        return create(name, new Properties(), tier, 3, -2.4F);
    }

    public static final Item create(String name, Properties properties, Tier tier,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, 3, -2.4F, creativeTab);
    }

    public static final Item create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        return create(name, new Properties(), tier, attackDamage, attackSpeed);
    }

    public static final Item create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        Item sword = new SwordItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.weapons.put(name, sword);

        return ItemRegistry.register(name, sword);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item sword = new SwordItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.weapons.put(name, sword);

        return ItemRegistry.register(name, sword, creativeTab);
    }
}
