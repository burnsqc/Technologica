package com.technologica.network.packethandlers;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.network.packets.ClientboundUpdateAirCapabilityPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundPacketHandlers {

	public static void handleUpdateAirCapability(ClientboundUpdateAirCapabilityPacket packet, final Supplier<NetworkEvent.Context> context) {
		Technologica.LOGGER.debug("HANDLING PACKET - CLIENTBOUND - UPDATE AIR");
		Minecraft minecraft = Minecraft.getInstance();
		Player player = minecraft.player;
		IAir airCapability2 = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
		airCapability2.setNewMaxAir(packet.getAir());
	}

}