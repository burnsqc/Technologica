package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.MulchTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class MulchBlock extends Block implements EntityBlock {
	public static final IntegerProperty MULCH_AGE = BlockStateProperties.AGE_3;

	public MulchBlock() {
		super(BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(MULCH_AGE, 0));

	}

	/*
	 * Technologica Methods
	 */

	public MulchTileEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (MulchTileEntity) worldIn.getBlockEntity(posIn);
	}

	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		MulchTileEntity mulchTileEntity = getTileEntity(worldIn, posIn);
		boolean grow = false;

		for (int i = -1; i < 2; ++i) {
			for (int j = -1; j < 2; ++j) {
				BlockState checkGrow = worldIn.getBlockState(posIn.offset(i, 1, j));
				if (checkGrow.getBlock() instanceof FruitingLogBlock || checkGrow.getBlock() instanceof SapLogBlock) {
					if (!checkGrow.getValue(BlockStateProperties.PERSISTENT)) {
						grow = true;
					}
				}
			}
		}

		if (grow) {
			for (int i = -9; i < 10; ++i) {
				for (int j = -9; j < 10; ++j) {
					for (int k = 1; k < 20; ++k) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(MULCH_AGE);
		super.createBlockStateDefinition(builderIn);
	}

	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new MulchTileEntity(p_153215_, p_153216_);
	}
}
