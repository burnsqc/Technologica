package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.fluid.ModFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModFluidTagsProvider extends FluidTagsProvider {

	public ModFluidTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerTags() {
		getOrCreateBuilder(FluidTags.WATER).add(
				ModFluids.BRINE_SOURCE.get(),
				ModFluids.BRINE_FLOWING.get(),
				ModFluids.MERCURY_SOURCE.get(),
				ModFluids.MERCURY_FLOWING.get());
	}
}