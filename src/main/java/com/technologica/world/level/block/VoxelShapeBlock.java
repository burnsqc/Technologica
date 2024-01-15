package com.technologica.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VoxelShapeBlock extends Block {
	private VoxelShape voxelShape;

	public VoxelShapeBlock(VoxelShape voxelShape, BlockBehaviour.Properties properties) {
		super(properties);
		this.voxelShape = voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		return this.voxelShape;
	}
}
