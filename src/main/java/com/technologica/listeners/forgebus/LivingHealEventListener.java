package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingHealEventListener {

	@SubscribeEvent
	public void onLivingHealEvent(LivingHealEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.RADIATION.get())) {
			event.setCanceled(true);
		}
	}
}