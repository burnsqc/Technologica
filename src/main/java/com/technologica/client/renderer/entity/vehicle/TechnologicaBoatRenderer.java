package com.technologica.client.renderer.entity.vehicle;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.vehicle.TechnologicaBoat;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public final class TechnologicaBoatRenderer extends BoatRenderer {
	private final Map<TechnologicaBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

	public TechnologicaBoatRenderer(Context context, boolean isChestBoat) {
		super(context, isChestBoat);
		this.boatResources = Stream.of(TechnologicaBoat.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> {
			return type;
		}, (type) -> {
			return Pair.of(new TechnologicaLocation(getTextureLocation(type, isChestBoat)), this.createBoatModel(context, type, isChestBoat));
		}));
	}

	private ListModel<Boat> createBoatModel(Context context, TechnologicaBoat.Type type, boolean isChestBoat) {
		ModelLayerLocation modellayerlocation = isChestBoat ? TechnologicaModelLayers.createChestBoatModelName(type) : TechnologicaModelLayers.createBoatModelName(type);
		ModelPart modelpart = context.bakeLayer(modellayerlocation);
		return isChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
	}

	private static String getTextureLocation(TechnologicaBoat.Type type, boolean isChestBoat) {
		return isChestBoat ? "textures/entity/chest_boat/" + type.getName() + ".png" : "textures/entity/boat/" + type.getName() + ".png";
	}

	@Override
	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		if (boat instanceof TechnologicaBoat techologicaBoat) {
			return this.boatResources.get(techologicaBoat.getTechnologicaVariant());
		} else {
			return null;
		}
	}
}
