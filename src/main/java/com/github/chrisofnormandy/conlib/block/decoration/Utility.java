package com.github.chrisofnormandy.conlib.block.decoration;

import com.github.chrisofnormandy.conlib.registry.BlockRegistry;

import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrewingStandBlock;
import net.minecraft.world.level.block.CartographyTableBlock;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FletchingTableBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.GrindstoneBlock;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.LoomBlock;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.DyeColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

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
    public static final Block create_craftingTable(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CraftingTableBlock(Properties.copy(Blocks.CRAFTING_TABLE)),
                creativeTab);
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
    public static final Block create_craftingTable(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CraftingTableBlock(properties), creativeTab);
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
    public static final Block create_furnace(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FurnaceBlock(Properties.copy(Blocks.FURNACE)), creativeTab);
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
    public static final Block create_furnace(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FurnaceBlock(properties), creativeTab);
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
    public static final Block create_anvil(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new AnvilBlock(Properties.copy(Blocks.ANVIL)), creativeTab);
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
    public static final Block create_anvil(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new AnvilBlock(properties), creativeTab);
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
    public static final Block create_grindstone(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GrindstoneBlock(Properties.copy(Blocks.GRINDSTONE)), creativeTab);
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
    public static final Block create_grindstone(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new GrindstoneBlock(properties), creativeTab);
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
    public static final Block create_composter(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ComposterBlock(Properties.copy(Blocks.COMPOSTER)), creativeTab);
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
    public static final Block create_composter(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new ComposterBlock(properties), creativeTab);
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
    public static final Block create_brewingStand(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BrewingStandBlock(Properties.copy(Blocks.BREWING_STAND)), creativeTab);
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
    public static final Block create_brewingStand(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BrewingStandBlock(properties), creativeTab);
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
    public static final Block create_cauldron(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CauldronBlock(Properties.copy(Blocks.CAULDRON)), creativeTab);
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
    public static final Block create_cauldron(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CauldronBlock(properties), creativeTab);
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
    public static final Block create_stonecutter(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new StonecutterBlock(Properties.copy(Blocks.STONECUTTER)), creativeTab);
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
    public static final Block create_stonecutter(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new StonecutterBlock(properties), creativeTab);
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
    public static final Block create_fletchingTable(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FletchingTableBlock(Properties.copy(Blocks.FLETCHING_TABLE)),
                creativeTab);
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
    public static final Block create_fletchingTable(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FletchingTableBlock(properties), creativeTab);
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
    public static final Block create_loom(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LoomBlock(Properties.copy(Blocks.LOOM)), creativeTab);
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
    public static final Block create_loom(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new LoomBlock(properties), creativeTab);
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
    public static final Block create_smoker(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SmokerBlock(Properties.copy(Blocks.SMOKER)), creativeTab);
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
    public static final Block create_smoker(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SmokerBlock(properties), creativeTab);
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
    public static final Block create_blastFurnace(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(Properties.copy(Blocks.BLAST_FURNACE)), creativeTab);
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
    public static final Block create_blastFurnace(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BlastFurnaceBlock(properties), creativeTab);
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
    public static final Block create_cartographyTable(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CartographyTableBlock(Properties.copy(Blocks.CARTOGRAPHY_TABLE)),
                creativeTab);
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
    public static final Block create_cartographyTable(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new CartographyTableBlock(properties), creativeTab);
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
    public static final Block create_smithingTable(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SmithingTableBlock(Properties.copy(Blocks.SMITHING_TABLE)),
                creativeTab);
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
    public static final Block create_smithingTable(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new SmithingTableBlock(properties), creativeTab);
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
    public static final Block create_beehive(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BeehiveBlock(Properties.copy(Blocks.BEEHIVE)), creativeTab);
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
    public static final Block create_beehive(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BeehiveBlock(properties), creativeTab);
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
    public static final Block create_bed(DyeColor color, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BedBlock(color, Properties.copy(Blocks.WHITE_BED)), creativeTab);
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
    public static final Block create_bed(DyeColor color, String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new BedBlock(color, properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_farmland(String name) {
        return BlockRegistry.register(name, new FarmBlock(Properties.copy(Blocks.FARMLAND)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_farmland(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FarmBlock(Properties.copy(Blocks.FARMLAND)), creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_farmland(String name, Properties properties) {
        return BlockRegistry.register(name, new FarmBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_farmland(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new FarmBlock(properties), creativeTab);
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
    public static final Block create_jukebox(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new JukeboxBlock(Properties.copy(Blocks.JUKEBOX)), creativeTab);
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
    public static final Block create_jukebox(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new JukeboxBlock(properties), creativeTab);
    }

    ////

    /**
     *
     * @param name
     * @return
     */
    public static final Block create_enchantingTable(String name) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(Properties.copy(Blocks.ENCHANTING_TABLE)));
    }

    /**
     *
     * @param name
     * @param group
     * @return
     */
    public static final Block create_enchantingTable(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(Properties.copy(Blocks.ENCHANTING_TABLE)),
                creativeTab);
    }

    /**
     *
     * @param name
     * @param properties
     * @return
     */
    public static final Block create_enchantingTable(String name, Properties properties) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(properties));
    }

    /**
     *
     * @param name
     * @param properties
     * @param group
     * @return
     */
    public static final Block create_enchantingTable(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EnchantmentTableBlock(properties), creativeTab);
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
    public static final Block create_enderChest(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EnderChestBlock(Properties.copy(Blocks.ENDER_CHEST)), creativeTab);
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
    public static final Block create_enderChest(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new EnderChestBlock(properties), creativeTab);
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
    public static final Block create_respawnAnchor(String name, ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(Properties.copy(Blocks.RESPAWN_ANCHOR)),
                creativeTab);
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
    public static final Block create_respawnAnchor(String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return BlockRegistry.register(name, new RespawnAnchorBlock(properties), creativeTab);
    }
}
