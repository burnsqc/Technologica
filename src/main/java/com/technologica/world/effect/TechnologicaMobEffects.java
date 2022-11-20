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
		LOGGER.info("MOB EFFECTS INITIALIZED: " + MOB_EFFECTS.getEntries().size() + " OF 1");
	}

	public static final RegistryObject<MobEffect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(MobEffectCategory.HARMFUL, 0));
}