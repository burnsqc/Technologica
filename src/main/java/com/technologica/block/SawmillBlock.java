package com.technologica.block;

import java.util.Random;

import com.technologica.tileentity.SawmillTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SawmillBlock extends HorizontalBlock {

	protected SawmillBlock(Properties builder) {
		super(builder);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new SawmillTileEntity();
	}

	public SawmillTileEntity getTileEntity(World world, BlockPos pos) {
		return (SawmillTileEntity) world.getTileEntity(pos);
	}
	
	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		SawmillTileEntity tile = getTileEntity(worldIn, pos);
		ItemStack itemstack = player.getHeldItem(handIn);
		
		if (tile.getLog().isEmpty() && worldIn.isRemote()) {
			if (ItemTags.LOGS.contains(itemstack.getItem())) {
				tile.setLog(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
				itemstack.shrink(1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack);
				player.openContainer.detectAndSendChanges();
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	public void animateTick(BlockState stateIn, World worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isRemote && getTileEntity(worldIn, posIn).isSawing()) {
			double d0 = (double) posIn.getX() + randomIn.nextDouble();
	        double d1 = (double) posIn.getY() + 2.0D;
	        double d2 = (double) posIn.getZ() + randomIn.nextDouble();
	        worldIn.addParticle(ParticleTypes.POOF, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	        worldIn.addParticle(new BlockParticleData(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
}