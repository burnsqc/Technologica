package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenBlockstates;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenModelsBlock;
import com.technologica.api.tlregen.resourcegen.util.TLReGenConfiguredModel;
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
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;

public class TLBlockstates extends TLReGenBlockstates {
	@Override
	protected void populate() {
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
		simpleBlock(TechnologicaBlocks.MULCH.get(), TLReGenModelsBlock.cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_side"), mcLoc("block/dirt"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_top")));
		tallBlock(TechnologicaBlocks.TRELLIS.get(), trellis(TechnologicaBlocks.TRELLIS.get(), blockTexture(TechnologicaBlocks.TRELLIS.get())));
		simpleBlock(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
		twelveDirectionBlockState(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), lineShaftHangerModel(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel2(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel3(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel4(TechnologicaBlocks.LINE_SHAFT_HANGER.get()));
		lineShaftBlockState(TechnologicaBlocks.LINE_SHAFT.get(), lineShaftNoPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftSmallPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftMediumPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftLargePulleyModel(TechnologicaBlocks.LINE_SHAFT.get()));
		getVariantBuilder(TechnologicaBlocks.SMALL_PULLEY.get()).partialState().setModels(new TLReGenConfiguredModel(TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.MEDIUM_PULLEY.get()).partialState().setModels(new TLReGenConfiguredModel(TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.LARGE_PULLEY.get()).partialState().setModels(new TLReGenConfiguredModel(TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()), new TechnologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()) + "_model")).texture("pulley", new TechnologicaLocation("block/pulley"))));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_1HP.get(), motorModel(TechnologicaBlocks.MOTOR_1HP.get()), motor2Model(TechnologicaBlocks.MOTOR_1HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_5HP.get(), motorModel(TechnologicaBlocks.MOTOR_5HP.get()), motor2Model(TechnologicaBlocks.MOTOR_5HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_20HP.get(), motorModel(TechnologicaBlocks.MOTOR_20HP.get()), motor2Model(TechnologicaBlocks.MOTOR_20HP.get()));
		fourDirectionBlockState(TechnologicaBlocks.TREE_TAP.get(), treeTapModel(TechnologicaBlocks.TREE_TAP.get()));
		sawmillBlockState2(TechnologicaBlocks.SAWMILL_CORE.get());
		sawmillBlockState(TechnologicaBlocks.SAWMILL.get());
		annunciatorBlockState(TechnologicaBlocks.ANNUNCIATOR.get());
		createHopper(TechnologicaBlocks.FAST_HOPPER.get());
		simpleBlock(TechnologicaBlocks.NITROGLYCERIN.get(), TLReGenModelsBlock.cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_side"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_bottom"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_top")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain").renderType("cutout_mipped"), TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain").renderType("cutout_mipped"));
		sleepingBag(TechnologicaBlocks.SLEEPING_BAG.get(), panel("block/sleeping_bag_top_head", "block/sleeping_bag_top_head", "block/sleeping_bag_side", "block/sleeping_bag_bottom"), panel("block/sleeping_bag_top", "block/sleeping_bag_top", "block/sleeping_bag_side", "block/sleeping_bag_bottom"));
		fourDirectionTallBlockState(TechnologicaBlocks.TAPE_DRIVE.get(), tapeDriveLowerModel(TechnologicaBlocks.TAPE_DRIVE.get()), tapeDriveUpperModel(TechnologicaBlocks.TAPE_DRIVE.get()));
		fourDirectionBlockState(TechnologicaBlocks.MONITOR.get(), monitorModel(TechnologicaBlocks.MONITOR.get()));
		fourDirectionBlockState(TechnologicaBlocks.KEYBOARD.get(), keyboardModel(TechnologicaBlocks.KEYBOARD.get()));
		basinBlockState(TechnologicaBlocks.BASIN.get(), basin(name(TechnologicaBlocks.BASIN.get()), "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_top", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_bottom", "block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.BASIN.get()) + "_side"));
		basinFilledBlockState(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		basinFilledBlockState(TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
		glueBlock(TechnologicaBlocks.GLUE.get());
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
		tallCropBlock(TechnologicaBlocks.CRANBERRIES.get());
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
		simpleBlock(TechnologicaBlocks.APRICOT_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_SAPLING.get()), blockTexture(TechnologicaBlocks.APRICOT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ASPEN_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_SAPLING.get()), blockTexture(TechnologicaBlocks.ASPEN_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.AVOCADO_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_SAPLING.get()), blockTexture(TechnologicaBlocks.AVOCADO_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.BANANA_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_SAPLING.get()), blockTexture(TechnologicaBlocks.BANANA_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CHERRY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_SAPLING.get()), blockTexture(TechnologicaBlocks.CHERRY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CHESTNUT_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.CHESTNUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CINNAMON_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_SAPLING.get()), blockTexture(TechnologicaBlocks.CINNAMON_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.COCONUT_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_SAPLING.get()), blockTexture(TechnologicaBlocks.COCONUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.EBONY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_SAPLING.get()), blockTexture(TechnologicaBlocks.EBONY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.KIWI_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_SAPLING.get()), blockTexture(TechnologicaBlocks.KIWI_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.LEMON_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_SAPLING.get()), blockTexture(TechnologicaBlocks.LEMON_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.LIME_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_SAPLING.get()), blockTexture(TechnologicaBlocks.LIME_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MAHOGANY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_SAPLING.get()), blockTexture(TechnologicaBlocks.MAHOGANY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MAPLE_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_SAPLING.get()), blockTexture(TechnologicaBlocks.MAPLE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.OLIVE_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_SAPLING.get()), blockTexture(TechnologicaBlocks.OLIVE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ORANGE_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_SAPLING.get()), blockTexture(TechnologicaBlocks.ORANGE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PEACH_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_SAPLING.get()), blockTexture(TechnologicaBlocks.PEACH_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PEAR_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_SAPLING.get()), blockTexture(TechnologicaBlocks.PEAR_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.PLUM_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_SAPLING.get()), blockTexture(TechnologicaBlocks.PLUM_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.REDWOOD_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.REDWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.RUBBER_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_SAPLING.get()), blockTexture(TechnologicaBlocks.RUBBER_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.TEAK_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_SAPLING.get()), blockTexture(TechnologicaBlocks.TEAK_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.WALNUT_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.WALNUT_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()), blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()), blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()), blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()), blockTexture(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get())).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.NECROTIC_SAPLING.get(), TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_SAPLING.get()), blockTexture(TechnologicaBlocks.NECROTIC_SAPLING.get())).renderType("cutout_mipped"));
	}

	private void pottedSaplingBlocks() {
		simpleBlock(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
		simpleBlock(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()).replaceAll("potted_", ""))).renderType("cutout_mipped"));
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
		simpleBlock(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(Blocks.ACACIA_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BANANA_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(Blocks.BIRCH_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(Blocks.CRIMSON_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(Blocks.DARK_OAK_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.EBONY_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(Blocks.JUNGLE_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.KIWI_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.LEMON_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.LIME_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PEACH_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PEAR_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.PLUM_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(Blocks.SPRUCE_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.TEAK_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.WARPED_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(Blocks.WARPED_PLANKS)).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_PLANKS.get())).renderType("translucent"));
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_PLANKS.get())).renderType("solid"));
		simpleBlock(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), TLReGenModelsBlock.cubeColumn(name(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_PLANKS.get())).renderType("solid"));
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
		simpleBlock(TechnologicaBlocks.BLOCK_OF_THALLIUM.get());
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
		simpleBlock(TechnologicaBlocks.BLOCK_OF_STEEL.get());
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
		getVariantBuilder(TechnologicaBlocks.HYDROGEN.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.HYDROGEN.get())));
		getVariantBuilder(TechnologicaBlocks.HELIUM.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.HELIUM.get())));
		getVariantBuilder(TechnologicaBlocks.NITROGEN.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.NITROGEN.get())));
		getVariantBuilder(TechnologicaBlocks.OXYGEN.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.OXYGEN.get())));
		getVariantBuilder(TechnologicaBlocks.FLUORINE.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.FLUORINE.get())));
		getVariantBuilder(TechnologicaBlocks.NEON.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.NEON.get())));
		getVariantBuilder(TechnologicaBlocks.CHLORINE.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.CHLORINE.get())));
		getVariantBuilder(TechnologicaBlocks.ARGON.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.ARGON.get())));
		getVariantBuilder(TechnologicaBlocks.KRYPTON.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.KRYPTON.get())));
		getVariantBuilder(TechnologicaBlocks.XENON.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.XENON.get())));
		getVariantBuilder(TechnologicaBlocks.RADON.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.RADON.get())));
		getVariantBuilder(TechnologicaBlocks.BROMINE.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.BROMINE.get())));
		getVariantBuilder(TechnologicaBlocks.MERCURY.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.MERCURY.get())));
		getVariantBuilder(TechnologicaBlocks.BRINE.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.BRINE.get())));
		getVariantBuilder(TechnologicaBlocks.OIL.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.OIL.get())));
		getVariantBuilder(TechnologicaBlocks.NATURAL_GAS.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.NATURAL_GAS.get())));
		getVariantBuilder(TechnologicaBlocks.MAPLE_SYRUP.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.MAPLE_SYRUP.get())));
		getVariantBuilder(TechnologicaBlocks.RUBBER_RESIN.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.RUBBER_RESIN.get())));
		getVariantBuilder(TechnologicaBlocks.GASOLINE.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.GASOLINE.get())));
		getVariantBuilder(TechnologicaBlocks.MACHINE_OIL.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.MACHINE_OIL.get())));
		getVariantBuilder(TechnologicaBlocks.COOLANT.get()).partialState().setModels(new TLReGenConfiguredModel(fluid(TechnologicaBlocks.COOLANT.get())));
	}

	public ModelFile glueModel(String name, ResourceLocation particle, ResourceLocation face) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("block/glue_model")).texture("particle", particle).texture("face", face);
	}

	public ModelFile cubeEachFace(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation east, ResourceLocation south, ResourceLocation west) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("block/cube_each_face")).texture("particle", down).texture("down", down).texture("up", up).texture("north", north).texture("east", east).texture("south", south).texture("west", west);
	}

	public ModelFile stem(String name, ResourceLocation stem, int growth) {
		return TLReGenModelsBlock.withExistingParent(name, mcLoc("stem_growth" + growth)).renderType("cutout").texture("stem", stem);
	}

	public ModelFile attachedStem(String name, ResourceLocation stem, ResourceLocation upperStem) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("stem_gourd")).renderType("cutout").texture("stem", stem).texture("upperstem", upperStem);
	}

	public ModelFile gourdCropModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("gourd")).renderType("cutout_mipped").texture("gourd", blockTexture(block));
	}

	public ModelFile hopper(String name, String top, String side, String inside) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("technologica_hopper")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public ModelFile basin(String name, String top, String bottom, String side) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("basin_model")).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom);
	}

	public ModelFile basinFilled(String name, String level, String top, String bottom, String side, String content) {
		return TLReGenModelsBlock.withExistingParent(name + "_level" + level, modLoc("basin_filled_model_level" + level)).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom).texture("content", content);
	}

	public ModelFile panel(String name, String top, String side, String bottom) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("panel")).texture("particle", side).texture("top", top).texture("side", side).texture("bottom", bottom);
	}

	public ModelFile hopperSide(String name, String top, String side, String inside) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("technologica_hopper_side")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public ModelFile buttonInventoryModel(Block block, String renderType) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_inventory", "block/button_inventory").renderType(renderType).texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_button", "_planks"));
	}

	public ModelFile trellis(Block block, ResourceLocation texture) {
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("trellis_model"), texture).renderType("cutout");
	}

	public static ModelFile chairModel(Block block, ResourceLocation texture, String renderType) {
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("chair"), "planks", texture).renderType(renderType);
	}

	public ModelFile tapeDriveLowerModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_lower", modLoc(ResourceLocationHelper.getPath(block) + "_lower_model"));
	}

	public ModelFile tapeDriveUpperModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_upper", modLoc(ResourceLocationHelper.getPath(block) + "_upper_model"));
	}

	public ModelFile tableModel(Block block, ResourceLocation texture, String renderType) {
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("table"), "planks", texture).renderType(renderType);
	}

	public ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile spikyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("spiky_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile leafyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return TLReGenModelsBlock.singleTexture(ResourceLocationHelper.getPath(block), modLoc("leafy_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public ModelFile smallPulleyModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block))).texture("0", new TechnologicaLocation("block/" + ResourceLocationHelper.getPath(block)));
	}

	public ModelFile lineShaftNoPulleyModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_no_pulley", modLoc("line_shaft_no_pulley_model"));
	}

	public ModelFile lineShaftSmallPulleyModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_small_pulley", modLoc("line_shaft_small_pulley_model"));
	}

	public ModelFile lineShaftMediumPulleyModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_medium_pulley", modLoc("line_shaft_medium_pulley_model"));
	}

	public ModelFile lineShaftLargePulleyModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_large_pulley", modLoc("line_shaft_large_pulley_model"));
	}

	public ModelFile lineShaftHangerModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("line_shaft_hanger_model"));
	}

	public ModelFile lineShaftHangerModel2(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "2", modLoc("line_shaft_hanger2_model"));
	}

	public ModelFile lineShaftHangerModel3(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "_shaft", modLoc("line_shaft_hanger_shaft_model"));
	}

	public ModelFile lineShaftHangerModel4(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "2_shaft", modLoc("line_shaft_hanger2_shaft_model"));
	}

	public ModelFile motorModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("motor")).texture("motor", blockTexture(block));
	}

	public ModelFile motor2Model(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block) + "2", modLoc("motor2")).texture("motor", blockTexture(block));
	}

	public ModelFile treeTapModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("tap")).texture("tree_tap", blockTexture(block));
	}

	public ModelFile monitorModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public ModelFile keyboardModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public ModelFile displayModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool")).renderType("cutout_mipped");
	}

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return TLReGenModelsBlock.withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
	}

	public ModelFile fluid(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return TLReGenModelsBlock.getBuilder(location.getPath()).texture("particle", "minecraft:block/water_still");
	}

	public ModelFile hollowLogModel(Block block) {
		return TLReGenModelsBlock.withExistingParent(ResourceLocationHelper.getPath(block), modLoc("hollow_log")).texture("side", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get())).texture("end", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()) + "_top").texture("inside", blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()) + "_solid").renderType("translucent");
	}

	private void simpleBlockWithRenderType(Block block, String renderType) {
		simpleBlock(block, TLReGenModelsBlock.cubeAll(name(block), blockTexture(block)).renderType(renderType));
	}

	private void slabBlockWithRenderType(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType) {
		slabBlock(block, TLReGenModelsBlock.slab(name(block), side, bottom, top).renderType(renderType), TLReGenModelsBlock.slabTop(name(block) + "_top", side, bottom, top).renderType(renderType), TLReGenModelsBlock.getExistingFile(doubleslab));
	}

	public void pressurePlateBlockWithRenderType(PressurePlateBlock block, ResourceLocation texture, String renderType) {
		ModelFile pressurePlate = TLReGenModelsBlock.pressurePlate(name(block), texture).renderType(renderType);
		ModelFile pressurePlateDown = TLReGenModelsBlock.pressurePlateDown(name(block) + "_down", texture).renderType(renderType);
		pressurePlateBlock(block, pressurePlate, pressurePlateDown);
	}

	public void buttonBlockWithRenderType(ButtonBlock block, ResourceLocation texture, String renderType) {
		ModelFile button = TLReGenModelsBlock.button(name(block), texture).renderType(renderType);
		ModelFile buttonPressed = TLReGenModelsBlock.buttonPressed(name(block) + "_pressed", texture).renderType(renderType);
		buttonBlock(block, button, buttonPressed);
	}

	public void fourDirectionBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
	}

	public void fourDirectionTallBlockState(Block block, ModelFile blockModelBottom, ModelFile blockModelTop) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModelBottom).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModelTop).rotationY(270).addModel();
	}

	public void sleepingBag(Block block, ModelFile blockModel, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.BED_PART, BedPart.HEAD).modelForState().modelFile(blockModel).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.BED_PART, BedPart.FOOT).modelForState().modelFile(blockModel2).rotationY(270).addModel();
	}

	public void fourDirectionBlockState2(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
	}

	public void twelveDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3, ModelFile blockModel4) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, false).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel3).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).with(BlockStateProperties.ATTACHED, true).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel();
	}

	public void lineShaftHangerBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
	}

	public void twentyFourDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel();
	}

	public void tallBlock(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(TrellisBlock.HALF, DoubleBlockHalf.LOWER).modelForState().modelFile(blockModel).addModel().partialState().with(TrellisBlock.HALF, DoubleBlockHalf.UPPER).modelForState().modelFile(blockModel).addModel();
	}

	public void lineShaftBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3, ModelFile blockModel4) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).addModel();
	}

	public void signBlockWithRenderType(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ResourceLocation texture, String renderType) {
		ModelFile sign = TLReGenModelsBlock.sign(name(signBlock), texture).renderType(renderType);
		signBlock(signBlock, wallSignBlock, sign);
	}

	public void grainCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(CropBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage4", ResourceLocationHelper.extend(blockTexture(block), "_stage4")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage5", ResourceLocationHelper.extend(blockTexture(block), "_stage5")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage6", ResourceLocationHelper.extend(blockTexture(block), "_stage6")).renderType("cutout")).addModel().partialState().with(CropBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage7", ResourceLocationHelper.extend(blockTexture(block), "_stage7")).renderType("cutout")).addModel();
	}

	public void replantableCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(PotatoBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(PotatoBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel();
	}

	public void seededCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(BeetrootBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout")).addModel().partialState().with(BeetrootBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout")).addModel();
	}

	public void berryBushBlock(Block block) {
		getVariantBuilder(block).partialState().with(SweetBerryBushBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2")).renderType("cutout_mipped")).addModel().partialState().with(SweetBerryBushBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3")).renderType("cutout_mipped")).addModel();
	}

	public void tallCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout")).addModel();
	}

	public void tallBushCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout_mipped")).addModel().partialState().with(TallCropBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(TLReGenModelsBlock.cross(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout_mipped")).addModel();
	}

	public void stemCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(StemBlock.AGE, 0).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage0", blockTexture(block), 0)).addModel().partialState().with(StemBlock.AGE, 1).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage1", blockTexture(block), 1)).addModel().partialState().with(StemBlock.AGE, 2).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage2", blockTexture(block), 2)).addModel().partialState().with(StemBlock.AGE, 3).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage3", blockTexture(block), 3)).addModel().partialState().with(StemBlock.AGE, 4).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage4", blockTexture(block), 4)).addModel().partialState().with(StemBlock.AGE, 5).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage5", blockTexture(block), 5)).addModel().partialState().with(StemBlock.AGE, 6).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage6", blockTexture(block), 6)).addModel().partialState().with(StemBlock.AGE, 7).modelForState().modelFile(stem(ResourceLocationHelper.getPath(block) + "_stage7", blockTexture(block), 7)).addModel();
	}

	public void attachedStemCropBlock(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).addModel();
	}

	public void vineCropBlock(Block block) {
		getMultipartBuilder(block).part().modelFile(trellis(TechnologicaBlocks.TRELLIS.get(), blockTexture(TechnologicaBlocks.TRELLIS.get()))).addModel().condition(VineCropBlock.TRELLIS, true).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 0).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 1).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 2).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 3).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 4).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 5).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 6).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.LOWER).condition(VineCropBlock.AGE, 7).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 0).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 1).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 2).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 3).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 4).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 5).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 6).end().part().modelFile(TLReGenModelsBlock.crop(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7")).renderType("cutout")).addModel().condition(VineCropBlock.HALF, DoubleBlockHalf.UPPER).condition(VineCropBlock.AGE, 7).end();
	}

	public void glueBlock(Block block) {
		ModelFile model = glueModel(ResourceLocationHelper.getPath(block), blockTexture(block), blockTexture(block));
		getMultipartBuilder(block).part().modelFile(model).rotationX(270).addModel().condition(GlueBlock.UP, true).end().part().modelFile(model).rotationX(90).addModel().condition(GlueBlock.DOWN, true).end().part().modelFile(model).addModel().condition(GlueBlock.NORTH, true).end().part().modelFile(model).rotationY(270).addModel().condition(GlueBlock.WEST, true).end().part().modelFile(model).rotationY(180).addModel().condition(GlueBlock.SOUTH, true).end().part().modelFile(model).rotationY(90).addModel().condition(GlueBlock.EAST, true).end();
	}

	public void basinBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().modelForState().modelFile(blockModel).addModel();
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
	}

	public void annunciatorBlockState(Block block) {
		ResourceLocation sides = new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side");
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides)).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides)).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath()
			+ "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath()
				+ "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides)).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides)).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(TLReGenModelsBlock.orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new TechnologicaLocation("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides)).rotationY(270).addModel();
	}

	private void createHopper(Block block) {
		getVariantBuilder(TechnologicaBlocks.FAST_HOPPER.get()).partialState().with(BlockStateProperties.FACING_HOPPER, Direction.DOWN).modelForState().modelFile(hopper(ForgeRegistries.BLOCKS.getKey(block).getPath(), "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.EAST).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.NORTH).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.SOUTH).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING_HOPPER, Direction.WEST).modelForState().modelFile(hopperSide(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side", "block/fast_hopper_top", "block/fast_hopper_outside", "block/fast_hopper_inside")).rotationY(270).addModel();
	}

	private ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}
}
