package com.technologica.tileentity;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;
import com.technologica.util.Radius;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;

public class LineShaftHangerTileEntity extends TileEntity {
	private boolean shaft = false;
	private float torque = 0;
	private float rpm = 0;
	
	public void setShaft(boolean shaftIn) {
		shaft = shaftIn;
	}
	
	public boolean getShaft() {
		return shaft;
	}
	
	public LineShaftHangerTileEntity() {
		super(TechnologicaTileEntities.LINE_SHAFT_HANGER_TILE.get());
	}
	
	public void setTorque(float torqueIn) {
		torque = torqueIn;
	}
	
	public void subtractTorque(float maxTorque) {
		torque = torque - maxTorque;
		if (torque == 0) {
			rpm = 0;
		}
		setShaftTorqueRPM(torque, rpm);
	}
	
	public float getTorque() {
		return torque;
	}
	
	public void setRPM(float rpmIn) {
		rpm = rpmIn;
	}
	
	public float getRPM() {
		return rpm;
	}
	
	public boolean checkSetShaftTorqueRPM(float maxTorque, float maxRPM) {
		if (maxRPM == rpm) {
			setShaftTorqueRPM(torque + maxTorque, rpm);
			return true;
		} else if (maxTorque > torque) {
			setShaftTorqueRPM(maxTorque, maxRPM);
			return true;
		}
		return false;
	}
	
	public void setShaftTorqueRPM(float torqueIn, float rpmIn) {
		List<TileEntity> shafts = getShafts();
		for(TileEntity shaft:shafts) {
			if (shaft instanceof LineShaftTileEntity) {
				((LineShaftTileEntity) shaft).setTorque(torqueIn);
				((LineShaftTileEntity) shaft).setRPM(rpmIn);
				
				if (((LineShaftTileEntity) shaft).getBeltPos() != null) {
					LineShaftTileEntity beltedPulley = (LineShaftTileEntity) world.getTileEntity(((LineShaftTileEntity) shaft).getBeltPos());
					Radius pulley1 = shaft.getBlockState().get(LineShaftBlock.RADIUS);
					Radius pulley2 = beltedPulley.getBlockState().get(LineShaftBlock.RADIUS);
					
					float torqueMultiplier = pulley2.getRadius()/pulley1.getRadius();
					float rpmMultiplier = pulley1.getRadius()/pulley2.getRadius();
					
					if (((LineShaftTileEntity) beltedPulley).getRPM() != this.rpm*rpmMultiplier) {
						((LineShaftTileEntity) beltedPulley).setShaftTorqueRPM(this.torque*torqueMultiplier, this.rpm*rpmMultiplier);
					}
				}
			} else if (shaft instanceof LineShaftHangerTileEntity) {
				((LineShaftHangerTileEntity) shaft).setTorque(torqueIn);
				((LineShaftHangerTileEntity) shaft).setRPM(rpmIn);
			}
			world.notifyBlockUpdate(shaft.getPos(), shaft.getBlockState(), shaft.getBlockState(), 3);
		}
	}
	
	public List<TileEntity> getShafts() {
		List<TileEntity> shafts = new ArrayList<>();
		shafts.add(this);
		Axis axis = getBlockState().get(AXIS);
		Direction direction1 = Direction.UP;
		Direction direction2 = Direction.DOWN;
		
		switch(axis) {
		case X:
			direction1 = Direction.EAST;
			direction2 = Direction.WEST;
			break;
		case Y:
			direction1 = Direction.UP;
			direction2 = Direction.DOWN;
			break;
		case Z:
			direction1 = Direction.NORTH;
			direction2 = Direction.SOUTH;
			break;
		}
		
		int offset = 1;
		TileEntity shaftCheck = world.getTileEntity(pos.offset(direction1, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().get(AXIS) == getBlockState().get(AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = world.getTileEntity(pos.offset(direction1, offset));	
		}
		
		offset = 1;
		shaftCheck = world.getTileEntity(pos.offset(direction2, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().get(AXIS) == getBlockState().get(AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = world.getTileEntity(pos.offset(direction2, offset));	
		}
		
		return shafts;
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
	    if (nbt.contains("shaft")) {
	    	shaft = nbt.getBoolean("shaft");
	    }
	    if (nbt.contains("torque")) {
			torque = nbt.getFloat("torque");
		}
	    if (nbt.contains("rpm")) {
			rpm = nbt.getFloat("rpm");
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putBoolean("shaft", shaft);
		compound.putFloat("torque", torque);
		compound.putFloat("rpm", rpm);
	    return compound;	    
	}
}
