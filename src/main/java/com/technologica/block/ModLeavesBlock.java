package com.technologica.block;

import java.util.Random;

import com.technologica.tileentity.FruitTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ModLeavesBlock extends LeavesBlock {
	private int fruitType;

	public ModLeavesBlock(int fruit) {
		super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid());
		fruitType = fruit;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new FruitTileEntity();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof FruitTileEntity) {
		}
	}

	public boolean ticksRandomly(BlockState state) {
		return !state.get(PERSISTENT);
	}

	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!state.get(PERSISTENT)) {
			if (state.get(DISTANCE) == 7) {
				spawnDrops(state, worldIn, pos);
				worldIn.removeBlock(pos, false);
			} else {
				if (worldIn.isAirBlock(pos.down())) {
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
						if (random.nextInt(2) == 0) {
							if (fruitType == 1) {
								if (state.get(DISTANCE) <= 1) {
									System.out.println("ATTEMPTING TO ADD ENTITY");
									worldIn.addEntity(new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn));
								}
							} else if (fruitType == 2) {
//								worldIn.setBlockState(pos.down(), Registration.CHERRY_CROP.get().getDefaultState());
							} else if (fruitType == 3) {
								if (state.get(DISTANCE) <= 1) {
//									worldIn.setBlockState(pos.down(),Registration.COCONUT_CROP.get().getDefaultState());
								}
							} else if (fruitType == 4) {
//								worldIn.setBlockState(pos.down(), Registration.LEMON_CROP.get().getDefaultState());
							} else if (fruitType == 5) {
//								worldIn.setBlockState(pos.down(), Registration.LIME_CROP.get().getDefaultState());
							} else if (fruitType == 6) {
//								worldIn.setBlockState(pos.down(), Registration.ORANGE_CROP.get().getDefaultState());
							} else if (fruitType == 7) {
//								worldIn.setBlockState(pos.down(), Registration.PEACH_CROP.get().getDefaultState());
							} else if (fruitType == 8) {
//								worldIn.setBlockState(pos.down(), Registration.PEAR_CROP.get().getDefaultState());
							}
						}
					}					
				}
			}
		}
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 60;
	}
}