package com.technologica.world.level.block;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;

public class OilyBlock extends Block {
	public static final IntegerProperty PRESSURE = BlockStateProperties.AGE_25;
	
	public OilyBlock(Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(PRESSURE, 0));
	}
	
	@Override
	public FluidState getFluidState(BlockState blockState) {
		return TechnologicaFluids.OIL.get().getSource(false);
	}
	
	@Override
	public void onRemove(BlockState stateIn, Level level, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!stateIn.is(newStateIn.getBlock())) {
			for (int pressure = 0; pressure <= stateIn.getValue(PRESSURE); pressure++) {
				level.setBlock(posIn.offset(0, pressure, 0), TechnologicaBlocks.OIL.get().defaultBlockState(), 3);
			}
			if (stateIn.getValue(PRESSURE) > 0) {
				level.playSound((Player) null, posIn, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0F, 2.0F);
			}
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(PRESSURE);
		super.createBlockStateDefinition(builderIn);
	}
}