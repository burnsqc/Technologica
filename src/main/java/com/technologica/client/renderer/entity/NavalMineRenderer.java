package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.client.renderer.entity.model.NavalMineModel;
import com.technologica.entity.item.NavalMineEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public final class NavalMineRenderer extends EntityRenderer<NavalMineEntity> {
	private static final ResourceLocation NAVAL_MINE_TEXTURE = new ResourceLocation("textures/block/gray_concrete.png");
	protected final NavalMineModel modelMine = new NavalMineModel();

	public NavalMineRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	public void render(NavalMineEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		
		this.modelMine.setRotationAngles(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.modelMine.getRenderType(this.getEntityTexture(entityIn)));
		this.modelMine.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(NavalMineEntity entity) {
		return NAVAL_MINE_TEXTURE;
	}
}
