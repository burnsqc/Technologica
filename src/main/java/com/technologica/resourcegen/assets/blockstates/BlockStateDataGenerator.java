package com.technologica.resourcegen.assets.blockstates;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.AnnunciatorOverlay;
import com.technologica.util.MiddleEnd;
import com.technologica.util.Radius;
import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.GlueBlock;
import com.technologica.world.level.block.TallCropBlock;
import com.technologica.world.level.block.TrellisBlock;
import com.technologica.world.level.block.VineCropBlock;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockStateDataGenerator extends BlockStateProvider {
	public BlockStateDataGenerator(PackOutput generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MOD_ID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		cropBlocks();
		plankBlocks();
		saplingBlocks();
		pottedSaplingBlocks();
		logBlocks();
		strippedLogBlocks();
		strippedWoodBlocks();
		woodBlocks();
		leavesBlocks();
		slabBlocks();
		bookshelfBlocks();
		stairsBlocks();
		fenceBlocks();
		buttonBlocks();
		pressurePlateBlocks();
		doorBlocks();
		trapdoorBlocks();
		fenceGateBlocks();
		signBlocks();
		chairBlocks();
		tableBlocks();
		oreBlocks();
		crystalBlocks();
		fluidBlocks();

		simpleBlock(TechnologicaBlocks.MULCH.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_side"), mcLoc("block/dirt"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_top")));
		tallBlock(TechnologicaBlocks.TRELLIS.get(), trellis(TechnologicaBlocks.TRELLIS.get(), blockTexture(TechnologicaBlocks.TRELLIS.get())));
		simpleBlock(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
		twelveDirectionBlockState(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), lineShaftHangerModel(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel2(TechnologicaBlocks.LINE_SHAFT_HANGER.get()));
		lineShaftBlockState(TechnologicaBlocks.LINE_SHAFT.get(), lineShaftNoPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftSmallPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftMediumPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftLargePulleyModel(TechnologicaBlocks.LINE_SHAFT.get()));
		getVariantBuilder(TechnologicaBlocks.SMALL_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.MEDIUM_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.LARGE_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_1HP.get(), motorModel(TechnologicaBlocks.MOTOR_1HP.get()), motor2Model(TechnologicaBlocks.MOTOR_1HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_5HP.get(), motorModel(TechnologicaBlocks.MOTOR_5HP.get()), motor2Model(TechnologicaBlocks.MOTOR_5HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_20HP.get(), motorModel(TechnologicaBlocks.MOTOR_20HP.get()), motor2Model(TechnologicaBlocks.MOTOR_20HP.get()));
		fourDirectionBlockState(TechnologicaBlocks.TREE_TAP.get(), treeTapModel(TechnologicaBlocks.TREE_TAP.get()));
		sawmillBlockState2(TechnologicaBlocks.SAWMILL_CORE.get());
		sawmillBlockState(TechnologicaBlocks.SAWMILL.get());
		annunciatorBlockState(TechnologicaBlocks.ANNUNCIATOR.get());
		createHopper(TechnologicaBlocks.FAST_HOPPER.get());
		simpleBlock(TechnologicaBlocks.NITROGLYCERIN.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_side"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_bottom"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_top")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain").renderType("cutout_mipped"), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain").renderType("cutout_mipped"));
		sleepingBag(TechnologicaBlocks.SLEEPING_BAG.get(), panel("block/sleeping_bag_top_head", "block/sleeping_bag_top_head", "block/sleeping_bag_side", "block/sleeping_bag_bottom"), panel("block/sleeping_bag_top", "block/sleeping_bag_top", "block/sleeping_bag_side", "block/sleeping_bag_bottom"));
		fourDirectionTallBlockState(TechnologicaBlocks.TAPE_DRIVE.get(), tapeDriveLowerModel(TechnologicaBlocks.TAPE_DRIVE.get()), tapeDriveUpperModel(TechnologicaBlocks.TAPE_DRIVE.get()));
		fourDirectionBlockState(TechnologicaBlocks.MONITOR.get(), monitorModel(TechnologicaBlocks.MONITOR.get()));
		fourDirectionBlockState(TechnologicaBlocks.KEYBOARD.get(), keyboardModel(TechnologicaBlocks.KEYBOARD.get()));
		basinBlockState(TechnologicaBlocks.BASIN.get(), basin(name(TechnologicaBlocks.BASIN.get()), "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side"));
		basinFilledBlockState(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		basinFilledBlockState(TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
		glueBlock(TechnologicaBlocks.GLUE.get());

		/*
		 * BLOCK ITEMS
		 */

		simpleBlockItem(TechnologicaBlocks.APRICOT_LEAVES.get(), cubeAll(TechnologicaBlocks.APRICOT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.ASPEN_LEAVES.get(), cubeAll(TechnologicaBlocks.ASPEN_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_LEAVES.get(), cubeAll(TechnologicaBlocks.AVOCADO_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.BANANA_LEAVES.get(), cubeAll(TechnologicaBlocks.BANANA_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.CHERRY_LEAVES.get(), cubeAll(TechnologicaBlocks.CHERRY_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_LEAVES.get(), cubeAll(TechnologicaBlocks.CHESTNUT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_LEAVES.get(), cubeAll(TechnologicaBlocks.CINNAMON_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.COCONUT_LEAVES.get(), cubeAll(TechnologicaBlocks.COCONUT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.EBONY_LEAVES.get(), cubeAll(TechnologicaBlocks.EBONY_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.KIWI_LEAVES.get(), cubeAll(TechnologicaBlocks.KIWI_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.LEMON_LEAVES.get(), cubeAll(TechnologicaBlocks.LEMON_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.LIME_LEAVES.get(), cubeAll(TechnologicaBlocks.LIME_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_LEAVES.get(), cubeAll(TechnologicaBlocks.MAHOGANY_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.MAPLE_LEAVES.get(), cubeAll(TechnologicaBlocks.MAPLE_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.OLIVE_LEAVES.get(), cubeAll(TechnologicaBlocks.OLIVE_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.ORANGE_LEAVES.get(), cubeAll(TechnologicaBlocks.ORANGE_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.PEACH_LEAVES.get(), cubeAll(TechnologicaBlocks.PEACH_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.PEAR_LEAVES.get(), cubeAll(TechnologicaBlocks.PEAR_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.PLUM_LEAVES.get(), cubeAll(TechnologicaBlocks.PLUM_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_LEAVES.get(), cubeAll(TechnologicaBlocks.REDWOOD_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), cubeAll(TechnologicaBlocks.ROSEWOOD_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.RUBBER_LEAVES.get(), cubeAll(TechnologicaBlocks.RUBBER_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.TEAK_LEAVES.get(), cubeAll(TechnologicaBlocks.TEAK_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.WALNUT_LEAVES.get(), cubeAll(TechnologicaBlocks.WALNUT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), cubeAll(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_LEAVES.get(), cubeAll(TechnologicaBlocks.FRUITFUL_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), cubeAll(TechnologicaBlocks.FROSTBITTEN_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), cubeAll(TechnologicaBlocks.CONDUCTIVE_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), cubeAll(TechnologicaBlocks.ALCHEMICAL_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), cubeAll(TechnologicaBlocks.BENEVOLENT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), cubeAll(TechnologicaBlocks.MALEVOLENT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), cubeAll(TechnologicaBlocks.MALEVOLENT_LEAVES.get()));
		simpleBlockItem(TechnologicaBlocks.CURSED_LEAVES.get(), cubeAll(TechnologicaBlocks.CURSED_LEAVES.get()));

		simpleBlockItem(TechnologicaBlocks.SALT.get(), cubeAll(TechnologicaBlocks.SALT.get()));
		simpleBlockItem(TechnologicaBlocks.LITHIUM_CLAY.get(), cubeAll(TechnologicaBlocks.LITHIUM_CLAY.get()));
		simpleBlockItem(TechnologicaBlocks.OILY_COARSE_DIRT.get(), cubeAll(TechnologicaBlocks.OILY_COARSE_DIRT.get()));
		simpleBlockItem(TechnologicaBlocks.OILY_GRAVEL.get(), cubeAll(TechnologicaBlocks.OILY_GRAVEL.get()));
		simpleBlockItem(TechnologicaBlocks.OILY_RED_SAND.get(), cubeAll(TechnologicaBlocks.OILY_RED_SAND.get()));
		simpleBlockItem(TechnologicaBlocks.OILY_SAND.get(), cubeAll(TechnologicaBlocks.OILY_SAND.get()));
		simpleBlockItem(TechnologicaBlocks.MOON_ROCK.get(), cubeAll(TechnologicaBlocks.MOON_ROCK.get()));
		simpleBlockItem(TechnologicaBlocks.MOON_DUST.get(), cubeAll(TechnologicaBlocks.MOON_DUST.get()));

		simpleBlockItem(TechnologicaBlocks.APATITE_ORE.get(), cubeAll(TechnologicaBlocks.APATITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.ARGENTITE_ORE.get(), cubeAll(TechnologicaBlocks.ARGENTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get(), cubeAll(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.ARSENOPYRITE_ORE.get(), cubeAll(TechnologicaBlocks.ARSENOPYRITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.BASTNAESITE_ORE.get(), cubeAll(TechnologicaBlocks.BASTNAESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.BAUXITE_ORE.get(), cubeAll(TechnologicaBlocks.BAUXITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.BORAX_ORE.get(), cubeAll(TechnologicaBlocks.BORAX_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.CASSITERITE_ORE.get(), cubeAll(TechnologicaBlocks.CASSITERITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.CHROMITE_ORE.get(), cubeAll(TechnologicaBlocks.CHROMITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.CINNABAR_ORE.get(), cubeAll(TechnologicaBlocks.CINNABAR_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.COBALTITE_ORE.get(), cubeAll(TechnologicaBlocks.COBALTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.CROOKESITE_ORE.get(), cubeAll(TechnologicaBlocks.CROOKESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.GADOLINITE_ORE.get(), cubeAll(TechnologicaBlocks.GADOLINITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.GALENA_ORE.get(), cubeAll(TechnologicaBlocks.GALENA_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.GARNIERITE_ORE.get(), cubeAll(TechnologicaBlocks.GARNIERITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.ILMENITE_ORE.get(), cubeAll(TechnologicaBlocks.ILMENITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.LEPIDOLITE_ORE.get(), cubeAll(TechnologicaBlocks.LEPIDOLITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.MAGNESITE_ORE.get(), cubeAll(TechnologicaBlocks.MAGNESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.MOLYBDENITE_ORE.get(), cubeAll(TechnologicaBlocks.MOLYBDENITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.OSMIRIDIUM_ORE.get(), cubeAll(TechnologicaBlocks.OSMIRIDIUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get(), cubeAll(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PATRONITE_ORE.get(), cubeAll(TechnologicaBlocks.PATRONITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PENTLANDITE_ORE.get(), cubeAll(TechnologicaBlocks.PENTLANDITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PHOSPHORITE_ORE.get(), cubeAll(TechnologicaBlocks.PHOSPHORITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PLATINUM_ORE.get(), cubeAll(TechnologicaBlocks.PLATINUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.NETHER_PLATINUM_ORE.get(), cubeAll(TechnologicaBlocks.NETHER_PLATINUM_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PYROLUSITE_ORE.get(), cubeAll(TechnologicaBlocks.PYROLUSITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.RUBY_ORE.get(), cubeAll(TechnologicaBlocks.RUBY_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.SAPPHIRE_ORE.get(), cubeAll(TechnologicaBlocks.SAPPHIRE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.SPODUMENE_ORE.get(), cubeAll(TechnologicaBlocks.SPODUMENE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.SYLVANITE_ORE.get(), cubeAll(TechnologicaBlocks.SYLVANITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get(), cubeAll(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.TANTALITE_ORE.get(), cubeAll(TechnologicaBlocks.TANTALITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.THORIANITE_ORE.get(), cubeAll(TechnologicaBlocks.THORIANITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.TOPAZ_ORE.get(), cubeAll(TechnologicaBlocks.TOPAZ_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.URANINITE_ORE.get(), cubeAll(TechnologicaBlocks.URANINITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.WOLFRAMITE_ORE.get(), cubeAll(TechnologicaBlocks.WOLFRAMITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(), cubeAll(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_RUBY.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_RUBY.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TOPAZ.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TOPAZ.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_LITHIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_LITHIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TITANIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TITANIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_VANADIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_VANADIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_MANGANESE.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_MANGANESE.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_COBALT.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_COBALT.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_NICKEL.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_NICKEL.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ZINC.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ZINC.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_GALLIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_GALLIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_RHODIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_RHODIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_SILVER.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_SILVER.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_CADMIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_CADMIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_INDIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_INDIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TIN.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TIN.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TANTALUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TANTALUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_RHENIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_RHENIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_OSMIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_OSMIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_PLATINUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_PLATINUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_THALLUIM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_THALLUIM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_LEAD.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_LEAD.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BISMUTH.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BISMUTH.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_POLONIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_POLONIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_THORIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_THORIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_URANIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_URANIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_CURIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_CURIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_FERMIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_FERMIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BRONZE.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BRONZE.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BRASS.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BRASS.get()));

		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_BORON.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_BORON.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_CARBON.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_CARBON.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_SILICON.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_SILICON.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_SULFUR.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_SULFUR.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ARSENIC.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ARSENIC.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_SELENIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_SELENIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_IODINE.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_IODINE.get()));
		simpleBlockItem(TechnologicaBlocks.BLOCK_OF_ASTATINE.get(), cubeAll(TechnologicaBlocks.BLOCK_OF_ASTATINE.get()));

		simpleBlockItem(TechnologicaBlocks.APRICOT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.APRICOT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.APRICOT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_LOG.get()), blockTexture(TechnologicaBlocks.ASPEN_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.ASPEN_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_LOG.get()), blockTexture(TechnologicaBlocks.AVOCADO_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.AVOCADO_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.BANANA_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_LOG.get()), blockTexture(TechnologicaBlocks.BANANA_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.BANANA_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_LOG.get()), blockTexture(TechnologicaBlocks.CHERRY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.CHERRY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_LOG.get()), blockTexture(TechnologicaBlocks.CHESTNUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.CHESTNUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_LOG.get()), blockTexture(TechnologicaBlocks.CINNAMON_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.CINNAMON_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_LOG.get()), blockTexture(TechnologicaBlocks.COCONUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.COCONUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.EBONY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_LOG.get()), blockTexture(TechnologicaBlocks.EBONY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.EBONY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.KIWI_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_LOG.get()), blockTexture(TechnologicaBlocks.KIWI_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.KIWI_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.LEMON_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_LOG.get()), blockTexture(TechnologicaBlocks.LEMON_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.LEMON_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.LIME_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_LOG.get()), blockTexture(TechnologicaBlocks.LIME_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.LIME_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_LOG.get()), blockTexture(TechnologicaBlocks.MAHOGANY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.MAHOGANY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_LOG.get()), blockTexture(TechnologicaBlocks.MAPLE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.MAPLE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_LOG.get()), blockTexture(TechnologicaBlocks.OLIVE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.OLIVE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_LOG.get()), blockTexture(TechnologicaBlocks.ORANGE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.ORANGE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.PEACH_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_LOG.get()), blockTexture(TechnologicaBlocks.PEACH_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.PEACH_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.PEAR_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_LOG.get()), blockTexture(TechnologicaBlocks.PEAR_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.PEAR_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.PLUM_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_LOG.get()), blockTexture(TechnologicaBlocks.PLUM_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.PLUM_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_LOG.get()), blockTexture(TechnologicaBlocks.REDWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.REDWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_LOG.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.ROSEWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_LOG.get()), blockTexture(TechnologicaBlocks.RUBBER_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.RUBBER_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.TEAK_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_LOG.get()), blockTexture(TechnologicaBlocks.TEAK_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.TEAK_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_LOG.get()), blockTexture(TechnologicaBlocks.WALNUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.WALNUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_LOG.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.ZEBRAWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_LOG.get()), blockTexture(TechnologicaBlocks.FRUITFUL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.FRUITFUL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_LOG.get(), hollowLogModel(TechnologicaBlocks.FROSTBITTEN_LOG.get()));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_LOG.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.CONDUCTIVE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_LOG.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.ALCHEMICAL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.BENEVOLENT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.MALEVOLENT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_LOG.get()), blockTexture(TechnologicaBlocks.INFERNAL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.INFERNAL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_LOG.get()), blockTexture(TechnologicaBlocks.NECROTIC_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.NECROTIC_LOG.get()) + "_top")));

		simpleBlockItem(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BANANA_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_BANANA_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_EBONY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_KIWI_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_KIWI_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LEMON_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_LEMON_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_LIME_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LIME_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_LIME_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_LIME_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEACH_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PEACH_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEAR_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PEAR_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PLUM_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PLUM_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TEAK_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_TEAK_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get()) + "_top")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get()) + "_top")));

		simpleBlockItem(TechnologicaBlocks.APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.BANANA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.EBONY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.KIWI_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.LEMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.LIME_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.PEACH_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.PEAR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.PLUM_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.TEAK_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log")));

		simpleBlockItem(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log")));
		simpleBlockItem(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log")));

		simpleBlockItem(TechnologicaBlocks.APRICOT_PLANKS.get(), cubeAll(TechnologicaBlocks.APRICOT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.ASPEN_PLANKS.get(), cubeAll(TechnologicaBlocks.ASPEN_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_PLANKS.get(), cubeAll(TechnologicaBlocks.AVOCADO_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.BANANA_PLANKS.get(), cubeAll(TechnologicaBlocks.BANANA_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.CHERRY_PLANKS.get(), cubeAll(TechnologicaBlocks.CHERRY_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_PLANKS.get(), cubeAll(TechnologicaBlocks.CHESTNUT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_PLANKS.get(), cubeAll(TechnologicaBlocks.CINNAMON_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.COCONUT_PLANKS.get(), cubeAll(TechnologicaBlocks.COCONUT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.EBONY_PLANKS.get(), cubeAll(TechnologicaBlocks.EBONY_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.KIWI_PLANKS.get(), cubeAll(TechnologicaBlocks.KIWI_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.LEMON_PLANKS.get(), cubeAll(TechnologicaBlocks.LEMON_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.LIME_PLANKS.get(), cubeAll(TechnologicaBlocks.LIME_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_PLANKS.get(), cubeAll(TechnologicaBlocks.MAHOGANY_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.MAPLE_PLANKS.get(), cubeAll(TechnologicaBlocks.MAPLE_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.OLIVE_PLANKS.get(), cubeAll(TechnologicaBlocks.OLIVE_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.ORANGE_PLANKS.get(), cubeAll(TechnologicaBlocks.ORANGE_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.PEACH_PLANKS.get(), cubeAll(TechnologicaBlocks.PEACH_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.PEAR_PLANKS.get(), cubeAll(TechnologicaBlocks.PEAR_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.PLUM_PLANKS.get(), cubeAll(TechnologicaBlocks.PLUM_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_PLANKS.get(), cubeAll(TechnologicaBlocks.REDWOOD_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), cubeAll(TechnologicaBlocks.ROSEWOOD_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.RUBBER_PLANKS.get(), cubeAll(TechnologicaBlocks.RUBBER_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.TEAK_PLANKS.get(), cubeAll(TechnologicaBlocks.TEAK_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.WALNUT_PLANKS.get(), cubeAll(TechnologicaBlocks.WALNUT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), cubeAll(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_PLANKS.get(), cubeAll(TechnologicaBlocks.FRUITFUL_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), cubeAll(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), cubeAll(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), cubeAll(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), cubeAll(TechnologicaBlocks.BENEVOLENT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), cubeAll(TechnologicaBlocks.MALEVOLENT_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_PLANKS.get(), cubeAll(TechnologicaBlocks.INFERNAL_PLANKS.get()));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_PLANKS.get(), cubeAll(TechnologicaBlocks.NECROTIC_PLANKS.get()));

		simpleBlockItem(TechnologicaBlocks.APRICOT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.EBONY_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.KIWI_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.TEAK_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_SLAB.get()), "_slab", "_planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_SLAB.get()), "_slab", "_planks")));

		simpleBlockItem(TechnologicaBlocks.APRICOT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.EBONY_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.KIWI_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.TEAK_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_STAIRS.get()), "_stairs", "_planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks")));

		simpleBlockItem(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.EBONY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.KIWI_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.TEAK_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.WARPED_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), "bookshelf", "planks")));

		simpleBlockItem(TechnologicaBlocks.APRICOT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks")).renderType("solid").renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.ASPEN_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.BANANA_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.CHERRY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.COCONUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.EBONY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.KIWI_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.LEMON_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.LIME_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.LIME_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.MAPLE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.OLIVE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.ORANGE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.PEACH_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.PEAR_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.PLUM_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.RUBBER_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.TEAK_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.WALNUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()), "_fence", "_planks")).renderType("translucent"));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()), "_fence", "_planks")).renderType("solid"));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()), "_fence", "_planks")).renderType("solid"));

		simpleBlockItem(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.EBONY_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.KIWI_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.TEAK_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE_GATE.get()), "_fence_gate", "_planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE_GATE.get()), "_fence_gate", "_planks")));

		doorBlockItem(TechnologicaBlocks.APRICOT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.ASPEN_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.AVOCADO_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.BANANA_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.CHERRY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.CHESTNUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.CINNAMON_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.COCONUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.EBONY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.KIWI_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.LEMON_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.LIME_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.MAHOGANY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.MAPLE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.OLIVE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.ORANGE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.PEACH_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.PEAR_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.PLUM_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.REDWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.ROSEWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.RUBBER_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.TEAK_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.WALNUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.FRUITFUL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "translucent");
		doorBlockItem(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.BENEVOLENT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.MALEVOLENT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.INFERNAL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
		doorBlockItem(TechnologicaBlocks.NECROTIC_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");

		simpleBlockItem(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.ASPEN_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.ASPEN_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.AVOCADO_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.BANANA_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.BANANA_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.CHERRY_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.CHERRY_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.CINNAMON_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.COCONUT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.COCONUT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.EBONY_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.EBONY_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.KIWI_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.KIWI_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.LEMON_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.LEMON_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.LIME_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.LIME_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.MAPLE_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.MAPLE_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.OLIVE_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.OLIVE_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.ORANGE_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.ORANGE_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.PEACH_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.PEACH_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.PEAR_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.PEAR_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.PLUM_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.PLUM_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.REDWOOD_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.RUBBER_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.RUBBER_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.TEAK_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.TEAK_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.WALNUT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.WALNUT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.INFERNAL_TRAPDOOR.get())));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.NECROTIC_TRAPDOOR.get())));

		simpleBlockItem(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ASPEN_CHAIR.get(), chairModel(TechnologicaBlocks.ASPEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_CHAIR.get(), chairModel(TechnologicaBlocks.AVOCADO_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BANANA_CHAIR.get(), chairModel(TechnologicaBlocks.BANANA_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BIRCH_CHAIR.get(), chairModel(TechnologicaBlocks.BIRCH_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.CHERRY_CHAIR.get(), chairModel(TechnologicaBlocks.CHERRY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_CHAIR.get(), chairModel(TechnologicaBlocks.CHESTNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_CHAIR.get(), chairModel(TechnologicaBlocks.CINNAMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.COCONUT_CHAIR.get(), chairModel(TechnologicaBlocks.COCONUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.DARK_OAK_CHAIR.get(), chairModel(TechnologicaBlocks.DARK_OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.EBONY_CHAIR.get(), chairModel(TechnologicaBlocks.EBONY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.JUNGLE_CHAIR.get(), chairModel(TechnologicaBlocks.JUNGLE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.KIWI_CHAIR.get(), chairModel(TechnologicaBlocks.KIWI_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.LEMON_CHAIR.get(), chairModel(TechnologicaBlocks.LEMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.LIME_CHAIR.get(), chairModel(TechnologicaBlocks.LIME_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_CHAIR.get(), chairModel(TechnologicaBlocks.MAHOGANY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MAPLE_CHAIR.get(), chairModel(TechnologicaBlocks.MAPLE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.OAK_CHAIR.get(), chairModel(TechnologicaBlocks.OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.OLIVE_CHAIR.get(), chairModel(TechnologicaBlocks.OLIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ORANGE_CHAIR.get(), chairModel(TechnologicaBlocks.ORANGE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PEACH_CHAIR.get(), chairModel(TechnologicaBlocks.PEACH_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PEAR_CHAIR.get(), chairModel(TechnologicaBlocks.PEAR_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PLUM_CHAIR.get(), chairModel(TechnologicaBlocks.PLUM_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.REDWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.RUBBER_CHAIR.get(), chairModel(TechnologicaBlocks.RUBBER_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.SPRUCE_CHAIR.get(), chairModel(TechnologicaBlocks.SPRUCE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.TEAK_CHAIR.get(), chairModel(TechnologicaBlocks.TEAK_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.WALNUT_CHAIR.get(), chairModel(TechnologicaBlocks.WALNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_CHAIR.get(), chairModel(TechnologicaBlocks.FRUITFUL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), chairModel(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_CHAIR.get()), "chair", "planks"), "translucent"));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), chairModel(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), chairModel(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_CHAIR.get(), chairModel(TechnologicaBlocks.INFERNAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_CHAIR.get()), "chair", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_CHAIR.get(), chairModel(TechnologicaBlocks.NECROTIC_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_CHAIR.get()), "chair", "planks"), "solid"));

		simpleBlockItem(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ASPEN_TABLE.get(), tableModel(TechnologicaBlocks.ASPEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_TABLE.get(), tableModel(TechnologicaBlocks.AVOCADO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BANANA_TABLE.get(), tableModel(TechnologicaBlocks.BANANA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BIRCH_TABLE.get(), tableModel(TechnologicaBlocks.BIRCH_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.CHERRY_TABLE.get(), tableModel(TechnologicaBlocks.CHERRY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_TABLE.get(), tableModel(TechnologicaBlocks.CHESTNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_TABLE.get(), tableModel(TechnologicaBlocks.CINNAMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.COCONUT_TABLE.get(), tableModel(TechnologicaBlocks.COCONUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.CRIMSON_TABLE.get(), tableModel(TechnologicaBlocks.CRIMSON_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.DARK_OAK_TABLE.get(), tableModel(TechnologicaBlocks.DARK_OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.EBONY_TABLE.get(), tableModel(TechnologicaBlocks.EBONY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.JUNGLE_TABLE.get(), tableModel(TechnologicaBlocks.JUNGLE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.KIWI_TABLE.get(), tableModel(TechnologicaBlocks.KIWI_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.LEMON_TABLE.get(), tableModel(TechnologicaBlocks.LEMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.LIME_TABLE.get(), tableModel(TechnologicaBlocks.LIME_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_TABLE.get(), tableModel(TechnologicaBlocks.MAHOGANY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MAPLE_TABLE.get(), tableModel(TechnologicaBlocks.MAPLE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.OAK_TABLE.get(), tableModel(TechnologicaBlocks.OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.OLIVE_TABLE.get(), tableModel(TechnologicaBlocks.OLIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ORANGE_TABLE.get(), tableModel(TechnologicaBlocks.ORANGE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PEACH_TABLE.get(), tableModel(TechnologicaBlocks.PEACH_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PEAR_TABLE.get(), tableModel(TechnologicaBlocks.PEAR_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.PLUM_TABLE.get(), tableModel(TechnologicaBlocks.PLUM_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_TABLE.get(), tableModel(TechnologicaBlocks.REDWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ROSEWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.RUBBER_TABLE.get(), tableModel(TechnologicaBlocks.RUBBER_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.SPRUCE_TABLE.get(), tableModel(TechnologicaBlocks.SPRUCE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.TEAK_TABLE.get(), tableModel(TechnologicaBlocks.TEAK_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.WALNUT_TABLE.get(), tableModel(TechnologicaBlocks.WALNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.WARPED_TABLE.get(), tableModel(TechnologicaBlocks.WARPED_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_TABLE.get(), tableModel(TechnologicaBlocks.FRUITFUL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), tableModel(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_TABLE.get()), "table", "planks"), "translucent"));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), tableModel(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), tableModel(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.BENEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.MALEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_TABLE.get(), tableModel(TechnologicaBlocks.INFERNAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_TABLE.get(), tableModel(TechnologicaBlocks.NECROTIC_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_TABLE.get()), "table", "planks"), "solid"));

		simpleBlockItem(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
		simpleBlockItem(TechnologicaBlocks.NITROGLYCERIN.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_side"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_bottom"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_top")));
	}

	private void cropBlocks() {
		grainCropBlock(TechnologicaBlocks.BARLEY.get());
		grainCropBlock(TechnologicaBlocks.OATS.get());
		grainCropBlock(TechnologicaBlocks.RYE.get());
		tallCropBlock(TechnologicaBlocks.CORN.get());
		tallCropBlock(TechnologicaBlocks.RICE.get());
		replantableCropBlock(TechnologicaBlocks.ASPARAGUS.get());
		replantableCropBlock(TechnologicaBlocks.CHILI_PEPPERS.get());
		replantableCropBlock(TechnologicaBlocks.COFFEE.get());
		replantableCropBlock(TechnologicaBlocks.GARLIC.get());
		replantableCropBlock(TechnologicaBlocks.GINGER.get());
		replantableCropBlock(TechnologicaBlocks.PEAS.get());
		replantableCropBlock(TechnologicaBlocks.PEANUTS.get());
		replantableCropBlock(TechnologicaBlocks.RED_BEANS.get());
		replantableCropBlock(TechnologicaBlocks.SOY_BEANS.get());
		replantableCropBlock(TechnologicaBlocks.SWEET_POTATOES.get());
		seededCropBlock(TechnologicaBlocks.BROCCOLI.get());
		seededCropBlock(TechnologicaBlocks.CELERY.get());
		seededCropBlock(TechnologicaBlocks.LETTUCE.get());
		seededCropBlock(TechnologicaBlocks.MUSTARD_GREENS.get());
		seededCropBlock(TechnologicaBlocks.ONIONS.get());
		seededCropBlock(TechnologicaBlocks.PINEAPPLES.get());
		seededCropBlock(TechnologicaBlocks.PURPLE_CABBAGE.get());
		seededCropBlock(TechnologicaBlocks.RADISHES.get());
		seededCropBlock(TechnologicaBlocks.TEA.get());
		seededCropBlock(TechnologicaBlocks.TURNIPS.get());
		berryBushBlock(TechnologicaBlocks.BLACKBERRY_BUSH.get());
		berryBushBlock(TechnologicaBlocks.BLUEBERRY_BUSH.get());
		berryBushBlock(TechnologicaBlocks.RASPBERRY_BUSH.get());
		berryBushBlock(TechnologicaBlocks.STRAWBERRY_BUSH.get());
		berryBushBlock(TechnologicaBlocks.COTTON_BUSH.get());
		tallBushCropBlock(TechnologicaBlocks.PEPPERCORNS.get());
		vineCropBlock(TechnologicaBlocks.GRAPES.get());
		vineCropBlock(TechnologicaBlocks.TOMATOES.get());
		tallCropBlock(TechnologicaBlocks.CRANBERRY_CROP.get());
		stemCropBlock(TechnologicaBlocks.CUCUMBER_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get()), blockTexture(TechnologicaBlocks.CUCUMBER_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get())));
		fourDirectionBlockState2(TechnologicaBlocks.CUCUMBERS.get(), gourdCropModel(TechnologicaBlocks.CUCUMBERS.get()));
		stemCropBlock(TechnologicaBlocks.SQUASH_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get()), blockTexture(TechnologicaBlocks.SQUASH_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get())));
		fourDirectionBlockState2(TechnologicaBlocks.SQUASH.get(), gourdCropModel(TechnologicaBlocks.SQUASH.get()));
		stemCropBlock(TechnologicaBlocks.ZUCCHINI_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get()), blockTexture(TechnologicaBlocks.ZUCCHINI_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get())));
		fourDirectionBlockState2(TechnologicaBlocks.ZUCCHINI.get(), gourdCropModel(TechnologicaBlocks.ZUCCHINI.get()));
	}

	private void saplingBlocks() {
		simpleBlock(TechnologicaBlocks.APRICOT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_SAPLING.get()), blockTexture(TechnologicaBlocks.APRICOT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ASPEN_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_SAPLING.get()), blockTexture(TechnologicaBlocks.ASPEN_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.AVOCADO_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_SAPLING.get()), blockTexture(TechnologicaBlocks.AVOCADO_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.BANANA_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_SAPLING.get()), blockTexture(TechnologicaBlocks.BANANA_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CHERRY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_SAPLING.get()), blockTexture(TechnologicaBlocks.CHERRY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CHESTNUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.CHESTNUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CINNAMON_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_SAPLING.get()), blockTexture(TechnologicaBlocks.CINNAMON_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.COCONUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_SAPLING.get()), blockTexture(TechnologicaBlocks.COCONUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.EBONY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_SAPLING.get()), blockTexture(TechnologicaBlocks.EBONY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.KIWI_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_SAPLING.get()), blockTexture(TechnologicaBlocks.KIWI_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.LEMON_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_SAPLING.get()), blockTexture(TechnologicaBlocks.LEMON_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.LIME_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_SAPLING.get()), blockTexture(TechnologicaBlocks.LIME_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MAHOGANY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_SAPLING.get()), blockTexture(TechnologicaBlocks.MAHOGANY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MAPLE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_SAPLING.get()), blockTexture(TechnologicaBlocks.MAPLE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.OLIVE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_SAPLING.get()), blockTexture(TechnologicaBlocks.OLIVE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ORANGE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_SAPLING.get()), blockTexture(TechnologicaBlocks.ORANGE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PEACH_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_SAPLING.get()), blockTexture(TechnologicaBlocks.PEACH_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PEAR_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_SAPLING.get()), blockTexture(TechnologicaBlocks.PEAR_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PLUM_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_SAPLING.get()), blockTexture(TechnologicaBlocks.PLUM_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.REDWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.REDWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.RUBBER_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_SAPLING.get()), blockTexture(TechnologicaBlocks.RUBBER_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.TEAK_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_SAPLING.get()), blockTexture(TechnologicaBlocks.TEAK_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.WALNUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.WALNUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()), blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()), blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()), blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()), blockTexture(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.NECROTIC_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_SAPLING.get()), blockTexture(TechnologicaBlocks.NECROTIC_SAPLING.get())).renderType("cutout_mipped"));
	}

	private void pottedSaplingBlocks() {
		simpleBlock(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
	}

	private void plankBlocks() {
		simpleBlockWithRenderType(TechnologicaBlocks.APRICOT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.ASPEN_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.AVOCADO_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.BANANA_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.CHERRY_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.CHESTNUT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.CINNAMON_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.COCONUT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.EBONY_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.KIWI_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.LEMON_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.LIME_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.MAHOGANY_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.MAPLE_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.OLIVE_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.ORANGE_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.PEACH_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.PEAR_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.PLUM_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.REDWOOD_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.RUBBER_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.TEAK_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.WALNUT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.FRUITFUL_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), "translucent");
		simpleBlockWithRenderType(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.INFERNAL_PLANKS.get(), "solid");
		simpleBlockWithRenderType(TechnologicaBlocks.NECROTIC_PLANKS.get(), "solid");
	}

	private void logBlocks() {
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.APRICOT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ASPEN_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.AVOCADO_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.BANANA_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CHERRY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CHESTNUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CINNAMON_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.COCONUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.EBONY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.KIWI_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.LEMON_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.LIME_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MAHOGANY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MAPLE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.OLIVE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ORANGE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PEACH_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PEAR_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PLUM_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.REDWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ROSEWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.RUBBER_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.TEAK_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.WALNUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ZEBRAWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.FRUITFUL_LOG.get(), "solid");
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.FROSTBITTEN_LOG.get(), hollowLogModel(TechnologicaBlocks.FROSTBITTEN_LOG.get()), hollowLogModel(TechnologicaBlocks.FROSTBITTEN_LOG.get()));
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CONDUCTIVE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ALCHEMICAL_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.INFERNAL_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.NECROTIC_LOG.get(), "solid");
	}

	private void strippedLogBlocks() {
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LIME_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), "translucent");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), "solid");
		logBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get(), "solid");
	}

	private void strippedWoodBlocks() {
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_BANANA_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_BANANA_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_EBONY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_KIWI_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_KIWI_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_LEMON_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_LEMON_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_LIME_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_LIME_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_PEACH_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PEACH_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_PEAR_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PEAR_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_PLUM_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_PLUM_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_TEAK_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_TEAK_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()), "translucent");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get()), "solid");
	}

	private void woodBlocks() {
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.APRICOT_WOOD.get(), blockTexture(TechnologicaBlocks.APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.APRICOT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ASPEN_WOOD.get(), blockTexture(TechnologicaBlocks.ASPEN_LOG.get()), blockTexture(TechnologicaBlocks.ASPEN_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.AVOCADO_WOOD.get(), blockTexture(TechnologicaBlocks.AVOCADO_LOG.get()), blockTexture(TechnologicaBlocks.AVOCADO_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.BANANA_WOOD.get(), blockTexture(TechnologicaBlocks.BANANA_LOG.get()), blockTexture(TechnologicaBlocks.BANANA_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CHERRY_WOOD.get(), blockTexture(TechnologicaBlocks.CHERRY_LOG.get()), blockTexture(TechnologicaBlocks.CHERRY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CHESTNUT_WOOD.get(), blockTexture(TechnologicaBlocks.CHESTNUT_LOG.get()), blockTexture(TechnologicaBlocks.CHESTNUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CINNAMON_WOOD.get(), blockTexture(TechnologicaBlocks.CINNAMON_LOG.get()), blockTexture(TechnologicaBlocks.CINNAMON_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.COCONUT_WOOD.get(), blockTexture(TechnologicaBlocks.COCONUT_LOG.get()), blockTexture(TechnologicaBlocks.COCONUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.EBONY_WOOD.get(), blockTexture(TechnologicaBlocks.EBONY_LOG.get()), blockTexture(TechnologicaBlocks.EBONY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.KIWI_WOOD.get(), blockTexture(TechnologicaBlocks.KIWI_LOG.get()), blockTexture(TechnologicaBlocks.KIWI_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.LEMON_WOOD.get(), blockTexture(TechnologicaBlocks.LEMON_LOG.get()), blockTexture(TechnologicaBlocks.LEMON_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.LIME_WOOD.get(), blockTexture(TechnologicaBlocks.LIME_LOG.get()), blockTexture(TechnologicaBlocks.LIME_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MAHOGANY_WOOD.get(), blockTexture(TechnologicaBlocks.MAHOGANY_LOG.get()), blockTexture(TechnologicaBlocks.MAHOGANY_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MAPLE_WOOD.get(), blockTexture(TechnologicaBlocks.MAPLE_LOG.get()), blockTexture(TechnologicaBlocks.MAPLE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.OLIVE_WOOD.get(), blockTexture(TechnologicaBlocks.OLIVE_LOG.get()), blockTexture(TechnologicaBlocks.OLIVE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ORANGE_WOOD.get(), blockTexture(TechnologicaBlocks.ORANGE_LOG.get()), blockTexture(TechnologicaBlocks.ORANGE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PEACH_WOOD.get(), blockTexture(TechnologicaBlocks.PEACH_LOG.get()), blockTexture(TechnologicaBlocks.PEACH_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PEAR_WOOD.get(), blockTexture(TechnologicaBlocks.PEAR_LOG.get()), blockTexture(TechnologicaBlocks.PEAR_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.PLUM_WOOD.get(), blockTexture(TechnologicaBlocks.PLUM_LOG.get()), blockTexture(TechnologicaBlocks.PLUM_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.REDWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.REDWOOD_LOG.get()), blockTexture(TechnologicaBlocks.REDWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ROSEWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_LOG.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.RUBBER_WOOD.get(), blockTexture(TechnologicaBlocks.RUBBER_LOG.get()), blockTexture(TechnologicaBlocks.RUBBER_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.TEAK_WOOD.get(), blockTexture(TechnologicaBlocks.TEAK_LOG.get()), blockTexture(TechnologicaBlocks.TEAK_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.WALNUT_WOOD.get(), blockTexture(TechnologicaBlocks.WALNUT_LOG.get()), blockTexture(TechnologicaBlocks.WALNUT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_LOG.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.FRUITFUL_WOOD.get(), blockTexture(TechnologicaBlocks.FRUITFUL_LOG.get()), blockTexture(TechnologicaBlocks.FRUITFUL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.FROSTBITTEN_WOOD.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.CONDUCTIVE_WOOD.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_LOG.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.ALCHEMICAL_WOOD.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_LOG.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_WOOD.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_WOOD.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_LOG.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.INFERNAL_WOOD.get(), blockTexture(TechnologicaBlocks.INFERNAL_LOG.get()), blockTexture(TechnologicaBlocks.INFERNAL_LOG.get()), "solid");
		axisBlockWithRenderType((RotatedPillarBlock) TechnologicaBlocks.NECROTIC_WOOD.get(), blockTexture(TechnologicaBlocks.NECROTIC_LOG.get()), blockTexture(TechnologicaBlocks.NECROTIC_LOG.get()), "solid");
	}

	private void leavesBlocks() {
		simpleBlockWithRenderType(TechnologicaBlocks.APRICOT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.ASPEN_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.AVOCADO_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.BANANA_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.CHERRY_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.CHESTNUT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.CINNAMON_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.COCONUT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.EBONY_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.KIWI_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.LEMON_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.LIME_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.MAHOGANY_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.MAPLE_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.OLIVE_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.ORANGE_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.PEACH_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.PEAR_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.PLUM_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.REDWOOD_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.RUBBER_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.TEAK_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.WALNUT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.FRUITFUL_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), "cutout_mipped");
		simpleBlockWithRenderType(TechnologicaBlocks.CURSED_LEAVES.get(), "cutout_mipped");
	}

	private void slabBlocks() {
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.APRICOT_SLAB.get(), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.ASPEN_SLAB.get(), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.AVOCADO_SLAB.get(), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.BANANA_SLAB.get(), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.CHERRY_SLAB.get(), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.CHESTNUT_SLAB.get(), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.CINNAMON_SLAB.get(), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.COCONUT_SLAB.get(), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.EBONY_SLAB.get(), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.KIWI_SLAB.get(), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.LEMON_SLAB.get(), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.LIME_SLAB.get(), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.MAHOGANY_SLAB.get(), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.MAPLE_SLAB.get(), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.OLIVE_SLAB.get(), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.ORANGE_SLAB.get(), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.PEACH_SLAB.get(), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.PEAR_SLAB.get(), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.PLUM_SLAB.get(), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.REDWOOD_SLAB.get(), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.ROSEWOOD_SLAB.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.RUBBER_SLAB.get(), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.TEAK_SLAB.get(), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.WALNUT_SLAB.get(), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.FRUITFUL_SLAB.get(), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.FROSTBITTEN_SLAB.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), "translucent");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.CONDUCTIVE_SLAB.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.ALCHEMICAL_SLAB.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.BENEVOLENT_SLAB.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.MALEVOLENT_SLAB.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.INFERNAL_SLAB.get(), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), "solid");
		slabBlockWithRenderType((SlabBlock) TechnologicaBlocks.NECROTIC_SLAB.get(), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), "solid");
	}

	private void bookshelfBlocks() {
		simpleBlock(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(Blocks.ACACIA_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BANANA_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(Blocks.BIRCH_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(Blocks.CRIMSON_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(Blocks.DARK_OAK_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.EBONY_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(Blocks.JUNGLE_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.KIWI_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.LEMON_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.LIME_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PEACH_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PEAR_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PLUM_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(Blocks.SPRUCE_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.TEAK_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.WARPED_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(Blocks.WARPED_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get())).renderType("translucent"));
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), models().cubeColumn(name(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get())).renderType("solid"));
	}

	private void stairsBlocks() {
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.APRICOT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.ASPEN_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.AVOCADO_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.BANANA_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.CHERRY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.CHESTNUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.CINNAMON_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.COCONUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.EBONY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.KIWI_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.LEMON_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.LIME_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.MAHOGANY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.MAPLE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.OLIVE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.ORANGE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.PEACH_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.PEAR_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.PLUM_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.REDWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.ROSEWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.RUBBER_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.TEAK_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.WALNUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.FRUITFUL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), "_stairs", "_planks"), "translucent");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.BENEVOLENT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.MALEVOLENT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.INFERNAL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_STAIRS.get()), "_stairs", "_planks"), "solid");
		stairsBlockWithRenderType((StairBlock) TechnologicaBlocks.NECROTIC_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks"), "solid");
	}

	private void fenceBlocks() {
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.APRICOT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.ASPEN_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.AVOCADO_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.BANANA_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.CHERRY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.CHESTNUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.CINNAMON_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.COCONUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.EBONY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.KIWI_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.LEMON_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.LIME_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.MAHOGANY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.MAPLE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.OLIVE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.ORANGE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.PEACH_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.PEAR_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.PLUM_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.REDWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.ROSEWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.RUBBER_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.TEAK_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.WALNUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.FRUITFUL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.FROSTBITTEN_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()), "_fence", "_planks"), "translucent");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.CONDUCTIVE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.ALCHEMICAL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.BENEVOLENT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.MALEVOLENT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.INFERNAL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()), "_fence", "_planks"), "solid");
		fenceBlockWithRenderType((FenceBlock) TechnologicaBlocks.NECROTIC_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()), "_fence", "_planks"), "solid");
	}

	private void buttonBlocks() {
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.APRICOT_BUTTON.get(), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.ASPEN_BUTTON.get(), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.AVOCADO_BUTTON.get(), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.BANANA_BUTTON.get(), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.CHERRY_BUTTON.get(), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.CHESTNUT_BUTTON.get(), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.CINNAMON_BUTTON.get(), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.COCONUT_BUTTON.get(), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.EBONY_BUTTON.get(), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.KIWI_BUTTON.get(), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.LEMON_BUTTON.get(), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.LIME_BUTTON.get(), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.MAHOGANY_BUTTON.get(), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.MAPLE_BUTTON.get(), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.OLIVE_BUTTON.get(), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.ORANGE_BUTTON.get(), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.PEACH_BUTTON.get(), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.PEAR_BUTTON.get(), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.PLUM_BUTTON.get(), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.REDWOOD_BUTTON.get(), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.ROSEWOOD_BUTTON.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.RUBBER_BUTTON.get(), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.TEAK_BUTTON.get(), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.WALNUT_BUTTON.get(), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.FRUITFUL_BUTTON.get(), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), "translucent");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.BENEVOLENT_BUTTON.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.MALEVOLENT_BUTTON.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.INFERNAL_BUTTON.get(), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), "solid");
		buttonBlockWithRenderType((ButtonBlock) TechnologicaBlocks.NECROTIC_BUTTON.get(), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), "solid");
	}

	private void pressurePlateBlocks() {
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), "translucent");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), "solid");
		pressurePlateBlockWithRenderType((PressurePlateBlock) TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get(), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), "solid");
	}

	private void doorBlocks() {
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.APRICOT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.ASPEN_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ASPEN_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ASPEN_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.AVOCADO_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.AVOCADO_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.AVOCADO_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.BANANA_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BANANA_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BANANA_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.CHERRY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHERRY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHERRY_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.CHESTNUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHESTNUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHESTNUT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.CINNAMON_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CINNAMON_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CINNAMON_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.COCONUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.COCONUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.COCONUT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.EBONY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.EBONY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.EBONY_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.KIWI_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.KIWI_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.KIWI_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.LEMON_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LEMON_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LEMON_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.LIME_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LIME_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LIME_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.MAHOGANY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAHOGANY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAHOGANY_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.MAPLE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAPLE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAPLE_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.OLIVE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.OLIVE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.OLIVE_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.ORANGE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ORANGE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ORANGE_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.PEACH_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEACH_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEACH_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.PEAR_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEAR_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEAR_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.PLUM_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PLUM_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PLUM_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.REDWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.ROSEWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.RUBBER_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.TEAK_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.WALNUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.FRUITFUL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FRUITFUL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FRUITFUL_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.FROSTBITTEN_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FROSTBITTEN_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FROSTBITTEN_DOOR.get()), "_top"), "translucent");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.CONDUCTIVE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CONDUCTIVE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CONDUCTIVE_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.ALCHEMICAL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ALCHEMICAL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ALCHEMICAL_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.BENEVOLENT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.MALEVOLENT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.INFERNAL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.INFERNAL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.INFERNAL_DOOR.get()), "_top"), "cutout_mipped");
		doorBlockWithRenderType((DoorBlock) TechnologicaBlocks.NECROTIC_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_top"), "cutout_mipped");
	}

	private void trapdoorBlocks() {
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.APRICOT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.ASPEN_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ASPEN_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.AVOCADO_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.BANANA_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.BANANA_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.CHERRY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CHERRY_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CINNAMON_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.COCONUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.COCONUT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.EBONY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.EBONY_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.KIWI_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.KIWI_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.LEMON_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.LEMON_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.LIME_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.LIME_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.MAPLE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MAPLE_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.OLIVE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.OLIVE_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.ORANGE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ORANGE_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.PEACH_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PEACH_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.PEAR_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PEAR_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.PLUM_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PLUM_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.REDWOOD_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.RUBBER_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.RUBBER_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.TEAK_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.TEAK_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.WALNUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.WALNUT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get()), true, "translucent");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.INFERNAL_TRAPDOOR.get()), true, "cutout_mipped");
		trapdoorBlockWithRenderType((TrapDoorBlock) TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.NECROTIC_TRAPDOOR.get()), true, "cutout_mipped");
	}

	private void fenceGateBlocks() {
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.APRICOT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.ASPEN_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.BANANA_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.CHERRY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.COCONUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.EBONY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.KIWI_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.LEMON_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.LIME_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.MAPLE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.OLIVE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.ORANGE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.PEACH_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.PEAR_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.PLUM_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.RUBBER_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.TEAK_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.WALNUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get()), "_fence_gate", "_planks"), "translucent");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
		fenceGateBlockWithRenderType((FenceGateBlock) TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE_GATE.get()), "_fence_gate", "_planks"), "solid");
	}

	private void signBlocks() {
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.APRICOT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.APRICOT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.ASPEN_SIGN.get(), (WallSignBlock) TechnologicaBlocks.ASPEN_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.AVOCADO_SIGN.get(), (WallSignBlock) TechnologicaBlocks.AVOCADO_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.BANANA_SIGN.get(), (WallSignBlock) TechnologicaBlocks.BANANA_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.CHERRY_SIGN.get(), (WallSignBlock) TechnologicaBlocks.CHERRY_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.CHESTNUT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.CHESTNUT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.CINNAMON_SIGN.get(), (WallSignBlock) TechnologicaBlocks.CINNAMON_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.COCONUT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.COCONUT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.EBONY_SIGN.get(), (WallSignBlock) TechnologicaBlocks.EBONY_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.KIWI_SIGN.get(), (WallSignBlock) TechnologicaBlocks.KIWI_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.LEMON_SIGN.get(), (WallSignBlock) TechnologicaBlocks.LEMON_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.LIME_SIGN.get(), (WallSignBlock) TechnologicaBlocks.LIME_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.LIME_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.MAHOGANY_SIGN.get(), (WallSignBlock) TechnologicaBlocks.MAHOGANY_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.MAPLE_SIGN.get(), (WallSignBlock) TechnologicaBlocks.MAPLE_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.OLIVE_SIGN.get(), (WallSignBlock) TechnologicaBlocks.OLIVE_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.ORANGE_SIGN.get(), (WallSignBlock) TechnologicaBlocks.ORANGE_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.PEACH_SIGN.get(), (WallSignBlock) TechnologicaBlocks.PEACH_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.PEAR_SIGN.get(), (WallSignBlock) TechnologicaBlocks.PEAR_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.PLUM_SIGN.get(), (WallSignBlock) TechnologicaBlocks.PLUM_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.REDWOOD_SIGN.get(), (WallSignBlock) TechnologicaBlocks.REDWOOD_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.ROSEWOOD_SIGN.get(), (WallSignBlock) TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.RUBBER_SIGN.get(), (WallSignBlock) TechnologicaBlocks.RUBBER_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.TEAK_SIGN.get(), (WallSignBlock) TechnologicaBlocks.TEAK_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.WALNUT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.WALNUT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), (WallSignBlock) TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.FRUITFUL_SIGN.get(), (WallSignBlock) TechnologicaBlocks.FRUITFUL_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.FROSTBITTEN_SIGN.get(), (WallSignBlock) TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get()), "translucent");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.CONDUCTIVE_SIGN.get(), (WallSignBlock) TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.ALCHEMICAL_SIGN.get(), (WallSignBlock) TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.BENEVOLENT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.MALEVOLENT_SIGN.get(), (WallSignBlock) TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.INFERNAL_SIGN.get(), (WallSignBlock) TechnologicaBlocks.INFERNAL_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get()), "cutout");
		signBlockWithRenderType((StandingSignBlock) TechnologicaBlocks.NECROTIC_SIGN.get(), (WallSignBlock) TechnologicaBlocks.NECROTIC_WALL_SIGN.get(), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get()), "cutout");
	}

	private void chairBlocks() {
		fourDirectionBlockState(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.ASPEN_CHAIR.get(), chairModel(TechnologicaBlocks.ASPEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.AVOCADO_CHAIR.get(), chairModel(TechnologicaBlocks.AVOCADO_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.BANANA_CHAIR.get(), chairModel(TechnologicaBlocks.BANANA_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.BIRCH_CHAIR.get(), chairModel(TechnologicaBlocks.BIRCH_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.CHERRY_CHAIR.get(), chairModel(TechnologicaBlocks.CHERRY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.CHESTNUT_CHAIR.get(), chairModel(TechnologicaBlocks.CHESTNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.CINNAMON_CHAIR.get(), chairModel(TechnologicaBlocks.CINNAMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.COCONUT_CHAIR.get(), chairModel(TechnologicaBlocks.COCONUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.CRIMSON_CHAIR.get(), chairModel(TechnologicaBlocks.CRIMSON_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.DARK_OAK_CHAIR.get(), chairModel(TechnologicaBlocks.DARK_OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.EBONY_CHAIR.get(), chairModel(TechnologicaBlocks.EBONY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.JUNGLE_CHAIR.get(), chairModel(TechnologicaBlocks.JUNGLE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.KIWI_CHAIR.get(), chairModel(TechnologicaBlocks.KIWI_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.LEMON_CHAIR.get(), chairModel(TechnologicaBlocks.LEMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.LIME_CHAIR.get(), chairModel(TechnologicaBlocks.LIME_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.MAHOGANY_CHAIR.get(), chairModel(TechnologicaBlocks.MAHOGANY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.MAPLE_CHAIR.get(), chairModel(TechnologicaBlocks.MAPLE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.OAK_CHAIR.get(), chairModel(TechnologicaBlocks.OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.OLIVE_CHAIR.get(), chairModel(TechnologicaBlocks.OLIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.ORANGE_CHAIR.get(), chairModel(TechnologicaBlocks.ORANGE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.PEACH_CHAIR.get(), chairModel(TechnologicaBlocks.PEACH_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.PEAR_CHAIR.get(), chairModel(TechnologicaBlocks.PEAR_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.PLUM_CHAIR.get(), chairModel(TechnologicaBlocks.PLUM_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.REDWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.REDWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.RUBBER_CHAIR.get(), chairModel(TechnologicaBlocks.RUBBER_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.SPRUCE_CHAIR.get(), chairModel(TechnologicaBlocks.SPRUCE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.TEAK_CHAIR.get(), chairModel(TechnologicaBlocks.TEAK_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.WALNUT_CHAIR.get(), chairModel(TechnologicaBlocks.WALNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.WARPED_CHAIR.get(), chairModel(TechnologicaBlocks.WARPED_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_CHAIR.get()).getPath(), "chair", "planks")), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.FRUITFUL_CHAIR.get(), chairModel(TechnologicaBlocks.FRUITFUL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), chairModel(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_CHAIR.get()), "chair", "planks"), "translucent"));
		fourDirectionBlockState(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), chairModel(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), chairModel(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.INFERNAL_CHAIR.get(), chairModel(TechnologicaBlocks.INFERNAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_CHAIR.get()), "chair", "planks"), "solid"));
		fourDirectionBlockState(TechnologicaBlocks.NECROTIC_CHAIR.get(), chairModel(TechnologicaBlocks.NECROTIC_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_CHAIR.get()), "chair", "planks"), "solid"));
	}

	private void tableBlocks() {
		simpleBlock(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.ASPEN_TABLE.get(), tableModel(TechnologicaBlocks.ASPEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.AVOCADO_TABLE.get(), tableModel(TechnologicaBlocks.AVOCADO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.BANANA_TABLE.get(), tableModel(TechnologicaBlocks.BANANA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.BIRCH_TABLE.get(), tableModel(TechnologicaBlocks.BIRCH_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.CHERRY_TABLE.get(), tableModel(TechnologicaBlocks.CHERRY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.CHESTNUT_TABLE.get(), tableModel(TechnologicaBlocks.CHESTNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.CINNAMON_TABLE.get(), tableModel(TechnologicaBlocks.CINNAMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.COCONUT_TABLE.get(), tableModel(TechnologicaBlocks.COCONUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.CRIMSON_TABLE.get(), tableModel(TechnologicaBlocks.CRIMSON_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.DARK_OAK_TABLE.get(), tableModel(TechnologicaBlocks.DARK_OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.EBONY_TABLE.get(), tableModel(TechnologicaBlocks.EBONY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.JUNGLE_TABLE.get(), tableModel(TechnologicaBlocks.JUNGLE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.KIWI_TABLE.get(), tableModel(TechnologicaBlocks.KIWI_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.LEMON_TABLE.get(), tableModel(TechnologicaBlocks.LEMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.LIME_TABLE.get(), tableModel(TechnologicaBlocks.LIME_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.MAHOGANY_TABLE.get(), tableModel(TechnologicaBlocks.MAHOGANY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.MAPLE_TABLE.get(), tableModel(TechnologicaBlocks.MAPLE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.OAK_TABLE.get(), tableModel(TechnologicaBlocks.OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.OLIVE_TABLE.get(), tableModel(TechnologicaBlocks.OLIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.ORANGE_TABLE.get(), tableModel(TechnologicaBlocks.ORANGE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.PEACH_TABLE.get(), tableModel(TechnologicaBlocks.PEACH_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.PEAR_TABLE.get(), tableModel(TechnologicaBlocks.PEAR_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.PLUM_TABLE.get(), tableModel(TechnologicaBlocks.PLUM_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.REDWOOD_TABLE.get(), tableModel(TechnologicaBlocks.REDWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ROSEWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.RUBBER_TABLE.get(), tableModel(TechnologicaBlocks.RUBBER_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.SPRUCE_TABLE.get(), tableModel(TechnologicaBlocks.SPRUCE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.TEAK_TABLE.get(), tableModel(TechnologicaBlocks.TEAK_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.WALNUT_TABLE.get(), tableModel(TechnologicaBlocks.WALNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.WARPED_TABLE.get(), tableModel(TechnologicaBlocks.WARPED_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_TABLE.get()).getPath(), "table", "planks")), "solid"));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.FRUITFUL_TABLE.get(), tableModel(TechnologicaBlocks.FRUITFUL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), tableModel(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_TABLE.get()), "table", "planks"), "translucent"));
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), tableModel(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), tableModel(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.BENEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.MALEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.INFERNAL_TABLE.get(), tableModel(TechnologicaBlocks.INFERNAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_TABLE.get()), "table", "planks"), "solid"));
		simpleBlock(TechnologicaBlocks.NECROTIC_TABLE.get(), tableModel(TechnologicaBlocks.NECROTIC_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_TABLE.get()), "table", "planks"), "solid"));
	}

	private void oreBlocks() {
		simpleBlock(TechnologicaBlocks.SALT.get());
		simpleBlock(TechnologicaBlocks.LITHIUM_CLAY.get());
		simpleBlock(TechnologicaBlocks.OILY_COARSE_DIRT.get());
		simpleBlock(TechnologicaBlocks.OILY_GRAVEL.get());
		simpleBlock(TechnologicaBlocks.OILY_RED_SAND.get());
		simpleBlock(TechnologicaBlocks.OILY_SAND.get());
		simpleBlock(TechnologicaBlocks.MOON_ROCK.get());
		simpleBlock(TechnologicaBlocks.MOON_DUST.get());
		simpleBlock(TechnologicaBlocks.APATITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get());
		simpleBlock(TechnologicaBlocks.ARGENTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.ARSENOPYRITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get());
		simpleBlock(TechnologicaBlocks.BASTNAESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.BAUXITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get());
		simpleBlock(TechnologicaBlocks.BORAX_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get());
		simpleBlock(TechnologicaBlocks.CASSITERITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get());
		simpleBlock(TechnologicaBlocks.CHROMITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get());
		simpleBlock(TechnologicaBlocks.CINNABAR_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get());
		simpleBlock(TechnologicaBlocks.COBALTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.CROOKESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.GADOLINITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get());
		simpleBlock(TechnologicaBlocks.GALENA_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get());
		simpleBlock(TechnologicaBlocks.GARNIERITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get());
		simpleBlock(TechnologicaBlocks.ILMENITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get());
		simpleBlock(TechnologicaBlocks.LEPIDOLITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get());
		simpleBlock(TechnologicaBlocks.MAGNESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.MOLYBDENITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get());
		simpleBlock(TechnologicaBlocks.OSMIRIDIUM_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get());
		simpleBlock(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get());
		simpleBlock(TechnologicaBlocks.PATRONITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get());
		simpleBlock(TechnologicaBlocks.PENTLANDITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get());
		simpleBlock(TechnologicaBlocks.PHOSPHORITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get());
		simpleBlock(TechnologicaBlocks.PLATINUM_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get());
		simpleBlock(TechnologicaBlocks.NETHER_PLATINUM_ORE.get());
		simpleBlock(TechnologicaBlocks.PYROLUSITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get());
		simpleBlock(TechnologicaBlocks.RUBY_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get());
		simpleBlock(TechnologicaBlocks.SAPPHIRE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
		simpleBlock(TechnologicaBlocks.SPODUMENE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get());
		simpleBlock(TechnologicaBlocks.SYLVANITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get());
		simpleBlock(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get());
		simpleBlock(TechnologicaBlocks.TANTALITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get());
		simpleBlock(TechnologicaBlocks.THORIANITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get());
		simpleBlock(TechnologicaBlocks.TOPAZ_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get());
		simpleBlock(TechnologicaBlocks.URANINITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get());
		simpleBlock(TechnologicaBlocks.WOLFRAMITE_ORE.get());
		simpleBlock(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_RUBY.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TOPAZ.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_LITHIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_TITANIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_VANADIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_MANGANESE.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_COBALT.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_NICKEL.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_ZINC.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_GALLIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_RHODIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_SILVER.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_CADMIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_INDIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TIN.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TANTALUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_RHENIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_OSMIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_PLATINUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_THALLUIM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_LEAD.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_BISMUTH.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_POLONIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_THORIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_URANIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_CURIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_FERMIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_BRONZE.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_BRASS.get());

		simpleBlock(TechnologicaBlocks.BLOCK_OF_BORON.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_CARBON.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_SILICON.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_SULFUR.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_ARSENIC.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_SELENIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_IODINE.get());
		simpleBlock(TechnologicaBlocks.BLOCK_OF_ASTATINE.get());
	}

	private void crystalBlocks() {
		twentyFourDirectionBlockState(TechnologicaBlocks.AUTUNITE_CRYSTAL.get(), leafyCrystalModel(TechnologicaBlocks.AUTUNITE_CRYSTAL.get()), leafyCrystalModel(TechnologicaBlocks.AUTUNITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.BARYTE_CRYSTAL.get(), leafyCrystalModel(TechnologicaBlocks.BARYTE_CRYSTAL.get()), leafyCrystalModel(TechnologicaBlocks.BARYTE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.CELESTINE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.CELESTINE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.CELESTINE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.COLUMBITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.COLUMBITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.COLUMBITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MONAZITE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.MONAZITE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.MONAZITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.POLLUCITE_CRYSTAL.get(), leafyCrystalModel(TechnologicaBlocks.POLLUCITE_CRYSTAL.get()), leafyCrystalModel(TechnologicaBlocks.POLLUCITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.RUTILE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.RUTILE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.RUTILE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.SCHEELITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.SCHEELITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.SCHEELITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.SPHALERITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.SPHALERITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.SPHALERITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.STIBNITE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.STIBNITE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.STIBNITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get(), spikyCrystalModel(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get()), spikyCrystalModel(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.TELLURITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.TELLURITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.TELLURITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.VANADINITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.VANADINITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.VANADINITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.WULFENITE_CRYSTAL.get(), leafyCrystalModel(TechnologicaBlocks.WULFENITE_CRYSTAL.get()), leafyCrystalModel(TechnologicaBlocks.WULFENITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.XENOTIME_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.XENOTIME_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.XENOTIME_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.ZIRCON_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.ZIRCON_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.ZIRCON_CRYSTAL.get()));
	}

	private void fluidBlocks() {
		getVariantBuilder(TechnologicaBlocks.HYDROGEN.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.HYDROGEN.get())));
		getVariantBuilder(TechnologicaBlocks.HELIUM.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.HELIUM.get())));
		getVariantBuilder(TechnologicaBlocks.NITROGEN.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.NITROGEN.get())));
		getVariantBuilder(TechnologicaBlocks.OXYGEN.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.OXYGEN.get())));
		getVariantBuilder(TechnologicaBlocks.FLUORINE.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.FLUORINE.get())));
		getVariantBuilder(TechnologicaBlocks.NEON.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.NEON.get())));
		getVariantBuilder(TechnologicaBlocks.CHLORINE.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.CHLORINE.get())));
		getVariantBuilder(TechnologicaBlocks.ARGON.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.ARGON.get())));
		getVariantBuilder(TechnologicaBlocks.KRYPTON.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.KRYPTON.get())));
		getVariantBuilder(TechnologicaBlocks.XENON.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.XENON.get())));
		getVariantBuilder(TechnologicaBlocks.RADON.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.RADON.get())));
		getVariantBuilder(TechnologicaBlocks.BROMINE.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.BROMINE.get())));
		getVariantBuilder(TechnologicaBlocks.MERCURY.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.MERCURY.get())));
		getVariantBuilder(TechnologicaBlocks.BRINE.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.BRINE.get())));
		getVariantBuilder(TechnologicaBlocks.OIL.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.OIL.get())));
		getVariantBuilder(TechnologicaBlocks.NATURAL_GAS.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.NATURAL_GAS.get())));
		getVariantBuilder(TechnologicaBlocks.MAPLE_SYRUP.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.MAPLE_SYRUP.get())));
		getVariantBuilder(TechnologicaBlocks.RUBBER_RESIN.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.RUBBER_RESIN.get())));
		getVariantBuilder(TechnologicaBlocks.GASOLINE.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.GASOLINE.get())));
		getVariantBuilder(TechnologicaBlocks.MACHINE_OIL.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.MACHINE_OIL.get())));
		getVariantBuilder(TechnologicaBlocks.COOLANT.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.COOLANT.get())));
	}

	/*
	 * ModelFiles
	 */

	public ModelFile glueModel(String name, ResourceLocation particle, ResourceLocation face) {
		return models().withExistingParent(name, modLoc("block/glue_model")).texture("particle", particle).texture("face", face);
	}

	public ModelFile cubeEachFace(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation east, ResourceLocation south, ResourceLocation west) {
		return models().withExistingParent(name, modLoc("block/cube_each_face")).texture("particle", down).texture("down", down).texture("up", up).texture("north", north).texture("east", east).texture("south", south).texture("west", west);
	}

	public ModelFile stem(String name, ResourceLocation stem, int growth) {
		return models().withExistingParent(name, mcLoc("stem_growth" + growth)).renderType("cutout").texture("stem", stem);
	}

	public ModelFile attachedStem(String name, ResourceLocation stem, ResourceLocation upperStem) {
		return models().withExistingParent(name, modLoc("stem_gourd")).renderType("cutout").texture("stem", stem).texture("upperstem", upperStem);
	}

	public ModelFile gourdCropModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("gourd")).renderType("cutout_mipped").texture("gourd", blockTexture(block));
	}

	public ModelFile hopper(String name, String top, String side, String inside) {
		return models().withExistingParent(name, modLoc("technologica_hopper")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public ModelFile basin(String name, String top, String bottom, String side) {
		return models().withExistingParent(name, modLoc("basin_model")).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom);
	}

	public ModelFile basinFilled(String name, String level, String top, String bottom, String side, String content) {
		return models().withExistingParent(name + "_level" + level, modLoc("basin_filled_model_level" + level)).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom).texture("content", content);
	}

	public ModelFile panel(String name, String top, String side, String bottom) {
		return models().withExistingParent(name, modLoc("panel")).texture("particle", side).texture("top", top).texture("side", side).texture("bottom", bottom);
	}

	public ModelFile hopperSide(String name, String top, String side, String inside) {
		return models().withExistingParent(name, modLoc("technologica_hopper_side")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public ModelFile buttonInventoryModel(Block block, String renderType) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_inventory", "block/button_inventory").renderType(renderType).texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_button", "_planks"));
	}

	public ModelFile trellis(Block block, ResourceLocation texture) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("trellis_model"), texture).renderType("cutout");
	}

	public ModelFile chairModel(Block block, ResourceLocation texture, String renderType) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("chair"), "planks", texture).renderType(renderType);
	}

	public ModelFile tapeDriveLowerModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_lower", modLoc(ResourceLocationHelper.getPath(block) + "_lower_model"));
	}

	public ModelFile tapeDriveUpperModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_upper", modLoc(ResourceLocationHelper.getPath(block) + "_upper_model"));
	}

	public ModelFile tableModel(Block block, ResourceLocation texture, String renderType) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("table"), "planks", texture).renderType(renderType);
	}

	public ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile spikyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("spiky_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile leafyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("leafy_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile smallPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block))).texture("0", new TechnologicaLocation("block/" + ResourceLocationHelper.getPath(block)));
	}

	public ModelFile lineShaftNoPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_no_pulley", modLoc("line_shaft_no_pulley_model")).texture("0", new TechnologicaLocation("block/pulley"));
	}

	public ModelFile lineShaftSmallPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_small_pulley", modLoc("line_shaft_small_pulley_model")).texture("0", new TechnologicaLocation("block/pulley"));
	}

	public ModelFile lineShaftMediumPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_medium_pulley", modLoc("line_shaft_medium_pulley_model")).texture("0", new TechnologicaLocation("block/pulley"));
	}

	public ModelFile lineShaftLargePulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_large_pulley", modLoc("line_shaft_large_pulley_model")).texture("0", new TechnologicaLocation("block/pulley"));
	}

	public ModelFile lineShaftHangerModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("line_shaft_hanger_model")).texture("0", blockTexture(block));
	}

	public ModelFile lineShaftHangerModel2(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "2", modLoc("line_shaft_hanger2_model")).texture("0", blockTexture(block));
	}

	public ModelFile motorModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("motor")).texture("motor", blockTexture(block));
	}

	public ModelFile motor2Model(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "2", modLoc("motor2")).texture("motor", blockTexture(block));
	}

	public ModelFile treeTapModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("tap")).texture("tree_tap", blockTexture(block));
	}

	public ModelFile monitorModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public ModelFile keyboardModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public ModelFile displayModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool")).renderType("cutout_mipped");
	}

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return models().withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
	}

	public ModelFile fluid(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().getBuilder(location.getPath()).texture("particle", "minecraft:block/water_still");
	}

	public ModelFile hollowLogModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("hollow_log")).texture("side", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get())).texture("end", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()) + "_top").texture("inside", blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()) + "_solid").renderType("translucent");
	}

	/*
	 * Blockstate, block model, and item model providers
	 */

	private void simpleBlockWithRenderType(Block block, String renderType) {
		simpleBlock(block, models().cubeAll(name(block), blockTexture(block)).renderType(renderType));
	}

	private void slabBlockWithRenderType(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType) {
		slabBlock(block, models().slab(name(block), side, bottom, top).renderType(renderType), models().slabTop(name(block) + "_top", side, bottom, top).renderType(renderType), models().getExistingFile(doubleslab));
	}

	public void pressurePlateBlockWithRenderType(PressurePlateBlock block, ResourceLocation texture, String renderType) {
		ModelFile pressurePlate = models().pressurePlate(name(block), texture).renderType(renderType);
		ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", texture).renderType(renderType);
		pressurePlateBlock(block, pressurePlate, pressurePlateDown);
		simpleBlockItem(block, pressurePlate);
	}

	public void buttonBlockWithRenderType(ButtonBlock block, ResourceLocation texture, String renderType) {
		ModelFile button = models().button(name(block), texture).renderType(renderType);
		ModelFile buttonPressed = models().buttonPressed(name(block) + "_pressed", texture).renderType(renderType);
		buttonBlock(block, button, buttonPressed);
		simpleBlockItem(block, buttonInventoryModel(block, renderType));
	}

	public void fourDirectionBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
		simpleBlockItem(block, blockModel);
	}

	public void fourDirectionTallBlockState(Block block, ModelFile blockModelBottom, ModelFile blockModelTop) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(270).addModel();
		simpleBlockItem(block, blockModelTop);
	}

	public void sleepingBag(Block block, ModelFile blockModel, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(270).addModel();
	}

	public void fourDirectionBlockState2(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
	}

	public void twelveDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
		simpleBlockItem(block, blockModel1);
	}

	public void lineShaftHangerBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
		simpleBlockItem(block, blockModel1);
	}

	public void twentyFourDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel();
		simpleBlockItem(block, blockModel1);
	}

	public void tallBlock(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(TrellisBlock.HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModel).addModel().partialState().with(TrellisBlock.HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModel).addModel();
		simpleBlockItem(block, blockModel);
	}

	public void lineShaftBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3, ModelFile blockModel4) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).addModel();
		simpleBlockItem(block, blockModel1);
	}

	public void signBlockWithRenderType(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ResourceLocation texture, String renderType) {
		ModelFile sign = models().sign(name(signBlock), texture).renderType(renderType);
		signBlock(signBlock, wallSignBlock, sign);
		signItem(signBlock, new ModelFile.UncheckedModelFile("item/generated"), renderType);
	}

	public void grainCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage4", ResourceLocationHelper.extend(blockTexture(block), "_stage4")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage5", ResourceLocationHelper.extend(blockTexture(block), "_stage5")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage6", ResourceLocationHelper.extend(blockTexture(block), "_stage6")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage7", ResourceLocationHelper.extend(blockTexture(block), "_stage7")).renderType("cutout")).addModel();
	}

	public void replantableCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(PotatoBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel();
	}

	public void seededCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(BeetrootBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel();
	}

	public void berryBushBlock(Block block) {
		getVariantBuilder(block).partialState().with(SweetBerryBushBlock.AGE, 0).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 1).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 2).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 3).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout_mipped")).addModel();
	}

	public void tallCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout")).addModel();
	}

	public void tallBushCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout_mipped")).addModel();
	}

	public void stemCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(StemBlock.AGE, 0).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage0", blockTexture(block), 0)).addModel().partialState().with(StemBlock.AGE, 1).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage1", blockTexture(block), 1)).addModel().partialState().with(StemBlock.AGE, 2).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage2", blockTexture(block), 2)).addModel().partialState().with(StemBlock.AGE, 3).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage3", blockTexture(block), 3)).addModel().partialState().with(StemBlock.AGE, 4).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage4", blockTexture(block), 4)).addModel().partialState().with(StemBlock.AGE, 5).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage5", blockTexture(block), 5)).addModel().partialState().with(StemBlock.AGE, 6).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage6", blockTexture(block), 6)).addModel().partialState().with(StemBlock.AGE, 7).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage7", blockTexture(block), 7)).addModel();
	}

	public void attachedStemCropBlock(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).addModel();
	}

	public void vineCropBlock(Block block) {
		getMultipartBuilder(block).part().modelFile(trellis(TechnologicaBlocks.TRELLIS.get(), blockTexture(TechnologicaBlocks.TRELLIS.get()))).addModel().condition(VineCropBlock.TRELLIS, true).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 0).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 1).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 2).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 3).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 4).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 5).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 6).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 7).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 0).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 1).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 2).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 3).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 4).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 5).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 6).end().part().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 7).end();
	}

	public void glueBlock(Block block) {
		ModelFile model = glueModel(ResourceLocationHelper.getPath(block), blockTexture(block), blockTexture(block));
		getMultipartBuilder(block).part().modelFile(model).rotationX(270).addModel().condition(GlueBlock.UP, true).end().part().modelFile(model).rotationX(90).addModel().condition(GlueBlock.DOWN, true).end().part().modelFile(model).addModel().condition(GlueBlock.NORTH, true).end().part().modelFile(model).rotationY(270).addModel().condition(GlueBlock.WEST, true).end().part().modelFile(model).rotationY(180).addModel().condition(GlueBlock.SOUTH, true).end().part().modelFile(model).rotationY(90).addModel().condition(GlueBlock.EAST, true).end();
	}

	public void basinBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().modelForState().modelFile(blockModel).addModel();
		simpleBlockItem(block, blockModel);
	}

	public void basinFilledBlockState(Block block) {
		getVariantBuilder(block).partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 1).modelForState().modelFile(basinFilled(name(block), "1", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 2).modelForState().modelFile(basinFilled(name(block), "2", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 3).modelForState().modelFile(basinFilled(name(block), "3", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 4).modelForState().modelFile(basinFilled(name(block), "4", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 5).modelForState().modelFile(basinFilled(name(block), "5", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 6).modelForState().modelFile(basinFilled(name(block), "6", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 7).modelForState().modelFile(basinFilled(name(block), "7", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 8).modelForState().modelFile(basinFilled(name(block), "8", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 9).modelForState().modelFile(basinFilled(name(block), "9", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 10).modelForState().modelFile(basinFilled(name(block), "10", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 11).modelForState().modelFile(basinFilled(name(block), "11", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 12).modelForState().modelFile(basinFilled(name(block), "12", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 13).modelForState().modelFile(basinFilled(name(block), "13", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 14).modelForState().modelFile(basinFilled(name(block), "14", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 15).modelForState().modelFile(basinFilled(name(block), "15", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel().partialState().with(TechnologicaBlockStateProperties.LEVEL_BASIN, 16).modelForState().modelFile(basinFilled(name(block), "16", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side", "block/opaque_fluid_still")).addModel();
	}

	public void sawmillBlockState(Block block) {
		ResourceLocation lower_side_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lower_side_left");
		ResourceLocation lower_side_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lower_side_middle");
		ResourceLocation lower_side_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lower_side_right");
		ResourceLocation lower_side_end = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lower_side_end");
		ResourceLocation upper_side_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_upper_side_left");
		ResourceLocation upper_side_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_upper_side_middle");
		ResourceLocation upper_side_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_upper_side_right");
		ResourceLocation upper_side_end = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_upper_side_end");
		ResourceLocation top_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_top_left");
		ResourceLocation top_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_top_middle");
		ResourceLocation top_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_top_right");

		getVariantBuilder(block).partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_north", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_north", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_north", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_east", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_east", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_east", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_south", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_south", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_south", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_west", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_west", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_west", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_north", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_north", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_north", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_east", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_east", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_east", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_south", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_south", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_south", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_west", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_west", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_west", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(180).addModel();

		simpleBlockItem(block, models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath(), upper_side_end, upper_side_end, top_middle));
	}

	public void sawmillBlockState2(Block block) {
		ResourceLocation lower_side_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_lower_side_left");
		ResourceLocation lower_side_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_lower_side_middle");
		ResourceLocation lower_side_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_lower_side_right");
		ResourceLocation lower_side_end = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_lower_side_end");
		ResourceLocation upper_side_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_upper_side_left");
		ResourceLocation upper_side_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_upper_side_middle");
		ResourceLocation upper_side_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_upper_side_right");
		ResourceLocation upper_side_end = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_upper_side_end");
		ResourceLocation top_left = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_top_left");
		ResourceLocation top_middle = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_top_middle");
		ResourceLocation top_right = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath().replace("_core", "") + "_top_right");

		getVariantBuilder(block).partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_north", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_north", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_north", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_east", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_east", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_east", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_south", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_south", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_south", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_left_west", lower_side_left, lower_side_left, lower_side_right, lower_side_end, lower_side_left, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_middle_west", lower_side_middle, lower_side_middle, lower_side_middle, lower_side_end, lower_side_middle, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, true).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "lower_right_west", lower_side_right, lower_side_right, lower_side_left, lower_side_end, lower_side_right, lower_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_north", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_north", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_north", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(270).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_east", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_east", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_east", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_south", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_south", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_south", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(90).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.LEFT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_left_west", lower_side_left, top_left, upper_side_right, upper_side_end, upper_side_left, upper_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.MIDDLE).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_middle_west", lower_side_middle, top_middle, upper_side_middle, upper_side_end, upper_side_middle, upper_side_end)).rotationY(180).addModel().partialState().with(BlockStateProperties.BOTTOM, false).with(TechnologicaBlockStateProperties.MIDDLE_END, MiddleEnd.RIGHT).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(cubeEachFace(name(block) + "upper_right_west", lower_side_right, top_right, upper_side_left, upper_side_end, upper_side_right, upper_side_end)).rotationY(180).addModel();

		simpleBlockItem(block, models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath(), upper_side_end, upper_side_end, top_middle));
	}

	public void annunciatorBlockState(Block block) {
		ResourceLocation sides = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side");
		getVariantBuilder(block)
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(270)
				.addModel();
		simpleBlockItem(block, models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath(), sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides));
	}

	private void createHopper(Block block) {
		getVariantBuilder(TechnologicaBlocks.FAST_HOPPER.get()).partialState().with(BlockStateProperties.FACING_HOPPER, Direction.DOWN).modelForState().modelFile(hopper(ForgeRegistries.BLOCKS.getKey(block).getPath(), "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.EAST).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.NORTH).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.SOUTH).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.WEST).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(270).addModel();
		simpleFlatItem(TechnologicaBlocks.FAST_HOPPER.get(), new ModelFile.UncheckedModelFile("item/generated"), "cutout");
	}

	/*
	 * Item model providers
	 */

	private void simpleFlatItem(Block block, ModelFile model, String renderType) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath())).renderType(renderType);
	}

	public void doorBlockItem(Block block, ModelFile model, String renderType) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath())).renderType(renderType);
	}

	public void signItem(Block block, ModelFile model, String renderType) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(block), "_wall", ""), "block", "item")).renderType(renderType);
	}

	private ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}
}
