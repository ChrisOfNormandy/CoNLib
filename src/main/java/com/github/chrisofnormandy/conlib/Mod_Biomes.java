package com.github.chrisofnormandy.conlib;

import com.github.chrisofnormandy.conlib.biome.RegistryHelper;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.github.chrisofnormandy.conlib.world.ModBiomeProvider;
import com.github.chrisofnormandy.conlib.world.ModWorldType;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Mod_Biomes {

    public static ModWorldType custom = new ModWorldType();

    public static void Init() {
        custom.setRegistryName(new ResourceLocation(Main.MOD_ID + "_custom_worldtype"));
        ForgeRegistries.WORLD_TYPES.register(custom);

        Registry.register(Registry.BIOME_SOURCE, Main.MOD_ID + "_overworld", ModBiomeProvider.CODEC);

        RegistryHelper builder = new RegistryHelper("new_biome");

        builder.setPrimarySurface(builder.surfaceBuilder("grassy", Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND));
        builder.setSecondarySurface(builder.surfaceBuilder("rocky", Blocks.COBBLESTONE, Blocks.STONE, Blocks.GRAVEL));

        builder.climateBuilder("chilly", BiomeType.COOL, 1);

        builder.terrainBuilder("new_biome_terrain", 1.2d);

        builder.biomeBuilder(0.5f, 0.2f, -0.1f, 0.3f);
        builder.isFrozen();
        builder.setRainType(RainType.SNOW);
        builder.configureClient(4566514, 267827, 12638463, builder.floatToInt(0.8f));

        builder.register();
        ModRegister.registerBiomes();
    }
}
