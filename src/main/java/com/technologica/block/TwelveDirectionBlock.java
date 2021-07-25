package com.technologica.block;

import com.technologica.item.ModItems;
import com.technologica.tileentity.LineShaftHangerTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TwelveDirectionBlock extends Block{
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE_1_7;
	
	protected TwelveDirectionBlock() {
		super(Properties.create(Material.IRON).hardnessAndResistance(2.0F).harvestLevel(1).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(AXIS, Direction.Axis.Y));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new LineShaftHangerTileEntity();
	}

	public static LineShaftHangerTileEntity getTileEntity(World world, BlockPos pos) {
		return (LineShaftHangerTileEntity) world.getTileEntity(pos);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		LineShaftHangerTileEntity tile = getTileEntity(worldIn, posIn);
		Item tool = playerIn.getHeldItem(handIn).getItem();
		
		if (tool == ModItems.WRENCH.get() && !tile.getShaft()) {
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
		
		} else if (tool == ModItems.PIPE_WRENCH.get()) {
			if (!playerIn.isCrouching() && !tile.getShaft()) {
				tile.setShaft(true);
			}
		} 
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int i = 0;
		Direction[] adirection = context.getNearestLookingDirections();
		if (adirection[i] == context.getFace().getOpposite()) {
			i++;
		}
		return this.getDefaultState().with(FACING, context.getFace()).with(AXIS, adirection[i].getAxis());
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING).add(AXIS).add(DISTANCE);
		super.fillStateContainer(builder);
	}
}
