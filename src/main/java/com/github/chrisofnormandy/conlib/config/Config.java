package com.github.chrisofnormandy.conlib.config;

import java.util.HashMap;
import java.util.List;

import com.github.chrisofnormandy.conlib.collections.Quartet;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec CONFIG;

	static HashMap<String, ForgeConfigSpec.IntValue> ranges = new HashMap<String, ForgeConfigSpec.IntValue>();
	static HashMap<String, ForgeConfigSpec.ConfigValue<Boolean>> flags = new HashMap<String, ForgeConfigSpec.ConfigValue<Boolean>>();
	static HashMap<String, ForgeConfigSpec.ConfigValue<Integer>> integers = new HashMap<String, ForgeConfigSpec.ConfigValue<Integer>>();
	static HashMap<String, ForgeConfigSpec.ConfigValue<List<? extends Integer>>> arrayLists_int = new HashMap<String, ForgeConfigSpec.ConfigValue<List<? extends Integer>>>();

	static HashMap<String, Quartet<String, Integer, Integer, Integer>> ranges_unbuilt = new HashMap<String, Quartet<String, Integer, Integer, Integer>>();

	static public void Init() {
		BUILDER.push("Ranges");
		for(HashMap.Entry<String, Quartet<String, Integer, Integer, Integer>> entry : ranges_unbuilt.entrySet()) {
            String key = entry.getKey();
            Quartet<String, Integer, Integer, Integer> value = entry.getValue();
        
            ranges.put(key, BUILDER.comment(value.w).defineInRange(key, value.x, value.y, value.z));
		}
		
		BUILDER.pop();

		CONFIG = BUILDER.build();
	}

	static {		
		Init();
	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

		file.load();
		
		config.setConfig(file);
	}

	public static void addRange(String key, int min, int max, int defaultValue, String comment) {
		ranges_unbuilt.put(key, new Quartet<String,Integer,Integer,Integer>(comment, defaultValue, min, max));
	}

	public static int getRangeValue(String key) {
		return ranges.get(key).get();
	}
}