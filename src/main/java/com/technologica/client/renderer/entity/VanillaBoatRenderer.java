package com.technologica.client.renderer.entity;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.technologica.Technologica;
import com.technologica.client.model.VanillaBoatModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class VanillaBoatRenderer extends EntityRenderer<VanillaBoat> {
	private final Map<VanillaBoat.Type, Pair<ResourceLocation, VanillaBoatModel>> boatResources;
	
	public VanillaBoatRenderer(EntityRendererProvider.Context contextIn) {
		super(contextIn);
		this.shadowRadius = 0.8F;
		this.boatResources = Stream.of(VanillaBoat.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
	         return p_173938_;
	      }, (p_173941_) -> {
	         return Pair.of(new ResourceLocation(Technologica.MODID, "textures/entity/boat/" + p_173941_.getName() + ".png"), new VanillaBoatModel(contextIn.bakeLayer(TechnologicaModelLayers.createBoatModelName(p_173941_))));
	      }));
	}

	public void render(VanillaBoat entityIn, float entityYaw, float partialTicks, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		poseStackIn.pushPose();
		poseStackIn.translate(0.0D, 0.375D, 0.0D);
		poseStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entityIn.getHurtTime() - partialTicks;
		float f1 = entityIn.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			poseStackIn.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) entityIn.getHurtDir()));
		}

		float f2 = entityIn.getBubbleAngle(partialTicks);
		if (!Mth.equal(f2, 0.0F)) {
			poseStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entityIn.getBubbleAngle(partialTicks), true));
		}
		
		Pair<ResourceLocation, VanillaBoatModel> pair = getModelWithLocation(entityIn);
		ResourceLocation resourcelocation = pair.getFirst();
	    VanillaBoatModel boatmodel = pair.getSecond();
		poseStackIn.scale(-1.0F, -1.0F, 1.0F);
		poseStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
		boatmodel.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(boatmodel.renderType(resourcelocation));
		boatmodel.renderToBuffer(poseStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		if (!entityIn.isUnderWater()) {
			VertexConsumer ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
			boatmodel.waterPatch().render(poseStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.NO_OVERLAY);
		}

		poseStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getTextureLocation(VanillaBoat entity) {
		return getModelWithLocation(entity).getFirst();
	}
	
	public Pair<ResourceLocation, VanillaBoatModel> getModelWithLocation(VanillaBoat boat) { 
		return this.boatResources.get(boat.getVanillaBoatType()); 
	}
}
