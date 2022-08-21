package com.technologica.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LineShaftHangerTileEntity extends BlockEntity {
	private boolean shaft = false;
	private float torque = 0;
	private float rpm = 0;

	public LineShaftHangerTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.LINE_SHAFT_HANGER_TILE.get(), p_155700_, p_155701_);
	}

	public void setShaft(boolean shaftIn) {
		this.shaft = shaftIn;
		setChanged();
	}

	public boolean getShaft() {
		return shaft;
	}

	public void setTorque(float torqueIn) {
		this.torque = torqueIn;
		setChanged();
	}

	public float getTorque() {
		return this.torque;
	}

	public void setRPM(float rpmIn) {
		this.rpm = rpmIn;
		this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 0);
		setChanged();
	}

	public float getRPM() {
		return this.rpm;
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
