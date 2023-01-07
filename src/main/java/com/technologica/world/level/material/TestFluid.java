package com.technologica.world.level.material;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class TestFluid extends FlowingFluid {

	@Override
	public Fluid getFlowing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fluid getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canConvertToSource(Level p_256670_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor p_76002_, BlockPos p_76003_, BlockState p_76004_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getSlopeFindDistance(LevelReader p_76074_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getDropOff(LevelReader p_76087_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmount(FluidState p_164509_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getBucket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canBeReplacedWith(FluidState p_76127_, BlockGetter p_76128_, BlockPos p_76129_, Fluid p_76130_, Direction p_76131_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTickDelay(LevelReader p_76120_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float getExplosionResistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState p_76136_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSource(FluidState p_76140_) {
		// TODO Auto-generated method stub
		return false;
	}

}
