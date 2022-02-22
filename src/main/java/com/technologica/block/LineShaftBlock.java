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
		super(AbstractBlock.Properties.of(Material.METAL).strength(0.3F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(RADIUS, Radius.NONE));
	}

	/*
	 * Technologica Methods
	 */
	
	public LineShaftTileEntity getTileEntity(World worldIn, BlockPos posIn) {
        return (LineShaftTileEntity) worldIn.getBlockEntity(posIn);
    }
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	@Deprecated
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, IWorld worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		worldIn.getBlockTicks().scheduleTick(currentPosIn, this, 0);
	    return super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}
	
	@Override
	public ActionResultType use(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		LineShaftTileEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getItemInHand(handIn).getItem();
		
		if (tool == TechnologicaItems.PIPE_WRENCH.get()) {
			worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.NONE), 1);
			worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			
		} else if (tile.getBlockState().getValue(RADIUS).getRadius() == 0) {
			if (tool == TechnologicaItems.SMALL_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.SMALL), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.MEDIUM_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.MEDIUM), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			} else if (tool == TechnologicaItems.LARGE_PULLEY_ITEM.get()) {
				worldIn.setBlock(posIn, stateIn.setValue(RADIUS, Radius.LARGE), 1);
				worldIn.playSound((PlayerEntity)null, posIn, SoundEvents.ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
			}
		}
		return ActionResultType.sidedSuccess(worldIn.isClientSide);
	}

	@Override
	public BlockRenderType getRenderShape(BlockState stateIn) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}	
	
	@Override
	public boolean canSurvive(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		boolean bool = false;
		switch (stateIn.getValue(AXIS)) {
		case X:
			bool = worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.east()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.west()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.east()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.west()).getBlock() instanceof MotorBlock);
			break;
		case Y:
			bool = worldIn.getBlockState(posIn.above()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.below()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.above()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.below()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.above()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.below()).getBlock() instanceof MotorBlock);
			break;
		case Z:
			bool = worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT_HANGER.get() || (worldIn.getBlockState(posIn.north()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() && worldIn.getBlockState(posIn.south()).getBlock() == TechnologicaBlocks.LINE_SHAFT.get() || worldIn.getBlockState(posIn.north()).getBlock() instanceof MotorBlock || worldIn.getBlockState(posIn.south()).getBlock() instanceof MotorBlock);
			break;
		}
		return bool;		
	}
	
	@Override
	public void tick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
	    if (!canSurvive(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}
	
	@Override
	public void playerWillDestroy(World worldIn, BlockPos posIn, BlockState stateIn, PlayerEntity playerIn) {
		LineShaftTileEntity tile = getTileEntity(worldIn, posIn);
		if (tile.getBeltPos() != null) {
			LineShaftTileEntity tile2 = getTileEntity(worldIn, tile.getBeltPos());
			tile.setBeltPos(null);	
			tile2.setBeltPos(null);
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(RADIUS);
		super.createBlockStateDefinition(builderIn);
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
