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
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new DisplayCaseTileEntity();
	}

	public DisplayCaseTileEntity getTileEntity(World world, BlockPos pos) {
		return (DisplayCaseTileEntity) world.getTileEntity(pos);
	}

	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		DisplayCaseTileEntity tile = getTileEntity(worldIn, pos);
		ItemStack itemstack = player.getHeldItem(handIn);
		if (tile.getDisplayStack().isEmpty()) {
			if (!itemstack.isEmpty()) {
				tile.setDisplayStack(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
				itemstack.shrink(1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack);
				player.openContainer.detectAndSendChanges();
			}
		} else {
			ItemStack stack = tile.getDisplayStack();
			tile.setDisplayStack(ItemStack.EMPTY);
			worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			if (!player.inventory.addItemStackToInventory(stack)) {
				spawnAsEntity(worldIn, pos.up(), stack);
			} else {
				player.openContainer.detectAndSendChanges();
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
}
