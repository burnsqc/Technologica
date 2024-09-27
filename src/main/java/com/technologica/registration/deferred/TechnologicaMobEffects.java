package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.effect.HallucinationEffect;
import com.technologica.world.effect.HemorrhageEffect;
import com.technologica.world.effect.NecrosisEffect;
import com.technologica.world.effect.NeuropathyEffect;
import com.technologica.world.effect.ParalysisEffect;
import com.technologica.world.effect.RadiationEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Mob Effects.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaMobEffects extends MasterDeferredRegistrar {
	public static final RegistryObject<MobEffect> HALLUCINIATION = MOB_EFFECTS.register("hallucination", () -> new HallucinationEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> HEMORRHAGE = MOB_EFFECTS.register("hemorrhage", () -> new HemorrhageEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> LIFESIGHT = MOB_EFFECTS.register("lifesight", () -> new NecrosisEffect(MobEffectCategory.BENEFICIAL, 0));
	public static final RegistryObject<MobEffect> NECROSIS = MOB_EFFECTS.register("necrosis", () -> new NecrosisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NEUROPATHY = MOB_EFFECTS.register("neuropathy", () -> new NeuropathyEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> PARALYSIS = MOB_EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}
