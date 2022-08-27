package com.technologica.world.item;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends Item {

	public HammerItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!world.isClientSide) {
			BlockPos pos = context.getClickedPos();
			BlockState state = world.getBlockState(pos);
			if (state.is(TechnologicaBlocks.MAPLE_LOG.get()) || state.is(TechnologicaBlocks.RUBBER_LOG.get())) {
				world.setBlock(pos.relative(context.getClickedFace()), TechnologicaBlocks.TREE_TAP.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getClickedFace()), 3);
				world.playSound((Player) null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}