package com.technologica.network.packets.clientbound;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetMeteorStorm {
	private boolean storming;

	public SetMeteorStorm(boolean storming) {
		this.storming = storming;
	}

	public static void encode(SetMeteorStorm packet, FriendlyByteBuf buffer) {
		buffer.writeBoolean(packet.storming);
	}

	public static SetMeteorStorm decode(FriendlyByteBuf buffer) {
		return new SetMeteorStorm(buffer.readBoolean());
	}

	public static void handle(SetMeteorStorm packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleSetMeteorStorm(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public boolean getStorm() {
		return this.storming;
	}
}
