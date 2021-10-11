package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class SawmillTileEntity extends TileEntity implements ITickableTileEntity {
	private boolean blade = false;
	private ItemStack log = ItemStack.EMPTY;
	private double sawTime = 0;
	private double logPos;
	
	public SawmillTileEntity() {
		super(TechnologicaTileEntities.SAWMILL_TILE.get());
	}

	public boolean getBlade() {
		return blade;
	}

	public void setBlade(boolean bladeIn) {
		blade = bladeIn;
	}

	public ItemStack getLog() {
		return log;
	}

	public void setLog(ItemStack logIn) {
		log = logIn;
		this.sawTime = 100;
	}

	public boolean isSawing() {
	    return this.sawTime > 0;
	}
	
	public double getSawing() {
	    return this.sawTime;
	}
	
	public double getLogPos() {
		return logPos;
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
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound) {
		this.read(blockState, parentNBTTagCompound);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		if (nbt.contains("blade")) {
			blade = nbt.getBoolean("blade");
		}
		if (nbt.contains("sawTime")) {
			this.sawTime = nbt.getDouble("sawTime");
		}
		if (nbt.contains("log")) {
			this.setLog(ItemStack.read(nbt.getCompound("log")));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putBoolean("blade", blade);
		compound.putDouble("sawTime", this.sawTime);
		compound.put("log", this.getLog().write(new CompoundNBT()));
		return compound;
	}

	@Override
	public void tick() {
		if (world.isRemote() && this.sawTime > 0F) {
			logPos = 1.0 - 4.0 * (sawTime / 200);
			sawTime--;
		} else if (!log.isEmpty()) {
			setLog(ItemStack.EMPTY);
		}
	}
}