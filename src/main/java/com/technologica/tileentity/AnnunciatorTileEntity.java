package com.technologica.tileentity;

import com.technologica.inventory.container.AnnunciatorContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;

public class AnnunciatorTileEntity extends SignTileEntity implements INamedContainerProvider {
	
	@Override
	public TileEntityType<?> getType() {
		return TechnologicaTileEntities.ANNUNCIATOR_TILE.get();
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		return new AnnunciatorContainer(p_createMenu_1_, p_createMenu_2_);
	}

	@Override
	public ITextComponent getDisplayName() {
		
		return null;
	}
}