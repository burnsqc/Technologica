package com.technologica.network.play.server;

import com.technologica.client.gui.screen.ModEditSignScreen;
import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.DistExecutor;

public class ClientHandler {
	public static DistExecutor.SafeRunnable handlePacket(BlockPos signPosition) {
		return new DistExecutor.SafeRunnable() {
			@Override
			public void run() {
				Minecraft mc = Minecraft.getInstance();
				TileEntity tileentity = mc.world.getTileEntity(signPosition);
				Minecraft.getInstance().displayGuiScreen(new ModEditSignScreen((ModSignTileEntity) tileentity));

			}
		};
	}
}