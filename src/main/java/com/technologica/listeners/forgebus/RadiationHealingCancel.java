package com.technologica.listeners.forgebus;

import com.technologica.world.effect.TechnologicaMobEffects;

import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RadiationHealingCancel {

	@SubscribeEvent
	public void onLivingHealEvent(LivingHealEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.RADIATION.get())) {
			event.setCanceled(true);
		}
	}
}