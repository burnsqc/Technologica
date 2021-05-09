package com.technologica.data;

import com.technologica.fluid.ModFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

public class ModFluidTagsProvider extends FluidTagsProvider {

	public ModFluidTagsProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerTags() {
		getOrCreateBuilder(FluidTags.WATER).add(
				ModFluids.BRINE_SOURCE.get(),
				ModFluids.BRINE_FLOWING.get());
	}
}
