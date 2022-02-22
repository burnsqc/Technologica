package com.technologica.block;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.technologica.particles.DrippingLiquidParticleData;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
	private int cooldown;
	private static final Map<Direction, VoxelShape> SHAPES = Maps
			.newEnumMap(ImmutableMap.of(
					Direction.NORTH, Block.box(6.0D, 6.0D, 11.0D, 10.0D, 11.0D, 16.0D),
					Direction.SOUTH, Block.box(6.0D, 6.0D, 0.0D, 10.0D, 11.0D, 5.0D), 
					Direction.WEST,	Block.box(11.0D, 6.0D, 6.0D, 16.0D, 11.0D, 10.0D), 
					Direction.EAST, Block.box(0.0D, 6.0D, 6.0D, 5.0D, 11.0D, 10.0D)));

	public TreeTapBlock() {
		super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.WOOD).noOcclusion());
		cooldown = 0;
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		return SHAPES.get(stateIn.getValue(FourDirectionBlock.NESW_FACING));
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isClientSide) {
			if (worldIn.getBlockState(posIn.relative(stateIn.getValue(FourDirectionBlock.NESW_FACING).getOpposite())).getBlock() instanceof SapLogBlock) {
				 
				double d0 = 0;
				double d1 = 0;
				double d2 = 0;
				
				Direction facing = stateIn.getValue(FourDirectionBlock.NESW_FACING);
				BlockState logState = worldIn.getBlockState(posIn.relative(facing.getOpposite()));
				
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
					default:
						break;
				}
				
				if (logState.getValue(SapLogBlock.AGE) > 0 & cooldown == 0) {
					if (logState.getBlock().getRegistryName().getPath().contains("maple")) {
						worldIn.addParticle(DrippingLiquidParticleData.MAPLE_SYRUP, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					} else {
						worldIn.addParticle(DrippingLiquidParticleData.RUBBER_RESIN, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					}
					worldIn.setBlock(posIn.relative(stateIn.getValue(FourDirectionBlock.NESW_FACING).getOpposite()), logState.setValue(SapLogBlock.AGE, logState.getValue(SapLogBlock.AGE) - 1), 7);
					cooldown = 100;
				} else if (cooldown > 0) {
					cooldown--;
				}
			}
		}
	}
}