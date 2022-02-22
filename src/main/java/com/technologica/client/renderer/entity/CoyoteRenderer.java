package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.CoyoteModel;
import com.technologica.entity.passive.CoyoteEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CoyoteRenderer extends MobRenderer<CoyoteEntity, CoyoteModel<CoyoteEntity>> {
	private static final ResourceLocation COYOTE_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/coyote.png");

	public CoyoteRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CoyoteModel<>(), 0.5F);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float getBob(CoyoteEntity livingBase, float partialTicks) {
		return livingBase.getTailRotation();
	}

	public void render(CoyoteEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isCoyoteWet()) {
			float f = entityIn.getShadingWhileWet(partialTicks);
			this.model.setColor(f, f, f);
		}

		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		if (entityIn.isCoyoteWet()) {
			this.model.setColor(1.0F, 1.0F, 1.0F);
		}

	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getTextureLocation(CoyoteEntity entity) {
		return COYOTE_TEXTURES;

	}
}