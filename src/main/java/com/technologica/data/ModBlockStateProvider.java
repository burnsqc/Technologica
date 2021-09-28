package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.VanillaCropsBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.state.properties.TechnologicaBlockStateProperties;
import com.technologica.util.text.StringHelper;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}

	@Override
	protected void registerStatesAndModels() {
		automaticBlockState(TechnologicaBlocks.BLOCKS.getEntries());
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
			String path = StringHelper.getPath(block);
				
			if (path.contains("leaves")) singleBlockState(block, cubeAll(block));
			else if (path.contains("planks")) singleBlockState(block, cubeAll(block));
			else if (path.contains("salt")) singleBlockState(block, cubeAll(block));
			else if (path.contains("clay")) singleBlockState(block, cubeAll(block));
			else if (path.contains("ore")) singleBlockState(block, cubeAll(block));
			
			
	
			else if (path.contains("fence") && !path.contains("gate")) fenceBlock(block);
			else if (path.contains("fence_gate")) fenceGateBlock(block);
			else if (path.contains("sign")) signBlock(block);
			else if (block.getClass().equals(VanillaCropsBlock.class)) cropBlock(block);
			else if (block.getClass().equals(TallCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) tallCropBlock(block);
			else if (path.contains("door") && !path.contains("trap")) doorBlock(block);
			else if (path.contains("trapdoor")) trapdoorBlock(block);
			else if (path.contains("_stairs")) stairsBlockState(block);
			
			
			
			else if (path.contains("_bookshelf")) singleBlockState(block, bookshelfModel(block));
			else if (path.contains("_sapling") && !path.contains("potted")) crossBlockState(block, crossModel(block));
			else if (path.contains("potted")) crossBlockState(block, flowerPotCrossModel(block));
			else if (path.contains("_pressure_plate")) pressurePlateBlockState(block, pressurePlateModel(block), pressurePlateDownModel(block));
			else if (path.contains("_log")) axisBlockState(block, logModel(block), logHorizontalModel(block));
			else if (path.contains("_wood")) axisBlockState(block, woodModel(block), woodModel(block));
			else if (path.contains("_slab")) slabBlockState(block, slabBottomModel(block), slabTopModel(block), slabDoubleModel(block));
			else if (path.contains("_button")) buttonBlockState(block, buttonModel(block), buttonPressedModel(block), buttonInventoryModel(block));
			else if (path.contains("tree_tap")) fourDirectionBlockState(block, treeTapModel(block));
			else if (path.contains("_chair")) fourDirectionBlockState(block, chairModel(block));
			else if (path.contains("_crystal") && !path.contains("dolomite")) twentyFourDirectionBlockState(block, hexagonalCrystalModel(block), hexagonalCrystalModel(block));
			else if (path.contains("_crystal") && path.contains("dolomite")) twentyFourDirectionBlockState(block, cubicCrystalModel(block), cubicCrystalModel(block));
			else if (path.contains("motor")) twentyFourDirectionBlockState(block, motorModel(block), motor2Model(block));
			else if (path.contains("display_case")) singleBlockState(block, displayModel(block));
		}
	}
	
	/*
	 * ModelFiles
	 */
	
	public ModelFile crossModel(Block block) {
		return models().cross(StringHelper.getPath(block), blockTexture(block));
	}
	
	public ModelFile flowerPotCrossModel(Block block) {
		return models().singleTexture(StringHelper.getPath(block), mcLoc("flower_pot_cross"), "plant", modLoc("block/" + block.getRegistryName().getPath().replaceAll("potted_", "")));
	}
	
	public ModelFile bookshelfModel(Block block) {
		ResourceLocation end = blockTexture(block);
		if (StringHelper.getPath(block).contains("spruce") || block.getTranslationKey().contains("birch") || block.getTranslationKey().contains("jungle") || block.getTranslationKey().contains("acacia") || block.getTranslationKey().contains("dark_oak") || block.getTranslationKey().contains("crimson") || block.getTranslationKey().contains("warped")) {
			end = mcLoc(blockTexture(block).getPath());	
		}
		return models().cubeColumn(StringHelper.getPath(block), blockTexture(block), StringHelper.replace(end, "bookshelf", "planks"));
	}
	
	public ModelFile logModel(Block block) {
		return models().cubeColumn(StringHelper.getPath(block), blockTexture(block), StringHelper.extend(blockTexture(block), "_top"));
	}
	
	public ModelFile logHorizontalModel(Block block) {
		return models().cubeColumnHorizontal(StringHelper.getPath(block) + "_horizontal", blockTexture(block), StringHelper.extend(blockTexture(block), "_top"));
	}
	
	public ModelFile woodModel(Block block) {
		return models().cubeColumn(StringHelper.getPath(block), StringHelper.replace(blockTexture(block), "_wood", "_log"), StringHelper.replace(blockTexture(block), "_wood", "_log"));
	}
	
	public ModelFile slabBottomModel(Block block) {
		return models().slab(StringHelper.getPath(block), StringHelper.replace(blockTexture(block), "slab", "planks"), StringHelper.replace(blockTexture(block), "slab", "planks"), StringHelper.replace(blockTexture(block), "slab", "planks"));
	}
	
	public ModelFile slabTopModel(Block block) {
		return models().slabTop(StringHelper.getPath(block) + "_top", StringHelper.replace(blockTexture(block), "slab", "planks"), StringHelper.replace(blockTexture(block), "slab", "planks"), StringHelper.replace(blockTexture(block), "slab", "planks"));
	}
	
	public ModelFile slabDoubleModel(Block block) {
		return models().getExistingFile(StringHelper.replace(blockTexture(block), "slab", "planks"));
	}
	
	public ModelFile stairs(Block block) {
		return models().stairs(StringHelper.getPath(block), StringHelper.replace(blockTexture(block), "stairs", "planks"), StringHelper.replace(blockTexture(block), "stairs", "planks"), StringHelper.replace(blockTexture(block), "stairs", "planks"));
	}
	
	public ModelFile chairModel(Block block) {
		return models().singleTexture(StringHelper.getPath(block), modLoc("chair"), "planks", StringHelper.replace(blockTexture(block), "chair", "planks"));
	}
	
	public ModelFile fence(Block block) {
		return models().fenceInventory(StringHelper.getPath(block) + "_inventory", StringHelper.replace(blockTexture(block), "fence", "planks"));
	}
	
	public ModelFile fenceGate(Block block) {
		return models().fenceGate(StringHelper.getPath(block), StringHelper.replace(blockTexture(block), "fence_gate", "planks"));
	}
	
	public ModelFile trapdoor(Block block) {
		return models().trapdoorBottom(StringHelper.getPath(block), blockTexture(block));
	}
	
	public ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(StringHelper.getPath(block), modLoc("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
	
	public ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = block.getRegistryName();
		return models().singleTexture(StringHelper.getPath(block), modLoc("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
    }
	
	public ModelFile motorModel(Block block) {
		return models().withExistingParent(StringHelper.getPath(block), modLoc("motor")).texture("motor", blockTexture(block));
    }
	
	public ModelFile motor2Model(Block block) {
		return models().withExistingParent(StringHelper.getPath(block) + "2", modLoc("motor2")).texture("motor", blockTexture(block));
    }
	
	public ModelFile treeTapModel(Block block) {
		return models().withExistingParent(StringHelper.getPath(block), modLoc("tap")).texture("tree_tap", blockTexture(block));
	}
	
	public ModelFile displayModel(Block block) {
		return models().withExistingParent(StringHelper.getPath(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	public ModelFile pressurePlateModel(Block block) {
        return models().withExistingParent(StringHelper.getPath(block), "block/pressure_plate_up").texture("texture", StringHelper.replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile pressurePlateDownModel(Block block) {
        return models().withExistingParent(StringHelper.getPath(block) + "_down", "block/pressure_plate_down").texture("texture", StringHelper.replace(blockTexture(block), "_pressure_plate", "_planks"));
    }
	
	public ModelFile buttonModel(Block block) {
        return models().withExistingParent(StringHelper.getPath(block), "block/button").texture("texture", StringHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonPressedModel(Block block) {
        return models().withExistingParent(StringHelper.getPath(block) + "_pressed", "block/button_pressed").texture("texture", StringHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile buttonInventoryModel(Block block) {
        return models().withExistingParent(StringHelper.getPath(block) + "_inventory", "block/button_inventory").texture("texture", StringHelper.replace(blockTexture(block), "_button", "_planks"));
    }
	
	public ModelFile sign(Block block) {
        ResourceLocation location = block.getRegistryName();
        return models().getBuilder(location.getPath()).texture("particle", StringHelper.replace(StringHelper.replace(blockTexture(block), "_wall", ""), "_sign", "_planks"));
    }

	public ModelFile tallCrop(String name, ResourceLocation crop) {
		return models().withExistingParent(name, modLoc("tall_crop")).texture("crop", crop);
    }
	
	/*
	 * Blockstate, block model, and item model providers
	 */
	
	public void singleBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block)
			.partialState().setModels(new ConfiguredModel(blockModel));
		this.simpleBlockItem(block, blockModel);		
    }
	
	public void pressurePlateBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
    	getVariantBuilder(block)
    		.partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(blockModel1).addModel()
        	.partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(blockModel2).addModel();
    	this.simpleBlockItem(block, blockModel1);
    }
	
	public void axisBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2) {
		getVariantBuilder(block)
	        .partialState().with(BlockStateProperties.AXIS, Axis.Y).modelForState().modelFile(blockModel1).addModel()
	        .partialState().with(BlockStateProperties.AXIS, Axis.Z).modelForState().modelFile(blockModel2).rotationX(90).addModel()
	        .partialState().with(BlockStateProperties.AXIS, Axis.X).modelForState().modelFile(blockModel2).rotationX(90).rotationY(90).addModel();
	    this.simpleBlockItem(block, blockModel1);			
	}
	
	public void slabBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile blockModel3) {
		getVariantBuilder(block)
	        .partialState().with(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM).setModels(new ConfiguredModel(blockModel1))
	        .partialState().with(BlockStateProperties.SLAB_TYPE, SlabType.TOP).setModels(new ConfiguredModel(blockModel2))
	        .partialState().with(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE).setModels(new ConfiguredModel(blockModel3));
	    this.simpleBlockItem(block, slabBottomModel(block));
    }
	
	public void fourDirectionBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block)
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(blockModel).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(blockModel).rotationY(90).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(blockModel).rotationY(180).addModel()
			.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(blockModel).rotationY(270).addModel();
	    this.simpleBlockItem(block, blockModel);
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
	
	public void buttonBlockState(Block block, ModelFile blockModel1, ModelFile blockModel2, ModelFile itemModel) {
    	getVariantBuilder(block)
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.FLOOR).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(90).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(180).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, false).modelForState().modelFile(blockModel1).rotationY(270).rotationX(90).uvLock(true).addModel()
    		.partialState().with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.POWERED, true).modelForState().modelFile(blockModel2).rotationY(270).rotationX(90).uvLock(true).addModel();
    	this.simpleBlockItem(block, itemModel);
    }
	
	public void stairsBlockState(Block block) {
		stairsBlock((StairsBlock) block, StringHelper.replace(blockTexture(block), "stairs", "planks"));
	    this.simpleBlockItem(block, stairs(block));
    }
	
	public void fenceBlock(Block block) {
		fenceBlock((FenceBlock) block, StringHelper.replace(blockTexture(block), "fence", "planks"));
	    this.simpleBlockItem(block, fence(block));
    }
	
	public void fenceGateBlock(Block block) {
		fenceGateBlock((FenceGateBlock) block, StringHelper.replace(blockTexture(block), "fence_gate", "planks"));
	    this.simpleBlockItem(block, fenceGate(block));
    }
	
    public void doorBlock(Block block) {
    	doorBlock((DoorBlock) block, StringHelper.extend(blockTexture(block), "_bottom"), StringHelper.extend(blockTexture(block), "_top"));
        this.doorBlockItem(block, new ModelFile.UncheckedModelFile("item/generated"));
    }
    	
    public void trapdoorBlock(Block block) {
    	trapdoorBlock((TrapDoorBlock) block, blockTexture(block), true);
    	this.simpleBlockItem(block, trapdoor(block));
    }
    
    public void signBlock(Block block) {
		getVariantBuilder(block)
			.partialState().setModels(new ConfiguredModel(sign(block)));
	    this.signItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
	}
    
	public void crossBlockState(Block block, ModelFile blockModel) {
		getVariantBuilder(block)
			.partialState().setModels(new ConfiguredModel(blockModel));
	}
	
	public void cropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage0", StringHelper.extend(blockTexture(block), "_stage0"))).addModel()
			.partialState().with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage1", StringHelper.extend(blockTexture(block), "_stage1"))).addModel()
			.partialState().with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage2", StringHelper.extend(blockTexture(block), "_stage2"))).addModel()
			.partialState().with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage3", StringHelper.extend(blockTexture(block), "_stage3"))).addModel()
			.partialState().with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage4", StringHelper.extend(blockTexture(block), "_stage4"))).addModel()
			.partialState().with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage5", StringHelper.extend(blockTexture(block), "_stage5"))).addModel()
			.partialState().with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage6", StringHelper.extend(blockTexture(block), "_stage6"))).addModel()
			.partialState().with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_stage7", StringHelper.extend(blockTexture(block), "_stage7"))).addModel();
	}
	
	public void tallCropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage0", StringHelper.extend(blockTexture(block), "_lower_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage1", StringHelper.extend(blockTexture(block), "_lower_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage2", StringHelper.extend(blockTexture(block), "_lower_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage3", StringHelper.extend(blockTexture(block), "_lower_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage4", StringHelper.extend(blockTexture(block), "_lower_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage5", StringHelper.extend(blockTexture(block), "_lower_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage6", StringHelper.extend(blockTexture(block), "_lower_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_lower_stage7", StringHelper.extend(blockTexture(block), "_lower_stage7"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage0", StringHelper.extend(blockTexture(block), "_upper_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage1", StringHelper.extend(blockTexture(block), "_upper_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage2", StringHelper.extend(blockTexture(block), "_upper_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage3", StringHelper.extend(blockTexture(block), "_upper_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage4", StringHelper.extend(blockTexture(block), "_upper_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage5", StringHelper.extend(blockTexture(block), "_upper_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage6", StringHelper.extend(blockTexture(block), "_upper_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(StringHelper.getPath(block) + "_upper_stage7", StringHelper.extend(blockTexture(block), "_upper_stage7"))).addModel();
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
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", StringHelper.replace(StringHelper.replace(blockTexture(block), "_wall", ""), "block", "item"));
	}
}
