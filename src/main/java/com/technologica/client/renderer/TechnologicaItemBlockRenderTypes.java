package com.technologica.client.renderer;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaFluids;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;

public class TechnologicaItemBlockRenderTypes {
	public static final Map<Fluid, RenderType> FLUID_RENDER_TYPES = Maps.newHashMap();

	public static void register(Fluid fluid, RenderType renderType) {
		FLUID_RENDER_TYPES.put(fluid, renderType);
	}

	static {
		register(TechnologicaFluids.HYDROGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_HYDROGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.HELIUM.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_HELIUM.get(), RenderType.translucent());
		register(TechnologicaFluids.NITROGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_NITROGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.OXYGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_OXYGEN.get(), RenderType.translucent());
		register(TechnologicaFluids.FLUORINE.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_FLUORINE.get(), RenderType.translucent());
		register(TechnologicaFluids.NEON.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_NEON.get(), RenderType.translucent());
		register(TechnologicaFluids.CHLORINE.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_CHLORINE.get(), RenderType.translucent());
		register(TechnologicaFluids.ARGON.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_ARGON.get(), RenderType.translucent());
		register(TechnologicaFluids.KRYPTON.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_KRYPTON.get(), RenderType.translucent());
		register(TechnologicaFluids.XENON.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_XENON.get(), RenderType.translucent());
		register(TechnologicaFluids.RADON.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_RADON.get(), RenderType.translucent());
		register(TechnologicaFluids.BROMINE.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_BROMINE.get(), RenderType.translucent());
		register(TechnologicaFluids.BRINE.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_BRINE.get(), RenderType.translucent());
		register(TechnologicaFluids.NATURAL_GAS.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_NATURAL_GAS.get(), RenderType.translucent());
		register(TechnologicaFluids.MAPLE_SYRUP.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_MAPLE_SYRUP.get(), RenderType.translucent());
		register(TechnologicaFluids.RUBBER_RESIN.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_RUBBER_RESIN.get(), RenderType.translucent());
		register(TechnologicaFluids.GASOLINE.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_GASOLINE.get(), RenderType.translucent());
		register(TechnologicaFluids.MACHINE_OIL.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_MACHINE_OIL.get(), RenderType.translucent());
		register(TechnologicaFluids.COOLANT.get(), RenderType.translucent());
		register(TechnologicaFluids.FLOWING_COOLANT.get(), RenderType.translucent());
	}
}
