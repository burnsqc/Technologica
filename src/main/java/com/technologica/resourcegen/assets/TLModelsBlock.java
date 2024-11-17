package com.technologica.resourcegen.assets;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.assets.TLReGenModelsBlock;
import com.tlregen.util.ResourceLocationHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;

public class TLModelsBlock extends TLReGenModelsBlock {

	@Override
	protected void populate() {
		blocksOfMetal();
		bookshelves();
		buttons();
		chairs();
		crops();
		crystals();
		deepslateOres();
		doors();
		fences();
		fenceGates();
		fluids();
		leaves();
		logs();
		netherOres();
		ores();
		planks();
		pottedSaplings();
		pressurePlates();
		saplings();
		signs();
		slabs();
		stairs();
		strippedLogs();
		strippedWood();
		tables();
		trapdoors();
		wood();

		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()), "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_fail", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_fail")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_info", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_pass", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_pass")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_warn", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_warn")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_fail", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_fail")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_info", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_pass", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_pass")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		models.withExistingParent(models.name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_warn", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_warn")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));

		models.withExistingParent(models.name(TechnologicaBlocks.BASIN.get()), new TechnologicaLocation("block/basin_model")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		models.withExistingParent(models.name(TechnologicaBlocks.DISPLAY_CASE.get()), new TechnologicaLocation("block/display")).texture("base", new ResourceLocation("block/black_wool")).texture("case", new TechnologicaLocation("block/display_case")).renderType("cutout_mipped");

		models.withExistingParent(models.name(TechnologicaBlocks.FAST_HOPPER.get()), new TechnologicaLocation("block/technologica_hopper")).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.FAST_HOPPER.get()) + "_side", new TechnologicaLocation("block/technologica_hopper_side")).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));

		models.withExistingParent(models.name(TechnologicaBlocks.GLUE.get()), new TechnologicaLocation("block/glue_model")).texture("face", new TechnologicaLocation("block/glue")).texture("particle", new TechnologicaLocation("block/glue"));

		models.withExistingParent(models.name(TechnologicaBlocks.KEYBOARD.get()), new TechnologicaLocation("block/keyboard_model"));

		models.withExistingParent(models.name(TechnologicaBlocks.SMALL_PULLEY.get()), new TechnologicaLocation("block/small_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));
		models.withExistingParent(models.name(TechnologicaBlocks.MEDIUM_PULLEY.get()), new TechnologicaLocation("block/medium_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));
		models.withExistingParent(models.name(TechnologicaBlocks.LARGE_PULLEY.get()), new TechnologicaLocation("block/large_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));

		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), new TechnologicaLocation("block/line_shaft_hanger_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2", new TechnologicaLocation("block/line_shaft_hanger2_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2_shaft", new TechnologicaLocation("block/line_shaft_hanger2_shaft_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "_shaft", new TechnologicaLocation("block/line_shaft_hanger_shaft_model"));

		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT.get()) + "_no_pulley", new TechnologicaLocation("block/line_shaft_no_pulley_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT.get()) + "_small_pulley", new TechnologicaLocation("block/line_shaft_small_pulley_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT.get()) + "_medium_pulley", new TechnologicaLocation("block/line_shaft_medium_pulley_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.LINE_SHAFT.get()) + "_large_pulley", new TechnologicaLocation("block/line_shaft_large_pulley_model"));

		models.withExistingParent(models.name(TechnologicaBlocks.MONITOR.get()), new TechnologicaLocation("block/monitor_model"));

		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_1HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_1hp"));
		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_1HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_1hp"));
		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_5HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_5hp"));
		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_5HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_5hp"));
		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_20HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_20hp"));
		models.withExistingParent(models.name(TechnologicaBlocks.MOTOR_20HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_20hp"));

		models.withExistingParent(models.name(TechnologicaBlocks.MULCH.get()), new ResourceLocation("block/cube_bottom_top")).texture("bottom", new ResourceLocation("block/dirt")).texture("side", new TechnologicaLocation("block/mulch_side")).texture("top", new TechnologicaLocation("block/mulch_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.NITROGLYCERIN.get()), new ResourceLocation("block/cube_bottom_top")).texture("bottom", new TechnologicaLocation("block/nitroglycerin_bottom")).texture("side", new TechnologicaLocation("block/nitroglycerin_side")).texture("top", new TechnologicaLocation("block/nitroglycerin_top"));

		models.withExistingParent(models.name(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), new ResourceLocation("block/chain")).renderType("cutout_mipped");

		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level1", new TechnologicaLocation("block/basin_filled_model_level1")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level2", new TechnologicaLocation("block/basin_filled_model_level2")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level3", new TechnologicaLocation("block/basin_filled_model_level3")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level4", new TechnologicaLocation("block/basin_filled_model_level4")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level5", new TechnologicaLocation("block/basin_filled_model_level5")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level6", new TechnologicaLocation("block/basin_filled_model_level6")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level7", new TechnologicaLocation("block/basin_filled_model_level7")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level8", new TechnologicaLocation("block/basin_filled_model_level8")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level9", new TechnologicaLocation("block/basin_filled_model_level9")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level10", new TechnologicaLocation("block/basin_filled_model_level10")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level11", new TechnologicaLocation("block/basin_filled_model_level11")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level12", new TechnologicaLocation("block/basin_filled_model_level12")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level13", new TechnologicaLocation("block/basin_filled_model_level13")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level14", new TechnologicaLocation("block/basin_filled_model_level14")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level15", new TechnologicaLocation("block/basin_filled_model_level15")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level16", new TechnologicaLocation("block/basin_filled_model_level16")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level1", new TechnologicaLocation("block/basin_filled_model_level1")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level2", new TechnologicaLocation("block/basin_filled_model_level2")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level3", new TechnologicaLocation("block/basin_filled_model_level3")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level4", new TechnologicaLocation("block/basin_filled_model_level4")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level5", new TechnologicaLocation("block/basin_filled_model_level5")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level6", new TechnologicaLocation("block/basin_filled_model_level6")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level7", new TechnologicaLocation("block/basin_filled_model_level7")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level8", new TechnologicaLocation("block/basin_filled_model_level8")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level9", new TechnologicaLocation("block/basin_filled_model_level9")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level10", new TechnologicaLocation("block/basin_filled_model_level10")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level11", new TechnologicaLocation("block/basin_filled_model_level11")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level12", new TechnologicaLocation("block/basin_filled_model_level12")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level13", new TechnologicaLocation("block/basin_filled_model_level13")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level14", new TechnologicaLocation("block/basin_filled_model_level14")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level15", new TechnologicaLocation("block/basin_filled_model_level15")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level16", new TechnologicaLocation("block/basin_filled_model_level16")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()), "block/orientable").texture("front", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("side", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("top", new TechnologicaLocation("block/sawmill_top_middle"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()), "block/orientable").texture("front", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("side", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("top", new TechnologicaLocation("block/sawmill_top_middle"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));

		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		models.withExistingParent(models.name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));

		models.withExistingParent(models.name(TechnologicaBlocks.SLEEPING_BAG.get()) + "_top", new TechnologicaLocation("block/panel")).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.SLEEPING_BAG.get()) + "_top_head", new TechnologicaLocation("block/panel")).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top_head"));

		models.withExistingParent(models.name(TechnologicaBlocks.TAPE_DRIVE.get()) + "_lower", new TechnologicaLocation("block/tape_drive_lower_model"));
		models.withExistingParent(models.name(TechnologicaBlocks.TAPE_DRIVE.get()) + "_upper", new TechnologicaLocation("block/tape_drive_upper_model"));

		models.withExistingParent(models.name(TechnologicaBlocks.TREE_TAP.get()), new TechnologicaLocation("block/tap")).texture("tree_tap", new TechnologicaLocation("block/tree_tap"));

		models.withExistingParent(models.name(TechnologicaBlocks.TRELLIS.get()), new TechnologicaLocation("block/trellis_model")).texture("texture", new TechnologicaLocation("block/trellis")).renderType("cutout");

		models.withExistingParent("dead_" + models.name(TechnologicaBlocks.BARNACLE.get()), new ResourceLocation("block/dead_sea_pickle")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent(models.name(TechnologicaBlocks.BARNACLE.get()), new ResourceLocation("block/sea_pickle")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("two_dead_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/two_dead_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("two_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/two_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("three_dead_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/three_dead_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("three_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/three_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("four_dead_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/four_dead_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
		models.withExistingParent("four_" + models.name(TechnologicaBlocks.BARNACLE.get()) + "s", new ResourceLocation("block/four_sea_pickles")).texture("all", new TechnologicaLocation("block/barnacle")).renderType("cutout");
	}

	private void blocksOfMetal() {
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get(), new TechnologicaLocation("block/block_of_actinium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get(), new TechnologicaLocation("block/block_of_aluminum"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get(), new TechnologicaLocation("block/block_of_americium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get(), new TechnologicaLocation("block/block_of_antimony"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ARSENIC.get(), new TechnologicaLocation("block/block_of_arsenic"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ASTATINE.get(), new TechnologicaLocation("block/block_of_astatine"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get(), new TechnologicaLocation("block/block_of_berkellium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get(), new TechnologicaLocation("block/block_of_beryllium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BISMUTH.get(), new TechnologicaLocation("block/block_of_bismuth"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BORON.get(), new TechnologicaLocation("block/block_of_boron"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BRASS.get(), new TechnologicaLocation("block/block_of_brass"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_BRONZE.get(), new TechnologicaLocation("block/block_of_bronze"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_CADMIUM.get(), new TechnologicaLocation("block/block_of_cadmium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get(), new TechnologicaLocation("block/block_of_californium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_CARBON.get(), new TechnologicaLocation("block/block_of_carbon"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get(), new TechnologicaLocation("block/block_of_chromium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_COBALT.get(), new TechnologicaLocation("block/block_of_cobalt"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_CURIUM.get(), new TechnologicaLocation("block/block_of_curium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get(), new TechnologicaLocation("block/block_of_einsteinium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_FERMIUM.get(), new TechnologicaLocation("block/block_of_fermium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_GALLIUM.get(), new TechnologicaLocation("block/block_of_gallium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get(), new TechnologicaLocation("block/block_of_germanium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get(), new TechnologicaLocation("block/block_of_hafnium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_INDIUM.get(), new TechnologicaLocation("block/block_of_indium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_IODINE.get(), new TechnologicaLocation("block/block_of_iodine"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get(), new TechnologicaLocation("block/block_of_iridium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get(), new TechnologicaLocation("block/block_of_lawrencium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_LEAD.get(), new TechnologicaLocation("block/block_of_lead"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_LITHIUM.get(), new TechnologicaLocation("block/block_of_lithium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_MANGANESE.get(), new TechnologicaLocation("block/block_of_manganese"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get(), new TechnologicaLocation("block/block_of_molybdenum"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get(), new TechnologicaLocation("block/block_of_neptunium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_NICKEL.get(), new TechnologicaLocation("block/block_of_nickel"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get(), new TechnologicaLocation("block/block_of_niobium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_OSMIUM.get(), new TechnologicaLocation("block/block_of_osmium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get(), new TechnologicaLocation("block/block_of_palladium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get(), new TechnologicaLocation("block/block_of_phosphorus"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_PLATINUM.get(), new TechnologicaLocation("block/block_of_platinum"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get(), new TechnologicaLocation("block/block_of_plutonium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_POLONIUM.get(), new TechnologicaLocation("block/block_of_polonium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get(), new TechnologicaLocation("block/block_of_protactinium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_RHENIUM.get(), new TechnologicaLocation("block/block_of_rhenium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_RHODIUM.get(), new TechnologicaLocation("block/block_of_rhodium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_RUBY.get(), new TechnologicaLocation("block/block_of_ruby"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get(), new TechnologicaLocation("block/block_of_ruthenium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get(), new TechnologicaLocation("block/block_of_sapphire"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_SELENIUM.get(), new TechnologicaLocation("block/block_of_selenium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_SILICON.get(), new TechnologicaLocation("block/block_of_silicon"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_SILVER.get(), new TechnologicaLocation("block/block_of_silver"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_STEEL.get(), new TechnologicaLocation("block/block_of_steel"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_SULFUR.get(), new TechnologicaLocation("block/block_of_sulfur"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TANTALUM.get(), new TechnologicaLocation("block/block_of_tantalum"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get(), new TechnologicaLocation("block/block_of_technetium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get(), new TechnologicaLocation("block/block_of_tellurium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_THALLIUM.get(), new TechnologicaLocation("block/block_of_thallium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_THORIUM.get(), new TechnologicaLocation("block/block_of_thorium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TIN.get(), new TechnologicaLocation("block/block_of_tin"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TITANIUM.get(), new TechnologicaLocation("block/block_of_titanium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TOPAZ.get(), new TechnologicaLocation("block/block_of_topaz"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get(), new TechnologicaLocation("block/block_of_tungsten"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_URANIUM.get(), new TechnologicaLocation("block/block_of_uranium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_VANADIUM.get(), new TechnologicaLocation("block/block_of_vanadium"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ZINC.get(), new TechnologicaLocation("block/block_of_zinc"));
		models.cubeAll(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get(), new TechnologicaLocation("block/block_of_zirconium"));

		models.cubeAll(TechnologicaBlocks.LITHIUM_CLAY.get(), new TechnologicaLocation("block/lithium_clay"));
		models.cubeAll(TechnologicaBlocks.MOON_DUST.get(), new TechnologicaLocation("block/moon_dust"));
		models.cubeAll(TechnologicaBlocks.MOON_ROCK.get(), new TechnologicaLocation("block/moon_rock"));
		models.cubeAll(TechnologicaBlocks.OILY_COARSE_DIRT.get(), new TechnologicaLocation("block/oily_coarse_dirt"));
		models.cubeAll(TechnologicaBlocks.OILY_GRAVEL.get(), new TechnologicaLocation("block/oily_gravel"));
		models.cubeAll(TechnologicaBlocks.OILY_RED_SAND.get(), new TechnologicaLocation("block/oily_red_sand"));
		models.cubeAll(TechnologicaBlocks.OILY_SAND.get(), new TechnologicaLocation("block/oily_sand"));
		models.cubeAll(TechnologicaBlocks.SALT.get(), new TechnologicaLocation("block/salt"));
	}

	private void bookshelves() {
		models.cubeColumn(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), new TechnologicaLocation("block/acacia_bookshelf"), new ResourceLocation("block/acacia_planks"));
		models.cubeColumn(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), new TechnologicaLocation("block/alchemical_bookshelf"), new TechnologicaLocation("block/alchemical_planks"));
		models.cubeColumn(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), new TechnologicaLocation("block/apricot_bookshelf"), new TechnologicaLocation("block/apricot_planks"));
		models.cubeColumn(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), new TechnologicaLocation("block/aspen_bookshelf"), new TechnologicaLocation("block/aspen_planks"));
		models.cubeColumn(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), new TechnologicaLocation("block/avocado_bookshelf"), new TechnologicaLocation("block/avocado_planks"));
		models.cubeColumn(TechnologicaBlocks.BANANA_BOOKSHELF.get(), new TechnologicaLocation("block/banana_bookshelf"), new TechnologicaLocation("block/banana_planks"));
		models.cubeColumn(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/benevolent_bookshelf"), new TechnologicaLocation("block/benevolent_planks"));
		models.cubeColumn(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), new TechnologicaLocation("block/birch_bookshelf"), new ResourceLocation("block/birch_planks"));
		models.cubeColumn(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), new TechnologicaLocation("block/cherry_bookshelf"), new TechnologicaLocation("block/cherry_planks"));
		models.cubeColumn(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), new TechnologicaLocation("block/chestnut_bookshelf"), new TechnologicaLocation("block/chestnut_planks"));
		models.cubeColumn(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), new TechnologicaLocation("block/cinnamon_bookshelf"), new TechnologicaLocation("block/cinnamon_planks"));
		models.cubeColumn(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), new TechnologicaLocation("block/coconut_bookshelf"), new TechnologicaLocation("block/coconut_planks"));
		models.cubeColumn(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), new TechnologicaLocation("block/conductive_bookshelf"), new TechnologicaLocation("block/conductive_planks"));
		models.cubeColumn(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), new TechnologicaLocation("block/crimson_bookshelf"), new ResourceLocation("block/crimson_planks"));
		models.cubeColumn(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), new TechnologicaLocation("block/dark_oak_bookshelf"), new ResourceLocation("block/dark_oak_planks"));
		models.cubeColumn(TechnologicaBlocks.EBONY_BOOKSHELF.get(), new TechnologicaLocation("block/ebony_bookshelf"), new TechnologicaLocation("block/ebony_planks"));
		models.cubeColumn(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), new TechnologicaLocation("block/frostbitten_bookshelf"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.cubeColumn(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), new TechnologicaLocation("block/fruitful_bookshelf"), new TechnologicaLocation("block/fruitful_planks"));
		models.cubeColumn(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), new TechnologicaLocation("block/infernal_bookshelf"), new TechnologicaLocation("block/infernal_planks"));
		models.cubeColumn(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), new TechnologicaLocation("block/jungle_bookshelf"), new ResourceLocation("block/jungle_planks"));
		models.cubeColumn(TechnologicaBlocks.KIWI_BOOKSHELF.get(), new TechnologicaLocation("block/kiwi_bookshelf"), new TechnologicaLocation("block/kiwi_planks"));
		models.cubeColumn(TechnologicaBlocks.LEMON_BOOKSHELF.get(), new TechnologicaLocation("block/lemon_bookshelf"), new TechnologicaLocation("block/lemon_planks"));
		models.cubeColumn(TechnologicaBlocks.LIME_BOOKSHELF.get(), new TechnologicaLocation("block/lime_bookshelf"), new TechnologicaLocation("block/lime_planks"));
		models.cubeColumn(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), new TechnologicaLocation("block/mahogany_bookshelf"), new TechnologicaLocation("block/mahogany_planks"));
		models.cubeColumn(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/malevolent_bookshelf"), new TechnologicaLocation("block/malevolent_planks"));
		models.cubeColumn(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), new TechnologicaLocation("block/maple_bookshelf"), new TechnologicaLocation("block/maple_planks"));
		models.cubeColumn(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), new TechnologicaLocation("block/necrotic_bookshelf"), new TechnologicaLocation("block/necrotic_planks"));
		models.cubeColumn(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), new TechnologicaLocation("block/olive_bookshelf"), new TechnologicaLocation("block/olive_planks"));
		models.cubeColumn(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), new TechnologicaLocation("block/orange_bookshelf"), new TechnologicaLocation("block/orange_planks"));
		models.cubeColumn(TechnologicaBlocks.PEACH_BOOKSHELF.get(), new TechnologicaLocation("block/peach_bookshelf"), new TechnologicaLocation("block/peach_planks"));
		models.cubeColumn(TechnologicaBlocks.PEAR_BOOKSHELF.get(), new TechnologicaLocation("block/pear_bookshelf"), new TechnologicaLocation("block/pear_planks"));
		models.cubeColumn(TechnologicaBlocks.PLUM_BOOKSHELF.get(), new TechnologicaLocation("block/plum_bookshelf"), new TechnologicaLocation("block/plum_planks"));
		models.cubeColumn(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/redwood_bookshelf"), new TechnologicaLocation("block/redwood_planks"));
		models.cubeColumn(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/rosewood_bookshelf"), new TechnologicaLocation("block/rosewood_planks"));
		models.cubeColumn(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), new TechnologicaLocation("block/rubber_bookshelf"), new TechnologicaLocation("block/rubber_planks"));
		models.cubeColumn(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), new TechnologicaLocation("block/spruce_bookshelf"), new ResourceLocation("block/spruce_planks"));
		models.cubeColumn(TechnologicaBlocks.TEAK_BOOKSHELF.get(), new TechnologicaLocation("block/teak_bookshelf"), new TechnologicaLocation("block/teak_planks"));
		models.cubeColumn(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), new TechnologicaLocation("block/walnut_bookshelf"), new TechnologicaLocation("block/walnut_planks"));
		models.cubeColumn(TechnologicaBlocks.WARPED_BOOKSHELF.get(), new TechnologicaLocation("block/warped_bookshelf"), new ResourceLocation("block/warped_planks"));
		models.cubeColumn(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/zebrawood_bookshelf"), new TechnologicaLocation("block/zebrawood_planks"));
	}

	private void buttons() {
		models.buttonAll(TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.APRICOT_BUTTON.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.ASPEN_BUTTON.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.AVOCADO_BUTTON.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.BANANA_BUTTON.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.BENEVOLENT_BUTTON.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.CHERRY_BUTTON.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.CHESTNUT_BUTTON.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.CINNAMON_BUTTON.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.COCONUT_BUTTON.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.EBONY_BUTTON.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.buttonAll(TechnologicaBlocks.FRUITFUL_BUTTON.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.INFERNAL_BUTTON.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.KIWI_BUTTON.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.LEMON_BUTTON.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.LIME_BUTTON.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.MAHOGANY_BUTTON.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.MALEVOLENT_BUTTON.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.MAPLE_BUTTON.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.NECROTIC_BUTTON.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.OLIVE_BUTTON.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.ORANGE_BUTTON.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.PEACH_BUTTON.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.PEAR_BUTTON.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.PLUM_BUTTON.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.REDWOOD_BUTTON.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.ROSEWOOD_BUTTON.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.RUBBER_BUTTON.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.TEAK_BUTTON.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.WALNUT_BUTTON.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.buttonAll(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void chairs() {
		chair(TechnologicaBlocks.ACACIA_CHAIR.get(), new ResourceLocation("block/acacia_planks"), "solid");
		chair(TechnologicaBlocks.ALCHEMICAL_CHAIR.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		chair(TechnologicaBlocks.APRICOT_CHAIR.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		chair(TechnologicaBlocks.ASPEN_CHAIR.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		chair(TechnologicaBlocks.AVOCADO_CHAIR.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		chair(TechnologicaBlocks.BANANA_CHAIR.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		chair(TechnologicaBlocks.BENEVOLENT_CHAIR.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		chair(TechnologicaBlocks.BIRCH_CHAIR.get(), new ResourceLocation("block/birch_planks"), "solid");
		chair(TechnologicaBlocks.CHERRY_CHAIR.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		chair(TechnologicaBlocks.CHESTNUT_CHAIR.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		chair(TechnologicaBlocks.CINNAMON_CHAIR.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		chair(TechnologicaBlocks.COCONUT_CHAIR.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		chair(TechnologicaBlocks.CONDUCTIVE_CHAIR.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		chair(TechnologicaBlocks.CRIMSON_CHAIR.get(), new ResourceLocation("block/crimson_planks"), "solid");
		chair(TechnologicaBlocks.DARK_OAK_CHAIR.get(), new ResourceLocation("block/dark_oak_planks"), "solid");
		chair(TechnologicaBlocks.EBONY_CHAIR.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		chair(TechnologicaBlocks.FROSTBITTEN_CHAIR.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		chair(TechnologicaBlocks.FRUITFUL_CHAIR.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		chair(TechnologicaBlocks.INFERNAL_CHAIR.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		chair(TechnologicaBlocks.JUNGLE_CHAIR.get(), new ResourceLocation("block/jungle_planks"), "solid");
		chair(TechnologicaBlocks.KIWI_CHAIR.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		chair(TechnologicaBlocks.LEMON_CHAIR.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		chair(TechnologicaBlocks.LIME_CHAIR.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		chair(TechnologicaBlocks.MAHOGANY_CHAIR.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		chair(TechnologicaBlocks.MALEVOLENT_CHAIR.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		chair(TechnologicaBlocks.MAPLE_CHAIR.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		chair(TechnologicaBlocks.NECROTIC_CHAIR.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		chair(TechnologicaBlocks.OAK_CHAIR.get(), new ResourceLocation("block/oak_planks"), "solid");
		chair(TechnologicaBlocks.OLIVE_CHAIR.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		chair(TechnologicaBlocks.ORANGE_CHAIR.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		chair(TechnologicaBlocks.PEACH_CHAIR.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		chair(TechnologicaBlocks.PEAR_CHAIR.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		chair(TechnologicaBlocks.PLUM_CHAIR.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		chair(TechnologicaBlocks.REDWOOD_CHAIR.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		chair(TechnologicaBlocks.ROSEWOOD_CHAIR.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		chair(TechnologicaBlocks.RUBBER_CHAIR.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		chair(TechnologicaBlocks.SPRUCE_CHAIR.get(), new ResourceLocation("block/spruce_planks"), "solid");
		chair(TechnologicaBlocks.TEAK_CHAIR.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		chair(TechnologicaBlocks.WALNUT_CHAIR.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		chair(TechnologicaBlocks.WARPED_CHAIR.get(), new ResourceLocation("block/warped_planks"), "solid");
		chair(TechnologicaBlocks.ZEBRAWOOD_CHAIR.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void crops() {
		models.crop4Stage(TechnologicaBlocks.ASPARAGUS.get(), new TechnologicaLocation("block/asparagus"), "cutout");
		models.crop4Stage(TechnologicaBlocks.BROCCOLI.get(), new TechnologicaLocation("block/broccoli"), "cutout");
		models.crop4Stage(TechnologicaBlocks.CELERY.get(), new TechnologicaLocation("block/celery"), "cutout");
		models.crop4Stage(TechnologicaBlocks.CHILI_PEPPERS.get(), new TechnologicaLocation("block/chili_peppers"), "cutout");
		models.crop4Stage(TechnologicaBlocks.COFFEE.get(), new TechnologicaLocation("block/coffee"), "cutout");
		models.crop4Stage(TechnologicaBlocks.GARLIC.get(), new TechnologicaLocation("block/garlic"), "cutout");
		models.crop4Stage(TechnologicaBlocks.GINGER.get(), new TechnologicaLocation("block/ginger"), "cutout");
		models.crop4Stage(TechnologicaBlocks.LETTUCE.get(), new TechnologicaLocation("block/lettuce"), "cutout");
		models.crop4Stage(TechnologicaBlocks.MUSTARD_GREENS.get(), new TechnologicaLocation("block/mustard_greens"), "cutout");
		models.crop4Stage(TechnologicaBlocks.ONIONS.get(), new TechnologicaLocation("block/onions"), "cutout");
		models.crop4Stage(TechnologicaBlocks.PEANUTS.get(), new TechnologicaLocation("block/peanuts"), "cutout");
		models.crop4Stage(TechnologicaBlocks.PEAS.get(), new TechnologicaLocation("block/peas"), "cutout");
		models.crop4Stage(TechnologicaBlocks.PINEAPPLES.get(), new TechnologicaLocation("block/pineapples"), "cutout");
		models.crop4Stage(TechnologicaBlocks.PURPLE_CABBAGE.get(), new TechnologicaLocation("block/purple_cabbage"), "cutout");
		models.crop4Stage(TechnologicaBlocks.RADISHES.get(), new TechnologicaLocation("block/radishes"), "cutout");
		models.crop4Stage(TechnologicaBlocks.RED_BEANS.get(), new TechnologicaLocation("block/red_beans"), "cutout");
		models.crop4Stage(TechnologicaBlocks.SOY_BEANS.get(), new TechnologicaLocation("block/soy_beans"), "cutout");
		models.crop4Stage(TechnologicaBlocks.SWEET_POTATOES.get(), new TechnologicaLocation("block/sweet_potatoes"), "cutout");
		models.crop4Stage(TechnologicaBlocks.TEA.get(), new TechnologicaLocation("block/tea"), "cutout");
		models.crop4Stage(TechnologicaBlocks.TURNIPS.get(), new TechnologicaLocation("block/turnips"), "cutout");

		models.crop8Stage(TechnologicaBlocks.BARLEY.get(), new TechnologicaLocation("block/barley"), "cutout");
		models.crop8Stage(TechnologicaBlocks.OATS.get(), new TechnologicaLocation("block/oats"), "cutout");
		models.crop8Stage(TechnologicaBlocks.RYE.get(), new TechnologicaLocation("block/rye"), "cutout");

		cropTall8Stage(TechnologicaBlocks.CORN.get(), new TechnologicaLocation("block/corn"), "cutout");
		cropTall8Stage(TechnologicaBlocks.CRANBERRIES.get(), new TechnologicaLocation("block/cranberry"), "cutout");
		cropTall8Stage(TechnologicaBlocks.GRAPES.get(), new TechnologicaLocation("block/grapes"), "cutout");
		cropTall8Stage(TechnologicaBlocks.RICE.get(), new TechnologicaLocation("block/rice"), "cutout");
		cropTall8Stage(TechnologicaBlocks.TOMATOES.get(), new TechnologicaLocation("block/tomatoes"), "cutout");

		models.bush4Stage(TechnologicaBlocks.BLACKBERRY_BUSH.get(), new TechnologicaLocation("block/blackberry_bush"), "cutout_mipped");
		models.bush4Stage(TechnologicaBlocks.BLUEBERRY_BUSH.get(), new TechnologicaLocation("block/blueberry_bush"), "cutout_mipped");
		models.bush4Stage(TechnologicaBlocks.COTTON_BUSH.get(), new TechnologicaLocation("block/cotton_bush"), "cutout_mipped");
		models.bush4Stage(TechnologicaBlocks.RASPBERRY_BUSH.get(), new TechnologicaLocation("block/raspberry_bush"), "cutout_mipped");
		models.bush4Stage(TechnologicaBlocks.STRAWBERRY_BUSH.get(), new TechnologicaLocation("block/strawberry_bush"), "cutout_mipped");

		bushTall8Stage(TechnologicaBlocks.PEPPERCORNS.get(), new TechnologicaLocation("block/peppercorns"), "cutout_mipped");

		models.withExistingParent(models.name(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/cucumber_stem")).texture("upperstem", new TechnologicaLocation("block/attached_cucumber_stem")).renderType("cutout");
		models.withExistingParent(models.name(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/squash_stem")).texture("upperstem", new TechnologicaLocation("block/attached_squash_stem")).renderType("cutout");
		models.withExistingParent(models.name(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/zucchini_stem")).texture("upperstem", new TechnologicaLocation("block/attached_zucchini_stem")).renderType("cutout");

		models.withExistingParent(models.name(TechnologicaBlocks.CUCUMBERS.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/cucumbers")).renderType("cutout_mipped");
		models.withExistingParent(models.name(TechnologicaBlocks.SQUASH.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/squash")).renderType("cutout_mipped");
		models.withExistingParent(models.name(TechnologicaBlocks.ZUCCHINI.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/zucchini")).renderType("cutout_mipped");

		models.gourdStem8Stage(TechnologicaBlocks.CUCUMBER_STEM.get(), new TechnologicaLocation("block/cucumber_stem"), "cutout");
		models.gourdStem8Stage(TechnologicaBlocks.SQUASH_STEM.get(), new TechnologicaLocation("block/squash_stem"), "cutout");
		models.gourdStem8Stage(TechnologicaBlocks.ZUCCHINI_STEM.get(), new TechnologicaLocation("block/zucchini_stem"), "cutout");
	}

	private void crystals() {
		hexagonalCrystal(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), new TechnologicaLocation("block/aquamarine_crystal"));
		leafyCrystal(TechnologicaBlocks.AUTUNITE_CRYSTAL.get(), new TechnologicaLocation("block/autunite_crystal"));
		leafyCrystal(TechnologicaBlocks.BARYTE_CRYSTAL.get(), new TechnologicaLocation("block/baryte_crystal"));
		spikyCrystal(TechnologicaBlocks.BISMITHUNITE_CRYSTAL.get(), new TechnologicaLocation("block/bismithunite_crystal"));
		hexagonalCrystal(TechnologicaBlocks.CELESTINE_CRYSTAL.get(), new TechnologicaLocation("block/celestine_crystal"));
		cubicCrystal(TechnologicaBlocks.COLUMBITE_CRYSTAL.get(), new TechnologicaLocation("block/columbite_crystal"));
		cubicCrystal(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), new TechnologicaLocation("block/dolomite_crystal"));
		hexagonalCrystal(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), new TechnologicaLocation("block/fluorite_crystal"));
		spikyCrystal(TechnologicaBlocks.HUTCHINSONITE_CRYSTAL.get(), new TechnologicaLocation("block/hutchinsonite_crystal"));
		spikyCrystal(TechnologicaBlocks.MONAZITE_CRYSTAL.get(), new TechnologicaLocation("block/monazite_crystal"));
		leafyCrystal(TechnologicaBlocks.POLLUCITE_CRYSTAL.get(), new TechnologicaLocation("block/pollucite_crystal"));
		spikyCrystal(TechnologicaBlocks.RUTILE_CRYSTAL.get(), new TechnologicaLocation("block/rutile_crystal"));
		cubicCrystal(TechnologicaBlocks.SCHEELITE_CRYSTAL.get(), new TechnologicaLocation("block/scheelite_crystal"));
		cubicCrystal(TechnologicaBlocks.SPHALERITE_CRYSTAL.get(), new TechnologicaLocation("block/sphalerite_crystal"));
		spikyCrystal(TechnologicaBlocks.STIBNITE_CRYSTAL.get(), new TechnologicaLocation("block/stibnite_crystal"));
		spikyCrystal(TechnologicaBlocks.STRONTIANITE_CRYSTAL.get(), new TechnologicaLocation("block/strontianite_crystal"));
		hexagonalCrystal(TechnologicaBlocks.TELLURITE_CRYSTAL.get(), new TechnologicaLocation("block/tellurite_crystal"));
		hexagonalCrystal(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), new TechnologicaLocation("block/ulexite_crystal"));
		hexagonalCrystal(TechnologicaBlocks.VANADINITE_CRYSTAL.get(), new TechnologicaLocation("block/vanadinite_crystal"));
		leafyCrystal(TechnologicaBlocks.WULFENITE_CRYSTAL.get(), new TechnologicaLocation("block/wulfenite_crystal"));
		cubicCrystal(TechnologicaBlocks.XENOTIME_CRYSTAL.get(), new TechnologicaLocation("block/xenotime_crystal"));
		cubicCrystal(TechnologicaBlocks.ZIRCON_CRYSTAL.get(), new TechnologicaLocation("block/zircon_crystal"));
	}

	private void deepslateOres() {
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get(), new TechnologicaLocation("block/deepslate_apatite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get(), new TechnologicaLocation("block/deepslate_argentite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get(), new TechnologicaLocation("block/deepslate_arsenopyrite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get(), new TechnologicaLocation("block/deepslate_bastnaesite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get(), new TechnologicaLocation("block/deepslate_bauxite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get(), new TechnologicaLocation("block/deepslate_borax_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get(), new TechnologicaLocation("block/deepslate_cassiterite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get(), new TechnologicaLocation("block/deepslate_chromite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get(), new TechnologicaLocation("block/deepslate_cinnabar_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get(), new TechnologicaLocation("block/deepslate_cobaltite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get(), new TechnologicaLocation("block/deepslate_crookesite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get(), new TechnologicaLocation("block/deepslate_gadolinite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get(), new TechnologicaLocation("block/deepslate_galena_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get(), new TechnologicaLocation("block/deepslate_garnierite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get(), new TechnologicaLocation("block/deepslate_ilmenite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get(), new TechnologicaLocation("block/deepslate_lepidolite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get(), new TechnologicaLocation("block/deepslate_magnesite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), new TechnologicaLocation("block/deepslate_molybdenite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/deepslate_osmiridium_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get(), new TechnologicaLocation("block/deepslate_patronite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get(), new TechnologicaLocation("block/deepslate_pentlandite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get(), new TechnologicaLocation("block/deepslate_phosphorite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get(), new TechnologicaLocation("block/deepslate_platinum_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get(), new TechnologicaLocation("block/deepslate_pyrolusite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get(), new TechnologicaLocation("block/deepslate_ruby_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), new TechnologicaLocation("block/deepslate_sapphire_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get(), new TechnologicaLocation("block/deepslate_spodumene_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get(), new TechnologicaLocation("block/deepslate_sylvanite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get(), new TechnologicaLocation("block/deepslate_tantalite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get(), new TechnologicaLocation("block/deepslate_thorianite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get(), new TechnologicaLocation("block/deepslate_topaz_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get(), new TechnologicaLocation("block/deepslate_uraninite_ore"));
		models.cubeAll(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(), new TechnologicaLocation("block/deepslate_wolframite_ore"));
	}

	private void doors() {
		models.doorAll(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), new TechnologicaLocation("block/alchemical_door_bottom"), new TechnologicaLocation("block/alchemical_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.APRICOT_DOOR.get(), new TechnologicaLocation("block/apricot_door_bottom"), new TechnologicaLocation("block/apricot_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.ASPEN_DOOR.get(), new TechnologicaLocation("block/aspen_door_bottom"), new TechnologicaLocation("block/aspen_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.AVOCADO_DOOR.get(), new TechnologicaLocation("block/avocado_door_bottom"), new TechnologicaLocation("block/avocado_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.BANANA_DOOR.get(), new TechnologicaLocation("block/banana_door_bottom"), new TechnologicaLocation("block/banana_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.BENEVOLENT_DOOR.get(), new TechnologicaLocation("block/benevolent_door_bottom"), new TechnologicaLocation("block/benevolent_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.CHERRY_DOOR.get(), new TechnologicaLocation("block/cherry_door_bottom"), new TechnologicaLocation("block/cherry_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.CHESTNUT_DOOR.get(), new TechnologicaLocation("block/chestnut_door_bottom"), new TechnologicaLocation("block/chestnut_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.CINNAMON_DOOR.get(), new TechnologicaLocation("block/cinnamon_door_bottom"), new TechnologicaLocation("block/cinnamon_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.COCONUT_DOOR.get(), new TechnologicaLocation("block/coconut_door_bottom"), new TechnologicaLocation("block/coconut_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), new TechnologicaLocation("block/conductive_door_bottom"), new TechnologicaLocation("block/conductive_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.EBONY_DOOR.get(), new TechnologicaLocation("block/ebony_door_bottom"), new TechnologicaLocation("block/ebony_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), new TechnologicaLocation("block/frostbitten_door_bottom"), new TechnologicaLocation("block/frostbitten_door_top"), "translucent");
		models.doorAll(TechnologicaBlocks.FRUITFUL_DOOR.get(), new TechnologicaLocation("block/fruitful_door_bottom"), new TechnologicaLocation("block/fruitful_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.INFERNAL_DOOR.get(), new TechnologicaLocation("block/infernal_door_bottom"), new TechnologicaLocation("block/infernal_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.KIWI_DOOR.get(), new TechnologicaLocation("block/kiwi_door_bottom"), new TechnologicaLocation("block/kiwi_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.LEMON_DOOR.get(), new TechnologicaLocation("block/lemon_door_bottom"), new TechnologicaLocation("block/lemon_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.LIME_DOOR.get(), new TechnologicaLocation("block/lime_door_bottom"), new TechnologicaLocation("block/lime_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.MAHOGANY_DOOR.get(), new TechnologicaLocation("block/mahogany_door_bottom"), new TechnologicaLocation("block/mahogany_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.MALEVOLENT_DOOR.get(), new TechnologicaLocation("block/malevolent_door_bottom"), new TechnologicaLocation("block/malevolent_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.MAPLE_DOOR.get(), new TechnologicaLocation("block/maple_door_bottom"), new TechnologicaLocation("block/maple_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.NECROTIC_DOOR.get(), new TechnologicaLocation("block/necrotic_door_bottom"), new TechnologicaLocation("block/necrotic_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.OLIVE_DOOR.get(), new TechnologicaLocation("block/olive_door_bottom"), new TechnologicaLocation("block/olive_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.ORANGE_DOOR.get(), new TechnologicaLocation("block/orange_door_bottom"), new TechnologicaLocation("block/orange_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.PEACH_DOOR.get(), new TechnologicaLocation("block/peach_door_bottom"), new TechnologicaLocation("block/peach_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.PEAR_DOOR.get(), new TechnologicaLocation("block/pear_door_bottom"), new TechnologicaLocation("block/pear_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.PLUM_DOOR.get(), new TechnologicaLocation("block/plum_door_bottom"), new TechnologicaLocation("block/plum_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.REDWOOD_DOOR.get(), new TechnologicaLocation("block/redwood_door_bottom"), new TechnologicaLocation("block/redwood_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.ROSEWOOD_DOOR.get(), new TechnologicaLocation("block/rosewood_door_bottom"), new TechnologicaLocation("block/rosewood_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.RUBBER_DOOR.get(), new TechnologicaLocation("block/rubber_door_bottom"), new TechnologicaLocation("block/rubber_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.TEAK_DOOR.get(), new TechnologicaLocation("block/teak_door_bottom"), new TechnologicaLocation("block/teak_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.WALNUT_DOOR.get(), new TechnologicaLocation("block/walnut_door_bottom"), new TechnologicaLocation("block/walnut_door_top"), "cutout_mipped");
		models.doorAll(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), new TechnologicaLocation("block/zebrawood_door_bottom"), new TechnologicaLocation("block/zebrawood_door_top"), "cutout_mipped");
	}

	private void fences() {
		models.fenceAll(TechnologicaBlocks.ALCHEMICAL_FENCE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.APRICOT_FENCE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.ASPEN_FENCE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.AVOCADO_FENCE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.BANANA_FENCE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.BENEVOLENT_FENCE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.CHERRY_FENCE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.CHESTNUT_FENCE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.CINNAMON_FENCE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.COCONUT_FENCE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.CONDUCTIVE_FENCE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.EBONY_FENCE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.FROSTBITTEN_FENCE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.fenceAll(TechnologicaBlocks.FRUITFUL_FENCE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.INFERNAL_FENCE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.KIWI_FENCE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.LEMON_FENCE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.LIME_FENCE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.MAHOGANY_FENCE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.MALEVOLENT_FENCE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.MAPLE_FENCE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.NECROTIC_FENCE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.OLIVE_FENCE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.ORANGE_FENCE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.PEACH_FENCE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.PEAR_FENCE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.PLUM_FENCE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.REDWOOD_FENCE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.ROSEWOOD_FENCE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.RUBBER_FENCE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.TEAK_FENCE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.WALNUT_FENCE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.fenceAll(TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void fenceGates() {
		models.fenceGateAll(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.ASPEN_FENCE_GATE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.BANANA_FENCE_GATE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.CHERRY_FENCE_GATE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.COCONUT_FENCE_GATE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.EBONY_FENCE_GATE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.fenceGateAll(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.KIWI_FENCE_GATE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.LEMON_FENCE_GATE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.LIME_FENCE_GATE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.MAPLE_FENCE_GATE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.OLIVE_FENCE_GATE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.ORANGE_FENCE_GATE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.PEACH_FENCE_GATE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.PEAR_FENCE_GATE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.PLUM_FENCE_GATE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.RUBBER_FENCE_GATE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.TEAK_FENCE_GATE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.WALNUT_FENCE_GATE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.fenceGateAll(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void fluids() {
		models.fluid(TechnologicaBlocks.ARGON.get());
		models.fluid(TechnologicaBlocks.BRINE.get());
		models.fluid(TechnologicaBlocks.BROMINE.get());
		models.fluid(TechnologicaBlocks.CHLORINE.get());
		models.fluid(TechnologicaBlocks.COOLANT.get());
		models.fluid(TechnologicaBlocks.FLUORINE.get());
		models.fluid(TechnologicaBlocks.GASOLINE.get());
		models.fluid(TechnologicaBlocks.HELIUM.get());
		models.fluid(TechnologicaBlocks.HYDROGEN.get());
		models.fluid(TechnologicaBlocks.KRYPTON.get());
		models.fluid(TechnologicaBlocks.MACHINE_OIL.get());
		models.fluid(TechnologicaBlocks.MAPLE_SYRUP.get());
		models.fluid(TechnologicaBlocks.MERCURY.get());
		models.fluid(TechnologicaBlocks.NATURAL_GAS.get());
		models.fluid(TechnologicaBlocks.NEON.get());
		models.fluid(TechnologicaBlocks.NITROGEN.get());
		models.fluid(TechnologicaBlocks.OIL.get());
		models.fluid(TechnologicaBlocks.OXYGEN.get());
		models.fluid(TechnologicaBlocks.RADON.get());
		models.fluid(TechnologicaBlocks.RUBBER_RESIN.get());
		models.fluid(TechnologicaBlocks.XENON.get());
		models.fluid(TechnologicaBlocks.MOLTEN_CORE.get());
	}

	private void leaves() {
		models.cubeAll(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), new TechnologicaLocation("block/alchemical_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.APRICOT_LEAVES.get(), new TechnologicaLocation("block/apricot_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.ASPEN_LEAVES.get(), new TechnologicaLocation("block/aspen_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.AVOCADO_LEAVES.get(), new TechnologicaLocation("block/avocado_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.BANANA_LEAVES.get(), new TechnologicaLocation("block/banana_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), new TechnologicaLocation("block/benevolent_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.CHERRY_LEAVES.get(), new TechnologicaLocation("block/cherry_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.CHESTNUT_LEAVES.get(), new TechnologicaLocation("block/chestnut_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.CINNAMON_LEAVES.get(), new TechnologicaLocation("block/cinnamon_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.COCONUT_LEAVES.get(), new TechnologicaLocation("block/coconut_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), new TechnologicaLocation("block/conductive_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.CURSED_LEAVES.get(), new TechnologicaLocation("block/cursed_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.EBONY_LEAVES.get(), new TechnologicaLocation("block/ebony_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), new TechnologicaLocation("block/frostbitten_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.FRUITFUL_LEAVES.get(), new TechnologicaLocation("block/fruitful_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.KIWI_LEAVES.get(), new TechnologicaLocation("block/kiwi_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.LEMON_LEAVES.get(), new TechnologicaLocation("block/lemon_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.LIME_LEAVES.get(), new TechnologicaLocation("block/lime_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.MAHOGANY_LEAVES.get(), new TechnologicaLocation("block/mahogany_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), new TechnologicaLocation("block/malevolent_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.MAPLE_LEAVES.get(), new TechnologicaLocation("block/maple_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.OLIVE_LEAVES.get(), new TechnologicaLocation("block/olive_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.ORANGE_LEAVES.get(), new TechnologicaLocation("block/orange_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.PEACH_LEAVES.get(), new TechnologicaLocation("block/peach_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.PEAR_LEAVES.get(), new TechnologicaLocation("block/pear_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.PLUM_LEAVES.get(), new TechnologicaLocation("block/plum_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.REDWOOD_LEAVES.get(), new TechnologicaLocation("block/redwood_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), new TechnologicaLocation("block/rosewood_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.RUBBER_LEAVES.get(), new TechnologicaLocation("block/rubber_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.TEAK_LEAVES.get(), new TechnologicaLocation("block/teak_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.WALNUT_LEAVES.get(), new TechnologicaLocation("block/walnut_leaves"), "cutout_mipped");
		models.cubeAll(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), new TechnologicaLocation("block/zebrawood_leaves"), "cutout_mipped");
	}

	private void logs() {
		models.logAll(TechnologicaBlocks.ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/alchemical_log"), new TechnologicaLocation("block/alchemical_log_top"));
		models.logAll(TechnologicaBlocks.APRICOT_LOG.get(), new TechnologicaLocation("block/apricot_log"), new TechnologicaLocation("block/apricot_log_top"));
		models.logAll(TechnologicaBlocks.ASPEN_LOG.get(), new TechnologicaLocation("block/aspen_log"), new TechnologicaLocation("block/aspen_log_top"));
		models.logAll(TechnologicaBlocks.AVOCADO_LOG.get(), new TechnologicaLocation("block/avocado_log"), new TechnologicaLocation("block/avocado_log_top"));
		models.logAll(TechnologicaBlocks.BANANA_LOG.get(), new TechnologicaLocation("block/banana_log"), new TechnologicaLocation("block/banana_log_top"));
		models.logAll(TechnologicaBlocks.BENEVOLENT_LOG.get(), new TechnologicaLocation("block/benevolent_log"), new TechnologicaLocation("block/benevolent_log_top"));
		models.logAll(TechnologicaBlocks.CHERRY_LOG.get(), new TechnologicaLocation("block/cherry_log"), new TechnologicaLocation("block/cherry_log_top"));
		models.logAll(TechnologicaBlocks.CHESTNUT_LOG.get(), new TechnologicaLocation("block/chestnut_log"), new TechnologicaLocation("block/chestnut_log_top"));
		models.logAll(TechnologicaBlocks.CINNAMON_LOG.get(), new TechnologicaLocation("block/cinnamon_log"), new TechnologicaLocation("block/cinnamon_log_top"));
		models.logAll(TechnologicaBlocks.COCONUT_LOG.get(), new TechnologicaLocation("block/coconut_log"), new TechnologicaLocation("block/coconut_log_top"));
		models.logAll(TechnologicaBlocks.CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/conductive_log"), new TechnologicaLocation("block/conductive_log_top"));
		models.logAll(TechnologicaBlocks.EBONY_LOG.get(), new TechnologicaLocation("block/ebony_log"), new TechnologicaLocation("block/ebony_log_top"));
		models.withExistingParent(models.name(TechnologicaBlocks.FROSTBITTEN_LOG.get()), new TechnologicaLocation("block/hollow_log")).texture("end", new TechnologicaLocation("block/frostbitten_log_top")).texture("inside", new TechnologicaLocation("block/stripped_frostbitten_log_solid")).texture("side", new TechnologicaLocation("block/frostbitten_log")).renderType("translucent");
		models.logAll(TechnologicaBlocks.FRUITFUL_LOG.get(), new TechnologicaLocation("block/fruitful_log"), new TechnologicaLocation("block/fruitful_log_top"));
		models.logAll(TechnologicaBlocks.INFERNAL_LOG.get(), new TechnologicaLocation("block/infernal_log"), new TechnologicaLocation("block/infernal_log_top"));
		models.logAll(TechnologicaBlocks.KIWI_LOG.get(), new TechnologicaLocation("block/kiwi_log"), new TechnologicaLocation("block/kiwi_log_top"));
		models.logAll(TechnologicaBlocks.LEMON_LOG.get(), new TechnologicaLocation("block/lemon_log"), new TechnologicaLocation("block/lemon_log_top"));
		models.logAll(TechnologicaBlocks.LIME_LOG.get(), new TechnologicaLocation("block/lime_log"), new TechnologicaLocation("block/lime_log_top"));
		models.logAll(TechnologicaBlocks.MAHOGANY_LOG.get(), new TechnologicaLocation("block/mahogany_log"), new TechnologicaLocation("block/mahogany_log_top"));
		models.logAll(TechnologicaBlocks.MALEVOLENT_LOG.get(), new TechnologicaLocation("block/malevolent_log"), new TechnologicaLocation("block/malevolent_log_top"));
		models.logAll(TechnologicaBlocks.MAPLE_LOG.get(), new TechnologicaLocation("block/maple_log"), new TechnologicaLocation("block/maple_log_top"));
		models.logAll(TechnologicaBlocks.NECROTIC_LOG.get(), new TechnologicaLocation("block/necrotic_log"), new TechnologicaLocation("block/necrotic_log_top"));
		models.logAll(TechnologicaBlocks.OLIVE_LOG.get(), new TechnologicaLocation("block/olive_log"), new TechnologicaLocation("block/olive_log_top"));
		models.logAll(TechnologicaBlocks.ORANGE_LOG.get(), new TechnologicaLocation("block/orange_log"), new TechnologicaLocation("block/orange_log_top"));
		models.logAll(TechnologicaBlocks.PEACH_LOG.get(), new TechnologicaLocation("block/peach_log"), new TechnologicaLocation("block/peach_log_top"));
		models.logAll(TechnologicaBlocks.PEAR_LOG.get(), new TechnologicaLocation("block/pear_log"), new TechnologicaLocation("block/pear_log_top"));
		models.logAll(TechnologicaBlocks.PLUM_LOG.get(), new TechnologicaLocation("block/plum_log"), new TechnologicaLocation("block/plum_log_top"));
		models.logAll(TechnologicaBlocks.REDWOOD_LOG.get(), new TechnologicaLocation("block/redwood_log"), new TechnologicaLocation("block/redwood_log_top"));
		models.logAll(TechnologicaBlocks.ROSEWOOD_LOG.get(), new TechnologicaLocation("block/rosewood_log"), new TechnologicaLocation("block/rosewood_log_top"));
		models.logAll(TechnologicaBlocks.RUBBER_LOG.get(), new TechnologicaLocation("block/rubber_log"), new TechnologicaLocation("block/rubber_log_top"));
		models.logAll(TechnologicaBlocks.TEAK_LOG.get(), new TechnologicaLocation("block/teak_log"), new TechnologicaLocation("block/teak_log_top"));
		models.logAll(TechnologicaBlocks.WALNUT_LOG.get(), new TechnologicaLocation("block/walnut_log"), new TechnologicaLocation("block/walnut_log_top"));
		models.logAll(TechnologicaBlocks.ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/zebrawood_log"), new TechnologicaLocation("block/zebrawood_log_top"));
	}

	private void netherOres() {
		models.cubeAll(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get(), new TechnologicaLocation("block/nether_argentite_ore"));
		models.cubeAll(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/nether_osmiridium_ore"));
		models.cubeAll(TechnologicaBlocks.NETHER_PLATINUM_ORE.get(), new TechnologicaLocation("block/nether_platinum_ore"));
		models.cubeAll(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get(), new TechnologicaLocation("block/nether_sylvanite_ore"));
	}

	private void ores() {
		models.cubeAll(TechnologicaBlocks.APATITE_ORE.get(), new TechnologicaLocation("block/apatite_ore"));
		models.cubeAll(TechnologicaBlocks.ARGENTITE_ORE.get(), new TechnologicaLocation("block/argentite_ore"));
		models.cubeAll(TechnologicaBlocks.ARSENOPYRITE_ORE.get(), new TechnologicaLocation("block/arsenopyrite_ore"));
		models.cubeAll(TechnologicaBlocks.BASTNAESITE_ORE.get(), new TechnologicaLocation("block/bastnaesite_ore"));
		models.cubeAll(TechnologicaBlocks.BAUXITE_ORE.get(), new TechnologicaLocation("block/bauxite_ore"));
		models.cubeAll(TechnologicaBlocks.BORAX_ORE.get(), new TechnologicaLocation("block/borax_ore"));
		models.cubeAll(TechnologicaBlocks.CASSITERITE_ORE.get(), new TechnologicaLocation("block/cassiterite_ore"));
		models.cubeAll(TechnologicaBlocks.CHROMITE_ORE.get(), new TechnologicaLocation("block/chromite_ore"));
		models.cubeAll(TechnologicaBlocks.CINNABAR_ORE.get(), new TechnologicaLocation("block/cinnabar_ore"));
		models.cubeAll(TechnologicaBlocks.COBALTITE_ORE.get(), new TechnologicaLocation("block/cobaltite_ore"));
		models.cubeAll(TechnologicaBlocks.CROOKESITE_ORE.get(), new TechnologicaLocation("block/crookesite_ore"));
		models.cubeAll(TechnologicaBlocks.GADOLINITE_ORE.get(), new TechnologicaLocation("block/gadolinite_ore"));
		models.cubeAll(TechnologicaBlocks.GALENA_ORE.get(), new TechnologicaLocation("block/galena_ore"));
		models.cubeAll(TechnologicaBlocks.GARNIERITE_ORE.get(), new TechnologicaLocation("block/garnierite_ore"));
		models.cubeAll(TechnologicaBlocks.ILMENITE_ORE.get(), new TechnologicaLocation("block/ilmenite_ore"));
		models.cubeAll(TechnologicaBlocks.LEPIDOLITE_ORE.get(), new TechnologicaLocation("block/lepidolite_ore"));
		models.cubeAll(TechnologicaBlocks.MAGNESITE_ORE.get(), new TechnologicaLocation("block/magnesite_ore"));
		models.cubeAll(TechnologicaBlocks.MOLYBDENITE_ORE.get(), new TechnologicaLocation("block/molybdenite_ore"));
		models.cubeAll(TechnologicaBlocks.OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/osmiridium_ore"));
		models.cubeAll(TechnologicaBlocks.PATRONITE_ORE.get(), new TechnologicaLocation("block/patronite_ore"));
		models.cubeAll(TechnologicaBlocks.PENTLANDITE_ORE.get(), new TechnologicaLocation("block/pentlandite_ore"));
		models.cubeAll(TechnologicaBlocks.PHOSPHORITE_ORE.get(), new TechnologicaLocation("block/phosphorite_ore"));
		models.cubeAll(TechnologicaBlocks.PLATINUM_ORE.get(), new TechnologicaLocation("block/platinum_ore"));
		models.cubeAll(TechnologicaBlocks.PYROLUSITE_ORE.get(), new TechnologicaLocation("block/pyrolusite_ore"));
		models.cubeAll(TechnologicaBlocks.RUBY_ORE.get(), new TechnologicaLocation("block/ruby_ore"));
		models.cubeAll(TechnologicaBlocks.SAPPHIRE_ORE.get(), new TechnologicaLocation("block/sapphire_ore"));
		models.cubeAll(TechnologicaBlocks.SPODUMENE_ORE.get(), new TechnologicaLocation("block/spodumene_ore"));
		models.cubeAll(TechnologicaBlocks.SYLVANITE_ORE.get(), new TechnologicaLocation("block/sylvanite_ore"));
		models.cubeAll(TechnologicaBlocks.TANTALITE_ORE.get(), new TechnologicaLocation("block/tantalite_ore"));
		models.cubeAll(TechnologicaBlocks.THORIANITE_ORE.get(), new TechnologicaLocation("block/thorianite_ore"));
		models.cubeAll(TechnologicaBlocks.TOPAZ_ORE.get(), new TechnologicaLocation("block/topaz_ore"));
		models.cubeAll(TechnologicaBlocks.URANINITE_ORE.get(), new TechnologicaLocation("block/uraninite_ore"));
		models.cubeAll(TechnologicaBlocks.WOLFRAMITE_ORE.get(), new TechnologicaLocation("block/wolframite_ore"));
	}

	private void planks() {
		models.cubeAll(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.APRICOT_PLANKS.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.ASPEN_PLANKS.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.AVOCADO_PLANKS.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.BANANA_PLANKS.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.CHERRY_PLANKS.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.CHESTNUT_PLANKS.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.CINNAMON_PLANKS.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.COCONUT_PLANKS.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.EBONY_PLANKS.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.cubeAll(TechnologicaBlocks.FRUITFUL_PLANKS.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.INFERNAL_PLANKS.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.KIWI_PLANKS.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.LEMON_PLANKS.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.LIME_PLANKS.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.MAHOGANY_PLANKS.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.MAPLE_PLANKS.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.NECROTIC_PLANKS.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.OLIVE_PLANKS.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.ORANGE_PLANKS.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.PEACH_PLANKS.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.PEAR_PLANKS.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.PLUM_PLANKS.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.REDWOOD_PLANKS.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.RUBBER_PLANKS.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.TEAK_PLANKS.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.WALNUT_PLANKS.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.cubeAll(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void pottedSaplings() {
		models.pottedSapling(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), new TechnologicaLocation("block/ancient_ambrosia_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), new TechnologicaLocation("block/apricot_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), new TechnologicaLocation("block/aspen_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), new TechnologicaLocation("block/avocado_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), new TechnologicaLocation("block/banana_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/benevolent_apothecary_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), new TechnologicaLocation("block/cherry_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), new TechnologicaLocation("block/chestnut_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), new TechnologicaLocation("block/cinnamon_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), new TechnologicaLocation("block/coconut_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), new TechnologicaLocation("block/cryogenic_spire_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), new TechnologicaLocation("block/ebony_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), new TechnologicaLocation("block/kiwi_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), new TechnologicaLocation("block/lemon_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), new TechnologicaLocation("block/lime_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), new TechnologicaLocation("block/mahogany_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), new TechnologicaLocation("block/maple_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/malevolent_apothecary_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), new TechnologicaLocation("block/necrotic_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), new TechnologicaLocation("block/olive_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), new TechnologicaLocation("block/orange_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), new TechnologicaLocation("block/peach_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), new TechnologicaLocation("block/pear_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), new TechnologicaLocation("block/plum_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), new TechnologicaLocation("block/redwood_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), new TechnologicaLocation("block/rosewood_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), new TechnologicaLocation("block/rubber_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/serendipitous_apothecary_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), new TechnologicaLocation("block/thunderous_conductor_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), new TechnologicaLocation("block/towering_inferno_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), new TechnologicaLocation("block/teak_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), new TechnologicaLocation("block/walnut_sapling"), "cutout_mipped");
		models.pottedSapling(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), new TechnologicaLocation("block/zebrawood_sapling"), "cutout_mipped");
	}

	private void pressurePlates() {
		models.pressurePlateAll(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.pressurePlateAll(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.pressurePlateAll(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void saplings() {
		models.sapling(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), new TechnologicaLocation("block/ancient_ambrosia_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.APRICOT_SAPLING.get(), new TechnologicaLocation("block/apricot_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.ASPEN_SAPLING.get(), new TechnologicaLocation("block/aspen_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.AVOCADO_SAPLING.get(), new TechnologicaLocation("block/avocado_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.BANANA_SAPLING.get(), new TechnologicaLocation("block/banana_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/benevolent_apothecary_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.CHERRY_SAPLING.get(), new TechnologicaLocation("block/cherry_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.CHESTNUT_SAPLING.get(), new TechnologicaLocation("block/chestnut_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.CINNAMON_SAPLING.get(), new TechnologicaLocation("block/cinnamon_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.COCONUT_SAPLING.get(), new TechnologicaLocation("block/coconut_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), new TechnologicaLocation("block/cryogenic_spire_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.EBONY_SAPLING.get(), new TechnologicaLocation("block/ebony_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.KIWI_SAPLING.get(), new TechnologicaLocation("block/kiwi_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.LEMON_SAPLING.get(), new TechnologicaLocation("block/lemon_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.LIME_SAPLING.get(), new TechnologicaLocation("block/lime_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.MAHOGANY_SAPLING.get(), new TechnologicaLocation("block/mahogany_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.MAPLE_SAPLING.get(), new TechnologicaLocation("block/maple_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/malevolent_apothecary_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.NECROTIC_SAPLING.get(), new TechnologicaLocation("block/necrotic_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.OLIVE_SAPLING.get(), new TechnologicaLocation("block/olive_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.ORANGE_SAPLING.get(), new TechnologicaLocation("block/orange_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.PEACH_SAPLING.get(), new TechnologicaLocation("block/peach_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.PEAR_SAPLING.get(), new TechnologicaLocation("block/pear_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.PLUM_SAPLING.get(), new TechnologicaLocation("block/plum_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.REDWOOD_SAPLING.get(), new TechnologicaLocation("block/redwood_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), new TechnologicaLocation("block/rosewood_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.RUBBER_SAPLING.get(), new TechnologicaLocation("block/rubber_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/serendipitous_apothecary_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), new TechnologicaLocation("block/thunderous_conductor_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), new TechnologicaLocation("block/towering_inferno_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.TEAK_SAPLING.get(), new TechnologicaLocation("block/teak_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.WALNUT_SAPLING.get(), new TechnologicaLocation("block/walnut_sapling"), "cutout_mipped");
		models.sapling(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), new TechnologicaLocation("block/zebrawood_sapling"), "cutout_mipped");
	}

	private void signs() {
		models.sign(TechnologicaBlocks.ALCHEMICAL_SIGN.get(), new TechnologicaLocation("block/alchemical_planks"), "cutout");
		models.sign(TechnologicaBlocks.APRICOT_SIGN.get(), new TechnologicaLocation("block/apricot_planks"), "cutout");
		models.sign(TechnologicaBlocks.ASPEN_SIGN.get(), new TechnologicaLocation("block/aspen_planks"), "cutout");
		models.sign(TechnologicaBlocks.AVOCADO_SIGN.get(), new TechnologicaLocation("block/avocado_planks"), "cutout");
		models.sign(TechnologicaBlocks.BANANA_SIGN.get(), new TechnologicaLocation("block/banana_planks"), "cutout");
		models.sign(TechnologicaBlocks.BENEVOLENT_SIGN.get(), new TechnologicaLocation("block/benevolent_planks"), "cutout");
		models.sign(TechnologicaBlocks.CHERRY_SIGN.get(), new TechnologicaLocation("block/cherry_planks"), "cutout");
		models.sign(TechnologicaBlocks.CHESTNUT_SIGN.get(), new TechnologicaLocation("block/chestnut_planks"), "cutout");
		models.sign(TechnologicaBlocks.CINNAMON_SIGN.get(), new TechnologicaLocation("block/cinnamon_planks"), "cutout");
		models.sign(TechnologicaBlocks.COCONUT_SIGN.get(), new TechnologicaLocation("block/coconut_planks"), "cutout");
		models.sign(TechnologicaBlocks.CONDUCTIVE_SIGN.get(), new TechnologicaLocation("block/conductive_planks"), "cutout");
		models.sign(TechnologicaBlocks.EBONY_SIGN.get(), new TechnologicaLocation("block/ebony_planks"), "cutout");
		models.sign(TechnologicaBlocks.FROSTBITTEN_SIGN.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.sign(TechnologicaBlocks.FRUITFUL_SIGN.get(), new TechnologicaLocation("block/fruitful_planks"), "cutout");
		models.sign(TechnologicaBlocks.INFERNAL_SIGN.get(), new TechnologicaLocation("block/infernal_planks"), "cutout");
		models.sign(TechnologicaBlocks.KIWI_SIGN.get(), new TechnologicaLocation("block/kiwi_planks"), "cutout");
		models.sign(TechnologicaBlocks.LEMON_SIGN.get(), new TechnologicaLocation("block/lemon_planks"), "cutout");
		models.sign(TechnologicaBlocks.LIME_SIGN.get(), new TechnologicaLocation("block/lime_planks"), "cutout");
		models.sign(TechnologicaBlocks.MAHOGANY_SIGN.get(), new TechnologicaLocation("block/mahogany_planks"), "cutout");
		models.sign(TechnologicaBlocks.MALEVOLENT_SIGN.get(), new TechnologicaLocation("block/malevolent_planks"), "cutout");
		models.sign(TechnologicaBlocks.MAPLE_SIGN.get(), new TechnologicaLocation("block/maple_planks"), "cutout");
		models.sign(TechnologicaBlocks.NECROTIC_SIGN.get(), new TechnologicaLocation("block/necrotic_planks"), "cutout");
		models.sign(TechnologicaBlocks.OLIVE_SIGN.get(), new TechnologicaLocation("block/olive_planks"), "cutout");
		models.sign(TechnologicaBlocks.ORANGE_SIGN.get(), new TechnologicaLocation("block/orange_planks"), "cutout");
		models.sign(TechnologicaBlocks.PEACH_SIGN.get(), new TechnologicaLocation("block/peach_planks"), "cutout");
		models.sign(TechnologicaBlocks.PEAR_SIGN.get(), new TechnologicaLocation("block/pear_planks"), "cutout");
		models.sign(TechnologicaBlocks.PLUM_SIGN.get(), new TechnologicaLocation("block/plum_planks"), "cutout");
		models.sign(TechnologicaBlocks.REDWOOD_SIGN.get(), new TechnologicaLocation("block/redwood_planks"), "cutout");
		models.sign(TechnologicaBlocks.ROSEWOOD_SIGN.get(), new TechnologicaLocation("block/rosewood_planks"), "cutout");
		models.sign(TechnologicaBlocks.RUBBER_SIGN.get(), new TechnologicaLocation("block/rubber_planks"), "cutout");
		models.sign(TechnologicaBlocks.TEAK_SIGN.get(), new TechnologicaLocation("block/teak_planks"), "cutout");
		models.sign(TechnologicaBlocks.WALNUT_SIGN.get(), new TechnologicaLocation("block/walnut_planks"), "cutout");
		models.sign(TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), new TechnologicaLocation("block/zebrawood_planks"), "cutout");
	}

	private void slabs() {
		models.slabAll(TechnologicaBlocks.ALCHEMICAL_SLAB.get(), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.slabAll(TechnologicaBlocks.APRICOT_SLAB.get(), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.slabAll(TechnologicaBlocks.ASPEN_SLAB.get(), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.slabAll(TechnologicaBlocks.AVOCADO_SLAB.get(), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.slabAll(TechnologicaBlocks.BANANA_SLAB.get(), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), "solid");
		models.slabAll(TechnologicaBlocks.BENEVOLENT_SLAB.get(), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.slabAll(TechnologicaBlocks.CHERRY_SLAB.get(), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.slabAll(TechnologicaBlocks.CHESTNUT_SLAB.get(), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.slabAll(TechnologicaBlocks.CINNAMON_SLAB.get(), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.slabAll(TechnologicaBlocks.COCONUT_SLAB.get(), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.slabAll(TechnologicaBlocks.CONDUCTIVE_SLAB.get(), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.slabAll(TechnologicaBlocks.EBONY_SLAB.get(), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.slabAll(TechnologicaBlocks.FROSTBITTEN_SLAB.get(), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.slabAll(TechnologicaBlocks.FRUITFUL_SLAB.get(), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.slabAll(TechnologicaBlocks.INFERNAL_SLAB.get(), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.slabAll(TechnologicaBlocks.KIWI_SLAB.get(), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.slabAll(TechnologicaBlocks.LEMON_SLAB.get(), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.slabAll(TechnologicaBlocks.LIME_SLAB.get(), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), "solid");
		models.slabAll(TechnologicaBlocks.MAHOGANY_SLAB.get(), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.slabAll(TechnologicaBlocks.MALEVOLENT_SLAB.get(), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.slabAll(TechnologicaBlocks.MAPLE_SLAB.get(), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), "solid");
		models.slabAll(TechnologicaBlocks.NECROTIC_SLAB.get(), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.slabAll(TechnologicaBlocks.OLIVE_SLAB.get(), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), "solid");
		models.slabAll(TechnologicaBlocks.ORANGE_SLAB.get(), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), "solid");
		models.slabAll(TechnologicaBlocks.PEACH_SLAB.get(), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), "solid");
		models.slabAll(TechnologicaBlocks.PEAR_SLAB.get(), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), "solid");
		models.slabAll(TechnologicaBlocks.PLUM_SLAB.get(), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), "solid");
		models.slabAll(TechnologicaBlocks.REDWOOD_SLAB.get(), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.slabAll(TechnologicaBlocks.ROSEWOOD_SLAB.get(), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.slabAll(TechnologicaBlocks.RUBBER_SLAB.get(), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.slabAll(TechnologicaBlocks.TEAK_SLAB.get(), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), "solid");
		models.slabAll(TechnologicaBlocks.WALNUT_SLAB.get(), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.slabAll(TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void stairs() {
		models.stairsAll(TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.APRICOT_STAIRS.get(), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.ASPEN_STAIRS.get(), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.AVOCADO_STAIRS.get(), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.BANANA_STAIRS.get(), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.BENEVOLENT_STAIRS.get(), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.CHERRY_STAIRS.get(), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.CHESTNUT_STAIRS.get(), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.CINNAMON_STAIRS.get(), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.COCONUT_STAIRS.get(), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.EBONY_STAIRS.get(), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		models.stairsAll(TechnologicaBlocks.FRUITFUL_STAIRS.get(), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.INFERNAL_STAIRS.get(), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.KIWI_STAIRS.get(), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.LEMON_STAIRS.get(), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.LIME_STAIRS.get(), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.MAHOGANY_STAIRS.get(), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.MALEVOLENT_STAIRS.get(), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.MAPLE_STAIRS.get(), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.NECROTIC_STAIRS.get(), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.OLIVE_STAIRS.get(), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.ORANGE_STAIRS.get(), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.PEACH_STAIRS.get(), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.PEAR_STAIRS.get(), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.PLUM_STAIRS.get(), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.REDWOOD_STAIRS.get(), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.ROSEWOOD_STAIRS.get(), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.RUBBER_STAIRS.get(), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.TEAK_STAIRS.get(), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.WALNUT_STAIRS.get(), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), "solid");
		models.stairsAll(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void strippedLogs() {
		models.logAll(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/stripped_alchemical_log"), new TechnologicaLocation("block/stripped_alchemical_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), new TechnologicaLocation("block/stripped_apricot_log"), new TechnologicaLocation("block/stripped_apricot_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), new TechnologicaLocation("block/stripped_aspen_log"), new TechnologicaLocation("block/stripped_aspen_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), new TechnologicaLocation("block/stripped_avocado_log"), new TechnologicaLocation("block/stripped_avocado_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), new TechnologicaLocation("block/stripped_banana_log"), new TechnologicaLocation("block/stripped_banana_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_benevolent_log"), new TechnologicaLocation("block/stripped_benevolent_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), new TechnologicaLocation("block/stripped_cherry_log"), new TechnologicaLocation("block/stripped_cherry_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), new TechnologicaLocation("block/stripped_chestnut_log"), new TechnologicaLocation("block/stripped_chestnut_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), new TechnologicaLocation("block/stripped_cinnamon_log"), new TechnologicaLocation("block/stripped_cinnamon_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), new TechnologicaLocation("block/stripped_coconut_log"), new TechnologicaLocation("block/stripped_coconut_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/stripped_conductive_log"), new TechnologicaLocation("block/stripped_conductive_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), new TechnologicaLocation("block/stripped_ebony_log"), new TechnologicaLocation("block/stripped_ebony_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), new TechnologicaLocation("block/stripped_frostbitten_log"), new TechnologicaLocation("block/stripped_frostbitten_log_top"), "translucent");
		models.logAll(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), new TechnologicaLocation("block/stripped_fruitful_log"), new TechnologicaLocation("block/stripped_fruitful_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), new TechnologicaLocation("block/stripped_infernal_log"), new TechnologicaLocation("block/stripped_infernal_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), new TechnologicaLocation("block/stripped_kiwi_log"), new TechnologicaLocation("block/stripped_kiwi_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), new TechnologicaLocation("block/stripped_lemon_log"), new TechnologicaLocation("block/stripped_lemon_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_LIME_LOG.get(), new TechnologicaLocation("block/stripped_lime_log"), new TechnologicaLocation("block/stripped_lime_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), new TechnologicaLocation("block/stripped_mahogany_log"), new TechnologicaLocation("block/stripped_mahogany_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_malevolent_log"), new TechnologicaLocation("block/stripped_malevolent_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), new TechnologicaLocation("block/stripped_maple_log"), new TechnologicaLocation("block/stripped_maple_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get(), new TechnologicaLocation("block/stripped_necrotic_log"), new TechnologicaLocation("block/stripped_necrotic_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), new TechnologicaLocation("block/stripped_olive_log"), new TechnologicaLocation("block/stripped_olive_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), new TechnologicaLocation("block/stripped_orange_log"), new TechnologicaLocation("block/stripped_orange_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), new TechnologicaLocation("block/stripped_peach_log"), new TechnologicaLocation("block/stripped_peach_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), new TechnologicaLocation("block/stripped_pear_log"), new TechnologicaLocation("block/stripped_pear_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), new TechnologicaLocation("block/stripped_plum_log"), new TechnologicaLocation("block/stripped_plum_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), new TechnologicaLocation("block/stripped_redwood_log"), new TechnologicaLocation("block/stripped_redwood_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), new TechnologicaLocation("block/stripped_rosewood_log"), new TechnologicaLocation("block/stripped_rosewood_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), new TechnologicaLocation("block/stripped_rubber_log"), new TechnologicaLocation("block/stripped_rubber_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), new TechnologicaLocation("block/stripped_teak_log"), new TechnologicaLocation("block/stripped_teak_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), new TechnologicaLocation("block/stripped_walnut_log"), new TechnologicaLocation("block/stripped_walnut_log_top"));
		models.logAll(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/stripped_zebrawood_log"), new TechnologicaLocation("block/stripped_zebrawood_log_top"));
	}

	private void strippedWood() {
		models.logAll(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/stripped_alchemical_log"), new TechnologicaLocation("block/stripped_alchemical_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), new TechnologicaLocation("block/stripped_apricot_log"), new TechnologicaLocation("block/stripped_apricot_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), new TechnologicaLocation("block/stripped_aspen_log"), new TechnologicaLocation("block/stripped_aspen_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), new TechnologicaLocation("block/stripped_avocado_log"), new TechnologicaLocation("block/stripped_avocado_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), new TechnologicaLocation("block/stripped_banana_log"), new TechnologicaLocation("block/stripped_banana_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_benevolent_log"), new TechnologicaLocation("block/stripped_benevolent_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), new TechnologicaLocation("block/stripped_cherry_log"), new TechnologicaLocation("block/stripped_cherry_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), new TechnologicaLocation("block/stripped_chestnut_log"), new TechnologicaLocation("block/stripped_chestnut_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), new TechnologicaLocation("block/stripped_cinnamon_log"), new TechnologicaLocation("block/stripped_cinnamon_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), new TechnologicaLocation("block/stripped_coconut_log"), new TechnologicaLocation("block/stripped_coconut_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/stripped_conductive_log"), new TechnologicaLocation("block/stripped_conductive_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), new TechnologicaLocation("block/stripped_ebony_log"), new TechnologicaLocation("block/stripped_ebony_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/stripped_frostbitten_log"), new TechnologicaLocation("block/stripped_frostbitten_log"), "translucent");
		models.logAll(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), new TechnologicaLocation("block/stripped_fruitful_log"), new TechnologicaLocation("block/stripped_fruitful_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), new TechnologicaLocation("block/stripped_infernal_log"), new TechnologicaLocation("block/stripped_infernal_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), new TechnologicaLocation("block/stripped_kiwi_log"), new TechnologicaLocation("block/stripped_kiwi_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), new TechnologicaLocation("block/stripped_lemon_log"), new TechnologicaLocation("block/stripped_lemon_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), new TechnologicaLocation("block/stripped_lime_log"), new TechnologicaLocation("block/stripped_lime_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), new TechnologicaLocation("block/stripped_mahogany_log"), new TechnologicaLocation("block/stripped_mahogany_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_malevolent_log"), new TechnologicaLocation("block/stripped_malevolent_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), new TechnologicaLocation("block/stripped_maple_log"), new TechnologicaLocation("block/stripped_maple_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), new TechnologicaLocation("block/stripped_necrotic_log"), new TechnologicaLocation("block/stripped_necrotic_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), new TechnologicaLocation("block/stripped_olive_log"), new TechnologicaLocation("block/stripped_olive_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), new TechnologicaLocation("block/stripped_orange_log"), new TechnologicaLocation("block/stripped_orange_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), new TechnologicaLocation("block/stripped_peach_log"), new TechnologicaLocation("block/stripped_peach_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), new TechnologicaLocation("block/stripped_pear_log"), new TechnologicaLocation("block/stripped_pear_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), new TechnologicaLocation("block/stripped_plum_log"), new TechnologicaLocation("block/stripped_plum_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_redwood_log"), new TechnologicaLocation("block/stripped_redwood_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_rosewood_log"), new TechnologicaLocation("block/stripped_rosewood_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), new TechnologicaLocation("block/stripped_rubber_log"), new TechnologicaLocation("block/stripped_rubber_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), new TechnologicaLocation("block/stripped_teak_log"), new TechnologicaLocation("block/stripped_teak_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), new TechnologicaLocation("block/stripped_walnut_log"), new TechnologicaLocation("block/stripped_walnut_log"));
		models.logAll(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_zebrawood_log"), new TechnologicaLocation("block/stripped_zebrawood_log"));
	}

	private void tables() {
		table(TechnologicaBlocks.ACACIA_TABLE.get(), new ResourceLocation("block/acacia_planks"), "solid");
		table(TechnologicaBlocks.ALCHEMICAL_TABLE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		table(TechnologicaBlocks.APRICOT_TABLE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		table(TechnologicaBlocks.ASPEN_TABLE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		table(TechnologicaBlocks.AVOCADO_TABLE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		table(TechnologicaBlocks.BANANA_TABLE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		table(TechnologicaBlocks.BENEVOLENT_TABLE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		table(TechnologicaBlocks.BIRCH_TABLE.get(), new ResourceLocation("block/birch_planks"), "solid");
		table(TechnologicaBlocks.CHERRY_TABLE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		table(TechnologicaBlocks.CHESTNUT_TABLE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		table(TechnologicaBlocks.CINNAMON_TABLE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		table(TechnologicaBlocks.COCONUT_TABLE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		table(TechnologicaBlocks.CONDUCTIVE_TABLE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		table(TechnologicaBlocks.CRIMSON_TABLE.get(), new ResourceLocation("block/crimson_planks"), "solid");
		table(TechnologicaBlocks.DARK_OAK_TABLE.get(), new ResourceLocation("block/dark_oak_planks"), "solid");
		table(TechnologicaBlocks.EBONY_TABLE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		table(TechnologicaBlocks.FROSTBITTEN_TABLE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		table(TechnologicaBlocks.FRUITFUL_TABLE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		table(TechnologicaBlocks.INFERNAL_TABLE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		table(TechnologicaBlocks.JUNGLE_TABLE.get(), new ResourceLocation("block/jungle_planks"), "solid");
		table(TechnologicaBlocks.KIWI_TABLE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		table(TechnologicaBlocks.LEMON_TABLE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		table(TechnologicaBlocks.LIME_TABLE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		table(TechnologicaBlocks.MAHOGANY_TABLE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		table(TechnologicaBlocks.MALEVOLENT_TABLE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		table(TechnologicaBlocks.MAPLE_TABLE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		table(TechnologicaBlocks.NECROTIC_TABLE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		table(TechnologicaBlocks.OAK_TABLE.get(), new ResourceLocation("block/oak_planks"), "solid");
		table(TechnologicaBlocks.OLIVE_TABLE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		table(TechnologicaBlocks.ORANGE_TABLE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		table(TechnologicaBlocks.PEACH_TABLE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		table(TechnologicaBlocks.PEAR_TABLE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		table(TechnologicaBlocks.PLUM_TABLE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		table(TechnologicaBlocks.REDWOOD_TABLE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		table(TechnologicaBlocks.ROSEWOOD_TABLE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		table(TechnologicaBlocks.RUBBER_TABLE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		table(TechnologicaBlocks.SPRUCE_TABLE.get(), new ResourceLocation("block/spruce_planks"), "solid");
		table(TechnologicaBlocks.TEAK_TABLE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		table(TechnologicaBlocks.WALNUT_TABLE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		table(TechnologicaBlocks.WARPED_TABLE.get(), new ResourceLocation("block/warped_planks"), "solid");
		table(TechnologicaBlocks.ZEBRAWOOD_TABLE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void trapdoors() {
		models.trapdoorAll(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), new TechnologicaLocation("block/alchemical_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), new TechnologicaLocation("block/apricot_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.ASPEN_TRAPDOOR.get(), new TechnologicaLocation("block/aspen_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), new TechnologicaLocation("block/avocado_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.BANANA_TRAPDOOR.get(), new TechnologicaLocation("block/banana_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), new TechnologicaLocation("block/benevolent_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.CHERRY_TRAPDOOR.get(), new TechnologicaLocation("block/cherry_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), new TechnologicaLocation("block/chestnut_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), new TechnologicaLocation("block/cinnamon_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.COCONUT_TRAPDOOR.get(), new TechnologicaLocation("block/coconut_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), new TechnologicaLocation("block/conductive_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.EBONY_TRAPDOOR.get(), new TechnologicaLocation("block/ebony_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), new TechnologicaLocation("block/frostbitten_trapdoor"), "translucent");
		models.trapdoorAll(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), new TechnologicaLocation("block/fruitful_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), new TechnologicaLocation("block/infernal_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.KIWI_TRAPDOOR.get(), new TechnologicaLocation("block/kiwi_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.LEMON_TRAPDOOR.get(), new TechnologicaLocation("block/lemon_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.LIME_TRAPDOOR.get(), new TechnologicaLocation("block/lime_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), new TechnologicaLocation("block/mahogany_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), new TechnologicaLocation("block/malevolent_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.MAPLE_TRAPDOOR.get(), new TechnologicaLocation("block/maple_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), new TechnologicaLocation("block/necrotic_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.OLIVE_TRAPDOOR.get(), new TechnologicaLocation("block/olive_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.ORANGE_TRAPDOOR.get(), new TechnologicaLocation("block/orange_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.PEACH_TRAPDOOR.get(), new TechnologicaLocation("block/peach_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.PEAR_TRAPDOOR.get(), new TechnologicaLocation("block/pear_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.PLUM_TRAPDOOR.get(), new TechnologicaLocation("block/plum_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/redwood_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/rosewood_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.RUBBER_TRAPDOOR.get(), new TechnologicaLocation("block/rubber_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.TEAK_TRAPDOOR.get(), new TechnologicaLocation("block/teak_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.WALNUT_TRAPDOOR.get(), new TechnologicaLocation("block/walnut_trapdoor"), "cutout_mipped");
		models.trapdoorAll(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/zebrawood_trapdoor"), "cutout_mipped");
	}

	private void wood() {
		models.logAll(TechnologicaBlocks.ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/alchemical_log"), new TechnologicaLocation("block/alchemical_log"));
		models.logAll(TechnologicaBlocks.APRICOT_WOOD.get(), new TechnologicaLocation("block/apricot_log"), new TechnologicaLocation("block/apricot_log"));
		models.logAll(TechnologicaBlocks.ASPEN_WOOD.get(), new TechnologicaLocation("block/aspen_log"), new TechnologicaLocation("block/aspen_log"));
		models.logAll(TechnologicaBlocks.AVOCADO_WOOD.get(), new TechnologicaLocation("block/avocado_log"), new TechnologicaLocation("block/avocado_log"));
		models.logAll(TechnologicaBlocks.BANANA_WOOD.get(), new TechnologicaLocation("block/banana_log"), new TechnologicaLocation("block/banana_log"));
		models.logAll(TechnologicaBlocks.BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/benevolent_log"), new TechnologicaLocation("block/benevolent_log"));
		models.logAll(TechnologicaBlocks.CHERRY_WOOD.get(), new TechnologicaLocation("block/cherry_log"), new TechnologicaLocation("block/cherry_log"));
		models.logAll(TechnologicaBlocks.CHESTNUT_WOOD.get(), new TechnologicaLocation("block/chestnut_log"), new TechnologicaLocation("block/chestnut_log"));
		models.logAll(TechnologicaBlocks.CINNAMON_WOOD.get(), new TechnologicaLocation("block/cinnamon_log"), new TechnologicaLocation("block/cinnamon_log"));
		models.logAll(TechnologicaBlocks.COCONUT_WOOD.get(), new TechnologicaLocation("block/coconut_log"), new TechnologicaLocation("block/coconut_log"));
		models.logAll(TechnologicaBlocks.CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/conductive_log"), new TechnologicaLocation("block/conductive_log"));
		models.logAll(TechnologicaBlocks.EBONY_WOOD.get(), new TechnologicaLocation("block/ebony_log"), new TechnologicaLocation("block/ebony_log"));
		models.logAll(TechnologicaBlocks.FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/frostbitten_log"), new TechnologicaLocation("block/frostbitten_log"));
		models.logAll(TechnologicaBlocks.FRUITFUL_WOOD.get(), new TechnologicaLocation("block/fruitful_log"), new TechnologicaLocation("block/fruitful_log"));
		models.logAll(TechnologicaBlocks.INFERNAL_WOOD.get(), new TechnologicaLocation("block/infernal_log"), new TechnologicaLocation("block/infernal_log"));
		models.logAll(TechnologicaBlocks.KIWI_WOOD.get(), new TechnologicaLocation("block/kiwi_log"), new TechnologicaLocation("block/kiwi_log"));
		models.logAll(TechnologicaBlocks.LEMON_WOOD.get(), new TechnologicaLocation("block/lemon_log"), new TechnologicaLocation("block/lemon_log"));
		models.logAll(TechnologicaBlocks.LIME_WOOD.get(), new TechnologicaLocation("block/lime_log"), new TechnologicaLocation("block/lime_log"));
		models.logAll(TechnologicaBlocks.MAHOGANY_WOOD.get(), new TechnologicaLocation("block/mahogany_log"), new TechnologicaLocation("block/mahogany_log"));
		models.logAll(TechnologicaBlocks.MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/malevolent_log"), new TechnologicaLocation("block/malevolent_log"));
		models.logAll(TechnologicaBlocks.MAPLE_WOOD.get(), new TechnologicaLocation("block/maple_log"), new TechnologicaLocation("block/maple_log"));
		models.logAll(TechnologicaBlocks.NECROTIC_WOOD.get(), new TechnologicaLocation("block/necrotic_log"), new TechnologicaLocation("block/necrotic_log"));
		models.logAll(TechnologicaBlocks.OLIVE_WOOD.get(), new TechnologicaLocation("block/olive_log"), new TechnologicaLocation("block/olive_log"));
		models.logAll(TechnologicaBlocks.ORANGE_WOOD.get(), new TechnologicaLocation("block/orange_log"), new TechnologicaLocation("block/orange_log"));
		models.logAll(TechnologicaBlocks.PEACH_WOOD.get(), new TechnologicaLocation("block/peach_log"), new TechnologicaLocation("block/peach_log"));
		models.logAll(TechnologicaBlocks.PEAR_WOOD.get(), new TechnologicaLocation("block/pear_log"), new TechnologicaLocation("block/pear_log"));
		models.logAll(TechnologicaBlocks.PLUM_WOOD.get(), new TechnologicaLocation("block/plum_log"), new TechnologicaLocation("block/plum_log"));
		models.logAll(TechnologicaBlocks.REDWOOD_WOOD.get(), new TechnologicaLocation("block/redwood_log"), new TechnologicaLocation("block/redwood_log"));
		models.logAll(TechnologicaBlocks.ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/rosewood_log"), new TechnologicaLocation("block/rosewood_log"));
		models.logAll(TechnologicaBlocks.RUBBER_WOOD.get(), new TechnologicaLocation("block/rubber_log"), new TechnologicaLocation("block/rubber_log"));
		models.logAll(TechnologicaBlocks.TEAK_WOOD.get(), new TechnologicaLocation("block/teak_log"), new TechnologicaLocation("block/teak_log"));
		models.logAll(TechnologicaBlocks.WALNUT_WOOD.get(), new TechnologicaLocation("block/walnut_log"), new TechnologicaLocation("block/walnut_log"));
		models.logAll(TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/zebrawood_log"), new TechnologicaLocation("block/zebrawood_log"));
	}

	/*
	 * MODELS
	 */

	private ModelBuilder<BlockModelBuilder> chair(Block block, ResourceLocation texture, String renderType) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "chair"), "planks", texture).renderType(renderType);
	}

	private ModelBuilder<BlockModelBuilder> hexagonalCrystal(Block block, ResourceLocation texture) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "block/hexagonal_crystal"), "crystal", texture).renderType("translucent");
	}

	private ModelBuilder<BlockModelBuilder> leafyCrystal(Block block, ResourceLocation texture) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "block/leafy_crystal"), "crystal", texture).renderType("translucent");
	}

	private ModelBuilder<BlockModelBuilder> spikyCrystal(Block block, ResourceLocation texture) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "block/spiky_crystal"), "crystal", texture).renderType("translucent");
	}

	private ModelBuilder<BlockModelBuilder> cubicCrystal(Block block, ResourceLocation texture) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "block/cubic_crystal"), "crystal", texture).renderType("translucent");
	}

	private ModelBuilder<BlockModelBuilder> table(Block block, ResourceLocation texture, String renderType) {
		return models.singleTexture(ResourceLocationHelper.getPath(block), new ResourceLocation(modID, "table"), "planks", texture).renderType(renderType);
	}

	private void bushTall8Stage(Block block, ResourceLocation texture, String renderType) {
		bushBottom(block, 0, texture, renderType);
		bushBottom(block, 1, texture, renderType);
		bushBottom(block, 2, texture, renderType);
		bushBottom(block, 3, texture, renderType);
		bushBottom(block, 4, texture, renderType);
		bushBottom(block, 5, texture, renderType);
		bushBottom(block, 6, texture, renderType);
		bushBottom(block, 7, texture, renderType);
		bushTop(block, 0, texture, renderType);
		bushTop(block, 1, texture, renderType);
		bushTop(block, 2, texture, renderType);
		bushTop(block, 3, texture, renderType);
		bushTop(block, 4, texture, renderType);
		bushTop(block, 5, texture, renderType);
		bushTop(block, 6, texture, renderType);
		bushTop(block, 7, texture, renderType);
	}

	private ModelBuilder<BlockModelBuilder> bushBottom(Block block, int stage, ResourceLocation texture, String renderType) {
		return models.withExistingParent(models.name(block) + "_bottom_stage" + stage, "block/cross").texture("cross", texture + "_bottom_stage" + stage).renderType(renderType);
	}

	private ModelBuilder<BlockModelBuilder> bushTop(Block block, int stage, ResourceLocation texture, String renderType) {
		return models.withExistingParent(models.name(block) + "_top_stage" + stage, "block/cross").texture("cross", texture + "_top_stage" + stage).renderType(renderType);
	}

	private void cropTall8Stage(Block block, ResourceLocation texture, String renderType) {
		cropBottom(block, 0, texture, renderType);
		cropBottom(block, 1, texture, renderType);
		cropBottom(block, 2, texture, renderType);
		cropBottom(block, 3, texture, renderType);
		cropBottom(block, 4, texture, renderType);
		cropBottom(block, 5, texture, renderType);
		cropBottom(block, 6, texture, renderType);
		cropBottom(block, 7, texture, renderType);
		cropTop(block, 0, texture, renderType);
		cropTop(block, 1, texture, renderType);
		cropTop(block, 2, texture, renderType);
		cropTop(block, 3, texture, renderType);
		cropTop(block, 4, texture, renderType);
		cropTop(block, 5, texture, renderType);
		cropTop(block, 6, texture, renderType);
		cropTop(block, 7, texture, renderType);
	}

	private ModelBuilder<BlockModelBuilder> cropBottom(Block block, int stage, ResourceLocation texture, String renderType) {
		return models.withExistingParent(models.name(block) + "_bottom_stage" + stage, "block/crop").texture("crop", texture + "_bottom_stage" + stage).renderType(renderType);
	}

	private ModelBuilder<BlockModelBuilder> cropTop(Block block, int stage, ResourceLocation texture, String renderType) {
		return models.withExistingParent(models.name(block) + "_top_stage" + stage, "block/crop").texture("crop", texture + "_top_stage" + stage).renderType(renderType);
	}
}
