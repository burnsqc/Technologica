package com.technologica.block;

import com.technologica.item.TechnologicaItems;
import com.technologica.tileentity.LineShaftHangerTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Special one-off class for the line shaft hanger. Created to add the handle
 * player interaction and associated tile entity.
 */
public class LineShaftHangerBlock extends TwelveDirectionBlock {

	public LineShaftHangerBlock() {
		super(AbstractBlock.Properties.of(Material.METAL).strength(2.0F).harvestLevel(1).sound(SoundType.ANVIL).noOcclusion());
	}

	/*
	 * Technologica Methods
	 */
	
	public static LineShaftHangerTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (LineShaftHangerTileEntity) worldIn.getBlockEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public ActionResultType use(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
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
				worldIn.setBlock(hitIn.getBlockPos().relative(hitIn.getDirection()),
						TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, stateIn.getValue(AXIS)),
						3);
			}
		}
		return ActionResultType.sidedSuccess(worldIn.isClientSide);
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
		return new LineShaftHangerTileEntity();
	}
}
