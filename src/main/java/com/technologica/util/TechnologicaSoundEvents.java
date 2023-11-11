package com.technologica.util;

import static com.technologica.Technologica.MOD_ID;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.Keys.SOUND_EVENTS, MOD_ID);

	public static int init() {
		SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		return SOUND_EVENTS.getEntries().size();
	}

	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("dodgeball")));
}
