package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.block.ModBlocks;
import com.technologica.items.ModItems;
import com.technologica.setup.ModItemGroup;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
	
	public ModLanguageProvider(DataGenerator generatorIn) {
		super(generatorIn, Technologica.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addBlock(ModBlocks.BANANA_LEAVES, "Banana Leaves");
		addBlock(ModBlocks.CHERRY_LEAVES, "Cherry Leaves");
		addBlock(ModBlocks.COCONUT_LEAVES, "Coconut Leaves");
		addBlock(ModBlocks.KIWI_LEAVES, "Kiwi Leaves");
		addBlock(ModBlocks.LEMON_LEAVES, "Lemon Leaves");
		addBlock(ModBlocks.LIME_LEAVES, "Lime Leaves");
		addBlock(ModBlocks.ORANGE_LEAVES, "Orange Leaves");
		addBlock(ModBlocks.PEACH_LEAVES, "Peach Leaves");
		addBlock(ModBlocks.PEAR_LEAVES, "Pear Leaves");
		addBlock(ModBlocks.BANANA_LOG, "Banana Log");
		addBlock(ModBlocks.CHERRY_LOG, "Cherry Log");
		addBlock(ModBlocks.COCONUT_LOG, "Coconut Log");
		addBlock(ModBlocks.KIWI_LOG, "Kiwi Log");
		addBlock(ModBlocks.LEMON_LOG, "Lemon Log");
		addBlock(ModBlocks.LIME_LOG, "Lime Log");
		addBlock(ModBlocks.ORANGE_LOG, "Orange Log");
		addBlock(ModBlocks.PEACH_LOG, "Peach Log");
		addBlock(ModBlocks.PEAR_LOG, "Pear Log");
		addBlock(ModBlocks.BANANA_SAPLING, "Banana Sapling");
		addBlock(ModBlocks.CHERRY_SAPLING, "Cherry Sapling");
		addBlock(ModBlocks.COCONUT_SAPLING, "Coconut Sapling");
		addBlock(ModBlocks.KIWI_SAPLING, "Kiwi Sapling");
		addBlock(ModBlocks.LEMON_SAPLING, "Lemon Sapling");
		addBlock(ModBlocks.LIME_SAPLING, "Lime Sapling");
		addBlock(ModBlocks.ORANGE_SAPLING, "Orange Sapling");
		addBlock(ModBlocks.PEACH_SAPLING, "Peach Sapling");
		addBlock(ModBlocks.PEAR_SAPLING, "Pear Sapling");
		addBlock(ModBlocks.LITHIUM_CLAY, "Lithium Clay");
		addBlock(ModBlocks.SALT, "Salt");
		addBlock(ModBlocks.BAUXITE_ORE, "Bauxite Ore");
		addBlock(ModBlocks.CHROMITE_ORE, "Chromite Ore");
		addBlock(ModBlocks.ILMENITE_ORE, "Ilmenite Ore");
		addBlock(ModBlocks.PYROLUSITE_ORE, "Pyrolusite Ore");
		addBlock(ModBlocks.COBALTITE_ORE, "Cobaltite Ore");
		addBlock(ModBlocks.GARNIERITE_ORE, "Garnierite Ore");
		addBlock(ModBlocks.BORAX_ORE, "Borax Ore");
		addBlock(ModBlocks.MAGNESITE_ORE, "Magnesite Ore");
		addBlock(ModBlocks.SPODUMENE_ORE, "Spodumene Ore");
		addBlock(ModBlocks.AQUAMARINE_CRYSTAL, "Aquamarine Crystal");
		addBlock(ModBlocks.DOLOMITE_CRYSTAL, "Dolomite Crystal");
		addBlock(ModBlocks.FLUORITE_CRYSTAL, "Fluorite Crystal");
		addBlock(ModBlocks.ULEXITE_CRYSTAL, "Ulexite Crystal");
		addBlock(ModBlocks.FRUITFUL_LEAVES, "Fruitful Leaves");
		addBlock(ModBlocks.ALCHEMICAL_LEAVES, "Alchemical Leaves");
		addBlock(ModBlocks.BENEVOLENT_LEAVES, "Benevolent Leaves");
		addBlock(ModBlocks.MALEVOLENT_LEAVES, "Malevolent Leaves");
		addBlock(ModBlocks.CONDUCTIVE_LEAVES, "Conductive Leaves");
		addBlock(ModBlocks.FROSTBITTEN_LEAVES, "Frostbitten Leaves");
		addBlock(ModBlocks.FRUITFUL_LOG, "Fruitful Log");
		addBlock(ModBlocks.ALCHEMICAL_LOG, "Alchemical Log");
		addBlock(ModBlocks.BENEVOLENT_LOG, "Benevolent Log");
		addBlock(ModBlocks.MALEVOLENT_LOG, "Malevolent Log");
		addBlock(ModBlocks.CONDUCTIVE_LOG, "Conductive Log");
		addBlock(ModBlocks.FROSTBITTEN_LOG, "Frostbitten Log");
		addBlock(ModBlocks.ANCIENT_AMBROSIA_SAPLING, "Ancient Ambrosia Sapling");
		addBlock(ModBlocks.SERENDIPITOUS_APOTHECARY_SAPLING, "Serendipitous Apothecary Sapling");
		addBlock(ModBlocks.BENEVOLENT_APOTHECARY_SAPLING, "Benevolent Apothecary Sapling");
		addBlock(ModBlocks.MALEVOLENT_APOTHECARY_SAPLING, "Malevolent Apothecary Sapling");
		addBlock(ModBlocks.TOWERING_INFERNO_SAPLING, "Towering Inferno Sapling");
		addBlock(ModBlocks.THUNDEROUS_CONDUCTOR_SAPLING, "Thunderous Conductor Sapling");
		addBlock(ModBlocks.CRYOGENIC_SPIRE_SAPLING, "Cryogenic Spire Sapling");
		addBlock(ModBlocks.DISPLAY_CASE, "Display Case");
		
		addItem(ModItems.BANANA, "Banana");
		addItem(ModItems.BLUEBERRY, "Blueberries");
		addItem(ModItems.CHERRY, "Cherries");
		addItem(ModItems.COCONUT, "Coconut");
		addItem(ModItems.GRAPE, "Grapes");
		addItem(ModItems.KIWI, "Kiwi");
		addItem(ModItems.LEMON, "Lemon");
		addItem(ModItems.LIME, "Lime");
		addItem(ModItems.ORANGE, "Orange");
		addItem(ModItems.PEACH, "Peach");
		addItem(ModItems.PEAR, "Pear");
		addItem(ModItems.STRAWBERRY, "Strawberry");
		addItem(ModItems.BLUEBERRY_SEEDS, "Blueberry Seeds");
		addItem(ModItems.GRAPE_SEEDS, "Grape Seeds");
		addItem(ModItems.STRAWBERRY_SEEDS, "Strawberry Seeds");
		
		addItem(ModItems.LITHIUM_INGOT, "Lithium Ingot");
		addItem(ModItems.BERYLLIUM_INGOT, "Beryllium Ingot");
		addItem(ModItems.SODIUM_INGOT, "Sodium Ingot");
		addItem(ModItems.MAGNESIUM_INGOT, "Magnesium Ingot");
		addItem(ModItems.ALUMINUM_INGOT, "Aluminum Ingot");
		addItem(ModItems.POTASSIUM_INGOT, "Potassium Ingot");
		addItem(ModItems.CALCIUM_INGOT, "Calcium Ingot");
		addItem(ModItems.SCANDIUM_INGOT, "Scandium Ingot");
		addItem(ModItems.TITANIUM_INGOT, "Titanium Ingot");
		addItem(ModItems.VANADIUM_INGOT, "Vanadium Ingot");
		addItem(ModItems.CHROMIUM_INGOT, "Chromium Ingot");
		addItem(ModItems.MANGANESE_INGOT, "Manganese Ingot");
		addItem(ModItems.COBALT_INGOT, "Cobalt Ingot");
		addItem(ModItems.NICKEL_INGOT, "Nickel Ingot");
		addItem(ModItems.COPPER_INGOT, "Copper Ingot");
		addItem(ModItems.ZINC_INGOT, "Zinc Ingot");
		addItem(ModItems.GALLIUM_INGOT, "Gallium Ingot");
		addItem(ModItems.RUBIDIUM_INGOT, "Rubidium Ingot");
		addItem(ModItems.STRONTIUM_INGOT, "Strontium Ingot");
		addItem(ModItems.YTTRIUM_INGOT, "Yttrium Ingot");
		addItem(ModItems.ZIRCONIUM_INGOT, "Zirconium Ingot");
		addItem(ModItems.NIOBIUM_INGOT, "Niobium Ingot");
		addItem(ModItems.MOLYBDENUM_INGOT, "Molybdenum Ingot");
		addItem(ModItems.TECHNETIUM_INGOT, "Technetium Ingot");
		addItem(ModItems.RUTHENIUM_INGOT, "Ruthenium Ingot");
		addItem(ModItems.RHODIUM_INGOT, "Rhodium Ingot");
		addItem(ModItems.PALLADIUM_INGOT, "Palladium Ingot");
		addItem(ModItems.SILVER_INGOT, "Silver Ingot");
		addItem(ModItems.CADMIUM_INGOT, "Cadmium Ingot");
		addItem(ModItems.INDIUM_INGOT, "Indium Ingot");
		addItem(ModItems.TIN_INGOT, "Tin Ingot");
		addItem(ModItems.CAESIUM_INGOT, "Caesium Ingot");
		addItem(ModItems.BARIUM_INGOT, "Barium Ingot");
		addItem(ModItems.LANTHANUM_INGOT, "Lanthanum Ingot");
		addItem(ModItems.CERIUM_INGOT, "Cerium Ingot");
		addItem(ModItems.PRAESODYMIUM_INGOT, "Praesodymium Ingot");
		addItem(ModItems.NEODYMIUM_INGOT, "Neodymium Ingot");
		addItem(ModItems.PROMETHIUM_INGOT, "Promethium Ingot");
		addItem(ModItems.SAMARIUM_INGOT, "Samarium Ingot");
		addItem(ModItems.EUROPIUM_INGOT, "Europium Ingot");
		addItem(ModItems.GADOLINIUM_INGOT, "Gadolinium Ingot");
		addItem(ModItems.TERBIUM_INGOT, "Terbium Ingot");
		addItem(ModItems.DYSPROSIUM_INGOT, "Dysprosium Ingot");
		addItem(ModItems.HOLMIUM_INGOT, "Holmium Ingot");
		addItem(ModItems.ERBIUM_INGOT, "Erbium Ingot");
		addItem(ModItems.THULIUM_INGOT, "Thulium Ingot");
		addItem(ModItems.YTTERBIUM_INGOT, "Ytterbium Ingot");
		addItem(ModItems.LUTETIUM_INGOT, "Lutetium Ingot");
		addItem(ModItems.HAFNIUM_INGOT, "Hafnium Ingot");
		addItem(ModItems.TANTALUM_INGOT, "Tantalum Ingot");
		addItem(ModItems.TUNGSTEN_INGOT, "Tungsten Ingot");
		addItem(ModItems.RHENIUM_INGOT, "Rhenium Ingot");
		addItem(ModItems.OSMIUM_INGOT, "Osmium Ingot");
		addItem(ModItems.IRIDIUM_INGOT, "Iridium Ingot");
		addItem(ModItems.PLATINUM_INGOT, "Platinum Ingot");
		addItem(ModItems.THALLIUM_INGOT, "Thallium Ingot");
		addItem(ModItems.LEAD_INGOT, "Lead Ingot");
		addItem(ModItems.BISMUTH_INGOT, "Bismuth Ingot");
		addItem(ModItems.POLONIUM_INGOT, "Polonium Ingot");
		addItem(ModItems.FRANCIUM_INGOT, "Francium Ingot");
		addItem(ModItems.RADIUM_INGOT, "Radium Ingot");
		addItem(ModItems.ACTINIUM_INGOT, "Actinium Ingot");
		addItem(ModItems.THORIUM_INGOT, "Thorium Ingot");
		addItem(ModItems.PROTACTINIUM_INGOT, "Protactinium Ingot");
		addItem(ModItems.URANIUM_INGOT, "Uranium Ingot");
		addItem(ModItems.NEPTUNIUM_INGOT, "Neptunium Ingot");
		addItem(ModItems.PLUTONIUM_INGOT, "Plutonium Ingot");
		addItem(ModItems.AMERICIUM_INGOT, "Americium Ingot");
		addItem(ModItems.CURIUM_INGOT, "Curium Ingot");
		addItem(ModItems.BERKELIUM_INGOT, "Berkelium Ingot");
		addItem(ModItems.CALIFORNIUM_INGOT, "Californium Ingot");
		addItem(ModItems.EINSTEINIUM_INGOT, "Einsteinium Ingot");
		addItem(ModItems.FERMIUM_INGOT, "Fermium Ingot");
		addItem(ModItems.MENDELEVIUM_INGOT, "Mendelevium Ingot");
		addItem(ModItems.NOBELIUM_INGOT, "Nobelium Ingot");
		addItem(ModItems.LAWRENCIUM_INGOT, "Lawrencium Ingot");
		addItem(ModItems.RUTHERFORDIUM_INGOT, "Rutherfordium Ingot");
		addItem(ModItems.DUBNIUM_INGOT, "Dubnium Ingot");
		addItem(ModItems.SEABORGIUM_INGOT, "Seaborgium Ingot");
		addItem(ModItems.BOHRIUM_INGOT, "Bohrium Ingot");
		addItem(ModItems.HASSIUM_INGOT, "Hassium Ingot");
		addItem(ModItems.MEITNERIUM_INGOT, "Meitnerium Ingot");
		addItem(ModItems.DARMSTADTIUM_INGOT, "Darmstadtium Ingot");
		addItem(ModItems.ROENTGENIUM_INGOT, "Roentgenium Ingot");
		addItem(ModItems.COPERNICIUM_INGOT, "Copernicium Ingot");
		addItem(ModItems.NIHONIUM_INGOT, "Nihonium Ingot");
		addItem(ModItems.FLEVORIUM_INGOT, "Flevorium Ingot");
		addItem(ModItems.MOSCOVIUM_INGOT, "Moscovium Ingot");
		addItem(ModItems.LIVERMORIUM_INGOT, "Livermorium Ingot");
		addItem(ModItems.TENNESINE_INGOT, "Tennesine Ingot");
		addItem(ModItems.OGANESSON_INGOT, "Oganesson Ingot");
		
		addItem(ModItems.LITHIUM_CLAY_BALL, "Lithium Clay Ball");
		addItem(ModItems.BORON_CHUNK, "Boron Chunk");
		addItem(ModItems.CARBON_CHUNK, "Carbon Chunk");
		addItem(ModItems.SILICON_CHUNK, "Silicon Chunk");
		addItem(ModItems.PHOSPHORUS_CHUNK, "Phosphorus Chunk");
		addItem(ModItems.SULFUR_CHUNK, "Sulfur Chunk");
		addItem(ModItems.GERMANIUM_CHUNK, "Germanium Chunk");
		addItem(ModItems.ARSENIC_CHUNK, "Arsenic Chunk");
		addItem(ModItems.SELENIUM_CHUNK, "Selenium Chunk");
		addItem(ModItems.ANTIMONY_CHUNK, "Antimony Chunk");
		addItem(ModItems.TELLURIUM_CHUNK, "Tellurium Chunk");
		addItem(ModItems.IODINE_CHUNK, "Iodine Chunk");
		addItem(ModItems.ASTATINE_CHUNK, "Astatine Chunk");
		
		addItem(ModItems.BRINE_BUCKET, "Brine Bucket");
		
		addItem(ModItems.DUCK_SPAWN_EGG, "Duck Spawn Egg");
		addItem(ModItems.GRIZZLY_BEAR_SPAWN_EGG, "Grizzly Bear Spawn Egg");
		addItem(ModItems.OSTRICH_SPAWN_EGG, "Ostrich Spawn Egg");
		addItem(ModItems.SHARK_SPAWN_EGG, "Shark Spawn Egg");
		addItem(ModItems.ZEBRA_SPAWN_EGG, "Zebra Spawn Egg");
		
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