package com.technologica.world.level.block;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.util.Radius;
import com.technologica.world.level.block.entity.LineShaftBlockEntity;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Special one-off class for the line shaft. Created to add the radius property as well as handle player interaction, valid position checks, and associated tile entity.
 */
public class LineShaftBlock extends RotatedPillarBlock implements EntityBlock {
	public static final EnumProperty<Radius> RADIUS = TechnologicaBlockStateProperties.RADIUS;
	private static final VoxelShape SHAPE_X = Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
	private static final VoxelShape SHAPE_X_SMALL = Block.box(6.0D, 4.0D, 4.0D, 10.0D, 12.0D, 12.0D);
	private static final VoxelShape SHAPE_X_MEDIUM = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	private static final VoxelShape SHAPE_X_LARGE = Block.box(6.0D, -8.0D, -8.0D, 10.0D, 24.0D, 24.0D);

	private static final VoxelShape SHAPE_Y = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
	private static final VoxelShape SHAPE_Y_SMALL = Block.box(4.0D, 6.0D, 4.0D, 12.0D, 10.0D, 12.0D);
	private static final VoxelShape SHAPE_Y_MEDIUM = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D);
	private static final VoxelShape SHAPE_Y_LARGE = Block.box(-8.0D, 6.0D, -8.0D, 24.0D, 10.0D, 24.0D);

	private static final VoxelShape SHAPE_Z = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D);
	private static final VoxelShape SHAPE_Z_SMALL = Block.box(4.0D, 4.0D, 6.0D, 12.0D, 12.0D, 10.0D);
	private static final VoxelShape SHAPE_Z_MEDIUM = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	private static final VoxelShape SHAPE_Z_LARGE = Block.box(-8.0D, -8.0D, 6.0D, 24.0D, 24.0D, 10.0D);

	public LineShaftBlock() {
		super(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(RADIUS, Radius.NONE));
	}

	/*
	 * Technologica Methods
	 */

	public LineShaftBlockEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (LineShaftBlockEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		if (stateIn.getValue(AXIS) == Direction.Axis.X) {
			VoxelShape voxelShape;
			if (stateIn.getValue(RADIUS) == Radius.SMALL) {
				voxelShape = Shapes.or(SHAPE_X, SHAPE_X_SMALL);
			} else if (stateIn.getValue(RADIUS) == Radius.MEDIUM) {
				voxelShape = Shapes.or(SHAPE_X, SHAPE_X_MEDIUM);
			} else if (stateIn.getValue(RADIUS) == Radius.LARGE) {
				voxelShape = Shapes.or(SHAPE_X, SHAPE_X_LARGE);
			} else {
				voxelShape = SHAPE_X;
			}
			return voxelShape;
		} else if (stateIn.getValue(AXIS) == Direction.Axis.Y) {
			VoxelShape voxelShape;
			if (stateIn.getValue(RADIUS) == Radius.SMALL) {
				voxelShape = Shapes.or(SHAPE_Y, SHAPE_Y_SMALL);
			} else if (stateIn.getValue(RADIUS) == Radius.MEDIUM) {
				voxelShape = Shapes.or(SHAPE_Y, SHAPE_Y_MEDIUM);
			} else if (stateIn.getValue(RADIUS) == Radius.LARGE) {
				voxelShape = Shapes.or(SHAPE_Y, SHAPE_Y_LARGE);
			} else {
				voxelShape = SHAPE_Y;
			}
			return voxelShape;
		} else {
			VoxelShape voxelShape;
			if (stateIn.getValue(RADIUS) == Radius.SMALL) {
				voxelShape = Shapes.or(SHAPE_Z, SHAPE_Z_SMALL);
			} else if (stateIn.getValue(RADIUS) == Radius.MEDIUM) {
				voxelShape = Shapes.or(SHAPE_Z, SHAPE_Z_MEDIUM);
			} else if (stateIn.getValue(RADIUS) == Radius.LARGE) {
				voxelShape = Shapes.or(SHAPE_Z, SHAPE_Z_LARGE);
			} else {
				voxelShape = SHAPE_Z;
			}
			return voxelShape;
		}
	}

	@Override
	@Deprecated
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, LevelAccessor worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		if (!stateIn.canSurvive(worldIn, currentPosIn)) {
			worldIn.scheduleTick(currentPosIn, this, 1);
		}
		return super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		LineShaftBlockEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getItemInHand(handIn).getItem();

		if (tool == TechnologicaItems.PIPE_WRENCH.get()) {
			worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.NONE), 1);
			worldIn.playSound((Player) null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);

		} else if (tile.getBlockState().getValue(RADIUS).getRadius() == 0) {
			if (tool == TechnologicaItems.SMALL_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.SMALL), 1);
				worldIn.playSound((Player) null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.MEDIUM_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.MEDIUM), 1);
				worldIn.playSound((Player) null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.LARGE_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.LARGE), 1);
				worldIn.playSound((Player) null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			}
		}

		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	@Override
	public RenderShape getRenderShape(BlockState stateIn) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		boolean bool = false;
		switch (stateIn.getValue(AXIS)) {
		case X:
			bool = worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.east()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.west()).getBlock() instanceof MotorBlock);
			break;
		case Y:
			bool = worldIn.getBlockState(posIn.above()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.below()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.above()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.below()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.above()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.below()).getBlock() instanceof MotorBlock);
			break;
		case Z:
			bool = worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.north()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.south()).getBlock() instanceof MotorBlock);
			break;
		}
		return bool;
	}

	@Override
	public void tick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		if (!canSurvive(stateIn, worldIn, posIn)) {
			LineShaftBlockEntity tile = getTileEntity(worldIn, posIn);
			if (tile.getBeltPos() != null) {
				LineShaftBlockEntity tile2 = getTileEntity(worldIn, tile.getBeltPos());
				if (tile2 != null) {
					tile2.setBeltPos(null);
				}
				tile.setBeltPos(null);
			}
			worldIn.destroyBlock(posIn, true);
		}
	}

	@Override
	public void playerWillDestroy(Level worldIn, BlockPos posIn, BlockState stateIn, Player playerIn) {
		LineShaftBlockEntity tile = getTileEntity(worldIn, posIn);
		if (tile.getBeltPos() != null) {
			LineShaftBlockEntity tile2 = getTileEntity(worldIn, tile.getBeltPos());
			if (tile2 != null) {
				tile2.setBeltPos(null);
			}
			tile.setBeltPos(null);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(RADIUS);
		super.createBlockStateDefinition(builderIn);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new LineShaftBlockEntity(p_153215_, p_153216_);
	}
}
