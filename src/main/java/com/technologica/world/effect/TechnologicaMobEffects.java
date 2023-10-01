package com.technologica.world.effect;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaMobEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.Keys.MOB_EFFECTS, MODID);

	public static void init() {
		MOB_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("MOB EFFECTS INITIALIZED: " + MOB_EFFECTS.getEntries().size() + " OF 5");
	}

	public static final RegistryObject<MobEffect> HALLUCINIATION = MOB_EFFECTS.register("hallucination", () -> new HallucinationEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> HEMORRHAGE = MOB_EFFECTS.register("hemorrhage", () -> new HemorrhageEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NECROSIS = MOB_EFFECTS.register("necrosis", () -> new NecrosisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> NEUROPATHY = MOB_EFFECTS.register("neuropathy", () -> new NeuropathyEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> PARALYSIS = MOB_EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0));
	public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}