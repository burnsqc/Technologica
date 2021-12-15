package com.technologica.network.play.server;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

public class SOpenAnnunciatorMenuPacket {
	private BlockPos pos;

	public SOpenAnnunciatorMenuPacket(BlockPos posIn) {
		this.pos = posIn;
	}

	public static void encode(SOpenAnnunciatorMenuPacket msg, PacketBuffer buf) {
		buf.writeBlockPos(msg.pos);
	}

	public static SOpenAnnunciatorMenuPacket decode(PacketBuffer buf) {
		return new SOpenAnnunciatorMenuPacket(buf.readBlockPos());
	}

	public static void handle(SOpenAnnunciatorMenuPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientHandlers.handleAnnunciatorPacket(msg.pos)));
		ctx.get().setPacketHandled(true);
	}	
}