package com.technologica.tileentity;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

import javax.annotation.Nullable;

import com.technologica.block.TwelveDirectionBlock;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

public class LineShaftHangerTileEntity extends TileEntity {
	public static final String ITEM_NAME = "Shaft";
	private boolean shaft = false;
	private int rpm = 0;
	private int torque = 0;

	
	public LineShaftHangerTileEntity() {
		super(ModTileEntities.LINE_SHAFT_HANGER_TILE.get());
	}
	
	public void setRPM (int rpmIn) {
		TileEntity connection3 = null;
		TileEntity connection2 = null;
		
		this.rpm = rpmIn;

		switch(getBlockState().get(AXIS)) {
		case X:
			connection3 = world.getTileEntity(this.getPos().offset(Direction.EAST));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.WEST));
			break;
		case Y:
			connection3 = world.getTileEntity(this.getPos().offset(Direction.UP));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.DOWN));
			break;
		case Z:
			connection3 = world.getTileEntity(this.getPos().offset(Direction.SOUTH));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.NORTH));
			break;
		}
		
		if (connection3 instanceof LineShaftTileEntity && connection3.getBlockState().get(AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftTileEntity) connection3).getRPM() != this.rpm) {
				((LineShaftTileEntity) connection3).setRPM(this.rpm);
			}
		} else if (connection3 instanceof LineShaftHangerTileEntity && connection3.getBlockState().get(TwelveDirectionBlock.AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftHangerTileEntity) connection3).getRPM() != this.rpm) {
				((LineShaftHangerTileEntity) connection3).setRPM(this.rpm);
			}
		}
		
		if (connection2 instanceof LineShaftTileEntity && connection2.getBlockState().get(AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftTileEntity) connection2).getRPM() != this.rpm) {
				((LineShaftTileEntity) connection2).setRPM(this.rpm);
			}
		} else if (connection2 instanceof LineShaftHangerTileEntity && connection2.getBlockState().get(TwelveDirectionBlock.AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftHangerTileEntity) connection2).getRPM() != this.rpm) {
				((LineShaftHangerTileEntity) connection2).setRPM(this.rpm);
			}
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
