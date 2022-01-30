package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.LineShaftBlock;
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.VanillaCropsBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.state.properties.TechnologicaBlockStateProperties;
import com.technologica.util.AnnunciatorOverlay;
import com.technologica.util.Radius;
import com.technologica.util.text.ResourceLocationHelper;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
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
			String path = ResourceLocationHelper.getPath(block);
			ResourceLocation texture = blockTexture(block);
				
			if (path.contains("leaves")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("_planks")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("salt")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("_clay")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("moon")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("_ore")) {
				simpleBlock(block);
				simpleBlockItem(block, cubeAll(block));
			} else if (path.contains("_bookshelf"))  {
				ResourceLocation end = blockTexture(block);
				if (ResourceLocationHelper.getPath(block).contains("spruce") || block.getTranslationKey().contains("birch") || block.getTranslationKey().contains("jungle") || block.getTranslationKey().contains("acacia") || block.getTranslationKey().contains("dark_oak") || block.getTranslationKey().contains("crimson") || block.getTranslationKey().contains("warped")) {
					end = mcLoc(blockTexture(block).getPath());	
				}
				simpleBlock(block, models().cubeColumn(path, blockTexture(block), ResourceLocationHelper.replace(end, "bookshelf", "planks")));
				simpleBlockItem(block, models().cubeColumn(path, blockTexture(block), ResourceLocationHelper.replace(end, "bookshelf", "planks")));
			} else if (path.contains("_log")) {
				logBlock((RotatedPillarBlock) block);
				simpleBlockItem(block, models().cubeColumn(path, blockTexture(block), new ResourceLocation(blockTexture(block) + "_top")));
			} else if (path.contains("_wood")) {
				texture = ResourceLocationHelper.replace(blockTexture(block), "_wood", "_log");
				axisBlock((RotatedPillarBlock) block, models().cubeColumn(path, texture, texture), models().cubeColumn(path, texture, texture));
				simpleBlockItem(block, models().cubeColumn(path, texture, texture));
			} else if (path.contains("_slab")) {
				texture = ResourceLocationHelper.replace(blockTexture(block), "_slab", "_planks");
				slabBlock((SlabBlock) block, texture, texture);
				simpleBlockItem(block, models().slab(path, texture, texture, texture));
			} else if (path.contains("_stairs")) {
				texture = ResourceLocationHelper.replace(blockTexture(block), "_stairs", "_planks");
				stairsBlock((StairsBlock) block, texture);
				simpleBlockItem(block, models().stairs(path, texture, texture, texture));
			} else if (path.contains("_fence") && !path.contains("_gate")) {
				texture = ResourceLocationHelper.replace(blockTexture(block), "_fence", "_planks");
				fenceBlock((FenceBlock) block, texture);
				simpleBlockItem(block, models().fenceInventory(path + "_inventory", texture));
			} else if (path.contains("_fence_gate")) {
				texture = ResourceLocationHelper.replace(blockTexture(block), "_fence_gate", "_planks");
				fenceGateBlock((FenceGateBlock) block, texture);
				simpleBlockItem(block, models().fenceGate(path, texture));
			}
			else if (path.contains("_door") && !path.contains("trap")) {
				doorBlock((DoorBlock) block, ResourceLocationHelper.extend(blockTexture(block), "_bottom"), ResourceLocationHelper.extend(blockTexture(block), "_top"));
				signItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
			}
			else if (path.contains("_trapdoor")) {
				trapdoorBlock((TrapDoorBlock) block, blockTexture(block), true);
				simpleBlockItem(block, models().trapdoorOrientableBottom(path + "_bottom", texture));
			}
			else if (path.contains("_sign")) signBlock(block);
			else if (path.contains("display_case")) {
				simpleBlock(block, displayModel(block));
				simpleBlockItem(block, displayModel(block));
			}
			else if (path.contains("_sapling") && !path.contains("potted")) simpleBlock(block, models().cross(path, texture));
			else if (path.contains("potted")) simpleBlock(block, models().singleTexture(path, mcLoc("flower_pot_cross"), "plant", modLoc("block/" + path.replaceAll("potted_", ""))));
			else if (block.getClass().equals(VanillaCropsBlock.class)) cropBlock(block);
			else if (block.getClass().equals(TallCropsBlock.class) || block.getClass().equals(WaterCropsBlock.class)) tallCropBlock(block);
			else if (path.contains("_pressure_plate")) {
				pressurePlateBlockState(block, pressurePlateModel(block), pressurePlateDownModel(block));
			}
			else if (path.contains("_button")) buttonBlockState(block, buttonModel(block), buttonPressedModel(block), buttonInventoryModel(block));
			else if (path.contains("tree_tap")) fourDirectionBlockState(block, treeTapModel(block));
			else if (path.contains("_chair")) {
				ResourceLocation planks = ResourceLocationHelper.replace(blockTexture(block), "chair", "planks");
				if (path.contains("oak") || path.contains("spruce") || path.contains("birch") || path.contains("jungle") || path.contains("acacia") || path.contains("dark_oak") || path.contains("crimson") || path.contains("warped")) {
					planks = mcLoc(ResourceLocationHelper.replace(blockTexture(block).getPath(), "chair", "planks"));	
				}
				fourDirectionBlockState(block, chairModel(block, planks));
			}
			else if (path.contains("_table")) {
				ResourceLocation planks = ResourceLocationHelper.replace(blockTexture(block), "table", "planks");
				if (path.contains("oak") || path.contains("spruce") || path.contains("birch") || path.contains("jungle") || path.contains("acacia") || path.contains("dark_oak") || path.contains("crimson") || path.contains("warped")) {
					planks = mcLoc(ResourceLocationHelper.replace(blockTexture(block).getPath(), "table", "planks"));	
				}
				simpleBlock(block, tableModel(block, planks));
				simpleBlockItem(block, tableModel(block, planks));
			}
			else if (path.contains("_crystal") && !path.contains("dolomite")) twentyFourDirectionBlockState(block, hexagonalCrystalModel(block), hexagonalCrystalModel(block));
			else if (path.contains("_crystal") && path.contains("dolomite")) twentyFourDirectionBlockState(block, cubicCrystalModel(block), cubicCrystalModel(block));
			else if (path.contains("motor")) twentyFourDirectionBlockState(block, motorModel(block), motor2Model(block));
			else if (block instanceof LineShaftBlock) {
				lineShaftBlockState(block, lineShaftNoPulleyModel(block), lineShaftSmallPulleyModel(block), lineShaftMediumPulleyModel(block), lineShaftLargePulleyModel(block));
			}
			else if (path.contains("line_shaft_hanger")) twelveDirectionBlockState(block, lineShaftHangerModel(block), lineShaftHangerModel2(block));
			else if (block instanceof FlowingFluidBlock) {
				getVariantBuilder(block).partialState().setModels(new ConfiguredModel(fluid(block)));
			}
			else if (path.contains("_pulley")) {
				getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().withExistingParent(path, ResourceLocationHelper.technologicaLocation(path + "_model")).texture("pulley", ResourceLocationHelper.technologicaLocation("block/pulley"))));
			}
			else if (path.contains("sawmill")) fourDirectionBlockState(block, cubeAll(block));
			else if (path.contains("annunciator")) annunciatorBlockState(block);
			else if (path.contains("mulch")) simpleBlock(block, models().cubeBottomTop(path, modLoc("block/" + path + "_side"), mcLoc("block/dirt"), modLoc("block/" + path + "_top")));
			else if (path.contains("chain")) axisBlock((RotatedPillarBlock) block, models().withExistingParent(path, "block/chain"), models().withExistingParent(path, "block/chain"));
		}
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
	
    public void signBlock(Block block) {
		getVariantBuilder(block)
			.partialState().setModels(new ConfiguredModel(sign(block)));
	    this.signItem(block, new ModelFile.UncheckedModelFile("item/generated"));	
	}
    
	public void cropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage0", ResourceLocationHelper.extend(blockTexture(block), "_stage0"))).addModel()
			.partialState().with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage1", ResourceLocationHelper.extend(blockTexture(block), "_stage1"))).addModel()
			.partialState().with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage2", ResourceLocationHelper.extend(blockTexture(block), "_stage2"))).addModel()
			.partialState().with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage3", ResourceLocationHelper.extend(blockTexture(block), "_stage3"))).addModel()
			.partialState().with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage4", ResourceLocationHelper.extend(blockTexture(block), "_stage4"))).addModel()
			.partialState().with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage5", ResourceLocationHelper.extend(blockTexture(block), "_stage5"))).addModel()
			.partialState().with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage6", ResourceLocationHelper.extend(blockTexture(block), "_stage6"))).addModel()
			.partialState().with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_stage7", ResourceLocationHelper.extend(blockTexture(block), "_stage7"))).addModel();
	}
	
	public void tallCropBlock(Block block) {
		getVariantBuilder(block)
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage0", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage1", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage2", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage3", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage4", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage5", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage6", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.LOWER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_lower_stage7", ResourceLocationHelper.extend(blockTexture(block), "_lower_stage7"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 0).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage0", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage0"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 1).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage1", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage1"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 2).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage2", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage2"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 3).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage3", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage3"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 4).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage4", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage4"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 5).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage5", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage5"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 6).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage6", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage6"))).addModel()
			.partialState().with(TallCropsBlock.HALF, DoubleBlockHalf.UPPER).with(CropsBlock.AGE, 7).modelForState().modelFile(models().crop(ResourceLocationHelper.getPath(block) + "_upper_stage7", ResourceLocationHelper.extend(blockTexture(block), "_upper_stage7"))).addModel();
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
