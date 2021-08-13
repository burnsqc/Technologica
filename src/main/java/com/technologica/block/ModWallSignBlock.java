package com.technologica.block;

import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModWallSignBlock extends WallSignBlock {

	public ModWallSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
	      return new ModSignTileEntity();
	   }
}
