package com.technologica.listeners.forgebus;

import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * <p>
 * This class listens for LivingFallEvent which is fired on the Forge event bus.
 * When the event is intercepted, the Lunar Low Grav feature is invoked.
 * </p>
 * 
 * @tl.status GREEN
 */

public class LivingFallEventListener {

	/**
	 * <p>
	 * Effectively disabled fall damage by multiplying the intended damage by zero if the entity is on the moon.
	 * </p>
	 * 
	 * @param event LivingFallEvent
	 */
	@SubscribeEvent
	public void lunarLowGrav(final LivingFallEvent event) {
		if (event.getEntity().level().dimension().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0.0F);
		}
	}
}