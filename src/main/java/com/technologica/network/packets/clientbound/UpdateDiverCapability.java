package com.technologica.network.packets.clientbound;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ClientboundPacketHandlers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class UpdateDiverCapability {
	private boolean diver;

	public UpdateDiverCapability(boolean diver) {
		this.diver = diver;
	}

	public static void encode(UpdateDiverCapability packet, FriendlyByteBuf buffer) {
		buffer.writeBoolean(packet.diver);
	}

	public static UpdateDiverCapability decode(FriendlyByteBuf buffer) {
		return new UpdateDiverCapability(buffer.readBoolean());
	}

	public static void handle(UpdateDiverCapability packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ClientboundPacketHandlers.handleUpdateDiverCapability(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public boolean getDiver() {
		return this.diver;
	}
}
