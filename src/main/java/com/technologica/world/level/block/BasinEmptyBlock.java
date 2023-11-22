package com.technologica.world.level.block;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaFluids;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasinEmptyBlock extends AbstractCauldronBlock {
	public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_COMPOSTER;
	private static final VoxelShape OUTER_SHAPE = Shapes.block();
	private static final VoxelShape[] SHAPES = Util.make(new VoxelShape[9], (p_51967_) -> {
		for (int i = 0; i < 8; ++i) {
			p_51967_[i] = Shapes.join(OUTER_SHAPE, Block.box(2.0D, Math.max(2, 1 + i * 2), 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST);
		}

		p_51967_[8] = p_51967_[7];
	});

	public BasinEmptyBlock(BlockBehaviour.Properties p_51403_) {
		super(p_51403_, CauldronInteraction.EMPTY);
	}

	@Override
	public VoxelShape getShape(BlockState p_151964_, BlockGetter p_151965_, BlockPos p_151966_, CollisionContext p_151967_) {
		return SHAPES[p_151964_.getValue(LEVEL)];
	}

	@Override
	public VoxelShape getInteractionShape(BlockState p_151955_, BlockGetter p_151956_, BlockPos p_151957_) {
		return OUTER_SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState p_51990_, BlockGetter p_51991_, BlockPos p_51992_, CollisionContext p_51993_) {
		return SHAPES[0];
	}

	@Override
	public boolean isFull(BlockState p_152947_) {
		return false;
	}

	@Override
	public void handlePrecipitation(BlockState p_152935_, Level p_152936_, BlockPos p_152937_, Biome.Precipitation p_152938_) {
	}

	@Override
	protected boolean canReceiveStalactiteDrip(Fluid fluidIn) {
		return false;
	}

	protected boolean canReceiveTreeTapDrip(Fluid fluidIn) {
		return true;
	}

	@Override
	protected void receiveStalactiteDrip(BlockState p_152940_, Level p_152941_, BlockPos p_152942_, Fluid p_152943_) {
	}

	protected void receiveTreeTapDrip(BlockState blockStateIn, Level levelIn, BlockPos blockPosIn, Fluid fluidIn) {
		if (fluidIn == TechnologicaFluids.MAPLE_SYRUP.get()) {
			BlockState blockstate = TechnologicaBlocks.MAPLE_SYRUP_BASIN.get().defaultBlockState();
			levelIn.setBlockAndUpdate(blockPosIn, blockstate);
			levelIn.gameEvent(GameEvent.BLOCK_CHANGE, blockPosIn, GameEvent.Context.of(blockstate));
			levelIn.levelEvent(1047, blockPosIn, 0);
		} else if (fluidIn == TechnologicaFluids.RUBBER_RESIN.get()) {
			BlockState blockstate = TechnologicaBlocks.RUBBER_RESIN_BASIN.get().defaultBlockState();
			levelIn.setBlockAndUpdate(blockPosIn, blockstate);
			levelIn.gameEvent(GameEvent.BLOCK_CHANGE, blockPosIn, GameEvent.Context.of(blockstate));
			levelIn.levelEvent(1047, blockPosIn, 0);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153549_) {
		p_153549_.add(LEVEL);
	}
}