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

	public BasinFilledBlock(BlockBehaviour.Properties p_51403_, Fluid fluidIn) {
		super(p_51403_, CauldronInteraction.EMPTY);
		this.fluid = fluidIn;
	}

	@Override
	public InteractionResult use(BlockState p_151969_, Level p_151970_, BlockPos p_151971_, Player p_151972_, InteractionHand p_151973_, BlockHitResult p_151974_) {
		ItemStack itemstack = p_151972_.getItemInHand(p_151973_);
		if (itemstack.getItem() == Items.BUCKET && p_151969_.getValue(LEVEL) > 0) {
			p_151972_.setItemInHand(p_151973_, ItemUtils.createFilledResult(itemstack, p_151972_, new ItemStack(fluid.getBucket())));
			lowerFillLevel(p_151969_, p_151970_, p_151971_);
			return InteractionResult.sidedSuccess(p_151970_.isClientSide);
		}
		return InteractionResult.FAIL;
	}

	public static void lowerFillLevel(BlockState p_153560_, Level p_153561_, BlockPos p_153562_) {
		int i = p_153560_.getValue(LEVEL) - 1;
		BlockState blockstate = i == 0 ? TechnologicaBlocks.BASIN.get().defaultBlockState() : p_153560_.setValue(LEVEL, Integer.valueOf(i));
		p_153561_.setBlockAndUpdate(p_153562_, blockstate);
		p_153561_.gameEvent(GameEvent.BLOCK_CHANGE, p_153562_, GameEvent.Context.of(blockstate));
	}

	@Override
	public VoxelShape getShape(BlockState p_151964_, BlockGetter p_151965_, BlockPos p_151966_, CollisionContext p_151967_) {
		return SHAPE;
	}

	@Override
	public VoxelShape getInteractionShape(BlockState p_151955_, BlockGetter p_151956_, BlockPos p_151957_) {
		return OUTER_SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState p_51990_, BlockGetter p_51991_, BlockPos p_51992_, CollisionContext p_51993_) {
		return SHAPE;
	}

	@Override
	public boolean isFull(BlockState p_152947_) {
		return p_152947_.getValue(LEVEL) == 16;
	}

	@Override
	public void handlePrecipitation(BlockState p_152935_, Level p_152936_, BlockPos p_152937_, Biome.Precipitation p_152938_) {
	}

	@Override
	protected boolean canReceiveStalactiteDrip(Fluid fluidIn) {
		return false;
	}

	protected boolean canReceiveTreeTapDrip(Fluid fluidIn) {
		return fluidIn.equals(fluid) || fluid == null;
	}

	@Override
	protected void receiveStalactiteDrip(BlockState p_152940_, Level p_152941_, BlockPos p_152942_, Fluid p_152943_) {
	}

	protected void receiveTreeTapDrip(BlockState p_152940_, Level p_152941_, BlockPos p_152942_, Fluid p_152943_) {
		if (!this.isFull(p_152940_)) {
			BlockState blockstate = p_152940_.setValue(LEVEL, Integer.valueOf(p_152940_.getValue(LEVEL) + 1));
			p_152941_.setBlockAndUpdate(p_152942_, blockstate);
			p_152941_.gameEvent(GameEvent.BLOCK_CHANGE, p_152942_, GameEvent.Context.of(blockstate));
			p_152941_.levelEvent(1047, p_152942_, 0);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153549_) {
		p_153549_.add(LEVEL);
	}
}