package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.fluid.TechnologicaFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModFluidTagsProvider extends FluidTagsProvider {

	public ModFluidTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerTags() {
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
			
			if (fluid.getRegistryName().getPath().contains("source") || fluid.getRegistryName().getPath().contains("flowing")) getOrCreateBuilder(FluidTags.WATER).add(fluid);
		}
	}
}