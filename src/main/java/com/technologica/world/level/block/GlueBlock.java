package com.technologica.world.level.block;

import java.util.Map;
import java.util.Random;
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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Rotation;
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

public class GlueBlock extends Block implements net.minecraftforge.common.IForgeShearable {
	public static final BooleanProperty UP = PipeBlock.UP;
	public static final BooleanProperty NORTH = PipeBlock.NORTH;
	public static final BooleanProperty EAST = PipeBlock.EAST;
	public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
	public static final BooleanProperty WEST = PipeBlock.WEST;
	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_57886_) -> {
		return p_57886_.getKey() != Direction.DOWN;
	}).collect(Util.toMap());
	protected static final float AABB_OFFSET = 1.0F;
	private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	private final Map<BlockState, VoxelShape> shapesCache;

	public GlueBlock(BlockBehaviour.Properties p_57847_) {
		super(p_57847_);
		this.registerDefaultState(this.stateDefinition.any().setValue(UP, Boolean.valueOf(false)).setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)));
		this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), GlueBlock::calculateShape)));
	}

	private static VoxelShape calculateShape(BlockState p_57906_) {
		VoxelShape voxelshape = Shapes.empty();
		if (p_57906_.getValue(UP)) {
			voxelshape = UP_AABB;
		}

		if (p_57906_.getValue(NORTH)) {
			voxelshape = Shapes.or(voxelshape, NORTH_AABB);
		}

		if (p_57906_.getValue(SOUTH)) {
			voxelshape = Shapes.or(voxelshape, SOUTH_AABB);
		}

		if (p_57906_.getValue(EAST)) {
			voxelshape = Shapes.or(voxelshape, EAST_AABB);
		}

		if (p_57906_.getValue(WEST)) {
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
		return this.hasFaces(this.getUpdatedState(p_57861_, p_57862_, p_57863_));
	}

	private boolean hasFaces(BlockState p_57908_) {
		return this.countFaces(p_57908_) > 0;
	}

	private int countFaces(BlockState p_57910_) {
		int i = 0;

		for (BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
			if (p_57910_.getValue(booleanproperty)) {
				++i;
			}
		}

		return i;
	}

	private boolean canSupportAtFace(BlockGetter p_57888_, BlockPos p_57889_, Direction p_57890_) {
		if (p_57890_ == Direction.DOWN) {
			return false;
		} else {
			BlockPos blockpos = p_57889_.relative(p_57890_);
			if (isAcceptableNeighbour(p_57888_, blockpos, p_57890_)) {
				return true;
			} else if (p_57890_.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				BooleanProperty booleanproperty = PROPERTY_BY_DIRECTION.get(p_57890_);
				BlockState blockstate = p_57888_.getBlockState(p_57889_.above());
				return blockstate.is(this) && blockstate.getValue(booleanproperty);
			}
		}
	}

	public static boolean isAcceptableNeighbour(BlockGetter p_57854_, BlockPos p_57855_, Direction p_57856_) {
		BlockState blockstate = p_57854_.getBlockState(p_57855_);
		return Block.isFaceFull(blockstate.getCollisionShape(p_57854_, p_57855_), p_57856_.getOpposite());
	}

	private BlockState getUpdatedState(BlockState p_57902_, BlockGetter p_57903_, BlockPos p_57904_) {
		BlockPos blockpos = p_57904_.above();
		if (p_57902_.getValue(UP)) {
			p_57902_ = p_57902_.setValue(UP, Boolean.valueOf(isAcceptableNeighbour(p_57903_, blockpos, Direction.DOWN)));
		}

		BlockState blockstate = null;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BooleanProperty booleanproperty = getPropertyForFace(direction);
			if (p_57902_.getValue(booleanproperty)) {
				boolean flag = this.canSupportAtFace(p_57903_, p_57904_, direction);
				if (!flag) {
					if (blockstate == null) {
						blockstate = p_57903_.getBlockState(blockpos);
					}

					flag = blockstate.is(this) && blockstate.getValue(booleanproperty);
				}

				p_57902_ = p_57902_.setValue(booleanproperty, Boolean.valueOf(flag));
			}
		}

		return p_57902_;
	}

	@Override
	public BlockState updateShape(BlockState p_57875_, Direction p_57876_, BlockState p_57877_, LevelAccessor p_57878_, BlockPos p_57879_, BlockPos p_57880_) {
		if (p_57876_ == Direction.DOWN) {
			return super.updateShape(p_57875_, p_57876_, p_57877_, p_57878_, p_57879_, p_57880_);
		} else {
			BlockState blockstate = this.getUpdatedState(p_57875_, p_57878_, p_57879_);
			return !this.hasFaces(blockstate) ? Blocks.AIR.defaultBlockState() : blockstate;
		}
	}

	private BlockState copyRandomFaces(BlockState p_57871_, BlockState p_57872_, Random p_57873_) {
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			if (p_57873_.nextBoolean()) {
				BooleanProperty booleanproperty = getPropertyForFace(direction);
				if (p_57871_.getValue(booleanproperty)) {
					p_57872_ = p_57872_.setValue(booleanproperty, Boolean.valueOf(true));
				}
			}
		}

		return p_57872_;
	}

	private boolean hasHorizontalConnection(BlockState p_57912_) {
		return p_57912_.getValue(NORTH) || p_57912_.getValue(EAST) || p_57912_.getValue(SOUTH) || p_57912_.getValue(WEST);
	}

	private boolean canSpread(BlockGetter p_57851_, BlockPos p_57852_) {
		Iterable<BlockPos> iterable = BlockPos.betweenClosed(p_57852_.getX() - 4, p_57852_.getY() - 1, p_57852_.getZ() - 4, p_57852_.getX() + 4, p_57852_.getY() + 1, p_57852_.getZ() + 4);
		int j = 5;

		for (BlockPos blockpos : iterable) {
			if (p_57851_.getBlockState(blockpos).is(this)) {
				--j;
				if (j <= 0) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean canBeReplaced(BlockState p_57858_, BlockPlaceContext p_57859_) {
		return false;
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_57849_) {
		BlockState blockstate = p_57849_.getLevel().getBlockState(p_57849_.getClickedPos());
		boolean flag = blockstate.is(this);
		BlockState blockstate1 = flag ? blockstate : this.defaultBlockState();

		for (Direction direction : p_57849_.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				BooleanProperty booleanproperty = getPropertyForFace(direction);
				boolean flag1 = flag && blockstate.getValue(booleanproperty);
				if (!flag1 && this.canSupportAtFace(p_57849_.getLevel(), p_57849_.getClickedPos(), direction)) {
					return blockstate1.setValue(booleanproperty, Boolean.valueOf(true));
				}
			}
		}

		return flag ? blockstate1 : null;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57882_) {
		p_57882_.add(UP, NORTH, EAST, SOUTH, WEST);
	}

	@Override
	public BlockState rotate(BlockState p_57868_, Rotation p_57869_) {
		switch (p_57869_) {
		case CLOCKWISE_180:
			return p_57868_.setValue(NORTH, p_57868_.getValue(SOUTH)).setValue(EAST, p_57868_.getValue(WEST)).setValue(SOUTH, p_57868_.getValue(NORTH)).setValue(WEST, p_57868_.getValue(EAST));
		case COUNTERCLOCKWISE_90:
			return p_57868_.setValue(NORTH, p_57868_.getValue(EAST)).setValue(EAST, p_57868_.getValue(SOUTH)).setValue(SOUTH, p_57868_.getValue(WEST)).setValue(WEST, p_57868_.getValue(NORTH));
		case CLOCKWISE_90:
			return p_57868_.setValue(NORTH, p_57868_.getValue(WEST)).setValue(EAST, p_57868_.getValue(NORTH)).setValue(SOUTH, p_57868_.getValue(EAST)).setValue(WEST, p_57868_.getValue(SOUTH));
		default:
			return p_57868_;
		}
	}

	@Override
	public BlockState mirror(BlockState p_57865_, Mirror p_57866_) {
		switch (p_57866_) {
		case LEFT_RIGHT:
			return p_57865_.setValue(NORTH, p_57865_.getValue(SOUTH)).setValue(SOUTH, p_57865_.getValue(NORTH));
		case FRONT_BACK:
			return p_57865_.setValue(EAST, p_57865_.getValue(WEST)).setValue(WEST, p_57865_.getValue(EAST));
		default:
			return super.mirror(p_57865_, p_57866_);
		}
	}

	public static BooleanProperty getPropertyForFace(Direction p_57884_) {
		return PROPERTY_BY_DIRECTION.get(p_57884_);
	}

	@Override
	public void entityInside(BlockState p_58180_, Level p_58181_, BlockPos p_58182_, Entity p_58183_) {
		p_58183_.makeStuckInBlock(p_58180_, new Vec3(0.25D, 0.05F, 0.25D));
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		if (itemstack.getItem() instanceof BlockItem) {
			Block block = ((BlockItem) itemstack.getItem()).getBlock();
			this.setBlockStateGlued(posIn, block.defaultBlockState(), false, worldIn);
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

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
