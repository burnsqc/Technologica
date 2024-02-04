package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Sound Events.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaSoundEvents extends MasterDeferredRegistrar {

	public static int init() {
		return SOUND_EVENTS.getEntries().size();
	}

	public static final RegistryObject<SoundEvent> DODGEBALL = SOUND_EVENTS.register("dodgeball", () -> SoundEvent.createVariableRangeEvent(new TechnologicaLocation("dodgeball")));
}