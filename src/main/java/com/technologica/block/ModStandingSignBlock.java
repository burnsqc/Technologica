package com.technologica.block;

import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModStandingSignBlock extends StandingSignBlock {

	public ModStandingSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
	      return new ModSignTileEntity();
	   }
}
