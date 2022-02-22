package com.technologica.fluid;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class ChlorineFluid extends FlowingFluid {
	public Fluid getFlowing() {
		return TechnologicaFluids.FLOWING_CHLORINE.get();
	}

	public Fluid getSource() {
		return TechnologicaFluids.CHLORINE.get();
	}

	public Item getBucket() {
		return TechnologicaItems.CHLORINE_BUCKET.get();
	}

	@Override
	public FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow")).color(1690894208).build(TechnologicaFluids.CHLORINE.get());
	}

	@Override
	public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
		if (worldIn.isClientSide) {
			if (!state.isSource() && Boolean.FALSE.equals(state.getValue(FALLING))) {
				if (random.nextInt(64) == 0) {
					worldIn.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
				}
			} else if (random.nextInt(10) == 0) {
				worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	@Nullable
	public IParticleData getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	protected boolean canConvertToSource() {
		return false;
	}

	protected void beforeDestroyingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getBlockEntity(pos) : null;
		Block.dropResources(state, worldIn, pos, tileentity);
	}

	public int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	public BlockState createLegacyBlock(FluidState state) {
		return TechnologicaBlocks.CHLORINE.get().defaultBlockState().setValue(FlowingFluidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
	}

	@Override
	public boolean isSame(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.CHLORINE.get() || fluidIn == TechnologicaFluids.FLOWING_CHLORINE.get();
	}

	public int getDropOff(IWorldReader worldIn) {
		return 1;
	}

	public int getTickDelay(IWorldReader p_205569_1_) {
		return 3;
	}

	public boolean canBeReplacedWith(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.is(FluidTags.WATER);
	}

	protected float getExplosionResistance() {
		return 100.0F;
	}

	public static class Flowing extends ChlorineFluid {
		@Override
		protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends ChlorineFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
