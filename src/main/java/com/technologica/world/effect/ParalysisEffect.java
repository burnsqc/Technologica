package com.technologica.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class ParalysisEffect extends MobEffect {

	public ParalysisEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (pLivingEntity instanceof Player) {
			if (FMLEnvironment.dist.isClient()) {
				ClientEffectHandler.handleParalysis();
			}
		}
	}

	@Override
	public boolean isDurationEffectTick(int p_19631_, int p_19632_) {
		return true;
	}
}