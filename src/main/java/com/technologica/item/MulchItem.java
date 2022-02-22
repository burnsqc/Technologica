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
	public ActionResultType useOn(ItemUseContext context) {
		World world = context.getLevel();
		if (!world.isClientSide) {
			BlockPos pos = context.getClickedPos();
			BlockState state = world.getBlockState(pos);
			
			if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.PODZOL)) {
				
				world.setBlock(pos, TechnologicaBlocks.MULCH.get().defaultBlockState(), 3);
				MulchTileEntity mulchTileEntity = (MulchTileEntity) world.getBlockEntity(pos);
				mulchTileEntity.setPreviousBlockState(state);
   				world.playSound((PlayerEntity)null, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
   				if (!context.getPlayer().abilities.instabuild) {
   					context.getItemInHand().shrink(1);
   				}
   				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}