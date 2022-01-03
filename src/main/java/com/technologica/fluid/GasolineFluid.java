package com.technologica.fluid;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;
import com.technologica.particles.DrippingLiquidParticleData;

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

public abstract class GasolineFluid extends FlowingFluid {
	public Fluid getFlowingFluid() {
		return TechnologicaFluids.FLOWING_GASOLINE.get();
	}

	public Fluid getStillFluid() {
		return TechnologicaFluids.GASOLINE.get();
	}

	public Item getFilledBucket() {
		return TechnologicaItems.GASOLINE_BUCKET.get();
	}

	@Override
	public FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow")).color(-2833815).build(TechnologicaFluids.GASOLINE.get());
	}

	@Override
	public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
		if (worldIn.isRemote) {
			if (!state.isSource() && Boolean.FALSE.equals(state.get(FALLING))) {
				if (random.nextInt(64) == 0) {
					worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
				}
			} else if (random.nextInt(10) == 0) {
				worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	@Nullable
	public IParticleData getDripParticleData() {
		return DrippingLiquidParticleData.GASOLINE;
	}

	protected boolean canSourcesMultiply() {
		return false;
	}

	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
		Block.spawnDrops(state, worldIn, pos, tileentity);
	}

	public int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	public BlockState getBlockState(FluidState state) {
		return TechnologicaBlocks.GASOLINE.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.GASOLINE.get() || fluidIn == TechnologicaFluids.FLOWING_GASOLINE.get();
	}

	public int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 1;
	}

	public int getTickRate(IWorldReader p_205569_1_) {
		return 3;
	}

	public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}

	protected float getExplosionResistance() {
		return 100.0F;
	}

	public static class Flowing extends GasolineFluid {
		@Override
		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		public int getLevel(FluidState state) {
			return state.get(LEVEL_1_8);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends GasolineFluid {
		public int getLevel(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
