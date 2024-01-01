package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.FigureEightPufferfishBigModel;
import com.technologica.client.model.FigureEightPufferfishMidModel;
import com.technologica.client.model.FigureEightPufferfishSmallModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.FigureEightPufferfish;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FigureEightPufferfishRenderer extends MobRenderer<FigureEightPufferfish, EntityModel<FigureEightPufferfish>> {
	private static final ResourceLocation FIGURE_EIGHT_PUFFERFISH_TEXTURE = new TechnologicaLocation("textures/entity/fish/figure_eight_pufferfish.png");
	private int puffStateO = 3;
	private final EntityModel<FigureEightPufferfish> small;
	private final EntityModel<FigureEightPufferfish> mid;
	private final EntityModel<FigureEightPufferfish> big = this.getModel();

	public FigureEightPufferfishRenderer(Context contextIn) {
		super(contextIn, new FigureEightPufferfishBigModel<>(contextIn.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG)), 0.2F);
		this.mid = new FigureEightPufferfishMidModel<>(contextIn.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM));
		this.small = new FigureEightPufferfishSmallModel<>(contextIn.bakeLayer(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL));
	}

	@Override
	public ResourceLocation getTextureLocation(FigureEightPufferfish figureEightPufferfishIn) {
		return FIGURE_EIGHT_PUFFERFISH_TEXTURE;
	}

	@Override
	public void render(FigureEightPufferfish figureEightPufferfishIn, float yawIn, float partialTicksIn, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		int i = figureEightPufferfishIn.getPuffState();
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
		super.render(figureEightPufferfishIn, yawIn, partialTicksIn, poseStackIn, bufferIn, packedLightIn);
	}

	@Override
	protected void setupRotations(FigureEightPufferfish figureEightPufferfishIn, PoseStack poseStackIn, float rotateXIn, float rotateYIn, float rotateZIn) {
		poseStackIn.translate(0.0D, Mth.cos(rotateXIn * 0.05F) * 0.08F, 0.0D);
		super.setupRotations(figureEightPufferfishIn, poseStackIn, rotateXIn, rotateYIn, rotateZIn);
	}
}