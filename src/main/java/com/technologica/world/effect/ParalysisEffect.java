package com.technologica.world.effect;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ParalysisEffect extends MobEffect {

	public ParalysisEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (pLivingEntity instanceof LocalPlayer) {
			ClientEffectHandler.handleParlysis();
		}
	}

	@Override
	public boolean isDurationEffectTick(int p_19631_, int p_19632_) {
		return true;
	}
}