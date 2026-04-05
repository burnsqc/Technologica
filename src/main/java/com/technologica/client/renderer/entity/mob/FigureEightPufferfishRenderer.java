package com.technologica.client.renderer.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.FigureEightPufferfishBigModel;
import com.technologica.client.model.FigureEightPufferfishMidModel;
import com.technologica.client.model.FigureEightPufferfishSmallModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Pufferfish;

public final class FigureEightPufferfishRenderer extends TechnologicaMobRenderer<Pufferfish, EntityModel<Pufferfish>> {
	private int puffStateO = 3;
	private final EntityModel<Pufferfish> small;
	private final EntityModel<Pufferfish> mid;
	private final EntityModel<Pufferfish> big = this.getModel();

	public FigureEightPufferfishRenderer(Context context) {
		super(context, new FigureEightPufferfishBigModel<>(context.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG)), TechnologicaMobTextures.FIGURE_EIGHT_PUFFERFISH, 0.2F);
		this.mid = new FigureEightPufferfishMidModel<>(context.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM));
		this.small = new FigureEightPufferfishSmallModel<>(context.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL));
	}

	@Override
	public void render(Pufferfish figureEightPufferfish, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
		int i = figureEightPufferfish.getPuffState();
		if (i != this.puffStateO) {
			if (i == 0) {
				this.model = this.small;
			} else if (i == 1) {
				this.model = this.mid;
			} else {
				this.model = this.big;
			}
		}
		this.puffStateO = i;
		this.shadowRadius = 0.1F + 0.1F * i;
		super.render(figureEightPufferfish, yaw, partialTicks, poseStack, multiBufferSource, packedLight);
	}

	@Override
	protected void setupRotations(Pufferfish figureEightPufferfish, PoseStack poseStack, float ageInTicks, float yaw, float partialTicks) {
		poseStack.translate(0.0D, Mth.cos(ageInTicks * 0.05F) * 0.08F, 0.0D);
		super.setupRotations(figureEightPufferfish, poseStack, ageInTicks, yaw, partialTicks);
	}
}
