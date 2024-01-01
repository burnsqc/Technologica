package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.level.block.entity.LightBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LightBlock extends BaseEntityBlock {

	public LightBlock(Properties p_48756_) {
		super(p_48756_);
	}
	
	public RenderShape getRenderShape(BlockState p_48758_) {
		return RenderShape.INVISIBLE;
	}

	public VoxelShape getShape(BlockState p_48760_, BlockGetter p_48761_, BlockPos p_48762_, CollisionContext p_48763_) {
		return Shapes.empty();
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new LightBlockEntity(p_153215_, p_153216_);
	}

	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
		if (level.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState2, t) -> {
			if (t instanceof LightBlockEntity tile) {
				tile.serverTick();
			}
		};
	}
}
