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
	private static final RenderType MUMMY_EYES = RenderType.eyes(new TechnologicaLocation("textures/entity/axeman_eyes.png"));

	public AxemanEyesLayer(RenderLayerParent<Axeman, AxemanModel<Axeman>> p_116964_) {
		super(p_116964_);
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Axeman mummyIn, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
		super.render(matrixStackIn, bufferIn, packedLightIn, mummyIn, p_116987_, p_116988_, p_116989_, p_116990_, p_116991_, p_116992_);
	}

	@Override
	public RenderType renderType() {
		return MUMMY_EYES;
	}
}