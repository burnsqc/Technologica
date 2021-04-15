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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class DisplayCaseBlock extends GlassBlock {

	public DisplayCaseBlock() {
		super(AbstractBlock.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid());
	}

	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new DisplayCaseTileEntity();
	}

	public DisplayCaseTileEntity getTileEntity(World world, BlockPos pos) {
		return (DisplayCaseTileEntity) world.getTileEntity(pos);
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		DisplayCaseTileEntity tile = getTileEntity(worldIn, pos);
		if (tile.getDisplayStack().isEmpty()) {
			if (!player.getHeldItem(handIn).isEmpty()) {
				tile.setDisplayStack(player.getHeldItem(handIn));
				player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
				player.openContainer.detectAndSendChanges();
			}
		} else {
			ItemStack stack = tile.getDisplayStack();
			tile.clear();
			if (!player.inventory.addItemStackToInventory(stack)) {
				spawnAsEntity(worldIn, pos.up(), stack);
			} else {
				player.openContainer.detectAndSendChanges();
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
}