package com.technologica.listeners.forge;

import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class LivingFallEventListener {

	/**
	 * <p>
	 * Effectively disabled fall damage by multiplying the intended damage by zero if the entity is on the moon.
	 * </p>
	 * 
	 * @param event LivingFallEvent
	 */
	@SubscribeEvent
	public static void lunarLowGrav(final LivingFallEvent event) {
		if (event.getEntity().level().dimension().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0.0F);
		}
	}
}