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
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(2.0F).harvestLevel(1).sound(SoundType.ANVIL).notSolid());
	}

	/*
	 * Technologica Methods
	 */
	
	public static LineShaftHangerTileEntity getTileEntity(World worldIn, BlockPos posIn) {
		return (LineShaftHangerTileEntity) worldIn.getTileEntity(posIn);
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		LineShaftHangerTileEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getHeldItem(handIn).getItem();

		if (tool == TechnologicaItems.WRENCH.get() && !tile.getShaft()) {
			Axis axis = null;
			switch (stateIn.get(FACING).getAxis()) {
			case X:
				axis = stateIn.get(AXIS) == Axis.Y ? Axis.Z : Axis.Y;
				break;
			case Y:
				axis = stateIn.get(AXIS) == Axis.X ? Axis.Z : Axis.X;
				break;
			case Z:
				axis = stateIn.get(AXIS) == Axis.X ? Axis.Y : Axis.X;
				break;
			}
			worldIn.setBlockState(posIn, stateIn.with(AXIS, axis), 2);

		} else if (tool == TechnologicaItems.STEEL_SHAFT.get()) {
			if (!playerIn.isCrouching() && !tile.getShaft()) {
				tile.setShaft(true);
			} else if (!playerIn.isCrouching() && tile.getShaft() && hitIn.getFace().getAxis() == stateIn.get(AXIS)) {
				worldIn.setBlockState(hitIn.getPos().offset(hitIn.getFace()),
						TechnologicaBlocks.LINE_SHAFT.get().getDefaultState().with(RotatedPillarBlock.AXIS, stateIn.get(AXIS)),
						3);
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
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
