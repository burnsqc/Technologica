package com.technologica.block;

import java.util.Random;

import com.technologica.tileentity.MulchTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MulchBlock extends Block {
	public static final IntegerProperty MULCH_AGE = BlockStateProperties.AGE_3;
	
	
	public MulchBlock() {
		super(AbstractBlock.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(MULCH_AGE, 0));
		
	}

	/*
	 * Technologica Methods
	 */
	
	public MulchTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (MulchTileEntity) worldIn.getBlockEntity(posIn);
	}
	
	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		MulchTileEntity mulchTileEntity = getTileEntity(worldIn, posIn);
		boolean grow = false;
		
		for(int i = -1; i < 2; ++i) {
			for(int j = -1; j < 2; ++j) {
				BlockState checkGrow = worldIn.getBlockState(posIn.offset(i, 1, j));
				if (checkGrow.getBlock() instanceof FruitingLogBlock || checkGrow.getBlock() instanceof SapLogBlock) {
					if (!checkGrow.getValue(BlockStateProperties.PERSISTENT)) {
						grow = true;
					}
				}
			}
		}
		
		if (grow) {
			for(int i = -9; i < 10; ++i) {
				for(int j = -9; j < 10; ++j) {
					for(int k = 1; k < 20; ++k) {
						BlockState toGrow = worldIn.getBlockState(posIn.offset(i, k, j));
						if (toGrow.getBlock() instanceof FruitingLeavesBlock) {
							if (!toGrow.getValue(FruitingLeavesBlock.PERSISTENT) && toGrow.getValue(FruitingLeavesBlock.AGE) < 15 && toGrow.getValue(FruitingLeavesBlock.DISTANCE) < 7) {
								toGrow.randomTick(worldIn, posIn.offset(i, k, j), worldIn.random);	
							}
						} else if (toGrow.getBlock() instanceof SapLogBlock) {
							if (!toGrow.getValue(SapLogBlock.PERSISTENT) && toGrow.getValue(SapLogBlock.AGE) < 15) {
								toGrow.randomTick(worldIn, posIn.offset(i, k, j), worldIn.random);	
							}
						}
					}
				}
			}	
		}
		
		if (stateIn.getValue(MULCH_AGE) < 2) {
			worldIn.setBlock(posIn, stateIn.setValue(MULCH_AGE, stateIn.getValue(MULCH_AGE) + 1), 3);
		} else {
			worldIn.setBlock(posIn, mulchTileEntity.getPreviousBlockState(), 3);
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(MULCH_AGE);
		super.createBlockStateDefinition(builderIn);
	}
	
	/*
	 * Forge Methods
	 */

	@Override
	public boolean hasTileEntity(BlockState stateIn) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState stateIn, IBlockReader worldIn) {
		return new MulchTileEntity();
	}
}
