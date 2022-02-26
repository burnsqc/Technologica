package com.technologica.network.protocol.game;

import java.util.function.Supplier;

import com.technologica.network.play.server.ClientHandlers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ClientboundOpenTechnologicaSignEditorPacket {
	private BlockPos signPosition;

	public ClientboundOpenTechnologicaSignEditorPacket(BlockPos posIn) {
		this.signPosition = posIn;
	}

	public static void encode(ClientboundOpenTechnologicaSignEditorPacket msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.signPosition);
	}

	public static ClientboundOpenTechnologicaSignEditorPacket decode(FriendlyByteBuf buf) {
		return new ClientboundOpenTechnologicaSignEditorPacket(buf.readBlockPos());
	}

	public static void handle(ClientboundOpenTechnologicaSignEditorPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientHandlers.handleModSignPacket(msg.signPosition)));
		ctx.get().setPacketHandled(true);
	}	
}