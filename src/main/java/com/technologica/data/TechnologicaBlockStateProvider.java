package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.util.AnnunciatorOverlay;
import com.technologica.util.Radius;
import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.world.level.block.TallCropsBlock;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaBlockStateProvider extends BlockStateProvider {

	public TechnologicaBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		cropBlock(TechnologicaBlocks.ASPARAGUS_CROP.get());
		cropBlock(TechnologicaBlocks.BARLEY_CROP.get());
		cropBlock(TechnologicaBlocks.BLACKBERRY_CROP.get());
		cropBlock(TechnologicaBlocks.BLUEBERRY_CROP.get());
		cropBlock(TechnologicaBlocks.BROCCOLI_CROP.get());
		cropBlock(TechnologicaBlocks.CELERY_CROP.get());
		cropBlock(TechnologicaBlocks.CHILI_PEPPER_CROP.get());
		cropBlock(TechnologicaBlocks.CUCUMBER_CROP.get());
		cropBlock(TechnologicaBlocks.GARLIC_CROP.get());
		cropBlock(TechnologicaBlocks.GINGER_CROP.get());
		cropBlock(TechnologicaBlocks.LETTUCE_CROP.get());
		cropBlock(TechnologicaBlocks.MUSTARD_GREENS_CROP.get());
		cropBlock(TechnologicaBlocks.OATS_CROP.get());
		cropBlock(TechnologicaBlocks.ONION_CROP.get());
		cropBlock(TechnologicaBlocks.PEA_CROP.get());
		cropBlock(TechnologicaBlocks.PEANUT_CROP.get());
		cropBlock(TechnologicaBlocks.PINEAPPLE_CROP.get());
		cropBlock(TechnologicaBlocks.PURPLE_CABBAGE_CROP.get());
		cropBlock(TechnologicaBlocks.RADISH_CROP.get());
		cropBlock(TechnologicaBlocks.RASPBERRY_CROP.get());
		cropBlock(TechnologicaBlocks.RYE_CROP.get());
		cropBlock(TechnologicaBlocks.SQUASH_CROP.get());
		cropBlock(TechnologicaBlocks.SWEET_POTATO_CROP.get());
		cropBlock(TechnologicaBlocks.STRAWBERRY_CROP.get());
		cropBlock(TechnologicaBlocks.TEA_CROP.get());
		cropBlock(TechnologicaBlocks.TOMATO_CROP.get());
		cropBlock(TechnologicaBlocks.TURNIP_CROP.get());
		cropBlock(TechnologicaBlocks.ZUCCHINI_CROP.get());
		
		tallCropBlock(TechnologicaBlocks.CORN_CROP.get());
		tallCropBlock(TechnologicaBlocks.PEPPERCORN_CROP.get());
		tallCropBlock(TechnologicaBlocks.CRANBERRY_CROP.get());
		tallCropBlock(TechnologicaBlocks.RICE_CROP.get());
		
		simpleBlock(TechnologicaBlocks.APRICOT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_SAPLING.get()), blockTexture(TechnologicaBlocks.APRICOT_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ASPEN_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_SAPLING.get()), blockTexture(TechnologicaBlocks.ASPEN_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.AVOCADO_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_SAPLING.get()), blockTexture(TechnologicaBlocks.AVOCADO_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.BANANA_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_SAPLING.get()), blockTexture(TechnologicaBlocks.BANANA_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.CHERRY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_SAPLING.get()), blockTexture(TechnologicaBlocks.CHERRY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.CHESTNUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.CHESTNUT_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.CINNAMON_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_SAPLING.get()), blockTexture(TechnologicaBlocks.CINNAMON_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.COCONUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_SAPLING.get()), blockTexture(TechnologicaBlocks.COCONUT_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.EBONY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_SAPLING.get()), blockTexture(TechnologicaBlocks.EBONY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.KIWI_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_SAPLING.get()), blockTexture(TechnologicaBlocks.KIWI_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.LEMON_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_SAPLING.get()), blockTexture(TechnologicaBlocks.LEMON_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.LIME_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_SAPLING.get()), blockTexture(TechnologicaBlocks.LIME_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.MAHOGANY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_SAPLING.get()), blockTexture(TechnologicaBlocks.MAHOGANY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.MAPLE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_SAPLING.get()), blockTexture(TechnologicaBlocks.MAPLE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.OLIVE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_SAPLING.get()), blockTexture(TechnologicaBlocks.OLIVE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ORANGE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_SAPLING.get()), blockTexture(TechnologicaBlocks.ORANGE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.PEACH_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_SAPLING.get()), blockTexture(TechnologicaBlocks.PEACH_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.PEAR_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_SAPLING.get()), blockTexture(TechnologicaBlocks.PEAR_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.PLUM_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_SAPLING.get()), blockTexture(TechnologicaBlocks.PLUM_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.REDWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.REDWOOD_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.RUBBER_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_SAPLING.get()), blockTexture(TechnologicaBlocks.RUBBER_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.TEAK_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_SAPLING.get()), blockTexture(TechnologicaBlocks.TEAK_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.WALNUT_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_SAPLING.get()), blockTexture(TechnologicaBlocks.WALNUT_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()), blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()), blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()), blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()), blockTexture(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get())));
		simpleBlock(TechnologicaBlocks.NECROTIC_SAPLING.get(), models().cross(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_SAPLING.get()), blockTexture(TechnologicaBlocks.NECROTIC_SAPLING.get())));
		
		simpleBlock(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BANANA_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_EBONY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_KIWI_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LEMON_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_LIME_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEACH_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PEAR_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_PLUM_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TEAK_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get()).replaceAll("potted_", ""))));
		simpleBlock(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), models().singleTexture(ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get()).replaceAll("potted_", ""))));
		
		simpleBlock(TechnologicaBlocks.APRICOT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.ASPEN_LEAVES.get());
		simpleBlock(TechnologicaBlocks.AVOCADO_LEAVES.get());
		simpleBlock(TechnologicaBlocks.BANANA_LEAVES.get());
		simpleBlock(TechnologicaBlocks.CHERRY_LEAVES.get());
		simpleBlock(TechnologicaBlocks.CHESTNUT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.CINNAMON_LEAVES.get());
		simpleBlock(TechnologicaBlocks.COCONUT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.EBONY_LEAVES.get());
		simpleBlock(TechnologicaBlocks.KIWI_LEAVES.get());
		simpleBlock(TechnologicaBlocks.LEMON_LEAVES.get());
		simpleBlock(TechnologicaBlocks.LIME_LEAVES.get());
		simpleBlock(TechnologicaBlocks.MAHOGANY_LEAVES.get());
		simpleBlock(TechnologicaBlocks.MAPLE_LEAVES.get());
		simpleBlock(TechnologicaBlocks.OLIVE_LEAVES.get());
		simpleBlock(TechnologicaBlocks.ORANGE_LEAVES.get());
		simpleBlock(TechnologicaBlocks.PEACH_LEAVES.get());
		simpleBlock(TechnologicaBlocks.PEAR_LEAVES.get());
		simpleBlock(TechnologicaBlocks.PLUM_LEAVES.get());
		simpleBlock(TechnologicaBlocks.REDWOOD_LEAVES.get());
		simpleBlock(TechnologicaBlocks.ROSEWOOD_LEAVES.get());
		simpleBlock(TechnologicaBlocks.RUBBER_LEAVES.get());
		simpleBlock(TechnologicaBlocks.TEAK_LEAVES.get());
		simpleBlock(TechnologicaBlocks.WALNUT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_LEAVES.get());
