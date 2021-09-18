package com.technologica.block;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TreeTapBlock extends FourDirectionBlock {
	private static final Map<Direction, VoxelShape> SHAPES = Maps
			.newEnumMap(ImmutableMap.of(
					Direction.NORTH, Block.makeCuboidShape(6.0D, 6.0D, 11.0D, 10.0D, 11.0D, 16.0D),
					Direction.SOUTH, Block.makeCuboidShape(6.0D, 6.0D, 0.0D, 10.0D, 11.0D, 5.0D), 
					Direction.WEST,	Block.makeCuboidShape(11.0D, 6.0D, 6.0D, 16.0D, 11.0D, 10.0D), 
					Direction.EAST, Block.makeCuboidShape(0.0D, 6.0D, 6.0D, 5.0D, 11.0D, 10.0D)));

	public TreeTapBlock(Properties propertiesIn) {
		super(propertiesIn);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return getShapeForState(state);
	}

	public static VoxelShape getShapeForState(BlockState state) {
		return SHAPES.get(state.get(HORIZONTAL_FACING));
	}

	public void animateTick(BlockState stateIn, World worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isRemote) {
			if (worldIn.getBlockState(posIn.offset(stateIn.get(FourDirectionBlock.HORIZONTAL_FACING).getOpposite())).getBlock() instanceof SapLogBlock) {
				if (worldIn.getBlockState(posIn.offset(stateIn.get(FourDirectionBlock.HORIZONTAL_FACING).getOpposite())).get(SapLogBlock.AGE) == 15) {
					double d0 = 0;
					double d1 = 0;
					double d2 = 0;
					
					switch (stateIn.get(FourDirectionBlock.HORIZONTAL_FACING)) {
						case EAST:
							d0 = (double) posIn.getX() + 0.28D;
							d1 = (double) posIn.getY() + 0.3D;
							d2 = (double) posIn.getZ() + 0.5D;
							break;
						case NORTH:
							d0 = (double) posIn.getX() + 0.5D;
							d1 = (double) posIn.getY() + 0.3D;
							d2 = (double) posIn.getZ() + 0.72D;
							break;
						case SOUTH:
							d0 = (double) posIn.getX() + 0.5D;
							d1 = (double) posIn.getY() + 0.3D;
							d2 = (double) posIn.getZ() + 0.28D;
							break;
						case WEST:
							d0 = (double) posIn.getX() + 0.72D;
							d1 = (double) posIn.getY() + 0.3D;
							d2 = (double) posIn.getZ() + 0.5D;
							break;
					}
						
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}