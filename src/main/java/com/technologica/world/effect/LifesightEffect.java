package com.technologica.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class LifesightEffect extends MobEffect {
	public LifesightEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		super.applyEffectTick(pLivingEntity, pAmplifier);
	}

	@Override
	public boolean isDurationEffectTick(int p_19631_, int p_19632_) {
		return true;
	}
}