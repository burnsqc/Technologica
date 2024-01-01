package com.technologica.network.packets;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundTriggerEnvironmentTitleCardPacket {
	private boolean dimensionOrBiome;

	public ClientboundTriggerEnvironmentTitleCardPacket(boolean dimensionOrBiomeIn) {
		dimensionOrBiome = dimensionOrBiomeIn;
	}

	public static void encode(ClientboundTriggerEnvironmentTitleCardPacket msg, FriendlyByteBuf buf) {
		buf.writeBoolean(msg.dimensionOrBiome);
	}

	public static ClientboundTriggerEnvironmentTitleCardPacket decode(FriendlyByteBuf buf) {
		boolean dimensionOrBiomeOut = buf.readBoolean();
		return new ClientboundTriggerEnvironmentTitleCardPacket(dimensionOrBiomeOut);
	}

	public static void handle(ClientboundTriggerEnvironmentTitleCardPacket packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleTriggerEnvironmentTitleCard(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public boolean getDimensionOrBiome() {
		return dimensionOrBiome;
	}
}