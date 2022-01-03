package com.technologica.network.play.client;

import java.util.function.Supplier;

import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

public class CUpdateAnnunciatorPacket {
	private BlockPos pos;
	private String[] lines;

	public CUpdateAnnunciatorPacket(BlockPos pos, String line1, String line2, String line3, String line4, String line5, String line6, String line7, String line8) {
		this.pos = pos;
		this.lines = new String[] { line1, line2, line3, line4, line5, line6, line7, line8 };
	}

	public static void encode(CUpdateAnnunciatorPacket msg, PacketBuffer buf) {
		buf.writeBlockPos(msg.pos);

		for (int i = 0; i < 8; ++i) {
			buf.writeString(msg.lines[i]);
		}
	}

	public static CUpdateAnnunciatorPacket decode(PacketBuffer buf) {
		BlockPos pos2 = buf.readBlockPos();
		
		String[] lines2 = new String[8];
		for (int i = 0; i < 8; ++i) {
			lines2[i] = buf.readString(384);
		}
		
		return new CUpdateAnnunciatorPacket(pos2, lines2[0], lines2[1], lines2[2], lines2[3], lines2[4], lines2[5], lines2[6], lines2[7]);
	}

	public static void handle(CUpdateAnnunciatorPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerWorld world = ctx.get().getSender().getServerWorld();
			TileEntity tileentity = world.getTileEntity(msg.pos);
			BlockState blockstate = world.getBlockState(msg.pos);
			
			if (tileentity instanceof AnnunciatorTileEntity) {
				for (int i = 0; i < 8; ++i) {
					((AnnunciatorTileEntity) tileentity).setText(i, ITextComponent.getTextComponentOrEmpty(msg.lines[i]));
				}
				tileentity.markDirty();
		        world.notifyBlockUpdate(msg.pos, blockstate, blockstate, 3);
			}
		});
		ctx.get().setPacketHandled(true);
	}

}