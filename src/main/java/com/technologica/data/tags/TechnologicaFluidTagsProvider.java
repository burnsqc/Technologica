package com.technologica.data.tags;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.world.level.material.TechnologicaFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaFluidTagsProvider extends FluidTagsProvider {

	public TechnologicaFluidTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void addTags() {
		automaticFluidTags(TechnologicaFluids.FLUIDS.getEntries());
	}
	
	/**
	 * Iterates through a deferred register of fluids, adding entries to tag files based upon translation key content.
	 * This only works if the translation keys are consistent.  This is really only intended to work for mod fluids which are similar to vanilla.
	 * This saves a lot of time when adding several new fluids. 
	 * @param collection a collection of deferred register fluid entries
	 */
	
	private final void automaticFluidTags(Collection<RegistryObject<Fluid>> collection) {
		for(Supplier<? extends Fluid> fluidSupplier:collection) {
			Fluid fluid = fluidSupplier.get();
			
			if (fluid.getRegistryName().getPath().contains("source") || fluid.getRegistryName().getPath().contains("flowing")) tag(FluidTags.WATER).add(fluid);
		}
	}
}