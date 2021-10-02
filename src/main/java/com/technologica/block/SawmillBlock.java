package com.technologica.block;

import java.util.Random;

import com.technologica.item.TechnologicaItems;
import com.technologica.tileentity.SawmillTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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

/**
 * Special one-off class for the sawmill.
 * Created to handle player interaction and associated tile entity.
 */
public class SawmillBlock extends FourDirectionBlock {

	protected SawmillBlock() {
		super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F).sound(SoundType.ANVIL).notSolid());
	}
	
	/*
	 * Technologica Methods
	 */
	
	public SawmillTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (SawmillTileEntity) worldIn.getTileEntity(posIn);
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		SawmillTileEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		Item item = playerIn.getHeldItem(handIn).getItem();
		
		if (tile.getLog().isEmpty()) {
			if (ItemTags.LOGS.contains(itemstack.getItem())) {
				tile.setLog(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, itemstack);
				playerIn.openContainer.detectAndSendChanges();
			}
		} else if (item == TechnologicaItems.SAWBLADE.get()) {
			tile.setBlade(true);
			worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			itemstack.shrink(1);
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isRemote && getTileEntity(worldIn, posIn).isSawing()) {
			double d0 = (double) posIn.getX() + randomIn.nextDouble();
	        double d1 = (double) posIn.getY() + 2.0D;
	        double d2 = (double) posIn.getZ() + randomIn.nextDouble();
	        worldIn.addParticle(ParticleTypes.POOF, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	        worldIn.addParticle(new BlockParticleData(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
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
		return new SawmillTileEntity();
	}
}