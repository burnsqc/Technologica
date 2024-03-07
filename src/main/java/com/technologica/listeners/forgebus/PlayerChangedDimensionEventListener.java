package com.technologica.listeners.forgebus;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.network.packets.ClientboundUpdateAirCapabilityPacket;
import com.technologica.setup.listeners.TechnologicaCapabilities;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

public class PlayerChangedDimensionEventListener {

	@SubscribeEvent
	public void onPlayerChangedDimensionEvent(final PlayerChangedDimensionEvent event) {
		ServerPlayer player = (ServerPlayer) event.getEntity();
		IAir airCapability = player.getCapability(TechnologicaCapabilities.AIR_METER_INSTANCE).orElseThrow(NullPointerException::new);
		int newMaxAir = airCapability.getNewMaxAir();
		Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new ClientboundUpdateAirCapabilityPacket(newMaxAir));
	}
}
