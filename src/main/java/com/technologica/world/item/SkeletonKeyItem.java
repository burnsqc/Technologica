package com.technologica.world.item;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.level.block.AbyssPortalFrameBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;

public class SkeletonKeyItem extends Item {

	public SkeletonKeyItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		// Level world = context.getLevel();
		// if (!world.isClientSide) {
		// BlockPos pos = context.getClickedPos();
		// BlockState state = world.getBlockState(pos);
		// if (state.is(TechnologicaBlocks.MAPLE_LOG.get()) || state.is(TechnologicaBlocks.RUBBER_LOG.get())) {
		// world.setBlock(pos.relative(context.getClickedFace()), TechnologicaBlocks.TREE_TAP.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getClickedFace()), 3);
		// world.playSound((Player) null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
		// return InteractionResult.SUCCESS;
		// }
		// }
		// return InteractionResult.PASS;

		Level level = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		if (blockstate.is(TechnologicaBlocks.ABYSS_PORTAL_FRAME.get()) && !blockstate.getValue(AbyssPortalFrameBlock.HAS_KEY)) {
			if (level.isClientSide) {
				return InteractionResult.SUCCESS;
			} else {
				BlockState blockstate1 = blockstate.setValue(AbyssPortalFrameBlock.HAS_KEY, Boolean.valueOf(true));
				Block.pushEntitiesUp(blockstate, blockstate1, level, blockpos);
				level.setBlock(blockpos, blockstate1, 2);
				level.updateNeighbourForOutputSignal(blockpos, TechnologicaBlocks.ABYSS_PORTAL.get());
				context.getItemInHand().shrink(1);
				level.levelEvent(1503, blockpos, 0);
				BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = AbyssPortalFrameBlock.getOrCreatePortalShape().find(level, blockpos);
				if (blockpattern$blockpatternmatch != null) {
					BlockPos blockpos1 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(-3, 0, -3);

					for (int i = 0; i < 3; ++i) {
						for (int j = 0; j < 3; ++j) {
							level.setBlock(blockpos1.offset(i, 0, j), TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState(), 2);
						}
					}

					level.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);
				}

				return InteractionResult.CONSUME;
			}
		} else {
			return InteractionResult.PASS;
		}
	}
}