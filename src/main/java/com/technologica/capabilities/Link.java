package com.technologica.capabilities;

import java.util.concurrent.Callable;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.TwelveDirectionBlock;
import com.technologica.world.level.block.entity.LineShaftHangerTileEntity;
import com.technologica.world.level.block.entity.LineShaftTileEntity;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.util.INBTSerializable;

public class Link implements ILink, INBTSerializable<CompoundTag> {
	public static final String BOOLEAN_LINKING_KEY = "linking";
	private boolean linking = false;
	private Level world;
	private BlockPos linkPos1 = BlockPos.ZERO;
	private BlockPos linkPos2 = BlockPos.ZERO;
	private BlockState linkState1;
	private BlockState linkState2;
	private BlockEntity linkTile1;
	private BlockEntity linkTile2;
	private Direction.Axis axis;
	private Direction direction;
	private int distance;
	private Player player;
	private String message;
	
	@Override
	public boolean getLinking() {
		return this.linking;
	}
	
	@Override
	public BlockPos getLinkAnchorPos() {
		return this.linkPos1;
	}
	
	@Override
	public void startLink(Level worldIn ,BlockPos posIn, BlockState stateIn, Player playerIn) {
		this.linking = true;
		this.world = worldIn;
		this.linkPos1 = posIn;
		this.linkState1 = stateIn;
		this.player = playerIn;
		this.message = "LINK STARTED";
		this.player.sendMessage(new TextComponent(this.message), Util.NIL_UUID);
	}
	
	@Override
	public void stopLink(BlockPos posIn, BlockState stateIn) {
		this.linking = false;
		this.linkPos2 = posIn;
		this.linkState2 = stateIn;
	}
	
	@Override
	public boolean checkAxis() {
		if (this.linkState1.getValue(TwelveDirectionBlock.AXIS).equals(this.linkState2.getValue(TwelveDirectionBlock.AXIS))) {
			this.axis = this.linkState1.getValue(TwelveDirectionBlock.AXIS);
			return true;
		} else {
			this.message = "LINK FAILED: AXIS MISALIGNMENT";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
			return false;
		}
	}
	
	@Override
	public boolean checkInlinePos() {
		boolean bool = false;
		switch (this.axis) {
		case X:
			bool = this.linkPos1.getY() == this.linkPos2.getY() && this.linkPos1.getZ() == this.linkPos2.getZ();
			this.direction = this.linkPos1.getX() > this.linkPos2.getX() ? Direction.WEST : Direction.EAST;
			this.distance = Math.abs(this.linkPos1.getX() - this.linkPos2.getX());
			break;
		case Y:
			bool = this.linkPos1.getX() == this.linkPos2.getX() && this.linkPos1.getZ() == this.linkPos2.getZ();
			this.direction = this.linkPos1.getY() > this.linkPos2.getY() ? Direction.DOWN : Direction.UP;
			this.distance = Math.abs(this.linkPos1.getY() - this.linkPos2.getY());
			break;
		case Z:
			bool = this.linkPos1.getX() == this.linkPos2.getX() && this.linkPos1.getY() == this.linkPos2.getY();
			this.direction = this.linkPos1.getZ() > this.linkPos2.getZ() ? Direction.NORTH : Direction.SOUTH;
			this.distance = Math.abs(this.linkPos1.getZ() - this.linkPos2.getZ());
			break;
		}
		if (!bool) {
			this.message = "LINK FAILED: POSITION MISALIGNMENT";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
		}
		return bool; 
	}
	
	@Override
	public boolean checkPlanarPos() {
		boolean bool = false;
		switch (this.axis) {
		case X:
			bool = this.linkPos1.getX() == this.linkPos2.getX();
			this.direction = this.linkPos1.getX() > this.linkPos2.getX() ? Direction.WEST : Direction.EAST;
			this.distance = Math.abs(this.linkPos1.getX() - this.linkPos2.getX());
			break;
		case Y:
			bool = this.linkPos1.getY() == this.linkPos2.getY();
			this.direction = this.linkPos1.getY() > this.linkPos2.getY() ? Direction.DOWN : Direction.UP;
			this.distance = Math.abs(this.linkPos1.getY() - this.linkPos2.getY());
			break;
		case Z:
			bool = this.linkPos1.getZ() == this.linkPos2.getZ();
			this.direction = this.linkPos1.getZ() > this.linkPos2.getZ() ? Direction.NORTH : Direction.SOUTH;
			this.distance = Math.abs(this.linkPos1.getZ() - this.linkPos2.getZ());
			break;
		}
		if (!bool) {
			this.message = "LINK FAILED: POSITION MISALIGNMENT";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
		}
		return bool; 
	}
	
