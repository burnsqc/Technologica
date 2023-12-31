package com.technologica.network.packethandlers;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.forgebus.ServerTickEventListener;
import com.technologica.network.packets.ClientboundSetMeteorStorm;
import com.technologica.network.packets.ClientboundSetMeteorStormLevel;
import com.technologica.network.packets.ClientboundTriggerEnvironmentTitleCardPacket;
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

	public static void handleTriggerEnvironmentTitleCard(ClientboundTriggerEnvironmentTitleCardPacket packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - TRIGGER ENVIRONMENT TITLE CARD");
		if (packet.getDimensionOrBiome() == false) {
			RenderGuiOverlayEventListener.triggerDimensionTitleCard();
		} else {
			RenderGuiOverlayEventListener.triggerBiomeTitleCard();
		}
	}

	public static void handleSetMeteorStorm(ClientboundSetMeteorStorm packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - SET METEOR STORM ");
		if (packet.getStorm()) {
			ServerTickEventListener.setStorming(true);
			ServerTickEventListener.setStormLevel(0.0F);
		} else {
			ServerTickEventListener.setStorming(false);
			ServerTickEventListener.setStormLevel(1.0F);
		}
	}

	public static void handleSetMeteorStormLevel(ClientboundSetMeteorStormLevel packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - SET METEOR STORM LEVEL");
		ServerTickEventListener.setStormLevel(packet.getStormLevel());
	}
}