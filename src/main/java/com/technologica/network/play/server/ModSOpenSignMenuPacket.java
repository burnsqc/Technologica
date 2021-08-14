package com.technologica.network.play.server;

import java.util.function.Supplier;

import com.technologica.client.gui.screen.ModEditSignScreen;
import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
		ctx.get().enqueueWork(() ->
				DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> handlePacket(msg, ctx))
		);
		ctx.get().setPacketHandled(true);
	}
   
   @OnlyIn(Dist.CLIENT)
   public static void handlePacket(ModSOpenSignMenuPacket msg, final Supplier<NetworkEvent.Context> ctx) {
	   	      
	   TileEntity tileentity = ctx.get().getSender().world.getTileEntity(msg.signPosition);
	   if (!(tileentity instanceof ModSignTileEntity)) {
		   tileentity = new ModSignTileEntity();
	       tileentity.setWorldAndPos(ctx.get().getSender().world, msg.signPosition);
	      }
	   
	   Minecraft mc = Minecraft.getInstance();
	   
	   mc.displayGuiScreen(new ModEditSignScreen((ModSignTileEntity) tileentity));
   }
}