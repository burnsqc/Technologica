package com.technologica.network.packets;

import java.util.function.Supplier;

import com.technologica.network.packethandlers.ServerboundPacketHandlers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ServerboundUpdateAnnunciatorPacket {
	private BlockPos pos;
	private String[] lines;

	public ServerboundUpdateAnnunciatorPacket(BlockPos pos, String line1, String line2, String line3, String line4, String line5, String line6, String line7, String line8) {
		this.pos = pos;
		this.lines = new String[] { line1, line2, line3, line4, line5, line6, line7, line8 };
	}

	public static void encode(ServerboundUpdateAnnunciatorPacket msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
		for (int i = 0; i < 8; ++i) {
			buf.writeUtf(msg.lines[i]);
		}
	}

	public static ServerboundUpdateAnnunciatorPacket decode(FriendlyByteBuf buf) {
		BlockPos pos2 = buf.readBlockPos();

		String[] lines2 = new String[8];
		for (int i = 0; i < 8; ++i) {
			lines2[i] = buf.readUtf(384);
		}

		return new ServerboundUpdateAnnunciatorPacket(pos2, lines2[0], lines2[1], lines2[2], lines2[3], lines2[4], lines2[5], lines2[6], lines2[7]);
	}

	public static void handle(ServerboundUpdateAnnunciatorPacket packet, final Supplier<NetworkEvent.Context> context) {
		context.get().enqueueWork(() -> {
			ServerboundPacketHandlers.handleUpdateAnnunciatorPacket(packet, context);
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