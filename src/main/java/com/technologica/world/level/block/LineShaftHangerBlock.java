package com.technologica.world.level.block;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.entity.LineShaftHangerTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Special one-off class for the line shaft hanger. Created to add the handle player interaction and associated tile entity.
 */
public class LineShaftHangerBlock extends TwelveDirectionBlock implements EntityBlock {

	public LineShaftHangerBlock() {
		super(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.ANVIL).noOcclusion());
	}

	/*
	 * Technologica Methods
	 */

	public static LineShaftHangerTileEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (LineShaftHangerTileEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		LineShaftHangerTileEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getItemInHand(handIn).getItem();

		if (tool == TechnologicaItems.WRENCH.get() && !tile.getShaft()) {
			Axis axis = null;
			switch (stateIn.getValue(FACING).getAxis()) {
			case X:
				axis = stateIn.getValue(AXIS) == Axis.Y ? Axis.Z : Axis.Y;
				break;
			case Y:
				axis = stateIn.getValue(AXIS) == Axis.X ? Axis.Z : Axis.X;
				break;
			case Z:
				axis = stateIn.getValue(AXIS) == Axis.X ? Axis.Y : Axis.X;
				break;
			}
			worldIn.setBlock(posIn, stateIn.setValue(AXIS, axis), 2);

		} else if (tool == TechnologicaItems.STEEL_SHAFT.get()) {
			if (!playerIn.isCrouching() && !tile.getShaft()) {
				tile.setShaft(true);
			} else if (!playerIn.isCrouching() && tile.getShaft() && hitIn.getDirection().getAxis() == stateIn.getValue(AXIS)) {
				worldIn.setBlock(hitIn.getBlockPos().relative(hitIn.getDirection()), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, stateIn.getValue(AXIS)), 3);
			}
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new LineShaftHangerTileEntity(p_153215_, p_153216_);
	}
}
