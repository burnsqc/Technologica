package com.technologica.block;

import com.technologica.item.ModItems;

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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MotorBlock extends RotatedPillarBlock {
	public MotorBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, false));
	}
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	//States
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
		super.fillStateContainer(builder);
	}
	
	//Interaction
	@Override
	@Deprecated
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		Item tool = player.getHeldItem(handIn).getItem();
			
		if (tool == ModItems.STEEL_SHAFT.get() && hit.getFace().getAxis() == stateIn.get(AXIS) && worldIn.isAirBlock(hit.getPos().offset(hit.getFace()))) {
			worldIn.setBlockState(hit.getPos().offset(hit.getFace()), ModBlocks.LINE_SHAFT.get().getDefaultState().with(AXIS, stateIn.get(AXIS)), 3);
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
}
