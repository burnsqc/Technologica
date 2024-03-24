package com.technologica.network.packets.clientbound;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetMeteorStormLevel {
	private float stormLevel;

	public SetMeteorStormLevel(float stormLevel) {
		this.stormLevel = stormLevel;
	}

	public static void encode(SetMeteorStormLevel packet, FriendlyByteBuf buffer) {
		buffer.writeFloat(packet.stormLevel);
	}

	public static SetMeteorStormLevel decode(FriendlyByteBuf buffer) {
		return new SetMeteorStormLevel(buffer.readFloat());
	}

	public static void handle(SetMeteorStormLevel packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleSetMeteorStormLevel(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public float getStormLevel() {
		return this.stormLevel;
	}
}
