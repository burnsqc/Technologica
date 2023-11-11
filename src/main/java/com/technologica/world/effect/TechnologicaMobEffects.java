package com.technologica.world.effect;

import static com.technologica.Technologica.MOD_ID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaMobEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.Keys.MOB_EFFECTS, MOD_ID);

	public static int init() {
		MOB_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		return MOB_EFFECTS.getEntries().size();
	}

	public static final RegistryObject<MobEffect> HALLUCINIATION = MOB_EFFECTS.register("hallucination", () -> new HallucinationEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> HEMORRHAGE = MOB_EFFECTS.register("hemorrhage", () -> new HemorrhageEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NECROSIS = MOB_EFFECTS.register("necrosis", () -> new NecrosisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NEUROPATHY = MOB_EFFECTS.register("neuropathy", () -> new NeuropathyEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> PARALYSIS = MOB_EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}