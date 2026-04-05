package com.technologica.client.renderer.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.CoyoteModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Coyote;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public final class CoyoteRenderer extends TechnologicaMobRenderer<Coyote, CoyoteModel<Coyote>> {
	public CoyoteRenderer(Context context) {
		super(context, new CoyoteModel<>(context.bakeLayer(TechnologicaModelLayers.COYOTE)), TechnologicaMobTextures.COYOTE, 0.5F);
	}

	@Override
	protected float getBob(Coyote coyote, float partialTicks) {
		return coyote.getTailAngle();
	}

	@Override
	public void render(Coyote coyote, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
		if (coyote.isWet()) {
			float f = coyote.getWetShade(partialTicks);
			this.model.setColor(f, f, f);
		}
		super.render(coyote, yaw, partialTicks, poseStack, multiBufferSource, packedLight);
		if (coyote.isWet()) {
			this.model.setColor(1.0F, 1.0F, 1.0F);
		}
	}
}
