package com.technologica.data;

import java.util.function.Supplier;

import com.technologica.MainMod;
import com.technologica.block.ModCropsBlock;
import com.technologica.block.ModCrystalBlock;
import com.technologica.setup.Registration;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, MainMod.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(Registration.LITHIUM_CLAY);
		simpleBlock(Registration.SALT);
		simpleBlock(Registration.BAUXITE_ORE);
		simpleBlock(Registration.BORAX_ORE);
		simpleBlock(Registration.MAGNESITE_ORE);
		simpleBlock(Registration.SPODUMENE_ORE);
		simpleBlock(Registration.BANANA_LEAVES);
		simpleBlock(Registration.CHERRY_LEAVES);
		simpleBlock(Registration.COCONUT_LEAVES);
		simpleBlock(Registration.KIWI_LEAVES);
		simpleBlock(Registration.LEMON_LEAVES);
		simpleBlock(Registration.LIME_LEAVES);
		simpleBlock(Registration.ORANGE_LEAVES);
		simpleBlock(Registration.PEACH_LEAVES);
		simpleBlock(Registration.PEAR_LEAVES);
		simpleBlock(Registration.FRUITFUL_LEAVES);
		simpleBlock(Registration.BENEVOLENT_LEAVES);
		
		logBlock(Registration.BANANA_LOG);
		logBlock(Registration.CHERRY_LOG);
		logBlock(Registration.COCONUT_LOG);
		logBlock(Registration.KIWI_LOG);
		logBlock(Registration.LEMON_LOG);
		logBlock(Registration.LIME_LOG);
		logBlock(Registration.ORANGE_LOG);
		logBlock(Registration.PEACH_LOG);
		logBlock(Registration.PEAR_LOG);
		logBlock(Registration.FRUITFUL_LOG);
		logBlock(Registration.BENEVOLENT_LOG);
		
		crossBlock(Registration.BANANA_SAPLING);
		crossBlock(Registration.CHERRY_SAPLING);
		crossBlock(Registration.COCONUT_SAPLING);
		crossBlock(Registration.KIWI_SAPLING);
		crossBlock(Registration.LEMON_SAPLING);
		crossBlock(Registration.LIME_SAPLING);
		crossBlock(Registration.ORANGE_SAPLING);
		crossBlock(Registration.PEACH_SAPLING);
		crossBlock(Registration.PEAR_SAPLING);
		crossBlock(Registration.ANCIENT_AMBROSIA_SAPLING);
		crossBlock(Registration.BENEVOLENT_APOTHECARY_SAPLING);	
		
		cropBlock(Registration.BLUEBERRY_CROP);
		cropBlock(Registration.GRAPE_CROP);
		cropBlock(Registration.STRAWBERRY_CROP);
		
		crystalBlock(Registration.AQUAMARINE_CRYSTAL);
		crystalBlock(Registration.DOLOMITE_CRYSTAL);
		crystalBlock(Registration.FLUORITE_CRYSTAL);
		crystalBlock(Registration.ULEXITE_CRYSTAL);
		
		displayBlock(Registration.DISPLAY_CASE);
	}	
	
	private String name(Block block) {
        return block.getRegistryName().getPath();
    }
	
	private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
	
	public ModelFile cross(Block block) {
        return models().cross(name(block), blockTexture(block));
    }
	
	public ModelFile crop(Block block, String stage) {
        return models().crop(name(block) + stage, extend(blockTexture(block), stage));
    }
	
	public ModelFile crystal(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(name(block), modLoc("crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block" + "/" + location.getPath()));
    }
	
	public ModelFile display(Block block) {
		return models().withExistingParent(name(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	public ModelFile cubeColumn(Block block) {
        return models().cubeColumn(name(block), blockTexture(block), extend(blockTexture(block), "_top"));
    }
	
	public void simpleBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(cubeAll(block)));
		this.simpleBlockItem(block, cubeAll(block));											
    }
	
	public void logBlock(Supplier<? extends Block> blockSupplier) {					
		RotatedPillarBlock block = (RotatedPillarBlock) blockSupplier.get();		
		axisBlock(block, blockTexture(block), extend(blockTexture(block), "_top"));	
        this.simpleBlockItem(block, cubeColumn(block));								
    }
	
	public void crossBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(cross(block)));
        this.crossBlockItem(block, new ModelFile.UncheckedModelFile("item/generated"));
	}
	
	public void cropBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block)
			.partialState().with(ModCropsBlock.AGE, 0).modelForState().modelFile(crop(block, "_stage0")).addModel()
			.partialState().with(ModCropsBlock.AGE, 1).modelForState().modelFile(crop(block, "_stage0")).addModel()
			.partialState().with(ModCropsBlock.AGE, 2).modelForState().modelFile(crop(block, "_stage1")).addModel()
			.partialState().with(ModCropsBlock.AGE, 3).modelForState().modelFile(crop(block, "_stage1")).addModel()
			.partialState().with(ModCropsBlock.AGE, 4).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(ModCropsBlock.AGE, 5).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(ModCropsBlock.AGE, 6).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(ModCropsBlock.AGE, 7).modelForState().modelFile(crop(block, "_stage3")).addModel();
	}
	
	public void crystalBlock(Supplier<? extends Block> blockSupplier) {
		Block block = blockSupplier.get();	
		getVariantBuilder(block)
			.partialState().with(ModCrystalBlock.FACING, Direction.NORTH).modelForState().modelFile(crystal(block)).rotationX(90).addModel()
			.partialState().with(ModCrystalBlock.FACING, Direction.EAST).modelForState().modelFile(crystal(block)).rotationX(90).rotationY(90).addModel()
			.partialState().with(ModCrystalBlock.FACING, Direction.SOUTH).modelForState().modelFile(crystal(block)).rotationX(270).addModel()
			.partialState().with(ModCrystalBlock.FACING, Direction.WEST).modelForState().modelFile(crystal(block)).rotationX(90).rotationY(270).addModel()
			.partialState().with(ModCrystalBlock.FACING, Direction.UP).modelForState().modelFile(crystal(block)).addModel()
			.partialState().with(ModCrystalBlock.FACING, Direction.DOWN).modelForState().modelFile(crystal(block)).rotationX(180).addModel();
		this.simpleBlockItem(block, crystal(block));
    }
	
	public void displayBlock(Supplier<? extends Block> blockSupplier) {
		Block block = blockSupplier.get();	
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(display(block)));
		this.simpleBlockItem(block, display(block));
    }
	
	public void crossBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "block" + "/" + location.getPath()));
    }
	
	public void crystalBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "block" + "/" + location.getPath()));
    }
}