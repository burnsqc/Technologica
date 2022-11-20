package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.renderer.block.model.BlockModel.GuiLight;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaItemModelProvider extends ItemModelProvider {

	public TechnologicaItemModelProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerModels() {
		simpleItem(TechnologicaItems.BARLEY_SEEDS.get());
		simpleItem(TechnologicaItems.BROCCOLI_SEEDS.get());
		simpleItem(TechnologicaItems.CELERY_SEEDS.get());
		simpleItem(TechnologicaItems.COFFEE_BEANS.get());
		simpleItem(TechnologicaItems.CORN_SEEDS.get());
		simpleItem(TechnologicaItems.CRANBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.CUCUMBER_SEEDS.get());
		simpleItem(TechnologicaItems.GRAPE_SEEDS.get());
		simpleItem(TechnologicaItems.LETTUCE_SEEDS.get());
		simpleItem(TechnologicaItems.MUSTARD_SEEDS.get());
		simpleItem(TechnologicaItems.OATS_SEEDS.get());
		simpleItem(TechnologicaItems.ONION_SEEDS.get());
		simpleItem(TechnologicaItems.PINEAPPLE_SEEDS.get());
		simpleItem(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get());
		simpleItem(TechnologicaItems.RADISH_SEEDS.get());
		simpleItem(TechnologicaItems.RED_BEANS.get());
		simpleItem(TechnologicaItems.RICE_SEEDS.get());
		simpleItem(TechnologicaItems.RYE_SEEDS.get());
		simpleItem(TechnologicaItems.SOY_BEANS.get());
		simpleItem(TechnologicaItems.SQUASH_SEEDS.get());
		simpleItem(TechnologicaItems.TEA_SEEDS.get());
		simpleItem(TechnologicaItems.TOMATO_SEEDS.get());
		simpleItem(TechnologicaItems.TURNIP_SEEDS.get());
		simpleItem(TechnologicaItems.ZUCCHINI_SEEDS.get());

		simpleBlockItem(TechnologicaItems.APRICOT_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.ASPEN_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.AVOCADO_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.BANANA_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.CHERRY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.CHESTNUT_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.CINNAMON_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.COCONUT_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.EBONY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.KIWI_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.LEMON_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.LIME_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.MAHOGANY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.MAPLE_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.OLIVE_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.ORANGE_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.PEACH_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.PEAR_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.PLUM_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.REDWOOD_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.ROSEWOOD_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.RUBBER_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.TEAK_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.WALNUT_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.ZEBRAWOOD_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.ANCIENT_AMBROSIA_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.CRYOGENIC_SPIRE_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.THUNDEROUS_CONDUCTOR_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.TOWERING_INFERNO_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.SERENDIPITOUS_APOTHECARY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.BENEVOLENT_APOTHECARY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.MALEVOLENT_APOTHECARY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.NECROTIC_SAPLING_ITEM.get());

		simpleItem(TechnologicaItems.COTTON.get());

		simpleSpawnEggItem(TechnologicaItems.ALLIGATOR_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.BEAVER_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.BUFFALO_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.CAMEL_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.COBRA_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.COTTONMOUTH_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.COYOTE_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.CRAB_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.DEER_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.DUCK_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.ELEPHANT_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.FLAMINGO_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.FROG_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.GIRAFFE_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.GORILLA_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.GRIZZLY_BEAR_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.JAGUAR_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.KING_CRAB_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.LEOPARD_SEAL_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.LION_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.LIZARD_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.MOOSE_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.NARWHAL_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.OCTOPUS_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.OSTRICH_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.OWL_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.PENGUIN_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.PIRANHA_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.POISON_DART_FROG_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.RACCOON_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.SCORPION_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.SHARK_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.SLOTH_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.STINGRAY_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.TURKEY_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.VULTURE_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.WALRUS_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.ZEBRA_SPAWN_EGG.get());

		simpleSpawnEggItem(TechnologicaItems.ATOMIC_CREEPER_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.PEEPER_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.SWEEPER_SPAWN_EGG.get());

		simpleItem(TechnologicaItems.PIRANHA_BUCKET.get());

		simpleItem(TechnologicaItems.FUR.get());
		simpleItem(TechnologicaItems.IVORY.get());
		simpleItem(TechnologicaItems.NARWHAL_TUSK.get());
		simpleItem(TechnologicaItems.BATRACHOTOXIN_SAC.get());
		simpleItem(TechnologicaItems.HEMOTOXIN_SAC.get());
		simpleItem(TechnologicaItems.NECROTOXIN_SAC.get());
		simpleItem(TechnologicaItems.NEUROTOXIN_SAC.get());

		simpleItem(TechnologicaItems.LITHIUM_INGOT.get());
		simpleItem(TechnologicaItems.BERYLLIUM_INGOT.get());
		simpleItem(TechnologicaItems.SODIUM_INGOT.get());
		simpleItem(TechnologicaItems.MAGNESIUM_INGOT.get());
		simpleItem(TechnologicaItems.ALUMINUM_INGOT.get());
		simpleItem(TechnologicaItems.POTASSIUM_INGOT.get());
		simpleItem(TechnologicaItems.CALCIUM_INGOT.get());
		simpleItem(TechnologicaItems.SCANDIUM_INGOT.get());
		simpleItem(TechnologicaItems.TITANIUM_INGOT.get());
		simpleItem(TechnologicaItems.VANADIUM_INGOT.get());
		simpleItem(TechnologicaItems.CHROMIUM_INGOT.get());
		simpleItem(TechnologicaItems.MANGANESE_INGOT.get());
		simpleItem(TechnologicaItems.COBALT_INGOT.get());
		simpleItem(TechnologicaItems.NICKEL_INGOT.get());
		simpleItem(TechnologicaItems.COPPER_INGOT.get());
		simpleItem(TechnologicaItems.ZINC_INGOT.get());
		simpleItem(TechnologicaItems.GALLIUM_INGOT.get());
		simpleItem(TechnologicaItems.RUBIDIUM_INGOT.get());
		simpleItem(TechnologicaItems.STRONTIUM_INGOT.get());
		simpleItem(TechnologicaItems.YTTRIUM_INGOT.get());
		simpleItem(TechnologicaItems.ZIRCONIUM_INGOT.get());
		simpleItem(TechnologicaItems.NIOBIUM_INGOT.get());
		simpleItem(TechnologicaItems.MOLYBDENUM_INGOT.get());
		radioactiveItem(TechnologicaItems.TECHNETIUM_INGOT.get());
		simpleItem(TechnologicaItems.RUTHENIUM_INGOT.get());
		simpleItem(TechnologicaItems.RHODIUM_INGOT.get());
		simpleItem(TechnologicaItems.PALLADIUM_INGOT.get());
		simpleItem(TechnologicaItems.SILVER_INGOT.get());
		simpleItem(TechnologicaItems.CADMIUM_INGOT.get());
		simpleItem(TechnologicaItems.INDIUM_INGOT.get());
		simpleItem(TechnologicaItems.TIN_INGOT.get());
		simpleItem(TechnologicaItems.CAESIUM_INGOT.get());
		simpleItem(TechnologicaItems.BARIUM_INGOT.get());
		simpleItem(TechnologicaItems.LANTHANUM_INGOT.get());
		simpleItem(TechnologicaItems.CERIUM_INGOT.get());
		simpleItem(TechnologicaItems.PRASEODYMIUM_INGOT.get());
		simpleItem(TechnologicaItems.NEODYMIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.PROMETHIUM_INGOT.get());
		simpleItem(TechnologicaItems.SAMARIUM_INGOT.get());
		simpleItem(TechnologicaItems.EUROPIUM_INGOT.get());
		simpleItem(TechnologicaItems.GADOLINIUM_INGOT.get());
		simpleItem(TechnologicaItems.TERBIUM_INGOT.get());
		simpleItem(TechnologicaItems.DYSPROSIUM_INGOT.get());
		simpleItem(TechnologicaItems.HOLMIUM_INGOT.get());
		simpleItem(TechnologicaItems.ERBIUM_INGOT.get());
		simpleItem(TechnologicaItems.THULIUM_INGOT.get());
		simpleItem(TechnologicaItems.YTTERBIUM_INGOT.get());
		simpleItem(TechnologicaItems.LUTETIUM_INGOT.get());
		simpleItem(TechnologicaItems.HAFNIUM_INGOT.get());
		simpleItem(TechnologicaItems.TANTALUM_INGOT.get());
		simpleItem(TechnologicaItems.TUNGSTEN_INGOT.get());
		simpleItem(TechnologicaItems.RHENIUM_INGOT.get());
		simpleItem(TechnologicaItems.OSMIUM_INGOT.get());
		simpleItem(TechnologicaItems.IRIDIUM_INGOT.get());
		simpleItem(TechnologicaItems.PLATINUM_INGOT.get());
		simpleItem(TechnologicaItems.THALLIUM_INGOT.get());
		simpleItem(TechnologicaItems.LEAD_INGOT.get());
		simpleItem(TechnologicaItems.BISMUTH_INGOT.get());
		radioactiveItem(TechnologicaItems.POLONIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.FRANCIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.RADIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.ACTINIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.THORIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.PROTACTINIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.URANIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.NEPTUNIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.PLUTONIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.AMERICIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.CURIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.BERKELIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.CALIFORNIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.EINSTEINIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.FERMIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.MENDELEVIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.NOBELIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.LAWRENCIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.RUTHERFORDIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.DUBNIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.SEABORGIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.BOHRIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.HASSIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.MEITNERIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.DARMSTADTIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.ROENTGENIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.COPERNICIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.NIHONIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.FLEVORIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.MOSCOVIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.LIVERMORIUM_INGOT.get());
		radioactiveItem(TechnologicaItems.TENNESSINE_INGOT.get());
		radioactiveItem(TechnologicaItems.OGANESSON_INGOT.get());

		simpleItem(TechnologicaItems.LITHIUM_CLAY_BALL.get());
		simpleItem(TechnologicaItems.BORON_CHUNK.get());
		simpleItem(TechnologicaItems.CARBON_CHUNK.get());
		simpleItem(TechnologicaItems.SILICON_CHUNK.get());
		simpleItem(TechnologicaItems.PHOSPHORUS_CHUNK.get());
		simpleItem(TechnologicaItems.SULFUR_CHUNK.get());
		simpleItem(TechnologicaItems.GERMANIUM_CHUNK.get());
		simpleItem(TechnologicaItems.ARSENIC_CHUNK.get());
		simpleItem(TechnologicaItems.SELENIUM_CHUNK.get());
		simpleItem(TechnologicaItems.ANTIMONY_CHUNK.get());
		simpleItem(TechnologicaItems.TELLURIUM_CHUNK.get());
		simpleItem(TechnologicaItems.IODINE_CHUNK.get());
		radioactiveItem(TechnologicaItems.ASTATINE_CHUNK.get());

		simpleItem(TechnologicaItems.MULCH.get());
		simpleItem(TechnologicaItems.FERTILIZER.get());
		simpleItem(TechnologicaItems.SAWDUST.get());
		simpleItem(TechnologicaItems.RUBBER.get());

		simpleItem(TechnologicaItems.HYDROGEN_BUCKET.get());
		simpleItem(TechnologicaItems.HELIUM_BUCKET.get());
		simpleItem(TechnologicaItems.NITROGEN_BUCKET.get());
		simpleItem(TechnologicaItems.OXYGEN_BUCKET.get());
		simpleItem(TechnologicaItems.FLUORINE_BUCKET.get());
		simpleItem(TechnologicaItems.NEON_BUCKET.get());
		simpleItem(TechnologicaItems.CHLORINE_BUCKET.get());
		simpleItem(TechnologicaItems.ARGON_BUCKET.get());
		simpleItem(TechnologicaItems.KRYPTON_BUCKET.get());
		simpleItem(TechnologicaItems.XENON_BUCKET.get());
		simpleItem(TechnologicaItems.RADON_BUCKET.get());
		simpleItem(TechnologicaItems.BROMINE_BUCKET.get());
		simpleItem(TechnologicaItems.MERCURY_BUCKET.get());
		simpleItem(TechnologicaItems.BRINE_BUCKET.get());
		simpleItem(TechnologicaItems.OIL_BUCKET.get());
		simpleItem(TechnologicaItems.NATURAL_GAS_BUCKET.get());
		simpleItem(TechnologicaItems.MAPLE_SYRUP_BUCKET.get());
		simpleItem(TechnologicaItems.RUBBER_RESIN_BUCKET.get());
		simpleItem(TechnologicaItems.GASOLINE_BUCKET.get());
		simpleItem(TechnologicaItems.MACHINE_OIL_BUCKET.get());
		simpleItem(TechnologicaItems.COOLANT_BUCKET.get());

		simpleItem(TechnologicaItems.APRICOT.get());
		simpleItem(TechnologicaItems.ASPARAGUS.get());
		simpleItem(TechnologicaItems.AVOCADO.get());
		simpleItem(TechnologicaItems.BANANA.get());
		simpleItem(TechnologicaItems.BARLEY.get());
		simpleItem(TechnologicaItems.BROCCOLI.get());
		simpleItem(TechnologicaItems.BLACKBERRY.get());
		simpleItem(TechnologicaItems.BLUEBERRY.get());
		simpleItem(TechnologicaItems.CELERY.get());
		simpleItem(TechnologicaItems.CHERRY.get());
		simpleItem(TechnologicaItems.CHESTNUT.get());
		simpleItem(TechnologicaItems.CHILI_PEPPER.get());
		simpleItem(TechnologicaItems.CINNAMON.get());
		simpleItem(TechnologicaItems.COCONUT.get());
		simpleItem(TechnologicaItems.CORN.get());
		simpleItem(TechnologicaItems.CRANBERRY.get());
		simpleItem(TechnologicaItems.CUCUMBER.get());
		simpleItem(TechnologicaItems.GARLIC.get());
		simpleItem(TechnologicaItems.GINGER.get());
		simpleItem(TechnologicaItems.GRAPE.get());
		simpleItem(TechnologicaItems.KIWI.get());
		simpleItem(TechnologicaItems.LEMON.get());
		simpleItem(TechnologicaItems.LETTUCE.get());
		simpleItem(TechnologicaItems.LIME.get());
		simpleItem(TechnologicaItems.MUSTARD_GREENS.get());
		simpleItem(TechnologicaItems.OATS.get());
		simpleItem(TechnologicaItems.OLIVE.get());
		simpleItem(TechnologicaItems.ONION.get());
		simpleItem(TechnologicaItems.ORANGE.get());
		simpleItem(TechnologicaItems.PEAS.get());
		simpleItem(TechnologicaItems.PEACH.get());
		simpleItem(TechnologicaItems.PEANUT.get());
		simpleItem(TechnologicaItems.PEAR.get());
		simpleItem(TechnologicaItems.PEPPERCORNS.get());
		simpleItem(TechnologicaItems.PINEAPPLE.get());
		simpleItem(TechnologicaItems.PLUM.get());
		simpleItem(TechnologicaItems.PURPLE_CABBAGE.get());
		simpleItem(TechnologicaItems.RADISH.get());
		simpleItem(TechnologicaItems.RASPBERRY.get());
		simpleItem(TechnologicaItems.RICE.get());
		simpleItem(TechnologicaItems.RYE.get());
		simpleItem(TechnologicaItems.SQUASH.get());
		simpleItem(TechnologicaItems.SWEET_POTATO.get());
		simpleItem(TechnologicaItems.STRAWBERRY.get());
		simpleItem(TechnologicaItems.TEA_LEAF.get());
		simpleItem(TechnologicaItems.TOMATO.get());
		simpleItem(TechnologicaItems.TURNIP.get());
		simpleItem(TechnologicaItems.WALNUT.get());
		simpleItem(TechnologicaItems.ZUCCHINI.get());

		simpleItem(TechnologicaItems.RAW_ALLIGATOR.get());
		simpleItem(TechnologicaItems.RAW_BEAR.get());
		simpleItem(TechnologicaItems.RAW_BISON.get());
		simpleItem(TechnologicaItems.RAW_CRAB.get());
		simpleItem(TechnologicaItems.RAW_CRAB_LEGS.get());
		simpleItem(TechnologicaItems.RAW_DUCK.get());
		simpleItem(TechnologicaItems.RAW_OCTOPUS.get());
		simpleItem(TechnologicaItems.RAW_OSTRICH.get());
		simpleItem(TechnologicaItems.RAW_PIRANHA.get());
		simpleItem(TechnologicaItems.RAW_SHARK.get());
		simpleItem(TechnologicaItems.RAW_TURKEY.get());
		simpleItem(TechnologicaItems.RAW_VENISON.get());
		simpleItem(TechnologicaItems.BLUBBER.get());

		simpleItem(TechnologicaItems.BANANAS_FOSTER.get());
		simpleItem(TechnologicaItems.BLACK_FOREST_CAKE.get());
		simpleItem(TechnologicaItems.BLUEBERRY_CHEESECAKE.get());
		simpleItem(TechnologicaItems.COCONUT_CREAM_PIE.get());
		simpleItem(TechnologicaItems.GRAPE_SHAVED_ICE.get());
		simpleItem(TechnologicaItems.KEY_LIME_MOUSSE.get());
		simpleItem(TechnologicaItems.KIWI_SORBET.get());
		simpleItem(TechnologicaItems.LEMON_BAR.get());
		simpleItem(TechnologicaItems.ORANGE_DREAMSICLE.get());
		simpleItem(TechnologicaItems.PEACH_COBBLER.get());
		simpleItem(TechnologicaItems.PEAR_TART.get());
		simpleItem(TechnologicaItems.STRAWBERRY_SHORTCAKE.get());
		simpleItem(TechnologicaItems.TAPENADE.get());
		simpleItem(TechnologicaItems.CINNAMON_ROLL.get());
		simpleItem(TechnologicaItems.OLIVE_OIL.get());
		simpleItem(TechnologicaItems.IODINE_PILL.get());

		simpleItem(TechnologicaItems.APRICOT_BOAT.get());
		simpleItem(TechnologicaItems.ASPEN_BOAT.get());
		simpleItem(TechnologicaItems.AVOCADO_BOAT.get());
		simpleItem(TechnologicaItems.BANANA_BOAT.get());
		simpleItem(TechnologicaItems.CHERRY_BOAT.get());
		simpleItem(TechnologicaItems.CHESTNUT_BOAT.get());
		simpleItem(TechnologicaItems.CINNAMON_BOAT.get());
		simpleItem(TechnologicaItems.COCONUT_BOAT.get());
		simpleItem(TechnologicaItems.EBONY_BOAT.get());
		simpleItem(TechnologicaItems.KIWI_BOAT.get());
		simpleItem(TechnologicaItems.LEMON_BOAT.get());
		simpleItem(TechnologicaItems.LIME_BOAT.get());
		simpleItem(TechnologicaItems.MAHOGANY_BOAT.get());
		simpleItem(TechnologicaItems.MAPLE_BOAT.get());
		simpleItem(TechnologicaItems.OLIVE_BOAT.get());
		simpleItem(TechnologicaItems.ORANGE_BOAT.get());
		simpleItem(TechnologicaItems.PEACH_BOAT.get());
		simpleItem(TechnologicaItems.PEAR_BOAT.get());
		simpleItem(TechnologicaItems.PLUM_BOAT.get());
		simpleItem(TechnologicaItems.REDWOOD_BOAT.get());
		simpleItem(TechnologicaItems.ROSEWOOD_BOAT.get());
		simpleItem(TechnologicaItems.RUBBER_BOAT.get());
		simpleItem(TechnologicaItems.TEAK_BOAT.get());
		simpleItem(TechnologicaItems.WALNUT_BOAT.get());
		simpleItem(TechnologicaItems.ZEBRAWOOD_BOAT.get());
		simpleItem(TechnologicaItems.ALCHEMICAL_BOAT.get());
		simpleItem(TechnologicaItems.BENEVOLENT_BOAT.get());
		simpleItem(TechnologicaItems.CONDUCTIVE_BOAT.get());
		simpleItem(TechnologicaItems.FROSTBITTEN_BOAT.get());
		simpleItem(TechnologicaItems.FRUITFUL_BOAT.get());
		simpleItem(TechnologicaItems.INFERNAL_BOAT.get());
		simpleItem(TechnologicaItems.MALEVOLENT_BOAT.get());
		// simpleItem(TechnologicaItems.NECROTIC_BOAT.get());

		simpleItem(TechnologicaItems.STEEL_SHAFT.get());
		simpleItem(TechnologicaItems.SMALL_PULLEY_ITEM.get());
		simpleItem(TechnologicaItems.MEDIUM_PULLEY_ITEM.get());
		simpleItem(TechnologicaItems.LARGE_PULLEY_ITEM.get());
		simpleItem(TechnologicaItems.PULLEY_BELT.get());
		simpleItem(TechnologicaItems.CHISEL.get());
		simpleItem(TechnologicaItems.HAMMER.get());
		simpleItem(TechnologicaItems.SAW.get());
		simpleItem(TechnologicaItems.PIPE_WRENCH.get());
		simpleItem(TechnologicaItems.WRENCH.get());
		simpleItem(TechnologicaItems.SAWBLADE.get());

		simpleItem(TechnologicaItems.OVERLAY_PASS_ITEM.get());
		simpleItem(TechnologicaItems.OVERLAY_WARN_ITEM.get());
		simpleItem(TechnologicaItems.OVERLAY_FAIL_ITEM.get());
		simpleItem(TechnologicaItems.SAWMILL_BLUEPRINT.get());

		simpleItem(TechnologicaItems.PRIMITIVE_DAGGER.get());
		simpleItem(TechnologicaItems.PRIMITIVE_PICKAXE.get());
		simpleItem(TechnologicaItems.PRIMITIVE_HOE.get());
		simpleItem(TechnologicaItems.PRIMITIVE_SHOVEL.get());
		simpleItem(TechnologicaItems.PRIMITIVE_HATCHET.get());

		simpleItem(TechnologicaItems.DODGEBALL_ITEM.get());
		simpleItem(TechnologicaItems.HARPOON.get());

		simpleItem(TechnologicaItems.SPACE_HELMET.get());
		simpleItem(TechnologicaItems.SPACE_SUIT.get());
		simpleItem(TechnologicaItems.SPACE_PANTS.get());
		simpleItem(TechnologicaItems.SPACE_BOOTS.get());

		simpleItem(TechnologicaItems.SNORKEL_HELMET.get());
		simpleItem(TechnologicaItems.SNORKEL_SUIT.get());
		simpleItem(TechnologicaItems.SNORKEL_PANTS.get());
		simpleItem(TechnologicaItems.SNORKEL_BOOTS.get());

		simpleItem(TechnologicaItems.DIVE_HELMET.get());
		simpleItem(TechnologicaItems.DIVE_SUIT.get());
		simpleItem(TechnologicaItems.DIVE_PANTS.get());
		simpleItem(TechnologicaItems.DIVE_BOOTS.get());

		simpleItem(TechnologicaItems.SCUBA_HELMET.get());
		simpleItem(TechnologicaItems.SCUBA_SUIT.get());
		simpleItem(TechnologicaItems.SCUBA_PANTS.get());
		simpleItem(TechnologicaItems.SCUBA_BOOTS.get());

		simpleItem(TechnologicaItems.GLUE_BOTTLE.get());
		simpleItem(TechnologicaItems.LAND_MINE.get());
		simpleItem(TechnologicaItems.NAVAL_MINE.get());

		simpleItem(TechnologicaItems.PERSISTENT_GLARE.get());
		simpleItem(TechnologicaItems.SINGULARITY_GRANULE.get());
	}

	public void simpleItem(Item item) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}

	public void simpleBlockItem(Item item) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), BLOCK_FOLDER + "/" + location.getPath()));
	}

	public void simpleSpawnEggItem(Item item) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
	}

	public void radioactiveItem(Item item) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("builtin/entity")).guiLight(GuiLight.FRONT).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
		this.getBuilder(location.getPath() + "_base").parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
}