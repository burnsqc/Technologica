package com.technologica.block;

import java.util.Random;

import com.technologica.item.ModItems;
import com.technologica.state.properties.ModBlockStateProperties;
import com.technologica.tileentity.LineShaftTileEntity;
import com.technologica.util.Radius;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class LineShaftBlock extends RotatedPillarBlock {
	public static final EnumProperty<Radius> RADIUS = ModBlockStateProperties.RADIUS;
	
	public LineShaftBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(RADIUS, Radius.NONE));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(RADIUS);
		super.fillStateContainer(builderIn);
	}
	
	@Override
	@Deprecated
	public void tick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
	    if (!isValidPosition(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}

	@Override
	@Deprecated
	public BlockState updatePostPlacement(BlockState stateIn, Direction directionIn, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 0);
	    return super.updatePostPlacement(stateIn, directionIn, facingState, worldIn, currentPos, facingPos);
	}
	
	@Override
	@Deprecated
	public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos pos) {
		boolean bool = false;
		switch (stateIn.get(AXIS)) {
		case X:
			bool = worldIn.getBlockState(pos.east()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(pos.west()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(pos.east()).getBlock() == ModBlocks.LINE_SHAFT.get() && worldIn.getBlockState(pos.west()).getBlock() == ModBlocks.LINE_SHAFT.get() || worldIn.getBlockState(pos.east()).getBlock() instanceof MotorBlock || worldIn.getBlockState(pos.west()).getBlock() instanceof MotorBlock);
			break;
		case Y:
			bool = worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.LINE_SHAFT.get() && worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.LINE_SHAFT.get() || worldIn.getBlockState(pos.up()).getBlock() instanceof MotorBlock || worldIn.getBlockState(pos.down()).getBlock() instanceof MotorBlock);
			break;
		case Z:
			bool = worldIn.getBlockState(pos.north()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(pos.south()).getBlock() == ModBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(pos.north()).getBlock() == ModBlocks.LINE_SHAFT.get() && worldIn.getBlockState(pos.south()).getBlock() == ModBlocks.LINE_SHAFT.get() || worldIn.getBlockState(pos.north()).getBlock() instanceof MotorBlock || worldIn.getBlockState(pos.south()).getBlock() instanceof MotorBlock);
			break;
	}
		return bool;		
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		LineShaftTileEntity tile = getTileEntity(worldIn, pos);
		tile.setBeltPos(null);
	}
	
	//Tile Entity
	@Override
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
	
	//Interaction
	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		LineShaftTileEntity tile = getTileEntity(worldIn, pos);
		Item tool = player.getHeldItem(handIn).getItem();
		
		if (tool == ModItems.PIPE_WRENCH.get()) {
			worldIn.setBlockState(pos, state.with(RADIUS, Radius.NONE), 1);
			worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			
		} else if (tile.getBlockState().get(RADIUS).getRadius() == 0) {
			if (tool == ModItems.SMALL_PULLEY_ITEM.get()) {
				worldIn.setBlockState(pos, state.with(RADIUS, Radius.SMALL), 1);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == ModItems.MEDIUM_PULLEY_ITEM.get()) {
				worldIn.setBlockState(pos, state.with(RADIUS, Radius.MEDIUM), 1);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == ModItems.LARGE_PULLEY_ITEM.get()) {
				worldIn.setBlockState(pos, state.with(RADIUS, Radius.LARGE), 1);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	//Render
	@Override
	@Deprecated
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}		
}
