package com.technologica.world.level.block;

import com.technologica.world.entity.decoration.InvisibleSeat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Special one-off class for chairs.
 * Created to inherit FourDirectionBlock orientation and handle matching voxel shape and flammability.
 */
public class ChairBlock extends FourDirectionBlock {
	protected static final VoxelShape CHAIR_HITBOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);

	public ChairBlock() {
		super(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion());
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		return CHAIR_HITBOX;
	}

	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		if (!worldIn.isClientSide) {
			InvisibleSeat seat = new InvisibleSeat(worldIn, posIn.getX() + 0.5F, posIn.getY() + 0.35F, posIn.getZ() + 0.5F);
			worldIn.addFreshEntity(seat);
			playerIn.startRiding(seat);
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	@Override
	public void onRemove(BlockState stateIn, Level worldIn, BlockPos posIn, BlockState newStateIn, boolean isMovingIn) {
		if (!worldIn.getEntitiesOfClass(InvisibleSeat.class, new AABB(posIn)).isEmpty()) {
			InvisibleSeat seat = worldIn.getEntitiesOfClass(InvisibleSeat.class, new AABB(posIn)).get(0);
			seat.ejectPassengers();
			seat.remove();
		}
	}

	/*
	 * Forge Methods
	 */

	@Override
	public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 20;
	}
}