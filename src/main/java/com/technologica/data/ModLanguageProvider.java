package com.technologica.data;

import com.technologica.MainMod;
import com.technologica.setup.ModItemGroup;
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
		addBlock(Registration.CHROMITE_ORE, "Chromite Ore");
		addBlock(Registration.ILMENITE_ORE, "Ilmenite Ore");
		addBlock(Registration.PYROLUSITE_ORE, "Pyrolusite Ore");
		addBlock(Registration.COBALTITE_ORE, "Cobaltite Ore");
		addBlock(Registration.GARNIERITE_ORE, "Garnierite Ore");
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
		addItem(Registration.VANADIUM_INGOT, "Vanadium Ingot");
		addItem(Registration.CHROMIUM_INGOT, "Chromium Ingot");
		addItem(Registration.MANGANESE_INGOT, "Manganese Ingot");
		addItem(Registration.COBALT_INGOT, "Cobalt Ingot");
		addItem(Registration.NICKEL_INGOT, "Nickel Ingot");
		addItem(Registration.COPPER_INGOT, "Copper Ingot");
		addItem(Registration.ZINC_INGOT, "Zinc Ingot");
		addItem(Registration.GALLIUM_INGOT, "Gallium Ingot");
		addItem(Registration.RUBIDIUM_INGOT, "Rubidium Ingot");
		addItem(Registration.STRONTIUM_INGOT, "Strontium Ingot");
		addItem(Registration.YTTRIUM_INGOT, "Yttrium Ingot");
		addItem(Registration.ZIRCONIUM_INGOT, "Zirconium Ingot");
		addItem(Registration.NIOBIUM_INGOT, "Niobium Ingot");
		addItem(Registration.MOLYBDENUM_INGOT, "Molybdenum Ingot");
		addItem(Registration.TECHNETIUM_INGOT, "Technetium Ingot");
		addItem(Registration.RUTHENIUM_INGOT, "Ruthenium Ingot");
		addItem(Registration.RHODIUM_INGOT, "Rhodium Ingot");
		addItem(Registration.PALLADIUM_INGOT, "Palladium Ingot");
		addItem(Registration.SILVER_INGOT, "Silver Ingot");
		addItem(Registration.CADMIUM_INGOT, "Cadmium Ingot");
		addItem(Registration.INDIUM_INGOT, "Indium Ingot");
		addItem(Registration.TIN_INGOT, "Tin Ingot");
		addItem(Registration.CAESIUM_INGOT, "Caesium Ingot");
		addItem(Registration.BARIUM_INGOT, "Barium Ingot");
		addItem(Registration.LANTHANUM_INGOT, "Lanthanum Ingot");
		addItem(Registration.CERIUM_INGOT, "Cerium Ingot");
		addItem(Registration.PRAESODYMIUM_INGOT, "Praesodymium Ingot");
		addItem(Registration.NEODYMIUM_INGOT, "Neodymium Ingot");
		addItem(Registration.PROMETHIUM_INGOT, "Promethium Ingot");
		addItem(Registration.SAMARIUM_INGOT, "Samarium Ingot");
		addItem(Registration.EUROPIUM_INGOT, "Europium Ingot");
		addItem(Registration.GADOLINIUM_INGOT, "Gadolinium Ingot");
		addItem(Registration.TERBIUM_INGOT, "Terbium Ingot");
		addItem(Registration.DYSPROSIUM_INGOT, "Dysprosium Ingot");
		addItem(Registration.HOLMIUM_INGOT, "Holmium Ingot");
		addItem(Registration.ERBIUM_INGOT, "Erbium Ingot");
		addItem(Registration.THULIUM_INGOT, "Thulium Ingot");
		addItem(Registration.YTTERBIUM_INGOT, "Ytterbium Ingot");
		addItem(Registration.LUTETIUM_INGOT, "Lutetium Ingot");
		addItem(Registration.HAFNIUM_INGOT, "Hafnium Ingot");
		addItem(Registration.TANTALUM_INGOT, "Tantalum Ingot");
		addItem(Registration.TUNGSTEN_INGOT, "Tungsten Ingot");
		addItem(Registration.RHENIUM_INGOT, "Rhenium Ingot");
		addItem(Registration.OSMIUM_INGOT, "Osmium Ingot");
		addItem(Registration.IRIDIUM_INGOT, "Iridium Ingot");
		addItem(Registration.PLATINUM_INGOT, "Platinum Ingot");
		addItem(Registration.THALLIUM_INGOT, "Thallium Ingot");
		addItem(Registration.LEAD_INGOT, "Lead Ingot");
		addItem(Registration.BISMUTH_INGOT, "Bismuth Ingot");
		addItem(Registration.POLONIUM_INGOT, "Polonium Ingot");
		addItem(Registration.FRANCIUM_INGOT, "Francium Ingot");
		addItem(Registration.RADIUM_INGOT, "Radium Ingot");
		addItem(Registration.ACTINIUM_INGOT, "Actinium Ingot");
		addItem(Registration.THORIUM_INGOT, "Thorium Ingot");
		addItem(Registration.PROTACTINIUM_INGOT, "Protactinium Ingot");
		addItem(Registration.URANIUM_INGOT, "Uranium Ingot");
		addItem(Registration.NEPTUNIUM_INGOT, "Neptunium Ingot");
		addItem(Registration.PLUTONIUM_INGOT, "Plutonium Ingot");
		addItem(Registration.AMERICIUM_INGOT, "Americium Ingot");
		addItem(Registration.CURIUM_INGOT, "Curium Ingot");
		addItem(Registration.BERKELIUM_INGOT, "Berkelium Ingot");
		addItem(Registration.CALIFORNIUM_INGOT, "Californium Ingot");
		addItem(Registration.EINSTEINIUM_INGOT, "Einsteinium Ingot");
		addItem(Registration.FERMIUM_INGOT, "Fermium Ingot");
		addItem(Registration.MENDELEVIUM_INGOT, "Mendelevium Ingot");
		addItem(Registration.NOBELIUM_INGOT, "Nobelium Ingot");
		addItem(Registration.LAWRENCIUM_INGOT, "Lawrencium Ingot");
		addItem(Registration.RUTHERFORDIUM_INGOT, "Rutherfordium Ingot");
		addItem(Registration.DUBNIUM_INGOT, "Dubnium Ingot");
		addItem(Registration.SEABORGIUM_INGOT, "Seaborgium Ingot");
		addItem(Registration.BOHRIUM_INGOT, "Bohrium Ingot");
		addItem(Registration.HASSIUM_INGOT, "Hassium Ingot");
		addItem(Registration.MEITNERIUM_INGOT, "Meitnerium Ingot");
		addItem(Registration.DARMSTADTIUM_INGOT, "Darmstadtium Ingot");
		addItem(Registration.ROENTGENIUM_INGOT, "Roentgenium Ingot");
		addItem(Registration.COPERNICIUM_INGOT, "Copernicium Ingot");
		addItem(Registration.NIHONIUM_INGOT, "Nihonium Ingot");
		addItem(Registration.FLEVORIUM_INGOT, "Flevorium Ingot");
		addItem(Registration.MOSCOVIUM_INGOT, "Moscovium Ingot");
		addItem(Registration.LIVERMORIUM_INGOT, "Livermorium Ingot");
		addItem(Registration.TENNESINE_INGOT, "Tennesine Ingot");
		addItem(Registration.OGANESSON_INGOT, "Oganesson Ingot");
		
		addItem(Registration.LITHIUM_CLAY_BALL, "Lithium Clay Ball");
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
		
		addItem(Registration.BRINE_BUCKET, "Brine Bucket");
		
		addItem(Registration.DUCK_SPAWN_EGG, "Duck Spawn Egg");
		addItem(Registration.GRIZZLY_BEAR_SPAWN_EGG, "Grizzly Bear Spawn Egg");
		addItem(Registration.SHARK_SPAWN_EGG, "Shark Spawn Egg");
		addItem(Registration.ZEBRA_SPAWN_EGG, "Zebra Spawn Egg");
		
		addItemGroup(ModItemGroup.TECHNOLOGICA_FLORA, "Flora");
		addItemGroup(ModItemGroup.TECHNOLOGICA_FAUNA, "Fauna");
		addItemGroup(ModItemGroup.TECHNOLOGICA_MINERAL, "Mineral");
		addItemGroup(ModItemGroup.TECHNOLOGICA_FOOD, "Food");
		addItemGroup(ModItemGroup.TECHNOLOGICA_DECORATIVE, "Decorative");
		addItemGroup(ModItemGroup.TECHNOLOGICA_CRYPTICA, "Cryptica");
	}
	
	public void addItemGroup(ItemGroup key, String name) {
		add(key, name);
    }

	private void add(ItemGroup key, String name) {
		add("itemGroup." + key.getPath(), name);	
	}
}