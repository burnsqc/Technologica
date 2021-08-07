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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

public class LineShaftTileEntity extends TileEntity {
	
	private BlockPos beltPos = null;
	private int rpm = 0;
	private int torque = 0;
	private float ratio;

	public LineShaftTileEntity() {
		super(ModTileEntities.LINE_SHAFT_TILE.get());
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
        MutableBoundingBox mbb = new MutableBoundingBox(getPos(), getPos());
        if (this.getBeltPos() != null)
            mbb.expandTo(new MutableBoundingBox(getBeltPos(), getBeltPos()));
        return AxisAlignedBB.toImmutable(mbb);
    }

	public void setBeltPos(BlockPos posIn) {
		this.beltPos = posIn;
	}
	
	public BlockPos getBeltPos() {
		return this.beltPos;
	}
	
	public void setRPM (int rpmIn) {
		TileEntity connection1 = null;
		TileEntity connection2 = null;
		TileEntity connection3 = null;
		
		this.rpm = rpmIn;

		switch(getBlockState().get(AXIS)) {
		case X:
			connection1 = world.getTileEntity(this.getPos().offset(Direction.EAST));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.WEST));
			break;
		case Y:
			connection1 = world.getTileEntity(this.getPos().offset(Direction.UP));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.DOWN));
			break;
		case Z:
			connection1 = world.getTileEntity(this.getPos().offset(Direction.SOUTH));
			connection2 = world.getTileEntity(this.getPos().offset(Direction.NORTH));
			break;
		}
		
		if (connection1 instanceof LineShaftTileEntity && connection1.getBlockState().get(AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftTileEntity) connection1).getRPM() != this.rpm) {
				((LineShaftTileEntity) connection1).setRPM(this.rpm);
			}
		} else if (connection1 instanceof LineShaftHangerTileEntity && connection1.getBlockState().get(TwelveDirectionBlock.AXIS) == this.getBlockState().get(AXIS)) {
			if (((LineShaftHangerTileEntity) connection1).getRPM() != this.rpm) {
				((LineShaftHangerTileEntity) connection1).setRPM(this.rpm);
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

		if (getBeltPos() != null) {
			connection3 = world.getTileEntity(this.beltPos);
			int mult1;
			int mult2;
			if (this.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
				mult1 = 1;
			} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
				mult1 = 2;
			} else {
				mult1 = 4;
			}
			if (connection3.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
				mult2 = 1;
			} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
				mult2 = 2;
			} else {
				mult2 = 4;
			}

			if (((LineShaftTileEntity) connection3).getRPM() != this.rpm * mult1 / mult2) {
				((LineShaftTileEntity) connection3).setRPM(this.rpm * mult1 / mult2);
			}
		}
	}
	
	public int getRPM() {
		return this.rpm;
	}

	public void setRatio() {
		TileEntity connection = world.getTileEntity(this.beltPos);
		float radius1;
		float radius2;

		if (this.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
			radius1 = 0.25f;
		} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
			radius1 = 0.5f;
		} else {
			radius1 = 1.0f;
		}

		if (connection.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
			radius2 = 0.25f;
		} else if (this.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
			radius2 = 0.5f;
		} else {
			radius2 = 1.0f;
		}

		this.ratio =  radius1-radius2;
	}

	public float getRatio() {
		return this.ratio;
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
		if (nbt.contains("rpm")) {
			this.rpm = nbt.getInt("rpm");
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.beltPos != null) {
			compound.put("BeltPos", NBTUtil.writeBlockPos(this.beltPos));
		}	  
		compound.putInt("rpm", this.rpm);
	    return compound;	    
	}
}
