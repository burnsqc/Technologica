package com.technologica.util;

import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LowGrav {
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.getEntity().world.getDimensionKey().toString().contains("technologica:moon")) {

			event.getEntity().addVelocity(0, 1, 0);
			event.getEntity().velocityChanged = true;
		}
	}

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.getEntity().world.getDimensionKey().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}