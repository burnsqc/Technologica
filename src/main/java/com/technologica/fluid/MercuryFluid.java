package com.technologica.fluid;

import static com.technologica.Technologica.MODID;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;
import com.technologica.particles.DrippingLiquidParticleData;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public abstract class MercuryFluid extends FlowingFluid {
	@Override
	public Fluid getFlowing() {
		return TechnologicaFluids.FLOWING_MERCURY.get();
	}

	@Override
	public Fluid getSource() {
		return TechnologicaFluids.MERCURY.get();
	}

	@Override
	public Item getBucket() {
		return TechnologicaItems.MERCURY_BUCKET.get();
	}

	@Override
	public void tick(World worldIn, BlockPos pos, FluidState state) {
	      if (!state.isSource()) {
	         FluidState fluidstate = this.getNewLiquid(worldIn, pos, worldIn.getBlockState(pos));
	         int i = this.getSpreadDelay(worldIn, pos, state, fluidstate);
	         if (fluidstate.isEmpty()) {
	            state = fluidstate;
	            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
	         } else if (!fluidstate.equals(state)) {
	            state = fluidstate;
	            BlockState blockstate = fluidstate.createLegacyBlock();
	            worldIn.setBlock(pos, blockstate, 2);
	            worldIn.getLiquidTicks().scheduleTick(pos, fluidstate.getType(), i);
	            worldIn.updateNeighborsAt(pos, blockstate.getBlock());
	         }
	      } else if (state.isSource() && (worldIn.isEmptyBlock(pos.below()) || worldIn.isWaterAt(pos.below()))) {
	    	  worldIn.setBlock(pos.below(), state.createLegacyBlock(), 3);
	    	  worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
	      }

//	      this.flowAround(worldIn, pos, state);
	   }
	
	@Override
	public FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(MODID, "block/metal_still"), new ResourceLocation(MODID, "block/metal_flow")).color(-1973791).build(TechnologicaFluids.MERCURY.get());
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
		return DrippingLiquidParticleData.MERCURY;
	}

	@Override
	protected boolean canConvertToSource() {
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getBlockEntity(pos) : null;
		Block.dropResources(state, worldIn, pos, tileentity);
	}

	@Override
	public int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	public BlockState createLegacyBlock(FluidState state) {
		return TechnologicaBlocks.MERCURY.get().defaultBlockState().setValue(FlowingFluidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
	}

	@Override
	public boolean isSame(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.MERCURY.get() || fluidIn == TechnologicaFluids.FLOWING_MERCURY.get();
	}

	@Override
	public int getDropOff(IWorldReader worldIn) {
		return 1;
	}

	@Override
	public int getTickDelay(IWorldReader p_205569_1_) {
		return 5;
	}

	@Override
	public boolean canBeReplacedWith(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid,
	                           Direction direction) {
		return direction == Direction.DOWN && !fluid.is(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	public static class Flowing extends MercuryFluid {
		@Override
		protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> builder) {
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

	public static class Source extends MercuryFluid {
		@Override
		public int getAmount(FluidState state) {
			return 8;
		}

		@Override
		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
