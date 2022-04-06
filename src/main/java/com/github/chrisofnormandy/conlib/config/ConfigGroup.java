package com.github.chrisofnormandy.conlib.config;

import java.util.HashMap;
import java.util.List;

import com.github.chrisofnormandy.conlib.collections.Quartet;
import com.github.chrisofnormandy.conlib.collections.Tuple;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGroup {
    /**
     * 
     */
    public ConfigGroup() {
    }

    public ForgeConfigSpec CONFIG;
    public HashMap<String, ConfigGroup> subgroups = new HashMap<String, ConfigGroup>();

    public HashMap<String, ForgeConfigSpec.IntValue> ranges = new HashMap<String, ForgeConfigSpec.IntValue>();
    public HashMap<String, ForgeConfigSpec.ConfigValue<Boolean>> flags = new HashMap<String, ForgeConfigSpec.ConfigValue<Boolean>>();
    public HashMap<String, ForgeConfigSpec.ConfigValue<Integer>> integers = new HashMap<String, ForgeConfigSpec.ConfigValue<Integer>>();
    public HashMap<String, ForgeConfigSpec.ConfigValue<Double>> doubles = new HashMap<String, ForgeConfigSpec.ConfigValue<Double>>();
    public HashMap<String, ForgeConfigSpec.ConfigValue<String>> strings = new HashMap<String, ForgeConfigSpec.ConfigValue<String>>();

    public HashMap<String, ForgeConfigSpec.ConfigValue<List<Integer>>> arrayLists_int = new HashMap<String, ForgeConfigSpec.ConfigValue<List<Integer>>>();
    public HashMap<String, ForgeConfigSpec.ConfigValue<List<String>>> arrayLists_string = new HashMap<String, ForgeConfigSpec.ConfigValue<List<String>>>();

    public HashMap<String, Quartet<String, Integer, Integer, Integer>> ranges_unbuilt = new HashMap<String, Quartet<String, Integer, Integer, Integer>>();
    public HashMap<String, Tuple<String, String>> strings_unbuilt = new HashMap<String, Tuple<String, String>>();
    public HashMap<String, Tuple<String, Integer>> integers_unbuilt = new HashMap<String, Tuple<String, Integer>>();
    public HashMap<String, Tuple<String, Double>> doubles_unbuilt = new HashMap<String, Tuple<String, Double>>();
    public HashMap<String, Tuple<String, Boolean>> flags_unbuilt = new HashMap<String, Tuple<String, Boolean>>();

    public HashMap<String, Tuple<String, List<Integer>>> arrayLists_int_unbuilt = new HashMap<String, Tuple<String, List<Integer>>>();
    public HashMap<String, Tuple<String, List<String>>> arrayLists_string_unbuilt = new HashMap<String, Tuple<String, List<String>>>();

    /**
     * 
     * @param name
     * @param group
     */
    public void addSubgroup(String name, ConfigGroup group) {
        subgroups.put(name, group);
    }

    /**
     * 
     * @param name
     * @return
     */
    public ConfigGroup getSubgroup(String name) {
        return subgroups.get(name);
    }

    /**
     * 
     * @param key
     * @param min
     * @param max
     * @param defaultValue
     * @param comment
     */
    public void addRange(String key, Integer min, Integer max, Integer defaultValue, String comment) {
        ranges_unbuilt.put(key, new Quartet<String, Integer, Integer, Integer>(comment, defaultValue, min, max));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addString(String key, String value, String comment) {
        strings_unbuilt.put(key, new Tuple<String, String>(comment, value));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addInteger(String key, Integer value, String comment) {
        integers_unbuilt.put(key, new Tuple<String, Integer>(comment, value));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addDouble(String key, Double value, String comment) {
        doubles_unbuilt.put(key, new Tuple<String, Double>(comment, value));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addFlag(String key, Boolean value, String comment) {
        flags_unbuilt.put(key, new Tuple<String, Boolean>(comment, value));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addIntList(String key, List<Integer> value, String comment) {
        arrayLists_int_unbuilt.put(key, new Tuple<String, List<Integer>>(comment, value));
    }

    /**
     * 
     * @param key
     * @param value
     * @param comment
     */
    public void addStringList(String key, List<String> value, String comment) {
        arrayLists_string_unbuilt.put(key, new Tuple<String, List<String>>(comment, value));
    }

    /**
     * 
     * @param key
     * @return
     */
    public Integer getRangeValue(String key) {
        return ranges.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        return strings.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public Integer getIntegerValue(String key) {
        return integers.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public Double getDoubleValue(String key) {
        return doubles.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public Boolean getFlagValue(String key) {
        return flags.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public List<Integer> getIntListValue(String key) {
        return arrayLists_int.get(key).get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public List<String> getStringListValue(String key) {
        return arrayLists_string.get(key).get();
    }
}