//		simpleBlock(TechnologicaBlocks.NECROTIC_LEAVES.get());
		
		simpleBlock(TechnologicaBlocks.MULCH.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_side"), mcLoc("block/dirt"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_top")));
//		simpleBlock(TechnologicaBlocks.FERTILIZER.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.FERTILIZER.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.FERTILIZER.get()) + "_side"), mcLoc("block/dirt"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.FERTILIZER.get()) + "_top")));
		
		simpleBlock(TechnologicaBlocks.SALT.get());
		simpleBlock(TechnologicaBlocks.LITHIUM_CLAY.get());
		simpleBlock(TechnologicaBlocks.MOON_ROCK.get());
		simpleBlock(TechnologicaBlocks.MOON_DUST.get());
		
		simpleBlock(TechnologicaBlocks.BAUXITE_ORE.get());
		simpleBlock(TechnologicaBlocks.CHROMITE_ORE.get());
		simpleBlock(TechnologicaBlocks.ILMENITE_ORE.get());
		simpleBlock(TechnologicaBlocks.PYROLUSITE_ORE.get());
		simpleBlock(TechnologicaBlocks.COBALTITE_ORE.get());
		simpleBlock(TechnologicaBlocks.GARNIERITE_ORE.get());
		simpleBlock(TechnologicaBlocks.BORAX_ORE.get());
		simpleBlock(TechnologicaBlocks.MAGNESITE_ORE.get());
		simpleBlock(TechnologicaBlocks.SPODUMENE_ORE.get());
		
		twentyFourDirectionBlockState(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()));
		
		twentyFourDirectionBlockState(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()));
		
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
		
		logBlock((RotatedPillarBlock) TechnologicaBlocks.APRICOT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.ASPEN_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.AVOCADO_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.BANANA_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.CHERRY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.CHESTNUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.CINNAMON_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.COCONUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.EBONY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.KIWI_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.LEMON_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.LIME_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.MAHOGANY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.MAPLE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.OLIVE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.ORANGE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.PEACH_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.PEAR_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.PLUM_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.REDWOOD_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.ROSEWOOD_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.RUBBER_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.TEAK_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.WALNUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.ZEBRAWOOD_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.TOWERING_INFERNO_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.NECROTIC_LOG.get());
		
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ASPEN_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BANANA_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHERRY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_COCONUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_EBONY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_KIWI_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LEMON_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LIME_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAPLE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_OLIVE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ORANGE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEACH_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEAR_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PLUM_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_RUBBER_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TEAK_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_WALNUT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_LOG.get());
//		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get());
		
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ASPEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.AVOCADO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.BANANA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.CHERRY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.CHESTNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.CINNAMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.COCONUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.EBONY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.KIWI_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.LEMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.LIME_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.MAHOGANY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.MAPLE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.OLIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ORANGE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.PEACH_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.PEAR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.PLUM_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.REDWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ROSEWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.RUBBER_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.TEAK_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.WALNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.TOWERING_INFERNO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.NECROTIC_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_WOOD.get()), "_wood", "_log")));

		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_LIME_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ANCIENT_AMBROSIA_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CRYOGENIC_SPIRE_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_THUNDEROUS_CONDUCTOR_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_TOWERING_INFERNO_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_SERENDIPITOUS_APOTHECARY_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")));
