package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.CoyoteModel;
import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
	private static final ResourceLocation COYOTE_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/coyote.png");

	public CoyoteRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoyoteModel<>(), 0.5F);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float getBob(Coyote livingBase, float partialTicks) {
		return livingBase.getTailRotation();
	}

	public void render(Coyote entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
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
	public ResourceLocation getTextureLocation(Coyote entity) {
		return COYOTE_TEXTURES;

	}
}