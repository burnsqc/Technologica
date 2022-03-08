package com.technologica.block;

import java.util.Random;

import com.technologica.item.TechnologicaItems;
import com.technologica.state.properties.TechnologicaBlockStateProperties;
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

/**
 * Special one-off class for the line shaft.    
 * Created to add the radius property as well as handle player interaction, valid position checks, and associated tile entity.
 */
public class LineShaftBlock extends RotatedPillarBlock {
	public static final EnumProperty<Radius> RADIUS = TechnologicaBlockStateProperties.RADIUS;
	
	public LineShaftBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(RADIUS, Radius.NONE));
	}

	/*
	 * Technologica Methods
	 */
	
	public LineShaftTileEntity getTileEntity(World worldIn, BlockPos posIn) {
        return (LineShaftTileEntity) worldIn.getTileEntity(posIn);
    }
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	@Deprecated
	public BlockState updatePostPlacement(BlockState stateIn, Direction directionIn, BlockState facingStateIn, IWorld worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		worldIn.getPendingBlockTicks().scheduleTick(currentPosIn, this, 0);
	    return super.updatePostPlacement(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		LineShaftTileEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getHeldItem(handIn).getItem();
		
		if (tool == TechnologicaItems.PIPE_WRENCH.get()) {
			worldIn.setBlockState(posIn, stateIn.with(RADIUS, Radius.NONE), 1);
			worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			
		} else if (tile.getBlockState().get(RADIUS).getRadius() == 0) {
			if (tool == TechnologicaItems.SMALL_PULLEY_ITEM.get()) {
				worldIn.setBlockState(posIn, stateIn.with(RADIUS, Radius.SMALL), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.MEDIUM_PULLEY_ITEM.get()) {
				worldIn.setBlockState(posIn, stateIn.with(RADIUS, Radius.MEDIUM), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.LARGE_PULLEY_ITEM.get()) {
				worldIn.setBlockState(posIn, stateIn.with(RADIUS, Radius.LARGE), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}

	@Override
	public BlockRenderType getRenderType(BlockState stateIn) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}	
	
	@Override
	public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		boolean bool = false;
		switch (stateIn.get(AXIS)) {
		case X:
			bool = worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.east()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.west()).getBlock() instanceof MotorBlock);
			break;
		case Y:
			bool = worldIn.getBlockState(posIn.up()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.down()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.up()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.down()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.up()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.down()).getBlock() instanceof MotorBlock);
			break;
		case Z:
			bool = worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.north()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.south()).getBlock() instanceof MotorBlock);
			break;
		}
		return bool;		
	}
	
	@Override
	public void tick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
	    if (!isValidPosition(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos posIn, BlockState stateIn, PlayerEntity playerIn) {
		LineShaftTileEntity tile = getTileEntity(worldIn, posIn);
		if (tile.getBeltPos() != null) {
			LineShaftTileEntity tile2 = getTileEntity(worldIn, tile.getBeltPos());
			tile.setBeltPos(null);	
			tile2.setBeltPos(null);
		}
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(RADIUS);
		super.fillStateContainer(builderIn);
	}
	
	/*
	 * Forge Methods
	 */
	
	@Override
	public boolean hasTileEntity(BlockState stateIn) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState stateIn, IBlockReader worldIn) {
		return new LineShaftTileEntity();
	}
}
