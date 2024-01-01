package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.CoyoteModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoyoteRenderer extends MobRenderer<Coyote, CoyoteModel<Coyote>> {
	private static final ResourceLocation COYOTE_TEXTURE = new TechnologicaLocation("textures/entity/coyote.png");

	public CoyoteRenderer(Context contextIn) {
		super(contextIn, new CoyoteModel<>(contextIn.bakeLayer(TechnologicaModelLayers.COYOTE)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Coyote coyoteIn) {
		return COYOTE_TEXTURE;
	}

	@Override
	protected float getBob(Coyote coyoteIn, float partialTicksIn) {
		return coyoteIn.getTailAngle();
	}

	@Override
	public void render(Coyote coyoteIn, float yawIn, float partialTicksIn, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		if (coyoteIn.isWet()) {
			float f = coyoteIn.getWetShade(partialTicksIn);
			this.model.setColor(f, f, f);
		}
		super.render(coyoteIn, yawIn, partialTicksIn, poseStackIn, bufferIn, packedLightIn);
		if (coyoteIn.isWet()) {
			this.model.setColor(1.0F, 1.0F, 1.0F);
		}
	}
}