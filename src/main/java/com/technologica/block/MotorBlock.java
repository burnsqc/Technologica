package com.technologica.block;

import com.technologica.item.TechnologicaItems;
import com.technologica.tileentity.LineShaftHangerTileEntity;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

/**
 * Special one-off class for motors.
 * Created to handle player interaction and RPM/torque setting for line shafts.
 */
public class MotorBlock extends TwentyFourDirectionBlock {
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public int maxRPM = 0;
	public int maxTorque = 0;
	
	public MotorBlock(int maxTorqueIn, int maxRPMIn) {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.DOWN).with(SUB_FACING, Direction.NORTH).with(POWERED, false));
		maxTorque = maxTorqueIn;
		maxRPM = maxRPMIn; 
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void neighborChanged(BlockState stateIn, World worldIn, BlockPos posIn, Block blockIn, BlockPos fromPosIn, boolean isMovingIn) {
		if (!worldIn.isRemote) {
			boolean alreadyPowered = stateIn.get(POWERED);
			
			if (worldIn.isBlockPowered(posIn) != alreadyPowered) {
				worldIn.setBlockState(posIn, stateIn.cycleValue(POWERED), 3);
				TileEntity tile;
				
				if (worldIn.getTileEntity(posIn.offset(stateIn.get(SUB_FACING))) instanceof LineShaftTileEntity && worldIn.getBlockState(posIn.offset(stateIn.get(SUB_FACING))).get(RotatedPillarBlock.AXIS) == stateIn.get(SUB_FACING).getAxis()) {
					tile = (LineShaftTileEntity) worldIn.getTileEntity(posIn.offset(stateIn.get(SUB_FACING)));
					if (worldIn.isBlockPowered(posIn)) ((LineShaftTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);						
					else if (!worldIn.isBlockPowered(posIn)) ((LineShaftTileEntity) tile).subtractTorque(maxTorque);
				} else if (worldIn.getTileEntity(posIn.offset(stateIn.get(SUB_FACING))) instanceof LineShaftHangerTileEntity && worldIn.getBlockState(posIn.offset(stateIn.get(SUB_FACING))).get(RotatedPillarBlock.AXIS) == stateIn.get(SUB_FACING).getAxis()) {
					tile = (LineShaftHangerTileEntity) worldIn.getTileEntity(posIn.offset(stateIn.get(SUB_FACING)));
					if (worldIn.isBlockPowered(posIn)) ((LineShaftHangerTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);						
					else if (!worldIn.isBlockPowered(posIn)) ((LineShaftHangerTileEntity) tile).subtractTorque(maxTorque);
				}
			}
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		Item tool = playerIn.getHeldItem(handIn).getItem();
			
		if (tool == TechnologicaItems.STEEL_SHAFT.get() && hitIn.getFace() == stateIn.get(SUB_FACING) && worldIn.isAirBlock(hitIn.getPos().offset(hitIn.getFace()))) {
			worldIn.setBlockState(hitIn.getPos().offset(hitIn.getFace()), TechnologicaBlocks.LINE_SHAFT.get().getDefaultState().with(RotatedPillarBlock.AXIS, stateIn.get(SUB_FACING).getAxis()), 3);
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(POWERED);
		super.fillStateContainer(builderIn);
	}
}