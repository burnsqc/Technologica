package com.technologica.data;

import com.technologica.MainMod;
import com.technologica.setup.ModSetup;
import com.technologica.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
	
	public ModLanguageProvider(DataGenerator generatorIn) {
		super(generatorIn, MainMod.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addBlock(Registration.BANANA_LEAVES, "Banana Leaves");
		addBlock(Registration.CHERRY_LEAVES, "Cherry Leaves");
		addBlock(Registration.COCONUT_LEAVES, "Coconut Leaves");
		addBlock(Registration.KIWI_LEAVES, "Kiwi Leaves");
		addBlock(Registration.LEMON_LEAVES, "Lemon Leaves");
		addBlock(Registration.LIME_LEAVES, "Lime Leaves");
		addBlock(Registration.ORANGE_LEAVES, "Orange Leaves");
		addBlock(Registration.PEACH_LEAVES, "Peach Leaves");
		addBlock(Registration.PEAR_LEAVES, "Pear Leaves");
		addBlock(Registration.BANANA_LOG, "Banana Log");
		addBlock(Registration.CHERRY_LOG, "Cherry Log");
		addBlock(Registration.COCONUT_LOG, "Coconut Log");
		addBlock(Registration.KIWI_LOG, "Kiwi Log");
		addBlock(Registration.LEMON_LOG, "Lemon Log");
		addBlock(Registration.LIME_LOG, "Lime Log");
		addBlock(Registration.ORANGE_LOG, "Orange Log");
		addBlock(Registration.PEACH_LOG, "Peach Log");
		addBlock(Registration.PEAR_LOG, "Pear Log");
		addBlock(Registration.BANANA_SAPLING, "Banana Sapling");
		addBlock(Registration.CHERRY_SAPLING, "Cherry Sapling");
		addBlock(Registration.COCONUT_SAPLING, "Coconut Sapling");
		addBlock(Registration.KIWI_SAPLING, "Kiwi Sapling");
		addBlock(Registration.LEMON_SAPLING, "Lemon Sapling");
		addBlock(Registration.LIME_SAPLING, "Lime Sapling");
		addBlock(Registration.ORANGE_SAPLING, "Orange Sapling");
		addBlock(Registration.PEACH_SAPLING, "Peach Sapling");
		addBlock(Registration.PEAR_SAPLING, "Pear Sapling");
		addBlock(Registration.LITHIUM_CLAY, "Lithium Clay");
		addBlock(Registration.SALT, "Salt");
		addBlock(Registration.BAUXITE_ORE, "Bauxite Ore");
		addBlock(Registration.BORAX_ORE, "Borax Ore");
		addBlock(Registration.MAGNESITE_ORE, "Magnesite Ore");
		addBlock(Registration.SPODUMENE_ORE, "Spodumene Ore");
		addBlock(Registration.AQUAMARINE_CRYSTAL, "Aquamarine Crystal");
		addBlock(Registration.DOLOMITE_CRYSTAL, "Dolomite Crystal");
		addBlock(Registration.FLUORITE_CRYSTAL, "Fluorite Crystal");
		addBlock(Registration.ULEXITE_CRYSTAL, "Ulexite Crystal");
		addBlock(Registration.FRUITFUL_LEAVES, "Fruitful Leaves");
		addBlock(Registration.ALCHEMICAL_LEAVES, "Alchemical Leaves");
		addBlock(Registration.BENEVOLENT_LEAVES, "Benevolent Leaves");
		addBlock(Registration.MALEVOLENT_LEAVES, "Malevolent Leaves");
		addBlock(Registration.CONDUCTIVE_LEAVES, "Conductive Leaves");
		addBlock(Registration.FROSTBITTEN_LEAVES, "Frostbitten Leaves");
		addBlock(Registration.FRUITFUL_LOG, "Fruitful Log");
		addBlock(Registration.ALCHEMICAL_LOG, "Alchemical Log");
		addBlock(Registration.BENEVOLENT_LOG, "Benevolent Log");
		addBlock(Registration.MALEVOLENT_LOG, "Malevolent Log");
		addBlock(Registration.CONDUCTIVE_LOG, "Conductive Log");
		addBlock(Registration.FROSTBITTEN_LOG, "Frostbitten Log");
		addBlock(Registration.ANCIENT_AMBROSIA_SAPLING, "Ancient Ambrosia Sapling");
		addBlock(Registration.SERENDIPITOUS_APOTHECARY_SAPLING, "Serendipitous Apothecary Sapling");
		addBlock(Registration.BENEVOLENT_APOTHECARY_SAPLING, "Benevolent Apothecary Sapling");
		addBlock(Registration.MALEVOLENT_APOTHECARY_SAPLING, "Malevolent Apothecary Sapling");
		addBlock(Registration.TOWERING_INFERNO_SAPLING, "Towering Inferno Sapling");
		addBlock(Registration.THUNDEROUS_CONDUCTOR_SAPLING, "Thunderous Conductor Sapling");
		addBlock(Registration.CRYOGENIC_SPIRE_SAPLING, "Cryogenic Spire Sapling");
		addBlock(Registration.DISPLAY_CASE, "Display Case");
		addItem(Registration.BANANA, "Banana");
		addItem(Registration.BLUEBERRY, "Blueberries");
		addItem(Registration.CHERRY, "Cherries");
		addItem(Registration.COCONUT, "Coconut");
		addItem(Registration.GRAPE, "Grapes");
		addItem(Registration.KIWI, "Kiwi");
		addItem(Registration.LEMON, "Lemon");
		addItem(Registration.LIME, "Lime");
		addItem(Registration.ORANGE, "Orange");
		addItem(Registration.PEACH, "Peach");
		addItem(Registration.PEAR, "Pear");
		addItem(Registration.STRAWBERRY, "Strawberry");
		addItem(Registration.BLUEBERRY_SEEDS, "Blueberry Seeds");
		addItem(Registration.GRAPE_SEEDS, "Grape Seeds");
		addItem(Registration.STRAWBERRY_SEEDS, "Strawberry Seeds");
		addItem(Registration.LITHIUM_INGOT, "Lithium Ingot");
		addItem(Registration.BERYLLIUM_INGOT, "Beryllium Ingot");
		addItem(Registration.SODIUM_INGOT, "Sodium Ingot");
		addItem(Registration.MAGNESIUM_INGOT, "Magnesium Ingot");
		addItem(Registration.ALUMINUM_INGOT, "Aluminum Ingot");
		addItem(Registration.POTASSIUM_INGOT, "Potassium Ingot");
		addItem(Registration.CALCIUM_INGOT, "Calcium Ingot");
		addItem(Registration.SCANDIUM_INGOT, "Scandium Ingot");
		addItem(Registration.TITANIUM_INGOT, "Titanium Ingot");
		addItem(Registration.CHROMIUM_INGOT, "Chromium Ingot");
		addItem(Registration.CAESIUM_INGOT, "Caesium Ingot");
		addItem(Registration.RUBIDIUM_INGOT, "Rubidium Ingot");
		addItem(Registration.STRONTIUM_INGOT, "Strontium Ingot");
		addItem(Registration.BARIUM_INGOT, "Barium Ingot");
		addItem(Registration.BORON_CHUNK, "Boron Chunk");
		addItem(Registration.CARBON_CHUNK, "Carbon Chunk");
		addItem(Registration.SILICON_CHUNK, "Silicon Chunk");
		addItem(Registration.PHOSPHORUS_CHUNK, "Phosphorus Chunk");
		addItem(Registration.SULFUR_CHUNK, "Sulfur Chunk");
		addItem(Registration.GERMANIUM_CHUNK, "Germanium Chunk");
		addItem(Registration.ARSENIC_CHUNK, "Arsenic Chunk");
		addItem(Registration.SELENIUM_CHUNK, "Selenium Chunk");
		addItem(Registration.ANTIMONY_CHUNK, "Antimony Chunk");
		addItem(Registration.TELLURIUM_CHUNK, "Tellurium Chunk");
		addItem(Registration.IODINE_CHUNK, "Iodine Chunk");
		addItem(Registration.ASTATINE_CHUNK, "Astatine Chunk");
		addItemGroup(ModSetup.TECHNOLOGICA_FOOD, "Food");
		addItemGroup(ModSetup.TECHNOLOGICA_FLORA, "Flora");
		addItemGroup(ModSetup.TECHNOLOGICA_MINERAL, "Mineral");
		addItemGroup(ModSetup.TECHNOLOGICA_CRYPTICA, "Cryptica");
		addItemGroup(ModSetup.TECHNOLOGICA_DECORATIVE, "Decorative");
	}
	
	public void addItemGroup(ItemGroup key, String name) {
		add(key, name);
    }

	private void add(ItemGroup key, String name) {
		add("itemGroup." + key.getPath(), name);	
	}
}