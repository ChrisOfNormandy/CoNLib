package com.conlib.registry;

// import com.conmod.conlib.block.OreBase;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegister {
    public ModRegister() {

    }

    public static Block rock(int harvestLevel) {
        return new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f).sound(SoundType.STONE).harvestLevel(harvestLevel));
    }

    public static Block slab(Block parent) {
        return new SlabBlock(Block.Properties.from(parent));
    }

    public static Block stairs(Block parent) {
        return new StairsBlock(() -> parent.getDefaultState(), Block.Properties.from(parent));
    }

    public static Block wall(Block parent) {
        return new WallBlock(Block.Properties.from(parent));
    }

    public static Item registerItem(String name, Properties properties) {
        Item item = new Item(properties).setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

    public static Food registerFoodNoItem(int hunger, float saturation) {
        return (new Food.Builder()).saturation(saturation).hunger(hunger).build();
    }

    public static Item registerFood(String name, int hunger, float saturation, ItemGroup group) {
        Food food = (new Food.Builder()).saturation(saturation).hunger(hunger).build();
        return registerItem(name, new Item.Properties().food(food).group(group));
    }

    public static Item registerFood(String name, Food food, ItemGroup group) {
        return registerItem(name, new Item.Properties().food(food).group(group));
    }

    public static Block registerBlock(Block block, String name, ItemGroup group)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(group));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }
    
    public static Block registerBlock(Block block, BlockItem itemBlock, String name) {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);

        if (itemBlock != null) {
            itemBlock.setRegistryName(name);
            ForgeRegistries.ITEMS.register(itemBlock);
        }

        return block;
    }
}