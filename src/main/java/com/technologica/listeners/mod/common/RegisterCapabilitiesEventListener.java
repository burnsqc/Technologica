package com.technologica.listeners.mod.common;

import com.technologica.capabilities.item.link.Link;
import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class RegisterCapabilitiesEventListener {
	public static final Capability<TechnologicaAbilities> DIVER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});
	public static final Capability<Link> LINK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	@SubscribeEvent
	public static final void onRegisterCapabilitiesEvent(final RegisterCapabilitiesEvent event) {
		event.register(TechnologicaAbilities.class);
		event.register(Link.class);
	}
}
