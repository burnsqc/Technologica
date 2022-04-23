package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.client.model.CoyoteModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
	private static final ResourceLocation COYOTE_TEXTURES = new ResourceLocation(Technologica.MODID, "textures/entity/coyote.png");

	public CoyoteRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoyoteModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.COYOTE)), 0.5F);
	}

	@Override
	protected float getBob(Coyote livingBase, float partialTicks) {
		return livingBase.getTailAngle();
	}

	@Override
	public void render(Coyote entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		if (entityIn.isWet()) {
			float f = entityIn.getWetShade(partialTicks);
			this.model.setColor(f, f, f);
		}

		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		if (entityIn.isWet()) {
			this.model.setColor(1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public ResourceLocation getTextureLocation(Coyote entity) {
		return COYOTE_TEXTURES;
	}
}