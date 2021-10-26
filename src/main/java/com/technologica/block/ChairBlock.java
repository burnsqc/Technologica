package com.technologica.block;

import com.technologica.entity.item.InvisibleSeatEntity;
import com.technologica.tileentity.FruitTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
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
	protected static final VoxelShape CHAIR_HITBOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);

	public ChairBlock() {
		super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	/*
	 * Technologica Methods
	 */
	
	public boolean hasEntity(BlockState stateIn) {
		return true;
	}

	public TileEntity createEntity(BlockState stateIn, IBlockReader worldIn) {
		return new FruitTileEntity();
	}
	
	public InvisibleSeatEntity getEntity(World world, BlockPos pos) {
		return (InvisibleSeatEntity) world.getEntitiesWithinAABB(InvisibleSeatEntity.class, new AxisAlignedBB(pos)).get(0);
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		return CHAIR_HITBOX;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		InvisibleSeatEntity seat = new InvisibleSeatEntity(worldIn, pos.getX() + 0.5F, pos.getY() + 0.35F, pos.getZ() + 0.5F);
		worldIn.addEntity(seat);
     }
	
	@Override
	public ActionResultType onBlockActivated(BlockState stateIn, World worldIn, BlockPos posIn, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hitIn) {
		if (!worldIn.isRemote) {
			InvisibleSeatEntity seat = getEntity(worldIn, posIn);
			playerIn.startRiding(seat);
		}	
		return ActionResultType.func_233537_a_(worldIn.isRemote);
	}
	
	@Override
	public void onReplaced(BlockState stateIn, World worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		InvisibleSeatEntity seat = getEntity(worldIn, posIn);
		seat.removePassengers();
		seat.remove();
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