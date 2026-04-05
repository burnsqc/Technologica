package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.ScorpionModel;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.animal.Scorpion;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.world.entity.LivingEntity;

public class ScorpionEyesLayer<T extends LivingEntity> extends EyesLayer<Scorpion, ScorpionModel<Scorpion>> {
	private static final RenderType SCORPION_EYES = RenderType.eyes(new TechnologicaLocation("textures/entity/scorpion_eyes.png"));

	public ScorpionEyesLayer(RenderLayerParent<Scorpion, ScorpionModel<Scorpion>> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Scorpion scorpion, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		super.render(poseStack, multiBufferSource, packedLight, scorpion, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public RenderType renderType() {
		return SCORPION_EYES;
	}
}
