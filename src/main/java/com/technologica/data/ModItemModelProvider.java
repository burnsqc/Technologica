package com.technologica.data;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.item.ModItems;

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
		simpleItem(ModItems.ASPARAGUS);
		simpleItem(ModItems.BANANA);
		simpleItem(ModItems.BARLEY);
		simpleItem(ModItems.BLACKBERRY);
		simpleItem(ModItems.BLUEBERRY);
		simpleItem(ModItems.BROCCOLI);
		simpleItem(ModItems.CELERY);
		simpleItem(ModItems.CHERRY);
		simpleItem(ModItems.COCONUT);
		simpleItem(ModItems.GRAPE);
		simpleItem(ModItems.KIWI);
		simpleItem(ModItems.LEMON);
		simpleItem(ModItems.LIME);
		simpleItem(ModItems.OATS);
		simpleItem(ModItems.ORANGE);
		simpleItem(ModItems.PEACH);
		simpleItem(ModItems.PEAR);
		simpleItem(ModItems.RASPBERRY);
		simpleItem(ModItems.RYE);
		simpleItem(ModItems.STRAWBERRY);
		
		simpleItem(ModItems.BANANAS_FOSTER);
		simpleItem(ModItems.BLACK_FOREST_CAKE);
		simpleItem(ModItems.BLUEBERRY_CHEESECAKE);
		simpleItem(ModItems.COCONUT_CREAM_PIE);
		simpleItem(ModItems.GRAPE_SHAVED_ICE);
		simpleItem(ModItems.KEY_LIME_MOUSSE);
		simpleItem(ModItems.KIWI_SORBET);
		simpleItem(ModItems.LEMON_BAR);
		simpleItem(ModItems.ORANGE_DREAMSICLE);
		simpleItem(ModItems.PEACH_COBBLER);
		simpleItem(ModItems.PEAR_TART);
		simpleItem(ModItems.STRAWBERRY_SHORTCAKE);
		
		simpleItem(ModItems.ASPARAGUS_SEEDS);
		simpleItem(ModItems.BARLEY_SEEDS);
		simpleItem(ModItems.BLACKBERRY_SEEDS);
		simpleItem(ModItems.BLUEBERRY_SEEDS);
		simpleItem(ModItems.BROCCOLI_SEEDS);
		simpleItem(ModItems.CELERY_SEEDS);
		simpleItem(ModItems.GRAPE_SEEDS);
		simpleItem(ModItems.OATS_SEEDS);
		simpleItem(ModItems.RASPBERRY_SEEDS);
		simpleItem(ModItems.RYE_SEEDS);
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
		simpleItem(ModItems.STEEL_SHAFT);
		simpleItem(ModItems.PULLEY_BELT);
		simpleItem(ModItems.DUCK_SPAWN_EGG);
		simpleItem(ModItems.GRIZZLY_BEAR_SPAWN_EGG);
		simpleItem(ModItems.OSTRICH_SPAWN_EGG);
		simpleItem(ModItems.SHARK_SPAWN_EGG);
		simpleItem(ModItems.ZEBRA_SPAWN_EGG);
	}
	
	public void simpleItem(Supplier<? extends Item> itemSupplier) {
		ResourceLocation location = itemSupplier.get().getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
}