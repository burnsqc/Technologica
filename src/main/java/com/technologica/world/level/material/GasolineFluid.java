package com.technologica.world.level.material;

import java.util.Optional;

import javax.annotation.Nullable;

import com.technologica.core.particles.DrippingLiquidParticleData;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;

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
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;

public abstract class GasolineFluid extends FlowingFluid {
	@Override
	public Fluid getFlowing() {
		return TechnologicaFluids.FLOWING_GASOLINE.get();
	}

	@Override
	public Fluid getSource() {
		return TechnologicaFluids.GASOLINE.get();
	}

	@Override
	public Item getBucket() {
		return TechnologicaItems.GASOLINE_BUCKET.get();
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
		return DrippingLiquidParticleData.GASOLINE;
	}

	@Override
	protected boolean canConvertToSource() {
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
		return TechnologicaBlocks.GASOLINE.get().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
	}

	@Override
	public boolean isSame(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.GASOLINE.get() || fluidIn == TechnologicaFluids.FLOWING_GASOLINE.get();
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
		return direction == Direction.DOWN && !fluidState.is(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.of(SoundEvents.BUCKET_FILL);
	}

	public static class Flowing extends GasolineFluid {
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

	public static class Source extends GasolineFluid {
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
		return TechnologicaFluids.GASOLINE_TYPE.get();
	}
}
