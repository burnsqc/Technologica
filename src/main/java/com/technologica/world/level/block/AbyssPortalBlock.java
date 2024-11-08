package com.technologica.world.level.block;

import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.world.level.block.entity.AbyssPortalBlockEntity;
import com.technologica.world.level.portal.AbyssPortal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbyssPortalBlock extends BaseEntityBlock {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

	public AbyssPortalBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new AbyssPortalBlockEntity(blockPos, blockState);
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPE;
	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		if (level instanceof ServerLevel && entity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(entity.getBoundingBox().move((-blockPos.getX()), (-blockPos.getY()), (-blockPos.getZ()))), blockState.getShape(level, blockPos), BooleanOp.AND)) {
			ResourceKey<Level> resourcekey = level.dimension() == Registries.levelStemToLevel(TechnologicaDimensions.CHALLENGER_DEEP_STEM) ? Level.OVERWORLD : Registries.levelStemToLevel(TechnologicaDimensions.CHALLENGER_DEEP_STEM);
			ServerLevel serverLevel = ((ServerLevel) level).getServer().getLevel(resourcekey);
			if (serverLevel == null) {
				return;
			}
			entity.changeDimension(serverLevel, new AbyssPortal(serverLevel, blockPos, entity));
		}
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		double d0 = blockPos.getX() + randomSource.nextDouble();
		double d1 = blockPos.getY() + 0.8D;
		double d2 = blockPos.getZ() + randomSource.nextDouble();
		level.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.1D, 0.0D);
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canBeReplaced(BlockState blockState, Fluid fluid) {
		return false;
	}
}
