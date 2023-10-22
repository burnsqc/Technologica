package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;
import com.technologica.client.renderer.MoonRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;

/**
 * <p>
 * This class listens for RegisterDimensionSpecialEffectsEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Dimension Special Effects are registered.
 * </p>
 * 
 * @tl.status YELLOW
 */

public class RegisterDimensionSpecialEffects {

	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		event.register(new ResourceLocation(Technologica.MODID, "moon"), new MoonRenderer());
		/**
		 * TODO: Determine how to count how many Technologica Dimension Special Effects actually got registered and replace the hard-coded value in the logger message.
		 */
		LOGGER.info("DIMENSION SPECIAL EFFECTS REGISTERED: 1 OF 1");
	}
}