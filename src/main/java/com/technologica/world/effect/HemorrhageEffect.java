package com.technologica.world.effect;

import com.technologica.world.damagesource.TechnologicaDamageSource;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class HemorrhageEffect extends MobEffect {

	public HemorrhageEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		pLivingEntity.hurt(TechnologicaDamageSource.BLEED, 0.1F * (1 + pAmplifier));
	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
}