//		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_APOTHECARY_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get()), "_wood", "_log")));

		simpleBlock(TechnologicaBlocks.APRICOT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.ASPEN_PLANKS.get());
		simpleBlock(TechnologicaBlocks.AVOCADO_PLANKS.get());
		simpleBlock(TechnologicaBlocks.BANANA_PLANKS.get());
		simpleBlock(TechnologicaBlocks.CHERRY_PLANKS.get());
		simpleBlock(TechnologicaBlocks.CHESTNUT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.CINNAMON_PLANKS.get());
		simpleBlock(TechnologicaBlocks.COCONUT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.EBONY_PLANKS.get());
		simpleBlock(TechnologicaBlocks.KIWI_PLANKS.get());
		simpleBlock(TechnologicaBlocks.LEMON_PLANKS.get());
		simpleBlock(TechnologicaBlocks.LIME_PLANKS.get());
		simpleBlock(TechnologicaBlocks.MAHOGANY_PLANKS.get());
		simpleBlock(TechnologicaBlocks.MAPLE_PLANKS.get());
		simpleBlock(TechnologicaBlocks.OLIVE_PLANKS.get());
		simpleBlock(TechnologicaBlocks.ORANGE_PLANKS.get());
		simpleBlock(TechnologicaBlocks.PEACH_PLANKS.get());
		simpleBlock(TechnologicaBlocks.PEAR_PLANKS.get());
		simpleBlock(TechnologicaBlocks.PLUM_PLANKS.get());
		simpleBlock(TechnologicaBlocks.REDWOOD_PLANKS.get());
		simpleBlock(TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		simpleBlock(TechnologicaBlocks.RUBBER_PLANKS.get());
		simpleBlock(TechnologicaBlocks.TEAK_PLANKS.get());
		simpleBlock(TechnologicaBlocks.WALNUT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_PLANKS.get());
//		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_PLANKS.get());
		simpleBlock(TechnologicaBlocks.NECROTIC_PLANKS.get());
		
		slabBlock((SlabBlock) TechnologicaBlocks.APRICOT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.ASPEN_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.AVOCADO_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.BANANA_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.CHERRY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.CHESTNUT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.CINNAMON_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.COCONUT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.EBONY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.KIWI_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.LEMON_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.LIME_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.MAHOGANY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.MAPLE_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.OLIVE_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.ORANGE_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.PEACH_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.PEAR_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.PLUM_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.REDWOOD_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.ROSEWOOD_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.RUBBER_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.TEAK_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.WALNUT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.TOWERING_INFERNO_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SLAB.get()), "_slab", "_planks"));
