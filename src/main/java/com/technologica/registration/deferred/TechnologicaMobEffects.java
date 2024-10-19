package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.effect.HallucinationEffect;
import com.technologica.world.effect.HemorrhageEffect;
import com.technologica.world.effect.NecrosisEffect;
import com.technologica.world.effect.NeuropathyEffect;
import com.technologica.world.effect.ParalysisEffect;
import com.technologica.world.effect.RadiationEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaMobEffects {
	public static final RegistryObject<MobEffect> HALLUCINIATION = Technologica.MOB_EFFECTS.register("hallucination", () -> new HallucinationEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> HEMORRHAGE = Technologica.MOB_EFFECTS.register("hemorrhage", () -> new HemorrhageEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> LIFESIGHT = Technologica.MOB_EFFECTS.register("lifesight", () -> new NecrosisEffect(MobEffectCategory.BENEFICIAL, 0));
	public static final RegistryObject<MobEffect> NECROSIS = Technologica.MOB_EFFECTS.register("necrosis", () -> new NecrosisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NEUROPATHY = Technologica.MOB_EFFECTS.register("neuropathy", () -> new NeuropathyEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> PARALYSIS = Technologica.MOB_EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> RADIATION = Technologica.MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}
