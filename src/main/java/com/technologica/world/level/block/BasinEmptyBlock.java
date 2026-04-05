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
	private static final VoxelShape[] SHAPES = Util.make(new VoxelShape[9], (voxelShape) -> {
		for (int i = 0; i < 8; ++i) {
			voxelShape[i] = Shapes.join(OUTER_SHAPE, Block.box(2.0D, Math.max(2, 1 + i * 2), 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST);
		}

		voxelShape[8] = voxelShape[7];
	});

	public BasinEmptyBlock(BlockBehaviour.Properties properties) {
		super(properties, CauldronInteraction.EMPTY);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPES[blockState.getValue(LEVEL)];
	}

	@Override
	public VoxelShape getInteractionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
		return OUTER_SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPES[0];
	}

	@Override
	public boolean isFull(BlockState blockState) {
		return false;
	}

	@Override
	public void handlePrecipitation(BlockState blockState, Level level, BlockPos blockPos, Biome.Precipitation precipitation) {
	}

	@Override
	protected boolean canReceiveStalactiteDrip(Fluid fluidIn) {
		return false;
	}

	protected boolean canReceiveTreeTapDrip(Fluid fluidIn) {
		return true;
	}

	@Override
	protected void receiveStalactiteDrip(BlockState blockState, Level level, BlockPos blockPos, Fluid fluid) {
	}

	protected void receiveTreeTapDrip(BlockState blockState, Level levelIn, BlockPos blockPosIn, Fluid fluidIn) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}
}