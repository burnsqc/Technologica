package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.AxemanModel;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Axeman;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.world.entity.LivingEntity;

public class AxemanEyesLayer<T extends LivingEntity> extends EyesLayer<Axeman, AxemanModel<Axeman>> {
	private static final RenderType AXEMAN_EYES = RenderType.eyes(new TechnologicaLocation("textures/entity/axeman_eyes.png"));

	public AxemanEyesLayer(RenderLayerParent<Axeman, AxemanModel<Axeman>> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Axeman axeman, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		super.render(poseStack, multiBufferSource, packedLight, axeman, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public RenderType renderType() {
		return AXEMAN_EYES;
	}
}
