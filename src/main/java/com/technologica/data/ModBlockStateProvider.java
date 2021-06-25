package com.technologica.data;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.ModBlocks;
import com.technologica.block.CrystalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public static final String CRYSTAL_TEXTURE_KEY = "crystal";
	public static final String BLOCK = "block";

	public ModBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(ModBlocks.LITHIUM_CLAY);
		simpleBlock(ModBlocks.SALT);
		simpleBlock(ModBlocks.BAUXITE_ORE);
		simpleBlock(ModBlocks.CHROMITE_ORE);
		simpleBlock(ModBlocks.ILMENITE_ORE);
		simpleBlock(ModBlocks.PYROLUSITE_ORE);
		simpleBlock(ModBlocks.COBALTITE_ORE);
		simpleBlock(ModBlocks.GARNIERITE_ORE);
		simpleBlock(ModBlocks.BORAX_ORE);
		simpleBlock(ModBlocks.MAGNESITE_ORE);
		simpleBlock(ModBlocks.SPODUMENE_ORE);
		simpleBlock(ModBlocks.BANANA_LEAVES);
		simpleBlock(ModBlocks.CHERRY_LEAVES);
		simpleBlock(ModBlocks.COCONUT_LEAVES);
		simpleBlock(ModBlocks.KIWI_LEAVES);
		simpleBlock(ModBlocks.LEMON_LEAVES);
		simpleBlock(ModBlocks.LIME_LEAVES);
		simpleBlock(ModBlocks.ORANGE_LEAVES);
		simpleBlock(ModBlocks.PEACH_LEAVES);
		simpleBlock(ModBlocks.PEAR_LEAVES);
		simpleBlock(ModBlocks.FRUITFUL_LEAVES);
		simpleBlock(ModBlocks.BENEVOLENT_LEAVES);
		
		logBlock(ModBlocks.BANANA_LOG);
		logBlock(ModBlocks.CHERRY_LOG);
		logBlock(ModBlocks.COCONUT_LOG);
		logBlock(ModBlocks.KIWI_LOG);
		logBlock(ModBlocks.LEMON_LOG);
		logBlock(ModBlocks.LIME_LOG);
		logBlock(ModBlocks.ORANGE_LOG);
		logBlock(ModBlocks.PEACH_LOG);
		logBlock(ModBlocks.PEAR_LOG);
		logBlock(ModBlocks.FRUITFUL_LOG);
		logBlock(ModBlocks.BENEVOLENT_LOG);
		
		columnBlock(ModBlocks.BANANA_BOOKSHELF);
		columnBlock(ModBlocks.CHERRY_BOOKSHELF);
		columnBlock(ModBlocks.COCONUT_BOOKSHELF);
		columnBlock(ModBlocks.KIWI_BOOKSHELF);
		columnBlock(ModBlocks.LEMON_BOOKSHELF);
		columnBlock(ModBlocks.LIME_BOOKSHELF);
		columnBlock(ModBlocks.ORANGE_BOOKSHELF);
		columnBlock(ModBlocks.PEACH_BOOKSHELF);
		columnBlock(ModBlocks.PEAR_BOOKSHELF);
		
		simpleBlock(ModBlocks.BANANA_PLANKS);
		simpleBlock(ModBlocks.CHERRY_PLANKS);
		simpleBlock(ModBlocks.COCONUT_PLANKS);
		simpleBlock(ModBlocks.KIWI_PLANKS);
		simpleBlock(ModBlocks.LEMON_PLANKS);
		simpleBlock(ModBlocks.LIME_PLANKS);
		simpleBlock(ModBlocks.ORANGE_PLANKS);
		simpleBlock(ModBlocks.PEACH_PLANKS);
		simpleBlock(ModBlocks.PEAR_PLANKS);
		
		slabBlock(ModBlocks.BANANA_SLAB, new ResourceLocation("technologica:block/banana_planks"));
		slabBlock(ModBlocks.CHERRY_SLAB, new ResourceLocation("technologica:block/cherry_planks"));
		slabBlock(ModBlocks.COCONUT_SLAB, new ResourceLocation("technologica:block/coconut_planks"));
		slabBlock(ModBlocks.KIWI_SLAB, new ResourceLocation("technologica:block/kiwi_planks"));
		slabBlock(ModBlocks.LEMON_SLAB, new ResourceLocation("technologica:block/lemon_planks"));
		slabBlock(ModBlocks.LIME_SLAB, new ResourceLocation("technologica:block/lime_planks"));
		slabBlock(ModBlocks.ORANGE_SLAB, new ResourceLocation("technologica:block/orange_planks"));
		slabBlock(ModBlocks.PEACH_SLAB, new ResourceLocation("technologica:block/peach_planks"));
		slabBlock(ModBlocks.PEAR_SLAB, new ResourceLocation("technologica:block/pear_planks"));
		
		trapdoorBlock(ModBlocks.BANANA_TRAPDOOR, new ResourceLocation("technologica:block/banana_trapdoor"), true);
		trapdoorBlock(ModBlocks.CHERRY_TRAPDOOR, new ResourceLocation("technologica:block/cherry_trapdoor"), true);
		trapdoorBlock(ModBlocks.COCONUT_TRAPDOOR, new ResourceLocation("technologica:block/coconut_trapdoor"), true);
		trapdoorBlock(ModBlocks.KIWI_TRAPDOOR, new ResourceLocation("technologica:block/kiwi_trapdoor"), true);
		trapdoorBlock(ModBlocks.LEMON_TRAPDOOR, new ResourceLocation("technologica:block/lemon_trapdoor"), true);
		trapdoorBlock(ModBlocks.LIME_TRAPDOOR, new ResourceLocation("technologica:block/lime_trapdoor"), true);
		trapdoorBlock(ModBlocks.ORANGE_TRAPDOOR, new ResourceLocation("technologica:block/orange_trapdoor"), true);
		trapdoorBlock(ModBlocks.PEACH_TRAPDOOR, new ResourceLocation("technologica:block/peach_trapdoor"), true);
		trapdoorBlock(ModBlocks.PEAR_TRAPDOOR, new ResourceLocation("technologica:block/pear_trapdoor"), true);
		
		crossBlock(ModBlocks.BANANA_SAPLING);
		crossBlock(ModBlocks.CHERRY_SAPLING);
		crossBlock(ModBlocks.COCONUT_SAPLING);
		crossBlock(ModBlocks.KIWI_SAPLING);
		crossBlock(ModBlocks.LEMON_SAPLING);
		crossBlock(ModBlocks.LIME_SAPLING);
		crossBlock(ModBlocks.ORANGE_SAPLING);
		crossBlock(ModBlocks.PEACH_SAPLING);
		crossBlock(ModBlocks.PEAR_SAPLING);
		crossBlock(ModBlocks.ANCIENT_AMBROSIA_SAPLING);
		crossBlock(ModBlocks.BENEVOLENT_APOTHECARY_SAPLING);
		
		flowerPotCrossBlock(ModBlocks.POTTED_BANANA_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_CHERRY_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_COCONUT_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_KIWI_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_LEMON_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_LIME_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_ORANGE_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_PEACH_SAPLING);
		flowerPotCrossBlock(ModBlocks.POTTED_PEAR_SAPLING);
		
		cropBlock(ModBlocks.BLUEBERRY_CROP);
		cropBlock(ModBlocks.GRAPE_CROP);
		cropBlock(ModBlocks.STRAWBERRY_CROP);
		
		hexagonalCrystalBlock(ModBlocks.AQUAMARINE_CRYSTAL);
		hexagonalCrystalBlock(ModBlocks.FLUORITE_CRYSTAL);
		hexagonalCrystalBlock(ModBlocks.ULEXITE_CRYSTAL);
		
		cubicCrystalBlock(ModBlocks.DOLOMITE_CRYSTAL);
		
		displayBlock(ModBlocks.DISPLAY_CASE);
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
	
	public ModelFile flowerPotCross(Block block) {
		ResourceLocation location = block.getRegistryName();
		String flowerPath = null;
		if (location != null) {
			flowerPath = location.getPath().replaceAll("potted_", "");
		}
		return models().singleTexture(name(block), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + flowerPath));
    }
	
	public ModelFile crop(Block block, String stage) {
        return models().crop(name(block) + stage, extend(blockTexture(block), stage));
    }
	
	public ModelFile hexagonal_crystal(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(name(block), modLoc("hexagonal_crystal"), CRYSTAL_TEXTURE_KEY, blockTexture(block)).texture(CRYSTAL_TEXTURE_KEY, new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
	
	public ModelFile cubic_crystal(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(name(block), modLoc("cubic_crystal"), CRYSTAL_TEXTURE_KEY, blockTexture(block)).texture(CRYSTAL_TEXTURE_KEY, new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
	
	public ModelFile display(Block block) {
		return models().withExistingParent(name(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	public ModelFile slab(Block block) {
        return models().slab(name(block), blockTexture(block), blockTexture(block), blockTexture(block));
    }
	
	public ModelFile cubeColumn(Block block) {
        return models().cubeColumn(name(block), blockTexture(block), extend(blockTexture(block), "_top"));
    }
	
	public void simpleBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(cubeAll(block)));
		this.simpleBlockItem(block, cubeAll(block));											
    }
	
	public void columnBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(cubeColumn(block)));
		this.simpleBlockItem(block, cubeColumn(block));											
    }
	
    public void slabBlock(Supplier<? extends Block> blockSupplier, ResourceLocation doubleslab) {
    	SlabBlock block = (SlabBlock) blockSupplier.get();
        getVariantBuilder(block).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(models().slab(name(block), blockTexture(block), blockTexture(block), blockTexture(block)))).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(models().slabTop(name(block) + "_top", blockTexture(block), blockTexture(block), blockTexture(block)))).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(models().getExistingFile(doubleslab)));
        this.simpleBlockItem(block, slab(block));
    }
	
    public void trapdoorBlock(Supplier<? extends Block> blockSupplier, ResourceLocation texture, boolean orientable) {
    	TrapDoorBlock block = (TrapDoorBlock) blockSupplier.get();
        trapdoorBlockInternal(block, block.getRegistryName().toString(), texture, orientable);
    }
    
    private void trapdoorBlockInternal(TrapDoorBlock block, String baseName, ResourceLocation texture, boolean orientable) {
        ModelFile bottom = orientable ? models().trapdoorOrientableBottom(baseName + "_bottom", texture) : models().trapdoorBottom(baseName + "_bottom", texture);
        ModelFile top = orientable ? models().trapdoorOrientableTop(baseName + "_top", texture) : models().trapdoorTop(baseName + "_top", texture);
        ModelFile open = orientable ? models().trapdoorOrientableOpen(baseName + "_open", texture) : models().trapdoorOpen(baseName + "_open", texture);
        trapdoorBlock(block, bottom, top, open, orientable);
    }

    public void trapdoorBlock(TrapDoorBlock block, ModelFile bottom, ModelFile top, ModelFile open, boolean orientable) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int xRot = 0;
            int yRot = ((int) state.get(TrapDoorBlock.HORIZONTAL_FACING).getHorizontalAngle()) + 180;
            boolean isOpen = state.get(TrapDoorBlock.OPEN);
            if (orientable && isOpen && state.get(TrapDoorBlock.HALF) == Half.TOP) {
                xRot += 180;
                yRot += 180;
            }
            if (!orientable && !isOpen) {
                yRot = 0;
            }
            yRot %= 360;
            return ConfiguredModel.builder().modelFile(isOpen ? open : state.get(TrapDoorBlock.HALF) == Half.TOP ? top : bottom)
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        }, TrapDoorBlock.POWERED, TrapDoorBlock.WATERLOGGED);
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
	
	public void flowerPotCrossBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(flowerPotCross(block)));
	}
	
	public void cropBlock(Supplier<? extends Block> blockSupplier) {							
		Block block = blockSupplier.get();														
		getVariantBuilder(block)
			.partialState().with(CropsBlock.AGE, 0).modelForState().modelFile(crop(block, "_stage0")).addModel()
			.partialState().with(CropsBlock.AGE, 1).modelForState().modelFile(crop(block, "_stage0")).addModel()
			.partialState().with(CropsBlock.AGE, 2).modelForState().modelFile(crop(block, "_stage1")).addModel()
			.partialState().with(CropsBlock.AGE, 3).modelForState().modelFile(crop(block, "_stage1")).addModel()
			.partialState().with(CropsBlock.AGE, 4).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(CropsBlock.AGE, 5).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(CropsBlock.AGE, 6).modelForState().modelFile(crop(block, "_stage2")).addModel()
			.partialState().with(CropsBlock.AGE, 7).modelForState().modelFile(crop(block, "_stage3")).addModel();
	}
	
	public void hexagonalCrystalBlock(Supplier<? extends Block> blockSupplier) {
		Block block = blockSupplier.get();	
		getVariantBuilder(block)
			.partialState().with(CrystalBlock.FACING, Direction.NORTH).modelForState().modelFile(hexagonal_crystal(block)).rotationX(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.EAST).modelForState().modelFile(hexagonal_crystal(block)).rotationX(90).rotationY(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.SOUTH).modelForState().modelFile(hexagonal_crystal(block)).rotationX(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.WEST).modelForState().modelFile(hexagonal_crystal(block)).rotationX(90).rotationY(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.UP).modelForState().modelFile(hexagonal_crystal(block)).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.DOWN).modelForState().modelFile(hexagonal_crystal(block)).rotationX(180).addModel();
		this.simpleBlockItem(block, hexagonal_crystal(block));
    }
	
	public void cubicCrystalBlock(Supplier<? extends Block> blockSupplier) {
		Block block = blockSupplier.get();	
		getVariantBuilder(block)
			.partialState().with(CrystalBlock.FACING, Direction.NORTH).modelForState().modelFile(cubic_crystal(block)).rotationX(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.EAST).modelForState().modelFile(cubic_crystal(block)).rotationX(90).rotationY(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.SOUTH).modelForState().modelFile(cubic_crystal(block)).rotationX(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.WEST).modelForState().modelFile(cubic_crystal(block)).rotationX(90).rotationY(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.UP).modelForState().modelFile(cubic_crystal(block)).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.DOWN).modelForState().modelFile(cubic_crystal(block)).rotationX(180).addModel();
		this.simpleBlockItem(block, cubic_crystal(block));
    }
	
	public void displayBlock(Supplier<? extends Block> blockSupplier) {
		Block block = blockSupplier.get();	
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(display(block)));
		this.simpleBlockItem(block, display(block));
    }
	
	public void crossBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
	
	public void crystalBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
}
