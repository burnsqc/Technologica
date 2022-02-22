package com.technologica.tileentity;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;
import com.technologica.util.Radius;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;

public class LineShaftTileEntity extends TileEntity {
	private BlockPos beltPos = null;
	private float rpm = 0;
	private float torque = 0;

	public LineShaftTileEntity() {
		super(TechnologicaTileEntities.LINE_SHAFT_TILE.get());
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
        MutableBoundingBox mbb = new MutableBoundingBox(getBlockPos(), getBlockPos());
        if (this.getBeltPos() != null)
            mbb.expand(new MutableBoundingBox(getBeltPos(), getBeltPos()));
        return AxisAlignedBB.of(mbb);
    }

	public void setBeltPos(BlockPos posIn) {
		beltPos = posIn;
	}
	
	public BlockPos getBeltPos() {
		return beltPos;
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
	
	public boolean checkSetShaftTorqueRPM(float torqueIn, float rpmIn) {
		if (rpmIn == rpm) {
			setShaftTorqueRPM(torque + torqueIn, rpm);
			return true;
		} else if (torqueIn > torque) {
			setShaftTorqueRPM(torqueIn, rpmIn);
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
	
	public List<TileEntity> getShafts() {
		List<TileEntity> shafts = new ArrayList<>();
		shafts.add(this);
		Axis axis = getBlockState().getValue(AXIS);
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
		TileEntity shaftCheck = level.getBlockEntity(worldPosition.relative(direction1, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(AXIS) == getBlockState().getValue(AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(worldPosition.relative(direction1, offset));	
		}
		
		offset = 1;
		shaftCheck = level.getBlockEntity(worldPosition.relative(direction2, offset));
		
		while((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(AXIS) == getBlockState().getValue(AXIS)) {
			shafts.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(worldPosition.relative(direction2, offset));	
		}
		
		return shafts;
	}
	
	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.worldPosition, 10, this.getUpdateTag());
	}   
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = level.getBlockState(worldPosition);
		load(blockState, pkt.getTag());
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.save(new CompoundNBT());
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.load(blockState, parentNBTTagCompound);
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		if (nbt.contains("beltPos")) {
			beltPos = NBTUtil.readBlockPos(nbt.getCompound("beltPos"));
		}
		if (nbt.contains("torque")) {
			torque = nbt.getFloat("torque");
		}
		if (nbt.contains("rpm")) {
			rpm = nbt.getFloat("rpm");
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		if (beltPos != null) {
			compound.put("beltPos", NBTUtil.writeBlockPos(beltPos));
		}	
		compound.putFloat("torque", torque);
		compound.putFloat("rpm", rpm);
	    return compound;	    
	}
}
