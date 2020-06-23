package com.conmod.MODNAME;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("MODNAME")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main {

  public static final String MODID = "MODNAME";
  public static final Logger LOG = LogManager.getLogger();

  public Main() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
  }
}