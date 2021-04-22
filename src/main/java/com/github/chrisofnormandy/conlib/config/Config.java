package com.github.chrisofnormandy.conlib.config;

import java.util.HashMap;
import java.util.List;

import com.github.chrisofnormandy.conlib.collections.Quartet;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber
public class Config {

	private static void BuildVars(ForgeConfigSpec.Builder BUILDER, ConfigGroup cfg) {
		BUILDER.push("Strings");
		for(HashMap.Entry<String, Tuple<String, String>> entry : cfg.strings_unbuilt.entrySet()) {
            String key = entry.getKey();
            Tuple<String, String> value = entry.getValue();
        
            cfg.strings.put(key, BUILDER.comment(value.x).define(key, value.y));
		}

		BUILDER.pop();

		BUILDER.push("Flags");
		for(HashMap.Entry<String, Tuple<String, Boolean>> entry : cfg.flags_unbuilt.entrySet()) {
            String key = entry.getKey();
            Tuple<String, Boolean> value = entry.getValue();
        
            cfg.flags.put(key, BUILDER.comment(value.x).define(key, value.y));
		}

		BUILDER.pop();

		BUILDER.push("Integers");
		for(HashMap.Entry<String, Tuple<String, Integer>> entry : cfg.integers_unbuilt.entrySet()) {
            String key = entry.getKey();
            Tuple<String, Integer> value = entry.getValue();
        
            cfg.integers.put(key, BUILDER.comment(value.x).define(key, value.y));
		}

		BUILDER.pop();

		BUILDER.push("Int Ranges");
		for(HashMap.Entry<String, Quartet<String, Integer, Integer, Integer>> entry : cfg.ranges_unbuilt.entrySet()) {
            String key = entry.getKey();
            Quartet<String, Integer, Integer, Integer> value = entry.getValue();
        
            cfg.ranges.put(key, BUILDER.comment(value.w).defineInRange(key, value.x, value.y, value.z));
		}

		BUILDER.pop();
	}

	private static void BuildLists(ForgeConfigSpec.Builder BUILDER, ConfigGroup cfg) {
		BUILDER.push("Int Lists");
		for(HashMap.Entry<String, Tuple<String, List<Integer>>> entry : cfg.arrayLists_int_unbuilt.entrySet()) {
            String key = entry.getKey();
            Tuple<String, List<Integer>> value = entry.getValue();
        
            cfg.arrayLists_int.put(key, BUILDER.comment(value.x).define(key, value.y));
		}

		BUILDER.pop();

		BUILDER.push("String Lists");
		for(HashMap.Entry<String, Tuple<String, List<String>>> entry : cfg.arrayLists_string_unbuilt.entrySet()) {
            String key = entry.getKey();
            Tuple<String, List<String>> value = entry.getValue();
        
            cfg.arrayLists_string.put(key, BUILDER.comment(value.x).define(key, value.y));
		}

		BUILDER.pop();
	}

	public static HashMap<String, ConfigGroup> configs = new HashMap<String, ConfigGroup>();

	static public void Build(String fileName) {
		ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
		ConfigGroup cfg = configs.get(fileName);

		BuildVars(BUILDER, cfg);
		BuildLists(BUILDER, cfg);

		cfg.CONFIG = BUILDER.build();
	}

	/**
	 * The order of execution is Init() -> add fields -> Build() -> createConfig().
	 * createConfig()'s can be called in any order at the end of all other config builds.
	 * @param fileName
	 */
	public static void Init(String fileName) {
		configs.put(fileName, new ConfigGroup());
	}

	public static void createConfig(String fileName) {
		ForgeConfigSpec cfg = configs.get(fileName).CONFIG;

		ModLoadingContext.get().registerConfig(
            Type.SERVER,
            cfg,
            fileName + ".toml"
        );
        Config.loadConfig(
            cfg,
            FMLPaths.CONFIGDIR.get().resolve(fileName + ".toml").toString()
        );		
	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

		file.load();
		
		config.setConfig(file);
	}

	public static void addRange(String fileName, String key, int min, int max, int defaultValue, String comment) {
		configs.get(fileName).addRange(key, min, max, defaultValue, comment);
	}

	public static void addString(String fileName, String key, String value, String comment) {
		configs.get(fileName).addString(key, value, comment);
	}

	public static void addInteger(String fileName, String key, Integer value, String comment) {
		configs.get(fileName).addInteger(key, value, comment);
	}

	public static void addFlag(String fileName, String key, Boolean value, String comment) {
		configs.get(fileName).addFlag(key, value, comment);
	}

	public static void addIntList(String fileName, String key, List<Integer> value, String comment) {
		configs.get(fileName).addIntList(key, value, comment);
	}

	public static void addStringList(String fileName, String key, List<String> value, String comment) {
		configs.get(fileName).addStringList(key, value, comment);
	}



	public static int getRangeValue(String fileName, String key) {
		return configs.get(fileName).getRangeValue(key);
	}

	public static String getStringValue(String fileName, String key) {
		return configs.get(fileName).getStringValue(key);
	}
	
	public static Integer getIntegerValue(String fileName, String key) {
		return configs.get(fileName).getIntegerValue(key);
	}

	public static Boolean getFlagValue(String fileName, String key) {
		return configs.get(fileName).getFlagValue(key);
	}

	public static List<Integer> getIntListValue(String fileName, String key) {
		return configs.get(fileName).getIntListValue(key);
	}

	public static List<String> getStringListValue(String fileName, String key) {
		return configs.get(fileName).getStringListValue(key);
	}
}