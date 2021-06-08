package com.technologica.fluid;

import static com.technologica.Technologica.MODID;

import java.util.Random;

import javax.annotation.Nullable;

import com.technologica.block.ModBlocks;
import com.technologica.items.ModItems;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class HydrogenFluid extends FlowingFluid {
	@Override
	public Fluid getFlowingFluid() {
		return ModFluids.HYDROGEN_FLOWING.get();
	}

	@Override
	public Fluid getStillFluid() {
		return ModFluids.HYDROGEN_SOURCE.get();
	}

	@Override
	public Item getFilledBucket() {
		return ModItems.HYDROGEN_BUCKET.get();
	}
/*	
	@Override
	protected void flowAround(IWorld worldIn, BlockPos pos, FluidState stateIn) {
	      if (!stateIn.isEmpty()) {
	         BlockState blockstate = worldIn.getBlockState(pos);
	         BlockPos blockpos = pos.up();
	         BlockState blockstate1 = worldIn.getBlockState(blockpos);
	         FluidState fluidstate = this.calculateCorrectFlowingState(worldIn, blockpos, blockstate1);
	         if (this.canFlow(worldIn, pos, blockstate, Direction.UP, blockpos, blockstate1, worldIn.getFluidState(blockpos), fluidstate.getFluid())) {
	            this.flowInto(worldIn, blockpos, blockstate1, Direction.UP, fluidstate);
	            
	         
	            this.func_207937_a(worldIn, pos, stateIn, blockstate);
	         }

	      }
	   }
	
	private void func_207937_a(IWorld p_207937_1_, BlockPos p_207937_2_, FluidState p_207937_3_, BlockState p_207937_4_) {
	      int i = p_207937_3_.getLevel() - this.getLevelDecreasePerBlock(p_207937_1_);
	      if (p_207937_3_.get(FALLING)) {
	         i = 7;
	      }

	      if (i > 0) {
	         Map<Direction, FluidState> map = this.func_205572_b(p_207937_1_, p_207937_2_, p_207937_4_);

	         for(Entry<Direction, FluidState> entry : map.entrySet()) {
	            Direction direction = Direction.UP;
	            FluidState fluidstate = entry.getValue();
	            BlockPos blockpos = p_207937_2_.offset(direction);
	            BlockState blockstate = p_207937_1_.getBlockState(blockpos);
	            if (this.canFlow(p_207937_1_, p_207937_2_, p_207937_4_, direction, blockpos, blockstate, p_207937_1_.getFluidState(blockpos), fluidstate.getFluid())) {
	               this.flowInto(p_207937_1_, blockpos, blockstate, direction, fluidstate);
	            }
	         }

	      }
	   }
*/	
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
/*	
	@Override
	protected FluidState calculateCorrectFlowingState(IWorldReader worldIn, BlockPos pos, BlockState blockStateIn) {
	      int i = 0;
	      int j = 0;

	      for(Direction direction : Direction.Plane.HORIZONTAL) {
	         BlockPos blockpos = pos.offset(direction);
	         BlockState blockstate = worldIn.getBlockState(blockpos);
	         FluidState fluidstate = blockstate.getFluidState();
	         if (fluidstate.getFluid().isEquivalentTo(this)) {
	            if (fluidstate.isSource() && net.minecraftforge.event.ForgeEventFactory.canCreateFluidSource(worldIn, blockpos, blockstate, this.canSourcesMultiply())) {
	               ++j;
	            }

	            i = Math.max(i, fluidstate.getLevel());
	         }
	      }

	      if (j >= 2) {
	         BlockState blockstate1 = worldIn.getBlockState(pos.up());
	         if (blockstate1.getMaterial().isSolid()) {
	            return this.getStillFluidState(false);
	         }
	      }

	      BlockPos blockpos1 = pos.down();
	      BlockState blockstate2 = worldIn.getBlockState(blockpos1);
	      FluidState fluidstate2 = blockstate2.getFluidState();
	      if (!fluidstate2.isEmpty() && fluidstate2.getFluid().isEquivalentTo(this)) {
	         return this.getFlowingFluidState(8, true);
	      } else {
	         int k = i - this.getLevelDecreasePerBlock(worldIn);
	         return k <= 0 ? Fluids.EMPTY.getDefaultState() : this.getFlowingFluidState(k, false);
	      }
	   }
*/	
	@Override
	public FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(MODID, "block/brine_still"), new ResourceLocation(MODID, "block/brine_flow")).build(ModFluids.HYDROGEN_SOURCE.get());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
		if (!state.isSource() && Boolean.FALSE.equals(state.get(FALLING))) {
			if (random.nextInt(64) == 0) {
				worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
			}
		} else if (random.nextInt(10) == 0) {
			worldIn.addParticle(ParticleTypes.UNDERWATER, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	@Nullable
	@OnlyIn(Dist.CLIENT)
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
		return ModBlocks.HYDROGEN.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}

	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == ModFluids.HYDROGEN_SOURCE.get() || fluidIn == ModFluids.HYDROGEN_FLOWING.get();
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
	public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid,
	                           Direction direction) {
		return direction == Direction.UP && !fluid.isIn(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	public static class Flowing extends HydrogenFluid {
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

	public static class Source extends HydrogenFluid {
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
