package com.technologica.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;

/**
 * Identical in behavior to vanilla Minecraft wall signs.  
 * Created to handle mod wood types and associated tile entity.
 */
public class VanillaWallSignBlock extends WallSignBlock {

	public VanillaWallSignBlock(WoodType typeIn) {
		super(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn);
	}
	
	/*
	 * Forge Methods
	 */
	
	@Override
	public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
		return new SignBlockEntity(p_154556_, p_154557_);
	}
}
