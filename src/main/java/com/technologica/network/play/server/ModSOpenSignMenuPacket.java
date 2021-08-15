package com.technologica.network.play.server;

import java.util.function.Supplier;

import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModSOpenSignMenuPacket {
	private BlockPos signPosition;

	public ModSOpenSignMenuPacket(BlockPos posIn) {
		this.signPosition = posIn;
	}

	public static void encode(ModSOpenSignMenuPacket msg, PacketBuffer buf) {
		buf.writeBlockPos(msg.signPosition);
	}

	public static ModSOpenSignMenuPacket decode(PacketBuffer buf) {
		return new ModSOpenSignMenuPacket(buf.readBlockPos());
	}

	public static void handle(ModSOpenSignMenuPacket msg, final Supplier<NetworkEvent.Context> ctx) {
		
		Minecraft mc = Minecraft.getInstance();

		TileEntity tileentity = mc.world.getTileEntity(msg.signPosition);
		if (!(tileentity instanceof ModSignTileEntity)) {
			tileentity = new ModSignTileEntity();
			tileentity.setWorldAndPos(mc.world, msg.signPosition);
		}
		
		ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHandler.handlePacket(msg.signPosition)));
		ctx.get().setPacketHandled(true);
	}	
}