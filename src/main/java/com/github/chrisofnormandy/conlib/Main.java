package com.github.chrisofnormandy.conlib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("conlib")
public class Main {
    public static final Logger LOG = LogManager.getLogger();
    public static String MOD_ID = "conlib";
    public static Mod_Config config = new Mod_Config();

    public Main() {
        config.Init();
        MinecraftForge.EVENT_BUS.register(this);
    }
}