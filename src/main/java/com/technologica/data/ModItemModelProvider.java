package com.technologica.data;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.items.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void registerModels() {
		simpleItem(ModItems.BANANA);
		simpleItem(ModItems.BLUEBERRY);
		simpleItem(ModItems.CHERRY);
		simpleItem(ModItems.COCONUT);
		simpleItem(ModItems.GRAPE);
		simpleItem(ModItems.KIWI);
		simpleItem(ModItems.LEMON);
		simpleItem(ModItems.LIME);
		simpleItem(ModItems.ORANGE);
		simpleItem(ModItems.PEACH);
		simpleItem(ModItems.PEAR);
		simpleItem(ModItems.STRAWBERRY);
		
		simpleItem(ModItems.BLUEBERRY_SEEDS);
		simpleItem(ModItems.GRAPE_SEEDS);
		simpleItem(ModItems.STRAWBERRY_SEEDS);
		
		simpleItem(ModItems.LITHIUM_INGOT);
		simpleItem(ModItems.BERYLLIUM_INGOT);
		simpleItem(ModItems.SODIUM_INGOT);
		simpleItem(ModItems.MAGNESIUM_INGOT);
		simpleItem(ModItems.ALUMINUM_INGOT);
		simpleItem(ModItems.POTASSIUM_INGOT);
		simpleItem(ModItems.CALCIUM_INGOT);
		simpleItem(ModItems.SCANDIUM_INGOT);
		simpleItem(ModItems.TITANIUM_INGOT);
		simpleItem(ModItems.VANADIUM_INGOT);
		simpleItem(ModItems.CHROMIUM_INGOT);
		simpleItem(ModItems.MANGANESE_INGOT);
		simpleItem(ModItems.COBALT_INGOT);
		simpleItem(ModItems.NICKEL_INGOT);
		simpleItem(ModItems.COPPER_INGOT);
		simpleItem(ModItems.ZINC_INGOT);
		simpleItem(ModItems.GALLIUM_INGOT);
		simpleItem(ModItems.RUBIDIUM_INGOT);
		simpleItem(ModItems.STRONTIUM_INGOT);
		simpleItem(ModItems.YTTRIUM_INGOT);
		simpleItem(ModItems.TECHNETIUM_INGOT);
		simpleItem(ModItems.RUTHENIUM_INGOT);
		simpleItem(ModItems.RHODIUM_INGOT);
		simpleItem(ModItems.PALLADIUM_INGOT);
		simpleItem(ModItems.SILVER_INGOT);
		simpleItem(ModItems.CAESIUM_INGOT);
		simpleItem(ModItems.BARIUM_INGOT);
		simpleItem(ModItems.LUTETIUM_INGOT);
		simpleItem(ModItems.RHENIUM_INGOT);
		simpleItem(ModItems.OSMIUM_INGOT);
		simpleItem(ModItems.IRIDIUM_INGOT);
		simpleItem(ModItems.PLATINUM_INGOT);
		simpleItem(ModItems.FRANCIUM_INGOT);
		simpleItem(ModItems.RADIUM_INGOT);
		simpleItem(ModItems.LAWRENCIUM_INGOT);
		
		simpleItem(ModItems.LITHIUM_CLAY_BALL);
		simpleItem(ModItems.BORON_CHUNK);
		simpleItem(ModItems.CARBON_CHUNK);
		simpleItem(ModItems.SILICON_CHUNK);
		simpleItem(ModItems.PHOSPHORUS_CHUNK);
		simpleItem(ModItems.SULFUR_CHUNK);
		simpleItem(ModItems.GERMANIUM_CHUNK);
		simpleItem(ModItems.ARSENIC_CHUNK);
		simpleItem(ModItems.SELENIUM_CHUNK);
		simpleItem(ModItems.ANTIMONY_CHUNK);
		simpleItem(ModItems.TELLURIUM_CHUNK);
		simpleItem(ModItems.IODINE_CHUNK);
		simpleItem(ModItems.ASTATINE_CHUNK);
		
		simpleItem(ModItems.BRINE_BUCKET);
		
		simpleItem(ModItems.HAMMER);
		simpleItem(ModItems.PIPE_WRENCH);
		simpleItem(ModItems.WRENCH);
		
		simpleItem(ModItems.SMALL_PULLEY_ITEM);
		simpleItem(ModItems.MEDIUM_PULLEY_ITEM);
		simpleItem(ModItems.LARGE_PULLEY_ITEM);
		simpleItem(ModItems.LINE_SHAFT_ITEM);
		
		simpleItem(ModItems.DUCK_SPAWN_EGG);
		simpleItem(ModItems.GRIZZLY_BEAR_SPAWN_EGG);
//		simpleItem(ModItems.OSTRICH_SPAWN_EGG);
//		simpleItem(ModItems.SHARK_SPAWN_EGG);
		simpleItem(ModItems.ZEBRA_SPAWN_EGG);
	}
	
	public void simpleItem(Supplier<? extends Item> itemSupplier) {
		ResourceLocation location = itemSupplier.get().getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
}