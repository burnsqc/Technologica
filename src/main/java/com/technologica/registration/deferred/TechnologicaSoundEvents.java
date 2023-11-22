package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaSoundEvents extends MasterDeferredRegistrar {
	
	public static int init() {
		SOUND_EVENTS.register(Technologica.MOD_EVENT_BUS);
		return SOUND_EVENTS.getEntries().size();
	}

	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("dodgeball")));
}