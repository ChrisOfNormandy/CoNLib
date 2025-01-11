package com.github.chrisofnormandy.conlib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimalModel;
import com.github.chrisofnormandy.conlib.mobs.types.CustomMobRenderer;
import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.mojang.logging.LogUtils;

@Mod(CoNLib.MOD_ID)
public class CoNLib {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "conlib";
    public static final ModConfig config = new ModConfig();

    public CoNLib() {
        LOGGER.info("MOD IS LOADING!");
        init();
    }

    private void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("CONLIB COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        LOGGER.info("ASSIGNING CREATIVE TABS");

        ModRegister.creativeTabs.forEach((key, value) -> {
            if (event.getTabKey() == key) {
                value.forEach((item) -> event.accept(item));
            }
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods
    // in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            ModRegister.entityRendering.forEach((key, value) -> {
                EntityRenderers.register(value.y.get(),
                        context -> new CustomMobRenderer(context, new CustomAnimalModel<CustomAnimal>(context.bakeLayer(
                                new ModelLayerLocation(new ResourceLocation(value.x, key), "main"))),
                                0.5F) {
                            @Override
                            public ResourceLocation getTextureLocation(CustomAnimal entity) {
                                return new ResourceLocation(value.x, "textures/entity/" + key + ".png");
                            }
                        });
            });
        }
    }

    @SubscribeEvent
    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        ModRegister.entityAttributes.forEach((key, value) -> {
            event.put(key.get(), value.get().build());
        });
    }
}