package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.DisplayCaseBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Special one-off class for the display case.
 * Created to handle player interaction and associated tile entity.
 */
public class DisplayCaseBlock extends GlassBlock implements EntityBlock {

	public DisplayCaseBlock() {
		super(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion());
	}

	/*
	 * Technologica Methods
	 */

	public DisplayCaseBlockEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (DisplayCaseBlockEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void onRemove(BlockState stateIn, Level worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.is(newStateIn.getBlock())) {
			DisplayCaseBlockEntity tile = getTileEntity(worldIn, posIn);
			popResource(worldIn, posIn.above(), tile.getDisplayStack());
			tile.setDisplayStack(ItemStack.EMPTY);
		}
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		DisplayCaseBlockEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		if (tile.getDisplayStack().isEmpty()) {
			if (!itemstack.isEmpty()) {
				tile.setDisplayStack(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((Player) null, posIn, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.getInventory().setItem(playerIn.getInventory().selected, itemstack);
				playerIn.containerMenu.broadcastChanges();
			}
		} else {
			ItemStack stack = tile.getDisplayStack();
			tile.setDisplayStack(ItemStack.EMPTY);
			worldIn.playSound(null, posIn, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			if (!playerIn.getInventory().add(tile.getDisplayStack())) {
				popResource(worldIn, posIn.above(), stack);
			} else {
				playerIn.containerMenu.broadcastChanges();
			}
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153277_, BlockState p_153278_) {
		return new DisplayCaseBlockEntity(p_153277_, p_153278_);
	}
}
