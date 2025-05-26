package com.technologica.resourcegen.util;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.MasterResourceGenerator;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaModels {
	public static BlockModelBuilder getBuilder(String path) {
		ResourceLocation outputLoc = extendWithFolder(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(MasterResourceGenerator.modID, path));
		return new BlockModelBuilder(outputLoc, MasterResourceGenerator.helper);
	}

	public static ResourceLocation extendWithFolder(ResourceLocation rl) {
		if (rl.getPath().contains("/")) {
			return rl;
		} else {
			return new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath());
		}
	}

	public static ModelFile.ExistingModelFile getExistingFile(ResourceLocation path) {
		ModelFile.ExistingModelFile ret = new ModelFile.ExistingModelFile(extendWithFolder(path), MasterResourceGenerator.helper);
		ret.assertExistence();
		return ret;
	}

	public static String name(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}

	public static ResourceLocation blockTexture(Block block) {
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(block);
		return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
	}

	public static ModelBuilder<BlockModelBuilder> withExistingParent(String name, ResourceLocation parent) {
		return getBuilder(name).parent(getExistingFile(parent));
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture) {
		return withExistingParent(name, parent).texture(textureKey, texture);
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, ResourceLocation parent, ResourceLocation texture) {
		return singleTexture(name, parent, "texture", texture);
	}

	public static ModelFile chairModel(Block block, ResourceLocation texture, String renderType) {
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("chair"), "planks", texture).renderType(renderType);
	}

	public static ModelFile glueModel(String name, ResourceLocation particle, ResourceLocation face) {
		return withExistingParent(name, new TechnologicaLocation("block/glue_model")).texture("particle", particle).texture("face", face);
	}

	public static ModelFile trellis(Block block, ResourceLocation texture) {
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("trellis_model"), texture).renderType("cutout");
	}

	public static ModelFile hollowLogModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("hollow_log")).texture("side", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get())).texture("end", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()) + "_top").texture("inside", blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()) + "_solid").renderType("translucent");
	}

	public static ModelFile tapeDriveLowerModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_lower", new TechnologicaLocation(ResourceLocationHelper.getPath(block) + "_lower_model"));
	}

	public static ModelFile tapeDriveUpperModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_upper", new TechnologicaLocation(ResourceLocationHelper.getPath(block) + "_upper_model"));
	}

	public static ModelFile tableModel(Block block, ResourceLocation texture, String renderType) {
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("table"), "planks", texture).renderType(renderType);
	}

	public static ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile spikyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("spiky_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile leafyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.getPath(block), new TechnologicaLocation("leafy_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile lineShaftNoPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_no_pulley", new TechnologicaLocation("line_shaft_no_pulley_model"));
	}

	public static ModelFile lineShaftSmallPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_small_pulley", new TechnologicaLocation("line_shaft_small_pulley_model"));
	}

	public static ModelFile lineShaftMediumPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_medium_pulley", new TechnologicaLocation("line_shaft_medium_pulley_model"));
	}

	public static ModelFile lineShaftLargePulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_large_pulley", new TechnologicaLocation("line_shaft_large_pulley_model"));
	}

	public static ModelFile lineShaftHangerModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("line_shaft_hanger_model"));
	}

	public static ModelFile lineShaftHangerModel2(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "2", new TechnologicaLocation("line_shaft_hanger2_model"));
	}

	public static ModelFile lineShaftHangerModel3(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "_shaft", new TechnologicaLocation("line_shaft_hanger_shaft_model"));
	}

	public static ModelFile lineShaftHangerModel4(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "2_shaft", new TechnologicaLocation("line_shaft_hanger2_shaft_model"));
	}

	public static ModelFile motorModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("motor")).texture("motor", blockTexture(block));
	}

	public static ModelFile motor2Model(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block) + "2", new TechnologicaLocation("motor2")).texture("motor", blockTexture(block));
	}

	public static ModelFile treeTapModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("tap")).texture("tree_tap", blockTexture(block));
	}

	public static ModelFile monitorModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public static ModelFile keyboardModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation(ResourceLocationHelper.getPath(block) + "_model"));
	}

	public static ModelFile displayModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool")).renderType("cutout_mipped");
	}

	public static ModelFile cubeEachFace(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation east, ResourceLocation south, ResourceLocation west) {
		return withExistingParent(name, new TechnologicaLocation("block/cube_each_face")).texture("particle", down).texture("down", down).texture("up", up).texture("north", north).texture("east", east).texture("south", south).texture("west", west);
	}

	public static ModelFile stem(String name, ResourceLocation stem, int growth) {
		return withExistingParent(name, new ResourceLocation("stem_growth" + growth)).renderType("cutout").texture("stem", stem);
	}

	public static ModelFile attachedStem(String name, ResourceLocation stem, ResourceLocation upperStem) {
		return withExistingParent(name, new TechnologicaLocation("stem_gourd")).renderType("cutout").texture("stem", stem).texture("upperstem", upperStem);
	}

	public static ModelFile gourdCropModel(Block block) {
		return withExistingParent(ResourceLocationHelper.getPath(block), new TechnologicaLocation("gourd")).renderType("cutout_mipped").texture("gourd", blockTexture(block));
	}

	public static ModelFile hopper(String name, String top, String side, String inside) {
		return withExistingParent(name, new TechnologicaLocation("technologica_hopper")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public static ModelFile basin(String name, String top, String bottom, String side) {
		return withExistingParent(name, new TechnologicaLocation("basin_model")).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom);
	}

	public static ModelFile basinFilled(String name, String level, String top, String bottom, String side, String content) {
		return withExistingParent(name + "_level" + level, new TechnologicaLocation("basin_filled_model_level" + level)).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom).texture("content", content);
	}

	public static ModelFile panel(String name, String top, String side, String bottom) {
		return withExistingParent(name, new TechnologicaLocation("panel")).texture("particle", side).texture("top", top).texture("side", side).texture("bottom", bottom);
	}

	public static ModelFile hopperSide(String name, String top, String side, String inside) {
		return withExistingParent(name, new TechnologicaLocation("technologica_hopper_side")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public static ModelFile abyssPortalModelEW(Block block) {
		return withExistingParent(name(TechnologicaBlocks.ABYSS_PORTAL.get()) + "_ew", new TechnologicaLocation("block/abyss_portal_ew")).texture("particle", new TechnologicaLocation("block/abyss_portal")).texture("portal", new TechnologicaLocation("block/abyss_portal"));
	}

	public static ModelFile abyssPortalModelNS(Block block) {
		return withExistingParent(name(TechnologicaBlocks.ABYSS_PORTAL.get()) + "_ns", new TechnologicaLocation("block/abyss_portal_ns")).texture("particle", new TechnologicaLocation("block/abyss_portal")).texture("portal", new TechnologicaLocation("block/abyss_portal"));
	}
}
