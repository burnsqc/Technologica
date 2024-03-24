package com.technologica.listeners.forgebus;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.player.TechnologicaAbilityProvider;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttachCapabilities {
	public static void onAttachCapabilitiesEvent(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			final TechnologicaAbilityProvider provider = new TechnologicaAbilityProvider();
			event.addCapability(new TechnologicaLocation("diver"), provider);
		}
	}
}
