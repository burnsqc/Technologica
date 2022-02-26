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
import com.technologica.world.entity.vehicle.VanillaBoatEntity;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;

public class VanillaBoatRenderer extends EntityRenderer<VanillaBoatEntity> {
	private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/apricot.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/aspen.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/avocado.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/banana.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/cherry.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/chestnut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/cinnamon.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/coconut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/ebony.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/kiwi.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/lemon.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/lime.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/mahogany.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/maple.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/olive.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/orange.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/peach.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/pear.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/plum.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/redwood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/rosewood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/rubber.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/teak.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/walnut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/zebrawood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/alchemical.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/benevolent.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/conductive.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/frostbitten.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/fruitful.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/infernal.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/malevolent.png")};
	private final Map<VanillaBoatEntity.Type, Pair<ResourceLocation, VanillaBoatModel>> boatResources;
	public VanillaBoatRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
		this.shadowRadius = 0.8F;
		this.boatResources = Stream.of(VanillaBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
	         return p_173938_;
	      }, (p_173941_) -> {
	         return Pair.of(new ResourceLocation("textures/entity/boat/" + p_173941_.getName() + ".png"), new VanillaBoatModel(renderManagerIn.bakeLayer(TechnologicaModelLayers.createBoatModelName(p_173941_))));
	      }));
	}

	public void render(VanillaBoatEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.0D, 0.375D, 0.0D);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entityIn.getHurtTime() - partialTicks;
		float f1 = entityIn.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) entityIn.getHurtDir()));
		}

		float f2 = entityIn.getBubbleAngle(partialTicks);
		if (!Mth.equal(f2, 0.0F)) {
			matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entityIn.getBubbleAngle(partialTicks), true));
		}
		Pair<ResourceLocation, VanillaBoatModel> pair = getModelWithLocation(entityIn);
	    ResourceLocation resourcelocation = pair.getFirst();
	    VanillaBoatModel boatmodel = pair.getSecond();

		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
		boatmodel.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(boatmodel.renderType(this.getTextureLocation(entityIn)));
		boatmodel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		if (!entityIn.isUnderWater()) {
			VertexConsumer ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
			boatmodel.waterPatch().render(matrixStackIn, ivertexbuilder1, packedLightIn,
					OverlayTexture.NO_OVERLAY);
		}

		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public Pair<ResourceLocation, VanillaBoatModel> getModelWithLocation(Boat boat) { return this.boatResources.get(boat.getBoatType()); }
	
	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getTextureLocation(VanillaBoatEntity entity) {
		return BOAT_TEXTURES[entity.getVanillaBoatType().ordinal()];
	}
}
