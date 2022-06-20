package com.technologica.world.level.block;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlueBlock extends Block {
	public static final BooleanProperty UP = PipeBlock.UP;
	public static final BooleanProperty DOWN = PipeBlock.DOWN;
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().collect(Util.toMap());
	protected static final float AABB_OFFSET = 1.0F;
	private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private final Map<BlockState, VoxelShape> shapesCache;

	public GlueBlock(BlockBehaviour.Properties p_57847_) {
		super(p_57847_);
		this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
		this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), GlueBlock::calculateShape)));
	}

	private static VoxelShape calculateShape(BlockState stateIn) {
		VoxelShape voxelshape = Shapes.empty();
		if (stateIn.getValue(UP)) {
			voxelshape = Shapes.or(voxelshape, UP_AABB);
		}

		if (stateIn.getValue(DOWN)) {
			voxelshape = Shapes.or(voxelshape, DOWN_AABB);
		}

		if (stateIn.getValue(NORTH)) {
			voxelshape = Shapes.or(voxelshape, NORTH_AABB);
		}

		if (stateIn.getValue(EAST)) {
			voxelshape = Shapes.or(voxelshape, EAST_AABB);
		}

		if (stateIn.getValue(SOUTH)) {
			voxelshape = Shapes.or(voxelshape, SOUTH_AABB);
		}

		if (stateIn.getValue(WEST)) {
			voxelshape = Shapes.or(voxelshape, WEST_AABB);
		}

		return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
	}

	@Override
	public VoxelShape getShape(BlockState p_57897_, BlockGetter p_57898_, BlockPos p_57899_, CollisionContext p_57900_) {
		return this.shapesCache.get(p_57897_);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState p_181239_, BlockGetter p_181240_, BlockPos p_181241_) {
		return true;
	}

	@Override
	public boolean canSurvive(BlockState p_57861_, LevelReader p_57862_, BlockPos p_57863_) {
		return this.hasFaces(p_57861_);
	}

	private boolean hasFaces(BlockState stateIn) {
		return this.countFaces(stateIn) > 0;
	}

	private int countFaces(BlockState stateIn) {
		int i = 0;

		for (BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
			if (stateIn.getValue(booleanproperty)) {
				++i;
			}
		}

		return i;
	}

	private boolean canSupportAtFace(BlockGetter getterIn, BlockPos posIn, Direction directionIn) {
		BlockPos blockpos = posIn.relative(directionIn);
		BlockState blockstate = getterIn.getBlockState(blockpos);
		if (Block.isFaceFull(blockstate.getCollisionShape(getterIn, blockpos), directionIn.getOpposite())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState p_57877_, LevelAccessor levelIn, BlockPos p_57879_, BlockPos p_57880_) {
		BlockState blockstate = stateIn;

		for (Direction direction : Direction.values()) {
			BooleanProperty booleanproperty = getPropertyForFace(direction);
			if (blockstate.getValue(booleanproperty)) {
				boolean flag = this.canSupportAtFace(levelIn, p_57879_, direction);
				blockstate = blockstate.setValue(booleanproperty, flag);
			}
		}

		return !this.hasFaces(blockstate) ? Blocks.AIR.defaultBlockState() : blockstate;
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_57849_) {
		BlockState blockstate = p_57849_.getLevel().getBlockState(p_57849_.getClickedPos());
		boolean flag = blockstate.is(this);
		BlockState blockstate1 = flag ? blockstate : this.defaultBlockState();

		for (Direction direction : p_57849_.getNearestLookingDirections()) {

			BooleanProperty booleanproperty = getPropertyForFace(direction);
			boolean flag1 = flag && blockstate.getValue(booleanproperty);
			if (!flag1 && this.canSupportAtFace(p_57849_.getLevel(), p_57849_.getClickedPos(), direction)) {
				return blockstate1.setValue(booleanproperty, Boolean.valueOf(true));
			}

		}

		return flag ? blockstate1 : null;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
	}

	public static BooleanProperty getPropertyForFace(Direction directionIn) {
		return PROPERTY_BY_DIRECTION.get(directionIn);
	}

	@Override
	public void entityInside(BlockState stateIn, Level levelIn, BlockPos posIn, Entity entityIn) {
		entityIn.makeStuckInBlock(stateIn, new Vec3(0.25D, 0.05F, 0.25D));
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level levelIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		if (itemstack.getItem() instanceof BlockItem) {
			Block block = ((BlockItem) itemstack.getItem()).getBlock();
			this.setBlockStateGlued(posIn, block.defaultBlockState(), false, levelIn);
		}
		return InteractionResult.sidedSuccess(levelIn.isClientSide);
	}

	@SuppressWarnings("deprecation")
	public BlockState setBlockStateGlued(BlockPos p_62865_, BlockState p_62866_, boolean p_62867_, Level worldIn) {

		LevelChunk levelchunk = worldIn.getChunkAt(p_62865_);

		int i = p_62865_.getY();
		LevelChunkSection levelchunksection = levelchunk.getSection(levelchunk.getSectionIndex(i));
		boolean flag = levelchunksection.hasOnlyAir();
		if (flag && p_62866_.isAir()) {
			return null;
		} else {
			int j = p_62865_.getX() & 15;
			int k = i & 15;
			int l = p_62865_.getZ() & 15;
			BlockState blockstate = levelchunksection.setBlockState(j, k, l, p_62866_);
			if (blockstate == p_62866_) {
				return null;
			} else {
				Block block = p_62866_.getBlock();

				boolean flag1 = levelchunksection.hasOnlyAir();
				if (flag != flag1) {
					worldIn.getChunkSource().getLightEngine().updateSectionStatus(p_62865_, flag1);
				}

				boolean flag2 = blockstate.hasBlockEntity();
				if (!worldIn.isClientSide) {
					blockstate.onRemove(worldIn, p_62865_, p_62866_, p_62867_);
				} else if ((!blockstate.is(block) || !p_62866_.hasBlockEntity()) && flag2) {
					levelchunk.removeBlockEntity(p_62865_);
				}

				if (!levelchunksection.getBlockState(j, k, l).is(block)) {
					return null;
				} else {
					if (!worldIn.isClientSide && !worldIn.captureBlockSnapshots) {
					}

					if (p_62866_.hasBlockEntity()) {
						BlockEntity blockentity = levelchunk.getBlockEntity(p_62865_, LevelChunk.EntityCreationType.CHECK);
						if (blockentity == null) {
							blockentity = ((EntityBlock) block).newBlockEntity(p_62865_, p_62866_);
							if (blockentity != null) {
								levelchunk.addAndRegisterBlockEntity(blockentity);
							}
						} else {
							blockentity.setBlockState(p_62866_);
						}
					}

					worldIn.markAndNotifyBlock(p_62865_, levelchunk, blockstate, p_62866_, 0, 0);
					return blockstate;
				}
			}
		}
	}

}
