package com.technologica.listeners.forgebus;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingBreatheEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingBreatheEventListener {

	@SubscribeEvent
	public void onLivingBreatheEvent(LivingBreatheEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
			int newMaxAir = airCapability.getNewMaxAir();

			if (newMaxAir == 600) {
				if (event.canBreathe()) {
					if (event.canRefillAir()) {
						event.setRefillAirAmount(Math.min(player.getAirSupply() + 8, newMaxAir) - player.getAirSupply());
						player.setAirSupply(Math.min(player.getAirSupply() + event.getRefillAirAmount(), newMaxAir));
						event.setCanRefillAir(false);
					}
				}
			} else if (newMaxAir == 6000) {
				if (event.canBreathe()) {
					if (event.canRefillAir()) {
						event.setRefillAirAmount(Math.min(player.getAirSupply() + 4, newMaxAir) - player.getAirSupply());
						player.setAirSupply(Math.min(player.getAirSupply() + event.getRefillAirAmount(), newMaxAir));
						event.setCanRefillAir(false);
					}
				}
			}
		}
	}
}