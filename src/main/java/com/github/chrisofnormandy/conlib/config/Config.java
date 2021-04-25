package com.github.chrisofnormandy.conlib.config;

import java.io.File;
import java.nio.file.Path;
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
	private ConfigGroup config = new ConfigGroup();
	private String name;
	private String path = "";

	public Config(String name) {
		this.name = name;
	}

	public Config(String path, String name) {
		this.path = path;
		this.name = name;
	}

	private void loadConfig(ForgeConfigSpec config, String path) {
		CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE)
				.build();

		file.load();

		config.setConfig(file);
	}

	private void createConfig() {
		String fileName = this.name + ".toml";

		if (this.path != "") {
			Path path = FMLPaths.CONFIGDIR.get().resolve(this.path);
			final File dir = path.toFile();
			
			if (!dir.exists())        
				dir.mkdirs();

			fileName = this.path + "/" + fileName;
		}

		ModLoadingContext.get().registerConfig(Type.SERVER, config.CONFIG, fileName);
		this.loadConfig(config.CONFIG, FMLPaths.CONFIGDIR.get().resolve(fileName).toString());
	}

	private void BuildVars(ForgeConfigSpec.Builder BUILDER, ConfigGroup group) {

		if (!group.flags_unbuilt.isEmpty()) {

			BUILDER.push("Flags");
			for (HashMap.Entry<String, Tuple<String, Boolean>> entry : group.flags_unbuilt.entrySet()) {
				String key = entry.getKey();
				Tuple<String, Boolean> value = entry.getValue();

				group.flags.put(key, BUILDER.comment(value.x).define(key, value.y));
			}

			BUILDER.pop();
		}

		if (!group.strings_unbuilt.isEmpty()) {

			BUILDER.push("Strings");
			for (HashMap.Entry<String, Tuple<String, String>> entry : group.strings_unbuilt.entrySet()) {
				String key = entry.getKey();
				Tuple<String, String> value = entry.getValue();

				group.strings.put(key, BUILDER.comment(value.x).define(key, value.y));
			}

			BUILDER.pop();
		}

		if (!group.integers_unbuilt.isEmpty()) {

			BUILDER.push("Integers");
			for (HashMap.Entry<String, Tuple<String, Integer>> entry : group.integers_unbuilt.entrySet()) {
				String key = entry.getKey();
				Tuple<String, Integer> value = entry.getValue();

				group.integers.put(key, BUILDER.comment(value.x).define(key, value.y));
			}

			BUILDER.pop();
		}

		if (!group.arrayLists_int_unbuilt.isEmpty()) {

			BUILDER.push("Int Ranges");
			for (HashMap.Entry<String, Quartet<String, Integer, Integer, Integer>> entry : group.ranges_unbuilt
					.entrySet()) {
				String key = entry.getKey();
				Quartet<String, Integer, Integer, Integer> value = entry.getValue();

				group.ranges.put(key, BUILDER.comment(value.w).defineInRange(key, value.x, value.y, value.z));
			}

			BUILDER.pop();
		}
	}

	private void BuildLists(ForgeConfigSpec.Builder BUILDER, ConfigGroup group) {

		if (!group.arrayLists_int_unbuilt.isEmpty()) {

			BUILDER.push("Int Lists");
			for (HashMap.Entry<String, Tuple<String, List<Integer>>> entry : group.arrayLists_int_unbuilt.entrySet()) {
				String key = entry.getKey();
				Tuple<String, List<Integer>> value = entry.getValue();

				group.arrayLists_int.put(key, BUILDER.comment(value.x).define(key, value.y));
			}

			BUILDER.pop();
		}

		if (!group.arrayLists_string_unbuilt.isEmpty()) {

			BUILDER.push("String Lists");
			for (HashMap.Entry<String, Tuple<String, List<String>>> entry : group.arrayLists_string_unbuilt.entrySet()) {
				String key = entry.getKey();
				Tuple<String, List<String>> value = entry.getValue();

				group.arrayLists_string.put(key, BUILDER.comment(value.x).define(key, value.y));
			}

			BUILDER.pop();
		}
	}

	public void Build() {
		ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

		this.BuildVars(BUILDER, this.config);
		this.BuildLists(BUILDER, this.config);

		this.config.subgroups.forEach((String name, ConfigGroup group) -> {
			BUILDER.push(name);
			this.BuildVars(BUILDER, group);
			BUILDER.pop();
		});

		this.config.CONFIG = BUILDER.build();

		this.createConfig();
	}

	public void addRange(String key, Integer min, Integer max, Integer defaultValue,
			String comment) {
		this.config.addRange(key, min, max, defaultValue, comment);
	}

	public void addString(String key, String value, String comment) {
		this.config.addString(key, value, comment);
	}

	public void addInteger(String key, Integer value, String comment) {
		this.config.addInteger(key, value, comment);
	}

	public void addFlag(String key, Boolean value, String comment) {
		this.config.addFlag(key, value, comment);
	}

	public void addIntList(String key, List<Integer> value, String comment) {
		this.config.addIntList(key, value, comment);
	}

	public void addStringList(String key, List<String> value, String comment) {
		this.config.addStringList(key, value, comment);
	}

	public Integer getRangeValue(String key) {
		return this.config.getRangeValue(key);
	}

	public String getStringValue(String key) {
		return this.config.getStringValue(key);
	}

	public Integer getIntegerValue(String key) {
		return this.config.getIntegerValue(key);
	}

	public Boolean getFlagValue(String key) {
		return this.config.getFlagValue(key);
	}

	public List<Integer> getIntListValue(String key) {
		return this.config.getIntListValue(key);
	}

	public List<String> getStringListValue(String key) {
		return this.config.getStringListValue(key);
	}

	public void addSubgroup(String name) {
		this.config.addSubgroup(name);
	}

	public ConfigGroup getSubgroup(String name) {
		return this.config.getSubgroup(name);
	}
}