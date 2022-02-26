package com.technologica.world.level.block;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.technologica.particles.DrippingLiquidParticleData;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

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
		super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.WOOD).noOcclusion());
		cooldown = 0;
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		return SHAPES.get(stateIn.getValue(FourDirectionBlock.NESW_FACING));
	}

	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos posIn, Random randomIn) {
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