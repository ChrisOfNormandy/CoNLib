package com.github.chrisofnormandy.conlib.items.tools;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class Shovels {

    public static final Item create(String name) {
        return create(name, new Item.Properties());
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, Tiers.IRON, 2, -3.0F);
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Tiers.IRON, 2, -3.0F, creativeTab);
    }

    public static final Item create(String name, Properties properties, Tier tier) {
        return create(name, new Item.Properties(), tier, 2, -3.0F);
    }

    public static final Item create(String name, Properties properties, Tier tier,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), tier, 2, -3.0F, creativeTab);
    }

    public static final Item create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        return create(name, new Item.Properties(), tier, attackDamage, attackSpeed);
    }

    public static final Item create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        Item shovel = new ShovelItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, shovel);

        return ItemRegistry.register(name, shovel);
    }

    public static final Item create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item shovel = new ShovelItem(tier, attackDamage, attackSpeed, properties);
        ModRegister.tools.put(name, shovel);

        return ItemRegistry.register(name, shovel, creativeTab);
    }
}
