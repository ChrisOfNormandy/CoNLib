package com.github.chrisofnormandy.conlib.items.food;

import com.github.chrisofnormandy.conlib.registry.ItemRegistry;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class Foods {
    public static final FoodProperties properties(Integer hunger, Float saturation) {
        return new FoodProperties.Builder().saturationMod(saturation).nutrition(hunger).build();
    }

    public static final Item create(String name) {
        return create(name, properties(1, 0.6f));
    }

    public static final Item create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties(1, 0.6f), creativeTab);
    }

    public static final Item create(String name, FoodProperties food) {
        return create(name, new Properties(), food);
    }

    public static final Item create(String name, FoodProperties food, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, new Properties(), food, creativeTab);
    }

    public static final Item create(String name, Properties properties) {
        return create(name, properties, properties(1, 0.6f));
    }

    public static final Item create(String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(name, properties, properties(1, 0.6f), creativeTab);
    }

    public static final Item create(String name, Properties properties, FoodProperties food) {
        Item item = ItemRegistry.register(name, properties.food(food));
        ModRegister.foods.put(name, item);

        return item;
    }

    public static final Item create(String name, Properties properties, FoodProperties food,
            ResourceKey<CreativeModeTab> creativeTab) {
        Item item = ItemRegistry.register(name, properties.food(food), creativeTab);
        ModRegister.foods.put(name, item);

        return item;
    }
}
