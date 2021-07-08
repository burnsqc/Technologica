package com.technologica.tileentity;

import javax.annotation.Nullable;

import com.technologica.block.LineShaftBlock;
import com.technologica.block.TwelveDirectionBlock;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

public class LineShaftTileEntity extends TileEntity {
	
	private BlockPos beltPos = null;
	private int rpm = 0;
	private int torque = 0;
	
	public LineShaftTileEntity() {
		super(ModTileEntities.LINE_SHAFT_TILE.get());
	}
	
	public void setBeltPos(BlockPos posIn) {
		this.beltPos = posIn;
	}
	
	public BlockPos getBeltPos() {
		return this.beltPos;
	}
	
	public void setRPMBoth(int rpmIn) {
		this.rpm = rpmIn;
		this.setRPMPos(this.rpm);
		this.setRPMNeg(this.rpm);
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

		renderBeltPosition();
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

		renderBeltPosition();
	}
	
	public int getRPM() {
		return this.rpm;
	}
	
	public void setTorque(int torqueIn) {
		torque = torqueIn;
	}
	
	public int getTorque() {
		return torque;
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
		if (nbt.contains("BeltPos")) {
			this.setBeltPos(NBTUtil.readBlockPos(nbt.getCompound("BeltPos")));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.beltPos != null) {
			compound.put("BeltPos", NBTUtil.writeBlockPos(this.beltPos));
		}	   
	    return compound;	    
	}

	private void renderBeltPosition() {
		TileEntity connection;
		if (this.getBeltPos() != null) {
			assert world != null;
			connection = world.getTileEntity(this.beltPos);
			int mult1;
			int mult2;
			if (this.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
				mult1 = 1;
			} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
				mult1 = 2;
			} else {
				mult1 = 4;
			}
			assert connection != null;
			if (connection.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
				mult2 = 1;
			} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
				mult2 = 2;
			} else {
				mult2 = 4;
			}

			((LineShaftTileEntity) connection).setRPMBoth(this.rpm * mult1 / mult2);
		}
	}
}
