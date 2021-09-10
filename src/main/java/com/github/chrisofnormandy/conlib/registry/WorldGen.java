package com.github.chrisofnormandy.conlib.registry;

import com.github.chrisofnormandy.conlib.biome.helpers.BiomeBuilder;
import com.github.chrisofnormandy.conlib.biome.helpers.BiomeUtil;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGen {
    /**
     * 
     * @param name
     * @param feature
     * @return
     */
    public static final Feature<NoFeatureConfig> registerPlantGen(String name, Feature<NoFeatureConfig> feature) {
        return registerGenFeature(name, feature);
    }

    /**
     * 
     * @param name
     * @param entry
     * @return
     */
    public static final Feature<NoFeatureConfig> registerGenFeature(String name, Feature<NoFeatureConfig> entry) {
        entry.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ForgeRegistries.FEATURES.register(entry);
        ModRegister.generators.put(name, entry);
        return entry;
    }

    /**
     * 
     * @param name
     * @param config
     * @return
     */
    public static final SurfaceBuilderConfig registerSurfaceBuilderConfig(String name, SurfaceBuilderConfig config) {
        ModRegister.surfaceBuilderConfigs.put(name, config);
        return config;
    }

    /**
     * 
     * @param <A>
     * @param <B>
     * @param name
     * @param builder
     * @return
     */
    public static final <A extends ISurfaceBuilderConfig, B extends ConfiguredSurfaceBuilder<A>> B registerConfiguredSurfaceBuilder(
            String name, B builder) {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(ModRegister.getModId(), name), builder);
        ModRegister.configSurfaceBuilders.put(name, builder);
        return builder;
    }

    /**
     * 
     * @param <A>
     * @param <B>
     * @param name
     * @param builder
     * @return
     */
    public static final <A extends ISurfaceBuilderConfig, B extends SurfaceBuilder<A>> B registerSurfaceBuilder(
            String name, B builder) {
        builder.setRegistryName(new ResourceLocation(ModRegister.getModId(), name));
        ForgeRegistries.SURFACE_BUILDERS.register(builder);
        ModRegister.surfaceBuilders.put(name, builder);
        return builder;
    }

    /**
     * 
     * @param name
     * @return
     */
    public static final BiomeBuilder create(String name) {
        RegistryKey<Biome> key = BiomeUtil.createKey(name);

        BiomeBuilder builder = BiomeUtil.getBuilder(key);

        ModRegister.overworldKeys.put(name, key);

        return builder;
    }

    /**
     * 
     * @param event
     * @param key
     * @param builder
     */
    private static final void register(RegistryEvent.Register<Biome> event, RegistryKey<Biome> key,
            BiomeBuilder builder) {
        event.getRegistry().register(builder.build(key));
        builder.registerTypes(key);
        builder.registerWeight(key);

        ModRegister.biomeRemaps.put(key, builder.getParentKey());
    }

    @SubscribeEvent
    public static final void register(RegistryEvent.Register<Biome> event) {
        ModRegister.overworldKeys.forEach(
                (String name, RegistryKey<Biome> key) -> register(event, key, ModRegister.biomeBuilders.get(key)));
    }
}
