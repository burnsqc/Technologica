package com.technologica.tileentity;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

public class LineShaftTileEntity extends TileEntity {
	private int rpm = 0;
	private int torque = 0;
	private Direction checkConnections1;
	private Direction checkConnections2;
	
	public LineShaftTileEntity() {
		super(ModTileEntities.LINE_SHAFT_TILE.get());
	}
	
	public void setRPM(int rpmIn) {
		this.rpm = rpmIn;
		
		if (this.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.X) {
			this.checkConnections1 = Direction.EAST;
			this.checkConnections2 = Direction.WEST;
		} else if (this.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.Y) {
			this.checkConnections1 = Direction.UP;
			this.checkConnections2 = Direction.DOWN;
		} else {
			this.checkConnections1 = Direction.SOUTH;
			this.checkConnections2 = Direction.NORTH;
		}
		
		TileEntity connection = world.getTileEntity(this.getPos().offset(checkConnections1));
		if (connection instanceof LineShaftTileEntity && connection.getBlockState().get(LineShaftBlock.AXIS) == this.getBlockState().get(LineShaftBlock.AXIS) && ((LineShaftTileEntity) connection).getRPM() != this.rpm) {
			((LineShaftTileEntity) world.getTileEntity(this.getPos().offset(checkConnections1))).setRPM(rpm);
		}
		connection = world.getTileEntity(this.getPos().offset(checkConnections2));
		if (connection instanceof LineShaftTileEntity && connection.getBlockState().get(LineShaftBlock.AXIS) == this.getBlockState().get(LineShaftBlock.AXIS) && ((LineShaftTileEntity) connection).getRPM() != this.rpm) {
			((LineShaftTileEntity) world.getTileEntity(this.getPos().offset(checkConnections2))).setRPM(rpm);
		}
	}
	
	public int getRPM() {
		return rpm;
	}
	
	public void setTorque(int torqueIn) {
		torque = torqueIn;
	}
	
	public int getTorque() {
		return torque;
	}
	
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 10, this.getUpdateTag());
	}   
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = world.getBlockState(pos);
		read(blockState, pkt.getNbtCompound());
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.read(blockState, parentNBTTagCompound);
	}
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
	    if (nbt.contains("DisplayItem")) {
//	    	this.setDisplayStack(ItemStack.read(nbt.getCompound("DisplayItem")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
//	    if (!this.getDisplayStack().isEmpty()) {
//	    	compound.put("DisplayItem", this.getDisplayStack().write(new CompoundNBT()));
//	    }	   
	    return compound;	    
	}
}