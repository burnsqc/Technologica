package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.client.renderer.MoonRenderer;
import com.technologica.world.level.dimension.TechnologicaBuiltinDimensionTypes;

import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;

/**
 * <p>
 * This class listens for RegisterDimensionSpecialEffectsEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Dimension Special Effects are registered.
 * </p>
 * 
 * @tl.status YELLOW
 * @author Jonathan
 */

public class RegisterDimensionSpecialEffects {

	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		event.register(TechnologicaBuiltinDimensionTypes.MOON_EFFECTS, new MoonRenderer());
		/**
		 * TODO: Determine how to count how many Technologica Dimension Special Effects actually got registered and replace the hard-coded value in the logger message.
		 */
		LOGGER.info("DIMENSION SPECIAL EFFECTS REGISTERED: 1 OF 1");
	}
}