//		slabBlock((SlabBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.NECROTIC_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_SLAB.get()), "_slab", "_planks"));
		
		stairsBlock((StairBlock) TechnologicaBlocks.APRICOT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.ASPEN_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.AVOCADO_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.BANANA_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.CHERRY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.CHESTNUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.CINNAMON_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.COCONUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.EBONY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.KIWI_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.LEMON_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.LIME_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.MAHOGANY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.MAPLE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.OLIVE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.ORANGE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.PEACH_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.PEAR_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.PLUM_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.REDWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.ROSEWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.RUBBER_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.TEAK_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.WALNUT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.TOWERING_INFERNO_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_STAIRS.get()), "_stairs", "_planks"));
//		stairsBlock((StairBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.NECROTIC_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks"));
		
		simpleBlock(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.BANANA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.EBONY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.KIWI_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.KIWI_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.LEMON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LEMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.LIME_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.LIME_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.PEACH_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEACH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.PEAR_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PEAR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.PLUM_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.PLUM_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.TEAK_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ANCIENT_AMBROSIA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CRYOGENIC_SPIRE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TOWERING_INFERNO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TOWERING_INFERNO_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_APOTHECARY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_BOOKSHELF.get()), "bookshelf", "planks")));
//		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_APOTHECARY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_BOOKSHELF.get()), "bookshelf", "planks")));
		
		fenceBlock((FenceBlock) TechnologicaBlocks.APRICOT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.ASPEN_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.AVOCADO_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.BANANA_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.CHERRY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.CHESTNUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.CINNAMON_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.COCONUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.EBONY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.KIWI_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.LEMON_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.LIME_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.MAHOGANY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.MAPLE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.OLIVE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.ORANGE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.PEACH_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.PEAR_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.PLUM_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.REDWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.ROSEWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.RUBBER_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.TEAK_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.WALNUT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.TOWERING_INFERNO_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_FENCE.get()), "_fence", "_planks"));
//		fenceBlock((FenceBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.NECROTIC_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()), "_fence", "_planks"));
		
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.APRICOT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ASPEN_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.BANANA_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.CHERRY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.COCONUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.EBONY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.KIWI_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.LEMON_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.LIME_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.MAPLE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.OLIVE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ORANGE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.RUBBER_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.TEAK_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.WALNUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.TOWERING_INFERNO_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_FENCE_GATE.get()), "_fence_gate", "_planks"));
//		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE_GATE.get()), "_fence_gate", "_planks"));
		
		doorBlock((DoorBlock) TechnologicaBlocks.APRICOT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ASPEN_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ASPEN_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ASPEN_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.AVOCADO_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.AVOCADO_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.AVOCADO_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.BANANA_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BANANA_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BANANA_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.CHERRY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHERRY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHERRY_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.CHESTNUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHESTNUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CHESTNUT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.CINNAMON_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CINNAMON_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CINNAMON_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.COCONUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.COCONUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.COCONUT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.EBONY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.EBONY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.EBONY_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.KIWI_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.KIWI_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.KIWI_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.LEMON_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LEMON_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LEMON_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.LIME_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LIME_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.LIME_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.MAHOGANY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAHOGANY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAHOGANY_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.MAPLE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAPLE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MAPLE_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.OLIVE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.OLIVE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.OLIVE_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ORANGE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ORANGE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ORANGE_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.REDWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ROSEWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.RUBBER_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.TEAK_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.WALNUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.ANCIENT_AMBROSIA_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.CRYOGENIC_SPIRE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.THUNDEROUS_CONDUCTOR_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.TOWERING_INFERNO_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.SERENDIPITIOUS_APOTHECARY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.SERENDIPITIOUS_APOTHECARY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.SERENDIPITIOUS_APOTHECARY_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.BENEVOLENT_APOTHECARY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_DOOR.get()), "_top"));
