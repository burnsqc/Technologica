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

/**
 * Special one-off class for the display case.    
 * Created to handle player interaction and associated tile entity.
 */
public class DisplayCaseBlock extends GlassBlock {

	public DisplayCaseBlock() {
		super(AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion());
	}

	/*
	 * Technologica Methods
	 */
	
	public DisplayCaseTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (DisplayCaseTileEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void onRemove(BlockState stateIn, World worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.is(newStateIn.getBlock())) {
			DisplayCaseTileEntity tile = getTileEntity(worldIn, posIn);
			popResource(worldIn, posIn.above(), tile.getDisplayStack());
			tile.setDisplayStack(ItemStack.EMPTY);
		}
	}
	
	@Override
	public ActionResultType use(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		DisplayCaseTileEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		if (tile.getDisplayStack().isEmpty()) {
			if (!itemstack.isEmpty()) {
				tile.setDisplayStack(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((PlayerEntity) null, posIn, SoundEvents.ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.inventory.setItem(playerIn.inventory.selected, itemstack);
				playerIn.containerMenu.broadcastChanges();
			}
		} else {
			ItemStack stack = tile.getDisplayStack();
			tile.setDisplayStack(ItemStack.EMPTY);
			worldIn.playSound(null, posIn, SoundEvents.ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			if (!playerIn.inventory.add(tile.getDisplayStack())) {
				popResource(worldIn, posIn.above(), stack);
			} else {
				playerIn.containerMenu.broadcastChanges();
			}
		}
		return ActionResultType.sidedSuccess(worldIn.isClientSide);
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
		return new DisplayCaseTileEntity();
	}
}
