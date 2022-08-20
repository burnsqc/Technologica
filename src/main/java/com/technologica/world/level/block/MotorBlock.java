package com.technologica.world.level.block;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Special one-off class for motors. Created to handle player interaction and RPM/torque setting for line shafts.
 */
public class MotorBlock extends TwentyFourDirectionBlock {
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public float maxRPM = 0;
	public float maxTorque = 0;

	public MotorBlock(float maxTorqueIn, float maxRPMIn) {
		super(BlockBehaviour.Properties.of(Material.METAL).strength(0.3F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN).setValue(SUB_FACING, Direction.NORTH).setValue(POWERED, false));
		maxTorque = maxTorqueIn;
		maxRPM = maxRPMIn;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public void neighborChanged(BlockState stateIn, Level worldIn, BlockPos posIn, Block blockIn, BlockPos fromPosIn, boolean isMovingIn) {
		if (!worldIn.isClientSide) {
			boolean alreadyPowered = stateIn.getValue(POWERED);

			if (worldIn.hasNeighborSignal(posIn) != alreadyPowered) {
				worldIn.setBlock(posIn, stateIn.cycle(POWERED), 3);
				// BlockEntity tile;

				// if (worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING))) instanceof LineShaftTileEntity && worldIn.getBlockState(posIn.relative(stateIn.getValue(SUB_FACING))).getValue(RotatedPillarBlock.AXIS) == stateIn.getValue(SUB_FACING).getAxis()) {
				// tile = worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING)));
				// if (worldIn.hasNeighborSignal(posIn)) ((LineShaftTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);
				// else if (!worldIn.hasNeighborSignal(posIn)) ((LineShaftTileEntity) tile).subtractTorque(maxTorque);
				// } else if (worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING))) instanceof LineShaftHangerTileEntity && worldIn.getBlockState(posIn.relative(stateIn.getValue(SUB_FACING))).getValue(RotatedPillarBlock.AXIS) == stateIn.getValue(SUB_FACING).getAxis()) {
				// tile = worldIn.getBlockEntity(posIn.relative(stateIn.getValue(SUB_FACING)));
				// if (worldIn.hasNeighborSignal(posIn)) ((LineShaftHangerTileEntity) tile).checkSetShaftTorqueRPM(maxTorque, maxRPM);
				// else if (!worldIn.hasNeighborSignal(posIn)) ((LineShaftHangerTileEntity) tile).subtractTorque(maxTorque);
				// }
			}
		}
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		Item tool = playerIn.getItemInHand(handIn).getItem();

		if (tool == TechnologicaItems.STEEL_SHAFT.get() && hitIn.getDirection() == stateIn.getValue(SUB_FACING) && worldIn.isEmptyBlock(hitIn.getBlockPos().relative(hitIn.getDirection()))) {
			worldIn.setBlock(hitIn.getBlockPos().relative(hitIn.getDirection()), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, stateIn.getValue(SUB_FACING).getAxis()), 3);
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(POWERED);
		super.createBlockStateDefinition(builderIn);
	}
}