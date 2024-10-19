package com.technologica.api.tlregen.resourcegen;

import net.minecraft.data.PackOutput;

public abstract class TLReGenAssetGenerator extends MasterResourceGenerator {
	protected final PackOutput.Target target = PackOutput.Target.RESOURCE_PACK;

	@Override
	public String getName() {
		return "assets." + super.getName();
	}
}
