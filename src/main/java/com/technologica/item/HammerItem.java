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
	public ActionResultType useOn(ItemUseContext context) {
   		World world = context.getLevel();
   		if (!world.isClientSide) {
   			BlockPos pos = context.getClickedPos();
   			BlockState state = world.getBlockState(pos);
   			if (state.is(TechnologicaBlocks.MAPLE_LOG.get()) || state.is(TechnologicaBlocks.RUBBER_LOG.get())) {
   				world.setBlock(pos.relative(context.getClickedFace()), TechnologicaBlocks.TREE_TAP.get().defaultBlockState().setValue(HorizontalBlock.FACING, context.getClickedFace()), 3);
   				world.playSound((PlayerEntity)null, pos, SoundEvents.WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
   				return ActionResultType.SUCCESS;
   			}
   		}
   		return ActionResultType.PASS;  
   	}
}