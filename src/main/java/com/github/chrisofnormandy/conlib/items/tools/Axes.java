package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Axes {

    public static final Item create(String name) {
        return create(name, new Properties(), Tiers.IRON, 6, -3.1F);
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), Tiers.IRON, 6, -3.1F, creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, Tiers.IRON, 6, -3.1F);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Tiers.IRON, 6, -3.1F, creativeTab);
    }

    public static final Item create(String name, Properties properties, Tier tier) {
        return create(name, new Properties(), tier, 6, -3.1F);
    }

    public static final Item create(String name, Properties properties, Tier tier,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, 6, -3.1F, creativeTab);
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
        Item axe = new AxeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, axe);

        return ItemRegistry.register(name, axe);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item axe = new AxeItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, axe);

        return ItemRegistry.register(name, axe, creativeTab);
    }
}
