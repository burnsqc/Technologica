package com.technologica.tileentity;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModSignTileEntity extends SignTileEntity {
	
	@Override
	public TileEntityType<?> getType() {
		return ModTileEntities.MOD_SIGN.get();
	}
}