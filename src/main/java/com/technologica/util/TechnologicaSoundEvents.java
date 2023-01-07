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
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.Keys.SOUND_EVENTS, MODID);

	public static void init() {
		SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("SOUND EVENTS INITIALIZED: " + SOUND_EVENTS.getEntries().size() + " OF 1");
	}

	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Technologica.MODID, "dodgeball")));
}
