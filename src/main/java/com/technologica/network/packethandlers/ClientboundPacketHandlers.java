package com.technologica.network.packethandlers;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.network.packets.ClientboundSetMeteorStorm;
import com.technologica.network.packets.ClientboundSetMeteorStormLevel;
import com.technologica.network.packets.ClientboundUpdateAirCapabilityPacket;
import com.technologica.setup.listeners.TechnologicaCapabilities;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundPacketHandlers {

	public static void handleUpdateAirCapability(ClientboundUpdateAirCapabilityPacket packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - UPDATE AIR");

		Minecraft minecraft = Minecraft.getInstance();
		Player player = minecraft.player;
		IAir airCapability2 = player.getCapability(TechnologicaCapabilities.AIR_METER_INSTANCE).orElseThrow(NullPointerException::new);
		airCapability2.setNewMaxAir(packet.getAir());
	}

	public static void handleSetMeteorStorm(ClientboundSetMeteorStorm packet, final Supplier<NetworkEvent.Context> context) {
		// Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - SET METEOR STORM ");

		TechnologicaClientLevel level = Technologica.getInstance().clientLevel;

		if (packet.getStorm()) {
			level.getLevelData().setMeteorStorming(true);
			level.setMeteorStormLevel(0.0F);
		} else {
			level.getLevelData().setMeteorStorming(false);
			level.setMeteorStormLevel(1.0F);
		}
	}

	public static void handleSetMeteorStormLevel(ClientboundSetMeteorStormLevel packet, final Supplier<NetworkEvent.Context> context) {
		// Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - SET METEOR STORM LEVEL");

		TechnologicaClientLevel level = Technologica.getInstance().clientLevel;

		level.setMeteorStormLevel(packet.getStormLevel());
	}
}