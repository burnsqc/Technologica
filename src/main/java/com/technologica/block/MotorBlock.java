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
	public float maxRPM = 0;
	public float maxTorque = 0;
	
	public MotorBlock(float maxTorqueIn, float maxRPMIn) {
		super(AbstractBlock.Properties.of(Material.METAL).strength(0.3F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(SUB_FACING, Direction.NORTH).setValue(POWERED, false));
		maxTorque = maxTorqueIn;
		maxRPM = maxRPMIn; 
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void neighborChanged(BlockState stateIn, World worldIn, BlockPos posIn, Block blockIn, BlockPos fromPosIn, boolean isMovingIn) {
		if (!worldIn.isClientSide) {
			boolean alreadyPowered = stateIn.getValue(POWERED);
			
			if (worldIn.hasNeighborSignal(posIn) != alreadyPowered) {
				worldIn.setBlock(posIn, stateIn.cycle(POWERED), 3);
				TileEntity tile;
				
				if (worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING))) instanceof LineShaftTileEntity && worldIn.getBlockState(posIn.relative(stateIn.getValue(SUB_FACING))).getValue(RotatedPillarBlock.AXIS) == stateIn.getValue(SUB_FACING).getAxis()) {
					tile = (LineShaftTileEntity) worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING)));
					if (worldIn.hasNeighborSignal(posIn)) ((LineShaftTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);						
					else if (!worldIn.hasNeighborSignal(posIn)) ((LineShaftTileEntity) tile).subtractTorque(maxTorque);
				} else if (worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING))) instanceof LineShaftHangerTileEntity && worldIn.getBlockState(posIn.relative(stateIn.getValue(SUB_FACING))).getValue(RotatedPillarBlock.AXIS) == stateIn.getValue(SUB_FACING).getAxis()) {
					tile = (LineShaftHangerTileEntity) worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING)));
					if (worldIn.hasNeighborSignal(posIn)) ((LineShaftHangerTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);						
					else if (!worldIn.hasNeighborSignal(posIn)) ((LineShaftHangerTileEntity) tile).subtractTorque(maxTorque);
				}
			}
		}
	}
	
	@Override
	public ActionResultType use(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		Item tool = playerIn.getItemInHand(handIn).getItem();
			
		if (tool == TechnologicaItems.STEEL_SHAFT.get() && hitIn.getDirection() == stateIn.getValue(SUB_FACING) && worldIn.isEmptyBlock(hitIn.getBlockPos().relative(hitIn.getDirection()))) {
			worldIn.setBlock(hitIn.getBlockPos().relative(hitIn.getDirection()), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, stateIn.getValue(SUB_FACING).getAxis()), 3);
		}
		return ActionResultType.sidedSuccess(worldIn.isClientSide);
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(POWERED);
		super.createBlockStateDefinition(builderIn);
	}
}