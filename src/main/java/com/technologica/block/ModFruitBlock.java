package com.technologica.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModFruitBlock extends BushBlock {
	private int fruitType;
	
	public ModFruitBlock(int fruit) {
		super(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.FOLIAGE).hardnessAndResistance(0.0F).sound(SoundType.CROP).notSolid().doesNotBlockMovement());
		fruitType = fruit;
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		boolean isLeaves = BlockTags.LEAVES.contains(worldIn.getBlockState(pos.up()).getBlock());				
		if (isLeaves) {
			return true;
		} else {
	    	return false;
	    }
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
//		double d0 = (double) pos.getX() + 0.5D;
//		double d1 = (double) pos.getY() + 0.8D;
//		double d2 = (double) pos.getZ() + 0.5D;
				
		if (fruitType==1) {
//			worldIn.addParticle(Registration.BANANA_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==2) {
//			worldIn.addParticle(Registration.CHERRY_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==3) {
//			worldIn.addParticle(Registration.COCONUT_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==4) {
//			worldIn.addParticle(Registration.LEMON_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==5) {
//			worldIn.addParticle(Registration.LIME_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==6) {
//			worldIn.addParticle(Registration.ORANGE_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==7) {
//			worldIn.addParticle(Registration.PEACH_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		} else if (fruitType==8) {
//			worldIn.addParticle(Registration.PEAR_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}	
}