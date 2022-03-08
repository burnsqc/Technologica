package com.technologica.block;

import com.technologica.tileentity.VanillaSignTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

/**
 * Identical in behavior to vanilla Minecraft wall signs.  
 * Created to handle mod wood types and associated tile entity.
 */
public class VanillaWallSignBlock extends WallSignBlock {

	public VanillaWallSignBlock(WoodType typeIn) {
		super(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), typeIn);
	}
	
	/*
	 * Forge Methods
	 */
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
	      return new VanillaSignTileEntity();
	   }
}
