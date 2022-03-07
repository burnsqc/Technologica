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
		this.tag(FluidTags.WATER).add(TechnologicaFluids.HYDROGEN.get(), TechnologicaFluids.FLOWING_HYDROGEN.get(), TechnologicaFluids.HELIUM.get(), TechnologicaFluids.FLOWING_HELIUM.get(), TechnologicaFluids.NITROGEN.get(), TechnologicaFluids.FLOWING_NITROGEN.get(), TechnologicaFluids.OXYGEN.get(), TechnologicaFluids.FLOWING_OXYGEN.get(),  TechnologicaFluids.FLUORINE.get(), TechnologicaFluids.FLOWING_FLUORINE.get(), TechnologicaFluids.NEON.get(), TechnologicaFluids.FLOWING_NEON.get(), TechnologicaFluids.CHLORINE.get(), TechnologicaFluids.FLOWING_CHLORINE.get(), TechnologicaFluids.ARGON.get(), TechnologicaFluids.FLOWING_ARGON.get(), TechnologicaFluids.KRYPTON.get(), TechnologicaFluids.FLOWING_KRYPTON.get(), TechnologicaFluids.XENON.get(), TechnologicaFluids.FLOWING_XENON.get(), TechnologicaFluids.RADON.get(), TechnologicaFluids.FLOWING_RADON.get(), TechnologicaFluids.BROMINE.get(), TechnologicaFluids.FLOWING_BROMINE.get(), TechnologicaFluids.MERCURY.get(), TechnologicaFluids.FLOWING_MERCURY.get(), TechnologicaFluids.BRINE.get(), TechnologicaFluids.FLOWING_BRINE.get(), TechnologicaFluids.OIL.get(), TechnologicaFluids.FLOWING_OIL.get(), TechnologicaFluids.NATURAL_GAS.get(), TechnologicaFluids.FLOWING_NATURAL_GAS.get(), TechnologicaFluids.MAPLE_SYRUP.get(), TechnologicaFluids.FLOWING_MAPLE_SYRUP.get(), TechnologicaFluids.RUBBER_RESIN.get(), TechnologicaFluids.FLOWING_RUBBER_RESIN.get(), TechnologicaFluids.GASOLINE.get(), TechnologicaFluids.FLOWING_GASOLINE.get(),  TechnologicaFluids.MACHINE_OIL.get(), TechnologicaFluids.FLOWING_MACHINE_OIL.get(), TechnologicaFluids.COOLANT.get(), TechnologicaFluids.FLOWING_COOLANT.get());
	}
}