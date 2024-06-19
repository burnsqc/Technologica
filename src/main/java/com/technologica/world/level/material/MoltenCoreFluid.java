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
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;

public abstract class MoltenCoreFluid extends FlowingFluid {
	@Override
	public Fluid getFlowing() {
		return TechnologicaFluids.FLOWING_MOLTEN_CORE.get();
	}

	@Override
	public Fluid getSource() {
		return TechnologicaFluids.MOLTEN_CORE.get();
	}

	@Override
	public Item getBucket() {
		return TechnologicaItems.MOLTEN_CORE_BUCKET.get();
	}

	@Override
	public void animateTick(Level worldIn, BlockPos pos, FluidState state, RandomSource random) {
		BlockPos blockPosAbove = pos.above();
		if (worldIn.getBlockState(blockPosAbove).isAir() && !worldIn.getBlockState(blockPosAbove).isSolidRender(worldIn, blockPosAbove)) {
			if (random.nextInt(10) == 0) {
				double d0 = pos.getX() + random.nextDouble();
				double d1 = pos.getY() + 1.0D;
				double d2 = pos.getZ() + random.nextDouble();
				worldIn.addParticle(ParticleTypes.LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				worldIn.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
			}

			if (random.nextInt(200) == 0) {
				worldIn.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
			}
		} else if (worldIn.isWaterAt(blockPosAbove)) {
			double d0 = pos.getX() + random.nextDouble();
			double d1 = pos.getY() + 1.0D;
			double d2 = pos.getZ() + random.nextDouble();
			worldIn.addAlwaysVisibleParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			worldIn.playLocalSound(d0, d1, d2, SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.5F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
		}
	}

	@Override
	public void randomTick(Level p_230572_, BlockPos p_230573_, FluidState p_230574_, RandomSource p_230575_) {
		if (p_230572_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
			int i = p_230575_.nextInt(3);
			if (i > 0) {
				BlockPos blockpos = p_230573_;

				for (int j = 0; j < i; ++j) {
					blockpos = blockpos.offset(p_230575_.nextInt(3) - 1, 1, p_230575_.nextInt(3) - 1);
					if (!p_230572_.isLoaded(blockpos)) {
						return;
					}

					BlockState blockstate = p_230572_.getBlockState(blockpos);
					if (blockstate.isAir()) {
						if (this.hasFlammableNeighbours(p_230572_, blockpos)) {
							p_230572_.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_230572_, blockpos, p_230573_, Blocks.FIRE.defaultBlockState()));
							return;
						}
					} else if (blockstate.blocksMotion()) {
						return;
					}
				}
			} else {
				for (int k = 0; k < 3; ++k) {
					BlockPos blockpos1 = p_230573_.offset(p_230575_.nextInt(3) - 1, 0, p_230575_.nextInt(3) - 1);
					if (!p_230572_.isLoaded(blockpos1)) {
						return;
					}

					if (p_230572_.isEmptyBlock(blockpos1.above()) && this.isFlammable(p_230572_, blockpos1, Direction.UP)) {
						p_230572_.setBlockAndUpdate(blockpos1.above(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_230572_, blockpos1.above(), p_230573_, Blocks.FIRE.defaultBlockState()));
					}
				}
			}
		}
	}

	private boolean hasFlammableNeighbours(LevelReader p_76228_, BlockPos p_76229_) {
		for (Direction direction : Direction.values()) {
			if (this.isFlammable(p_76228_, p_76229_.relative(direction), direction.getOpposite())) {
				return true;
			}
		}
		return false;
	}

	private boolean isFlammable(LevelReader level, BlockPos pos, Direction face) {
		return pos.getY() >= level.getMinBuildHeight() && pos.getY() < level.getMaxBuildHeight() && !level.hasChunkAt(pos) ? false : level.getBlockState(pos).isFlammable(level, pos, face);
	}

	@Override
	@Nullable
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_LAVA;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor p_76216_, BlockPos p_76217_, BlockState p_76218_) {
		this.fizz(p_76216_, p_76217_);
	}

	@Override
	public int getSlopeFindDistance(LevelReader p_76244_) {
		return p_76244_.dimensionType().ultraWarm() ? 4 : 2;
	}

	@Override
	public BlockState createLegacyBlock(FluidState p_76249_) {
		return TechnologicaBlocks.MOLTEN_CORE.get().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_76249_)));
	}

	@Override
	public boolean isSame(Fluid p_76231_) {
		return p_76231_ == TechnologicaFluids.MOLTEN_CORE.get() || p_76231_ == TechnologicaFluids.FLOWING_MOLTEN_CORE.get();
	}

	@Override
	public int getDropOff(LevelReader p_76252_) {
		return p_76252_.dimensionType().ultraWarm() ? 1 : 2;
	}

	@Override
	public boolean canBeReplacedWith(FluidState p_76233_, BlockGetter p_76234_, BlockPos p_76235_, Fluid p_76236_, Direction p_76237_) {
		return false;
	}

	@Override
	public int getTickDelay(LevelReader p_76226_) {
		return p_76226_.dimensionType().ultraWarm() ? 10 : 30;
	}

	@Override
	public int getSpreadDelay(Level p_76203_, BlockPos p_76204_, FluidState p_76205_, FluidState p_76206_) {
		int i = this.getTickDelay(p_76203_);
		if (!p_76205_.isEmpty() && !p_76206_.isEmpty() && !p_76205_.getValue(FALLING) && !p_76206_.getValue(FALLING) && p_76206_.getHeight(p_76203_, p_76204_) > p_76205_.getHeight(p_76203_, p_76204_) && p_76203_.getRandom().nextInt(4) != 0) {
			i *= 4;
		}

		return i;
	}

	private void fizz(LevelAccessor p_76213_, BlockPos p_76214_) {
		p_76213_.levelEvent(1501, p_76214_, 0);
	}

	@Override
	protected boolean canConvertToSource(Level p_256295_) {
		return false;
	}

	@Override
	protected void spreadTo(LevelAccessor p_76220_, BlockPos p_76221_, BlockState p_76222_, Direction p_76223_, FluidState p_76224_) {
		if (p_76223_ == Direction.DOWN) {
			FluidState fluidstate = p_76220_.getFluidState(p_76221_);
			if (this.is(FluidTags.LAVA) && fluidstate.is(FluidTags.WATER)) {
				if (p_76222_.getBlock() instanceof LiquidBlock) {
					p_76220_.setBlock(p_76221_, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_76220_, p_76221_, p_76221_, Blocks.STONE.defaultBlockState()), 3);
				}

				this.fizz(p_76220_, p_76221_);
				return;
			}
		}

		super.spreadTo(p_76220_, p_76221_, p_76222_, p_76223_, p_76224_);
	}

	@Override
	protected boolean isRandomlyTicking() {
		return true;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
	}

	public static class Flowing extends MoltenCoreFluid {
		@Override
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> p_76260_) {
			super.createFluidStateDefinition(p_76260_);
			p_76260_.add(LEVEL);
		}

		@Override
		public int getAmount(FluidState p_76264_) {
			return p_76264_.getValue(LEVEL);
		}

		@Override
		public boolean isSource(FluidState p_76262_) {
			return false;
		}
	}

	public static class Source extends MoltenCoreFluid {
		@Override
		public int getAmount(FluidState p_76269_) {
			return 8;
		}

		@Override
		public boolean isSource(FluidState p_76267_) {
			return true;
		}
	}

	@Override
	public FluidType getFluidType() {
		return TechnologicaFluidTypes.MOLTEN_CORE.get();
	}
}