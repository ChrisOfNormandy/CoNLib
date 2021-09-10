package com.github.chrisofnormandy.conlib.biome;

import java.util.ArrayList;
import java.util.List;

import com.github.chrisofnormandy.conlib.biome.helpers.BiomeBuilder;
import com.github.chrisofnormandy.conlib.biome.helpers.BiomeUtil;
import com.github.chrisofnormandy.conlib.collections.Tuple;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
// import net.minecraft.world.biome.ParticleEffectAmbience;
// import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.biome.Biome.TemperatureModifier;
// import net.minecraft.world.biome.BiomeAmbience.GrassColorModifier.ColorModifier;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.GenerationStage.Carving;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class BiomeBase {
    private RegistryKey<Biome> key;

    private Float depth;
    private Float scale;
    private Biome.RainType precipitation;
    private Biome.Category category;
    private Float temperature;
    private TemperatureModifier temperatureModifier = TemperatureModifier.NONE;
    private Float downfall;
    private Boolean playerCanSpawn = true;
    // private Float creatureSpawnProbability = 0.0f;

    private Integer fogColor;
    private Integer foliageColor = null;
    private Integer grassColor = null;
    private Integer skyColor;
    private Integer waterColor;
    private Integer waterFogColor;
    // private ColorModifier grassColorModifier;
    // private ParticleEffectAmbience particle;
    // private SoundAdditionsAmbience ambientSound;
    private MoodSoundAmbience moodSound;

    private Boolean useDefaults = false;

    private List<ConfiguredCarver<?>> airCarvers = new ArrayList<ConfiguredCarver<?>>();
    private List<ConfiguredCarver<?>> liquidCarvers = new ArrayList<ConfiguredCarver<?>>();

    private List<Tuple<EntityClassification, Spawners>> spawners = new ArrayList<Tuple<EntityClassification, Spawners>>();

    private Terrain terrain;

    private List<ConfiguredFeature<?, ?>> rawGeneration = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> lakes = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> localModifications = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> undergroundStructures = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> surfaceStructures = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> strongholds = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> undergroundOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> undergroundDecoration = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> vegetalDecoration = new ArrayList<ConfiguredFeature<?, ?>>();
    private List<ConfiguredFeature<?, ?>> topLayerModification = new ArrayList<ConfiguredFeature<?, ?>>();

    private BiomeBuilder builder;

    /**
     * 
     * @param key
     */
    public BiomeBase(RegistryKey<Biome> key) {
        this.key = key;
        this.builder = new BiomeBuilder(key, BiomeUtil.biomeFromKey(Biomes.THE_VOID));
    }

    /**
     * 
     * @return
     */
    public BiomeBuilder getBuilder() {
        return this.builder;
    }

    /**
     * 
     * @return
     */
    public RegistryKey<Biome> getKey() {
        return this.key;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase depth(Float value) {
        this.depth = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase scale(Float value) {
        this.scale = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase precipitation(Biome.RainType value) {
        this.precipitation = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase category(Biome.Category value) {
        this.category = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase temperature(Float value) {
        this.temperature = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase fogColor(Integer value) {
        this.fogColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase foliageColor(Integer value) {
        this.foliageColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase grassColor(Integer value) {
        this.grassColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase skyColor(Integer value) {
        this.skyColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase waterColor(Integer value) {
        this.waterColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase waterFogColor(Integer value) {
        this.waterFogColor = value;
        return this;
    };

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase moodSound(MoodSoundAmbience value) {
        this.moodSound = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase temperatureModifier(TemperatureModifier value) {
        this.temperatureModifier = value;
        return this;
    }

    /**
     * 
     * @param value
     * @return
     */
    public BiomeBase downfall(Float value) {
        this.downfall = value;
        return this;
    }

    /**
     * 
     * @return
     */
    public BiomeBase denyPlayerSpawn() {
        this.playerCanSpawn = false;
        return this;
    }

    /**
     * 
     * @param mob
     * @param weight
     * @param min
     * @param max
     * @return
     */
    public BiomeBase addMobSpawn(EntityType<?> mob, Integer weight, Integer min, Integer max) {
        spawners.add(new Tuple<EntityClassification, Spawners>(mob.getCategory(), new Spawners(mob, weight, min, max)));
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addRawGeneration(ConfiguredFeature<?, ?> feature) {
        rawGeneration.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addLake(ConfiguredFeature<?, ?> feature) {
        lakes.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addLocalModification(ConfiguredFeature<?, ?> feature) {
        localModifications.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addSurfaceStructure(ConfiguredFeature<?, ?> feature) {
        surfaceStructures.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addStronghold(ConfiguredFeature<?, ?> feature) {
        strongholds.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addUndergroundOre(ConfiguredFeature<?, ?> feature) {
        undergroundOres.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addUndergroundDecoration(ConfiguredFeature<?, ?> feature) {
        undergroundDecoration.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addVegetation(ConfiguredFeature<?, ?> feature) {
        vegetalDecoration.add(feature);
        return this;
    }

    /**
     * 
     * @param feature
     * @return
     */
    public BiomeBase addTopLayerModification(ConfiguredFeature<?, ?> feature) {
        topLayerModification.add(feature);
        return this;
    }

    /**
     * 
     * @param terrain
     * @return
     */
    public BiomeBase setSurfaceBuilder(Terrain terrain) {
        this.terrain = terrain;
        return this;
    }

    /**
     * 
     * @return
     */
    public BiomeBase useDefaults() {
        this.useDefaults = true;
        return this;
    }

    /**
     * 
     * @param builder
     * @return
     */
    public BiomeBuilder biomeSetup(BiomeBuilder builder) {
        builder.precipitation(this.precipitation).biomeCategory(this.category).depth(this.depth).scale(this.scale)
                .temperature(this.temperature).downfall(this.downfall).temperatureAdjustment(this.temperatureModifier);

        BiomeAmbience.Builder effects = new BiomeAmbience.Builder().waterColor(this.waterColor)
                .waterFogColor(this.waterFogColor).fogColor(this.fogColor).skyColor(this.skyColor)
                .ambientMoodSound(this.moodSound);

        if (foliageColor != null)
            effects.foliageColorOverride(foliageColor);
        if (grassColor != null)
            effects.grassColorOverride(grassColor);

        builder.specialEffects(effects.build());

        return builder;
    }

    /**
     * 
     * @param builder
     * @return
     */
    public BiomeGenerationSettings.Builder genSetup(BiomeGenerationSettings.Builder builder) {
        builder.surfaceBuilder(this.terrain.builder);

        if (this.useDefaults)
            DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);

        rawGeneration
                .forEach((ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.RAW_GENERATION, feature));
        lakes.forEach((ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.LAKES, feature));
        localModifications.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.LOCAL_MODIFICATIONS, feature));
        undergroundStructures.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.UNDERGROUND_STRUCTURES, feature));
        surfaceStructures.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.SURFACE_STRUCTURES, feature));
        strongholds.forEach((ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.STRONGHOLDS, feature));
        undergroundOres
                .forEach((ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.UNDERGROUND_ORES, feature));
        undergroundDecoration.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.UNDERGROUND_DECORATION, feature));
        vegetalDecoration.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.VEGETAL_DECORATION, feature));
        topLayerModification.forEach(
                (ConfiguredFeature<?, ?> feature) -> builder.addFeature(Decoration.TOP_LAYER_MODIFICATION, feature));

        airCarvers.forEach((ConfiguredCarver<?> carver) -> builder.addCarver(Carving.AIR, carver));
        liquidCarvers.forEach((ConfiguredCarver<?> carver) -> builder.addCarver(Carving.LIQUID, carver));

        return builder;
    }

    /**
     * 
     * @param builder
     * @return
     */
    public MobSpawnInfo.Builder spawnSetup(MobSpawnInfo.Builder builder) {
        spawners.forEach((Tuple<EntityClassification, Spawners> spawner) -> builder.addSpawn(spawner.x, spawner.y));

        if (playerCanSpawn)
            builder.setPlayerCanSpawn();

        return builder;
    }
}