	@Override
	public boolean checkObstructed() {
		boolean bool = true;
		for (int k = 1; k < this.distance; k++) {
			if (!this.world.isEmptyBlock(this.linkPos1.relative(this.direction, k))) {
				bool = false;
			}	
		}
		if (!bool) {
			this.message = "LINK FAILED: OBSTRUCTED";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);	
		}
		return bool;
	}

	@Override
	public boolean checkDistance() {
		boolean bool1 = false;
		boolean bool2 = false;
		
		bool1 = this.distance < 10;
		bool2 = this.distance > 1;
		if (!bool1) {
			this.message = "LINK FAILED: DISTANCE TOO FAR";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
		} else if (!bool2) {
			this.message = "LINK FAILED: DISTANCE TOO SHORT";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
		}
		return bool1 && bool2; 
	}
	
	@Override
	public boolean checkMaterial() {
		Inventory inv = this.player.getInventory();
		this.linkTile1 = this.world.getBlockEntity(this.linkPos1);
		this.linkTile2 = this.world.getBlockEntity(this.linkPos2);
		int count = 0;
		int shaft1;
		int shaft2;
		boolean bool = false;
		
		shaft1 = ((LineShaftHangerTileEntity) this.linkTile1).getShaft() ? 0 : 1;
		shaft2 = ((LineShaftHangerTileEntity) this.linkTile2).getShaft() ? 0 : 1;
		
		for(int i = 0; i < inv.getContainerSize(); i++) {
		    ItemStack stack = inv.getItem(i);  
		    if(stack.getItem() == TechnologicaItems.STEEL_SHAFT.get()) {
		        count = count + stack.getCount();
		    }    
		}
		bool = this.distance - 1 + shaft1 + shaft2 <= count;
		if (!bool) {
			this.message = "LINK FAILED: MATERIAL SHORTAGE";
			this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);
		}
		return bool;
	}
	
	@Override
	public void createLineShaft() {
		((LineShaftHangerTileEntity) this.linkTile1).setShaft(true);
		((LineShaftHangerTileEntity) this.linkTile2).setShaft(true);
		this.world.sendBlockUpdated(this.linkPos1, this.linkState1, this.linkState1, 3);
		this.world.sendBlockUpdated(this.linkPos2, this.linkState2, this.linkState2, 3);
		
		for (int k = 1; k < this.distance; k++) {
			this.world.setBlock(this.linkPos1.relative(this.direction, k), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(BlockStateProperties.AXIS, this.axis), 3);
			this.world.sendBlockUpdated(this.linkPos1.relative(this.direction, k), Blocks.AIR.defaultBlockState(), TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(BlockStateProperties.AXIS, this.axis), 3);
		}
		this.message = "LINK SUCCESS";
		this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);	
	}
	
	@Override
	public void createBelt() {
		this.linkTile1 = this.world.getBlockEntity(this.linkPos1);
		this.linkTile2 = this.world.getBlockEntity(this.linkPos2);
		((LineShaftTileEntity) this.linkTile1).setBeltPos(this.linkPos2);
		((LineShaftTileEntity) this.linkTile2).setBeltPos(this.linkPos1);
		this.world.sendBlockUpdated(this.linkPos1, this.linkState1, this.linkState1, 3);
		this.world.sendBlockUpdated(this.linkPos2, this.linkState2, this.linkState2, 3);
		this.message = "LINK SUCCESS";
		this.player.sendMessage(new TextComponent(message), Util.NIL_UUID);	
	}
	
	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		nbt.putBoolean(BOOLEAN_LINKING_KEY, this.linking);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		this.linking = nbt.getBoolean(BOOLEAN_LINKING_KEY);
	}
	
	public static class Factory implements Callable<ILink> {
		@Override
		public ILink call() throws Exception {
			return new Link();
		}
	}	
}
