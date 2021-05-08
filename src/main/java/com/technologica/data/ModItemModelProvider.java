package com.technologica.data;

import java.util.function.Supplier;

import com.technologica.MainMod;
import com.technologica.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, MainMod.MODID, helperIn);
	}
	
	@Override
	protected void registerModels() {
		simpleItem(Registration.BANANA);
		simpleItem(Registration.BLUEBERRY);
		simpleItem(Registration.CHERRY);
		simpleItem(Registration.COCONUT);
		simpleItem(Registration.GRAPE);
		simpleItem(Registration.KIWI);
		simpleItem(Registration.LEMON);
		simpleItem(Registration.LIME);
		simpleItem(Registration.ORANGE);
		simpleItem(Registration.PEACH);
		simpleItem(Registration.PEAR);
		simpleItem(Registration.STRAWBERRY);
		
		simpleItem(Registration.BLUEBERRY_SEEDS);
		simpleItem(Registration.GRAPE_SEEDS);
		simpleItem(Registration.STRAWBERRY_SEEDS);
		
		simpleItem(Registration.LITHIUM_INGOT);
		simpleItem(Registration.BERYLLIUM_INGOT);
		simpleItem(Registration.SODIUM_INGOT);
		simpleItem(Registration.MAGNESIUM_INGOT);
		simpleItem(Registration.ALUMINUM_INGOT);
		simpleItem(Registration.POTASSIUM_INGOT);
		simpleItem(Registration.CALCIUM_INGOT);
		simpleItem(Registration.SCANDIUM_INGOT);
		simpleItem(Registration.TITANIUM_INGOT);
		simpleItem(Registration.VANADIUM_INGOT);
		simpleItem(Registration.CHROMIUM_INGOT);
		simpleItem(Registration.MANGANESE_INGOT);
		simpleItem(Registration.COBALT_INGOT);
		simpleItem(Registration.NICKEL_INGOT);
		simpleItem(Registration.COPPER_INGOT);
		simpleItem(Registration.ZINC_INGOT);
		simpleItem(Registration.GALLIUM_INGOT);
		simpleItem(Registration.RUBIDIUM_INGOT);
		simpleItem(Registration.STRONTIUM_INGOT);
		simpleItem(Registration.YTTRIUM_INGOT);
		simpleItem(Registration.TECHNETIUM_INGOT);
		simpleItem(Registration.RUTHENIUM_INGOT);
		simpleItem(Registration.RHODIUM_INGOT);
		simpleItem(Registration.PALLADIUM_INGOT);
		simpleItem(Registration.SILVER_INGOT);
		simpleItem(Registration.CAESIUM_INGOT);
		simpleItem(Registration.BARIUM_INGOT);
		simpleItem(Registration.LUTETIUM_INGOT);
		simpleItem(Registration.RHENIUM_INGOT);
		simpleItem(Registration.OSMIUM_INGOT);
		simpleItem(Registration.IRIDIUM_INGOT);
		simpleItem(Registration.PLATINUM_INGOT);
		simpleItem(Registration.FRANCIUM_INGOT);
		simpleItem(Registration.RADIUM_INGOT);
		simpleItem(Registration.LAWRENCIUM_INGOT);
		
		simpleItem(Registration.LITHIUM_CLAY_BALL);
		simpleItem(Registration.BORON_CHUNK);
		simpleItem(Registration.CARBON_CHUNK);
		simpleItem(Registration.SILICON_CHUNK);
		simpleItem(Registration.PHOSPHORUS_CHUNK);
		simpleItem(Registration.SULFUR_CHUNK);
		simpleItem(Registration.GERMANIUM_CHUNK);
		simpleItem(Registration.ARSENIC_CHUNK);
		simpleItem(Registration.SELENIUM_CHUNK);
		simpleItem(Registration.ANTIMONY_CHUNK);
		simpleItem(Registration.TELLURIUM_CHUNK);
		simpleItem(Registration.IODINE_CHUNK);
		simpleItem(Registration.ASTATINE_CHUNK);
		
//		simpleItem(Registration.DUCK_SPAWN_EGG);
//		simpleItem(Registration.GRIZZLY_BEAR_SPAWN_EGG);
//		simpleItem(Registration.SHARK_SPAWN_EGG);
//		simpleItem(Registration.ZEBRA_SPAWN_EGG);
	}
	
	public void simpleItem(Supplier<? extends Item> itemSupplier) {
		ResourceLocation location = itemSupplier.get().getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
}