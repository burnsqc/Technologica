package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.CrystalBlock;
import com.technologica.block.ModBlocks;
import com.technologica.block.ModCropsBlock;
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TwentyFourDirectionBlock;
import com.technologica.block.WaterCropsBlock;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

	public static final String CRYSTAL_TEXTURE_KEY = "crystal";
	public static final String BLOCK = "block";

	public ModBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		automaticBlockState(ModBlocks.BLOCKS.getEntries());
	}	
	
	/**
	 * Iterates through a deferred register of blocks, generating blockstates, block models, and item models for each entry.
	 * This only works if the translation keys are consistent.  This is really only intended to work for mod blocks which are similar to vanilla.
	 * This saves a lot of time when adding one new tree which leads to logs, leaves, planks, stairs, doors, etc. 
	 * @param collection a collection of deferred register block entries
	 */
	
	private final void automaticBlockState(Collection<RegistryObject<Block>> collection) {
		for(Supplier<? extends Block> blockSupplier:collection) {
			Block block = blockSupplier.get();
				
			if (block.getRegistryName().getPath().contains("leaves")) simpleBlock(block);
			else if (block.getRegistryName().getPath().contains("planks")) simpleBlock(block);
			else if (block.getRegistryName().getPath().contains("salt")) simpleBlock(block);
			else if (block.getRegistryName().getPath().contains("clay")) simpleBlock(block);
			else if (block.getRegistryName().getPath().contains("ore")) simpleBlock(block);
			else if (block.getRegistryName().getPath().contains("bookshelf")) bookshelfBlock(block);	
			else if (block.getRegistryName().getPath().contains("log")) logBlock(block);
			else if (block.getRegistryName().getPath().contains("_wood")) woodBlock(block);
			else if (block.getRegistryName().getPath().contains("slab")) slabBlock(block);
			else if (block.getRegistryName().getPath().contains("stairs")) stairsBlock(block);
			else if (block.getRegistryName().getPath().contains("fence") && !block.getRegistryName().getPath().contains("gate")) fenceBlock(block);
			else if (block.getRegistryName().getPath().contains("fence_gate")) fenceGateBlock(block);
			else if (block.getRegistryName().getPath().contains("pressure_plate")) pressurePlateBlock(block);
			else if (block.getRegistryName().getPath().contains("button")) buttonBlock(block);
			else if (block.getRegistryName().getPath().contains("sign")) signBlock(block);
			else if (block.getRegistryName().getPath().contains("sapling") && !block.getRegistryName().getPath().contains("potted")) crossBlock(block);
			else if (block.getRegistryName().getPath().contains("potted")) flowerPotCrossBlock(block);
			else if (block.getClass().equals(ModCropsBlock.class)) cropBlock(block);
			else if (block.getClass().equals(TallCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) tallCropBlock(block);
			else if (block.getRegistryName().getPath().contains("door") && !block.getRegistryName().getPath().contains("trap")) doorBlock(block);
			else if (block.getRegistryName().getPath().contains("trapdoor")) trapdoorBlock(block);
			else if (block.getRegistryName().getPath().contains("crystal") && !block.getRegistryName().getPath().contains("dolomite")) hexagonalCrystalBlock(block);
			else if (block.getRegistryName().getPath().contains("dolomite")) cubicCrystalBlock(block);
			else if (block.getRegistryName().getPath().contains("display")) displayBlock(block);
			else if (block instanceof TwentyFourDirectionBlock) twentyFourDirectionBlock(block);
		}
	}
	
	private String name(Block block) {
        return block.getRegistryName().getPath();
    }
	
	private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
	
	private ResourceLocation replace(ResourceLocation rl, String regex, String replacement) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath().replaceAll(regex, replacement));
    }
	
	/*
	 * ModelFiles
	 */
	public ModelFile cubeColumn(Block block) {
		if (block.getRegistryName().getPath().contains("bookshelf")) {
			ResourceLocation end = blockTexture(block);
			if (block.getTranslationKey().contains("spruce") || block.getTranslationKey().contains("birch") || block.getTranslationKey().contains("jungle") || block.getTranslationKey().contains("acacia") || block.getTranslationKey().contains("dark_oak") || block.getTranslationKey().contains("crimson") || block.getTranslationKey().contains("warped")) {
				end = mcLoc(blockTexture(block).getPath());	
			}
			return models().cubeColumn(name(block), blockTexture(block), replace(end, "bookshelf", "planks"));
		} else if (block.getRegistryName().getPath().contains("_wood")) {
			return models().cubeColumn(name(block), replace(blockTexture(block), "_wood", "_log"), replace(blockTexture(block), "_wood", "_log"));
		} else {
			return models().cubeColumn(name(block), blockTexture(block), extend(blockTexture(block), "_top"));
		}
	}
	
	public ModelFile slab(Block block) {
		return models().slab(name(block), replace(blockTexture(block), "slab", "planks"), replace(blockTexture(block), "slab", "planks"), replace(blockTexture(block), "slab", "planks"));
	}
	
	public ModelFile stairs(Block block) {
		return models().stairs(name(block), replace(blockTexture(block), "stairs", "planks"), replace(blockTexture(block), "stairs", "planks"), replace(blockTexture(block), "stairs", "planks"));
	}
	
	public ModelFile fence(Block block) {
		return models().fenceInventory(name(block) + "_inventory", replace(blockTexture(block), "fence", "planks"));
	}
	
	public ModelFile fenceGate(Block block) {
		return models().fenceGate(name(block), replace(blockTexture(block), "fence_gate", "planks"));
	}
	
	public ModelFile trapdoor(Block block) {
		return models().trapdoorBottom(name(block), blockTexture(block));
	}
	
	public ModelFile hexagonalCrystal(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(name(block), modLoc("hexagonal_crystal"), CRYSTAL_TEXTURE_KEY, blockTexture(block)).texture(CRYSTAL_TEXTURE_KEY, new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
	
	public ModelFile cubicCrystal(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(name(block), modLoc("cubic_crystal"), CRYSTAL_TEXTURE_KEY, blockTexture(block)).texture(CRYSTAL_TEXTURE_KEY, new ResourceLocation(location.getNamespace(), BLOCK + "/" + location.getPath()));
    }
	
	public ModelFile motor(Block block) {
		return models().withExistingParent(name(block), modLoc("motor")).texture("motor", blockTexture(block));
    }
	
	public ModelFile motor2(Block block) {
		return models().withExistingParent(name(block) + "2", modLoc("motor2")).texture("motor", blockTexture(block));
    }
	
	public ModelFile display(Block block) {
		return models().withExistingParent(name(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	public ModelFile pressurePlate(Block block) {
        return models().withExistingParent(name(block), BLOCK + "/pressure_plate_up").texture("texture", replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile pressurePlateDown(Block block) {
        return models().withExistingParent(name(block) + "_down", BLOCK + "/pressure_plate_down").texture("texture", replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile button(Block block) {
        return models().withExistingParent(name(block), BLOCK + "/button").texture("texture", replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonPressed(Block block) {
        return models().withExistingParent(name(block) + "_pressed", BLOCK + "/button_pressed").texture("texture", replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonInventory(Block block) {
        return models().withExistingParent(name(block) + "_inventory", BLOCK + "/button_inventory").texture("texture", replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile sign(Block block) {
        ResourceLocation location = block.getRegistryName();
        return models().getBuilder(location.getPath()).texture("particle", replace(replace(blockTexture(block), "_wall", ""), "_sign", "_planks"));
    }

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return models().withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
    }
	
	/*
	 * Blockstate, block model, and item model providers
	 */
	
	public void simpleBlock(Block block) {
		simpleBlock(block, cubeAll(block));
		this.simpleBlockItem(block, cubeAll(block));		
    }
	
	public void logBlock(Block block) {
		logBlock((RotatedPillarBlock) block);
	    this.simpleBlockItem(block, cubeColumn(block));			
	}
	
	public void woodBlock(Block block) {
		axisBlock((RotatedPillarBlock) block, models().cubeColumn(name(block), replace(blockTexture(block), "_wood", "_log"), replace(blockTexture(block), "_wood", "_log")), models().cubeColumnHorizontal(name(block), replace(blockTexture(block), "_wood", "_log"), replace(blockTexture(block), "_wood", "_log")));
	    this.simpleBlockItem(block, cubeColumn(block));			
	}
	
	public void bookshelfBlock(Block block) {
		ResourceLocation end = blockTexture(block);
		if (block.getTranslationKey().contains("spruce") || block.getTranslationKey().contains("birch") || block.getTranslationKey().contains("jungle") || block.getTranslationKey().contains("acacia") || block.getTranslationKey().contains("dark_oak") || block.getTranslationKey().contains("crimson") || block.getTranslationKey().contains("warped")) {
			end = mcLoc(blockTexture(block).getPath());	
		}
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cubeColumn(name(block), blockTexture(block), replace(end, "bookshelf", "planks"))));
		this.simpleBlockItem(block, cubeColumn(block));		
    }
	
	public void slabBlock(Block block) {
		slabBlock((SlabBlock) block, replace(blockTexture(block), "slab", "planks"), replace(blockTexture(block), "slab", "planks"));
	    this.simpleBlockItem(block, slab(block));
    }
    
	public void stairsBlock(Block block) {
		stairsBlock((StairsBlock) block, replace(blockTexture(block), "stairs", "planks"));
	    this.simpleBlockItem(block, stairs(block));
    }
	
	public void fenceBlock(Block block) {
		fenceBlock((FenceBlock) block, replace(blockTexture(block), "fence", "planks"));
	    this.simpleBlockItem(block, fence(block));
    }
	
	public void fenceGateBlock(Block block) {
		fenceGateBlock((FenceGateBlock) block, replace(blockTexture(block), "fence_gate", "planks"));
	    this.simpleBlockItem(block, fenceGate(block));
    }
	
    public void doorBlock(Block block) {
    	doorBlock((DoorBlock) block, extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top"));
        this.doorBlockItem(block, new ModelFile.UncheckedModelFile("item/generated"));
    }
    	
    public void trapdoorBlock(Block block) {
    	trapdoorBlock((TrapDoorBlock) block, blockTexture(block), true);
    	this.simpleBlockItem(block, trapdoor(block));
    }
    
    public void pressurePlateBlock(Block block) {
    	getVariantBuilder(block)
    		.partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(pressurePlate(block)).addModel()
        	.partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(pressurePlateDown(block)).addModel();
    	this.simpleBlockItem(block, pressurePlate(block));
    }
    
    public void buttonBlock(Block block) {
    	getVariantBuilder(block)
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(270).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(270).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(180).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(180).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(90).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.CEILING).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(90).rotationX(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(90).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(90).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(180).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(270).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.FLOOR).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(270).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.EAST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.NORTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.SOUTH).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, false).modelForState().modelFile(button(block)).rotationY(270).rotationX(90).uvLock(true).addModel()
    		.partialState().with(WoodButtonBlock.FACE, AttachFace.WALL).with(WoodButtonBlock.HORIZONTAL_FACING, Direction.WEST).with(WoodButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed(block)).rotationY(270).rotationX(90).uvLock(true).addModel();
    	this.simpleBlockItem(block, buttonInventory(block));
    }
    
    public void signBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(sign(block)));
	    this.signItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
	}
    
	public void crossBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cross(name(block), blockTexture(block))));
	    this.crossBlockItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
	}
	
	public void flowerPotCrossBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().singleTexture(name(block), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + block.getRegistryName().getPath().replaceAll("potted_", "")))));
	}
	
	public void cropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(name(block) + "_stage0", extend(blockTexture(block), "_stage0"))).addModel()
			.partialState().with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(name(block) + "_stage1", extend(blockTexture(block), "_stage1"))).addModel()
			.partialState().with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(name(block) + "_stage2", extend(blockTexture(block), "_stage2"))).addModel()
			.partialState().with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(name(block) + "_stage3", extend(blockTexture(block), "_stage3"))).addModel()
			.partialState().with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(name(block) + "_stage4", extend(blockTexture(block), "_stage4"))).addModel()
			.partialState().with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(name(block) + "_stage5", extend(blockTexture(block), "_stage5"))).addModel()
			.partialState().with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(name(block) + "_stage6", extend(blockTexture(block), "_stage6"))).addModel()
			.partialState().with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(name(block) + "_stage7", extend(blockTexture(block), "_stage7"))).addModel();
	}
	
	public void tallCropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(name(block) + "_lower_stage0", extend(blockTexture(block), "_lower_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(name(block) + "_lower_stage1", extend(blockTexture(block), "_lower_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(name(block) + "_lower_stage2", extend(blockTexture(block), "_lower_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(name(block) + "_lower_stage3", extend(blockTexture(block), "_lower_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(name(block) + "_lower_stage4", extend(blockTexture(block), "_lower_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(name(block) + "_lower_stage5", extend(blockTexture(block), "_lower_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(name(block) + "_lower_stage6", extend(blockTexture(block), "_lower_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(name(block) + "_lower_stage7", extend(blockTexture(block), "_lower_stage7"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(name(block) + "_upper_stage0", extend(blockTexture(block), "_upper_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(name(block) + "_upper_stage1", extend(blockTexture(block), "_upper_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(name(block) + "_upper_stage2", extend(blockTexture(block), "_upper_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(name(block) + "_upper_stage3", extend(blockTexture(block), "_upper_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(name(block) + "_upper_stage4", extend(blockTexture(block), "_upper_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(name(block) + "_upper_stage5", extend(blockTexture(block), "_upper_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(name(block) + "_upper_stage6", extend(blockTexture(block), "_upper_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(name(block) + "_upper_stage7", extend(blockTexture(block), "_upper_stage7"))).addModel();
	}
	
	public void hexagonalCrystalBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CrystalBlock.FACING, Direction.NORTH).modelForState().modelFile(hexagonalCrystal(block)).rotationX(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.EAST).modelForState().modelFile(hexagonalCrystal(block)).rotationX(90).rotationY(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.SOUTH).modelForState().modelFile(hexagonalCrystal(block)).rotationX(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.WEST).modelForState().modelFile(hexagonalCrystal(block)).rotationX(90).rotationY(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.UP).modelForState().modelFile(hexagonalCrystal(block)).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.DOWN).modelForState().modelFile(hexagonalCrystal(block)).rotationX(180).addModel();
		this.simpleBlockItem(block, hexagonalCrystal(block));
    }
	
	public void cubicCrystalBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CrystalBlock.FACING, Direction.NORTH).modelForState().modelFile(cubicCrystal(block)).rotationX(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.EAST).modelForState().modelFile(cubicCrystal(block)).rotationX(90).rotationY(90).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.SOUTH).modelForState().modelFile(cubicCrystal(block)).rotationX(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.WEST).modelForState().modelFile(cubicCrystal(block)).rotationX(90).rotationY(270).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.UP).modelForState().modelFile(cubicCrystal(block)).addModel()
			.partialState().with(CrystalBlock.FACING, Direction.DOWN).modelForState().modelFile(cubicCrystal(block)).rotationX(180).addModel();
		this.simpleBlockItem(block, cubicCrystal(block));
    }
	
	public void twentyFourDirectionBlock(Block block) {
    	getVariantBuilder(block)
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor(block)).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor2(block)).rotationX(270).rotationY(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor(block)).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor2(block)).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).rotationX(270).rotationY(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.NORTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor2(block)).rotationY(90).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor(block)).rotationY(90).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor2(block)).rotationY(270).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor(block)).rotationY(90).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).rotationY(270).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.EAST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).rotationY(90).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor(block)).rotationY(180).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor2(block)).rotationY(180).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor(block)).rotationY(180).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor2(block)).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.SOUTH).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).rotationY(180).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor2(block)).rotationY(90).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor(block)).rotationY(270).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor2(block)).rotationY(270).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor(block)).rotationY(270).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).rotationY(90).rotationX(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.WEST).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).rotationY(270).rotationX(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor(block)).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor(block)).rotationY(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor(block)).rotationY(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor(block)).rotationY(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.UP).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.NORTH).modelForState().modelFile(motor(block)).rotationX(180).rotationY(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.EAST).modelForState().modelFile(motor(block)).rotationX(180).rotationY(270).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.SOUTH).modelForState().modelFile(motor(block)).rotationX(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.WEST).modelForState().modelFile(motor(block)).rotationX(180).rotationY(90).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.UP).modelForState().modelFile(motor(block)).rotationX(180).rotationY(180).addModel()
    		.partialState().with(DirectionalBlock.FACING, Direction.DOWN).with(TwentyFourDirectionBlock.SUB_FACING, Direction.DOWN).modelForState().modelFile(motor(block)).rotationX(180).rotationY(180).addModel();
    	this.simpleBlockItem(block, motor(block));
    }
	
	public void displayBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(display(block)));
		this.simpleBlockItem(block, display(block));
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
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", replace(replace(blockTexture(block), "_wall", ""), "block", "item"));
	}
	
	public void crossBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
	
	public void crystalBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
}
