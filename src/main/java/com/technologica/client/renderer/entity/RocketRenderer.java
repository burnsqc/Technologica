package com.technologica.client.renderer.entity;

import java.util.Map;
import java.util.stream.Stream;

import org.joml.Quaternionf;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.technologica.Technologica;
import com.technologica.client.model.VanillaBoatModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.vehicle.Rocket;
import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RocketRenderer extends EntityRenderer<Rocket> {
	private final Map<VanillaBoat.Type, Pair<ResourceLocation, VanillaBoatModel>> boatResources;

	public RocketRenderer(EntityRendererProvider.Context contextIn) {
		super(contextIn);
		this.shadowRadius = 0.8F;
		this.boatResources = Stream.of(VanillaBoat.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
			return p_173938_;
		}, (p_173941_) -> {
			return Pair.of(new ResourceLocation(Technologica.MODID, "textures/entity/boat/" + p_173941_.getName() + ".png"), new VanillaBoatModel(contextIn.bakeLayer(TechnologicaModelLayers.createBoatModelName(p_173941_))));
		}));
	}

	@Override
	public void render(Rocket entityIn, float entityYaw, float partialTicks, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		poseStackIn.pushPose();
		poseStackIn.translate(0.0D, 0.375D, 0.0D);
		poseStackIn.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
		float f = entityIn.getHurtTime() - partialTicks;
		float f1 = entityIn.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}
		if (f > 0.0F) {
			poseStackIn.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * entityIn.getHurtDir()));
		}
		float f2 = entityIn.getBubbleAngle(partialTicks);
		if (!Mth.equal(f2, 0.0F)) {
			poseStackIn.mulPose((new Quaternionf()).setAngleAxis(entityIn.getBubbleAngle(partialTicks) * ((float) Math.PI / 180F), 1.0F, 0.0F, 1.0F));
		}
		poseStackIn.scale(-1.0F, -1.0F, 1.0F);
		poseStackIn.mulPose(Axis.YP.rotationDegrees(90.0F));
		poseStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(Rocket entity) {
		return getModelWithLocation(entity).getFirst();
	}

	@SuppressWarnings("unlikely-arg-type")
	public Pair<ResourceLocation, VanillaBoatModel> getModelWithLocation(Rocket entity) {
		return this.boatResources.get(entity.getVanillaBoatType());
	}
}