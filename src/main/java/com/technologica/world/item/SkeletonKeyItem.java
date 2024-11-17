package com.technologica.world.item;

import java.util.Optional;

import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.world.level.portal.AbyssPortalShape;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SkeletonKeyItem extends Item {

	public SkeletonKeyItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		BlockState blockState = level.getBlockState(blockPos);

		if (blockState.is(Blocks.PRISMARINE)) {
			if (inPortalDimension(level)) {
				if (!level.isClientSide) {
					BlockPos portalPos = blockPos.relative(context.getClickedFace());
					Optional<AbyssPortalShape> optional = AbyssPortalShape.findEmptyPortalShape(level, portalPos, Direction.Axis.X);
					if (optional.isPresent()) {
						optional.get().createPortalBlocks();
						return InteractionResult.CONSUME;
					}
				}
			}
		}
		return InteractionResult.PASS;
	}

	private static boolean inPortalDimension(Level level) {
		return level.dimension() == Level.OVERWORLD || level.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.ABYSS_STEM);
	}
}