//		doorBlock((DoorBlock) TechnologicaBlocks.MALEVOLENT_APOTHECARY_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.NECROTIC_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_top"));
		
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.APRICOT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get()), true);
		
		pressurePlateBlockState(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()));
		
		buttonBlockState(TechnologicaBlocks.APRICOT_BUTTON.get(), buttonModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.APRICOT_BUTTON.get()));
		
		signBlock(TechnologicaBlocks.APRICOT_SIGN.get());
		signBlock(TechnologicaBlocks.ASPEN_SIGN.get());
		signBlock(TechnologicaBlocks.AVOCADO_SIGN.get());
		signBlock(TechnologicaBlocks.BANANA_SIGN.get());
		signBlock(TechnologicaBlocks.CHERRY_SIGN.get());
		signBlock(TechnologicaBlocks.CHESTNUT_SIGN.get());
		signBlock(TechnologicaBlocks.CINNAMON_SIGN.get());
		signBlock(TechnologicaBlocks.COCONUT_SIGN.get());
		signBlock(TechnologicaBlocks.EBONY_SIGN.get());
		signBlock(TechnologicaBlocks.KIWI_SIGN.get());
		signBlock(TechnologicaBlocks.LEMON_SIGN.get());
		signBlock(TechnologicaBlocks.LIME_SIGN.get());
		signBlock(TechnologicaBlocks.OLIVE_SIGN.get());
		signBlock(TechnologicaBlocks.ORANGE_SIGN.get());
		signBlock(TechnologicaBlocks.PEACH_SIGN.get());
		signBlock(TechnologicaBlocks.PEAR_SIGN.get());
		signBlock(TechnologicaBlocks.PLUM_SIGN.get());
		signBlock(TechnologicaBlocks.REDWOOD_SIGN.get());
		signBlock(TechnologicaBlocks.ROSEWOOD_SIGN.get());
		signBlock(TechnologicaBlocks.RUBBER_SIGN.get());
		signBlock(TechnologicaBlocks.TEAK_SIGN.get());
		signBlock(TechnologicaBlocks.WALNUT_SIGN.get());
		signBlock(TechnologicaBlocks.ZEBRAWOOD_SIGN.get());
//		signBlock(TechnologicaBlocks.ANICENT_AMBROSIA_SIGN.get());
//		signBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_SIGN.get());
//		signBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SIGN.get());
//		signBlock(TechnologicaBlocks.TOWERING_INFERNO_SIGN.get());
//		signBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SIGN.get());
//		signBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SIGN.get());
//		signBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SIGN.get());
		signBlock(TechnologicaBlocks.NECROTIC_SIGN.get());
		
		signBlock(TechnologicaBlocks.APRICOT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.ASPEN_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.AVOCADO_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.BANANA_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.CHERRY_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.CHESTNUT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.CINNAMON_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.COCONUT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.EBONY_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.KIWI_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.LEMON_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.LIME_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.OLIVE_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.ORANGE_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.PEACH_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.PEAR_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.PLUM_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.REDWOOD_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.RUBBER_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.TEAK_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.WALNUT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.ANICENT_AMBROSIA_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.TOWERING_INFERNO_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_WALL_SIGN.get());
