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
import net.minecraftforge.registries.RegistryObject;

public class Swords {

    public static final RegistryObject<SwordItem> create(String name) {
        return create(name, new Item.Properties());
    }

    public static final RegistryObject<SwordItem> create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Item.Properties(), creativeTab);
    }

    public static final RegistryObject<SwordItem> create(String name, Properties properties) {
        return create(name, properties, Tiers.IRON, 3, -2.4F);
    }

    public static final RegistryObject<SwordItem> create(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, Tiers.IRON, 3, -2.4F, creativeTab);
    }

    public static final RegistryObject<SwordItem> create(String name, Properties properties, Tier tier) {
        return create(name, new Properties(), tier, 3, -2.4F);
    }

    public static final RegistryObject<SwordItem> create(String name, Properties properties, Tier tier,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, 3, -2.4F, creativeTab);
    }

    public static final RegistryObject<SwordItem> create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        return create(name, new Properties(), tier, attackDamage, attackSpeed);
    }

    public static final RegistryObject<SwordItem> create(String name,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), tier, attackDamage, attackSpeed, creativeTab);
    }

    public static final RegistryObject<SwordItem> create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed) {
        var sword = ItemRegistry.register(name, () -> new SwordItem(tier, attackDamage, attackSpeed, properties));
        ModRegister.weapons.put(name, sword);

        return sword;
    }

    public static final RegistryObject<SwordItem> create(String name,
            Properties properties,
            Tier tier,
            Integer attackDamage,
            Float attackSpeed,
            ResourceKey<CreativeModeTab> creativeTab) {
        var sword = ItemRegistry.register(name, () -> new SwordItem(tier, attackDamage, attackSpeed, properties),
                creativeTab);
        ModRegister.weapons.put(name, sword);

        return sword;
    }
}
