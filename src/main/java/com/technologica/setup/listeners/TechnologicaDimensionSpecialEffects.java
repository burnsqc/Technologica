package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.client.renderer.MoonRenderer;
import com.technologica.registration.key.TechnologicaDimensionTypes;

import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;

/**
 * <p>
 * This class listens for RegisterDimensionSpecialEffectsEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Dimension Special Effects are registered.
 * </p>
 * 
 * @tl.status YELLOW
 */
public final class TechnologicaDimensionSpecialEffects {

	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		event.register(TechnologicaDimensionTypes.MOON_EFFECTS, new MoonRenderer());
		/**
		 * TODO: Determine how to count how many Technologica Dimension Special Effects actually got registered and replace the hard-coded value in the logger message.
		 */
		Technologica.LOGGER.info("SETUP - DIMENSION SPECIAL EFFECTS - 1 OF 1");
	}
}