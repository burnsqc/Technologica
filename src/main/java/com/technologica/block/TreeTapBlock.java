package com.technologica.block;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Special one-off class for tree taps.
 * Created to handle voxel shape and animation.
 */
public class TreeTapBlock extends FourDirectionBlock {
	private static final Map<Direction, VoxelShape> SHAPES = Maps
			.newEnumMap(ImmutableMap.of(
					Direction.NORTH, Block.makeCuboidShape(6.0D, 6.0D, 11.0D, 10.0D, 11.0D, 16.0D),
					Direction.SOUTH, Block.makeCuboidShape(6.0D, 6.0D, 0.0D, 10.0D, 11.0D, 5.0D), 
					Direction.WEST,	Block.makeCuboidShape(11.0D, 6.0D, 6.0D, 16.0D, 11.0D, 10.0D), 
					Direction.EAST, Block.makeCuboidShape(0.0D, 6.0D, 6.0D, 5.0D, 11.0D, 10.0D)));

	public TreeTapBlock() {
		super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F).sound(SoundType.WOOD).notSolid());
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		return SHAPES.get(stateIn.get(FourDirectionBlock.NESW_FACING));
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isRemote) {
			if (worldIn.getBlockState(posIn.offset(stateIn.get(FourDirectionBlock.NESW_FACING).getOpposite())).getBlock() instanceof SapLogBlock) {
				if (worldIn.getBlockState(posIn.offset(stateIn.get(FourDirectionBlock.NESW_FACING).getOpposite())).get(SapLogBlock.AGE) == 15) {
					double d0 = 0;
					double d1 = 0;
					double d2 = 0;
					
					Direction facing = stateIn.get(FourDirectionBlock.NESW_FACING);
					
					switch (facing) {
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
					case DOWN:
						break;
					case UP:
						break;
					default:
						break;
					}
						
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}