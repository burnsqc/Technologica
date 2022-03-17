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
		
		simpleBlock(TechnologicaBlocks.SALT.get());
		simpleBlock(TechnologicaBlocks.LITHIUM_CLAY.get());
		simpleBlock(TechnologicaBlocks.MOON_ROCK.get());
		simpleBlock(TechnologicaBlocks.MOON_DUST.get());
		
		simpleBlock(TechnologicaBlocks.BAUXITE_ORE.get());
		
		twentyFourDirectionBlockState(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()));
		
		twentyFourDirectionBlockState(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()), cubicCrystalModel(TechnologicaBlocks.DOLOMITE_CRYSTAL.get()));
		
		getVariantBuilder(TechnologicaBlocks.HYDROGEN.get()).partialState().setModels(new ConfiguredModel(fluid(TechnologicaBlocks.HYDROGEN.get())));
		
		logBlock((RotatedPillarBlock) TechnologicaBlocks.APRICOT_LOG.get());
		
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_LOG.get());
		
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_WOOD.get()), "_wood", "_log")));
		
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get()), "_wood", "_log")));
		
		simpleBlock(TechnologicaBlocks.APRICOT_PLANKS.get());
		
		slabBlock((SlabBlock) TechnologicaBlocks.APRICOT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_SLAB.get()), "_slab", "_planks"));
		
		stairsBlock((StairBlock) TechnologicaBlocks.APRICOT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_STAIRS.get()), "_stairs", "_planks"));
		
		simpleBlock(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), "bookshelf", "planks")));
		
		fenceBlock((FenceBlock) TechnologicaBlocks.APRICOT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks"));
		
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.APRICOT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		
		doorBlock((DoorBlock) TechnologicaBlocks.APRICOT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.APRICOT_DOOR.get()), "_top"));
		
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.APRICOT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get()), true);
		
		pressurePlateBlockState(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()));
		
		buttonBlockState(TechnologicaBlocks.APRICOT_BUTTON.get(), buttonModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.APRICOT_BUTTON.get()));
		
		signBlock(TechnologicaBlocks.APRICOT_SIGN.get());
		
		signBlock(TechnologicaBlocks.APRICOT_WALL_SIGN.get());
		
		twelveDirectionBlockState(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), lineShaftHangerModel(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel2(TechnologicaBlocks.LINE_SHAFT_HANGER.get()));
		
		lineShaftBlockState(TechnologicaBlocks.LINE_SHAFT.get(), lineShaftNoPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftSmallPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftMediumPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftLargePulleyModel(TechnologicaBlocks.LINE_SHAFT.get()));
		
		getVariantBuilder(TechnologicaBlocks.SMALL_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()), ResourceLocationHelper.technologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()) + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));
		
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_1HP.get(), motorModel(TechnologicaBlocks.MOTOR_1HP.get()), motor2Model(TechnologicaBlocks.MOTOR_1HP.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.TREE_TAP.get(), treeTapModel(TechnologicaBlocks.TREE_TAP.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.SAWMILL.get(), cubeAll(TechnologicaBlocks.SAWMILL.get()));
		
		fourDirectionBlockState(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks")));
		
		simpleBlock(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks")));
		
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
