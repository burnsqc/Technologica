package com.technologica.client.renderer;

import java.util.HashMap;

import com.technologica.registration.deferred.TechnologicaFluids;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;

public class TechnologicaItemBlockRenderTypes {
	public static final HashMap<Fluid, RenderType> TYPE_BY_FLUID = new HashMap<Fluid, RenderType>();

	static {
		TYPE_BY_FLUID.put(TechnologicaFluids.HYDROGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_HYDROGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.HELIUM.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_HELIUM.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.NITROGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_NITROGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.OXYGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_OXYGEN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLUORINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_FLUORINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.NEON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_NEON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.CHLORINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_CHLORINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.ARGON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_ARGON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.KRYPTON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_KRYPTON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.XENON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_XENON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.RADON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_RADON.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.BROMINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_BROMINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.BRINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_BRINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.NATURAL_GAS.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_NATURAL_GAS.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.MAPLE_SYRUP.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_MAPLE_SYRUP.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.RUBBER_RESIN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_RUBBER_RESIN.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.GASOLINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_GASOLINE.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.MACHINE_OIL.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_MACHINE_OIL.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.COOLANT.get(), RenderType.translucent());
		TYPE_BY_FLUID.put(TechnologicaFluids.FLOWING_COOLANT.get(), RenderType.translucent());
	}
}
