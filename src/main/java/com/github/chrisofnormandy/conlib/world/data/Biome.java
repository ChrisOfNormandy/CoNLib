package com.github.chrisofnormandy.conlib.world.data;

import java.util.HashMap;

import com.github.chrisofnormandy.conlib.collections.JsonBuilder;
import com.github.chrisofnormandy.conlib.collections.JsonBuilder.JsonArray;
import com.github.chrisofnormandy.conlib.collections.JsonBuilder.JsonObject;

import net.minecraft.block.Block;

public class Biome {

    private JsonBuilder builder = new JsonBuilder();
    private HashMap<String, JsonObject> features = new HashMap<String, JsonObject>();

    public final Root root = new Root();

    public JsonObject build() {
        return root.get();
    }

    public HashMap<String, JsonObject> getFeatures() {
        return features;
    }

    public Biome() {
    }

    public void addOreFeature(String oreName, Block ore, Integer size) {
        ConfiguredFeature oreFeature = new ConfiguredFeature();

        JsonObject config = oreFeature.oreConfig(ore, "minecraft:base_stone_overworld", 8, 0, 128);

        root.features.addOreSpawn(ore.getRegistryName().toString());

        features.put(oreName, config);
    }

    public class Root {
        private JsonObject json = builder.createJsonObject();

        public Root() {}

        private Float depth = 0.1f;
        private Float scale = 0.2f;
        private String precipitation = "none";
        private String category = null;
        private Float temperature = 0.0f;
        private String temperature_modifier = "none";
        private Float downfall = 0.0f;
        private Boolean player_spawn_friendly = true;
        private Float creature_spawn_probability = 0.0f;

        public Effects effects = new Effects();

        private String surface_builder = null;

        public Carvers carvers = new Carvers();

        public Features features = new Features();

        public Spawners spawners = new Spawners();

        private JsonArray starts = builder.createJsonArray();

        private JsonObject spawn_costs = builder.createJsonObject();

        public Root setDepth(Float value) {
            depth = value;
            return this;
        }

        public Root setScale(Float value) {
            scale = value;
            return this;
        }

        public Root setPrecipitation(String value) {
            switch (value) {
                case "none": {
                }
                case "rain": {
                }
                case "snow": {
                    precipitation = value;
                    break;
                }
            }

            return this;
        }

        public Root setCategory(String value) {
            switch (value) {
                case "none": {
                }
                case "taiga": {
                }
                case "extreme_hills": {
                }
                case "jungle": {
                }
                case "mesa": {
                }
                case "plains": {
                }
                case "savanna": {
                }
                case "icy": {
                }
                case "the_end": {
                }
                case "beach": {
                }
                case "forest": {
                }
                case "ocean": {
                }
                case "desert": {
                }
                case "river": {
                }
                case "swamp": {
                }
                case "mushroom": {
                }
                case "nether": {
                    category = value;
                    break;
                }
            }

            return this;
        }

        public Root setTemperature(Float value) {
            temperature = value;
            return this;
        }

        public Root isFrozen() {
            temperature_modifier = "frozen";
            return this;
        }

        public Root setDownfall(Float value) {
            downfall = value;
            return this;
        }

        public Root denyPlayerSpawn() {
            player_spawn_friendly = false;
            return this;
        }

        public Root setCreatureSpawnProbability(Float value) {
            if (value >= 0 && value <= 1)
                creature_spawn_probability = value;
            return this;
        }

        public Root setSurfaceBuilder(String value) {
            surface_builder = value;
            return this;
        }

        public Root addStart(String value) {
            starts.add(value);
            return this;
        }

        public JsonObject get() {
            json.set("depth", this.depth);
            json.set("scale", this.scale);
            json.set("precipitation", this.precipitation);
            if (category != null)
                json.set("category", this.category);
            json.set("temperature", this.temperature);
            json.set("temperature_modifier", this.temperature_modifier);
            json.set("downfall", this.downfall);
            json.set("player_spawn_friendly", this.player_spawn_friendly);
            json.set("creature_spawn_probability", this.creature_spawn_probability);
            if (surface_builder != null)
                json.set("surface_builder", this.surface_builder);

            json.set("effects", this.effects.get());
            json.set("carvers", this.carvers.get());
            json.set("features", this.features.get());
            json.set("starts", this.starts);
            json.set("spawn_costs", this.spawn_costs);
            json.set("spawners", this.spawners.get());

            return json;
        }
    }

