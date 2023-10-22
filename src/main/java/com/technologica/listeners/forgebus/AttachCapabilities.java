package com.technologica.listeners.forgebus;

import com.technologica.capabilities.air.AirProvider;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AttachCapabilities {

	@SubscribeEvent
	public void onAttachCapabilitiesEvent(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			final AirProvider provider = new AirProvider();
			event.addCapability(AirProvider.IDENTIFIER, provider);
		}
	}
}