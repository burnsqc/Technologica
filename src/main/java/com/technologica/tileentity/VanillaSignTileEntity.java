package com.technologica.tileentity;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class VanillaSignTileEntity extends SignTileEntity {
	
	@Override
	public TileEntityType<?> getType() {
		return TechnologicaTileEntities.MOD_SIGN.get();
	}
}