    public class Effects {
        private JsonObject json = builder.createJsonObject();

        public Effects() {}

        private Integer fog_color = -1;
        private Integer foliage_color = -1;
        private Integer grass_color = -1;
        private Integer sky_color = -1;
        private Integer water_color = -1;
        private Integer water_fog_color = -1;
        private String grass_color_modifier = null;

        private Integer intFromHex(String hex) {
            String digits = "0123456789ABCDEF";

            hex = hex.toUpperCase();

            int val = 0;
            int length = hex.length();
            char c;
            int d;
            for (int i = 0; i < length; i++) {
                c = hex.charAt(i);
                d = digits.indexOf(c);
                val = 16 * val + d;
            }

            return val;
        }

        private JsonObject particle = builder.createJsonObject();

        private String ambient_sound = null;

        private JsonObject mood_sound = builder.createJsonObject();

        private JsonObject additions_sound = builder.createJsonObject();

        private JsonObject music = builder.createJsonObject();

        public Effects setFogColor(String value) {
            fog_color = intFromHex(value);
            return this;
        }

        public Effects setFoliageColor(String value) {
            foliage_color = intFromHex(value);
            return this;
        }

        public Effects setGrassColor(String value) {
            grass_color = intFromHex(value);
            return this;
        }

        public Effects setSkyColor(String value) {
            sky_color = intFromHex(value);
            return this;
        }

        public Effects setWaterColor(String value) {
            water_color = intFromHex(value);
            return this;
        }

        public Effects setWaterFogColor(String value) {
            water_fog_color = intFromHex(value);
            return this;
        }

        public Effects setFogColor(Integer value) {
            fog_color = value;
            return this;
        }

        public Effects setFoliageColor(Integer value) {
            foliage_color = value;
            return this;
        }

        public Effects setGrassColor(Integer value) {
            grass_color = value;
            return this;
        }

        public Effects setSkyColor(Integer value) {
            sky_color = value;
            return this;
        }

        public Effects setWaterColor(Integer value) {
            water_color = value;
            return this;
        }

        public Effects setWaterFogColor(Integer value) {
            water_fog_color = value;
            return this;
        }

        public Effects setGrasColorModifier(String value) {
            grass_color_modifier = value;
            return this;
        }

        public Effects setAmbientSound(String value) {
            ambient_sound = value;
            return this;
        }

        public Effects setParticle(String value) {
            particle.addObject("options").set("type", value);
            particle.set("probability", 0.118093334);
            return this;
        }

        public Effects setMoodSound(String value) {
            mood_sound.set("sound", value);
            mood_sound.set("tick_delay", 6000);
            mood_sound.set("block_search_extent", 8);
            mood_sound.set("offset", 2.0f);

            return this;
        }

        public Effects setAdditionsSound(String value) {
            additions_sound.set("sound", value);
            additions_sound.set("tick_chance", 0.0111);

            return this;
        }

        public Effects setMusic(String value) {
            music.set("sound", value);
            music.set("min_delay", 12000);
            music.set("max_delay", 24000);
            music.set("replace_current_music", false);

            return this;
        }

        public JsonObject get() {
            if (fog_color >= 0)
                json.set("fog_color", this.fog_color);
            if (foliage_color >= 0)
                json.set("foliage_color", this.foliage_color);
            if (grass_color >= 0)
                json.set("grass_color", this.grass_color);
            if (sky_color >= 0)
                json.set("sky_color", this.sky_color);
            if (water_color >= 0)
                json.set("water_color", this.water_color);
            if (water_fog_color >= 0)
                json.set("water_fog_color", this.water_fog_color);
            if (grass_color_modifier != null)
                json.set("grass_color_modifier", this.grass_color_modifier);
            if (ambient_sound != null)
                json.set("ambient_sound", this.ambient_sound);

            json.set("particle", this.particle);
            json.set("mood_sound", this.mood_sound);
            json.set("additions_sound", this.additions_sound);
            json.set("music", this.music);

            return json;
        }
    }

