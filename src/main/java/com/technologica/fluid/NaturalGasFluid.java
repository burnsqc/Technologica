package com.technologica.fluid;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;

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

public abstract class NaturalGasFluid extends FlowingFluid {

	@Override
	public Fluid getFlowingFluid() {
		return TechnologicaFluids.FLOWING_NATURAL_GAS.get();
	}

	@Override
	public Fluid getStillFluid() {
		return TechnologicaFluids.NATURAL_GAS.get();
	}

	@Override
	public Item getFilledBucket() {
		return TechnologicaItems.NATURAL_GAS_BUCKET.get();
	}

	@Override
	public void tick(World worldIn, BlockPos pos, FluidState state) {
		if (state.isSource() && worldIn.isAirBlock(pos.up())) {
			worldIn.setBlockState(pos.up(), state.getBlockState(), 3);
	    	worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
		if (!state.isSource()) {
			FluidState fluidstate = this.calculateCorrectFlowingState(worldIn, pos, worldIn.getBlockState(pos));
	        	int i = this.func_215667_a(worldIn, pos, state, fluidstate);



	         if (fluidstate.isEmpty()) {
	            state = fluidstate;
//	            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
	         } else if (!fluidstate.equals(state)) {
	            state = fluidstate;
	            BlockState blockstate = fluidstate.getBlockState();
	            worldIn.setBlockState(pos, blockstate, 2);
	            worldIn.getPendingFluidTicks().scheduleTick(pos, fluidstate.getFluid(), i);
	            worldIn.notifyNeighborsOfStateChange(pos, blockstate.getBlock());
	         }
	      }

	      this.flowAround(worldIn, pos, state);
	   }
	
	@Override
	public FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow")).color(1684340580).build(TechnologicaFluids.NATURAL_GAS.get());
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
		return ParticleTypes.DRIPPING_WATER;
	}

	@Override
	protected boolean canSourcesMultiply() {
		return false;
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
		Block.spawnDrops(state, worldIn, pos, tileentity);
	}

	@Override
	public int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	public BlockState getBlockState(FluidState state) {
		return TechnologicaBlocks.NATURAL_GAS.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == TechnologicaFluids.NATURAL_GAS.get() || fluidIn == TechnologicaFluids.FLOWING_NATURAL_GAS.get();
	}

	@Override
	public int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 1;
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 3;
	}

	@Override
	public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.UP && !fluid.isIn(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	public static class Flowing extends NaturalGasFluid {
		@Override
		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		@Override
		public int getLevel(FluidState state) {
			return state.get(LEVEL_1_8);
		}

		@Override
		public boolean isSource(FluidState state) {
			return false;
		}
	}

	public static class Source extends NaturalGasFluid {
		@Override
		public int getLevel(FluidState state) {
			return 8;
		}

		@Override
		public boolean isSource(FluidState state) {
			return true;
		}
	}
}
