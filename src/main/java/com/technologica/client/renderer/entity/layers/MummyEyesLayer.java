package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.monster.Mummy;

import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.world.entity.LivingEntity;

public class MummyEyesLayer<T extends LivingEntity> extends EyesLayer<Mummy, ZombieModel<Mummy>> {
	private static final RenderType MUMMY_EYES = RenderType.eyes(new TechnologicaLocation("textures/entity/mummy/mummy_eyes.png"));

	public MummyEyesLayer(RenderLayerParent<Mummy, ZombieModel<Mummy>> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Mummy mummy, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (mummy.getParalyzeCooldown() > 100) {
			super.render(poseStack, multiBufferSource, packedLight, mummy, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
		}
	}

	@Override
	public RenderType renderType() {
		return MUMMY_EYES;
	}
}
