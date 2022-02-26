package com.technologica.world.level.block.entity;

import java.util.ArrayList;
import java.util.List;

import com.technologica.util.Radius;
import com.technologica.world.level.block.LineShaftBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class LineShaftHangerTileEntity extends BlockEntity {
	private boolean shaft = false;
	private float torque = 0;
	private float rpm = 0;
	
	public void setShaft(boolean shaftIn) {
		shaft = shaftIn;
	}
	
	public boolean getShaft() {
		return shaft;
	}
	
	public LineShaftHangerTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.LINE_SHAFT_HANGER_TILE.get(), p_155700_, p_155701_);
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
		List<BlockEntity> shafts = getShafts();
		for(BlockEntity shaft:shafts) {
			if (shaft instanceof LineShaftTileEntity) {
				((LineShaftTileEntity) shaft).setTorque(torqueIn);
				((LineShaftTileEntity) shaft).setRPM(rpmIn);
				
				if (((LineShaftTileEntity) shaft).getBeltPos() != null) {
					LineShaftTileEntity beltedPulley = (LineShaftTileEntity) level.getBlockEntity(((LineShaftTileEntity) shaft).getBeltPos());
					Radius pulley1 = shaft.getBlockState().getValue(LineShaftBlock.RADIUS);
					Radius pulley2 = beltedPulley.getBlockState().getValue(LineShaftBlock.RADIUS);
					
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
			level.sendBlockUpdated(shaft.getBlockPos(), shaft.getBlockState(), shaft.getBlockState(), 3);
		}
	}
	
	public List<BlockEntity> getShafts() {
		List<BlockEntity> shafts = new ArrayList<>();
		shafts.add(this);
		Axis axis = getBlockState().getValue(BlockStateProperties.AXIS);
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
		BlockEntity shaftCheck = level.getBlockEntity(worldPosition.relative(direction1, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(BlockStateProperties.AXIS) == getBlockState().getValue(BlockStateProperties.AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(worldPosition.relative(direction1, offset));	
		}
		
		offset = 1;
		shaftCheck = level.getBlockEntity(worldPosition.relative(direction2, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(BlockStateProperties.AXIS) == getBlockState().getValue(BlockStateProperties.AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(worldPosition.relative(direction2, offset));	
		}
		
		return shafts;
	}
	
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}   
	
	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		load(pkt.getTag());
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}
	
	@Override
	public void handleUpdateTag(CompoundTag parentNBTTagCompound) {
		this.load(parentNBTTagCompound);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
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
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putBoolean("shaft", shaft);
		compound.putFloat("torque", torque);
		compound.putFloat("rpm", rpm);    
	}
}
