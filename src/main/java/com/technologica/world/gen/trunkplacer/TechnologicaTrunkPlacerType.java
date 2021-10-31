package com.technologica.world.gen.trunkplacer;

import static com.technologica.Technologica.MODID;

import com.technologica.world.gen.foliageplacer.TeardropFoliagePlacer;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaTrunkPlacerType {

	private TechnologicaTrunkPlacerType() {
		// use private constructor to hide default constructor
	}

	private static final DeferredRegister<TrunkPlacerType<?>> TRUNKS = DeferredRegister.create(ForgeRegistries.TRUNK_PLACER_TYPES, MODID);

    public static final RegistryObject<TrunkPlacerType<?>> THREE_WIDE = TRUNKS.register("three_wide_trunk_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));    

	public static void register() {
		TRUNKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
