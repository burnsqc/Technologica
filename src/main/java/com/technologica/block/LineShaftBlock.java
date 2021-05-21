package com.technologica.block;

import com.technologica.items.ModItems;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LineShaftBlock extends RotatedPillarBlock {
	public static final IntegerProperty PULLEY = BlockStateProperties.LEVEL_0_3;
	
	public LineShaftBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(PULLEY, Integer.valueOf(0)));
	}

	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new LineShaftTileEntity();
	}
	
	public LineShaftTileEntity getTileEntity(World world, BlockPos pos) {
        return (LineShaftTileEntity) world.getTileEntity(pos);
    }
	
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		LineShaftTileEntity tile = getTileEntity(worldIn, pos);
		Item tool = player.getHeldItem(handIn).getItem();
		
		if (tile.getBlockState().get(PULLEY) == 0) {
			if (tool == ModItems.SMALL_PULLEY_ITEM.get()) {
				
				worldIn.setBlockState(pos, state.with(PULLEY, Integer.valueOf(1)), 1);
				tile.setRPM(60);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == ModItems.MEDIUM_PULLEY_ITEM.get()) {
				
				worldIn.setBlockState(pos, state.with(PULLEY, Integer.valueOf(2)), 1);
				tile.setRPM(60);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == ModItems.LARGE_PULLEY_ITEM.get()) {
				
				worldIn.setBlockState(pos, state.with(PULLEY, Integer.valueOf(3)), 1);
				tile.setRPM(60);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		} else {
			if (tool == ModItems.PIPE_WRENCH.get()) {
				
				worldIn.setBlockState(pos, state.with(PULLEY, Integer.valueOf(0)), 1);
				tile.setRPM(0);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PULLEY);
		super.fillStateContainer(builder);
	}
}
