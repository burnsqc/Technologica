package com.technologica.network.play.client;

import java.util.function.Supplier;

import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;

public class CUpdateAnnunciatorPacket {
	private BlockPos pos;
	private String[] lines;

	public CUpdateAnnunciatorPacket(BlockPos pos, String line1, String line2, String line3, String line4, String line5, String line6, String line7, String line8) {
		this.pos = pos;
		this.lines = new String[] { line1, line2, line3, line4, line5, line6, line7, line8 };
	}

	public static void encode(CUpdateAnnunciatorPacket msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
		for (int i = 0; i < 8; ++i) {
			buf.writeUtf(msg.lines[i]);
		}
	}

	public static CUpdateAnnunciatorPacket decode(FriendlyByteBuf buf) {
		BlockPos pos2 = buf.readBlockPos();

		String[] lines2 = new String[8];
		for (int i = 0; i < 8; ++i) {
			lines2[i] = buf.readUtf(384);
		}

		return new CUpdateAnnunciatorPacket(pos2, lines2[0], lines2[1], lines2[2], lines2[3], lines2[4], lines2[5], lines2[6], lines2[7]);
	}

	public static void handle(CUpdateAnnunciatorPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Level world = ctx.get().getSender().level();
			BlockEntity tileentity = world.getBlockEntity(msg.pos);
			BlockState blockstate = world.getBlockState(msg.pos);

			if (tileentity instanceof AnnunciatorBlockEntity) {
				for (int i = 0; i < 8; ++i) {
					((AnnunciatorBlockEntity) tileentity).setText(i, Component.nullToEmpty(msg.lines[i]));
				}
				tileentity.setChanged();
				world.sendBlockUpdated(msg.pos, blockstate, blockstate, 3);
			}
		});
		ctx.get().setPacketHandled(true);
	}
}