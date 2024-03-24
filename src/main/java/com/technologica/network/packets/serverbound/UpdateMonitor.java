package com.technologica.network.packets.serverbound;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ServerboundPacketHandlers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class UpdateMonitor {
	private BlockPos pos;
	private String[] lines;

	public UpdateMonitor(BlockPos pos, String line1, String line2, String line3, String line4, String line5, String line6, String line7, String line8, String line9, String line10, String line11, String line12, String line13, String line14, String line15, String line16) {
		this.pos = pos;
		this.lines = new String[] { line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, line13, line14, line15, line16 };
	}

	public static void encode(UpdateMonitor msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
		for (int i = 0; i < 16; ++i) {
			buf.writeUtf(msg.lines[i]);
		}
	}

	public static UpdateMonitor decode(FriendlyByteBuf buf) {
		BlockPos pos2 = buf.readBlockPos();
		String[] lines2 = new String[16];
		for (int i = 0; i < 16; ++i) {
			lines2[i] = buf.readUtf(384);
		}
		return new UpdateMonitor(pos2, lines2[0], lines2[1], lines2[2], lines2[3], lines2[4], lines2[5], lines2[6], lines2[7], lines2[8], lines2[9], lines2[10], lines2[11], lines2[12], lines2[13], lines2[14], lines2[15]);
	}

	public static void handle(UpdateMonitor packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ServerboundPacketHandlers.handleUpdateMonitor(packet, context);
		});
		context.get().setPacketHandled(true);
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public String[] getLines() {
		return this.lines;
	}
}