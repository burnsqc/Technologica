package com.technologica.block;

import com.technologica.tileentity.DisplayCaseTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class DisplayCaseBlock extends GlassBlock {

	public DisplayCaseBlock() {
		super(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid());
	}

	@Override
	public boolean hasTileEntity(BlockState stateIn) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState stateIn, IBlockReader worldIn) {
		return new DisplayCaseTileEntity();
	}

	public DisplayCaseTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (DisplayCaseTileEntity) worldIn.getTileEntity(posIn);
	}

	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		DisplayCaseTileEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (tile.getDisplayStack().isEmpty()) {
			if (!itemstack.isEmpty()) {
				tile.setDisplayStack(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, itemstack);
				playerIn.openContainer.detectAndSendChanges();
			}
		} else {
			ItemStack stack = tile.getDisplayStack();
			tile.setDisplayStack(ItemStack.EMPTY);
			worldIn.playSound(null, posIn, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			if (!playerIn.inventory.addItemStackToInventory(tile.getDisplayStack())) {
				spawnAsEntity(worldIn, posIn.up(), stack);
			} else {
				playerIn.openContainer.detectAndSendChanges();
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public void onReplaced(BlockState stateIn, World worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.matchesBlock(newStateIn.getBlock())) {
			DisplayCaseTileEntity tile = getTileEntity(worldIn, posIn);
			spawnAsEntity(worldIn, posIn.up(), tile.getDisplayStack());
			tile.setDisplayStack(ItemStack.EMPTY);
		}
	}
}
