package com.technologica.world.level.block;

import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class GourdCropBlock extends StemGrownBlock {
	public static final DirectionProperty NESW_FACING = BlockStateProperties.HORIZONTAL_FACING;
	private int index;

	public GourdCropBlock(BlockBehaviour.Properties propertiesIn, int indexIn) {
		super(propertiesIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(NESW_FACING, Direction.NORTH));
		index = indexIn;
	}

	@Override
	public StemBlock getStem() {
		if (index == 0) {
			return (StemBlock) TechnologicaBlocks.CUCUMBER_STEM.get();
		} else if (index == 1) {
			return (StemBlock) TechnologicaBlocks.SQUASH_STEM.get();
		} else {
			return (StemBlock) TechnologicaBlocks.ZUCCHINI_STEM.get();
		}
	}

	@Override
	public AttachedStemBlock getAttachedStem() {
		if (index == 0) {
			return (AttachedStemBlock) TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get();
		} else if (index == 1) {
			return (AttachedStemBlock) TechnologicaBlocks.ATTACHED_SQUASH_STEM.get();
		} else {
			return (AttachedStemBlock) TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get();
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(NESW_FACING);
		super.createBlockStateDefinition(builderIn);
	}
}
