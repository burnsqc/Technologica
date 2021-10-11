package com.technologica.network.play.server;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

public class SOpenModSignMenuPacket {
	private BlockPos signPosition;

	public SOpenModSignMenuPacket(BlockPos posIn) {
		this.signPosition = posIn;
	}

	public static void encode(SOpenModSignMenuPacket msg, PacketBuffer buf) {
		buf.writeBlockPos(msg.signPosition);
	}

	public static SOpenModSignMenuPacket decode(PacketBuffer buf) {
		return new SOpenModSignMenuPacket(buf.readBlockPos());
	}

	public static void handle(SOpenModSignMenuPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientHandlers.handleModSignPacket(msg.signPosition)));
		ctx.get().setPacketHandled(true);
	}	
}