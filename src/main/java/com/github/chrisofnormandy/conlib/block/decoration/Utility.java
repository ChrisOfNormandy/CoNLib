package com.github.chrisofnormandy.conlib.block.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlastFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.block.CartographyTableBlock;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.FletchingTableBlock;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.LoomBlock;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;

public class Utility {
    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_craftingTable(String name) {
        return BlockRegistry.register(name, new CraftingTableBlock(Properties.copy(Blocks.CRAFTING_TABLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_craftingTable(String name, ItemGroup group) {
        return BlockRegistry.register(name, new CraftingTableBlock(Properties.copy(Blocks.CRAFTING_TABLE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_craftingTable(String name, Properties properties) {
        return BlockRegistry.register(name, new CraftingTableBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_craftingTable(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CraftingTableBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_furnace(String name) {
        return BlockRegistry.register(name, new FurnaceBlock(Properties.copy(Blocks.FURNACE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_furnace(String name, ItemGroup group) {
        return BlockRegistry.register(name, new FurnaceBlock(Properties.copy(Blocks.FURNACE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_furnace(String name, Properties properties) {
        return BlockRegistry.register(name, new FurnaceBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_furnace(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FurnaceBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_anvil(String name) {
        return BlockRegistry.register(name, new AnvilBlock(Properties.copy(Blocks.ANVIL)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_anvil(String name, ItemGroup group) {
        return BlockRegistry.register(name, new AnvilBlock(Properties.copy(Blocks.ANVIL)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_anvil(String name, Properties properties) {
        return BlockRegistry.register(name, new AnvilBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_anvil(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new AnvilBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_grindstone(String name) {
        return BlockRegistry.register(name, new GrindstoneBlock(Properties.copy(Blocks.GRINDSTONE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_grindstone(String name, ItemGroup group) {
        return BlockRegistry.register(name, new GrindstoneBlock(Properties.copy(Blocks.GRINDSTONE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_grindstone(String name, Properties properties) {
        return BlockRegistry.register(name, new GrindstoneBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_grindstone(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new GrindstoneBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_composter(String name) {
        return BlockRegistry.register(name, new ComposterBlock(Properties.copy(Blocks.COMPOSTER)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_composter(String name, ItemGroup group) {
        return BlockRegistry.register(name, new ComposterBlock(Properties.copy(Blocks.COMPOSTER)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_composter(String name, Properties properties) {
        return BlockRegistry.register(name, new ComposterBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_composter(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new ComposterBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_brewingStand(String name) {
        return BlockRegistry.register(name, new BrewingStandBlock(Properties.copy(Blocks.BREWING_STAND)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_brewingStand(String name, ItemGroup group) {
        return BlockRegistry.register(name, new BrewingStandBlock(Properties.copy(Blocks.BREWING_STAND)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_brewingStand(String name, Properties properties) {
        return BlockRegistry.register(name, new BrewingStandBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_brewingStand(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BrewingStandBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_cauldron(String name) {
        return BlockRegistry.register(name, new CauldronBlock(Properties.copy(Blocks.CAULDRON)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_cauldron(String name, ItemGroup group) {
        return BlockRegistry.register(name, new CauldronBlock(Properties.copy(Blocks.CAULDRON)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_cauldron(String name, Properties properties) {
        return BlockRegistry.register(name, new CauldronBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_cauldron(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CauldronBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_stonecutter(String name) {
        return BlockRegistry.register(name, new StonecutterBlock(Properties.copy(Blocks.STONECUTTER)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_stonecutter(String name, ItemGroup group) {
        return BlockRegistry.register(name, new StonecutterBlock(Properties.copy(Blocks.STONECUTTER)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_stonecutter(String name, Properties properties) {
        return BlockRegistry.register(name, new StonecutterBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_stonecutter(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new StonecutterBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_fletchingTable(String name) {
        return BlockRegistry.register(name, new FletchingTableBlock(Properties.copy(Blocks.FLETCHING_TABLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_fletchingTable(String name, ItemGroup group) {
        return BlockRegistry.register(name, new FletchingTableBlock(Properties.copy(Blocks.FLETCHING_TABLE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_fletchingTable(String name, Properties properties) {
        return BlockRegistry.register(name, new FletchingTableBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_fletchingTable(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FletchingTableBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_loom(String name) {
        return BlockRegistry.register(name, new LoomBlock(Properties.copy(Blocks.LOOM)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_loom(String name, ItemGroup group) {
        return BlockRegistry.register(name, new LoomBlock(Properties.copy(Blocks.LOOM)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_loom(String name, Properties properties) {
        return BlockRegistry.register(name, new LoomBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_loom(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new LoomBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_smoker(String name) {
        return BlockRegistry.register(name, new SmokerBlock(Properties.copy(Blocks.SMOKER)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_smoker(String name, ItemGroup group) {
        return BlockRegistry.register(name, new SmokerBlock(Properties.copy(Blocks.SMOKER)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_smoker(String name, Properties properties) {
        return BlockRegistry.register(name, new SmokerBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_smoker(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SmokerBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_blastFurnace(String name) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(Properties.copy(Blocks.BLAST_FURNACE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_blastFurnace(String name, ItemGroup group) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(Properties.copy(Blocks.BLAST_FURNACE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_blastFurnace(String name, Properties properties) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_blastFurnace(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_cartographyTable(String name) {
        return BlockRegistry.register(name, new CartographyTableBlock(Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_cartographyTable(String name, ItemGroup group) {
        return BlockRegistry.register(name, new CartographyTableBlock(Properties.copy(Blocks.CARTOGRAPHY_TABLE)),
                group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_cartographyTable(String name, Properties properties) {
        return BlockRegistry.register(name, new CartographyTableBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_cartographyTable(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new CartographyTableBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_smithingTable(String name) {
        return BlockRegistry.register(name, new SmithingTableBlock(Properties.copy(Blocks.SMITHING_TABLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_smithingTable(String name, ItemGroup group) {
        return BlockRegistry.register(name, new SmithingTableBlock(Properties.copy(Blocks.SMITHING_TABLE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_smithingTable(String name, Properties properties) {
        return BlockRegistry.register(name, new SmithingTableBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_smithingTable(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new SmithingTableBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_beehive(String name) {
        return BlockRegistry.register(name, new BeehiveBlock(Properties.copy(Blocks.BEEHIVE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_beehive(String name, ItemGroup group) {
        return BlockRegistry.register(name, new BeehiveBlock(Properties.copy(Blocks.BEEHIVE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_beehive(String name, Properties properties) {
        return BlockRegistry.register(name, new BeehiveBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_beehive(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BeehiveBlock(properties), group);
    }

    ////

    /**
     * 
     * @param color
     * @param name
     * @return
     */
    public static final Block create_bed(DyeColor color, String name) {
        return BlockRegistry.register(name, new BedBlock(color, Properties.copy(Blocks.WHITE_BED)));
    }

    /**
     * 
     * @param color
     * @param name
     * @param group
     * @return
     */
    public static final Block create_bed(DyeColor color, String name, ItemGroup group) {
        return BlockRegistry.register(name, new BedBlock(color, Properties.copy(Blocks.WHITE_BED)), group);
    }

    /**
     * 
     * @param color
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_bed(DyeColor color, String name, Properties properties) {
        return BlockRegistry.register(name, new BedBlock(color, properties));
    }

    /**
     * 
     * @param color
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_bed(DyeColor color, String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new BedBlock(color, properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_farmland(String name) {
        return BlockRegistry.register(name, new FarmlandBlock(Properties.copy(Blocks.FARMLAND)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_farmland(String name, ItemGroup group) {
        return BlockRegistry.register(name, new FarmlandBlock(Properties.copy(Blocks.FARMLAND)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_farmland(String name, Properties properties) {
        return BlockRegistry.register(name, new FarmlandBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_farmland(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new FarmlandBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_jukebox(String name) {
        return BlockRegistry.register(name, new JukeboxBlock(Properties.copy(Blocks.JUKEBOX)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_jukebox(String name, ItemGroup group) {
        return BlockRegistry.register(name, new JukeboxBlock(Properties.copy(Blocks.JUKEBOX)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_jukebox(String name, Properties properties) {
        return BlockRegistry.register(name, new JukeboxBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_jukebox(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new JukeboxBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_enchantingTable(String name) {
        return BlockRegistry.register(name, new EnchantingTableBlock(Properties.copy(Blocks.ENCHANTING_TABLE)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_enchantingTable(String name, ItemGroup group) {
        return BlockRegistry.register(name, new EnchantingTableBlock(Properties.copy(Blocks.ENCHANTING_TABLE)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_enchantingTable(String name, Properties properties) {
        return BlockRegistry.register(name, new EnchantingTableBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_enchantingTable(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new EnchantingTableBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_enderChest(String name) {
        return BlockRegistry.register(name, new EnderChestBlock(Properties.copy(Blocks.ENDER_CHEST)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_enderChest(String name, ItemGroup group) {
        return BlockRegistry.register(name, new EnderChestBlock(Properties.copy(Blocks.ENDER_CHEST)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_enderChest(String name, Properties properties) {
        return BlockRegistry.register(name, new EnderChestBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_enderChest(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new EnderChestBlock(properties), group);
    }

    ////

    /**
     * 
     * @param name
     * @return
     */
    public static final Block create_respawnAnchor(String name) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(Properties.copy(Blocks.RESPAWN_ANCHOR)));
    }

    /**
     * 
     * @param name
     * @param group
     * @return
     */
    public static final Block create_respawnAnchor(String name, ItemGroup group) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(Properties.copy(Blocks.RESPAWN_ANCHOR)), group);
    }

    /**
     * 
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_respawnAnchor(String name, Properties properties) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(properties));
    }

    /**
     * 
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_respawnAnchor(String name, Properties properties, ItemGroup group) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(properties), group);
    }
}
