package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AbyssPortalBlockEntity extends BlockEntity {
	protected AbyssPortalBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
		super(blockEntityType, blockPos, blockState);
	}

	public AbyssPortalBlockEntity(BlockPos blockPos, BlockState blockState) {
		this(TechnologicaBlockEntityTypes.ABYSS_PORTAL.get(), blockPos, blockState);
	}

	public boolean shouldRenderFace(Direction direction) {
		return direction.getAxis() == Direction.Axis.Y;
	}
}