    public class Carvers {
        private JsonObject json = builder.createJsonObject();

        public Carvers() {}

        private JsonArray air = builder.createJsonArray();
        private JsonArray liquid = builder.createJsonArray();

        public Carvers addAirCarver(String gen_name) {
            air.add(gen_name);
            return this;
        }

        public Carvers addLiquidCarver(String gen_name) {
            liquid.add(gen_name);
            return this;
        }

        public JsonObject get() {
            json.set("air", this.air);
            json.set("liquid", this.liquid);

            return json;
        }
    }

    public class Features {
        private JsonArray array = builder.createJsonArray();

        public Features() {}

        private JsonArray RAW_GENERATION = array.addArray();
        private JsonArray LAKES = array.addArray();
        private JsonArray LOCAL_MODIFICATIONS = array.addArray();
        private JsonArray UNDERGROUND_STRUCTURES = array.addArray();
        private JsonArray SURFACE_STRUCTURES = array.addArray();
        private JsonArray STRONGHOLDS = array.addArray();
        private JsonArray UNDERGROUND_ORES = array.addArray();
        private JsonArray UNDERGROUND_DECORATION = array.addArray();
        private JsonArray VEGETAL_DECORATION = array.addArray();
        private JsonArray TOP_LAYER_MODIFICATION = array.addArray();

        public Features addRawGeneration(String value) {
            RAW_GENERATION.add(value);
            return this;
        }

        public Features addLake(String value) {
            LAKES.add(value);
            return this;
        }

        public Features addLocalModification(String value) {
            LOCAL_MODIFICATIONS.add(value);
            return this;
        }

        public Features addUndergroundStructure(String value) {
            UNDERGROUND_STRUCTURES.add(value);
            return this;
        }

        public Features addSurfaceStructure(String value) {
            SURFACE_STRUCTURES.add(value);
            return this;
        }

        public Features addStronghold(String value) {
            STRONGHOLDS.add(value);
            return this;
        }

        public Features addOreSpawn(String value) {
            UNDERGROUND_ORES.add(value);
            return this;
        }

        public Features addUndergroundDecoration(String value) {
            UNDERGROUND_DECORATION.add(value);
            return this;
        }

        public Features addVegetation(String value) {
            VEGETAL_DECORATION.add(value);
            return this;
        }

        public Features addTopLayerModification(String value) {
            TOP_LAYER_MODIFICATION.add(value);
            return this;
        }

        public JsonArray get() {
            return array;
        }
    }

    public class Spawners {
        private JsonObject json = builder.createJsonObject();

        public Spawners() {}

        private void add(String key, String type, Integer weight, Integer min, Integer max) {
            if (json.get(key) == null)
                json.addArray(key);
            json.getArray(key).addObject().set("type", type).set("weight", weight).set("minCount", min).set("maxCount",
                    max);
        }

        public void addMonster(String type, Integer weight, Integer min, Integer max) {
            add("monster", type, weight, min, max);
        }

        public void addCreature(String type, Integer weight, Integer min, Integer max) {
            add("creature", type, weight, min, max);
        }

        public void addAmbient(String type, Integer weight, Integer min, Integer max) {
            add("ambient", type, weight, min, max);
        }

        public void addWaterCreature(String type, Integer weight, Integer min, Integer max) {
            add("water_creature", type, weight, min, max);
        }

        public void addWaterAmbient(String type, Integer weight, Integer min, Integer max) {
            add("water_ambient", type, weight, min, max);
        }

        public void addMisc(String type, Integer weight, Integer min, Integer max) {
            add("misc", type, weight, min, max);
        }

        public JsonObject get() {
            return json;
        }
    }

    public class Spawn_Costs {
        private JsonObject json = builder.createJsonObject();

        public Spawn_Costs add(String key, Double energy_budget, Double charge) {
            json.addObject(key).set("energy_budget", energy_budget).set("charge", charge);
            return this;
        }

        public JsonObject get() {
            return json;
        }
    }
}
