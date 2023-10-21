package com.technologica.listeners.forgebus;

import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingFallEventListener {

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.getEntity().level().dimension().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}