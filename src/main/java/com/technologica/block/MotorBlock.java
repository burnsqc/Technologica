package com.technologica.block;

import com.technologica.item.ModItems;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MotorBlock extends TwentyFourDirectionBlock {

	public MotorBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.DOWN).with(SUB_FACING, Direction.NORTH));
	}
	
	//Interaction
	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		Item tool = player.getHeldItem(handIn).getItem();
			
		if (tool == ModItems.STEEL_SHAFT.get() && hit.getFace() == stateIn.get(SUB_FACING) && worldIn.isAirBlock(hit.getPos().offset(hit.getFace()))) {
			worldIn.setBlockState(hit.getPos().offset(hit.getFace()), ModBlocks.LINE_SHAFT.get().getDefaultState().with(RotatedPillarBlock.AXIS, stateIn.get(SUB_FACING).getAxis()), 3);
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if (worldIn.isBlockPowered(fromPos) && worldIn.getBlockState(pos.offset(state.get(SUB_FACING))).getBlock() instanceof LineShaftBlock) {
			LineShaftTileEntity tile = (LineShaftTileEntity) worldIn.getTileEntity(pos.offset(state.get(SUB_FACING)));  
			tile.setRPM(60);
		} else if (!worldIn.isBlockPowered(fromPos) && worldIn.getBlockState(pos.offset(state.get(SUB_FACING))).getBlock() instanceof LineShaftBlock) {
			LineShaftTileEntity tile = (LineShaftTileEntity) worldIn.getTileEntity(pos.offset(state.get(SUB_FACING)));  
			tile.setRPM(0);
		}
	}
}