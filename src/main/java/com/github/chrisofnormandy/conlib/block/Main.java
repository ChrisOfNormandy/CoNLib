package com.github.chrisofnormandy.conlib.block;

import com.github.chrisofnormandy.conlib.config.Config;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;

public class Main {
    public static String[] dyes = com.github.chrisofnormandy.conlib.item.Main.dyes;

    public static Block create_rock(int harvestLevel) {
        return new Block(Properties.create(Material.ROCK).hardnessAndResistance(3.0f).sound(SoundType.STONE)
                .harvestLevel(harvestLevel));
    }

    public static Block create_brick() {
        return new Block(Properties.from(Blocks.BRICKS));
    }

    public static Block create_wood() {
        return new Block(Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD));
    }

    public static Block create_slab(Block parent) {
        return new SlabBlock(Properties.from(parent));
    }

    public static Block create_stairs(Block parent) {
        return new StairsBlock(() -> parent.getDefaultState(), Properties.from(parent));
    }

    public static Block create_wall(Block parent) {
        return new WallBlock(Properties.from(parent));
    }

    public static Block create_fence(Block parent) {
        return new FenceBlock(Properties.from(parent));
    }

    public static Block create_fenceGate(Block parent) {
        return new FenceGateBlock(Properties.from(parent));
    }

    /**
     * 
     * @param name
     * @param harvestLevel
     * @param groups        0: Blocks, 1: Slabs, 2: Stairs, 3: Walls
     */
    static void registerBlockWithProducts(String name, Block block, ItemGroup[] groups) {
        ModRegister.registerBlock(name, block, groups[0]);
        ModRegister.registerBlock(name + "_slab", create_slab(block), groups[1]);
        ModRegister.registerBlock(name + "_stairs", create_stairs(block), groups[2]);
        ModRegister.registerBlock(name + "_wall", create_wall(block), groups[3]);
    }

    /**
     * 
     * @param name
     * @param harvestLevel
     * @param groups        0: Blocks, 1: Slabs, 2: Stairs, 3: Walls
     */
    public static void registerRockSuite(String name, int harvestLevel, ItemGroup[] groups) {
        Block block = create_rock(harvestLevel);
        registerBlockWithProducts(name, block, groups);
    }

    /**
     * 
     * @param name
     * @param harvestLevel
     * @param groups        0: Blocks, 1: Slabs, 2: Stairs, 3: Walls
     * @param includeBase   Whether or not to register mossy and cracked versions of the standard block
     */
    public static void registerRockSuite_withProducts(String name, int harvestLevel, ItemGroup[] groups, boolean includeBase) {
        Block block = create_rock(harvestLevel);

        registerBlockWithProducts(name, block, groups);
        if (includeBase) {
            registerBlockWithProducts("mossy_" + name, new Block(Properties.from(block)), groups);
            registerBlockWithProducts("cracked_" + name, new Block(Properties.from(block)), groups);
        }
        registerBlockWithProducts(name + "_bricks", new Block(Properties.from(block)), groups);
        registerBlockWithProducts("mossy_" + name + "_bricks", new Block(Properties.from(block)), groups);
        registerBlockWithProducts("cracked_" + name + "_bricks", new Block(Properties.from(block)), groups);
    }

    public static void registerBrickSuite(String name, ItemGroup[] groups) {
        registerBlockWithProducts(name + "_bricks", create_brick(), groups);
        registerBlockWithProducts(name + "_bricks_large", create_brick(), groups);
        registerBlockWithProducts(name + "_bricks_large_tile", create_brick(), groups);
        registerBlockWithProducts(name + "_bricks_mixed", create_brick(), groups);
    }

    public static void registerBrickSuite(String name, Block block, ItemGroup[] groups) {
        registerBlockWithProducts(name, block, groups);
        registerBlockWithProducts(name + "_bricks", new Block(Properties.from(block)), groups);
        registerBlockWithProducts(name + "_bricks_large", new Block(Properties.from(block)), groups);
        registerBlockWithProducts(name + "_bricks_large_tile", new Block(Properties.from(block)), groups);
        registerBlockWithProducts(name + "_bricks_mixed", new Block(Properties.from(block)), groups);
    }

    public static void registerWoodSuite(String name, ItemGroup group) {
        Block log = create_wood();
        Block planks = create_wood();

        ModRegister.registerBlock(name + "_log", log, group);

        ModRegister.registerBlock(name + "_planks", planks);
        ModRegister.registerBlock(name + "_slab", create_slab(planks), group);
        ModRegister.registerBlock(name + "_stairs", create_stairs(planks), group);
        ModRegister.registerBlock(name + "_fence", create_fence(planks), group);
        ModRegister.registerBlock(name + "_fence_gate", create_fenceGate(planks), group);
    }

    public static void registerDyedSuite(String name, Block parent, ItemGroup group) {
        for (int i = 0; i < dyes.length; i++) {
            ModRegister.registerBlock(dyes[i] + "_" + name, new Block(Properties.from(parent)), group);
        }
    }

    public static Node create_node(Block parent, Node.Tier tier, int damage) {
        return new Node(Properties.from(parent), tier, damage, parent.asItem());
    }

    public static void registerNode(String name, Block parent, Node.Tier tier, ItemGroup group) {
        int crude = Config.getRangeValue("nodes_crude_tiers");
        int normal = Config.getRangeValue("nodes_normal_tiers");
        int rich = Config.getRangeValue("nodes_rich_tiers");

        int count = 0;

        switch (tier) {
            case CRUDE: {
                count = crude;
                break;
            }
            case NORMAL: {
                count = normal;
                break;
            }
            case RICH: {
                count = rich;
                break;
            }
        }

        Node n = create_node(parent, tier, count);

        Block node = ModRegister.registerBlock(name, n, group);
        ModRegister.nodes.put(node.getRegistryName().toString(), n);

        Block old_ = node;
        Block new_ = null;

        for (int i = count - 1; i >= 0; i--) {
            new_ = (i > 0)
                ? ModRegister.registerBlock(name + "_" + i, create_node(parent, tier, i))
                : parent;

            old_ = ModRegister.setBlock_replaceable(old_, new_);

            ModRegister.registerNode(new_.getRegistryName().toString(), n);
        }
    }

    // public static Block create_ore_gem(String name, int minXp, int maxXp, ItemGroup group, Properties properties) {
    //     Block block = ModRegister.registerOre(name, minXp, maxXp, properties, "gem", group);

    //     return block;
    // }

    // public static Block create_ore_resource() {

    // }

    // public static Block create_ore_fuel() {

    // }
}
