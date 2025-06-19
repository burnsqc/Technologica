package com.technologica.resourcegen.assets;

import java.util.HashMap;
import java.util.Map;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.resourcegen.util.TechnologicaModels;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.util.VanillaModels;
import com.tlregen.util.ResourceLocationHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;

public class TLModelsBlock {
	public static final Map<ResourceLocation, BlockModelBuilder> MODELS_BLOCK = new HashMap<ResourceLocation, BlockModelBuilder>();

	static {
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ARSENIC.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ASTATINE.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BISMUTH.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BORON.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BRASS.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_BRONZE.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_CADMIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_CARBON.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_COBALT.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_CURIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_FERMIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_GALLIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_INDIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_IODINE.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_LEAD.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_LITHIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_MANGANESE.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_NICKEL.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_OSMIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_PLATINUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_POLONIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_RHENIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_RHODIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_RUBY.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_SELENIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_SILICON.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_SILVER.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_STEEL.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_SULFUR.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TANTALUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_THALLIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_THORIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TIN.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TITANIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TOPAZ.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_URANIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_VANADIUM.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ZINC.get());
		blockModelCubeAll(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get());

		blockModelCubeAll(TechnologicaBlocks.LITHIUM_CLAY.get());
		blockModelCubeAll(TechnologicaBlocks.MOON_DUST.get());
		blockModelCubeAll(TechnologicaBlocks.MOON_ROCK.get());
		blockModelCubeAll(TechnologicaBlocks.OILY_COARSE_DIRT.get());
		blockModelCubeAll(TechnologicaBlocks.OILY_GRAVEL.get());
		blockModelCubeAll(TechnologicaBlocks.OILY_RED_SAND.get());
		blockModelCubeAll(TechnologicaBlocks.OILY_SAND.get());
		blockModelCubeAll(TechnologicaBlocks.SALT.get());

