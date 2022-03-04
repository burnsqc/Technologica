package com.technologica.data.tags;

import com.technologica.Technologica;
import com.technologica.world.level.material.TechnologicaFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaFluidTagsProvider extends FluidTagsProvider {

	public TechnologicaFluidTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void addTags() {
		this.tag(FluidTags.WATER).add(TechnologicaFluids.HYDROGEN.get(), TechnologicaFluids.FLOWING_HYDROGEN.get(), TechnologicaFluids.HELIUM.get(), TechnologicaFluids.FLOWING_HELIUM.get()); //Add rest of Technologica fluids to this tag
	}
}