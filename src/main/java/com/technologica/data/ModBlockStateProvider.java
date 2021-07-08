package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.CrystalBlock;
import com.technologica.block.MagicLeavesBlock;
import com.technologica.block.ModBlocks;
import com.technologica.block.ModLeavesBlock;
import com.technologica.block.ModLogBlock;
import com.technologica.block.PotionLeavesBlock;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.data.DataGenerator;
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
		automaticBlock(ModBlocks.BLOCKS.getEntries());
		cubicCrystalBlock(ModBlocks.DOLOMITE_CRYSTAL.get());
		displayBlock(ModBlocks.DISPLAY_CASE.get());
	}	
	
	private final void automaticBlock(Collection<RegistryObject<Block>> collection) {
		for(Supplier<? extends Block> blockSupplier:collection) {
			Block block = blockSupplier.get();
			if (block instanceof ModLeavesBlock || block instanceof PotionLeavesBlock || block instanceof MagicLeavesBlock || block.getClass() == Block.class || block instanceof OreBlock) {
				if (!block.getRegistryName().getPath().contains("pulley") && !block.getRegistryName().getPath().contains("bookshelf")) {
					simpleBlock(block);
					this.simpleBlockItem(block, cubeAll(block));
				} else if (block.getRegistryName().getPath().contains("bookshelf")) {
					bookshelfBlock(block);
				}
			} else if (block instanceof ModLogBlock) logBlock(block);	
			else if (block instanceof SlabBlock) slabBlock(block);
			else if (block instanceof StairsBlock) stairsBlock(block);
			else if (block instanceof FenceBlock) fenceBlock(block);
			else if (block instanceof FenceGateBlock) fenceGateBlock(block);
			else if (block instanceof SaplingBlock) crossBlock(block);
			else if (block instanceof FlowerPotBlock) flowerPotCrossBlock(block);
			else if (block instanceof CropsBlock) cropBlock(block);
			else if (block instanceof DoorBlock) doorBlock(block);
			else if (block instanceof TrapDoorBlock) trapdoorBlock(block);
			else if (block instanceof CrystalBlock) {
				if (!block.getRegistryName().getPath().contains("dolomite")) {
					hexagonalCrystalBlock(block);
				}
			}
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
			return models().cubeColumn(name(block), blockTexture(block), replace(blockTexture(block), "bookshelf", "planks"));
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
	
	public ModelFile display(Block block) {
		return models().withExistingParent(name(block), modLoc("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool"));
    }
	
	/*
	 * Blockstate, block model, and item model providers
	 */
	public void bookshelfBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cubeColumn(name(block), blockTexture(block), replace(blockTexture(block), "bookshelf", "planks"))));
		this.simpleBlockItem(block, cubeColumn(block));		
    }
	
	public void logBlock(Block block) {
		logBlock((RotatedPillarBlock) block);
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
	
	public void displayBlock(Block block) {
		getVariantBuilder(block).partialState().setModels(new ConfiguredModel(display(block)));
		this.simpleBlockItem(block, display(block));
    }
	
	public void doorBlockItem(Block block, ModelFile model) {
		ResourceLocation location = block.getRegistryName();
        itemModels().getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(location.getNamespace(), "item/" + location.getPath()));
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
