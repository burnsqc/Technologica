package com.technologica.world.level.material;

import java.util.Optional;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaFluidTypes;
import com.technologica.registration.deferred.TechnologicaFluids;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;

public abstract class OxygenFluid extends FlowingFluid {

	@Override
	public Fluid getFlowing() {
		return TechnologicaFluids.FLOWING_OXYGEN.get();
	}

	@Override
	public Fluid getSource() {
		return TechnologicaFluids.OXYGEN.get();
	}

	@Override
	public Item getBucket() {
		return TechnologicaItems.OXYGEN_BUCKET.get();
	}

	@Override
	public void tick(Level worldIn, BlockPos pos, FluidState state) {
		if (state.isSource() && worldIn.isEmptyBlock(pos.above())) {
			worldIn.setBlock(pos.above(), state.createLegacyBlock(), 3);
			worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
		}
		if (!state.isSource()) {
			FluidState fluidstate = this.getNewLiquid(worldIn, pos, worldIn.getBlockState(pos));
			int i = this.getSpreadDelay(worldIn, pos, state, fluidstate);

			if (fluidstate.isEmpty()) {
				state = fluidstate;
//	            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
			} else if (!fluidstate.equals(state)) {
				state = fluidstate;
				BlockState blockstate = fluidstate.createLegacyBlock();
				worldIn.setBlock(pos, blockstate, 2);
				((LevelAccessor) worldIn.getFluidTicks()).scheduleTick(pos, fluidstate.getType(), i);
				worldIn.updateNeighborsAt(pos, blockstate.getBlock());
			}
		}

		this.spread(worldIn, pos, state);
	}

	@Override
	public void animateTick(Level worldIn, BlockPos pos, FluidState state, RandomSource random) {
		if (worldIn.isClientSide) {
			if (!state.isSource() && Boolean.FALSE.equals(state.getValue(FALLING))) {
				if (random.nextInt(64) == 0) {
					worldIn.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
				}
			} else if (random.nextInt(10) == 0) {
				worldIn.addParticle(ParticleTypes.UNDERWATER, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	@Nullable
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	@Override
	protected boolean canConvertToSource(Level p_256670_) {
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor worldIn, BlockPos pos, BlockState state) {
		BlockEntity tileentity = state.hasBlockEntity() ? worldIn.getBlockEntity(pos) : null;
		Block.dropResources(state, worldIn, pos, tileentity);
	}

	@Override
	public int getSlopeFindDistance(LevelReader worldIn) {
		return 4;
	}

	@Override
	public BlockState createLegacyBlock(FluidState state) {
		return TechnologicaBlocks.OXYGEN.get().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
	}

	@Override
	public boolean isSame(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.OXYGEN.get() || fluidIn == TechnologicaFluids.FLOWING_OXYGEN.get();
	}

	@Override
	public int getDropOff(LevelReader worldIn) {
		return 1;
	}

	@Override
	public int getTickDelay(LevelReader p_205569_1_) {
		return 3;
	}

	@Override
	public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockReader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.UP && !fluidState.is(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.of(SoundEvents.BUCKET_FILL);
	}

	public static class Flowing extends OxygenFluid {
		@Override
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		@Override
		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		@Override
		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends OxygenFluid {
		@Override
		public int getAmount(FluidState state) {
			return 8;
		}

		@Override
		public boolean isSource(FluidState state) {
			return true;
		}
	}

	@Override
	public FluidType getFluidType() {
		return TechnologicaFluidTypes.OXYGEN_TYPE.get();
	}
}
