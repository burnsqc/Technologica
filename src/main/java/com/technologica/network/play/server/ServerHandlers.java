package com.technologica.network.play.server;

import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.DistExecutor;

public class ServerHandlers {

	public static DistExecutor.SafeRunnable handleAnnunciatorPacket(BlockPos pos, String[] lines) {
		return new DistExecutor.SafeRunnable() {
			private static final long serialVersionUID = 2L;

			@Override
			public void run() {
				Minecraft mc = Minecraft.getInstance();
				TileEntity tileentity = mc.world.getTileEntity(pos);

				if (tileentity instanceof AnnunciatorTileEntity) {
					for (int i = 0; i < 7; ++i) {
						((AnnunciatorTileEntity) tileentity).setText(i, ITextComponent.getTextComponentOrEmpty(lines[i]));
					}
				}
			}
		};
	}
}