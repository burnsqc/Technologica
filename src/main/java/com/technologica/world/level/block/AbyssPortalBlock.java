package com.technologica.world.level.block;

import com.technologica.capabilities.item.link.PortalHook;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbyssPortalBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final int AABB_OFFSET = 2;
	protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public AbyssPortalBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		switch (blockState.getValue(AXIS)) {
		case Z:
			return Z_AXIS_AABB;
		case X:
		default:
			return X_AXIS_AABB;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState p_54928_, Direction p_54929_, BlockState p_54930_, LevelAccessor p_54931_, BlockPos p_54932_, BlockPos p_54933_) {
		Direction.Axis direction$axis = p_54929_.getAxis();
		Direction.Axis direction$axis1 = p_54928_.getValue(AXIS);
		boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
		return !flag && !p_54930_.is(this) && !(new PortalShape(p_54931_, p_54932_, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(p_54928_, p_54929_, p_54930_, p_54931_, p_54932_, p_54933_);
	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (entity.canChangeDimensions()) {
			PortalHook portalHook = entity.getCapability(PortalHook.PORTAL_HOOK_INSTANCE).orElseThrow(NullPointerException::new);
			portalHook.handleInsidePortal(blockPos, entity);
			portalHook.handleNetherPortal();
		}
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		if (randomSource.nextInt(100) == 0) {
			level.playLocalSound(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int i = 0; i < 4; ++i) {
			double d0 = blockPos.getX() + randomSource.nextDouble();
			double d1 = blockPos.getY() + randomSource.nextDouble();
			double d2 = blockPos.getZ() + randomSource.nextDouble();
			double d3 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			double d4 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			double d5 = (randomSource.nextFloat() - 0.5D) * 0.5D;
			int j = randomSource.nextInt(2) * 2 - 1;
			if (!level.getBlockState(blockPos.west()).is(this) && !level.getBlockState(blockPos.east()).is(this)) {
				d0 = blockPos.getX() + 0.5D + 0.25D * j;
				d3 = randomSource.nextFloat() * 2.0F * j;
			} else {
				d2 = blockPos.getZ() + 0.5D + 0.25D * j;
				d5 = randomSource.nextFloat() * 2.0F * j;
			}
			level.addParticle(ParticleTypes.DRIPPING_DRIPSTONE_WATER, d0, d1, d2, d3, d4, d5);
		}
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
		return ItemStack.EMPTY;
	}

	@Override
	public BlockState rotate(BlockState p_54925_, Rotation p_54926_) {
		switch (p_54926_) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch (p_54925_.getValue(AXIS)) {
			case Z:
				return p_54925_.setValue(AXIS, Direction.Axis.X);
			case X:
				return p_54925_.setValue(AXIS, Direction.Axis.Z);
			default:
				return p_54925_;
			}
		default:
			return p_54925_;
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}
}