//		signBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.NECROTIC_WALL_SIGN.get());
		
		twelveDirectionBlockState(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), lineShaftHangerModel(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel2(TechnologicaBlocks.LINE_SHAFT_HANGER.get()));
		
		lineShaftBlockState(TechnologicaBlocks.LINE_SHAFT.get(), lineShaftNoPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftSmallPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftMediumPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftLargePulleyModel(TechnologicaBlocks.LINE_SHAFT.get()));
		
		getVariantBuilder(TechnologicaBlocks.SMALL_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()), ResourceLocationHelper.technologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()) + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));
		
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_1HP.get(), motorModel(TechnologicaBlocks.MOTOR_1HP.get()), motor2Model(TechnologicaBlocks.MOTOR_1HP.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.TREE_TAP.get(), treeTapModel(TechnologicaBlocks.TREE_TAP.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.SAWMILL.get(), cubeAll(TechnologicaBlocks.SAWMILL.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ASPEN_CHAIR.get(), chairModel(TechnologicaBlocks.ASPEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.AVOCADO_CHAIR.get(), chairModel(TechnologicaBlocks.AVOCADO_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.BANANA_CHAIR.get(), chairModel(TechnologicaBlocks.BANANA_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.BIRCH_CHAIR.get(), chairModel(TechnologicaBlocks.BIRCH_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.CHERRY_CHAIR.get(), chairModel(TechnologicaBlocks.CHERRY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.CHESTNUT_CHAIR.get(), chairModel(TechnologicaBlocks.CHESTNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.CINNAMON_CHAIR.get(), chairModel(TechnologicaBlocks.CINNAMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.COCONUT_CHAIR.get(), chairModel(TechnologicaBlocks.COCONUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.DARK_OAK_CHAIR.get(), chairModel(TechnologicaBlocks.DARK_OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.EBONY_CHAIR.get(), chairModel(TechnologicaBlocks.EBONY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.JUNGLE_CHAIR.get(), chairModel(TechnologicaBlocks.JUNGLE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.KIWI_CHAIR.get(), chairModel(TechnologicaBlocks.KIWI_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.LEMON_CHAIR.get(), chairModel(TechnologicaBlocks.LEMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.LIME_CHAIR.get(), chairModel(TechnologicaBlocks.LIME_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.MAHOGANY_CHAIR.get(), chairModel(TechnologicaBlocks.MAHOGANY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.MAPLE_CHAIR.get(), chairModel(TechnologicaBlocks.MAPLE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.OAK_CHAIR.get(), chairModel(TechnologicaBlocks.OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.OLIVE_CHAIR.get(), chairModel(TechnologicaBlocks.OLIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ORANGE_CHAIR.get(), chairModel(TechnologicaBlocks.ORANGE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.REDWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.REDWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.RUBBER_CHAIR.get(), chairModel(TechnologicaBlocks.RUBBER_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.SPRUCE_CHAIR.get(), chairModel(TechnologicaBlocks.SPRUCE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.TEAK_CHAIR.get(), chairModel(TechnologicaBlocks.TEAK_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.WALNUT_CHAIR.get(), chairModel(TechnologicaBlocks.WALNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.ANCIENT_AMBROSIA_CHAIR.get(), chairModel(TechnologicaBlocks.ANCIENT_AMBROSIA_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.CRYOGENIC_SPIRE_CHAIR.get(), chairModel(TechnologicaBlocks.CRYOGENIC_SPIRE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_CHAIR.get(), chairModel(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.TOWERING_INFERNO_CHAIR.get(), chairModel(TechnologicaBlocks.TOWERING_INFERNO_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_CHAIR.get(), chairModel(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.BENEVOLENT_APOTHECARY_CHAIR.get(), chairModel(TechnologicaBlocks.BENEVOLENT_APOTHECARY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_CHAIR.get()), "chair", "planks")));
//		fourDirectionBlockState(TechnologicaBlocks.MALEVOLENT_APOTHECARY_CHAIR.get(), chairModel(TechnologicaBlocks.MALEVOLENT_APOTHECARY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.NECROTIC_CHAIR.get(), chairModel(TechnologicaBlocks.NECROTIC_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_CHAIR.get()), "chair", "planks")));
		
		simpleBlock(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.AVOCADO_TABLE.get(), tableModel(TechnologicaBlocks.AVOCADO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.BANANA_TABLE.get(), tableModel(TechnologicaBlocks.BANANA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.BIRCH_TABLE.get(), tableModel(TechnologicaBlocks.BIRCH_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.CHERRY_TABLE.get(), tableModel(TechnologicaBlocks.CHERRY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CHESTNUT_TABLE.get(), tableModel(TechnologicaBlocks.CHESTNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CINNAMON_TABLE.get(), tableModel(TechnologicaBlocks.CINNAMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.COCONUT_TABLE.get(), tableModel(TechnologicaBlocks.COCONUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.DARK_OAK_TABLE.get(), tableModel(TechnologicaBlocks.DARK_OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.EBONY_TABLE.get(), tableModel(TechnologicaBlocks.EBONY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.JUNGLE_TABLE.get(), tableModel(TechnologicaBlocks.JUNGLE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.KIWI_TABLE.get(), tableModel(TechnologicaBlocks.KIWI_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.LEMON_TABLE.get(), tableModel(TechnologicaBlocks.LEMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.LIME_TABLE.get(), tableModel(TechnologicaBlocks.LIME_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.MAHOGANY_TABLE.get(), tableModel(TechnologicaBlocks.MAHOGANY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.MAPLE_TABLE.get(), tableModel(TechnologicaBlocks.MAPLE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.OAK_TABLE.get(), tableModel(TechnologicaBlocks.OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.OLIVE_TABLE.get(), tableModel(TechnologicaBlocks.OLIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ORANGE_TABLE.get(), tableModel(TechnologicaBlocks.ORANGE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.REDWOOD_TABLE.get(), tableModel(TechnologicaBlocks.REDWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ROSEWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.RUBBER_TABLE.get(), tableModel(TechnologicaBlocks.RUBBER_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.SPRUCE_TABLE.get(), tableModel(TechnologicaBlocks.SPRUCE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.TEAK_TABLE.get(), tableModel(TechnologicaBlocks.TEAK_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.WALNUT_TABLE.get(), tableModel(TechnologicaBlocks.WALNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.ANCIENT_AMBROSIA_TABLE.get(), tableModel(TechnologicaBlocks.ANCIENT_AMBROSIA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ANCIENT_AMBROSIA_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.CRYOGENIC_SPIRE_TABLE.get(), tableModel(TechnologicaBlocks.CRYOGENIC_SPIRE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRYOGENIC_SPIRE_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_TABLE.get(), tableModel(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.TOWERING_INFERNO_TABLE.get(), tableModel(TechnologicaBlocks.TOWERING_INFERNO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TOWERING_INFERNO_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_TABLE.get(), tableModel(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.BENEVOLENT_APOTHECARY_TABLE.get(), tableModel(TechnologicaBlocks.BENEVOLENT_APOTHECARY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_APOTHECARY_TABLE.get()), "table", "planks")));
//		simpleBlock(TechnologicaBlocks.MALEVOLENT_APOTHECARY_TABLE.get(), tableModel(TechnologicaBlocks.MALEVOLENT_APOTHECARY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_APOTHECARY_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.NECROTIC_TABLE.get(), tableModel(TechnologicaBlocks.NECROTIC_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_TABLE.get()), "table", "planks")));
		
		simpleBlock(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
		
		annunciatorBlockState(TechnologicaBlocks.ANNUNCIATOR.get());
		
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain"), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain"));
		
		/*
		 * BLOCK ITEMS
		 */
		
		simpleBlockItem(TechnologicaBlocks.APRICOT_LEAVES.get(), cubeAll(TechnologicaBlocks.APRICOT_LEAVES.get()));
		
		simpleBlockItem(TechnologicaBlocks.SALT.get(), cubeAll(TechnologicaBlocks.SALT.get()));
		simpleBlockItem(TechnologicaBlocks.LITHIUM_CLAY.get(), cubeAll(TechnologicaBlocks.SALT.get()));
		simpleBlockItem(TechnologicaBlocks.MOON_ROCK.get(), cubeAll(TechnologicaBlocks.MOON_ROCK.get()));
		simpleBlockItem(TechnologicaBlocks.MOON_DUST.get(), cubeAll(TechnologicaBlocks.MOON_DUST.get()));
		
		simpleBlockItem(TechnologicaBlocks.BAUXITE_ORE.get(), cubeAll(TechnologicaBlocks.BAUXITE_ORE.get()));
		
		simpleBlockItem(TechnologicaBlocks.APRICOT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.APRICOT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.APRICOT_LOG.get()) + "_top")));
		
		simpleBlockItem(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get()) + "_top")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")));
		
		simpleBlockItem(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_PLANKS.get(), cubeAll(TechnologicaBlocks.APRICOT_PLANKS.get()));
		
		simpleBlockItem(TechnologicaBlocks.APRICOT_SLAB.get(), models().slab(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_SLAB.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_STAIRS.get(), models().stairs(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_STAIRS.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), "bookshelf", "planks"), "bookshelf", "planks")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks")));
	
		simpleBlockItem(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), models().fenceGate(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), "_fence_gate", "_planks")));
	
		doorBlockItem(TechnologicaBlocks.APRICOT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		
		simpleBlockItem(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), models().trapdoorOrientableBottom(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_TRAPDOOR.get()) + "_bottom", blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get())));
		
		simpleBlockItem(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks")));
		
		simpleBlockItem(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
	}	
	
	/*
	 * ModelFiles
	 */
	
	public ModelFile chairModel(Block block, ResourceLocation texture) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("chair"), "planks", texture);
	}
	
	public ModelFile tableModel(Block block, ResourceLocation texture) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("table"), "planks", texture);
	}
	
	public ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
	
	public ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
	
	public ModelFile smallPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc(ResourceLocationHelper.getPath(block))).texture("0", ResourceLocationHelper.technologicaLocation("block/" + ResourceLocationHelper.getPath(block)));
    }
	
	public ModelFile lineShaftNoPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_no_pulley", modLoc("line_shaft_no_pulley_model")).texture("0", new ResourceLocation(Technologica.MODID, "block/pulley"));
    }
	
	public ModelFile lineShaftSmallPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_small_pulley", modLoc("line_shaft_small_pulley_model")).texture("0", new ResourceLocation(Technologica.MODID, "block/pulley"));
    }
	
	public ModelFile lineShaftMediumPulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_medium_pulley", modLoc("line_shaft_medium_pulley_model")).texture("0", new ResourceLocation(Technologica.MODID, "block/pulley"));
    }
	
	public ModelFile lineShaftLargePulleyModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_large_pulley", modLoc("line_shaft_large_pulley_model")).texture("0", new ResourceLocation(Technologica.MODID, "block/pulley"));
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
	
	public ModelFile displayModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	public ModelFile pressurePlateModel(Block block) {
        return models().withExistingParent(ResourceLocationHelper.getPath(block), "block/pressure_plate_up").texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile pressurePlateDownModel(Block block) {
        return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_down", "block/pressure_plate_down").texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile buttonModel(Block block) {
        return models().withExistingParent(ResourceLocationHelper.getPath(block), "block/button").texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonPressedModel(Block block) {
        return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_pressed", "block/button_pressed").texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonInventoryModel(Block block) {
        return models().withExistingParent(ResourceLocationHelper.getPath(block) + "_inventory", "block/button_inventory").texture("texture", ResourceLocationHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile sign(Block block) {
        ResourceLocation location = block.getRegistryName();
        return models().getBuilder(location.getPath()).texture("particle", ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(block), "_wall", ""), "_sign", "_planks"));
    }

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return models().withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
    }
	
	public ModelFile fluid(Block block) {
		ResourceLocation location = block.getRegistryName();
        return models().getBuilder(location.getPath()).texture("particle", "minecraft:block/water_still");
    }
	
	/*
	 * Blockstate, block model, and item model providers
	 */
	
	public void pressurePlateBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
    	getVariantBuilder(block)
    		.partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(blockModel1).addModel()
        	.partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(blockModel2).addModel();
    	this.simpleBlockItem(block, blockModel1);
    }
	
	public void fourDirectionBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block)
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
	    this.simpleBlockItem(block, blockModel);
    }
	
	public void twelveDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
    	getVariantBuilder(block)
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
    	this.simpleBlockItem(block, blockModel1);
    }
	
	public void twentyFourDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
    	getVariantBuilder(block)
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationX(270).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(270).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(90).rotationX(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel();
    	this.simpleBlockItem(block, blockModel1);
    }
	
	public void lineShaftBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3, ModelFile blockModel4) {
    	getVariantBuilder(block)
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).addModel()
    		.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).addModel();
    	this.simpleBlockItem(block, blockModel1);
    }
	
	public void buttonBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile itemModel) {
    	getVariantBuilder(block)
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).uvLock(true).addModel();
    	this.simpleBlockItem(block, itemModel);
    }
	
    public void signBlock(Block block) {
		getVariantBuilder(block)
			.partialState().setModels(new ConfiguredModel(sign(block)));
	    this.signItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
	}
    
	public void cropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel()
			.partialState().with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel()
			.partialState().with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel()
			.partialState().with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel()
			.partialState().with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage4", ResourceLocationHelper.extend(blockTexture(block), "_stage4"))).addModel()
			.partialState().with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage5", ResourceLocationHelper.extend(blockTexture(block), "_stage5"))).addModel()
			.partialState().with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage6", ResourceLocationHelper.extend(blockTexture(block), "_stage6"))).addModel()
			.partialState().with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage7", ResourceLocationHelper.extend(blockTexture(block), "_stage7"))).addModel();
	}
	
	public void tallCropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage0", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage1", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage2", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage3", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage4", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage5", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage6", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage7", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage7"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage0", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage1", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage2", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage3", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage4", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage5", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage6", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage7", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage7"))).addModel();
	}
	
	public void annunciatorBlockState(Block block) {
		ResourceLocation sides = new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_side");
		getVariantBuilder(block)
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_info"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_fail"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_pass"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_warn"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_info"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_fail"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_pass"), sides)).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_warn"), sides)).addModel()
			
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_info"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_fail"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_pass"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_warn"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_info"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_fail"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_pass"), sides)).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_warn"), sides)).rotationY(90).addModel()
			
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_info"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_fail"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_pass"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_warn"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_info"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_fail"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_pass"), sides)).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_warn"), sides)).rotationY(180).addModel()
			
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_info"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_fail" ,sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_fail"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_pass"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, false).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_warn"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_info"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_fail"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_pass"), sides)).rotationY(270).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.LIT, true).with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN).modelForState().modelFile(models().orientable(block.getRegistryName().getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_warn"), sides)).rotationY(270).addModel();
			
	    this.simpleBlockItem(block, models().orientable(block.getRegistryName().getPath(), sides, new ResourceLocation(Technologica.MODID, "block/" + block.getRegistryName().getPath() + "_lit_info"), sides));
    }
	
	/*
	 * Item model providers
	 */
	
	public void doorBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath()));
	}
	
	public void signItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(block), "_wall", ""), "block", "item"));
	}
}
