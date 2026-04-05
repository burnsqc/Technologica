package com.technologica.world.level.portal;

import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.level.block.AbyssPortalBlock;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbyssPortalShape {
	public static final int MAX_WIDTH = 21;
	public static final int MAX_HEIGHT = 21;
	private static final BlockBehaviour.StatePredicate FRAME = (blockState, blockGetter, blockPos) -> {
		return blockState.is(Blocks.PRISMARINE);
	};
	private final LevelAccessor level;
	private final Direction.Axis axis;
	private final Direction rightDir;
	private int numPortalBlocks;
	@Nullable
	private BlockPos bottomLeft;
	private int height;
	private final int width;

	public static Optional<AbyssPortalShape> findEmptyPortalShape(LevelAccessor levelAccessor, BlockPos blockPos, Direction.Axis axis) {
		return findPortalShape(levelAccessor, blockPos, (abyssPortalShape) -> {
			return abyssPortalShape.isValid() && abyssPortalShape.numPortalBlocks == 0;
		}, axis);
	}

	public static Optional<AbyssPortalShape> findPortalShape(LevelAccessor levelAccessor, BlockPos blockPos, Predicate<AbyssPortalShape> predicate, Direction.Axis axis) {
		Optional<AbyssPortalShape> optional = Optional.of(new AbyssPortalShape(levelAccessor, blockPos, axis)).filter(predicate);
		if (optional.isPresent()) {
			return optional;
		} else {
			Direction.Axis axisOpposite = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
			return Optional.of(new AbyssPortalShape(levelAccessor, blockPos, axisOpposite)).filter(predicate);
		}
	}

	public AbyssPortalShape(LevelAccessor levelAccessor, BlockPos blockPos, Direction.Axis axis) {
		this.level = levelAccessor;
		this.axis = axis;
		this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
		this.bottomLeft = this.calculateBottomLeft(blockPos);
		if (this.bottomLeft == null) {
			this.bottomLeft = blockPos;
			this.width = 1;
			this.height = 1;
		} else {
			this.width = this.calculateWidth();
			if (this.width > 0) {
				this.height = this.calculateHeight();
			}
		}
	}

	@Nullable
	private BlockPos calculateBottomLeft(BlockPos blockPos) {
		Direction direction = this.rightDir.getOpposite();
		int j = this.getDistanceUntilEdgeAboveFrame(blockPos, direction) - 1;
		return j < 0 ? null : blockPos.relative(direction, j);
	}

	private int calculateWidth() {
		int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
		return i >= 2 && i <= 21 ? i : 0;
	}

	private int getDistanceUntilEdgeAboveFrame(BlockPos blockPos, Direction direction) {
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		for (int i = 0; i <= 21; ++i) {
			mutableBlockPos.set(blockPos).move(direction, i);
			BlockState blockState = this.level.getBlockState(mutableBlockPos);
			if (!isEmpty(blockState)) {
				if (FRAME.test(blockState, this.level, mutableBlockPos)) {
					return i;
				}
				break;
			}
			BlockState blockStateDown = this.level.getBlockState(mutableBlockPos.move(Direction.DOWN));
			if (!FRAME.test(blockStateDown, this.level, mutableBlockPos)) {
				break;
			}
		}
		return 0;
	}

	private int calculateHeight() {
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		int i = this.getDistanceUntilTop(mutableBlockPos);
		return i >= 3 && i <= 21 && this.hasTopFrame(mutableBlockPos, i) ? i : 0;
	}

	private boolean hasTopFrame(BlockPos.MutableBlockPos mutableBlockPos, int top) {
		for (int i = 0; i < this.width; ++i) {
			BlockPos.MutableBlockPos mutableBlockPos2 = mutableBlockPos.set(this.bottomLeft).move(Direction.UP, top).move(this.rightDir, i);
			if (!FRAME.test(this.level.getBlockState(mutableBlockPos2), this.level, mutableBlockPos2)) {
				return false;
			}
		}
		return true;
	}

	private int getDistanceUntilTop(BlockPos.MutableBlockPos mutableBlockPos) {
		for (int i = 0; i < 21; ++i) {
			mutableBlockPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
			if (!FRAME.test(this.level.getBlockState(mutableBlockPos), this.level, mutableBlockPos)) {
				return i;
			}

			mutableBlockPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
			if (!FRAME.test(this.level.getBlockState(mutableBlockPos), this.level, mutableBlockPos)) {
				return i;
			}

			for (int j = 0; j < this.width; ++j) {
				mutableBlockPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
				BlockState blockState = this.level.getBlockState(mutableBlockPos);
				if (!isEmpty(blockState)) {
					return i;
				}

				if (blockState.is(TechnologicaBlocks.ABYSS_PORTAL.get())) {
					++this.numPortalBlocks;
				}
			}
		}

		return 21;
	}

	private static boolean isEmpty(BlockState blockState) {
		return blockState.isAir() || blockState.getFluidState().is(FluidTags.WATER) || blockState.is(TechnologicaBlocks.ABYSS_PORTAL.get());
	}

	public boolean isValid() {
		return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
	}

	public void createPortalBlocks() {
		BlockState blockState = TechnologicaBlocks.ABYSS_PORTAL.get().defaultBlockState().setValue(AbyssPortalBlock.AXIS, this.axis);
		BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach((blockPos) -> {
			this.level.setBlock(blockPos, blockState, 18);
		});
	}

	public boolean isComplete() {
		return this.isValid() && this.numPortalBlocks == this.width * this.height;
	}

	public static Vec3 getRelativePosition(BlockUtil.FoundRectangle foundRectangle, Direction.Axis axis, Vec3 vec3, EntityDimensions entityDimension) {
		double d0 = (double) foundRectangle.axis1Size - (double) entityDimension.width;
		double d1 = (double) foundRectangle.axis2Size - (double) entityDimension.height;
		BlockPos blockpos = foundRectangle.minCorner;
		double d2;
		if (d0 > 0.0D) {
			float f = blockpos.get(axis) + entityDimension.width / 2.0F;
			d2 = Mth.clamp(Mth.inverseLerp(vec3.get(axis) - f, 0.0D, d0), 0.0D, 1.0D);
		} else {
			d2 = 0.5D;
		}
		double d4;
		if (d1 > 0.0D) {
			Direction.Axis axisY = Direction.Axis.Y;
			d4 = Mth.clamp(Mth.inverseLerp(vec3.get(axisY) - blockpos.get(axisY), 0.0D, d1), 0.0D, 1.0D);
		} else {
			d4 = 0.0D;
		}
		Direction.Axis axisOpposite = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
		double d3 = vec3.get(axisOpposite) - (blockpos.get(axisOpposite) + 0.5D);
		return new Vec3(d2, d4, d3);
	}

	public static PortalInfo createPortalInfo(ServerLevel serverLevel, BlockUtil.FoundRectangle foundRectangle, Direction.Axis axis, Vec3 relativePortalPosition, Entity entity, Vec3 entityDeltaMovement, float entityRotY, float entityRotX) {
		BlockPos blockpos = foundRectangle.minCorner;
		BlockState blockState = serverLevel.getBlockState(blockpos);
		Direction.Axis axisDirection = blockState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
		double d0 = foundRectangle.axis1Size;
		double d1 = foundRectangle.axis2Size;
		EntityDimensions entitydimensions = entity.getDimensions(entity.getPose());
		int i = axis == axisDirection ? 0 : 90;
		Vec3 vec3 = axis == axisDirection ? entityDeltaMovement : new Vec3(entityDeltaMovement.z, entityDeltaMovement.y, -entityDeltaMovement.x);
		double d2 = entitydimensions.width / 2.0D + (d0 - entitydimensions.width) * relativePortalPosition.x();
		double d3 = (d1 - entitydimensions.height) * relativePortalPosition.y();
		double d4 = 0.5D + relativePortalPosition.z();
		boolean flag = axisDirection == Direction.Axis.X;
		Vec3 vec31 = new Vec3(blockpos.getX() + (flag ? d2 : d4), blockpos.getY() + d3, blockpos.getZ() + (flag ? d4 : d2));
		Vec3 vec32 = findCollisionFreePosition(vec31, serverLevel, entity, entitydimensions);
		return new PortalInfo(vec32, vec3, entityRotY + i, entityRotX);
	}

	private static Vec3 findCollisionFreePosition(Vec3 vec31, ServerLevel serverLevel, Entity entity, EntityDimensions entityDimension) {
		if (!(entityDimension.width > 4.0F) && !(entityDimension.height > 4.0F)) {
			double d0 = entityDimension.height / 2.0D;
			Vec3 vec3 = vec31.add(0.0D, d0, 0.0D);
			VoxelShape voxelshape = Shapes.create(AABB.ofSize(vec3, entityDimension.width, 0.0D, entityDimension.width).expandTowards(0.0D, 1.0D, 0.0D).inflate(1.0E-6D));
			Optional<Vec3> optional = serverLevel.findFreePosition(entity, voxelshape, vec3, entityDimension.width, entityDimension.height, entityDimension.width);
			Optional<Vec3> optional1 = optional.map((vec32) -> {
				return vec32.subtract(0.0D, d0, 0.0D);
			});
			return optional1.orElse(vec31);
		} else {
			return vec31;
		}
	}
}
