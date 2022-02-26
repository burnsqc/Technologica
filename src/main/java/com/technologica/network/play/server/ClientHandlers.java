package com.technologica.network.play.server;

import com.technologica.client.gui.screens.inventory.TechnologicaSignEditScreen;
import com.technologica.world.level.block.entity.VanillaSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fml.DistExecutor;

public class ClientHandlers {
	
	public static DistExecutor.SafeRunnable handleModSignPacket(BlockPos signPosition) {
		return new DistExecutor.SafeRunnable() {
			private static final long serialVersionUID = 1L;

			@Override
			public void run() {
				Minecraft mc = Minecraft.getInstance();
				BlockEntity tileentity = mc.level.getBlockEntity(signPosition);
				
				if (!(tileentity instanceof VanillaSignTileEntity)) {
					tileentity = new VanillaSignTileEntity(signPosition, null);
					//tileentity.setLevelAndPosition(mc.level, signPosition);
				}
				
				mc.setScreen(new TechnologicaSignEditScreen((VanillaSignTileEntity) tileentity, false));
			}
		};
	}
}