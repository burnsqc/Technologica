package com.technologica.network.play.server;

import com.technologica.client.gui.screen.ModEditSignScreen;
import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class ClientHandler {
	public static void handlePacket(BlockPos signPosition) {
		Minecraft mc = Minecraft.getInstance();
		TileEntity tileentity = mc.world.getTileEntity(signPosition);
		Minecraft.getInstance().displayGuiScreen(new ModEditSignScreen((ModSignTileEntity) tileentity));
	}
}