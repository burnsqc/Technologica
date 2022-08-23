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
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaBlockStateProvider extends BlockStateProvider {
	public TechnologicaBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		cropBlocks();
		saplingBlocks();
		pottedSaplingBlocks();

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
		simpleBlock(TechnologicaBlocks.FRUITFUL_LEAVES.get());
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_LEAVES.get());
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_LEAVES.get());
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_LEAVES.get());
		simpleBlock(TechnologicaBlocks.BENEVOLENT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.MALEVOLENT_LEAVES.get());
		simpleBlock(TechnologicaBlocks.CURSED_LEAVES.get());

		simpleBlock(TechnologicaBlocks.MULCH.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_side"), mcLoc("block/dirt"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.MULCH.get()) + "_top")));

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
		twentyFourDirectionBlockState(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.FLUORITE_CRYSTAL.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), hexagonalCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()), hexagonalCrystalModel(TechnologicaBlocks.ULEXITE_CRYSTAL.get()));

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
		logBlock((RotatedPillarBlock) TechnologicaBlocks.FRUITFUL_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.FROSTBITTEN_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.CONDUCTIVE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.ALCHEMICAL_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.INFERNAL_LOG.get());
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
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get());
		logBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get());
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
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.FRUITFUL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.FROSTBITTEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.CONDUCTIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.ALCHEMICAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.BENEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.MALEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.INFERNAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_WOOD.get()), "_wood", "_log")));
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
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get()), "_wood", "_log")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log")), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get()), "_wood", "_log")));
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
		simpleBlock(TechnologicaBlocks.FRUITFUL_PLANKS.get());
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		simpleBlock(TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		simpleBlock(TechnologicaBlocks.INFERNAL_PLANKS.get());
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
		slabBlock((SlabBlock) TechnologicaBlocks.FRUITFUL_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.FROSTBITTEN_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.CONDUCTIVE_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.ALCHEMICAL_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.BENEVOLENT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.MALEVOLENT_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_SLAB.get()), "_slab", "_planks"));
		slabBlock((SlabBlock) TechnologicaBlocks.INFERNAL_SLAB.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_SLAB.get()), "_slab", "_planks"), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_SLAB.get()), "_slab", "_planks"));
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
		stairsBlock((StairBlock) TechnologicaBlocks.FRUITFUL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.BENEVOLENT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.MALEVOLENT_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.INFERNAL_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_STAIRS.get()), "_stairs", "_planks"));
		stairsBlock((StairBlock) TechnologicaBlocks.NECROTIC_STAIRS.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_STAIRS.get()), "_stairs", "_planks"));

		simpleBlock(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.ACACIA_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.BANANA_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BANANA_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.BIRCH_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.CRIMSON_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.EBONY_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.EBONY_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.JUNGLE_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
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
		simpleBlock(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.SPRUCE_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.TEAK_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.TEAK_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.WARPED_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.WARPED_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()), ResourceLocationHelper.replace(mcLoc(blockTexture(TechnologicaBlocks.WARPED_BOOKSHELF.get()).getPath()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get()), "bookshelf", "planks")));
		simpleBlock(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_BOOKSHELF.get()), "bookshelf", "planks")));
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
		fenceBlock((FenceBlock) TechnologicaBlocks.FRUITFUL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.FROSTBITTEN_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.CONDUCTIVE_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.ALCHEMICAL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.BENEVOLENT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.MALEVOLENT_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()), "_fence", "_planks"));
		fenceBlock((FenceBlock) TechnologicaBlocks.INFERNAL_FENCE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()), "_fence", "_planks"));
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
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.PEACH_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.PEAR_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.PLUM_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.RUBBER_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.TEAK_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.WALNUT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get()), "_fence_gate", "_planks"));
		fenceGateBlock((FenceGateBlock) TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE_GATE.get()), "_fence_gate", "_planks"));
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
		doorBlock((DoorBlock) TechnologicaBlocks.PEACH_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEACH_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEACH_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.PEAR_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEAR_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PEAR_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.PLUM_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PLUM_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.PLUM_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.REDWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.REDWOOD_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ROSEWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ROSEWOOD_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.RUBBER_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.RUBBER_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.TEAK_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.TEAK_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.WALNUT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.WALNUT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ZEBRAWOOD_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.FRUITFUL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FRUITFUL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FRUITFUL_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.FROSTBITTEN_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FROSTBITTEN_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.FROSTBITTEN_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.CONDUCTIVE_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CONDUCTIVE_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.CONDUCTIVE_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.ALCHEMICAL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ALCHEMICAL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.ALCHEMICAL_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.BENEVOLENT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.BENEVOLENT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.MALEVOLENT_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.MALEVOLENT_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.INFERNAL_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.INFERNAL_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.INFERNAL_DOOR.get()), "_top"));
		doorBlock((DoorBlock) TechnologicaBlocks.NECROTIC_DOOR.get(), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_bottom"), ResourceLocationHelper.extend(blockTexture(TechnologicaBlocks.NECROTIC_DOOR.get()), "_top"));

		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.APRICOT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.APRICOT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.ASPEN_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ASPEN_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.AVOCADO_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.BANANA_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.BANANA_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.CHERRY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CHERRY_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CINNAMON_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.COCONUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.COCONUT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.EBONY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.EBONY_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.KIWI_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.KIWI_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.LEMON_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.LEMON_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.LIME_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.LIME_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.MAPLE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MAPLE_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.OLIVE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.OLIVE_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.ORANGE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ORANGE_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.PEACH_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PEACH_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.PEAR_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PEAR_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.PLUM_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.PLUM_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.REDWOOD_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.RUBBER_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.RUBBER_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.TEAK_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.TEAK_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.WALNUT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.WALNUT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.INFERNAL_TRAPDOOR.get()), true);
		trapdoorBlock((TrapDoorBlock) TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), blockTexture(TechnologicaBlocks.NECROTIC_TRAPDOOR.get()), true);

		pressurePlateBlockState(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.LIME_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.LIME_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get()));
		pressurePlateBlockState(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get(), pressurePlateModel(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get()), pressurePlateDownModel(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get()));

		buttonBlockState(TechnologicaBlocks.APRICOT_BUTTON.get(), buttonModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.APRICOT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.APRICOT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.ASPEN_BUTTON.get(), buttonModel(TechnologicaBlocks.ASPEN_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.ASPEN_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.ASPEN_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.AVOCADO_BUTTON.get(), buttonModel(TechnologicaBlocks.AVOCADO_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.AVOCADO_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.AVOCADO_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.BANANA_BUTTON.get(), buttonModel(TechnologicaBlocks.BANANA_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.BANANA_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.BANANA_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.CHERRY_BUTTON.get(), buttonModel(TechnologicaBlocks.CHERRY_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.CHERRY_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.CHERRY_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.CHESTNUT_BUTTON.get(), buttonModel(TechnologicaBlocks.CHESTNUT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.CHESTNUT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.CHESTNUT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.CINNAMON_BUTTON.get(), buttonModel(TechnologicaBlocks.CINNAMON_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.CINNAMON_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.CINNAMON_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.COCONUT_BUTTON.get(), buttonModel(TechnologicaBlocks.COCONUT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.COCONUT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.COCONUT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.EBONY_BUTTON.get(), buttonModel(TechnologicaBlocks.EBONY_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.EBONY_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.EBONY_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.KIWI_BUTTON.get(), buttonModel(TechnologicaBlocks.KIWI_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.KIWI_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.KIWI_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.LEMON_BUTTON.get(), buttonModel(TechnologicaBlocks.LEMON_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.LEMON_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.LEMON_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.LIME_BUTTON.get(), buttonModel(TechnologicaBlocks.LIME_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.LIME_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.LIME_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.MAHOGANY_BUTTON.get(), buttonModel(TechnologicaBlocks.MAHOGANY_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.MAHOGANY_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.MAHOGANY_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.MAPLE_BUTTON.get(), buttonModel(TechnologicaBlocks.MAPLE_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.MAPLE_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.MAPLE_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.OLIVE_BUTTON.get(), buttonModel(TechnologicaBlocks.OLIVE_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.OLIVE_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.OLIVE_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.ORANGE_BUTTON.get(), buttonModel(TechnologicaBlocks.ORANGE_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.ORANGE_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.ORANGE_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.PEACH_BUTTON.get(), buttonModel(TechnologicaBlocks.PEACH_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.PEACH_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.PEACH_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.PEAR_BUTTON.get(), buttonModel(TechnologicaBlocks.PEAR_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.PEAR_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.PEAR_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.PLUM_BUTTON.get(), buttonModel(TechnologicaBlocks.PLUM_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.PLUM_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.PLUM_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.REDWOOD_BUTTON.get(), buttonModel(TechnologicaBlocks.REDWOOD_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.REDWOOD_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.REDWOOD_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.ROSEWOOD_BUTTON.get(), buttonModel(TechnologicaBlocks.ROSEWOOD_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.ROSEWOOD_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.ROSEWOOD_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.RUBBER_BUTTON.get(), buttonModel(TechnologicaBlocks.RUBBER_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.RUBBER_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.RUBBER_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.TEAK_BUTTON.get(), buttonModel(TechnologicaBlocks.TEAK_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.TEAK_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.TEAK_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.WALNUT_BUTTON.get(), buttonModel(TechnologicaBlocks.WALNUT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.WALNUT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.WALNUT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), buttonModel(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.FRUITFUL_BUTTON.get(), buttonModel(TechnologicaBlocks.FRUITFUL_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.FRUITFUL_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.FRUITFUL_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), buttonModel(TechnologicaBlocks.FROSTBITTEN_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.FROSTBITTEN_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.FROSTBITTEN_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), buttonModel(TechnologicaBlocks.CONDUCTIVE_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.CONDUCTIVE_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.CONDUCTIVE_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), buttonModel(TechnologicaBlocks.ALCHEMICAL_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.ALCHEMICAL_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.ALCHEMICAL_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.BENEVOLENT_BUTTON.get(), buttonModel(TechnologicaBlocks.BENEVOLENT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.BENEVOLENT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.BENEVOLENT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.MALEVOLENT_BUTTON.get(), buttonModel(TechnologicaBlocks.MALEVOLENT_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.MALEVOLENT_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.MALEVOLENT_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.INFERNAL_BUTTON.get(), buttonModel(TechnologicaBlocks.INFERNAL_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.INFERNAL_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.INFERNAL_BUTTON.get()));
		buttonBlockState(TechnologicaBlocks.NECROTIC_BUTTON.get(), buttonModel(TechnologicaBlocks.NECROTIC_BUTTON.get()), buttonPressedModel(TechnologicaBlocks.NECROTIC_BUTTON.get()), buttonInventoryModel(TechnologicaBlocks.NECROTIC_BUTTON.get()));

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
		signBlock(TechnologicaBlocks.MAHOGANY_SIGN.get());
		signBlock(TechnologicaBlocks.MAPLE_SIGN.get());
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
		signBlock(TechnologicaBlocks.FRUITFUL_SIGN.get());
		signBlock(TechnologicaBlocks.FROSTBITTEN_SIGN.get());
		signBlock(TechnologicaBlocks.CONDUCTIVE_SIGN.get());
		signBlock(TechnologicaBlocks.ALCHEMICAL_SIGN.get());
		signBlock(TechnologicaBlocks.BENEVOLENT_SIGN.get());
		signBlock(TechnologicaBlocks.MALEVOLENT_SIGN.get());
		signBlock(TechnologicaBlocks.INFERNAL_SIGN.get());
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
		signBlock(TechnologicaBlocks.MAHOGANY_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.MAPLE_WALL_SIGN.get());
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
		signBlock(TechnologicaBlocks.FRUITFUL_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.INFERNAL_WALL_SIGN.get());
		signBlock(TechnologicaBlocks.NECROTIC_WALL_SIGN.get());

		twelveDirectionBlockState(TechnologicaBlocks.LINE_SHAFT_HANGER.get(), lineShaftHangerModel(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), lineShaftHangerModel2(TechnologicaBlocks.LINE_SHAFT_HANGER.get()));

		lineShaftBlockState(TechnologicaBlocks.LINE_SHAFT.get(), lineShaftNoPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftSmallPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftMediumPulleyModel(TechnologicaBlocks.LINE_SHAFT.get()), lineShaftLargePulleyModel(TechnologicaBlocks.LINE_SHAFT.get()));

		getVariantBuilder(TechnologicaBlocks.SMALL_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()), ResourceLocationHelper.technologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.SMALL_PULLEY.get()) + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.MEDIUM_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()), ResourceLocationHelper.technologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.MEDIUM_PULLEY.get()) + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));
		getVariantBuilder(TechnologicaBlocks.LARGE_PULLEY.get()).partialState().setModels(new ConfiguredModel(models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()), ResourceLocationHelper.technologicaLocation(ResourceLocationHelper.getPath(TechnologicaBlocks.LARGE_PULLEY.get()) + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));

		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_1HP.get(), motorModel(TechnologicaBlocks.MOTOR_1HP.get()), motor2Model(TechnologicaBlocks.MOTOR_1HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_5HP.get(), motorModel(TechnologicaBlocks.MOTOR_5HP.get()), motor2Model(TechnologicaBlocks.MOTOR_5HP.get()));
		twentyFourDirectionBlockState(TechnologicaBlocks.MOTOR_20HP.get(), motorModel(TechnologicaBlocks.MOTOR_20HP.get()), motor2Model(TechnologicaBlocks.MOTOR_20HP.get()));

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
		fourDirectionBlockState(TechnologicaBlocks.CRIMSON_CHAIR.get(), chairModel(TechnologicaBlocks.CRIMSON_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_CHAIR.get()).getPath(), "chair", "planks"))));
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
		fourDirectionBlockState(TechnologicaBlocks.PEACH_CHAIR.get(), chairModel(TechnologicaBlocks.PEACH_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.PEAR_CHAIR.get(), chairModel(TechnologicaBlocks.PEAR_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.PLUM_CHAIR.get(), chairModel(TechnologicaBlocks.PLUM_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.REDWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.REDWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.RUBBER_CHAIR.get(), chairModel(TechnologicaBlocks.RUBBER_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.SPRUCE_CHAIR.get(), chairModel(TechnologicaBlocks.SPRUCE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.TEAK_CHAIR.get(), chairModel(TechnologicaBlocks.TEAK_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.WALNUT_CHAIR.get(), chairModel(TechnologicaBlocks.WALNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.WARPED_CHAIR.get(), chairModel(TechnologicaBlocks.WARPED_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_CHAIR.get()).getPath(), "chair", "planks"))));
		fourDirectionBlockState(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.FRUITFUL_CHAIR.get(), chairModel(TechnologicaBlocks.FRUITFUL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), chairModel(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), chairModel(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), chairModel(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.INFERNAL_CHAIR.get(), chairModel(TechnologicaBlocks.INFERNAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_CHAIR.get()), "chair", "planks")));
		fourDirectionBlockState(TechnologicaBlocks.NECROTIC_CHAIR.get(), chairModel(TechnologicaBlocks.NECROTIC_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_CHAIR.get()), "chair", "planks")));

		simpleBlock(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ASPEN_TABLE.get(), tableModel(TechnologicaBlocks.ASPEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.AVOCADO_TABLE.get(), tableModel(TechnologicaBlocks.AVOCADO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.BANANA_TABLE.get(), tableModel(TechnologicaBlocks.BANANA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.BIRCH_TABLE.get(), tableModel(TechnologicaBlocks.BIRCH_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.CHERRY_TABLE.get(), tableModel(TechnologicaBlocks.CHERRY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CHESTNUT_TABLE.get(), tableModel(TechnologicaBlocks.CHESTNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CINNAMON_TABLE.get(), tableModel(TechnologicaBlocks.CINNAMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.COCONUT_TABLE.get(), tableModel(TechnologicaBlocks.COCONUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CRIMSON_TABLE.get(), tableModel(TechnologicaBlocks.CRIMSON_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_TABLE.get()).getPath(), "table", "planks"))));
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
		simpleBlock(TechnologicaBlocks.PEACH_TABLE.get(), tableModel(TechnologicaBlocks.PEACH_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.PEAR_TABLE.get(), tableModel(TechnologicaBlocks.PEAR_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.PLUM_TABLE.get(), tableModel(TechnologicaBlocks.PLUM_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.REDWOOD_TABLE.get(), tableModel(TechnologicaBlocks.REDWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ROSEWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ROSEWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.RUBBER_TABLE.get(), tableModel(TechnologicaBlocks.RUBBER_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.SPRUCE_TABLE.get(), tableModel(TechnologicaBlocks.SPRUCE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.TEAK_TABLE.get(), tableModel(TechnologicaBlocks.TEAK_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.WALNUT_TABLE.get(), tableModel(TechnologicaBlocks.WALNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.WARPED_TABLE.get(), tableModel(TechnologicaBlocks.WARPED_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlock(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.FRUITFUL_TABLE.get(), tableModel(TechnologicaBlocks.FRUITFUL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), tableModel(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), tableModel(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), tableModel(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.BENEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.BENEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.MALEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.MALEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.INFERNAL_TABLE.get(), tableModel(TechnologicaBlocks.INFERNAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_TABLE.get()), "table", "planks")));
		simpleBlock(TechnologicaBlocks.NECROTIC_TABLE.get(), tableModel(TechnologicaBlocks.NECROTIC_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_TABLE.get()), "table", "planks")));

		simpleBlock(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));

		annunciatorBlockState(TechnologicaBlocks.ANNUNCIATOR.get());

		simpleBlock(TechnologicaBlocks.NITROGLYCERIN.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_side"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_bottom"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_top")));
		axisBlock((RotatedPillarBlock) TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain"), models().withExistingParent(ResourceLocationHelper.getPath(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), "block/chain"));

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
		simpleBlockItem(TechnologicaBlocks.MOON_ROCK.get(), cubeAll(TechnologicaBlocks.MOON_ROCK.get()));
		simpleBlockItem(TechnologicaBlocks.MOON_DUST.get(), cubeAll(TechnologicaBlocks.MOON_DUST.get()));

		simpleBlockItem(TechnologicaBlocks.BAUXITE_ORE.get(), cubeAll(TechnologicaBlocks.BAUXITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.CHROMITE_ORE.get(), cubeAll(TechnologicaBlocks.CHROMITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.ILMENITE_ORE.get(), cubeAll(TechnologicaBlocks.ILMENITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.PYROLUSITE_ORE.get(), cubeAll(TechnologicaBlocks.PYROLUSITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.COBALTITE_ORE.get(), cubeAll(TechnologicaBlocks.COBALTITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.GARNIERITE_ORE.get(), cubeAll(TechnologicaBlocks.GARNIERITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.BORAX_ORE.get(), cubeAll(TechnologicaBlocks.BORAX_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.MAGNESITE_ORE.get(), cubeAll(TechnologicaBlocks.MAGNESITE_ORE.get()));
		simpleBlockItem(TechnologicaBlocks.SPODUMENE_ORE.get(), cubeAll(TechnologicaBlocks.SPODUMENE_ORE.get()));

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
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_LOG.get(), models().cubeColumn(ResourceLocationHelper.getPath(TechnologicaBlocks.FROSTBITTEN_LOG.get()), blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()), new ResourceLocation(blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()) + "_top")));
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

		simpleBlockItem(TechnologicaBlocks.APRICOT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHERRY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.EBONY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.KIWI_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.LIME_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.OLIVE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.TEAK_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_FENCE.get()), "_fence", "_planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_FENCE.get(), models().fenceInventory(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()) + "_inventory", ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_FENCE.get()), "_fence", "_planks")));

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

		doorBlockItem(TechnologicaBlocks.APRICOT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.ASPEN_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.AVOCADO_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.BANANA_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.CHERRY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.CHESTNUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.CINNAMON_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.COCONUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.EBONY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.KIWI_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.LEMON_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.LIME_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.MAHOGANY_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.MAPLE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.OLIVE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.ORANGE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.PEACH_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.PEAR_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.PLUM_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.REDWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.ROSEWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.RUBBER_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.TEAK_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.WALNUT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.FRUITFUL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.BENEVOLENT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.MALEVOLENT_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.INFERNAL_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));
		doorBlockItem(TechnologicaBlocks.NECROTIC_DOOR.get(), new ModelFile.UncheckedModelFile("item/generated"));

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

		simpleBlockItem(TechnologicaBlocks.ACACIA_CHAIR.get(), chairModel(TechnologicaBlocks.ACACIA_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.APRICOT_CHAIR.get(), chairModel(TechnologicaBlocks.APRICOT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_CHAIR.get(), chairModel(TechnologicaBlocks.ASPEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_CHAIR.get(), chairModel(TechnologicaBlocks.AVOCADO_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_CHAIR.get(), chairModel(TechnologicaBlocks.BANANA_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.BIRCH_CHAIR.get(), chairModel(TechnologicaBlocks.BIRCH_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.CHERRY_CHAIR.get(), chairModel(TechnologicaBlocks.CHERRY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_CHAIR.get(), chairModel(TechnologicaBlocks.CHESTNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_CHAIR.get(), chairModel(TechnologicaBlocks.CINNAMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_CHAIR.get(), chairModel(TechnologicaBlocks.COCONUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.DARK_OAK_CHAIR.get(), chairModel(TechnologicaBlocks.DARK_OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.EBONY_CHAIR.get(), chairModel(TechnologicaBlocks.EBONY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.JUNGLE_CHAIR.get(), chairModel(TechnologicaBlocks.JUNGLE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.KIWI_CHAIR.get(), chairModel(TechnologicaBlocks.KIWI_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_CHAIR.get(), chairModel(TechnologicaBlocks.LEMON_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_CHAIR.get(), chairModel(TechnologicaBlocks.LIME_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_CHAIR.get(), chairModel(TechnologicaBlocks.MAHOGANY_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_CHAIR.get(), chairModel(TechnologicaBlocks.MAPLE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.OAK_CHAIR.get(), chairModel(TechnologicaBlocks.OAK_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.OLIVE_CHAIR.get(), chairModel(TechnologicaBlocks.OLIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_CHAIR.get(), chairModel(TechnologicaBlocks.ORANGE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_CHAIR.get(), chairModel(TechnologicaBlocks.PEACH_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_CHAIR.get(), chairModel(TechnologicaBlocks.PEAR_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_CHAIR.get(), chairModel(TechnologicaBlocks.PLUM_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.REDWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_CHAIR.get(), chairModel(TechnologicaBlocks.RUBBER_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.SPRUCE_CHAIR.get(), chairModel(TechnologicaBlocks.SPRUCE_CHAIR.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_CHAIR.get()).getPath(), "chair", "planks"))));
		simpleBlockItem(TechnologicaBlocks.TEAK_CHAIR.get(), chairModel(TechnologicaBlocks.TEAK_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_CHAIR.get(), chairModel(TechnologicaBlocks.WALNUT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), chairModel(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_CHAIR.get(), chairModel(TechnologicaBlocks.FRUITFUL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), chairModel(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), chairModel(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), chairModel(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), chairModel(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_CHAIR.get(), chairModel(TechnologicaBlocks.INFERNAL_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_CHAIR.get()), "chair", "planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_CHAIR.get(), chairModel(TechnologicaBlocks.NECROTIC_CHAIR.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_CHAIR.get()), "chair", "planks")));

		simpleBlockItem(TechnologicaBlocks.ACACIA_TABLE.get(), tableModel(TechnologicaBlocks.ACACIA_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ACACIA_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.APRICOT_TABLE.get(), tableModel(TechnologicaBlocks.APRICOT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.APRICOT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.ASPEN_TABLE.get(), tableModel(TechnologicaBlocks.ASPEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ASPEN_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.AVOCADO_TABLE.get(), tableModel(TechnologicaBlocks.AVOCADO_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.AVOCADO_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.BANANA_TABLE.get(), tableModel(TechnologicaBlocks.BANANA_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BANANA_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.BIRCH_TABLE.get(), tableModel(TechnologicaBlocks.BIRCH_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BIRCH_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.CHERRY_TABLE.get(), tableModel(TechnologicaBlocks.CHERRY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHERRY_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.CHESTNUT_TABLE.get(), tableModel(TechnologicaBlocks.CHESTNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CHESTNUT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.CINNAMON_TABLE.get(), tableModel(TechnologicaBlocks.CINNAMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CINNAMON_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.COCONUT_TABLE.get(), tableModel(TechnologicaBlocks.COCONUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.COCONUT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.CRIMSON_TABLE.get(), tableModel(TechnologicaBlocks.CRIMSON_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CRIMSON_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.DARK_OAK_TABLE.get(), tableModel(TechnologicaBlocks.DARK_OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.DARK_OAK_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.EBONY_TABLE.get(), tableModel(TechnologicaBlocks.EBONY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.EBONY_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.JUNGLE_TABLE.get(), tableModel(TechnologicaBlocks.JUNGLE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.JUNGLE_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.KIWI_TABLE.get(), tableModel(TechnologicaBlocks.KIWI_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.KIWI_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.LEMON_TABLE.get(), tableModel(TechnologicaBlocks.LEMON_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LEMON_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.LIME_TABLE.get(), tableModel(TechnologicaBlocks.LIME_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.LIME_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAHOGANY_TABLE.get(), tableModel(TechnologicaBlocks.MAHOGANY_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAHOGANY_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.MAPLE_TABLE.get(), tableModel(TechnologicaBlocks.MAPLE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MAPLE_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.OAK_TABLE.get(), tableModel(TechnologicaBlocks.OAK_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OAK_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.OLIVE_TABLE.get(), tableModel(TechnologicaBlocks.OLIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.OLIVE_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.ORANGE_TABLE.get(), tableModel(TechnologicaBlocks.ORANGE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ORANGE_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEACH_TABLE.get(), tableModel(TechnologicaBlocks.PEACH_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEACH_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.PEAR_TABLE.get(), tableModel(TechnologicaBlocks.PEAR_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PEAR_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.PLUM_TABLE.get(), tableModel(TechnologicaBlocks.PLUM_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.PLUM_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.REDWOOD_TABLE.get(), tableModel(TechnologicaBlocks.REDWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.REDWOOD_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.ROSEWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ROSEWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ROSEWOOD_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.RUBBER_TABLE.get(), tableModel(TechnologicaBlocks.RUBBER_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.RUBBER_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.SPRUCE_TABLE.get(), tableModel(TechnologicaBlocks.SPRUCE_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.SPRUCE_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.TEAK_TABLE.get(), tableModel(TechnologicaBlocks.TEAK_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.TEAK_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.WALNUT_TABLE.get(), tableModel(TechnologicaBlocks.WALNUT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WALNUT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.WARPED_TABLE.get(), tableModel(TechnologicaBlocks.WARPED_TABLE.get(), mcLoc(ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.WARPED_TABLE.get()).getPath(), "table", "planks"))));
		simpleBlockItem(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), tableModel(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ZEBRAWOOD_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.FRUITFUL_TABLE.get(), tableModel(TechnologicaBlocks.FRUITFUL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FRUITFUL_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), tableModel(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.FROSTBITTEN_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), tableModel(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.CONDUCTIVE_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), tableModel(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.ALCHEMICAL_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.BENEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.BENEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.BENEVOLENT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.MALEVOLENT_TABLE.get(), tableModel(TechnologicaBlocks.MALEVOLENT_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.MALEVOLENT_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.INFERNAL_TABLE.get(), tableModel(TechnologicaBlocks.INFERNAL_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.INFERNAL_TABLE.get()), "table", "planks")));
		simpleBlockItem(TechnologicaBlocks.NECROTIC_TABLE.get(), tableModel(TechnologicaBlocks.NECROTIC_TABLE.get(), ResourceLocationHelper.replace(blockTexture(TechnologicaBlocks.NECROTIC_TABLE.get()), "table", "planks")));

		simpleBlockItem(TechnologicaBlocks.DISPLAY_CASE.get(), displayModel(TechnologicaBlocks.DISPLAY_CASE.get()));
		simpleBlockItem(TechnologicaBlocks.NITROGLYCERIN.get(), models().cubeBottomTop(ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_side"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_bottom"), modLoc("block/" + ResourceLocationHelper.getPath(TechnologicaBlocks.NITROGLYCERIN.get()) + "_top")));

	}

	private void cropBlocks() {
		grainCropBlock(TechnologicaBlocks.BARLEY.get());
		grainCropBlock(TechnologicaBlocks.OATS.get());
		grainCropBlock(TechnologicaBlocks.RYE.get());

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

		grainCropBlock(TechnologicaBlocks.COTTON_CROP.get());
		grainCropBlock(TechnologicaBlocks.GRAPE_CROP.get());
		grainCropBlock(TechnologicaBlocks.TOMATO_CROP.get());

		tallCropBlock(TechnologicaBlocks.CORN.get());
		tallCropBlock(TechnologicaBlocks.PEPPERCORNS.get());
		tallCropBlock(TechnologicaBlocks.CRANBERRY_CROP.get());
		tallCropBlock(TechnologicaBlocks.RICE.get());

		stemCropBlock(TechnologicaBlocks.CUCUMBER_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get()), blockTexture(TechnologicaBlocks.CUCUMBER_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get())));
		fourDirectionBlockState(TechnologicaBlocks.CUCUMBERS.get(), gourdCropModel(TechnologicaBlocks.CUCUMBERS.get()));
		stemCropBlock(TechnologicaBlocks.SQUASH_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get()), blockTexture(TechnologicaBlocks.SQUASH_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get())));
		fourDirectionBlockState(TechnologicaBlocks.SQUASH.get(), gourdCropModel(TechnologicaBlocks.SQUASH.get()));
		stemCropBlock(TechnologicaBlocks.ZUCCHINI_STEM.get());
		attachedStemCropBlock(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get(), attachedStem(ResourceLocationHelper.getPath(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get()), blockTexture(TechnologicaBlocks.ZUCCHINI_STEM.get()), blockTexture(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get())));
		fourDirectionBlockState(TechnologicaBlocks.ZUCCHINI.get(), gourdCropModel(TechnologicaBlocks.ZUCCHINI.get()));
	}

	public void pottedSaplingBlocks() {
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
	}

	public void saplingBlocks() {
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
	}

	/*
	 * ModelFiles
	 */

	public ModelFile stem(String name, ResourceLocation stem, int growth) {
		return models().withExistingParent(name, mcLoc("stem_growth" + growth)).texture("stem", stem);
	}

	public ModelFile attachedStem(String name, ResourceLocation stem, ResourceLocation upperStem) {
		return models().withExistingParent(name, modLoc("stem_gourd")).texture("stem", stem).texture("upperstem", upperStem);
	}

	public ModelFile gourdCropModel(Block block) {
		return models().withExistingParent(ResourceLocationHelper.getPath(block), modLoc("gourd")).texture("gourd", blockTexture(block));
	}

	public ModelFile chairModel(Block block, ResourceLocation texture) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("chair"), "planks", texture);
	}

	public ModelFile tableModel(Block block, ResourceLocation texture) {
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("table"), "planks", texture);
	}

	public ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().singleTexture(ResourceLocationHelper.getPath(block), modLoc("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
	}

	public ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
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
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().getBuilder(location.getPath()).texture("particle", ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(block), "_wall", ""), "_sign", "_planks"));
	}

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return models().withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
	}

	public ModelFile fluid(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return models().getBuilder(location.getPath()).texture("particle", "minecraft:block/water_still");
	}

	/*
	 * Blockstate, block model, and item model providers
	 */

	public void pressurePlateBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(blockModel1).addModel().partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(blockModel2).addModel();
		this.simpleBlockItem(block, blockModel1);
	}

	public void fourDirectionBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
		this.simpleBlockItem(block, blockModel);
	}

	public void twelveDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Y).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(BlockStateProperties.AXIS, Direction.Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
		this.simpleBlockItem(block, blockModel1);
	}

	public void twentyFourDirectionBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(270).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel2).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel2).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationY(90).rotationX(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.UP).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.NORTH).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.EAST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(270).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.SOUTH).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.WEST).modelForState().modelFile(blockModel1).rotationX(180).rotationY(90).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.UP).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).with(TechnologicaBlockStateProperties.SUB_FACING, Direction.DOWN).modelForState().modelFile(blockModel1).rotationX(180).rotationY(180).addModel();
		this.simpleBlockItem(block, blockModel1);
	}

	public void lineShaftBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3, ModelFile blockModel4) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.NONE).modelForState().modelFile(blockModel1).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.SMALL).modelForState().modelFile(blockModel2).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.MEDIUM).modelForState().modelFile(blockModel3).rotationX(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.X).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).rotationY(90).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).addModel().partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z).with(TechnologicaBlockStateProperties.RADIUS, Radius.LARGE).modelForState().modelFile(blockModel4).rotationX(90).addModel();
		this.simpleBlockItem(block, blockModel1);
	}

	public void buttonBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile itemModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.ATTACH_FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).uvLock(true).addModel();
		this.simpleBlockItem(block, itemModel);
	}

	public void signBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(sign(block)));
		this.signItem(block, new ModelFile.UncheckedModelFile("item/generated"));
	}

	public void grainCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel().partialState().with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel().partialState().with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel().partialState().with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage4", ResourceLocationHelper.extend(blockTexture(block), "_stage4"))).addModel().partialState().with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage5", ResourceLocationHelper.extend(blockTexture(block), "_stage5"))).addModel().partialState().with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage6", ResourceLocationHelper.extend(blockTexture(block), "_stage6"))).addModel().partialState().with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage7", ResourceLocationHelper.extend(blockTexture(block), "_stage7"))).addModel();
	}

	public void replantableCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(PotatoBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel().partialState().with(PotatoBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel().partialState().with(PotatoBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel().partialState().with(PotatoBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel().partialState().with(PotatoBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(PotatoBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(PotatoBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(PotatoBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel();
	}

	public void seededCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(BeetrootBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel().partialState().with(BeetrootBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel().partialState().with(BeetrootBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(BeetrootBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel();
	}

	public void berryBushBlock(Block block) {
		getVariantBuilder(block).partialState().with(SweetBerryBushBlock.AGE, 0).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel().partialState().with(SweetBerryBushBlock.AGE, 1).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel().partialState().with(SweetBerryBushBlock.AGE, 2).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel().partialState().with(SweetBerryBushBlock.AGE, 3).modelForState().modelFile(models().cross(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel();
	}

	public void tallCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage0", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage0"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage1", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage1"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage2", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage2"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage3", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage3"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage4", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage4"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage5", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage5"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage6", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage6"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_bottom_stage7", ResourceLocationHelper.extend(blockTexture(block), "_bottom_stage7"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage0", ResourceLocationHelper.extend(blockTexture(block), "_top_stage0"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage1", ResourceLocationHelper.extend(blockTexture(block), "_top_stage1"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage2", ResourceLocationHelper.extend(blockTexture(block), "_top_stage2"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage3", ResourceLocationHelper.extend(blockTexture(block), "_top_stage3"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage4", ResourceLocationHelper.extend(blockTexture(block), "_top_stage4"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage5", ResourceLocationHelper.extend(blockTexture(block), "_top_stage5"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage6", ResourceLocationHelper.extend(blockTexture(block), "_top_stage6"))).addModel().partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_top_stage7", ResourceLocationHelper.extend(blockTexture(block), "_top_stage7"))).addModel();
	}

	public void stemCropBlock(Block block) {
		getVariantBuilder(block).partialState().with(StemBlock.AGE, 0).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage0", blockTexture(block), 0)).addModel().partialState().with(StemBlock.AGE, 1).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage1", blockTexture(block), 1)).addModel().partialState().with(StemBlock.AGE, 2).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage2", blockTexture(block), 2)).addModel().partialState().with(StemBlock.AGE, 3).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage3", blockTexture(block), 3)).addModel().partialState().with(StemBlock.AGE, 4).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage4", blockTexture(block), 4)).addModel().partialState().with(StemBlock.AGE, 5).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage5", blockTexture(block), 5)).addModel().partialState().with(StemBlock.AGE, 6).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage6", blockTexture(block), 6)).addModel().partialState().with(StemBlock.AGE, 7).modelForState().modelFile(this.stem(ResourceLocationHelper.getPath(block) + "_stage7", blockTexture(block), 7)).addModel();
	}

	public void attachedStemCropBlock(Block block, ModelFile blockModel) {
		getVariantBuilder(block).partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(180).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).rotationY(90).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(270).addModel().partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).addModel();
	}

	public void annunciatorBlockState(Block block) {
		ResourceLocation sides = new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_side");
		getVariantBuilder(block)
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(90)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(180)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_info"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fail"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_pass"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, false)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_warn"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_fail"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_pass"), sides))
				.rotationY(270)
				.addModel()
				.partialState()
				.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.with(BlockStateProperties.LIT, true)
				.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN)
				.modelForState()
				.modelFile(models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn", sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_warn"), sides))
				.rotationY(270)
				.addModel();
		this.simpleBlockItem(block, models().orientable(ForgeRegistries.BLOCKS.getKey(block).getPath(), sides, new ResourceLocation(Technologica.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_lit_info"), sides));
	}

	/*
	 * Item model providers
	 */

	public void doorBlockItem(Block block, ModelFile model) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath()));
	}

	public void signItem(Block block, ModelFile model) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocationHelper.replace(ResourceLocationHelper.replace(blockTexture(block), "_wall", ""), "block", "item"));
	}
}
