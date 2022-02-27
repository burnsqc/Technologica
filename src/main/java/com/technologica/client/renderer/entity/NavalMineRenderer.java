package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.client.model.NavalMineModel;
import com.technologica.world.entity.item.NavalMine;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public final class NavalMineRenderer extends EntityRenderer<NavalMine> {
	private static final ResourceLocation NAVAL_MINE_TEXTURE = new ResourceLocation("textures/block/gray_concrete.png");
	protected final NavalMineModel modelMine = new NavalMineModel();

	public NavalMineRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}

	public void render(NavalMine entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		
		this.modelMine.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(this.modelMine.renderType(this.getTextureLocation(entityIn)));
		this.modelMine.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(NavalMine entity) {
		return NAVAL_MINE_TEXTURE;
	}
}
