package com.technologica.block;

import com.technologica.items.ModItems;
import com.technologica.tileentity.DriveShaftTileEntity;

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
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModDriveShaftBlock extends RotatedPillarBlock {
	public static final BooleanProperty PULLEY = BlockStateProperties.CONDITIONAL;
	
	public ModDriveShaftBlock() {
		super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.3F).sound(SoundType.ANVIL).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(PULLEY, false));
	}

	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new DriveShaftTileEntity();
	}
	
	public DriveShaftTileEntity getTileEntity(World world, BlockPos pos) {
        return (DriveShaftTileEntity) world.getTileEntity(pos);
    }
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		DriveShaftTileEntity tile = getTileEntity(worldIn, pos);
		Item tool = player.getHeldItem(handIn).getItem();
		
		if (!tile.getPulley()) {
			if (tool == ModItems.HAMMER.get()) {
				tile.setPulley(true);
				worldIn.setBlockState(pos, state.with(PULLEY, Boolean.valueOf(true)), 1);
				tile.setRPM(60);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		} else {
			if (tool == ModItems.WRENCH.get()) {
				tile.setPulley(false);
				worldIn.setBlockState(pos, state.with(PULLEY, Boolean.valueOf(false)), 1);
				tile.setRPM(0);
				worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.25F, 1.0F + worldIn.rand.nextFloat() * 0.4F);
			}
		}
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PULLEY);
		super.fillStateContainer(builder);
	}
}
