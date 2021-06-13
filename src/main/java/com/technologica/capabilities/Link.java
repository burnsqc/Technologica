package com.technologica.capabilities;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

import java.util.concurrent.Callable;

import com.technologica.block.ModBlocks;
import com.technologica.block.TwelveDirectionBlock;
import com.technologica.items.ModItems;
import com.technologica.tileentity.LineShaftHangerTileEntity;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.INBTSerializable;

public class Link implements ILink, INBTSerializable<CompoundNBT> {
	public static final String BOOLEAN_LINKING_KEY = "linking";
	private boolean linking = false;
	private World world;
	private BlockPos linkPos1 = BlockPos.ZERO;
	private BlockPos linkPos2 = BlockPos.ZERO;
	private BlockState linkState1;
	private BlockState linkState2;
	private TileEntity linkTile1;
	private TileEntity linkTile2;
	private Direction.Axis axis;
	private Direction direction;
	private int distance;
	private PlayerEntity player;
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
	public void startLink(World worldIn ,BlockPos posIn, BlockState stateIn, PlayerEntity playerIn) {
		this.linking = true;
		this.world = worldIn;
		this.linkPos1 = posIn;
		this.linkState1 = stateIn;
		this.player = playerIn;
		this.message = "LINK STARTED";
		this.player.sendMessage(new StringTextComponent(this.message), Util.DUMMY_UUID);
	}
	
	@Override
	public void stopLink(BlockPos posIn, BlockState stateIn) {
		this.linking = false;
		this.linkPos2 = posIn;
		this.linkState2 = stateIn;
	}
	
	@Override
	public boolean checkAxis() {
		if (this.linkState1.get(TwelveDirectionBlock.AXIS).equals(this.linkState2.get(TwelveDirectionBlock.AXIS))) {
			this.axis = this.linkState1.get(TwelveDirectionBlock.AXIS);
			return true;
		} else {
			this.message = "LINK FAILED: AXIS MISALIGNMENT";
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
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
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
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
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		}
		return bool; 
	}
	
	@Override
	public boolean checkObstructed() {
		boolean bool = true;
		for (int k = 1; k < this.distance; k++) {
			if (!this.world.isAirBlock(this.linkPos1.offset(this.direction, k))) {
				bool = false;
			}	
		}
		if (!bool) {
			this.message = "LINK FAILED: OBSTRUCTED";
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);	
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
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		} else if (!bool2) {
			this.message = "LINK FAILED: DISTANCE TOO SHORT";
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		}
		return bool1 && bool2; 
	}
	
	@Override
	public boolean checkMaterial() {
		PlayerInventory inv = this.player.inventory;
		this.linkTile1 = this.world.getTileEntity(this.linkPos1);
		this.linkTile2 = this.world.getTileEntity(this.linkPos2);
		int count = 0;
		int shaft1;
		int shaft2;
		boolean bool = false;
		
		shaft1 = ((LineShaftHangerTileEntity) this.linkTile1).getShaft() ? 0 : 1;
		shaft2 = ((LineShaftHangerTileEntity) this.linkTile2).getShaft() ? 0 : 1;
		
		for(int i = 0; i < inv.getSizeInventory(); i++) {
		    ItemStack stack = inv.getStackInSlot(i);  
		    if(stack.getItem() == ModItems.STEEL_SHAFT.get()) {
		        count = count + stack.getCount();
		    }    
		}
		bool = this.distance - 1 + shaft1 + shaft2 <= count;
		if (!bool) {
			this.message = "LINK FAILED: MATERIAL SHORTAGE";
			this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		}
		return bool;
	}
	
	@Override
	public void createLineShaft() {
		((LineShaftHangerTileEntity) this.linkTile1).setShaft(true);
		((LineShaftHangerTileEntity) this.linkTile2).setShaft(true);
		this.world.notifyBlockUpdate(this.linkPos1, this.linkState1, this.linkState1, 3);
		this.world.notifyBlockUpdate(this.linkPos2, this.linkState2, this.linkState2, 3);
		
		for (int k = 1; k < this.distance; k++) {
			this.world.setBlockState(this.linkPos1.offset(this.direction, k), ModBlocks.LINE_SHAFT.get().getDefaultState().with(AXIS, this.axis), 3);
			this.world.notifyBlockUpdate(this.linkPos1.offset(this.direction, k), Blocks.AIR.getDefaultState(), ModBlocks.LINE_SHAFT.get().getDefaultState().with(AXIS, this.axis), 3);
		}
		this.message = "LINK SUCCESS";
		this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);	
	}
	
	@Override
	public void createBelt() {
		this.linkTile1 = this.world.getTileEntity(this.linkPos1);
		this.linkTile2 = this.world.getTileEntity(this.linkPos2);
		((LineShaftTileEntity) this.linkTile1).setBeltPos(this.linkPos2);
		((LineShaftTileEntity) this.linkTile2).setBeltPos(this.linkPos1);
		((LineShaftTileEntity) this.linkTile1).setRatio();
		this.world.notifyBlockUpdate(this.linkPos1, this.linkState1, this.linkState1, 3);
		this.message = "LINK SUCCESS";
		this.player.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);	
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putBoolean(BOOLEAN_LINKING_KEY, this.linking);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.linking = nbt.getBoolean(BOOLEAN_LINKING_KEY);
	}
	
	public static class LinkStorage implements IStorage<ILink> {
		@Override
		public INBT writeNBT(Capability<ILink> capability, ILink instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean(BOOLEAN_LINKING_KEY, instance.getLinking());
			return nbt;
		}

		@Override
		public void readNBT(Capability<ILink> capability, ILink instance, Direction side, INBT nbt) {
			if (!(instance instanceof Link)) {
				throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
			}
			
		}
	}
	
	public static class Factory implements Callable<ILink> {
		@Override
		public ILink call() throws Exception {
			return new Link();
		}
	}	
}
