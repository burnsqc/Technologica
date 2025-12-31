package com.technologica.capabilities.item.link;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.level.block.TwelveDirectionBlock;
import com.technologica.world.level.block.entity.LineShaftBlockEntity;
import com.technologica.world.level.block.entity.LineShaftHangerBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.INBTSerializable;

public class Link implements INBTSerializable<CompoundTag> {
	private boolean isLinking = false;
	private Level level;
	private BlockPos blockPos1 = BlockPos.ZERO;
	private BlockPos blockPos2 = BlockPos.ZERO;
	private BlockState blockState1;
	private BlockState blockState2;
	private BlockEntity blockEntity1;
	private BlockEntity blockEntity2;
	private Direction.Axis axis;
	private Direction direction;
	private int distance;
	private Player player;
	public static final Capability<Link> LINK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public boolean getLinking() {
		return this.isLinking;
	}

	public BlockPos getLinkAnchorPos() {
		return this.blockPos1;
	}

	public void startLink(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		this.isLinking = true;
		this.level = level;
		this.blockPos1 = blockPos;
		this.blockState1 = blockState;
		this.player = player;
		this.player.displayClientMessage(Component.literal("LINK STARTED"), true);
	}

	public void stopLink(BlockPos blockPos, BlockState blockState) {
		this.isLinking = false;
		this.blockPos2 = blockPos;
		this.blockState2 = blockState;
	}

	public boolean checkAxisAlignment() {
		if (this.blockState1.getValue(TwelveDirectionBlock.AXIS).equals(this.blockState2.getValue(TwelveDirectionBlock.AXIS))) {
			this.axis = this.blockState1.getValue(TwelveDirectionBlock.AXIS);
			return true;
		} else {
			this.player.displayClientMessage(Component.literal("LINK FAILED: AXIS MISALIGNMENT"), true);
			return false;
		}
	}

