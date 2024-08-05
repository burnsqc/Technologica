package com.technologica.api.tlregen.resourcegen;

import net.minecraft.data.PackOutput;

public abstract class TLReGenDataGenerator extends TLReGenMasterResourceGenerator {
	protected final PackOutput.Target target = PackOutput.Target.DATA_PACK;

	@Override
	public String getName() {
		return "data." + super.getName();
	}
}
