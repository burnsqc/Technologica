package com.technologica.network.packets.serverbound;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ServerboundPacketHandlers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class UpdateMonitor {
	private BlockPos blockPos;
	private String[] text;

	public UpdateMonitor(BlockPos blockPos, String[] text) {
		this.blockPos = blockPos;
		this.text = text;
	}

	public static void encode(UpdateMonitor packet, FriendlyByteBuf buffer) {
		buffer.writeBlockPos(packet.blockPos);
		for (int row = 0; row < packet.text.length; ++row) {
			buffer.writeUtf(packet.text[row]);
		}
	}

	public static UpdateMonitor decode(FriendlyByteBuf buffer) {
		BlockPos blockPos = buffer.readBlockPos();
		String[] text = new String[32];
		for (int row = 0; row < text.length; ++row) {
			text[row] = buffer.readUtf();
		}
		return new UpdateMonitor(blockPos, text);
	}

	public static void handle(UpdateMonitor packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> ServerboundPacketHandlers.handleUpdateMonitor(packet, context));
		context.get().setPacketHandled(true);
	}

	public BlockPos getBlockPos() {
		return this.blockPos;
	}

	public String[] getText() {
		return this.text;
	}
}
