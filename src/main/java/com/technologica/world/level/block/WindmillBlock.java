package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.WindmillBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Special one-off class for the sawmill. Created to handle player interaction and associated tile entity.
 */
public class WindmillBlock extends FourDirectionBlock implements EntityBlock {

	public WindmillBlock() {
		super(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).noOcclusion());
	}

	@Override
	public RenderShape getRenderShape(BlockState blockState) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	public WindmillBlockEntity getTileEntity(Level level, BlockPos blockPos) {
		return (WindmillBlockEntity) level.getBlockEntity(blockPos);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new WindmillBlockEntity(blockPos, blockState);
	}
}