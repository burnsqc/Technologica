package com.technologica.util.lineshaftsystem;

import java.util.Set;

import com.technologica.world.level.block.entity.LineShaftBlockEntity;
import com.technologica.world.level.block.entity.LineShaftHangerBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntity;

public class LineShaft {
	private int index;
	private Set<BlockEntity> shaftBlockEntities;
	private boolean visited;
	private float rpm;
	private float torque;

	public LineShaft(Set<BlockEntity> lineShaftBlocks, int indexIn) {
		this.shaftBlockEntities = lineShaftBlocks;
		this.index = indexIn;
	}

	public int getIndex() {
		return this.index;
	}

	public Set<BlockEntity> getShaftBlockEntities() {
		return this.shaftBlockEntities;
	}

	public boolean getVisited() {
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public float getRPM() {
		return this.rpm;
	}

	public void setRPM(float rpm, boolean actuallySet) {
		this.rpm = rpm;
		if (actuallySet) {
			for (BlockEntity shaftBlock : shaftBlockEntities) {
				if (shaftBlock instanceof LineShaftBlockEntity) {
					((LineShaftBlockEntity) shaftBlock).setRPM(rpm);
					((LineShaftBlockEntity) shaftBlock).setTorque(torque);
				} else if (shaftBlock instanceof LineShaftHangerBlockEntity) {
					((LineShaftHangerBlockEntity) shaftBlock).setRPM(rpm);
					((LineShaftHangerBlockEntity) shaftBlock).setTorque(torque);
				}
			}
		}
	}

	public float getTorque() {
		return this.torque;
	}

	public void setTorque(float torque) {
		this.torque = torque;
	}
}
