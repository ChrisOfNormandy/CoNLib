package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Hoes {

    public static final Item create(String name) {
        return create(name, new Properties(), Tiers.IRON, 0, -3.0F);
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), Tiers.IRON, 0, -3.0F, creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, Tiers.IRON, 0, -3.0F);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Tiers.IRON, 0, -3.0F, creativeTab);
    }

    public static final Item create(String name, Properties properties, Tier tier) {
        return create(name, new Properties(), tier, 0, -3.0F);
    }

    public static final Item create(String name, Properties properties, Tier tier,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, 0, -3.0F, creativeTab);
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
        Item hoe = new HoeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, hoe);

        return ItemRegistry.register(name, hoe);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item hoe = new HoeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, hoe);

        return ItemRegistry.register(name, hoe, creativeTab);
    }
}
