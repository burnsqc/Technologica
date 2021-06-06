package com.technologica.tileentity;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;
import com.technologica.block.TwelveDirectionBlock;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

public class LineShaftHangerTileEntity extends TileEntity {
	public static final String ITEM_NAME = "Shaft";
	private boolean shaft = false;
	private int rpm = 0;
	private int torque = 0;

	
	public LineShaftHangerTileEntity() {
		super(ModTileEntities.LINE_SHAFT_HANGER_TILE.get());
	}
	
	public void setRPMPos (int rpmIn) {
		TileEntity connection;
		
		this.rpm = rpmIn;
		if (this.getBlockState().get(AXIS) == Direction.Axis.X) {
			connection = world.getTileEntity(this.getPos().offset(Direction.EAST));
		} else if (this.getBlockState().get(AXIS) == Direction.Axis.Y) {
			connection = world.getTileEntity(this.getPos().offset(Direction.UP));
		} else {
			connection = world.getTileEntity(this.getPos().offset(Direction.SOUTH));
		}
		
		if (connection instanceof LineShaftTileEntity && connection.getBlockState().get(AXIS) == this.getBlockState().get(AXIS)) {
			((LineShaftTileEntity) connection).setRPMPos(this.rpm);
		} else if (connection instanceof LineShaftHangerTileEntity && connection.getBlockState().get(TwelveDirectionBlock.AXIS) == this.getBlockState().get(AXIS)) {
			((LineShaftHangerTileEntity) connection).setRPMPos(this.rpm);
		}
	}
	
	public void setRPMNeg (int rpmIn) {
		TileEntity connection;
		
		this.rpm = rpmIn;
		if (this.getBlockState().get(AXIS) == Direction.Axis.X) {
			connection = world.getTileEntity(this.getPos().offset(Direction.WEST));
		} else if (this.getBlockState().get(AXIS) == Direction.Axis.Y) {
			connection = world.getTileEntity(this.getPos().offset(Direction.DOWN));
		} else {
			connection = world.getTileEntity(this.getPos().offset(Direction.NORTH));
		}
		
		if (connection instanceof LineShaftTileEntity && connection.getBlockState().get(AXIS) == this.getBlockState().get(AXIS)) {
			((LineShaftTileEntity) connection).setRPMNeg(this.rpm);
		} else if (connection instanceof LineShaftHangerTileEntity && connection.getBlockState().get(TwelveDirectionBlock.AXIS) == this.getBlockState().get(AXIS)) {
			((LineShaftHangerTileEntity) connection).setRPMNeg(this.rpm);
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
	
	public void setShaft(boolean shaftIn) {
		shaft = shaftIn;
	}
	
	public boolean getShaft() {
		return shaft;
	}
	
	@Override
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
	    if (nbt.contains(ITEM_NAME)) {
	    	this.setShaft(nbt.getBoolean(ITEM_NAME));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
	    compound.putBoolean(ITEM_NAME, this.getShaft());
	    return compound;	    
	}
}
