package com.technologica.world.level.block;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasinFilledBlock extends AbstractCauldronBlock {
	public static final IntegerProperty LEVEL = TechnologicaBlockStateProperties.LEVEL_BASIN;
	private Fluid fluid;
	private static final VoxelShape OUTER_SHAPE = Shapes.block();
	private static final VoxelShape SHAPE = Shapes.join(OUTER_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST);

	public BasinFilledBlock(BlockBehaviour.Properties properties, Fluid fluid) {
		super(properties, CauldronInteraction.EMPTY);
		this.fluid = fluid;
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		ItemStack itemstack = player.getItemInHand(interactionHand);
		if (itemstack.getItem() == Items.BUCKET && blockState.getValue(LEVEL) > 0) {
			player.setItemInHand(interactionHand, ItemUtils.createFilledResult(itemstack, player, new ItemStack(fluid.getBucket())));
			lowerFillLevel(blockState, level, blockPos);
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
		return InteractionResult.FAIL;
	}

	public static void lowerFillLevel(BlockState blockState, Level level, BlockPos blockPos) {
		int i = blockState.getValue(LEVEL) - 1;
		BlockState blockstate = i == 0 ? TechnologicaBlocks.BASIN.get().defaultBlockState() : blockState.setValue(LEVEL, Integer.valueOf(i));
		level.setBlockAndUpdate(blockPos, blockstate);
		level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(blockstate));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public VoxelShape getInteractionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
		return OUTER_SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public boolean isFull(BlockState blockState) {
		return blockState.getValue(LEVEL) == 16;
	}

	@Override
	public void handlePrecipitation(BlockState blockState, Level level, BlockPos blockPos, Biome.Precipitation precipitation) {
	}

	@Override
	protected boolean canReceiveStalactiteDrip(Fluid fluidIn) {
		return false;
	}

	protected boolean canReceiveTreeTapDrip(Fluid fluidIn) {
		return fluidIn.equals(fluid) || fluid == null;
	}

	@Override
	protected void receiveStalactiteDrip(BlockState blockState, Level level, BlockPos blockPos, Fluid fluid) {
	}

	protected void receiveTreeTapDrip(BlockState blockState, Level level, BlockPos blockPos, Fluid fluid) {
		if (!this.isFull(blockState)) {
			BlockState blockstate = blockState.setValue(LEVEL, Integer.valueOf(blockState.getValue(LEVEL) + 1));
			level.setBlockAndUpdate(blockPos, blockstate);
			level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(blockstate));
			level.levelEvent(1047, blockPos, 0);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}
}