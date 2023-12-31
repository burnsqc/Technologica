package com.technologica.network.packets;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundSetMeteorStorm {
	private boolean isStorming;

	public ClientboundSetMeteorStorm(boolean isStormingIn) {
		isStorming = isStormingIn;
	}

	public static void encode(ClientboundSetMeteorStorm msg, FriendlyByteBuf buf) {
		buf.writeBoolean(msg.isStorming);
	}

	public static ClientboundSetMeteorStorm decode(FriendlyByteBuf buf) {
		boolean isStormingOut = buf.readBoolean();
		return new ClientboundSetMeteorStorm(isStormingOut);
	}

	public static void handle(ClientboundSetMeteorStorm packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleSetMeteorStorm(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public boolean getStorm() {
		return isStorming;
	}
}