		cubeAllRenderType(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.APRICOT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.ASPEN_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.AVOCADO_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.BANANA_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.CHERRY_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.CHESTNUT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.CINNAMON_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.COCONUT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.EBONY_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), VanillaModels.TRANSLUCENT);
		cubeAllRenderType(TechnologicaBlocks.FRUITFUL_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.INFERNAL_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.KIWI_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.LEMON_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.LIME_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.MAHOGANY_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.MAPLE_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.NECROTIC_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.OLIVE_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.ORANGE_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.PEACH_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.PEAR_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.PLUM_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.REDWOOD_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.RUBBER_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.TEAK_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.WALNUT_PLANKS.get(), VanillaModels.SOLID);
		cubeAllRenderType(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), VanillaModels.SOLID);

		blockModelCubeAll(TechnologicaBlocks.APATITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.ARGENTITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.ARSENOPYRITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.BASTNAESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.BAUXITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.BORAX_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.CASSITERITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.CHROMITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.CINNABAR_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.COBALTITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.CROOKESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.GADOLINITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.GALENA_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.GARNIERITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.ILMENITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.LEPIDOLITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.MAGNESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.MOLYBDENITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.OSMIRIDIUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.PATRONITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.PENTLANDITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.PHOSPHORITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.PLATINUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.PYROLUSITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.RUBY_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.SAPPHIRE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.SPODUMENE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.SYLVANITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.TANTALITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.THORIANITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.TOPAZ_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.URANINITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.WOLFRAMITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.NETHER_PLATINUM_ORE.get());
		blockModelCubeAll(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get());

		cubeAllRenderType(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.APRICOT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.ASPEN_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.AVOCADO_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.BANANA_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.CHERRY_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.CHESTNUT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.CINNAMON_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.COCONUT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.CURSED_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.EBONY_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.FRUITFUL_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.KIWI_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.LEMON_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.LIME_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.MAHOGANY_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.MAPLE_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.OLIVE_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.ORANGE_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.PEACH_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.PEAR_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.PLUM_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.REDWOOD_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.RUBBER_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.TEAK_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.WALNUT_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);
		cubeAllRenderType(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), VanillaModels.CUTOUT_MIPPED);

		log(TechnologicaBlocks.ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/alchemical_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.APRICOT_LOG.get(), new TechnologicaLocation("block/apricot_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.ASPEN_LOG.get(), new TechnologicaLocation("block/aspen_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.AVOCADO_LOG.get(), new TechnologicaLocation("block/avocado_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.BANANA_LOG.get(), new TechnologicaLocation("block/banana_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.BENEVOLENT_LOG.get(), new TechnologicaLocation("block/benevolent_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.CHERRY_LOG.get(), new TechnologicaLocation("block/cherry_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.CHESTNUT_LOG.get(), new TechnologicaLocation("block/chestnut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.CINNAMON_LOG.get(), new TechnologicaLocation("block/cinnamon_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.COCONUT_LOG.get(), new TechnologicaLocation("block/coconut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/conductive_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.EBONY_LOG.get(), new TechnologicaLocation("block/ebony_log_top"), VanillaModels.SOLID);
		hollowLog(TechnologicaBlocks.FROSTBITTEN_LOG.get());
		log(TechnologicaBlocks.FRUITFUL_LOG.get(), new TechnologicaLocation("block/fruitful_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.INFERNAL_LOG.get(), new TechnologicaLocation("block/infernal_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.KIWI_LOG.get(), new TechnologicaLocation("block/kiwi_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.LEMON_LOG.get(), new TechnologicaLocation("block/lemon_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.LIME_LOG.get(), new TechnologicaLocation("block/lime_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.MAHOGANY_LOG.get(), new TechnologicaLocation("block/mahogany_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.MALEVOLENT_LOG.get(), new TechnologicaLocation("block/malevolent_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.MAPLE_LOG.get(), new TechnologicaLocation("block/maple_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.NECROTIC_LOG.get(), new TechnologicaLocation("block/necrotic_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.OLIVE_LOG.get(), new TechnologicaLocation("block/olive_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.ORANGE_LOG.get(), new TechnologicaLocation("block/orange_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.PEACH_LOG.get(), new TechnologicaLocation("block/peach_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.PEAR_LOG.get(), new TechnologicaLocation("block/pear_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.PLUM_LOG.get(), new TechnologicaLocation("block/plum_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.REDWOOD_LOG.get(), new TechnologicaLocation("block/redwood_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.ROSEWOOD_LOG.get(), new TechnologicaLocation("block/rosewood_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.RUBBER_LOG.get(), new TechnologicaLocation("block/rubber_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.TEAK_LOG.get(), new TechnologicaLocation("block/teak_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.WALNUT_LOG.get(), new TechnologicaLocation("block/walnut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/zebrawood_log_top"), VanillaModels.SOLID);

		log(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/stripped_alchemical_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), new TechnologicaLocation("block/stripped_apricot_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), new TechnologicaLocation("block/stripped_aspen_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), new TechnologicaLocation("block/stripped_avocado_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), new TechnologicaLocation("block/stripped_banana_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_benevolent_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), new TechnologicaLocation("block/stripped_cherry_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), new TechnologicaLocation("block/stripped_chestnut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), new TechnologicaLocation("block/stripped_cinnamon_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), new TechnologicaLocation("block/stripped_coconut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/stripped_conductive_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), new TechnologicaLocation("block/stripped_ebony_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), new TechnologicaLocation("block/stripped_frostbitten_log_top"), VanillaModels.TRANSLUCENT);
		log(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), new TechnologicaLocation("block/stripped_fruitful_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), new TechnologicaLocation("block/stripped_infernal_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), new TechnologicaLocation("block/stripped_kiwi_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), new TechnologicaLocation("block/stripped_lemon_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_LIME_LOG.get(), new TechnologicaLocation("block/stripped_lime_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), new TechnologicaLocation("block/stripped_mahogany_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_malevolent_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), new TechnologicaLocation("block/stripped_maple_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get(), new TechnologicaLocation("block/stripped_necrotic_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), new TechnologicaLocation("block/stripped_olive_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), new TechnologicaLocation("block/stripped_orange_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), new TechnologicaLocation("block/stripped_peach_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), new TechnologicaLocation("block/stripped_pear_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), new TechnologicaLocation("block/stripped_plum_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), new TechnologicaLocation("block/stripped_redwood_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), new TechnologicaLocation("block/stripped_rosewood_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), new TechnologicaLocation("block/stripped_rubber_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), new TechnologicaLocation("block/stripped_teak_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), new TechnologicaLocation("block/stripped_walnut_log_top"), VanillaModels.SOLID);
		log(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/stripped_zebrawood_log_top"), VanillaModels.SOLID);

		wood(TechnologicaBlocks.ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/alchemical_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.APRICOT_WOOD.get(), new TechnologicaLocation("block/apricot_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.ASPEN_WOOD.get(), new TechnologicaLocation("block/aspen_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.AVOCADO_WOOD.get(), new TechnologicaLocation("block/avocado_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.BANANA_WOOD.get(), new TechnologicaLocation("block/banana_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/benevolent_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.CHERRY_WOOD.get(), new TechnologicaLocation("block/cherry_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.CHESTNUT_WOOD.get(), new TechnologicaLocation("block/chestnut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.CINNAMON_WOOD.get(), new TechnologicaLocation("block/cinnamon_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.COCONUT_WOOD.get(), new TechnologicaLocation("block/coconut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/conductive_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.EBONY_WOOD.get(), new TechnologicaLocation("block/ebony_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/frostbitten_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.FRUITFUL_WOOD.get(), new TechnologicaLocation("block/fruitful_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.INFERNAL_WOOD.get(), new TechnologicaLocation("block/infernal_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.KIWI_WOOD.get(), new TechnologicaLocation("block/kiwi_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.LEMON_WOOD.get(), new TechnologicaLocation("block/lemon_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.LIME_WOOD.get(), new TechnologicaLocation("block/lime_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.MAHOGANY_WOOD.get(), new TechnologicaLocation("block/mahogany_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/malevolent_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.MAPLE_WOOD.get(), new TechnologicaLocation("block/maple_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.NECROTIC_WOOD.get(), new TechnologicaLocation("block/necrotic_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.OLIVE_WOOD.get(), new TechnologicaLocation("block/olive_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.ORANGE_WOOD.get(), new TechnologicaLocation("block/orange_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.PEACH_WOOD.get(), new TechnologicaLocation("block/peach_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.PEAR_WOOD.get(), new TechnologicaLocation("block/pear_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.PLUM_WOOD.get(), new TechnologicaLocation("block/plum_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.REDWOOD_WOOD.get(), new TechnologicaLocation("block/redwood_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/rosewood_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.RUBBER_WOOD.get(), new TechnologicaLocation("block/rubber_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.TEAK_WOOD.get(), new TechnologicaLocation("block/teak_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.WALNUT_WOOD.get(), new TechnologicaLocation("block/walnut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/zebrawood_log"), VanillaModels.SOLID);

		wood(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/stripped_alchemical_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), new TechnologicaLocation("block/stripped_apricot_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), new TechnologicaLocation("block/stripped_aspen_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), new TechnologicaLocation("block/stripped_avocado_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), new TechnologicaLocation("block/stripped_banana_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_benevolent_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), new TechnologicaLocation("block/stripped_cherry_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), new TechnologicaLocation("block/stripped_chestnut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), new TechnologicaLocation("block/stripped_cinnamon_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), new TechnologicaLocation("block/stripped_coconut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/stripped_conductive_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), new TechnologicaLocation("block/stripped_ebony_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/stripped_frostbitten_log"), VanillaModels.TRANSLUCENT);
		wood(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), new TechnologicaLocation("block/stripped_fruitful_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), new TechnologicaLocation("block/stripped_infernal_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), new TechnologicaLocation("block/stripped_kiwi_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), new TechnologicaLocation("block/stripped_lemon_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), new TechnologicaLocation("block/stripped_lime_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), new TechnologicaLocation("block/stripped_mahogany_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_malevolent_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), new TechnologicaLocation("block/stripped_maple_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), new TechnologicaLocation("block/stripped_necrotic_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), new TechnologicaLocation("block/stripped_olive_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), new TechnologicaLocation("block/stripped_orange_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), new TechnologicaLocation("block/stripped_peach_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), new TechnologicaLocation("block/stripped_pear_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), new TechnologicaLocation("block/stripped_plum_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_redwood_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_rosewood_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), new TechnologicaLocation("block/stripped_rubber_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), new TechnologicaLocation("block/stripped_teak_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), new TechnologicaLocation("block/stripped_walnut_log"), VanillaModels.SOLID);
		wood(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_zebrawood_log"), VanillaModels.SOLID);

		slab(TechnologicaBlocks.ALCHEMICAL_SLAB.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.APRICOT_SLAB.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.ASPEN_SLAB.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.AVOCADO_SLAB.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.BANANA_SLAB.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.BENEVOLENT_SLAB.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.CHERRY_SLAB.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.CHESTNUT_SLAB.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.CINNAMON_SLAB.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.COCONUT_SLAB.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.CONDUCTIVE_SLAB.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.EBONY_SLAB.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.FROSTBITTEN_SLAB.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		slab(TechnologicaBlocks.FRUITFUL_SLAB.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.INFERNAL_SLAB.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.KIWI_SLAB.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.LEMON_SLAB.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.LIME_SLAB.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.MAHOGANY_SLAB.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.MALEVOLENT_SLAB.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.MAPLE_SLAB.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.NECROTIC_SLAB.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.OLIVE_SLAB.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.ORANGE_SLAB.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.PEACH_SLAB.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.PEAR_SLAB.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.PLUM_SLAB.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.REDWOOD_SLAB.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.ROSEWOOD_SLAB.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.RUBBER_SLAB.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.TEAK_SLAB.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.WALNUT_SLAB.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		slab(TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		stairs(TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.APRICOT_STAIRS.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.ASPEN_STAIRS.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.AVOCADO_STAIRS.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.BANANA_STAIRS.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.BENEVOLENT_STAIRS.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.CHERRY_STAIRS.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.CHESTNUT_STAIRS.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.CINNAMON_STAIRS.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.COCONUT_STAIRS.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.EBONY_STAIRS.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		stairs(TechnologicaBlocks.FRUITFUL_STAIRS.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.INFERNAL_STAIRS.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.KIWI_STAIRS.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.LEMON_STAIRS.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.LIME_STAIRS.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.MAHOGANY_STAIRS.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.MALEVOLENT_STAIRS.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.MAPLE_STAIRS.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.NECROTIC_STAIRS.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.OLIVE_STAIRS.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.ORANGE_STAIRS.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.PEACH_STAIRS.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.PEAR_STAIRS.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.PLUM_STAIRS.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.REDWOOD_STAIRS.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.ROSEWOOD_STAIRS.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.RUBBER_STAIRS.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.TEAK_STAIRS.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.WALNUT_STAIRS.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		stairs(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		bookshelf(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), ResourceLocationHelper.blockTexture(Blocks.ACACIA_PLANKS), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), ResourceLocationHelper.blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.BANANA_BOOKSHELF.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), new ResourceLocation("block/birch_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), new ResourceLocation("block/crimson_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), new ResourceLocation("block/dark_oak_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.EBONY_BOOKSHELF.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		bookshelf(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), new ResourceLocation("block/jungle_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.KIWI_BOOKSHELF.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.LEMON_BOOKSHELF.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.LIME_BOOKSHELF.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.PEACH_BOOKSHELF.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.PEAR_BOOKSHELF.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.PLUM_BOOKSHELF.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), new ResourceLocation("block/spruce_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.TEAK_BOOKSHELF.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.WARPED_BOOKSHELF.get(), new ResourceLocation("block/warped_planks"), VanillaModels.SOLID);
		bookshelf(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		fence(TechnologicaBlocks.ALCHEMICAL_FENCE.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.APRICOT_FENCE.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.ASPEN_FENCE.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.AVOCADO_FENCE.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.BANANA_FENCE.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.BENEVOLENT_FENCE.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.CHERRY_FENCE.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.CHESTNUT_FENCE.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.CINNAMON_FENCE.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.COCONUT_FENCE.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.CONDUCTIVE_FENCE.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.EBONY_FENCE.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.FROSTBITTEN_FENCE.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		fence(TechnologicaBlocks.FRUITFUL_FENCE.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.INFERNAL_FENCE.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.KIWI_FENCE.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.LEMON_FENCE.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.LIME_FENCE.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.MAHOGANY_FENCE.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.MALEVOLENT_FENCE.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.MAPLE_FENCE.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.NECROTIC_FENCE.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.OLIVE_FENCE.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.ORANGE_FENCE.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.PEACH_FENCE.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.PEAR_FENCE.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.PLUM_FENCE.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.REDWOOD_FENCE.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.ROSEWOOD_FENCE.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.RUBBER_FENCE.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.TEAK_FENCE.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.WALNUT_FENCE.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		fence(TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		fenceGate(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.ASPEN_FENCE_GATE.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.BANANA_FENCE_GATE.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.CHERRY_FENCE_GATE.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.COCONUT_FENCE_GATE.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.EBONY_FENCE_GATE.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		fenceGate(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.KIWI_FENCE_GATE.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.LEMON_FENCE_GATE.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.LIME_FENCE_GATE.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.MAPLE_FENCE_GATE.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.OLIVE_FENCE_GATE.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.ORANGE_FENCE_GATE.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.PEACH_FENCE_GATE.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.PEAR_FENCE_GATE.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.PLUM_FENCE_GATE.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.RUBBER_FENCE_GATE.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.TEAK_FENCE_GATE.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.WALNUT_FENCE_GATE.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		fenceGate(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		button(TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.APRICOT_BUTTON.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.ASPEN_BUTTON.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.AVOCADO_BUTTON.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.BANANA_BUTTON.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.BENEVOLENT_BUTTON.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.CHERRY_BUTTON.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.CHESTNUT_BUTTON.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.CINNAMON_BUTTON.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.COCONUT_BUTTON.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.EBONY_BUTTON.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		button(TechnologicaBlocks.FRUITFUL_BUTTON.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.INFERNAL_BUTTON.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.KIWI_BUTTON.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.LEMON_BUTTON.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.LIME_BUTTON.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.MAHOGANY_BUTTON.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.MALEVOLENT_BUTTON.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.MAPLE_BUTTON.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.NECROTIC_BUTTON.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.OLIVE_BUTTON.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.ORANGE_BUTTON.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.PEACH_BUTTON.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.PEAR_BUTTON.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.PLUM_BUTTON.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.REDWOOD_BUTTON.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.ROSEWOOD_BUTTON.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.RUBBER_BUTTON.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.TEAK_BUTTON.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.WALNUT_BUTTON.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		button(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);
		
		pressurePlate(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		pressurePlate(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		pressurePlate(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		door(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), new TechnologicaLocation("block/alchemical_door_bottom"), new TechnologicaLocation("block/alchemical_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.APRICOT_DOOR.get(), new TechnologicaLocation("block/apricot_door_bottom"), new TechnologicaLocation("block/apricot_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.ASPEN_DOOR.get(), new TechnologicaLocation("block/aspen_door_bottom"), new TechnologicaLocation("block/aspen_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.AVOCADO_DOOR.get(), new TechnologicaLocation("block/avocado_door_bottom"), new TechnologicaLocation("block/avocado_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.BANANA_DOOR.get(), new TechnologicaLocation("block/banana_door_bottom"), new TechnologicaLocation("block/banana_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.BENEVOLENT_DOOR.get(), new TechnologicaLocation("block/benevolent_door_bottom"), new TechnologicaLocation("block/benevolent_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.CHERRY_DOOR.get(), new TechnologicaLocation("block/cherry_door_bottom"), new TechnologicaLocation("block/cherry_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.CHESTNUT_DOOR.get(), new TechnologicaLocation("block/chestnut_door_bottom"), new TechnologicaLocation("block/chestnut_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.CINNAMON_DOOR.get(), new TechnologicaLocation("block/cinnamon_door_bottom"), new TechnologicaLocation("block/cinnamon_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.COCONUT_DOOR.get(), new TechnologicaLocation("block/coconut_door_bottom"), new TechnologicaLocation("block/coconut_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), new TechnologicaLocation("block/conductive_door_bottom"), new TechnologicaLocation("block/conductive_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.EBONY_DOOR.get(), new TechnologicaLocation("block/ebony_door_bottom"), new TechnologicaLocation("block/ebony_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), new TechnologicaLocation("block/frostbitten_door_bottom"), new TechnologicaLocation("block/frostbitten_door_top"), VanillaModels.TRANSLUCENT);
		door(TechnologicaBlocks.FRUITFUL_DOOR.get(), new TechnologicaLocation("block/fruitful_door_bottom"), new TechnologicaLocation("block/fruitful_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.INFERNAL_DOOR.get(), new TechnologicaLocation("block/infernal_door_bottom"), new TechnologicaLocation("block/infernal_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.KIWI_DOOR.get(), new TechnologicaLocation("block/kiwi_door_bottom"), new TechnologicaLocation("block/kiwi_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.LEMON_DOOR.get(), new TechnologicaLocation("block/lemon_door_bottom"), new TechnologicaLocation("block/lemon_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.LIME_DOOR.get(), new TechnologicaLocation("block/lime_door_bottom"), new TechnologicaLocation("block/lime_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.MAHOGANY_DOOR.get(), new TechnologicaLocation("block/mahogany_door_bottom"), new TechnologicaLocation("block/mahogany_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.MALEVOLENT_DOOR.get(), new TechnologicaLocation("block/malevolent_door_bottom"), new TechnologicaLocation("block/malevolent_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.MAPLE_DOOR.get(), new TechnologicaLocation("block/maple_door_bottom"), new TechnologicaLocation("block/maple_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.NECROTIC_DOOR.get(), new TechnologicaLocation("block/necrotic_door_bottom"), new TechnologicaLocation("block/necrotic_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.OLIVE_DOOR.get(), new TechnologicaLocation("block/olive_door_bottom"), new TechnologicaLocation("block/olive_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.ORANGE_DOOR.get(), new TechnologicaLocation("block/orange_door_bottom"), new TechnologicaLocation("block/orange_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.PEACH_DOOR.get(), new TechnologicaLocation("block/peach_door_bottom"), new TechnologicaLocation("block/peach_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.PEAR_DOOR.get(), new TechnologicaLocation("block/pear_door_bottom"), new TechnologicaLocation("block/pear_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.PLUM_DOOR.get(), new TechnologicaLocation("block/plum_door_bottom"), new TechnologicaLocation("block/plum_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.REDWOOD_DOOR.get(), new TechnologicaLocation("block/redwood_door_bottom"), new TechnologicaLocation("block/redwood_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.ROSEWOOD_DOOR.get(), new TechnologicaLocation("block/rosewood_door_bottom"), new TechnologicaLocation("block/rosewood_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.RUBBER_DOOR.get(), new TechnologicaLocation("block/rubber_door_bottom"), new TechnologicaLocation("block/rubber_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.TEAK_DOOR.get(), new TechnologicaLocation("block/teak_door_bottom"), new TechnologicaLocation("block/teak_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.WALNUT_DOOR.get(), new TechnologicaLocation("block/walnut_door_bottom"), new TechnologicaLocation("block/walnut_door_top"), VanillaModels.CUTOUT_MIPPED);
		door(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), new TechnologicaLocation("block/zebrawood_door_bottom"), new TechnologicaLocation("block/zebrawood_door_top"), VanillaModels.CUTOUT_MIPPED);

		trapdoor(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.ASPEN_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.BANANA_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.CHERRY_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.COCONUT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.EBONY_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), VanillaModels.TRANSLUCENT);
		trapdoor(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.KIWI_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.LEMON_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.LIME_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.MAPLE_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.OLIVE_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.ORANGE_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.PEACH_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.PEAR_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.PLUM_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.RUBBER_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.TEAK_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.WALNUT_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);
		trapdoor(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), VanillaModels.CUTOUT_MIPPED);

		sign(TechnologicaBlocks.ALCHEMICAL_SIGN.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.APRICOT_SIGN.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.ASPEN_SIGN.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.AVOCADO_SIGN.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.BANANA_SIGN.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.BENEVOLENT_SIGN.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.CHERRY_SIGN.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.CHESTNUT_SIGN.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.CINNAMON_SIGN.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.COCONUT_SIGN.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.CONDUCTIVE_SIGN.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.EBONY_SIGN.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.FROSTBITTEN_SIGN.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		sign(TechnologicaBlocks.FRUITFUL_SIGN.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.INFERNAL_SIGN.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.KIWI_SIGN.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.LEMON_SIGN.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.LIME_SIGN.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.MAHOGANY_SIGN.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.MALEVOLENT_SIGN.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.MAPLE_SIGN.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.NECROTIC_SIGN.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.OLIVE_SIGN.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.ORANGE_SIGN.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.PEACH_SIGN.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.PEAR_SIGN.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.PLUM_SIGN.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.REDWOOD_SIGN.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.ROSEWOOD_SIGN.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.RUBBER_SIGN.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.TEAK_SIGN.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.WALNUT_SIGN.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.CUTOUT);
		sign(TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.CUTOUT);

		sapling(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get());
		sapling(TechnologicaBlocks.APRICOT_SAPLING.get());
		sapling(TechnologicaBlocks.ASPEN_SAPLING.get());
		sapling(TechnologicaBlocks.AVOCADO_SAPLING.get());
		sapling(TechnologicaBlocks.BANANA_SAPLING.get());
		sapling(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get());
		sapling(TechnologicaBlocks.CHERRY_SAPLING.get());
		sapling(TechnologicaBlocks.CHESTNUT_SAPLING.get());
		sapling(TechnologicaBlocks.CINNAMON_SAPLING.get());
		sapling(TechnologicaBlocks.COCONUT_SAPLING.get());
		sapling(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get());
		sapling(TechnologicaBlocks.EBONY_SAPLING.get());
		sapling(TechnologicaBlocks.KIWI_SAPLING.get());
		sapling(TechnologicaBlocks.LEMON_SAPLING.get());
		sapling(TechnologicaBlocks.LIME_SAPLING.get());
		sapling(TechnologicaBlocks.MAHOGANY_SAPLING.get());
		sapling(TechnologicaBlocks.MAPLE_SAPLING.get());
		sapling(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get());
		sapling(TechnologicaBlocks.NECROTIC_SAPLING.get());
		sapling(TechnologicaBlocks.OLIVE_SAPLING.get());
		sapling(TechnologicaBlocks.ORANGE_SAPLING.get());
		sapling(TechnologicaBlocks.PEACH_SAPLING.get());
		sapling(TechnologicaBlocks.PEAR_SAPLING.get());
		sapling(TechnologicaBlocks.PLUM_SAPLING.get());
		sapling(TechnologicaBlocks.REDWOOD_SAPLING.get());
		sapling(TechnologicaBlocks.ROSEWOOD_SAPLING.get());
		sapling(TechnologicaBlocks.RUBBER_SAPLING.get());
		sapling(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get());
		sapling(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get());
		sapling(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get());
		sapling(TechnologicaBlocks.TEAK_SAPLING.get());
		sapling(TechnologicaBlocks.WALNUT_SAPLING.get());
		sapling(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get());

		pottedSapling(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), new TechnologicaLocation("block/ancient_ambrosia_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), new TechnologicaLocation("block/apricot_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), new TechnologicaLocation("block/aspen_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), new TechnologicaLocation("block/avocado_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), new TechnologicaLocation("block/banana_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/benevolent_apothecary_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), new TechnologicaLocation("block/cherry_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), new TechnologicaLocation("block/chestnut_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), new TechnologicaLocation("block/cinnamon_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), new TechnologicaLocation("block/coconut_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), new TechnologicaLocation("block/cryogenic_spire_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), new TechnologicaLocation("block/ebony_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), new TechnologicaLocation("block/kiwi_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), new TechnologicaLocation("block/lemon_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), new TechnologicaLocation("block/lime_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), new TechnologicaLocation("block/mahogany_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), new TechnologicaLocation("block/maple_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/malevolent_apothecary_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), new TechnologicaLocation("block/necrotic_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), new TechnologicaLocation("block/olive_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), new TechnologicaLocation("block/orange_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), new TechnologicaLocation("block/peach_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), new TechnologicaLocation("block/pear_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), new TechnologicaLocation("block/plum_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), new TechnologicaLocation("block/redwood_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), new TechnologicaLocation("block/rosewood_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), new TechnologicaLocation("block/rubber_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/serendipitous_apothecary_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), new TechnologicaLocation("block/thunderous_conductor_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), new TechnologicaLocation("block/towering_inferno_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), new TechnologicaLocation("block/teak_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), new TechnologicaLocation("block/walnut_sapling"));
		pottedSapling(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), new TechnologicaLocation("block/zebrawood_sapling"));

		fluid(TechnologicaBlocks.ARGON.get());
		fluid(TechnologicaBlocks.BRINE.get());
		fluid(TechnologicaBlocks.BROMINE.get());
		fluid(TechnologicaBlocks.CHLORINE.get());
		fluid(TechnologicaBlocks.COOLANT.get());
		fluid(TechnologicaBlocks.FLUORINE.get());
		fluid(TechnologicaBlocks.GASOLINE.get());
		fluid(TechnologicaBlocks.HELIUM.get());
		fluid(TechnologicaBlocks.HYDROGEN.get());
		fluid(TechnologicaBlocks.KRYPTON.get());
		fluid(TechnologicaBlocks.MACHINE_OIL.get());
		fluid(TechnologicaBlocks.MAPLE_SYRUP.get());
		fluid(TechnologicaBlocks.MERCURY.get());
		fluid(TechnologicaBlocks.NATURAL_GAS.get());
		fluid(TechnologicaBlocks.NEON.get());
		fluid(TechnologicaBlocks.NITROGEN.get());
		fluid(TechnologicaBlocks.OIL.get());
		fluid(TechnologicaBlocks.OXYGEN.get());
		fluid(TechnologicaBlocks.RADON.get());
		fluid(TechnologicaBlocks.RUBBER_RESIN.get());
		fluid(TechnologicaBlocks.XENON.get());
		fluid(TechnologicaBlocks.MOLTEN_CORE.get());

		chair(TechnologicaBlocks.ACACIA_CHAIR.get(), new ResourceLocation("block/acacia_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.APRICOT_CHAIR.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.ASPEN_CHAIR.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.AVOCADO_CHAIR.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.BANANA_CHAIR.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.BIRCH_CHAIR.get(), new ResourceLocation("block/birch_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.CHERRY_CHAIR.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.CHESTNUT_CHAIR.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.CINNAMON_CHAIR.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.COCONUT_CHAIR.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.CRIMSON_CHAIR.get(), new ResourceLocation("block/crimson_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.DARK_OAK_CHAIR.get(), new ResourceLocation("block/dark_oak_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.EBONY_CHAIR.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		chair(TechnologicaBlocks.FRUITFUL_CHAIR.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.INFERNAL_CHAIR.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.JUNGLE_CHAIR.get(), new ResourceLocation("block/jungle_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.KIWI_CHAIR.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.LEMON_CHAIR.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.LIME_CHAIR.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.MAHOGANY_CHAIR.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.MAPLE_CHAIR.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.NECROTIC_CHAIR.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.OAK_CHAIR.get(), new ResourceLocation("block/oak_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.OLIVE_CHAIR.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.ORANGE_CHAIR.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.PEACH_CHAIR.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.PEAR_CHAIR.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.PLUM_CHAIR.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.REDWOOD_CHAIR.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.RUBBER_CHAIR.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.SPRUCE_CHAIR.get(), new ResourceLocation("block/spruce_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.TEAK_CHAIR.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.WALNUT_CHAIR.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.WARPED_CHAIR.get(), new ResourceLocation("block/warped_planks"), VanillaModels.SOLID);
		chair(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		table(TechnologicaBlocks.ACACIA_TABLE.get(), new ResourceLocation("block/acacia_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), new TechnologicaLocation("block/alchemical_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.APRICOT_TABLE.get(), new TechnologicaLocation("block/apricot_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.ASPEN_TABLE.get(), new TechnologicaLocation("block/aspen_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.AVOCADO_TABLE.get(), new TechnologicaLocation("block/avocado_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.BANANA_TABLE.get(), new TechnologicaLocation("block/banana_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.BENEVOLENT_TABLE.get(), new TechnologicaLocation("block/benevolent_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.BIRCH_TABLE.get(), new ResourceLocation("block/birch_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.CHERRY_TABLE.get(), new TechnologicaLocation("block/cherry_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.CHESTNUT_TABLE.get(), new TechnologicaLocation("block/chestnut_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.CINNAMON_TABLE.get(), new TechnologicaLocation("block/cinnamon_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.COCONUT_TABLE.get(), new TechnologicaLocation("block/coconut_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), new TechnologicaLocation("block/conductive_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.CRIMSON_TABLE.get(), new ResourceLocation("block/crimson_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.DARK_OAK_TABLE.get(), new ResourceLocation("block/dark_oak_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.EBONY_TABLE.get(), new TechnologicaLocation("block/ebony_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), new TechnologicaLocation("block/frostbitten_planks"), VanillaModels.TRANSLUCENT);
		table(TechnologicaBlocks.FRUITFUL_TABLE.get(), new TechnologicaLocation("block/fruitful_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.INFERNAL_TABLE.get(), new TechnologicaLocation("block/infernal_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.JUNGLE_TABLE.get(), new ResourceLocation("block/jungle_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.KIWI_TABLE.get(), new TechnologicaLocation("block/kiwi_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.LEMON_TABLE.get(), new TechnologicaLocation("block/lemon_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.LIME_TABLE.get(), new TechnologicaLocation("block/lime_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.MAHOGANY_TABLE.get(), new TechnologicaLocation("block/mahogany_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.MALEVOLENT_TABLE.get(), new TechnologicaLocation("block/malevolent_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.MAPLE_TABLE.get(), new TechnologicaLocation("block/maple_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.NECROTIC_TABLE.get(), new TechnologicaLocation("block/necrotic_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.OAK_TABLE.get(), new ResourceLocation("block/oak_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.OLIVE_TABLE.get(), new TechnologicaLocation("block/olive_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.ORANGE_TABLE.get(), new TechnologicaLocation("block/orange_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.PEACH_TABLE.get(), new TechnologicaLocation("block/peach_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.PEAR_TABLE.get(), new TechnologicaLocation("block/pear_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.PLUM_TABLE.get(), new TechnologicaLocation("block/plum_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.REDWOOD_TABLE.get(), new TechnologicaLocation("block/redwood_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.ROSEWOOD_TABLE.get(), new TechnologicaLocation("block/rosewood_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.RUBBER_TABLE.get(), new TechnologicaLocation("block/rubber_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.SPRUCE_TABLE.get(), new ResourceLocation("block/spruce_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.TEAK_TABLE.get(), new TechnologicaLocation("block/teak_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.WALNUT_TABLE.get(), new TechnologicaLocation("block/walnut_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.WARPED_TABLE.get(), new ResourceLocation("block/warped_planks"), VanillaModels.SOLID);
		table(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), new TechnologicaLocation("block/zebrawood_planks"), VanillaModels.SOLID);

		crop4Stage(TechnologicaBlocks.ASPARAGUS.get());
		crop4Stage(TechnologicaBlocks.BROCCOLI.get());
		crop4Stage(TechnologicaBlocks.CELERY.get());
		crop4Stage(TechnologicaBlocks.CHILI_PEPPERS.get());
		crop4Stage(TechnologicaBlocks.COFFEE.get());
		crop4Stage(TechnologicaBlocks.GARLIC.get());
		crop4Stage(TechnologicaBlocks.GINGER.get());
		crop4Stage(TechnologicaBlocks.LETTUCE.get());
		crop4Stage(TechnologicaBlocks.MUSTARD_GREENS.get());
		crop4Stage(TechnologicaBlocks.ONIONS.get());
		crop4Stage(TechnologicaBlocks.PEANUTS.get());
		crop4Stage(TechnologicaBlocks.PEAS.get());
		crop4Stage(TechnologicaBlocks.PINEAPPLES.get());
		crop4Stage(TechnologicaBlocks.PURPLE_CABBAGE.get());
		crop4Stage(TechnologicaBlocks.RADISHES.get());
		crop4Stage(TechnologicaBlocks.RED_BEANS.get());
		crop4Stage(TechnologicaBlocks.SOY_BEANS.get());
		crop4Stage(TechnologicaBlocks.SWEET_POTATOES.get());
		crop4Stage(TechnologicaBlocks.TEA.get());
		crop4Stage(TechnologicaBlocks.TURNIPS.get());
		crop8Stage(TechnologicaBlocks.BARLEY.get());
		crop8Stage(TechnologicaBlocks.OATS.get());
		crop8Stage(TechnologicaBlocks.RYE.get());
		bush4Stage(TechnologicaBlocks.BLACKBERRY_BUSH.get());
		bush4Stage(TechnologicaBlocks.BLUEBERRY_BUSH.get());
		bush4Stage(TechnologicaBlocks.COTTON_BUSH.get());
		bush4Stage(TechnologicaBlocks.RASPBERRY_BUSH.get());
		bush4Stage(TechnologicaBlocks.STRAWBERRY_BUSH.get());
		cropTall8Stage(TechnologicaBlocks.CORN.get());
		cropTall8Stage(TechnologicaBlocks.CRANBERRIES.get());
		cropTall8Stage(TechnologicaBlocks.GRAPES.get());
		cropTall8Stage(TechnologicaBlocks.RICE.get());
		cropTall8Stage(TechnologicaBlocks.TOMATOES.get());
		bushTall8Stage(TechnologicaBlocks.PEPPERCORNS.get());
		stem8Stage(TechnologicaBlocks.CUCUMBER_STEM.get());
		stem8Stage(TechnologicaBlocks.SQUASH_STEM.get());
		stem8Stage(TechnologicaBlocks.ZUCCHINI_STEM.get());
		gourdStem(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get(), ResourceLocationHelper.blockTexture(TechnologicaBlocks.CUCUMBER_STEM.get()));
		gourdStem(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get(), ResourceLocationHelper.blockTexture(TechnologicaBlocks.SQUASH_STEM.get()));
		gourdStem(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get(), ResourceLocationHelper.blockTexture(TechnologicaBlocks.ZUCCHINI_STEM.get()));
		gourd(TechnologicaBlocks.CUCUMBERS.get());
		gourd(TechnologicaBlocks.SQUASH.get());
		gourd(TechnologicaBlocks.ZUCCHINI.get());

		hexagonalCrystal(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get());
		leafyCrystal(TechnologicaBlocks.AUTUNITE_CRYSTAL.get());
		leafyCrystal(TechnologicaBlocks.BARYTE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get());
		hexagonalCrystal(TechnologicaBlocks.CELESTINE_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.COLUMBITE_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.DOLOMITE_CRYSTAL.get());
		hexagonalCrystal(TechnologicaBlocks.FLUORITE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.MONAZITE_CRYSTAL.get());
		leafyCrystal(TechnologicaBlocks.POLLUCITE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.RUTILE_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.SCHEELITE_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.SPHALERITE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.STIBNITE_CRYSTAL.get());
		spikyCrystal(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get());
		hexagonalCrystal(TechnologicaBlocks.TELLURITE_CRYSTAL.get());
		hexagonalCrystal(TechnologicaBlocks.ULEXITE_CRYSTAL.get());
		hexagonalCrystal(TechnologicaBlocks.VANADINITE_CRYSTAL.get());
		leafyCrystal(TechnologicaBlocks.WULFENITE_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.XENOTIME_CRYSTAL.get());
		cubicCrystal(TechnologicaBlocks.ZIRCON_CRYSTAL.get());
		
		displayCase(TechnologicaBlocks.DISPLAY_CASE.get());
		basinFilled(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		basinFilled(TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
		cubeBottomTop(TechnologicaBlocks.MULCH.get(), new ResourceLocation("block/dirt"), new TechnologicaLocation("block/mulch_side"), new TechnologicaLocation("block/mulch_top"));
		cubeBottomTop(TechnologicaBlocks.NITROGLYCERIN.get(), new TechnologicaLocation("block/nitroglycerin_bottom"), new TechnologicaLocation("block/nitroglycerin_side"), new TechnologicaLocation("block/nitroglycerin_top"));
		
		seaPickle(TechnologicaBlocks.BARNACLE.get());

		byoParent(TechnologicaBlocks.TREE_TAP.get(), TechnologicaModels.TREE_TAP, ResourceLocationHelper.blockTexture(TechnologicaBlocks.TREE_TAP.get()));
		byoParent(TechnologicaBlocks.TRELLIS.get(), TechnologicaModels.TRELLIS, ResourceLocationHelper.blockTexture(TechnologicaBlocks.TRELLIS.get()), VanillaModels.CUTOUT);

		byoParent(TechnologicaBlocks.MONITOR.get(), TechnologicaModels.MONITOR);
		byoParent(TechnologicaBlocks.KEYBOARD.get(), TechnologicaModels.KEYBOARD);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.TAPE_DRIVE.get()) + "_lower"), TechnologicaModels.TAPE_DRIVE_LOWER);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.TAPE_DRIVE.get()) + "_upper"), TechnologicaModels.TAPE_DRIVE_UPPER);

		annunciator(TechnologicaBlocks.ANNUNCIATOR.get());
		basin(TechnologicaBlocks.BASIN.get());
		hopper(TechnologicaBlocks.FAST_HOPPER.get());
		glue(TechnologicaBlocks.GLUE.get());
		byoParentNoTexture(TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), VanillaModels.CHAIN, VanillaModels.CUTOUT_MIPPED);

		byoParent(TechnologicaBlocks.SMALL_PULLEY.get(), TechnologicaModels.SMALL_PULLEY, new TechnologicaLocation("block/pulley"));
		byoParent(TechnologicaBlocks.MEDIUM_PULLEY.get(), TechnologicaModels.MEDIUM_PULLEY, new TechnologicaLocation("block/pulley"));
		byoParent(TechnologicaBlocks.LARGE_PULLEY.get(), TechnologicaModels.LARGE_PULLEY, new TechnologicaLocation("block/pulley"));
		byoParent(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), TechnologicaModels.LINE_SHAFT_HANGER);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2"), TechnologicaModels.LINE_SHAFT_HANGER2);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "_shaft"), TechnologicaModels.LINE_SHAFT_HANGER_SHAFT);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2_shaft"), TechnologicaModels.LINE_SHAFT_HANGER2_SHAFT);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT.get()) + "_no_pulley"), TechnologicaModels.LINE_SHAFT_NO_PULLEY);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT.get()) + "_small_pulley"), TechnologicaModels.LINE_SHAFT_SMALL_PULLEY);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT.get()) + "_medium_pulley"), TechnologicaModels.LINE_SHAFT_MEDIUM_PULLEY);
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.LINE_SHAFT.get()) + "_large_pulley"), TechnologicaModels.LINE_SHAFT_LARGE_PULLEY);
		byoParent(TechnologicaBlocks.MOTOR_1HP.get(), TechnologicaModels.MOTOR, new TechnologicaLocation("block/motor_1hp"));
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.MOTOR_1HP.get()) + "2"), TechnologicaModels.MOTOR2, new TechnologicaLocation("block/motor_1hp"));
		byoParent(TechnologicaBlocks.MOTOR_5HP.get(), TechnologicaModels.MOTOR, new TechnologicaLocation("block/motor_5hp"));
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.MOTOR_5HP.get()) + "2"), TechnologicaModels.MOTOR2, new TechnologicaLocation("block/motor_5hp"));
		byoParent(TechnologicaBlocks.MOTOR_20HP.get(), TechnologicaModels.MOTOR, new TechnologicaLocation("block/motor_20hp"));
		byoParent(new TechnologicaLocation(ResourceLocationHelper.path(TechnologicaBlocks.MOTOR_20HP.get()) + "2"), TechnologicaModels.MOTOR2, new TechnologicaLocation("block/motor_20hp"));
		sleepingBag(TechnologicaBlocks.SLEEPING_BAG.get());
		sawmill(TechnologicaBlocks.SAWMILL.get());
		sawmillCore(TechnologicaBlocks.SAWMILL_CORE.get());
	}

	private static void blockModelCubeAll(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.blockCubeAll(block));
	}

	private static void cubeAllRenderType(Block block, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.blockCubeAllRenderType(block, renderType));
	}

	private static void cubeBottomTop(Block block, ResourceLocation bottom, ResourceLocation side, ResourceLocation top) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.cubeBottomTop(block, bottom, side, top));
	}

	private static void bookshelf(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.cubeColumn(block, ResourceLocationHelper.blockTexture(block), texture, renderType));
	}

	private static void log(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.cubeColumn(block, ResourceLocationHelper.blockTexture(block), texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_horizontal"), VanillaModels.cubeColumnHorizontal(block, ResourceLocationHelper.blockTexture(block), texture, renderType));
	}

	private static void wood(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.cubeColumn(block, texture, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_horizontal"), VanillaModels.cubeColumnHorizontal(block, texture, texture, renderType));
	}

	private static void slab(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.slab(block, texture, texture, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top"), VanillaModels.slabTop(block, texture, texture, texture, renderType));
	}

	private static void stairs(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.stairs(block, texture, texture, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_inner"), VanillaModels.stairsInner(block, texture, texture, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_outer"), VanillaModels.stairsOuter(block, texture, texture, texture, renderType));
	}

	private static void fence(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_post"), VanillaModels.fencePost(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_side"), VanillaModels.fenceSide(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_inventory"), VanillaModels.fenceInventory(block, texture, renderType));
	}

	private static void fenceGate(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.fenceGate(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_open"), VanillaModels.fenceGateOpen(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_wall"), VanillaModels.fenceGateWall(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_wall_open"), VanillaModels.fenceGateWallOpen(block, texture, renderType));
	}

	private static void door(Block block, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_left"), VanillaModels.doorBottomLeft(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_left_open"), VanillaModels.doorBottomLeftOpen(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_right"), VanillaModels.doorBottomRight(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_right_open"), VanillaModels.doorBottomRightOpen(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_left"), VanillaModels.doorTopLeft(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_left_open"), VanillaModels.doorTopLeftOpen(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_right"), VanillaModels.doorTopRight(block, bottom, top, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_right_open"), VanillaModels.doorTopRightOpen(block, bottom, top, renderType));
	}

	private static void trapdoor(Block block, ResourceLocation renderType) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom"), VanillaModels.trapdoorBottom(block, ResourceLocationHelper.blockTexture(block), renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_open"), VanillaModels.trapdoorOpen(block, ResourceLocationHelper.blockTexture(block), renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top"), VanillaModels.trapdoorTop(block, ResourceLocationHelper.blockTexture(block), renderType));
	}

	private static void button(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block)), VanillaModels.button(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_pressed"), VanillaModels.buttonPressed(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_inventory"), VanillaModels.buttonInventory(block, texture, renderType));
	}

	private static void pressurePlate(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.pressurePlate(block, texture, renderType));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_down"), VanillaModels.pressurePlateDown(block, texture, renderType));
	}

	private static void sign(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.sign(block, texture, renderType));
	}

	private static void sapling(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.sapling(block));
	}

	private static void pottedSapling(Block block, ResourceLocation texture) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.pottedSapling(block, texture));
	}

	private static void crop4Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage0"), VanillaModels.crop(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage1"), VanillaModels.crop(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage2"), VanillaModels.crop(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage3"), VanillaModels.crop(block, 3));
	}

	private static void crop8Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage0"), VanillaModels.crop(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage1"), VanillaModels.crop(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage2"), VanillaModels.crop(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage3"), VanillaModels.crop(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage4"), VanillaModels.crop(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage5"), VanillaModels.crop(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage6"), VanillaModels.crop(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage7"), VanillaModels.crop(block, 7));
	}

	private static void bush4Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage0"), VanillaModels.bush(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage1"), VanillaModels.bush(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage2"), VanillaModels.bush(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage3"), VanillaModels.bush(block, 3));
	}

	private static void fluid(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.fluid(block));
	}

	private static void cropTall8Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage0"), TechnologicaModels.cropBottom(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage1"), TechnologicaModels.cropBottom(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage2"), TechnologicaModels.cropBottom(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage3"), TechnologicaModels.cropBottom(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage4"), TechnologicaModels.cropBottom(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage5"), TechnologicaModels.cropBottom(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage6"), TechnologicaModels.cropBottom(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage7"), TechnologicaModels.cropBottom(block, 7));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage0"), TechnologicaModels.cropTop(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage1"), TechnologicaModels.cropTop(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage2"), TechnologicaModels.cropTop(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage3"), TechnologicaModels.cropTop(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage4"), TechnologicaModels.cropTop(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage5"), TechnologicaModels.cropTop(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage6"), TechnologicaModels.cropTop(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage7"), TechnologicaModels.cropTop(block, 7));
	}

	private static void bushTall8Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage0"), TechnologicaModels.bushBottom(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage1"), TechnologicaModels.bushBottom(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage2"), TechnologicaModels.bushBottom(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage3"), TechnologicaModels.bushBottom(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage4"), TechnologicaModels.bushBottom(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage5"), TechnologicaModels.bushBottom(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage6"), TechnologicaModels.bushBottom(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_bottom_stage7"), TechnologicaModels.bushBottom(block, 7));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage0"), TechnologicaModels.bushTop(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage1"), TechnologicaModels.bushTop(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage2"), TechnologicaModels.bushTop(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage3"), TechnologicaModels.bushTop(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage4"), TechnologicaModels.bushTop(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage5"), TechnologicaModels.bushTop(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage6"), TechnologicaModels.bushTop(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_stage7"), TechnologicaModels.bushTop(block, 7));
	}

	private static void chair(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.chair(block, texture, renderType));
	}

	private static void table(Block block, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.table(block, texture, renderType));
	}

	private static void cubicCrystal(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.cubicCrystal(block));
	}

	private static void hexagonalCrystal(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.hexagonalCrystal(block));
	}

	private static void leafyCrystal(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.leafyCrystal(block));
	}

	private static void spikyCrystal(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.spikyCrystal(block));
	}

	private static void gourd(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.gourd(block));
	}

	private static void gourdStem(Block block, ResourceLocation texture) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.gourdStem(block, texture));
	}

	private static void stem8Stage(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage0"), VanillaModels.stemGrowth(block, 0));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage1"), VanillaModels.stemGrowth(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage2"), VanillaModels.stemGrowth(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage3"), VanillaModels.stemGrowth(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage4"), VanillaModels.stemGrowth(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage5"), VanillaModels.stemGrowth(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage6"), VanillaModels.stemGrowth(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_stage7"), VanillaModels.stemGrowth(block, 7));
	}

	private static void basin(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.basin(block));
	}

	private static void hollowLog(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.hollowLog(block));
	}

	private static void displayCase(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.displayCase(block));
	}

	private static void hopper(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.hopper(block));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_side"), TechnologicaModels.hopperSide(block));
	}

	private static void sleepingBag(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top"), TechnologicaModels.sleepingBagTop(block));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_top_head"), TechnologicaModels.sleepingBagTopHead(block));
	}

	private static void glue(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.glue(block));
	}

	private static void basinFilled(Block block) {
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level1"), TechnologicaModels.basin(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level2"), TechnologicaModels.basin(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level3"), TechnologicaModels.basin(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level4"), TechnologicaModels.basin(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level5"), TechnologicaModels.basin(block, 5));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level6"), TechnologicaModels.basin(block, 6));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level7"), TechnologicaModels.basin(block, 7));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level8"), TechnologicaModels.basin(block, 8));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level9"), TechnologicaModels.basin(block, 9));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level10"), TechnologicaModels.basin(block, 10));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level11"), TechnologicaModels.basin(block, 11));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level12"), TechnologicaModels.basin(block, 12));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level13"), TechnologicaModels.basin(block, 13));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level14"), TechnologicaModels.basin(block, 14));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level15"), TechnologicaModels.basin(block, 15));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_level16"), TechnologicaModels.basin(block, 16));
	}

	private static void seaPickle(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.seaPickle(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation("two_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.seaPickle(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation("three_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.seaPickle(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation("four_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.seaPickle(block, 4));
		MODELS_BLOCK.put(new TechnologicaLocation("dead_" + ResourceLocationHelper.path(block)), VanillaModels.deadSeaPickle(block, 1));
		MODELS_BLOCK.put(new TechnologicaLocation("two_dead_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.deadSeaPickle(block, 2));
		MODELS_BLOCK.put(new TechnologicaLocation("three_dead_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.deadSeaPickle(block, 3));
		MODELS_BLOCK.put(new TechnologicaLocation("four_dead_" + ResourceLocationHelper.path(block) + "s"), VanillaModels.deadSeaPickle(block, 4));
	}

	private static void annunciator(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_lit_info"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_fail"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_fail"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_info"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_info"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_pass"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_pass"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_warn"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_warn"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_lit_fail"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_lit_fail"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_lit_info"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_lit_info"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_lit_pass"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_lit_pass"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "_lit_warn"), VanillaModels.orientable(block, new TechnologicaLocation("block/annunciator_lit_warn"), new TechnologicaLocation("block/annunciator_side"), new TechnologicaLocation("block/annunciator_side")));
	}

	private static void sawmill(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.orientable(block, new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_top_middle")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
	}

	private static void sawmillCore(Block block) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), VanillaModels.orientable(block, new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_top_middle")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_left_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_middle_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "lower_right_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_lower_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_left_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_lower_side_left"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_top_left"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_middle_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_lower_side_middle"), new TechnologicaLocation("block/sawmill_upper_side_middle"), new TechnologicaLocation("block/sawmill_top_middle"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_east"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_north"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_south"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
		MODELS_BLOCK.put(new TechnologicaLocation(ResourceLocationHelper.path(block) + "upper_right_west"), TechnologicaModels.cubeEachFace(block, new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_end"), new TechnologicaLocation("block/sawmill_upper_side_left"), new TechnologicaLocation("block/sawmill_lower_side_right"), new TechnologicaLocation("block/sawmill_upper_side_right"), new TechnologicaLocation("block/sawmill_top_right"), new TechnologicaLocation("block/sawmill_upper_side_end")));
	}
		
	private static void byoParent(Block block, ModelFile parent) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.byoParent(block, parent));
	}

	private static void byoParent(ResourceLocation resourceLocation, ModelFile parent) {
		MODELS_BLOCK.put(resourceLocation, TechnologicaModels.byoParent(resourceLocation, parent));
	}

	private static void byoParent(Block block, ModelFile parent, ResourceLocation texture) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.byoParent(block, parent, texture));
	}

	private static void byoParent(ResourceLocation resourceLocation, ModelFile parent, ResourceLocation texture) {
		MODELS_BLOCK.put(resourceLocation, TechnologicaModels.byoParent(resourceLocation, parent, texture));
	}

	private static void byoParentNoTexture(Block block, ModelFile parent, ResourceLocation texture) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.byoParentNoTexture(block, parent, texture));
	}

	private static void byoParent(Block block, ModelFile parent, ResourceLocation texture, ResourceLocation renderType) {
		MODELS_BLOCK.put(ResourceLocationHelper.key(block), TechnologicaModels.byoParent(block, parent, texture, renderType));
	}
}
