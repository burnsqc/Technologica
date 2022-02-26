package com.technologica.client.model.geom;

import java.util.Set;

import com.google.common.collect.Sets;
import com.technologica.world.entity.vehicle.VanillaBoatEntity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class TechnologicaModelLayers {
	private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
	public static final ModelLayerLocation BEAVER = register("beaver");

	private static ModelLayerLocation register(String p_171294_) {
		return register(p_171294_, "main");
	}

	private static ModelLayerLocation register(String p_171296_, String p_171297_) {
		ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
		if (!ALL_MODELS.add(modellayerlocation)) {
			throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
		} else {
			return modellayerlocation;
		}
	}

	private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
		return new ModelLayerLocation(new ResourceLocation("minecraft", p_171301_), p_171302_);
	}

	public static ModelLayerLocation createBoatModelName(VanillaBoatEntity.Type p_171290_) {
		return createLocation("boat/" + p_171290_.getName(), "main");
	}

}
