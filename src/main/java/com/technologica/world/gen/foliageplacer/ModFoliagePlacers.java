package com.technologica.world.gen.foliageplacer;

import static com.technologica.Technologica.MODID;

import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFoliagePlacers {

   private ModFoliagePlacers() {
      // use private constructor to hide default constructor
   }

	private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, MODID);

	public static final RegistryObject<FoliagePlacerType<?>> CONICAL = FOLIAGES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = FOLIAGES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> DISH = FOLIAGES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
    public static final RegistryObject<FoliagePlacerType<?>> PALM = FOLIAGES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
    public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = FOLIAGES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));    
	
	public static void register() 
    {
        FOLIAGES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
    }
}
