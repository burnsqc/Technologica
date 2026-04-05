package com.technologica.client.renderer.entity.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.client.model.NavalMineModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.item.NavalMine;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public final class NavalMineRenderer extends EntityRenderer<NavalMine> {
	private static final ResourceLocation TEXTURE = new TechnologicaLocation("textures/entity/naval_mine.png");
	protected final NavalMineModel modelMine;

	public NavalMineRenderer(Context context) {
		super(context);
		this.modelMine = new NavalMineModel(context.bakeLayer(TechnologicaModelLayers.NAVAL_MINE));
	}

	@Override
	public ResourceLocation getTextureLocation(NavalMine navalMine) {
		return TEXTURE;
	}

	@Override
	public void render(NavalMine navalMine, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
		poseStack.pushPose();
		this.modelMine.setupAnim(navalMine, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer ivertexbuilder = multiBufferSource.getBuffer(this.modelMine.renderType(this.getTextureLocation(navalMine)));
		this.modelMine.renderToBuffer(poseStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(navalMine, yaw, partialTicks, poseStack, multiBufferSource, packedLight);
	}
}
