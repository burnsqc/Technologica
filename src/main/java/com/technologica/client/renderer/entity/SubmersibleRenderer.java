package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.client.model.BiPlaneModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.vehicle.Submersible;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SubmersibleRenderer extends EntityRenderer<Submersible> {
	private static final ResourceLocation BIPLANE_TEXTURE = new TechnologicaLocation("textures/entity/airplane/biplane.png");
	private final ListModel<Submersible> listmodel;

	public SubmersibleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager);
		listmodel = new BiPlaneModel(renderManager.bakeLayer(TechnologicaModelLayers.SUBMERSIBLE));
	}

	@Override
	public ResourceLocation getTextureLocation(Submersible entity) {
		return BIPLANE_TEXTURE;
	}

	@Override
	public void render(Submersible biplane, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		poseStack.pushPose();
		poseStack.translate(0.0F, 0.375F, 0.0F);
		poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
		poseStack.mulPose(Axis.XP.rotationDegrees(-biplane.getXRot()));
		poseStack.mulPose(Axis.ZP.rotationDegrees(-biplane.roll));
		listmodel.setupAnim(biplane, entityYaw, partialTicks, -0.1F, 0.0F, 0.0F);
		poseStack.scale(-1.0F, -1.0F, 1.0F);
		poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
		VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(getTextureLocation(biplane)));
		listmodel.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(biplane, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
}
