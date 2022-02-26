package com.technologica.util;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING SOUND EVENTS");
        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info(SOUND_EVENTS.getEntries().size() + " SOUND EVENTS INITIALIZED");
    }
	
	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> new SoundEvent(new ResourceLocation(Technologica.MODID, "dodgeball")));
}
