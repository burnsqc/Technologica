package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class LivingHealEventListener {

	@SubscribeEvent
	public static void onLivingHealEvent(LivingHealEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.RADIATION.get())) {
			event.setCanceled(true);
		}
	}
}
