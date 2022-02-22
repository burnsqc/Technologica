package com.technologica.network.play.server;

import com.technologica.client.gui.screen.EditModSignScreen;
import com.technologica.tileentity.VanillaSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.DistExecutor;

public class ClientHandlers {
	
	public static DistExecutor.SafeRunnable handleModSignPacket(BlockPos signPosition) {
		return new DistExecutor.SafeRunnable() {
			private static final long serialVersionUID = 1L;

			@Override
			public void run() {
				Minecraft mc = Minecraft.getInstance();
				TileEntity tileentity = mc.level.getBlockEntity(signPosition);
				
				if (!(tileentity instanceof VanillaSignTileEntity)) {
					tileentity = new VanillaSignTileEntity();
					tileentity.setLevelAndPosition(mc.level, signPosition);
				}
				
				mc.setScreen(new EditModSignScreen((VanillaSignTileEntity) tileentity));
			}
		};
	}
}