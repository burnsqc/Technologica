package com.technologica.resourcegen.util;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.MasterResourceGenerator;
import com.tlregen.api.resourcegen.util.VanillaModels;
import com.tlregen.util.ResourceLocationHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper.ResourceType;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaModels {
	public static final ModelFile CHAIR = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/chair"));
	public static final ModelFile TABLE = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/table"));
	public static final ModelFile CUBIC_CRYSTAL = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/cubic_crystal"));
	public static final ModelFile HEXAGONAL_CRYSTAL = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/hexagonal_crystal"));
	public static final ModelFile LEAFY_CRYSTAL = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/leafy_crystal"));
	public static final ModelFile SPIKY_CRYSTAL = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/spiky_crystal"));
	public static final ModelFile GOURD = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/gourd"));
	public static final ModelFile GOURD_STEM = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/stem_gourd"));
	public static final ModelFile DISPLAY_CASE = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/display"));
	public static final ModelFile BASIN = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_model"));
	public static final ModelFile[] BASIN_FILLED = { new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level1")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level2")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level3")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level4")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level5")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level6")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level7")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level8")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level9")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level10")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level11")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level12")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level13")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level14")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level15")), new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/basin_filled_model_level16")) };
	public static final ModelFile HOLLOW_LOG = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/hollow_log"));
	public static final ModelFile HOPPER = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/technologica_hopper"));
	public static final ModelFile HOPPER_SIDE = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/technologica_hopper_side"));
	public static final ModelFile GLUE = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/glue_model"));
	public static final ModelFile MONITOR = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/monitor_model"));
	public static final ModelFile KEYBOARD = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/keyboard_model"));
	public static final ModelFile TREE_TAP = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/tap"));
	public static final ModelFile TRELLIS = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/trellis_model"));
	public static final ModelFile TAPE_DRIVE_LOWER = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/tape_drive_lower_model"));
	public static final ModelFile TAPE_DRIVE_UPPER = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/tape_drive_upper_model"));
	public static final ModelFile SMALL_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/small_pulley_model"));
	public static final ModelFile MEDIUM_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/medium_pulley_model"));
	public static final ModelFile LARGE_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/large_pulley_model"));
	public static final ModelFile LINE_SHAFT_HANGER = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_hanger_model"));
	public static final ModelFile LINE_SHAFT_HANGER2 = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_hanger2_model"));
	public static final ModelFile LINE_SHAFT_HANGER_SHAFT = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_hanger_shaft_model"));
	public static final ModelFile LINE_SHAFT_HANGER2_SHAFT = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_hanger2_shaft_model"));
	public static final ModelFile LINE_SHAFT_NO_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_no_pulley_model"));
	public static final ModelFile LINE_SHAFT_SMALL_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_small_pulley_model"));
	public static final ModelFile LINE_SHAFT_MEDIUM_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_medium_pulley_model"));
	public static final ModelFile LINE_SHAFT_LARGE_PULLEY = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/line_shaft_large_pulley_model"));
	public static final ModelFile MOTOR = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/motor"));
	public static final ModelFile MOTOR2 = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/motor2"));
	public static final ModelFile PANEL = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/panel"));
	public static final ModelFile CUBE_EACH_FACE = new ModelFile.UncheckedModelFile(new TechnologicaLocation("block/cube_each_face"));

	public static BlockModelBuilder getBuilder(String path) {
		ResourceLocation outputLoc = extendWithFolder(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(MasterResourceGenerator.modID, path));
		MasterResourceGenerator.helper.trackGenerated(outputLoc, new ResourceType(PackType.CLIENT_RESOURCES, ".json", "models"));
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

	public static ModelBuilder<BlockModelBuilder> withExistingParent(String name, String parent) {
		return withExistingParent(name, new ResourceLocation(parent));
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture) {
		return withExistingParent(name, parent).texture(textureKey, texture);
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, ResourceLocation parent, ResourceLocation texture) {
		return singleTexture(name, parent, "texture", texture);
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, String parent, String textureKey, ResourceLocation texture) {
		return singleTexture(name, new ResourceLocation(parent), textureKey, texture);
	}

	public static ModelBuilder<BlockModelBuilder> singleTexture(String name, String parent, ResourceLocation texture) {
		return singleTexture(name, new ResourceLocation(parent), texture);
	}

	private static BlockModelBuilder blockModel(String path) {
		ResourceLocation outputLoc = extendWithFolderBlock(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(MasterResourceGenerator.modID, path));
		BlockModelBuilder blockModelBuilder = new BlockModelBuilder(outputLoc, MasterResourceGenerator.helper);
		return blockModelBuilder;
	}

	private static ResourceLocation extendWithFolderBlock(ResourceLocation rl) {
		return rl.getPath().contains("/") ? rl : new ResourceLocation(rl.getNamespace(), "block/" + rl.getPath());
	}

	private static String path(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}

	public static BlockModelBuilder chair(Block block, ResourceLocation texture, ResourceLocation renderType) {
		return blockModel(path(block)).parent(CHAIR).texture("planks", texture).renderType(renderType);
	}

	public static BlockModelBuilder table(Block block, ResourceLocation texture, ResourceLocation renderType) {
		return blockModel(path(block)).parent(TABLE).texture("planks", texture).renderType(renderType);
	}

	public static BlockModelBuilder cropBottom(Block block, int stage) {
		return blockModel(path(block) + "_bottom_stage" + stage).parent(VanillaModels.CROP).texture("crop", blockTexture(block) + "_bottom_stage" + stage).renderType(VanillaModels.CUTOUT);
	}

	public static BlockModelBuilder cropTop(Block block, int stage) {
		return blockModel(path(block) + "_top_stage" + stage).parent(VanillaModels.CROP).texture("crop", blockTexture(block) + "_top_stage" + stage).renderType(VanillaModels.CUTOUT);
	}

	public static BlockModelBuilder bushBottom(Block block, int stage) {
		return blockModel(path(block) + "_bottom_stage" + stage).parent(VanillaModels.CROSS).texture("cross", blockTexture(block) + "_bottom_stage" + stage).renderType(VanillaModels.CUTOUT_MIPPED);
	}

	public static BlockModelBuilder bushTop(Block block, int stage) {
		return blockModel(path(block) + "_top_stage" + stage).parent(VanillaModels.CROSS).texture("cross", blockTexture(block) + "_top_stage" + stage).renderType(VanillaModels.CUTOUT_MIPPED);
	}

	public static BlockModelBuilder cubicCrystal(Block block) {
		return blockModel(path(block)).parent(CUBIC_CRYSTAL).texture("crystal", blockTexture(block)).renderType(VanillaModels.TRANSLUCENT);
	}

	public static BlockModelBuilder hexagonalCrystal(Block block) {
		return blockModel(path(block)).parent(HEXAGONAL_CRYSTAL).texture("crystal", blockTexture(block)).renderType(VanillaModels.TRANSLUCENT);
	}

	public static BlockModelBuilder leafyCrystal(Block block) {
		return blockModel(path(block)).parent(LEAFY_CRYSTAL).texture("crystal", blockTexture(block)).renderType(VanillaModels.TRANSLUCENT);
	}

	public static BlockModelBuilder spikyCrystal(Block block) {
		return blockModel(path(block)).parent(SPIKY_CRYSTAL).texture("crystal", blockTexture(block)).renderType(VanillaModels.TRANSLUCENT);
	}

	public static BlockModelBuilder gourd(Block block) {
		return blockModel(path(block)).parent(GOURD).texture("gourd", blockTexture(block)).renderType(VanillaModels.CUTOUT_MIPPED);
	}

	public static BlockModelBuilder gourdStem(Block block, ResourceLocation texture) {
		return blockModel(path(block)).parent(GOURD_STEM).texture("stem", texture).texture("upperstem", blockTexture(block)).renderType(VanillaModels.CUTOUT);
	}

	public static BlockModelBuilder displayCase(Block block) {
		return blockModel(path(block)).parent(DISPLAY_CASE).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool")).renderType(VanillaModels.CUTOUT_MIPPED);
	}

	public static BlockModelBuilder basin(Block block) {
		return blockModel(path(block)).parent(BASIN).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
	}

	public static BlockModelBuilder basin(Block block, int level) {
		return blockModel(ResourceLocationHelper.path(block) + "_level" + level).parent(BASIN_FILLED[level - 1]).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
	}

	public static BlockModelBuilder hollowLog(Block block) {
		return blockModel(path(block)).parent(HOLLOW_LOG).texture("end", new TechnologicaLocation("block/frostbitten_log_top")).texture("inside", new TechnologicaLocation("block/stripped_frostbitten_log_solid")).texture("side", new TechnologicaLocation("block/frostbitten_log")).renderType(VanillaModels.TRANSLUCENT);
	}

	public static BlockModelBuilder hopper(Block block) {
		return blockModel(path(block)).parent(HOPPER).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));
	}
	
	public static BlockModelBuilder hopperSide(Block block) {
		return blockModel(path(block)).parent(HOPPER_SIDE).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));
	}

	public static ModelFile hopperSide(String name, String top, String side, String inside) {
		return withExistingParent(name, new TechnologicaLocation("technologica_hopper_side")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public static BlockModelBuilder glue(Block block) {
		return blockModel(path(block)).parent(GLUE).texture("face", new TechnologicaLocation("block/glue")).texture("particle", new TechnologicaLocation("block/glue"));
	}

	public static BlockModelBuilder sleepingBagTop(Block block) {
		return blockModel(path(block)).parent(PANEL).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top"));
	}
	
	public static BlockModelBuilder sleepingBagTopHead(Block block) {
		return blockModel(path(block)).parent(PANEL).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top_head"));
	}

	public static BlockModelBuilder cubeEachFace(Block block, ResourceLocation down, ResourceLocation east, ResourceLocation north, ResourceLocation particle, ResourceLocation south, ResourceLocation up, ResourceLocation west) {
		return blockModel(path(block)).parent(CUBE_EACH_FACE).texture("down", down).texture("east", east).texture("north", north).texture("particle", particle).texture("south", south).texture("up", up).texture("west", west);
	}

	public static ModelFile cubeEachFace(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation east, ResourceLocation south, ResourceLocation west) {
		return withExistingParent(name, new TechnologicaLocation("block/cube_each_face")).texture("particle", down).texture("down", down).texture("up", up).texture("north", north).texture("east", east).texture("south", south).texture("west", west);
	}

	public static BlockModelBuilder byoParent(Block block, ModelFile parent) {
		return blockModel(ResourceLocationHelper.path(block)).parent(parent);
	}

	public static BlockModelBuilder byoParent(Block block, ModelFile parent, ResourceLocation texture) {
		return blockModel(ResourceLocationHelper.path(block)).parent(parent).texture("texture", texture);
	}

	public static BlockModelBuilder byoParent(ResourceLocation resourceLocation, ModelFile parent) {
		return blockModel(resourceLocation.getPath()).parent(parent);
	}

	public static BlockModelBuilder byoParent(ResourceLocation resourceLocation, ModelFile parent, ResourceLocation texture) {
		return blockModel(resourceLocation.getPath()).parent(parent).texture("texture", texture);
	}

	public static BlockModelBuilder byoParent(Block block, ModelFile parent, ResourceLocation texture, ResourceLocation renderType) {
		return blockModel(ResourceLocationHelper.path(block)).parent(parent).texture("texture", texture).renderType(renderType);
	}

	public static BlockModelBuilder byoParentNoTexture(Block block, ModelFile parent, ResourceLocation renderType) {
		return blockModel(ResourceLocationHelper.path(block)).parent(parent).renderType(renderType);
	}

	public static ModelFile glueModel(String name, ResourceLocation particle, ResourceLocation face) {
		return withExistingParent(name, new TechnologicaLocation("block/glue_model")).texture("particle", particle).texture("face", face);
	}

	public static ModelFile trellis(Block block, ResourceLocation texture) {
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("trellis_model"), texture).renderType("cutout");
	}

	public static ModelFile hollowLogModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("hollow_log")).texture("side", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get())).texture("end", blockTexture(TechnologicaBlocks.FROSTBITTEN_LOG.get()) + "_top").texture("inside", blockTexture(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get()) + "_solid").renderType("translucent");
	}

	public static ModelFile tapeDriveLowerModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_lower", new TechnologicaLocation(ResourceLocationHelper.path(block) + "_lower_model"));
	}

	public static ModelFile tapeDriveUpperModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_upper", new TechnologicaLocation(ResourceLocationHelper.path(block) + "_upper_model"));
	}

	public static ModelFile tableModel(Block block, ResourceLocation texture, String renderType) {
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("table"), "planks", texture).renderType(renderType);
	}

	public static ModelFile hexagonalCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("hexagonal_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile cubicCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("cubic_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile spikyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("spiky_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile leafyCrystalModel(Block block) {
		ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
		return singleTexture(ResourceLocationHelper.path(block), new TechnologicaLocation("leafy_crystal"), "crystal", blockTexture(block)).texture("crystal", new ResourceLocation(location.getNamespace(), "block/" + location.getPath())).renderType("translucent");
	}

	public static ModelFile lineShaftNoPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_no_pulley", new TechnologicaLocation("line_shaft_no_pulley_model"));
	}

	public static ModelFile lineShaftSmallPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_small_pulley", new TechnologicaLocation("line_shaft_small_pulley_model"));
	}

	public static ModelFile lineShaftMediumPulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_medium_pulley", new TechnologicaLocation("line_shaft_medium_pulley_model"));
	}

	public static ModelFile lineShaftLargePulleyModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_large_pulley", new TechnologicaLocation("line_shaft_large_pulley_model"));
	}

	public static ModelFile lineShaftHangerModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("line_shaft_hanger_model"));
	}

	public static ModelFile lineShaftHangerModel2(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "2", new TechnologicaLocation("line_shaft_hanger2_model"));
	}

	public static ModelFile lineShaftHangerModel3(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_shaft", new TechnologicaLocation("line_shaft_hanger_shaft_model"));
	}

	public static ModelFile lineShaftHangerModel4(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "2_shaft", new TechnologicaLocation("line_shaft_hanger2_shaft_model"));
	}

	public static ModelFile motorModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("motor")).texture("motor", blockTexture(block));
	}

	public static ModelFile motor2Model(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block) + "2", new TechnologicaLocation("motor2")).texture("motor", blockTexture(block));
	}

	public static ModelFile treeTapModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("tap")).texture("tree_tap", blockTexture(block));
	}

	public static ModelFile monitorModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation(ResourceLocationHelper.path(block) + "_model"));
	}

	public static ModelFile keyboardModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation(ResourceLocationHelper.path(block) + "_model"));
	}

	public static ModelFile displayModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("display")).texture("case", blockTexture(block)).texture("base", new ResourceLocation("block/black_wool")).renderType("cutout_mipped");
	}

	public static ModelFile stem(String name, ResourceLocation stem, int growth) {
		return withExistingParent(name, new ResourceLocation("stem_growth" + growth)).renderType("cutout").texture("stem", stem);
	}

	public static ModelFile attachedStem(String name, ResourceLocation stem, ResourceLocation upperStem) {
		return withExistingParent(name, new TechnologicaLocation("stem_gourd")).renderType("cutout").texture("stem", stem).texture("upperstem", upperStem);
	}

	public static ModelFile gourdCropModel(Block block) {
		return withExistingParent(ResourceLocationHelper.path(block), new TechnologicaLocation("gourd")).renderType("cutout_mipped").texture("gourd", blockTexture(block));
	}

	public static ModelFile hopperModel(String name, String top, String side, String inside) {
		return withExistingParent(name, new TechnologicaLocation("technologica_hopper")).texture("particle", side).texture("top", top).texture("side", side).texture("inside", inside);
	}

	public static ModelFile basinModel(String name, String top, String bottom, String side) {
		return withExistingParent(name, new TechnologicaLocation("basin_model")).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom);
	}

	public static ModelFile basinFilled(String name, String level, String top, String bottom, String side, String content) {
		return withExistingParent(name + "_level" + level, new TechnologicaLocation("basin_filled_model_level" + level)).texture("particle", side).texture("top", top).texture("bottom", bottom).texture("side", side).texture("inside", bottom).texture("content", content);
	}

	public static ModelFile panel(String name, String top, String side, String bottom) {
		return withExistingParent(name, new TechnologicaLocation("panel")).texture("particle", side).texture("top", top).texture("side", side).texture("bottom", bottom);
	}

	public static ModelFile abyssPortalModelEW(Block block) {
		return withExistingParent(name(TechnologicaBlocks.ABYSS_PORTAL.get()) + "_ew", new TechnologicaLocation("block/abyss_portal_ew")).texture("particle", new TechnologicaLocation("block/abyss_portal")).texture("portal", new TechnologicaLocation("block/abyss_portal"));
	}

	public static ModelFile abyssPortalModelNS(Block block) {
		return withExistingParent(name(TechnologicaBlocks.ABYSS_PORTAL.get()) + "_ns", new TechnologicaLocation("block/abyss_portal_ns")).texture("particle", new TechnologicaLocation("block/abyss_portal")).texture("portal", new TechnologicaLocation("block/abyss_portal"));
	}

	public static ModelFile cubeBottomTop(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		return withExistingParent(name, new ResourceLocation("block/cube_bottom_top")).texture("side", side).texture("bottom", bottom).texture("top", top);
	}

	public static ModelFile skull() {
		return getBuilder("minecraft:block/skull");
	}

	public static ModelBuilder<BlockModelBuilder> cross(String name, ResourceLocation cross) {
		return singleTexture(name, "block/cross", "cross", cross);
	}

	public static ModelBuilder<BlockModelBuilder> fluid(Block block) {
		return getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath()).texture("particle", "minecraft:block/water_still");
	}

	public static ModelFile cubeAll(Block block) {
		return cubeAll(name(block), blockTexture(block));
	}

	public static ModelBuilder<BlockModelBuilder> cubeAll(String name, ResourceLocation texture) {
		return singleTexture(name, "block/cube_all", "all", texture);
	}

	public static ModelBuilder<BlockModelBuilder> crop(String name, ResourceLocation crop) {
		return singleTexture(name, "block/crop", "crop", crop);
	}

	public static ModelBuilder<BlockModelBuilder> pressurePlate(Block block, ResourceLocation texture, String renderType) {
		return singleTexture(ResourceLocationHelper.path(block), new ResourceLocation("pressure_plate_up"), texture).renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> pressurePlateDown(Block block, ResourceLocation texture, String renderType) {
		return singleTexture(ResourceLocationHelper.path(block) + "_down", new ResourceLocation("pressure_plate_down"), texture).renderType(renderType);
	}
	
	public static ModelBuilder<BlockModelBuilder> doorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_bottom_left", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_bottom_left_open", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorBottomRight(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_bottom_right", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_bottom_right_open", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorTopLeft(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_top_left", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_top_left_open", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorTopRight(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_top_right", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> doorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
		return door(name, "door_top_right_open", bottom, top);
	}

	public static ModelBuilder<BlockModelBuilder> door(String name, String model, ResourceLocation bottom, ResourceLocation top) {
		return withExistingParent(name, "block/" + model).texture("bottom", bottom).texture("top", top);
	}

	public static ModelBuilder<BlockModelBuilder> sign(Block block, ResourceLocation texture, String renderType) {
		return getBuilder(name(block)).texture("particle", texture).renderType(renderType);
	}
	
	public static ModelBuilder<BlockModelBuilder> fenceGate(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_fence_gate", texture);
	}

	public static ModelBuilder<BlockModelBuilder> fenceGateOpen(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_fence_gate_open", texture);
	}

	public static ModelBuilder<BlockModelBuilder> fenceGateWall(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_fence_gate_wall", texture);
	}

	public static ModelBuilder<BlockModelBuilder> fenceGateWallOpen(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_fence_gate_wall_open", texture);
	}

	public static ModelBuilder<BlockModelBuilder> trapdoorOrientableBottom(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_orientable_trapdoor_bottom", texture);
	}

	public static ModelBuilder<BlockModelBuilder> trapdoorOrientableTop(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_orientable_trapdoor_top", texture);
	}

	public static ModelBuilder<BlockModelBuilder> trapdoorOrientableOpen(String name, ResourceLocation texture) {
		return singleTexture(name, "block/template_orientable_trapdoor_open", texture);
	}

	public static ModelBuilder<BlockModelBuilder> fencePost(String name, ResourceLocation texture) {
		return singleTexture(name, "block/fence_post", texture);
	}

	public static ModelBuilder<BlockModelBuilder> fenceSide(String name, ResourceLocation texture) {
		return singleTexture(name, "block/fence_side", texture);
	}

	public static ModelBuilder<BlockModelBuilder> button(String name, ResourceLocation texture) {
		return singleTexture(name, "block/button", texture);
	}

	public static ModelBuilder<BlockModelBuilder> buttonPressed(String name, ResourceLocation texture) {
		return singleTexture(name, "block/button_pressed", texture);
	}

	public static ModelBuilder<BlockModelBuilder> cubeColumn(String name, ResourceLocation side, ResourceLocation end) {
		return withExistingParent(name, "block/cube_column").texture("side", side).texture("end", end);
	}

	public static ModelBuilder<BlockModelBuilder> stairs(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		return withExistingParent(name, "block/stairs").texture("side", side).texture("bottom", bottom).texture("top", top);
	}

	public static ModelBuilder<BlockModelBuilder> stairsInner(Block block, ResourceLocation bottom, ResourceLocation side, ResourceLocation top, String renderType) {
		return withExistingParent(name(block) + "_inner", "block/inner_stairs").texture("bottom", bottom).texture("side", side).texture("top", top).renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> stairsOuter(Block block, ResourceLocation bottom, ResourceLocation side, ResourceLocation top, String renderType) {
		return withExistingParent(name(block) + "_outer", "block/outer_stairs").texture("bottom", bottom).texture("side", side).texture("top", top).renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> orientable(String name, ResourceLocation side, ResourceLocation front, ResourceLocation top) {
		return withExistingParent(name, "block/orientable").texture("side", side).texture("front", front).texture("top", top);
	}

	public static ModelBuilder<BlockModelBuilder> slab(Block block, ResourceLocation bottom, ResourceLocation side, ResourceLocation top, String renderType) {
		return withExistingParent(name(block), "block/slab").texture("bottom", bottom).texture("side", side).texture("top", top).renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> slabTop(Block block, ResourceLocation bottom, ResourceLocation side, ResourceLocation top, String renderType) {
		return withExistingParent(name(block) + "_top", "block/slab_top").texture("bottom", bottom).texture("side", side).texture("top", top).renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> cubeColumnHorizontal(String name, ResourceLocation side, ResourceLocation end) {
		return withExistingParent(name, "block/cube_column_horizontal").texture("side", side).texture("end", end);
	}

	public static ModelFile buttonInventoryModel(Block block, String renderType) {
		return withExistingParent(ResourceLocationHelper.path(block) + "_inventory", "block/button_inventory").renderType(renderType);
	}

	public static ModelBuilder<BlockModelBuilder> fenceInventory(String name, ResourceLocation texture) {
		return singleTexture(name, "block/fence_inventory", texture);
	}
}