	public boolean checkInlinePos() {
		boolean bool = false;
		switch (this.axis) {
			case X -> {
				bool = this.blockPos1.getY() == this.blockPos2.getY() && this.blockPos1.getZ() == this.blockPos2.getZ();
				this.direction = this.blockPos1.getX() > this.blockPos2.getX() ? Direction.WEST : Direction.EAST;
				this.distance = Math.abs(this.blockPos1.getX() - this.blockPos2.getX());
			}
			case Y -> {
				bool = this.blockPos1.getX() == this.blockPos2.getX() && this.blockPos1.getZ() == this.blockPos2.getZ();
				this.direction = this.blockPos1.getY() > this.blockPos2.getY() ? Direction.DOWN : Direction.UP;
				this.distance = Math.abs(this.blockPos1.getY() - this.blockPos2.getY());
			}
			case Z -> {
				bool = this.blockPos1.getX() == this.blockPos2.getX() && this.blockPos1.getY() == this.blockPos2.getY();
				this.direction = this.blockPos1.getZ() > this.blockPos2.getZ() ? Direction.NORTH : Direction.SOUTH;
				this.distance = Math.abs(this.blockPos1.getZ() - this.blockPos2.getZ());
			}
			default -> {
			}
		}
		if (!bool) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: POSITION MISALIGNMENT"), true);
		}
		return bool;
	}

	public boolean checkPlanarPos() {
		boolean bool = false;
		switch (this.axis) {
			case X:
				bool = this.blockPos1.getX() == this.blockPos2.getX();
				this.direction = this.blockPos1.getX() > this.blockPos2.getX() ? Direction.WEST : Direction.EAST;
				this.distance = Math.abs(this.blockPos1.getX() - this.blockPos2.getX());
				break;
			case Y:
				bool = this.blockPos1.getY() == this.blockPos2.getY();
				this.direction = this.blockPos1.getY() > this.blockPos2.getY() ? Direction.DOWN : Direction.UP;
				this.distance = Math.abs(this.blockPos1.getY() - this.blockPos2.getY());
				break;
			case Z:
				bool = this.blockPos1.getZ() == this.blockPos2.getZ();
				this.direction = this.blockPos1.getZ() > this.blockPos2.getZ() ? Direction.NORTH : Direction.SOUTH;
				this.distance = Math.abs(this.blockPos1.getZ() - this.blockPos2.getZ());
				break;
			default:
				break;
		}
		if (!bool) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: POSITION MISALIGNMENT"), true);
		}
		return bool;
	}

	public boolean checkObstructed() {
		boolean bool = true;
		for (int k = 1; k < this.distance; k++) {
			if (!this.level.isEmptyBlock(this.blockPos1.relative(this.direction, k))) {
				bool = false;
			}
		}
		if (!bool) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: OBSTRUCTED"), true);
		}
		return bool;
	}

	public boolean checkDistance() {
		boolean bool1 = false;
		boolean bool2 = false;

		bool1 = this.distance < 10;
		bool2 = this.distance > 1;
		if (!bool1) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: DISTANCE TOO FAR"), true);
		} else if (!bool2) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: DISTANCE TOO SHORT"), true);
		}
		return bool1 && bool2;
	}

	public boolean checkMaterial() {
		this.blockEntity1 = this.level.getBlockEntity(this.blockPos1);
		this.blockEntity2 = this.level.getBlockEntity(this.blockPos2);
		int count = 0;
		int shaft1;
		int shaft2;

		shaft1 = ((LineShaftHangerBlockEntity) this.blockEntity1).getShaft() ? 0 : 1;
		shaft2 = ((LineShaftHangerBlockEntity) this.blockEntity2).getShaft() ? 0 : 1;
		Inventory inventory = this.player.getInventory();
		for (int i = 0; i < inventory.getContainerSize(); i++) {
			ItemStack stack = inventory.getItem(i);
			if (stack.getItem() == TechnologicaItems.STEEL_SHAFT.get()) {
				count = count + stack.getCount();
			}
		}

		boolean bool = false;
		bool = this.distance - 1 + shaft1 + shaft2 <= count;
		if (!bool) {
			this.player.displayClientMessage(Component.literal("LINK FAILED: MATERIAL SHORTAGE"), true);
		}
		return bool;
	}

	public void createLineShaft() {
		((LineShaftHangerBlockEntity) this.blockEntity1).setShaft(true);
		((LineShaftHangerBlockEntity) this.blockEntity2).setShaft(true);
		this.level.sendBlockUpdated(this.blockPos1, this.blockState1, this.blockState1, 3);
		this.level.sendBlockUpdated(this.blockPos2, this.blockState2, this.blockState2, 3);

		for (int k = 1; k < this.distance; k++) {
			this.level.setBlock(this.blockPos1.relative(this.direction, k), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(BlockStateProperties.AXIS, this.axis), 3);
			this.level.sendBlockUpdated(this.blockPos1.relative(this.direction, k), Blocks.AIR.defaultBlockState(), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(BlockStateProperties.AXIS, this.axis), 3);
		}
		this.player.displayClientMessage(Component.literal("LINK SUCCESS"), true);
	}

	public void createBelt() {
		this.blockEntity1 = this.level.getBlockEntity(this.blockPos1);
		this.blockEntity2 = this.level.getBlockEntity(this.blockPos2);
		((LineShaftBlockEntity) this.blockEntity1).setBeltPos(this.blockPos2);
		((LineShaftBlockEntity) this.blockEntity2).setBeltPos(this.blockPos1);
		this.level.sendBlockUpdated(this.blockPos1, this.blockState1, this.blockState1, 3);
		this.level.sendBlockUpdated(this.blockPos2, this.blockState2, this.blockState2, 3);
		this.player.displayClientMessage(Component.literal("LINK SUCCESS"), true);
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		nbt.putBoolean("linking", this.isLinking);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
		this.isLinking = compoundTag.getBoolean("linking");
	}
}
