package com.technologica.item;

import com.technologica.block.TechnologicaBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends Item {

	public HammerItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
   		World world = context.getWorld();
   		if (!world.isRemote) {
   			BlockPos pos = context.getPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.matchesBlock(TechnologicaBlocks.MAPLE_LOG.get()) || state.matchesBlock(TechnologicaBlocks.RUBBER_LOG.get())) {
   				world.setBlockState(pos.offset(context.getFace()), TechnologicaBlocks.TREE_TAP.get().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, context.getFace()), 3);
   				world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
   				return ActionResultType.SUCCESS;
   			}
   		}
   		return ActionResultType.PASS;  
   	}
}