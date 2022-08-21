package com.technologica.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class LineShaftTileEntity extends BlockEntity {
	private BlockPos beltPos = null;
	private float rpm = 0;
	private float torque = 0;
	// Add variable for Manager
	// Load & save manager? Probably not...

	public LineShaftTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.LINE_SHAFT_TILE.get(), p_155700_, p_155701_);
	}

	@Override
	public AABB getRenderBoundingBox() {

		AABB mbb = new AABB(getBlockPos());
		if (this.getBeltPos() != null) {
			AABB mbb2 = new AABB(getBeltPos());
			double minX = Math.min(mbb.minX, mbb2.minX);
			double minY = Math.min(mbb.minY, mbb2.minY);
			double minZ = Math.min(mbb.minZ, mbb2.minZ);
			double maxX = Math.max(mbb.maxX, mbb2.maxX);
			double maxY = Math.max(mbb.maxY, mbb2.maxY);
			double maxZ = Math.max(mbb.maxZ, mbb2.maxZ);
			return new AABB(minX, minY, minZ, maxX, maxY, maxZ);
		}
		return mbb;
	}

	public void setBeltPos(BlockPos posIn) {
		this.beltPos = posIn;
		setChanged();
	}

	public BlockPos getBeltPos() {
		return this.beltPos;
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
		if (nbt.contains("beltPos")) {
			beltPos = NbtUtils.readBlockPos(nbt.getCompound("beltPos"));
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
		if (beltPos != null) {
			compound.put("beltPos", NbtUtils.writeBlockPos(beltPos));
		}
		compound.putFloat("torque", torque);
		compound.putFloat("rpm", rpm);
	}
}
