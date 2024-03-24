package com.technologica.network.packethandlers;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.network.packets.clientbound.SetMeteorStorm;
import com.technologica.network.packets.clientbound.SetMeteorStormLevel;
import com.technologica.network.packets.clientbound.UpdateDiverCapability;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundPacketHandlers {

	public static void handleUpdateDiverCapability(UpdateDiverCapability packet, final Supplier<NetworkEvent.Context> context) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer player = minecraft.player;
		TechnologicaAbilities diver = player.getCapability(TechnologicaCapabilities.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
		diver.setDiver(packet.getDiver());
	}

	public static void handleSetMeteorStorm(SetMeteorStorm packet, final Supplier<NetworkEvent.Context> context) {
		TechnologicaClientLevel level = Technologica.getInstance().clientLevel;
		if (packet.getStorm()) {
			level.getLevelData().setMeteorStorming(true);
			level.setMeteorStormLevel(0.0F);
		} else {
			level.getLevelData().setMeteorStorming(false);
			level.setMeteorStormLevel(1.0F);
		}
	}

	public static void handleSetMeteorStormLevel(SetMeteorStormLevel packet, final Supplier<NetworkEvent.Context> context) {
		TechnologicaClientLevel level = Technologica.getInstance().clientLevel;
		level.setMeteorStormLevel(packet.getStormLevel());
	}
}
