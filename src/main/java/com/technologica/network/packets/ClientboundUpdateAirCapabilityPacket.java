package com.technologica.network.packets;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundUpdateAirCapabilityPacket {
	private int air;

	public ClientboundUpdateAirCapabilityPacket(int airIn) {
		air = airIn;
	}

	public static void encode(ClientboundUpdateAirCapabilityPacket msg, FriendlyByteBuf buf) {
		buf.writeInt(msg.air);
	}

	public static ClientboundUpdateAirCapabilityPacket decode(FriendlyByteBuf buf) {
		int air2 = buf.readInt();
		return new ClientboundUpdateAirCapabilityPacket(air2);
	}

	public static void handle(ClientboundUpdateAirCapabilityPacket packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleUpdateAirCapability(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public int getAir() {
		return air;
	}
}