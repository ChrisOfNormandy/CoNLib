package com.github.chrisofnormandy.conlib;

import com.github.chrisofnormandy.conlib.config.Config;

public class Mod_Config {
    public static void Init() {
        Config.addString("test_string", "Wow, a wonderful message!", "This is a test string.");
        Config.addFlag("test_flag", false, "This is a test flag.");
        Config.addInteger("test_int", 69, "This is a test integer.");
        Config.addRange("test_range", 0, 10, 1, "This is a test range.");
    }
}
