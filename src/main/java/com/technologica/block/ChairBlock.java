package com.technologica.block;

import com.technologica.entity.item.InvisibleSeatEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Special one-off class for chairs.    
 * Created to inherit FourDirectionBlock orientation and handle matching voxel shape and flammability.
 */
public class ChairBlock extends FourDirectionBlock {
	protected static final VoxelShape CHAIR_HITBOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);

	public ChairBlock() {
		super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion());
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		return CHAIR_HITBOX;
	}

	@Override
	public ActionResultType use(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		if (!worldIn.isClientSide) {
			InvisibleSeatEntity seat = new InvisibleSeatEntity(worldIn, posIn.getX() + 0.5F, posIn.getY() + 0.35F, posIn.getZ() + 0.5F);
			worldIn.addFreshEntity(seat);
			playerIn.startRiding(seat);
		}	
		return ActionResultType.sidedSuccess(worldIn.isClientSide);
	}
	
	@Override
	public void onRemove(BlockState stateIn, World worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!worldIn.getEntitiesOfClass(InvisibleSeatEntity.class, new AxisAlignedBB(posIn)).isEmpty()) {
			InvisibleSeatEntity seat = worldIn.getEntitiesOfClass(InvisibleSeatEntity.class, new AxisAlignedBB(posIn)).get(0);
			seat.ejectPassengers();
			seat.remove();
		}
	}
	
	/*
	 * Forge Methods
	 */
	
	@Override
	public int getFlammability(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 20;
	}
}