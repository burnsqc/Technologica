package com.technologica.network.play.server;

import java.util.function.Supplier;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class SUpdateAirCapabilityPacket {
	private int air;

	public SUpdateAirCapabilityPacket(int air) {
		this.air = air;
	}

	public static void encode(SUpdateAirCapabilityPacket msg, FriendlyByteBuf buf) {
		buf.writeInt(msg.air);
	}

	public static SUpdateAirCapabilityPacket decode(FriendlyByteBuf buf) {
		int air2 = buf.readInt();

		return new SUpdateAirCapabilityPacket(air2);
	}

	public static void handle(SUpdateAirCapabilityPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Minecraft minecraft = Minecraft.getInstance();
			Player player = minecraft.player;
			IAir airCapability2 = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
			airCapability2.setNewMaxAir(msg.air);
		});
		ctx.get().setPacketHandled(true);
	}
}