package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.effect.HallucinationEffect;
import com.technologica.world.effect.HemorrhageEffect;
import com.technologica.world.effect.NecrosisEffect;
import com.technologica.world.effect.NeuropathyEffect;
import com.technologica.world.effect.ParalysisEffect;
import com.technologica.world.effect.RadiationEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaMobEffects extends MasterDeferredRegistrar {
	
	public static int init() {
		MOB_EFFECTS.register(Technologica.MOD_EVENT_BUS);
		return MOB_EFFECTS.getEntries().size();
	}

	public static final RegistryObject<MobEffect> HALLUCINIATION = MOB_EFFECTS.register("hallucination", () -> new HallucinationEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> HEMORRHAGE = MOB_EFFECTS.register("hemorrhage", () -> new HemorrhageEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NECROSIS = MOB_EFFECTS.register("necrosis", () -> new NecrosisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NEUROPATHY = MOB_EFFECTS.register("neuropathy", () -> new NeuropathyEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> PARALYSIS = MOB_EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}