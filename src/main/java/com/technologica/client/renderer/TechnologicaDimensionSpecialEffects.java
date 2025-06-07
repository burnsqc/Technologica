package com.technologica.client.renderer;

import java.util.HashMap;

import com.technologica.Technologica;
import com.technologica.registration.dynamic.TechnologicaDimensionTypes;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class TechnologicaDimensionSpecialEffects {
	public static final HashMap<ResourceLocation, DimensionSpecialEffects> DIMENSION_SPECIAL_EFFECTS = new HashMap<ResourceLocation, DimensionSpecialEffects>();

	static {
		DIMENSION_SPECIAL_EFFECTS.put(TechnologicaDimensionTypes.MOON_EFFECTS, new MoonRenderer(Technologica.getInstance()));
		DIMENSION_SPECIAL_EFFECTS.put(TechnologicaDimensionTypes.ABYSS_EFFECTS, new AbyssEffects());
	}

	public static class AbyssEffects extends DimensionSpecialEffects {
		public AbyssEffects() {
			super(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false);
		}

		@Override
		public Vec3 getBrightnessDependentFogColor(Vec3 p_108901_, float p_108902_) {
			return p_108901_;
		}

		@Override
		public boolean isFoggyAt(int p_108898_, int p_108899_) {
			return false;
		}
	}
}
