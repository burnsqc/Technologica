package com.technologica.world.effect;

import com.technologica.registration.dynamic.TechnologicaDamageTypes;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class HemorrhageEffect extends MobEffect {

	public HemorrhageEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		livingEntity.hurt(livingEntity.level().damageSources().source(TechnologicaDamageTypes.BLEED), 0.1F * (1 + amplifier));
	}

	@Override
	public boolean isDurationEffectTick(int p_19631_, int p_19632_) {
		return true;
	}
}