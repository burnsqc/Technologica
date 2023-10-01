package com.technologica.world.effect;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ParalysisEffect extends MobEffect {

	public ParalysisEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (pLivingEntity instanceof Player) {
			KeyMapping.releaseAll();
			Minecraft mc = Minecraft.getInstance();
			mc.mouseHandler.releaseMouse();
		}
	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
}