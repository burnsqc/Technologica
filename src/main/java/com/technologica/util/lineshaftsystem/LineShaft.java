package com.technologica.util.lineshaftsystem;

import java.util.List;

import net.minecraft.world.level.block.entity.BlockEntity;

public class LineShaft {
	private int index;
	public List<BlockEntity> shaftList;
	private float rpm = 0;
	private float torque = 0;

	public LineShaft(List<BlockEntity> listIn, int indexIn) {
		this.shaftList = listIn;
		this.index = indexIn;
	}

	public int getIndex() {
		return this.index;
	}

	public float getRPM() {
		return this.rpm;
	}

	public void setRPM(float rpmIn) {
		this.rpm = rpmIn;
	}

	public void setTorque(float torqueIn) {
		this.torque = torqueIn;
	}

	public float getTorque() {
		return this.torque;
	}
}