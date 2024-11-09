package com.technologica.client.renderer;

import com.technologica.Technologica;
import com.technologica.registration.dynamic.TechnologicaDimensionTypes;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public abstract class TechnologicaDimensionSpecialEffects {
	public static final Object2ObjectMap<ResourceLocation, DimensionSpecialEffects> EFFECTS = Util.make(new Object2ObjectArrayMap<>(), (map) -> {
		map.put(TechnologicaDimensionTypes.MOON_EFFECTS, new MoonRenderer(Technologica.getInstance()));
		map.put(TechnologicaDimensionTypes.ABYSS_EFFECTS, new AbyssEffects());
	});

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
