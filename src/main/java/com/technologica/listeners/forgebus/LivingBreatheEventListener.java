package com.technologica.listeners.forgebus;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingBreatheEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingBreatheEventListener {

	@SubscribeEvent
	public void onLivingBreatheEvent(final LivingBreatheEvent event) {
		if (event.getEntity() instanceof Player player) {
			int maxAir = player.getMaxAirSupply();
			if (maxAir == 600) {
				if (event.canBreathe()) {
					if (event.canRefillAir()) {
						event.setRefillAirAmount(Math.min(player.getAirSupply() + 8, maxAir) - player.getAirSupply());
						player.setAirSupply(Math.min(player.getAirSupply() + event.getRefillAirAmount(), maxAir));
						event.setCanRefillAir(false);
					}
				}
			}
		}
	}
}
