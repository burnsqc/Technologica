package com.technologica.item;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.tileentity.MulchTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MulchItem extends Item {

	public MulchItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		if (!world.isRemote) {
			BlockPos pos = context.getPos();
			BlockState state = world.getBlockState(pos);
			
			if (state.matchesBlock(Blocks.GRASS_BLOCK) || state.matchesBlock(Blocks.DIRT) || state.matchesBlock(Blocks.COARSE_DIRT) || state.matchesBlock(Blocks.PODZOL)) {
				
				world.setBlockState(pos, TechnologicaBlocks.MULCH.get().getDefaultState(), 3);
				MulchTileEntity mulchTileEntity = (MulchTileEntity) world.getTileEntity(pos);
				mulchTileEntity.setPreviousBlockState(state);
   				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
   				if (!context.getPlayer().abilities.isCreativeMode) {
   					context.getItem().shrink(1);
   				}
   				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}