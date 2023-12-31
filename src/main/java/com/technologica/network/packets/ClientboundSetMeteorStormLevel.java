package com.technologica.network.packets;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundSetMeteorStormLevel {
	private float stormLevel;

	public ClientboundSetMeteorStormLevel(float stormLevelIn) {
		stormLevel = stormLevelIn;
	}

	public static void encode(ClientboundSetMeteorStormLevel msg, FriendlyByteBuf buf) {
		buf.writeFloat(msg.stormLevel);
	}

	public static ClientboundSetMeteorStormLevel decode(FriendlyByteBuf buf) {
		float stormLevelOut = buf.readFloat();
		return new ClientboundSetMeteorStormLevel(stormLevelOut);
	}

	public static void handle(ClientboundSetMeteorStormLevel packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleSetMeteorStormLevel(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public float getStormLevel() {
		return stormLevel;
	}
}