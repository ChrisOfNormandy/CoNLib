package com.github.chrisofnormandy.conlib;

import java.util.ArrayList;
import java.util.List;

import com.github.chrisofnormandy.conlib.config.Config;

public class Mod_Config {
    public static void Init() {
        Config.Init(Main.MOD_ID);

        Config.addString(Main.MOD_ID, "test_string", "Wow, a wonderful message!", "This is a test string.");
        Config.addFlag(Main.MOD_ID, "test_flag", false, "This is a test flag.");
        Config.addInteger(Main.MOD_ID, "test_int", 69, "This is a test integer.");
        Config.addRange(Main.MOD_ID, "test_range", 0, 10, 1, "This is a test range.");

        List<Integer> list_int = new ArrayList<Integer>();
        list_int.add(1);
        list_int.add(2);
        list_int.add(3);

        List<String> list_string = new ArrayList<String>();
        list_string.add("1");
        list_string.add("2");
        list_string.add("3");

        Config.addIntList(Main.MOD_ID, "test_int_list", list_int, "This is a test list.");
        Config.addStringList(Main.MOD_ID, "test_string_list", list_string, "This is a test list.");

        Config.Build(Main.MOD_ID);

        Config.createConfig(Main.MOD_ID);
    }
}
