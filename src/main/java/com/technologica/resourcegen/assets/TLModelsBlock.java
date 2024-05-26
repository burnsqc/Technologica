package com.technologica.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.assets.TLReGenModelsBlock;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;

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

		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()), "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_fail", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_fail")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_info", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_pass", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_pass")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_warn", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_warn")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_fail", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_fail")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_info", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_info")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_pass", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_pass")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));
		withExistingParent(name(TechnologicaBlocks.ANNUNCIATOR.get()) + "_lit_warn", "block/orientable").texture("front", new TechnologicaLocation("block/annunciator_lit_warn")).texture("side", new TechnologicaLocation("block/annunciator_side")).texture("top", new TechnologicaLocation("block/annunciator_side"));

		withExistingParent(name(TechnologicaBlocks.BASIN.get()), new TechnologicaLocation("block/basin_model")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		withExistingParent(name(TechnologicaBlocks.DISPLAY_CASE.get()), new TechnologicaLocation("block/display")).texture("base", new ResourceLocation("block/black_wool")).texture("case", new TechnologicaLocation("block/display_case")).renderType("cutout_mipped");

		withExistingParent(name(TechnologicaBlocks.FAST_HOPPER.get()), new TechnologicaLocation("block/technologica_hopper")).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));
		withExistingParent(name(TechnologicaBlocks.FAST_HOPPER.get()) + "_side", new TechnologicaLocation("block/technologica_hopper_side")).texture("inside", new TechnologicaLocation("block/fast_hopper_inside")).texture("particle", new TechnologicaLocation("block/fast_hopper_outside")).texture("side", new TechnologicaLocation("block/fast_hopper_outside")).texture("top", new TechnologicaLocation("block/fast_hopper_top"));

		withExistingParent(name(TechnologicaBlocks.GLUE.get()), new TechnologicaLocation("block/glue_model")).texture("face", new TechnologicaLocation("block/glue")).texture("particle", new TechnologicaLocation("block/glue"));

		withExistingParent(name(TechnologicaBlocks.KEYBOARD.get()), new TechnologicaLocation("block/keyboard_model"));

		withExistingParent(name(TechnologicaBlocks.SMALL_PULLEY.get()), new TechnologicaLocation("block/small_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));
		withExistingParent(name(TechnologicaBlocks.MEDIUM_PULLEY.get()), new TechnologicaLocation("block/medium_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));
		withExistingParent(name(TechnologicaBlocks.LARGE_PULLEY.get()), new TechnologicaLocation("block/large_pulley_model")).texture("pulley", new TechnologicaLocation("block/pulley"));

		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()), new TechnologicaLocation("block/line_shaft_hanger_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2", new TechnologicaLocation("block/line_shaft_hanger2_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "2_shaft", new TechnologicaLocation("block/line_shaft_hanger2_shaft_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT_HANGER.get()) + "_shaft", new TechnologicaLocation("block/line_shaft_hanger_shaft_model"));

		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT.get()) + "_no_pulley", new TechnologicaLocation("block/line_shaft_no_pulley_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT.get()) + "_small_pulley", new TechnologicaLocation("block/line_shaft_small_pulley_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT.get()) + "_medium_pulley", new TechnologicaLocation("block/line_shaft_medium_pulley_model"));
		withExistingParent(name(TechnologicaBlocks.LINE_SHAFT.get()) + "_large_pulley", new TechnologicaLocation("block/line_shaft_large_pulley_model"));

		withExistingParent(name(TechnologicaBlocks.MONITOR.get()), new TechnologicaLocation("block/monitor_model"));

		withExistingParent(name(TechnologicaBlocks.MOTOR_1HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_1hp"));
		withExistingParent(name(TechnologicaBlocks.MOTOR_1HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_1hp"));
		withExistingParent(name(TechnologicaBlocks.MOTOR_5HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_5hp"));
		withExistingParent(name(TechnologicaBlocks.MOTOR_5HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_5hp"));
		withExistingParent(name(TechnologicaBlocks.MOTOR_20HP.get()), new TechnologicaLocation("block/motor")).texture("motor", new TechnologicaLocation("block/motor_20hp"));
		withExistingParent(name(TechnologicaBlocks.MOTOR_20HP.get()) + "2", new TechnologicaLocation("block/motor2")).texture("motor", new TechnologicaLocation("block/motor_20hp"));

		withExistingParent(name(TechnologicaBlocks.MULCH.get()), new ResourceLocation("block/cube_bottom_top")).texture("bottom", new ResourceLocation("block/dirt")).texture("side", new TechnologicaLocation("block/mulch_side")).texture("top", new TechnologicaLocation("block/mulch_top"));
		withExistingParent(name(TechnologicaBlocks.NITROGLYCERIN.get()), new ResourceLocation("block/cube_bottom_top")).texture("bottom", new TechnologicaLocation("block/nitroglycerin_bottom")).texture("side", new TechnologicaLocation("block/nitroglycerin_side")).texture("top", new TechnologicaLocation("block/nitroglycerin_top"));

		withExistingParent(name(TechnologicaBlocks.NAVAL_MINE_CHAIN.get()), new ResourceLocation("block/chain")).renderType("cutout_mipped");

		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level1", new TechnologicaLocation("block/basin_filled_model_level1")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level2", new TechnologicaLocation("block/basin_filled_model_level2")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level3", new TechnologicaLocation("block/basin_filled_model_level3")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level4", new TechnologicaLocation("block/basin_filled_model_level4")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level5", new TechnologicaLocation("block/basin_filled_model_level5")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level6", new TechnologicaLocation("block/basin_filled_model_level6")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level7", new TechnologicaLocation("block/basin_filled_model_level7")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level8", new TechnologicaLocation("block/basin_filled_model_level8")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level9", new TechnologicaLocation("block/basin_filled_model_level9")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level10", new TechnologicaLocation("block/basin_filled_model_level10")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level11", new TechnologicaLocation("block/basin_filled_model_level11")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level12", new TechnologicaLocation("block/basin_filled_model_level12")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level13", new TechnologicaLocation("block/basin_filled_model_level13")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level14", new TechnologicaLocation("block/basin_filled_model_level14")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level15", new TechnologicaLocation("block/basin_filled_model_level15")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()) + "_level16", new TechnologicaLocation("block/basin_filled_model_level16")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level1", new TechnologicaLocation("block/basin_filled_model_level1")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level2", new TechnologicaLocation("block/basin_filled_model_level2")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level3", new TechnologicaLocation("block/basin_filled_model_level3")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level4", new TechnologicaLocation("block/basin_filled_model_level4")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level5", new TechnologicaLocation("block/basin_filled_model_level5")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level6", new TechnologicaLocation("block/basin_filled_model_level6")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level7", new TechnologicaLocation("block/basin_filled_model_level7")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level8", new TechnologicaLocation("block/basin_filled_model_level8")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level9", new TechnologicaLocation("block/basin_filled_model_level9")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level10", new TechnologicaLocation("block/basin_filled_model_level10")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level11", new TechnologicaLocation("block/basin_filled_model_level11")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level12", new TechnologicaLocation("block/basin_filled_model_level12")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level13", new TechnologicaLocation("block/basin_filled_model_level13")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level14", new TechnologicaLocation("block/basin_filled_model_level14")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level15", new TechnologicaLocation("block/basin_filled_model_level15")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));
		withExistingParent(name(TechnologicaBlocks.RUBBER_RESIN_BASIN.get()) + "_level16", new TechnologicaLocation("block/basin_filled_model_level16")).texture("bottom", new TechnologicaLocation("block/basin_bottom")).texture("content", new TechnologicaLocation("block/opaque_fluid_still")).texture("inside", new TechnologicaLocation("block/basin_bottom")).texture("particle", new TechnologicaLocation("block/basin_side")).texture("side", new TechnologicaLocation("block/basin_side")).texture("top", new TechnologicaLocation("block/basin_top"));

		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()), "block/orientable").texture("front", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("side", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("top", new TechnologicaLocation("block/sawmill_top_middle"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()), "block/orientable").texture("front", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("side", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("top", new TechnologicaLocation("block/sawmill_top_middle"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "lower_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL_CORE.get()) + "upper_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));

		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "lower_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_lower_side_end")).texture("north", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("up", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("west", new TechnologicaLocation("block/sawmill_lower_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_left_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_left")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("up", new TechnologicaLocation("block/sawmill_top_left")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_middle_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_middle")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_middle")).texture("up", new TechnologicaLocation("block/sawmill_top_middle")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_east", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_north", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_south", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));
		withExistingParent(name(TechnologicaBlocks.SAWMILL.get()) + "upper_right_west", new TechnologicaLocation("block/cube_each_face")).texture("down", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("east", new TechnologicaLocation("block/sawmill_upper_side_end")).texture("north", new TechnologicaLocation("block/sawmill_upper_side_left")).texture("particle", new TechnologicaLocation("block/sawmill_lower_side_right")).texture("south", new TechnologicaLocation("block/sawmill_upper_side_right")).texture("up", new TechnologicaLocation("block/sawmill_top_right")).texture("west", new TechnologicaLocation("block/sawmill_upper_side_end"));

		withExistingParent(name(TechnologicaBlocks.SLEEPING_BAG.get()) + "_top", new TechnologicaLocation("block/panel")).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top"));
		withExistingParent(name(TechnologicaBlocks.SLEEPING_BAG.get()) + "_top_head", new TechnologicaLocation("block/panel")).texture("bottom", new TechnologicaLocation("block/sleeping_bag_bottom")).texture("particle", new TechnologicaLocation("block/sleeping_bag_side")).texture("side", new TechnologicaLocation("block/sleeping_bag_side")).texture("top", new TechnologicaLocation("block/sleeping_bag_top_head"));

		withExistingParent(name(TechnologicaBlocks.TAPE_DRIVE.get()) + "_lower", new TechnologicaLocation("block/tape_drive_lower_model"));
		withExistingParent(name(TechnologicaBlocks.TAPE_DRIVE.get()) + "_upper", new TechnologicaLocation("block/tape_drive_upper_model"));

		withExistingParent(name(TechnologicaBlocks.TREE_TAP.get()), new TechnologicaLocation("block/tap")).texture("tree_tap", new TechnologicaLocation("block/tree_tap"));

		withExistingParent(name(TechnologicaBlocks.TRELLIS.get()), new TechnologicaLocation("block/trellis_model")).texture("texture", new TechnologicaLocation("block/trellis")).renderType("cutout");
	}

	private void blocksOfMetal() {
		cubeAll(TechnologicaBlocks.BLOCK_OF_ACTINIUM.get(), new TechnologicaLocation("block/block_of_actinium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ALUMINUM.get(), new TechnologicaLocation("block/block_of_aluminum"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_AMERICIUM.get(), new TechnologicaLocation("block/block_of_americium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ANTIMONY.get(), new TechnologicaLocation("block/block_of_antimony"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ARSENIC.get(), new TechnologicaLocation("block/block_of_arsenic"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ASTATINE.get(), new TechnologicaLocation("block/block_of_astatine"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BERKELLIUM.get(), new TechnologicaLocation("block/block_of_berkellium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BERYLLIUM.get(), new TechnologicaLocation("block/block_of_beryllium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BISMUTH.get(), new TechnologicaLocation("block/block_of_bismuth"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BORON.get(), new TechnologicaLocation("block/block_of_boron"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BRASS.get(), new TechnologicaLocation("block/block_of_brass"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_BRONZE.get(), new TechnologicaLocation("block/block_of_bronze"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_CADMIUM.get(), new TechnologicaLocation("block/block_of_cadmium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_CALIFORNIUM.get(), new TechnologicaLocation("block/block_of_californium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_CARBON.get(), new TechnologicaLocation("block/block_of_carbon"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_CHROMIUM.get(), new TechnologicaLocation("block/block_of_chromium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_COBALT.get(), new TechnologicaLocation("block/block_of_cobalt"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_CURIUM.get(), new TechnologicaLocation("block/block_of_curium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_EINSTEINIUM.get(), new TechnologicaLocation("block/block_of_einsteinium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_FERMIUM.get(), new TechnologicaLocation("block/block_of_fermium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_GALLIUM.get(), new TechnologicaLocation("block/block_of_gallium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_GERMANIUM.get(), new TechnologicaLocation("block/block_of_germanium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_HAFNIUM.get(), new TechnologicaLocation("block/block_of_hafnium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_INDIUM.get(), new TechnologicaLocation("block/block_of_indium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_IODINE.get(), new TechnologicaLocation("block/block_of_iodine"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_IRIDIUM.get(), new TechnologicaLocation("block/block_of_iridium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_LAWRENCIUM.get(), new TechnologicaLocation("block/block_of_lawrencium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_LEAD.get(), new TechnologicaLocation("block/block_of_lead"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_LITHIUM.get(), new TechnologicaLocation("block/block_of_lithium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_MANGANESE.get(), new TechnologicaLocation("block/block_of_manganese"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_MOLYBDENUM.get(), new TechnologicaLocation("block/block_of_molybdenum"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_NEPTUNIUM.get(), new TechnologicaLocation("block/block_of_neptunium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_NICKEL.get(), new TechnologicaLocation("block/block_of_nickel"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_NIOBIUM.get(), new TechnologicaLocation("block/block_of_niobium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_OSMIUM.get(), new TechnologicaLocation("block/block_of_osmium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_PALLADIUM.get(), new TechnologicaLocation("block/block_of_palladium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_PHOSPHORUS.get(), new TechnologicaLocation("block/block_of_phosphorus"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_PLATINUM.get(), new TechnologicaLocation("block/block_of_platinum"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_PLUTONIUM.get(), new TechnologicaLocation("block/block_of_plutonium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_POLONIUM.get(), new TechnologicaLocation("block/block_of_polonium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_PROTACTINIUM.get(), new TechnologicaLocation("block/block_of_protactinium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_RHENIUM.get(), new TechnologicaLocation("block/block_of_rhenium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_RHODIUM.get(), new TechnologicaLocation("block/block_of_rhodium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_RUBY.get(), new TechnologicaLocation("block/block_of_ruby"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_RUTHENIUM.get(), new TechnologicaLocation("block/block_of_ruthenium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_SAPPHIRE.get(), new TechnologicaLocation("block/block_of_sapphire"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_SELENIUM.get(), new TechnologicaLocation("block/block_of_selenium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_SILICON.get(), new TechnologicaLocation("block/block_of_silicon"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_SILVER.get(), new TechnologicaLocation("block/block_of_silver"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_STEEL.get(), new TechnologicaLocation("block/block_of_steel"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_SULFUR.get(), new TechnologicaLocation("block/block_of_sulfur"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TANTALUM.get(), new TechnologicaLocation("block/block_of_tantalum"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TECHNETIUM.get(), new TechnologicaLocation("block/block_of_technetium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TELLURIUM.get(), new TechnologicaLocation("block/block_of_tellurium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_THALLIUM.get(), new TechnologicaLocation("block/block_of_thallium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_THORIUM.get(), new TechnologicaLocation("block/block_of_thorium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TIN.get(), new TechnologicaLocation("block/block_of_tin"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TITANIUM.get(), new TechnologicaLocation("block/block_of_titanium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TOPAZ.get(), new TechnologicaLocation("block/block_of_topaz"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_TUNGSTEN.get(), new TechnologicaLocation("block/block_of_tungsten"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_URANIUM.get(), new TechnologicaLocation("block/block_of_uranium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_VANADIUM.get(), new TechnologicaLocation("block/block_of_vanadium"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ZINC.get(), new TechnologicaLocation("block/block_of_zinc"));
		cubeAll(TechnologicaBlocks.BLOCK_OF_ZIRCONIUM.get(), new TechnologicaLocation("block/block_of_zirconium"));

		cubeAll(TechnologicaBlocks.LITHIUM_CLAY.get(), new TechnologicaLocation("block/lithium_clay"));
		cubeAll(TechnologicaBlocks.MOON_DUST.get(), new TechnologicaLocation("block/moon_dust"));
		cubeAll(TechnologicaBlocks.MOON_ROCK.get(), new TechnologicaLocation("block/moon_rock"));
		cubeAll(TechnologicaBlocks.OILY_COARSE_DIRT.get(), new TechnologicaLocation("block/oily_coarse_dirt"));
		cubeAll(TechnologicaBlocks.OILY_GRAVEL.get(), new TechnologicaLocation("block/oily_gravel"));
		cubeAll(TechnologicaBlocks.OILY_RED_SAND.get(), new TechnologicaLocation("block/oily_red_sand"));
		cubeAll(TechnologicaBlocks.OILY_SAND.get(), new TechnologicaLocation("block/oily_sand"));
		cubeAll(TechnologicaBlocks.SALT.get(), new TechnologicaLocation("block/salt"));
	}

	private void bookshelves() {
		cubeColumn(TechnologicaBlocks.ACACIA_BOOKSHELF.get(), new TechnologicaLocation("block/acacia_bookshelf"), new ResourceLocation("block/acacia_planks"));
		cubeColumn(TechnologicaBlocks.ALCHEMICAL_BOOKSHELF.get(), new TechnologicaLocation("block/alchemical_bookshelf"), new TechnologicaLocation("block/alchemical_planks"));
		cubeColumn(TechnologicaBlocks.APRICOT_BOOKSHELF.get(), new TechnologicaLocation("block/apricot_bookshelf"), new TechnologicaLocation("block/apricot_planks"));
		cubeColumn(TechnologicaBlocks.ASPEN_BOOKSHELF.get(), new TechnologicaLocation("block/aspen_bookshelf"), new TechnologicaLocation("block/aspen_planks"));
		cubeColumn(TechnologicaBlocks.AVOCADO_BOOKSHELF.get(), new TechnologicaLocation("block/avocado_bookshelf"), new TechnologicaLocation("block/avocado_planks"));
		cubeColumn(TechnologicaBlocks.BANANA_BOOKSHELF.get(), new TechnologicaLocation("block/banana_bookshelf"), new TechnologicaLocation("block/banana_planks"));
		cubeColumn(TechnologicaBlocks.BENEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/benevolent_bookshelf"), new TechnologicaLocation("block/benevolent_planks"));
		cubeColumn(TechnologicaBlocks.BIRCH_BOOKSHELF.get(), new TechnologicaLocation("block/birch_bookshelf"), new ResourceLocation("block/birch_planks"));
		cubeColumn(TechnologicaBlocks.CHERRY_BOOKSHELF.get(), new TechnologicaLocation("block/cherry_bookshelf"), new TechnologicaLocation("block/cherry_planks"));
		cubeColumn(TechnologicaBlocks.CHESTNUT_BOOKSHELF.get(), new TechnologicaLocation("block/chestnut_bookshelf"), new TechnologicaLocation("block/chestnut_planks"));
		cubeColumn(TechnologicaBlocks.CINNAMON_BOOKSHELF.get(), new TechnologicaLocation("block/cinnamon_bookshelf"), new TechnologicaLocation("block/cinnamon_planks"));
		cubeColumn(TechnologicaBlocks.COCONUT_BOOKSHELF.get(), new TechnologicaLocation("block/coconut_bookshelf"), new TechnologicaLocation("block/coconut_planks"));
		cubeColumn(TechnologicaBlocks.CONDUCTIVE_BOOKSHELF.get(), new TechnologicaLocation("block/conductive_bookshelf"), new TechnologicaLocation("block/conductive_planks"));
		cubeColumn(TechnologicaBlocks.CRIMSON_BOOKSHELF.get(), new TechnologicaLocation("block/crimson_bookshelf"), new ResourceLocation("block/crimson_planks"));
		cubeColumn(TechnologicaBlocks.DARK_OAK_BOOKSHELF.get(), new TechnologicaLocation("block/dark_oak_bookshelf"), new ResourceLocation("block/dark_oak_planks"));
		cubeColumn(TechnologicaBlocks.EBONY_BOOKSHELF.get(), new TechnologicaLocation("block/ebony_bookshelf"), new TechnologicaLocation("block/ebony_planks"));
		cubeColumn(TechnologicaBlocks.FROSTBITTEN_BOOKSHELF.get(), new TechnologicaLocation("block/frostbitten_bookshelf"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		cubeColumn(TechnologicaBlocks.FRUITFUL_BOOKSHELF.get(), new TechnologicaLocation("block/fruitful_bookshelf"), new TechnologicaLocation("block/fruitful_planks"));
		cubeColumn(TechnologicaBlocks.INFERNAL_BOOKSHELF.get(), new TechnologicaLocation("block/infernal_bookshelf"), new TechnologicaLocation("block/infernal_planks"));
		cubeColumn(TechnologicaBlocks.JUNGLE_BOOKSHELF.get(), new TechnologicaLocation("block/jungle_bookshelf"), new ResourceLocation("block/jungle_planks"));
		cubeColumn(TechnologicaBlocks.KIWI_BOOKSHELF.get(), new TechnologicaLocation("block/kiwi_bookshelf"), new TechnologicaLocation("block/kiwi_planks"));
		cubeColumn(TechnologicaBlocks.LEMON_BOOKSHELF.get(), new TechnologicaLocation("block/lemon_bookshelf"), new TechnologicaLocation("block/lemon_planks"));
		cubeColumn(TechnologicaBlocks.LIME_BOOKSHELF.get(), new TechnologicaLocation("block/lime_bookshelf"), new TechnologicaLocation("block/lime_planks"));
		cubeColumn(TechnologicaBlocks.MAHOGANY_BOOKSHELF.get(), new TechnologicaLocation("block/mahogany_bookshelf"), new TechnologicaLocation("block/mahogany_planks"));
		cubeColumn(TechnologicaBlocks.MALEVOLENT_BOOKSHELF.get(), new TechnologicaLocation("block/malevolent_bookshelf"), new TechnologicaLocation("block/malevolent_planks"));
		cubeColumn(TechnologicaBlocks.MAPLE_BOOKSHELF.get(), new TechnologicaLocation("block/maple_bookshelf"), new TechnologicaLocation("block/maple_planks"));
		cubeColumn(TechnologicaBlocks.NECROTIC_BOOKSHELF.get(), new TechnologicaLocation("block/necrotic_bookshelf"), new TechnologicaLocation("block/necrotic_planks"));
		cubeColumn(TechnologicaBlocks.OLIVE_BOOKSHELF.get(), new TechnologicaLocation("block/olive_bookshelf"), new TechnologicaLocation("block/olive_planks"));
		cubeColumn(TechnologicaBlocks.ORANGE_BOOKSHELF.get(), new TechnologicaLocation("block/orange_bookshelf"), new TechnologicaLocation("block/orange_planks"));
		cubeColumn(TechnologicaBlocks.PEACH_BOOKSHELF.get(), new TechnologicaLocation("block/peach_bookshelf"), new TechnologicaLocation("block/peach_planks"));
		cubeColumn(TechnologicaBlocks.PEAR_BOOKSHELF.get(), new TechnologicaLocation("block/pear_bookshelf"), new TechnologicaLocation("block/pear_planks"));
		cubeColumn(TechnologicaBlocks.PLUM_BOOKSHELF.get(), new TechnologicaLocation("block/plum_bookshelf"), new TechnologicaLocation("block/plum_planks"));
		cubeColumn(TechnologicaBlocks.REDWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/redwood_bookshelf"), new TechnologicaLocation("block/redwood_planks"));
		cubeColumn(TechnologicaBlocks.ROSEWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/rosewood_bookshelf"), new TechnologicaLocation("block/rosewood_planks"));
		cubeColumn(TechnologicaBlocks.RUBBER_BOOKSHELF.get(), new TechnologicaLocation("block/rubber_bookshelf"), new TechnologicaLocation("block/rubber_planks"));
		cubeColumn(TechnologicaBlocks.SPRUCE_BOOKSHELF.get(), new TechnologicaLocation("block/spruce_bookshelf"), new ResourceLocation("block/spruce_planks"));
		cubeColumn(TechnologicaBlocks.TEAK_BOOKSHELF.get(), new TechnologicaLocation("block/teak_bookshelf"), new TechnologicaLocation("block/teak_planks"));
		cubeColumn(TechnologicaBlocks.WALNUT_BOOKSHELF.get(), new TechnologicaLocation("block/walnut_bookshelf"), new TechnologicaLocation("block/walnut_planks"));
		cubeColumn(TechnologicaBlocks.WARPED_BOOKSHELF.get(), new TechnologicaLocation("block/warped_bookshelf"), new ResourceLocation("block/warped_planks"));
		cubeColumn(TechnologicaBlocks.ZEBRAWOOD_BOOKSHELF.get(), new TechnologicaLocation("block/zebrawood_bookshelf"), new TechnologicaLocation("block/zebrawood_planks"));
	}

	private void buttons() {
		buttonAll(TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		buttonAll(TechnologicaBlocks.APRICOT_BUTTON.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		buttonAll(TechnologicaBlocks.ASPEN_BUTTON.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		buttonAll(TechnologicaBlocks.AVOCADO_BUTTON.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		buttonAll(TechnologicaBlocks.BANANA_BUTTON.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		buttonAll(TechnologicaBlocks.BENEVOLENT_BUTTON.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		buttonAll(TechnologicaBlocks.CHERRY_BUTTON.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		buttonAll(TechnologicaBlocks.CHESTNUT_BUTTON.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		buttonAll(TechnologicaBlocks.CINNAMON_BUTTON.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		buttonAll(TechnologicaBlocks.COCONUT_BUTTON.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		buttonAll(TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		buttonAll(TechnologicaBlocks.EBONY_BUTTON.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		buttonAll(TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		buttonAll(TechnologicaBlocks.FRUITFUL_BUTTON.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		buttonAll(TechnologicaBlocks.INFERNAL_BUTTON.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		buttonAll(TechnologicaBlocks.KIWI_BUTTON.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		buttonAll(TechnologicaBlocks.LEMON_BUTTON.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		buttonAll(TechnologicaBlocks.LIME_BUTTON.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		buttonAll(TechnologicaBlocks.MAHOGANY_BUTTON.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		buttonAll(TechnologicaBlocks.MALEVOLENT_BUTTON.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		buttonAll(TechnologicaBlocks.MAPLE_BUTTON.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		buttonAll(TechnologicaBlocks.NECROTIC_BUTTON.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		buttonAll(TechnologicaBlocks.OLIVE_BUTTON.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		buttonAll(TechnologicaBlocks.ORANGE_BUTTON.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		buttonAll(TechnologicaBlocks.PEACH_BUTTON.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		buttonAll(TechnologicaBlocks.PEAR_BUTTON.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		buttonAll(TechnologicaBlocks.PLUM_BUTTON.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		buttonAll(TechnologicaBlocks.REDWOOD_BUTTON.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		buttonAll(TechnologicaBlocks.ROSEWOOD_BUTTON.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		buttonAll(TechnologicaBlocks.RUBBER_BUTTON.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		buttonAll(TechnologicaBlocks.TEAK_BUTTON.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		buttonAll(TechnologicaBlocks.WALNUT_BUTTON.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		buttonAll(TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
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
		crop4Stage(TechnologicaBlocks.ASPARAGUS.get(), new TechnologicaLocation("block/asparagus"), "cutout");
		crop4Stage(TechnologicaBlocks.BROCCOLI.get(), new TechnologicaLocation("block/broccoli"), "cutout");
		crop4Stage(TechnologicaBlocks.CELERY.get(), new TechnologicaLocation("block/celery"), "cutout");
		crop4Stage(TechnologicaBlocks.CHILI_PEPPERS.get(), new TechnologicaLocation("block/chili_peppers"), "cutout");
		crop4Stage(TechnologicaBlocks.COFFEE.get(), new TechnologicaLocation("block/coffee"), "cutout");
		crop4Stage(TechnologicaBlocks.GARLIC.get(), new TechnologicaLocation("block/garlic"), "cutout");
		crop4Stage(TechnologicaBlocks.GINGER.get(), new TechnologicaLocation("block/ginger"), "cutout");
		crop4Stage(TechnologicaBlocks.LETTUCE.get(), new TechnologicaLocation("block/lettuce"), "cutout");
		crop4Stage(TechnologicaBlocks.MUSTARD_GREENS.get(), new TechnologicaLocation("block/mustard_greens"), "cutout");
		crop4Stage(TechnologicaBlocks.ONIONS.get(), new TechnologicaLocation("block/onions"), "cutout");
		crop4Stage(TechnologicaBlocks.PEANUTS.get(), new TechnologicaLocation("block/peanuts"), "cutout");
		crop4Stage(TechnologicaBlocks.PEAS.get(), new TechnologicaLocation("block/peas"), "cutout");
		crop4Stage(TechnologicaBlocks.PINEAPPLES.get(), new TechnologicaLocation("block/pineapples"), "cutout");
		crop4Stage(TechnologicaBlocks.PURPLE_CABBAGE.get(), new TechnologicaLocation("block/purple_cabbage"), "cutout");
		crop4Stage(TechnologicaBlocks.RADISHES.get(), new TechnologicaLocation("block/radishes"), "cutout");
		crop4Stage(TechnologicaBlocks.RED_BEANS.get(), new TechnologicaLocation("block/red_beans"), "cutout");
		crop4Stage(TechnologicaBlocks.SOY_BEANS.get(), new TechnologicaLocation("block/soy_beans"), "cutout");
		crop4Stage(TechnologicaBlocks.SWEET_POTATOES.get(), new TechnologicaLocation("block/sweet_potatoes"), "cutout");
		crop4Stage(TechnologicaBlocks.TEA.get(), new TechnologicaLocation("block/tea"), "cutout");
		crop4Stage(TechnologicaBlocks.TURNIPS.get(), new TechnologicaLocation("block/turnips"), "cutout");

		crop8Stage(TechnologicaBlocks.BARLEY.get(), new TechnologicaLocation("block/barley"), "cutout");
		crop8Stage(TechnologicaBlocks.OATS.get(), new TechnologicaLocation("block/oats"), "cutout");
		crop8Stage(TechnologicaBlocks.RYE.get(), new TechnologicaLocation("block/rye"), "cutout");

		cropTall8Stage(TechnologicaBlocks.CORN.get(), new TechnologicaLocation("block/corn"), "cutout");
		cropTall8Stage(TechnologicaBlocks.CRANBERRIES.get(), new TechnologicaLocation("block/cranberry"), "cutout");
		cropTall8Stage(TechnologicaBlocks.GRAPES.get(), new TechnologicaLocation("block/grapes"), "cutout");
		cropTall8Stage(TechnologicaBlocks.RICE.get(), new TechnologicaLocation("block/rice"), "cutout");
		cropTall8Stage(TechnologicaBlocks.TOMATOES.get(), new TechnologicaLocation("block/tomatoes"), "cutout");

		bush4Stage(TechnologicaBlocks.BLACKBERRY_BUSH.get(), new TechnologicaLocation("block/blackberry_bush"), "cutout_mipped");
		bush4Stage(TechnologicaBlocks.BLUEBERRY_BUSH.get(), new TechnologicaLocation("block/blueberry_bush"), "cutout_mipped");
		bush4Stage(TechnologicaBlocks.COTTON_BUSH.get(), new TechnologicaLocation("block/cotton_bush"), "cutout_mipped");
		bush4Stage(TechnologicaBlocks.RASPBERRY_BUSH.get(), new TechnologicaLocation("block/raspberry_bush"), "cutout_mipped");
		bush4Stage(TechnologicaBlocks.STRAWBERRY_BUSH.get(), new TechnologicaLocation("block/strawberry_bush"), "cutout_mipped");

		bushTall8Stage(TechnologicaBlocks.PEPPERCORNS.get(), new TechnologicaLocation("block/peppercorns"), "cutout_mipped");

		withExistingParent(name(TechnologicaBlocks.ATTACHED_CUCUMBER_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/cucumber_stem")).texture("upperstem", new TechnologicaLocation("block/attached_cucumber_stem")).renderType("cutout");
		withExistingParent(name(TechnologicaBlocks.ATTACHED_SQUASH_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/squash_stem")).texture("upperstem", new TechnologicaLocation("block/attached_squash_stem")).renderType("cutout");
		withExistingParent(name(TechnologicaBlocks.ATTACHED_ZUCCHINI_STEM.get()), new TechnologicaLocation("block/stem_gourd")).texture("stem", new TechnologicaLocation("block/zucchini_stem")).texture("upperstem", new TechnologicaLocation("block/attached_zucchini_stem")).renderType("cutout");

		withExistingParent(name(TechnologicaBlocks.CUCUMBERS.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/cucumbers")).renderType("cutout_mipped");
		withExistingParent(name(TechnologicaBlocks.SQUASH.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/squash")).renderType("cutout_mipped");
		withExistingParent(name(TechnologicaBlocks.ZUCCHINI.get()), new TechnologicaLocation("block/gourd")).texture("gourd", new TechnologicaLocation("block/zucchini")).renderType("cutout_mipped");

		gourdStem8Stage(TechnologicaBlocks.CUCUMBER_STEM.get(), new TechnologicaLocation("block/cucumber_stem"), "cutout");
		gourdStem8Stage(TechnologicaBlocks.SQUASH_STEM.get(), new TechnologicaLocation("block/squash_stem"), "cutout");
		gourdStem8Stage(TechnologicaBlocks.ZUCCHINI_STEM.get(), new TechnologicaLocation("block/zucchini_stem"), "cutout");
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
		cubeAll(TechnologicaBlocks.DEEPSLATE_APATITE_ORE.get(), new TechnologicaLocation("block/deepslate_apatite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_ARGENTITE_ORE.get(), new TechnologicaLocation("block/deepslate_argentite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_ARSENOPYRITE_ORE.get(), new TechnologicaLocation("block/deepslate_arsenopyrite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_BASTNAESITE_ORE.get(), new TechnologicaLocation("block/deepslate_bastnaesite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_BAUXITE_ORE.get(), new TechnologicaLocation("block/deepslate_bauxite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_BORAX_ORE.get(), new TechnologicaLocation("block/deepslate_borax_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_CASSITERITE_ORE.get(), new TechnologicaLocation("block/deepslate_cassiterite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_CHROMITE_ORE.get(), new TechnologicaLocation("block/deepslate_chromite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_CINNABAR_ORE.get(), new TechnologicaLocation("block/deepslate_cinnabar_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_COBALTITE_ORE.get(), new TechnologicaLocation("block/deepslate_cobaltite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_CROOKESITE_ORE.get(), new TechnologicaLocation("block/deepslate_crookesite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_GADOLINITE_ORE.get(), new TechnologicaLocation("block/deepslate_gadolinite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_GALENA_ORE.get(), new TechnologicaLocation("block/deepslate_galena_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_GARNIERITE_ORE.get(), new TechnologicaLocation("block/deepslate_garnierite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_ILMENITE_ORE.get(), new TechnologicaLocation("block/deepslate_ilmenite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_LEPIDOLITE_ORE.get(), new TechnologicaLocation("block/deepslate_lepidolite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_MAGNESITE_ORE.get(), new TechnologicaLocation("block/deepslate_magnesite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_MOLYBDENITE_ORE.get(), new TechnologicaLocation("block/deepslate_molybdenite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/deepslate_osmiridium_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_PATRONITE_ORE.get(), new TechnologicaLocation("block/deepslate_patronite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_PENTLANDITE_ORE.get(), new TechnologicaLocation("block/deepslate_pentlandite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_PHOSPHORITE_ORE.get(), new TechnologicaLocation("block/deepslate_phosphorite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_PLATINUM_ORE.get(), new TechnologicaLocation("block/deepslate_platinum_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_PYROLUSITE_ORE.get(), new TechnologicaLocation("block/deepslate_pyrolusite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_RUBY_ORE.get(), new TechnologicaLocation("block/deepslate_ruby_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), new TechnologicaLocation("block/deepslate_sapphire_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_SPODUMENE_ORE.get(), new TechnologicaLocation("block/deepslate_spodumene_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_SYLVANITE_ORE.get(), new TechnologicaLocation("block/deepslate_sylvanite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_TANTALITE_ORE.get(), new TechnologicaLocation("block/deepslate_tantalite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get(), new TechnologicaLocation("block/deepslate_thorianite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_TOPAZ_ORE.get(), new TechnologicaLocation("block/deepslate_topaz_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get(), new TechnologicaLocation("block/deepslate_uraninite_ore"));
		cubeAll(TechnologicaBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(), new TechnologicaLocation("block/deepslate_wolframite_ore"));
	}

	private void doors() {
		doorAll(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), new TechnologicaLocation("block/alchemical_door_bottom"), new TechnologicaLocation("block/alchemical_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.APRICOT_DOOR.get(), new TechnologicaLocation("block/apricot_door_bottom"), new TechnologicaLocation("block/apricot_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.ASPEN_DOOR.get(), new TechnologicaLocation("block/aspen_door_bottom"), new TechnologicaLocation("block/aspen_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.AVOCADO_DOOR.get(), new TechnologicaLocation("block/avocado_door_bottom"), new TechnologicaLocation("block/avocado_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.BANANA_DOOR.get(), new TechnologicaLocation("block/banana_door_bottom"), new TechnologicaLocation("block/banana_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.BENEVOLENT_DOOR.get(), new TechnologicaLocation("block/benevolent_door_bottom"), new TechnologicaLocation("block/benevolent_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.CHERRY_DOOR.get(), new TechnologicaLocation("block/cherry_door_bottom"), new TechnologicaLocation("block/cherry_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.CHESTNUT_DOOR.get(), new TechnologicaLocation("block/chestnut_door_bottom"), new TechnologicaLocation("block/chestnut_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.CINNAMON_DOOR.get(), new TechnologicaLocation("block/cinnamon_door_bottom"), new TechnologicaLocation("block/cinnamon_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.COCONUT_DOOR.get(), new TechnologicaLocation("block/coconut_door_bottom"), new TechnologicaLocation("block/coconut_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), new TechnologicaLocation("block/conductive_door_bottom"), new TechnologicaLocation("block/conductive_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.EBONY_DOOR.get(), new TechnologicaLocation("block/ebony_door_bottom"), new TechnologicaLocation("block/ebony_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), new TechnologicaLocation("block/frostbitten_door_bottom"), new TechnologicaLocation("block/frostbitten_door_top"), "translucent");
		doorAll(TechnologicaBlocks.FRUITFUL_DOOR.get(), new TechnologicaLocation("block/fruitful_door_bottom"), new TechnologicaLocation("block/fruitful_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.INFERNAL_DOOR.get(), new TechnologicaLocation("block/infernal_door_bottom"), new TechnologicaLocation("block/infernal_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.KIWI_DOOR.get(), new TechnologicaLocation("block/kiwi_door_bottom"), new TechnologicaLocation("block/kiwi_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.LEMON_DOOR.get(), new TechnologicaLocation("block/lemon_door_bottom"), new TechnologicaLocation("block/lemon_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.LIME_DOOR.get(), new TechnologicaLocation("block/lime_door_bottom"), new TechnologicaLocation("block/lime_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.MAHOGANY_DOOR.get(), new TechnologicaLocation("block/mahogany_door_bottom"), new TechnologicaLocation("block/mahogany_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.MALEVOLENT_DOOR.get(), new TechnologicaLocation("block/malevolent_door_bottom"), new TechnologicaLocation("block/malevolent_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.MAPLE_DOOR.get(), new TechnologicaLocation("block/maple_door_bottom"), new TechnologicaLocation("block/maple_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.NECROTIC_DOOR.get(), new TechnologicaLocation("block/necrotic_door_bottom"), new TechnologicaLocation("block/necrotic_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.OLIVE_DOOR.get(), new TechnologicaLocation("block/olive_door_bottom"), new TechnologicaLocation("block/olive_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.ORANGE_DOOR.get(), new TechnologicaLocation("block/orange_door_bottom"), new TechnologicaLocation("block/orange_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.PEACH_DOOR.get(), new TechnologicaLocation("block/peach_door_bottom"), new TechnologicaLocation("block/peach_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.PEAR_DOOR.get(), new TechnologicaLocation("block/pear_door_bottom"), new TechnologicaLocation("block/pear_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.PLUM_DOOR.get(), new TechnologicaLocation("block/plum_door_bottom"), new TechnologicaLocation("block/plum_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.REDWOOD_DOOR.get(), new TechnologicaLocation("block/redwood_door_bottom"), new TechnologicaLocation("block/redwood_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.ROSEWOOD_DOOR.get(), new TechnologicaLocation("block/rosewood_door_bottom"), new TechnologicaLocation("block/rosewood_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.RUBBER_DOOR.get(), new TechnologicaLocation("block/rubber_door_bottom"), new TechnologicaLocation("block/rubber_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.TEAK_DOOR.get(), new TechnologicaLocation("block/teak_door_bottom"), new TechnologicaLocation("block/teak_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.WALNUT_DOOR.get(), new TechnologicaLocation("block/walnut_door_bottom"), new TechnologicaLocation("block/walnut_door_top"), "cutout_mipped");
		doorAll(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), new TechnologicaLocation("block/zebrawood_door_bottom"), new TechnologicaLocation("block/zebrawood_door_top"), "cutout_mipped");
	}

	private void fences() {
		fenceAll(TechnologicaBlocks.ALCHEMICAL_FENCE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		fenceAll(TechnologicaBlocks.APRICOT_FENCE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		fenceAll(TechnologicaBlocks.ASPEN_FENCE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		fenceAll(TechnologicaBlocks.AVOCADO_FENCE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		fenceAll(TechnologicaBlocks.BANANA_FENCE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		fenceAll(TechnologicaBlocks.BENEVOLENT_FENCE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		fenceAll(TechnologicaBlocks.CHERRY_FENCE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		fenceAll(TechnologicaBlocks.CHESTNUT_FENCE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		fenceAll(TechnologicaBlocks.CINNAMON_FENCE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		fenceAll(TechnologicaBlocks.COCONUT_FENCE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		fenceAll(TechnologicaBlocks.CONDUCTIVE_FENCE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		fenceAll(TechnologicaBlocks.EBONY_FENCE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		fenceAll(TechnologicaBlocks.FROSTBITTEN_FENCE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		fenceAll(TechnologicaBlocks.FRUITFUL_FENCE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		fenceAll(TechnologicaBlocks.INFERNAL_FENCE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		fenceAll(TechnologicaBlocks.KIWI_FENCE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		fenceAll(TechnologicaBlocks.LEMON_FENCE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		fenceAll(TechnologicaBlocks.LIME_FENCE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		fenceAll(TechnologicaBlocks.MAHOGANY_FENCE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		fenceAll(TechnologicaBlocks.MALEVOLENT_FENCE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		fenceAll(TechnologicaBlocks.MAPLE_FENCE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		fenceAll(TechnologicaBlocks.NECROTIC_FENCE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		fenceAll(TechnologicaBlocks.OLIVE_FENCE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		fenceAll(TechnologicaBlocks.ORANGE_FENCE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		fenceAll(TechnologicaBlocks.PEACH_FENCE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		fenceAll(TechnologicaBlocks.PEAR_FENCE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		fenceAll(TechnologicaBlocks.PLUM_FENCE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		fenceAll(TechnologicaBlocks.REDWOOD_FENCE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		fenceAll(TechnologicaBlocks.ROSEWOOD_FENCE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		fenceAll(TechnologicaBlocks.RUBBER_FENCE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		fenceAll(TechnologicaBlocks.TEAK_FENCE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		fenceAll(TechnologicaBlocks.WALNUT_FENCE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		fenceAll(TechnologicaBlocks.ZEBRAWOOD_FENCE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void fenceGates() {
		fenceGateAll(TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.ASPEN_FENCE_GATE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.BANANA_FENCE_GATE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.CHERRY_FENCE_GATE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.COCONUT_FENCE_GATE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.EBONY_FENCE_GATE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		fenceGateAll(TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.KIWI_FENCE_GATE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.LEMON_FENCE_GATE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.LIME_FENCE_GATE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.MAPLE_FENCE_GATE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.NECROTIC_FENCE_GATE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.OLIVE_FENCE_GATE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.ORANGE_FENCE_GATE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.PEACH_FENCE_GATE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.PEAR_FENCE_GATE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.PLUM_FENCE_GATE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.RUBBER_FENCE_GATE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.TEAK_FENCE_GATE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.WALNUT_FENCE_GATE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		fenceGateAll(TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void fluids() {
		fluid(TechnologicaBlocks.ARGON.get());
		fluid(TechnologicaBlocks.BRINE.get());
		fluid(TechnologicaBlocks.BROMINE.get());
		fluid(TechnologicaBlocks.CHLORINE.get());
		fluid(TechnologicaBlocks.COOLANT.get());
		fluid(TechnologicaBlocks.FLUORINE.get());
		fluid(TechnologicaBlocks.GASOLINE.get());
		fluid(TechnologicaBlocks.HELIUM.get());
		fluid(TechnologicaBlocks.HYDROGEN.get());
		fluid(TechnologicaBlocks.KRYPTON.get());
		fluid(TechnologicaBlocks.MACHINE_OIL.get());
		fluid(TechnologicaBlocks.MAPLE_SYRUP.get());
		fluid(TechnologicaBlocks.MERCURY.get());
		fluid(TechnologicaBlocks.NATURAL_GAS.get());
		fluid(TechnologicaBlocks.NEON.get());
		fluid(TechnologicaBlocks.NITROGEN.get());
		fluid(TechnologicaBlocks.OIL.get());
		fluid(TechnologicaBlocks.OXYGEN.get());
		fluid(TechnologicaBlocks.RADON.get());
		fluid(TechnologicaBlocks.RUBBER_RESIN.get());
		fluid(TechnologicaBlocks.XENON.get());
	}

	private void leaves() {
		cubeAll(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), new TechnologicaLocation("block/alchemical_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.APRICOT_LEAVES.get(), new TechnologicaLocation("block/apricot_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.ASPEN_LEAVES.get(), new TechnologicaLocation("block/aspen_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.AVOCADO_LEAVES.get(), new TechnologicaLocation("block/avocado_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.BANANA_LEAVES.get(), new TechnologicaLocation("block/banana_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.BENEVOLENT_LEAVES.get(), new TechnologicaLocation("block/benevolent_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.CHERRY_LEAVES.get(), new TechnologicaLocation("block/cherry_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.CHESTNUT_LEAVES.get(), new TechnologicaLocation("block/chestnut_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.CINNAMON_LEAVES.get(), new TechnologicaLocation("block/cinnamon_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.COCONUT_LEAVES.get(), new TechnologicaLocation("block/coconut_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), new TechnologicaLocation("block/conductive_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.CURSED_LEAVES.get(), new TechnologicaLocation("block/cursed_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.EBONY_LEAVES.get(), new TechnologicaLocation("block/ebony_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.FROSTBITTEN_LEAVES.get(), new TechnologicaLocation("block/frostbitten_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.FRUITFUL_LEAVES.get(), new TechnologicaLocation("block/fruitful_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.KIWI_LEAVES.get(), new TechnologicaLocation("block/kiwi_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.LEMON_LEAVES.get(), new TechnologicaLocation("block/lemon_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.LIME_LEAVES.get(), new TechnologicaLocation("block/lime_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.MAHOGANY_LEAVES.get(), new TechnologicaLocation("block/mahogany_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.MALEVOLENT_LEAVES.get(), new TechnologicaLocation("block/malevolent_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.MAPLE_LEAVES.get(), new TechnologicaLocation("block/maple_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.OLIVE_LEAVES.get(), new TechnologicaLocation("block/olive_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.ORANGE_LEAVES.get(), new TechnologicaLocation("block/orange_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.PEACH_LEAVES.get(), new TechnologicaLocation("block/peach_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.PEAR_LEAVES.get(), new TechnologicaLocation("block/pear_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.PLUM_LEAVES.get(), new TechnologicaLocation("block/plum_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.REDWOOD_LEAVES.get(), new TechnologicaLocation("block/redwood_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.ROSEWOOD_LEAVES.get(), new TechnologicaLocation("block/rosewood_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.RUBBER_LEAVES.get(), new TechnologicaLocation("block/rubber_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.TEAK_LEAVES.get(), new TechnologicaLocation("block/teak_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.WALNUT_LEAVES.get(), new TechnologicaLocation("block/walnut_leaves"), "cutout_mipped");
		cubeAll(TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), new TechnologicaLocation("block/zebrawood_leaves"), "cutout_mipped");
	}

	private void logs() {
		logAll(TechnologicaBlocks.ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/alchemical_log"), new TechnologicaLocation("block/alchemical_log_top"));
		logAll(TechnologicaBlocks.APRICOT_LOG.get(), new TechnologicaLocation("block/apricot_log"), new TechnologicaLocation("block/apricot_log_top"));
		logAll(TechnologicaBlocks.ASPEN_LOG.get(), new TechnologicaLocation("block/aspen_log"), new TechnologicaLocation("block/aspen_log_top"));
		logAll(TechnologicaBlocks.AVOCADO_LOG.get(), new TechnologicaLocation("block/avocado_log"), new TechnologicaLocation("block/avocado_log_top"));
		logAll(TechnologicaBlocks.BANANA_LOG.get(), new TechnologicaLocation("block/banana_log"), new TechnologicaLocation("block/banana_log_top"));
		logAll(TechnologicaBlocks.BENEVOLENT_LOG.get(), new TechnologicaLocation("block/benevolent_log"), new TechnologicaLocation("block/benevolent_log_top"));
		logAll(TechnologicaBlocks.CHERRY_LOG.get(), new TechnologicaLocation("block/cherry_log"), new TechnologicaLocation("block/cherry_log_top"));
		logAll(TechnologicaBlocks.CHESTNUT_LOG.get(), new TechnologicaLocation("block/chestnut_log"), new TechnologicaLocation("block/chestnut_log_top"));
		logAll(TechnologicaBlocks.CINNAMON_LOG.get(), new TechnologicaLocation("block/cinnamon_log"), new TechnologicaLocation("block/cinnamon_log_top"));
		logAll(TechnologicaBlocks.COCONUT_LOG.get(), new TechnologicaLocation("block/coconut_log"), new TechnologicaLocation("block/coconut_log_top"));
		logAll(TechnologicaBlocks.CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/conductive_log"), new TechnologicaLocation("block/conductive_log_top"));
		logAll(TechnologicaBlocks.EBONY_LOG.get(), new TechnologicaLocation("block/ebony_log"), new TechnologicaLocation("block/ebony_log_top"));
		withExistingParent(name(TechnologicaBlocks.FROSTBITTEN_LOG.get()), new TechnologicaLocation("block/hollow_log")).texture("end", new TechnologicaLocation("block/frostbitten_log_top")).texture("inside", new TechnologicaLocation("block/stripped_frostbitten_log_solid")).texture("side", new TechnologicaLocation("block/frostbitten_log")).renderType("translucent");
		logAll(TechnologicaBlocks.FRUITFUL_LOG.get(), new TechnologicaLocation("block/fruitful_log"), new TechnologicaLocation("block/fruitful_log_top"));
		logAll(TechnologicaBlocks.INFERNAL_LOG.get(), new TechnologicaLocation("block/infernal_log"), new TechnologicaLocation("block/infernal_log_top"));
		logAll(TechnologicaBlocks.KIWI_LOG.get(), new TechnologicaLocation("block/kiwi_log"), new TechnologicaLocation("block/kiwi_log_top"));
		logAll(TechnologicaBlocks.LEMON_LOG.get(), new TechnologicaLocation("block/lemon_log"), new TechnologicaLocation("block/lemon_log_top"));
		logAll(TechnologicaBlocks.LIME_LOG.get(), new TechnologicaLocation("block/lime_log"), new TechnologicaLocation("block/lime_log_top"));
		logAll(TechnologicaBlocks.MAHOGANY_LOG.get(), new TechnologicaLocation("block/mahogany_log"), new TechnologicaLocation("block/mahogany_log_top"));
		logAll(TechnologicaBlocks.MALEVOLENT_LOG.get(), new TechnologicaLocation("block/malevolent_log"), new TechnologicaLocation("block/malevolent_log_top"));
		logAll(TechnologicaBlocks.MAPLE_LOG.get(), new TechnologicaLocation("block/maple_log"), new TechnologicaLocation("block/maple_log_top"));
		logAll(TechnologicaBlocks.NECROTIC_LOG.get(), new TechnologicaLocation("block/necrotic_log"), new TechnologicaLocation("block/necrotic_log_top"));
		logAll(TechnologicaBlocks.OLIVE_LOG.get(), new TechnologicaLocation("block/olive_log"), new TechnologicaLocation("block/olive_log_top"));
		logAll(TechnologicaBlocks.ORANGE_LOG.get(), new TechnologicaLocation("block/orange_log"), new TechnologicaLocation("block/orange_log_top"));
		logAll(TechnologicaBlocks.PEACH_LOG.get(), new TechnologicaLocation("block/peach_log"), new TechnologicaLocation("block/peach_log_top"));
		logAll(TechnologicaBlocks.PEAR_LOG.get(), new TechnologicaLocation("block/pear_log"), new TechnologicaLocation("block/pear_log_top"));
		logAll(TechnologicaBlocks.PLUM_LOG.get(), new TechnologicaLocation("block/plum_log"), new TechnologicaLocation("block/plum_log_top"));
		logAll(TechnologicaBlocks.REDWOOD_LOG.get(), new TechnologicaLocation("block/redwood_log"), new TechnologicaLocation("block/redwood_log_top"));
		logAll(TechnologicaBlocks.ROSEWOOD_LOG.get(), new TechnologicaLocation("block/rosewood_log"), new TechnologicaLocation("block/rosewood_log_top"));
		logAll(TechnologicaBlocks.RUBBER_LOG.get(), new TechnologicaLocation("block/rubber_log"), new TechnologicaLocation("block/rubber_log_top"));
		logAll(TechnologicaBlocks.TEAK_LOG.get(), new TechnologicaLocation("block/teak_log"), new TechnologicaLocation("block/teak_log_top"));
		logAll(TechnologicaBlocks.WALNUT_LOG.get(), new TechnologicaLocation("block/walnut_log"), new TechnologicaLocation("block/walnut_log_top"));
		logAll(TechnologicaBlocks.ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/zebrawood_log"), new TechnologicaLocation("block/zebrawood_log_top"));
	}

	private void netherOres() {
		cubeAll(TechnologicaBlocks.NETHER_ARGENTITE_ORE.get(), new TechnologicaLocation("block/nether_argentite_ore"));
		cubeAll(TechnologicaBlocks.NETHER_OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/nether_osmiridium_ore"));
		cubeAll(TechnologicaBlocks.NETHER_PLATINUM_ORE.get(), new TechnologicaLocation("block/nether_platinum_ore"));
		cubeAll(TechnologicaBlocks.NETHER_SYLVANITE_ORE.get(), new TechnologicaLocation("block/nether_sylvanite_ore"));
	}

	private void ores() {
		cubeAll(TechnologicaBlocks.APATITE_ORE.get(), new TechnologicaLocation("block/apatite_ore"));
		cubeAll(TechnologicaBlocks.ARGENTITE_ORE.get(), new TechnologicaLocation("block/argentite_ore"));
		cubeAll(TechnologicaBlocks.ARSENOPYRITE_ORE.get(), new TechnologicaLocation("block/arsenopyrite_ore"));
		cubeAll(TechnologicaBlocks.BASTNAESITE_ORE.get(), new TechnologicaLocation("block/bastnaesite_ore"));
		cubeAll(TechnologicaBlocks.BAUXITE_ORE.get(), new TechnologicaLocation("block/bauxite_ore"));
		cubeAll(TechnologicaBlocks.BORAX_ORE.get(), new TechnologicaLocation("block/borax_ore"));
		cubeAll(TechnologicaBlocks.CASSITERITE_ORE.get(), new TechnologicaLocation("block/cassiterite_ore"));
		cubeAll(TechnologicaBlocks.CHROMITE_ORE.get(), new TechnologicaLocation("block/chromite_ore"));
		cubeAll(TechnologicaBlocks.CINNABAR_ORE.get(), new TechnologicaLocation("block/cinnabar_ore"));
		cubeAll(TechnologicaBlocks.COBALTITE_ORE.get(), new TechnologicaLocation("block/cobaltite_ore"));
		cubeAll(TechnologicaBlocks.CROOKESITE_ORE.get(), new TechnologicaLocation("block/crookesite_ore"));
		cubeAll(TechnologicaBlocks.GADOLINITE_ORE.get(), new TechnologicaLocation("block/gadolinite_ore"));
		cubeAll(TechnologicaBlocks.GALENA_ORE.get(), new TechnologicaLocation("block/galena_ore"));
		cubeAll(TechnologicaBlocks.GARNIERITE_ORE.get(), new TechnologicaLocation("block/garnierite_ore"));
		cubeAll(TechnologicaBlocks.ILMENITE_ORE.get(), new TechnologicaLocation("block/ilmenite_ore"));
		cubeAll(TechnologicaBlocks.LEPIDOLITE_ORE.get(), new TechnologicaLocation("block/lepidolite_ore"));
		cubeAll(TechnologicaBlocks.MAGNESITE_ORE.get(), new TechnologicaLocation("block/magnesite_ore"));
		cubeAll(TechnologicaBlocks.MOLYBDENITE_ORE.get(), new TechnologicaLocation("block/molybdenite_ore"));
		cubeAll(TechnologicaBlocks.OSMIRIDIUM_ORE.get(), new TechnologicaLocation("block/osmiridium_ore"));
		cubeAll(TechnologicaBlocks.PATRONITE_ORE.get(), new TechnologicaLocation("block/patronite_ore"));
		cubeAll(TechnologicaBlocks.PENTLANDITE_ORE.get(), new TechnologicaLocation("block/pentlandite_ore"));
		cubeAll(TechnologicaBlocks.PHOSPHORITE_ORE.get(), new TechnologicaLocation("block/phosphorite_ore"));
		cubeAll(TechnologicaBlocks.PLATINUM_ORE.get(), new TechnologicaLocation("block/platinum_ore"));
		cubeAll(TechnologicaBlocks.PYROLUSITE_ORE.get(), new TechnologicaLocation("block/pyrolusite_ore"));
		cubeAll(TechnologicaBlocks.RUBY_ORE.get(), new TechnologicaLocation("block/ruby_ore"));
		cubeAll(TechnologicaBlocks.SAPPHIRE_ORE.get(), new TechnologicaLocation("block/sapphire_ore"));
		cubeAll(TechnologicaBlocks.SPODUMENE_ORE.get(), new TechnologicaLocation("block/spodumene_ore"));
		cubeAll(TechnologicaBlocks.SYLVANITE_ORE.get(), new TechnologicaLocation("block/sylvanite_ore"));
		cubeAll(TechnologicaBlocks.TANTALITE_ORE.get(), new TechnologicaLocation("block/tantalite_ore"));
		cubeAll(TechnologicaBlocks.THORIANITE_ORE.get(), new TechnologicaLocation("block/thorianite_ore"));
		cubeAll(TechnologicaBlocks.TOPAZ_ORE.get(), new TechnologicaLocation("block/topaz_ore"));
		cubeAll(TechnologicaBlocks.URANINITE_ORE.get(), new TechnologicaLocation("block/uraninite_ore"));
		cubeAll(TechnologicaBlocks.WOLFRAMITE_ORE.get(), new TechnologicaLocation("block/wolframite_ore"));
	}

	private void planks() {
		cubeAll(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		cubeAll(TechnologicaBlocks.APRICOT_PLANKS.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		cubeAll(TechnologicaBlocks.ASPEN_PLANKS.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		cubeAll(TechnologicaBlocks.AVOCADO_PLANKS.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		cubeAll(TechnologicaBlocks.BANANA_PLANKS.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		cubeAll(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		cubeAll(TechnologicaBlocks.CHERRY_PLANKS.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		cubeAll(TechnologicaBlocks.CHESTNUT_PLANKS.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		cubeAll(TechnologicaBlocks.CINNAMON_PLANKS.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		cubeAll(TechnologicaBlocks.COCONUT_PLANKS.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		cubeAll(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		cubeAll(TechnologicaBlocks.EBONY_PLANKS.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		cubeAll(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		cubeAll(TechnologicaBlocks.FRUITFUL_PLANKS.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		cubeAll(TechnologicaBlocks.INFERNAL_PLANKS.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		cubeAll(TechnologicaBlocks.KIWI_PLANKS.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		cubeAll(TechnologicaBlocks.LEMON_PLANKS.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		cubeAll(TechnologicaBlocks.LIME_PLANKS.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		cubeAll(TechnologicaBlocks.MAHOGANY_PLANKS.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		cubeAll(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		cubeAll(TechnologicaBlocks.MAPLE_PLANKS.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		cubeAll(TechnologicaBlocks.NECROTIC_PLANKS.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		cubeAll(TechnologicaBlocks.OLIVE_PLANKS.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		cubeAll(TechnologicaBlocks.ORANGE_PLANKS.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		cubeAll(TechnologicaBlocks.PEACH_PLANKS.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		cubeAll(TechnologicaBlocks.PEAR_PLANKS.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		cubeAll(TechnologicaBlocks.PLUM_PLANKS.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		cubeAll(TechnologicaBlocks.REDWOOD_PLANKS.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		cubeAll(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		cubeAll(TechnologicaBlocks.RUBBER_PLANKS.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		cubeAll(TechnologicaBlocks.TEAK_PLANKS.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		cubeAll(TechnologicaBlocks.WALNUT_PLANKS.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		cubeAll(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void pottedSaplings() {
		pottedSapling(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), new TechnologicaLocation("block/ancient_ambrosia_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), new TechnologicaLocation("block/apricot_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), new TechnologicaLocation("block/aspen_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), new TechnologicaLocation("block/avocado_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), new TechnologicaLocation("block/banana_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/benevolent_apothecary_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), new TechnologicaLocation("block/cherry_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), new TechnologicaLocation("block/chestnut_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), new TechnologicaLocation("block/cinnamon_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), new TechnologicaLocation("block/coconut_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), new TechnologicaLocation("block/cryogenic_spire_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), new TechnologicaLocation("block/ebony_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), new TechnologicaLocation("block/kiwi_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), new TechnologicaLocation("block/lemon_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), new TechnologicaLocation("block/lime_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), new TechnologicaLocation("block/mahogany_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), new TechnologicaLocation("block/maple_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/malevolent_apothecary_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), new TechnologicaLocation("block/necrotic_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), new TechnologicaLocation("block/olive_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), new TechnologicaLocation("block/orange_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), new TechnologicaLocation("block/peach_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), new TechnologicaLocation("block/pear_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), new TechnologicaLocation("block/plum_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), new TechnologicaLocation("block/redwood_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), new TechnologicaLocation("block/rosewood_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), new TechnologicaLocation("block/rubber_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/serendipitous_apothecary_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), new TechnologicaLocation("block/thunderous_conductor_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), new TechnologicaLocation("block/towering_inferno_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), new TechnologicaLocation("block/teak_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), new TechnologicaLocation("block/walnut_sapling"), "cutout_mipped");
		pottedSapling(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), new TechnologicaLocation("block/zebrawood_sapling"), "cutout_mipped");
	}

	private void pressurePlates() {
		pressurePlateAll(TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/alchemical_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/apricot_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/aspen_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), new TechnologicaLocation("block/avocado_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), new TechnologicaLocation("block/banana_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/benevolent_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cherry_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/chestnut_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/coconut_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/conductive_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/ebony_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		pressurePlateAll(TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/fruitful_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), new TechnologicaLocation("block/infernal_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), new TechnologicaLocation("block/kiwi_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lemon_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), new TechnologicaLocation("block/lime_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), new TechnologicaLocation("block/mahogany_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/malevolent_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/maple_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get(), new TechnologicaLocation("block/necrotic_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/olive_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), new TechnologicaLocation("block/orange_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), new TechnologicaLocation("block/peach_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), new TechnologicaLocation("block/pear_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), new TechnologicaLocation("block/plum_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/redwood_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rosewood_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), new TechnologicaLocation("block/rubber_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), new TechnologicaLocation("block/teak_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), new TechnologicaLocation("block/walnut_planks"), "solid");
		pressurePlateAll(TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void saplings() {
		sapling(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), new TechnologicaLocation("block/ancient_ambrosia_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.APRICOT_SAPLING.get(), new TechnologicaLocation("block/apricot_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.ASPEN_SAPLING.get(), new TechnologicaLocation("block/aspen_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.AVOCADO_SAPLING.get(), new TechnologicaLocation("block/avocado_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.BANANA_SAPLING.get(), new TechnologicaLocation("block/banana_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/benevolent_apothecary_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.CHERRY_SAPLING.get(), new TechnologicaLocation("block/cherry_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.CHESTNUT_SAPLING.get(), new TechnologicaLocation("block/chestnut_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.CINNAMON_SAPLING.get(), new TechnologicaLocation("block/cinnamon_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.COCONUT_SAPLING.get(), new TechnologicaLocation("block/coconut_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), new TechnologicaLocation("block/cryogenic_spire_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.EBONY_SAPLING.get(), new TechnologicaLocation("block/ebony_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.KIWI_SAPLING.get(), new TechnologicaLocation("block/kiwi_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.LEMON_SAPLING.get(), new TechnologicaLocation("block/lemon_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.LIME_SAPLING.get(), new TechnologicaLocation("block/lime_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.MAHOGANY_SAPLING.get(), new TechnologicaLocation("block/mahogany_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.MAPLE_SAPLING.get(), new TechnologicaLocation("block/maple_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/malevolent_apothecary_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.NECROTIC_SAPLING.get(), new TechnologicaLocation("block/necrotic_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.OLIVE_SAPLING.get(), new TechnologicaLocation("block/olive_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.ORANGE_SAPLING.get(), new TechnologicaLocation("block/orange_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.PEACH_SAPLING.get(), new TechnologicaLocation("block/peach_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.PEAR_SAPLING.get(), new TechnologicaLocation("block/pear_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.PLUM_SAPLING.get(), new TechnologicaLocation("block/plum_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.REDWOOD_SAPLING.get(), new TechnologicaLocation("block/redwood_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), new TechnologicaLocation("block/rosewood_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.RUBBER_SAPLING.get(), new TechnologicaLocation("block/rubber_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), new TechnologicaLocation("block/serendipitous_apothecary_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), new TechnologicaLocation("block/thunderous_conductor_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), new TechnologicaLocation("block/towering_inferno_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.TEAK_SAPLING.get(), new TechnologicaLocation("block/teak_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.WALNUT_SAPLING.get(), new TechnologicaLocation("block/walnut_sapling"), "cutout_mipped");
		sapling(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), new TechnologicaLocation("block/zebrawood_sapling"), "cutout_mipped");
	}

	private void signs() {
		sign(TechnologicaBlocks.ALCHEMICAL_SIGN.get(), new TechnologicaLocation("block/alchemical_planks"), "cutout");
		sign(TechnologicaBlocks.APRICOT_SIGN.get(), new TechnologicaLocation("block/apricot_planks"), "cutout");
		sign(TechnologicaBlocks.ASPEN_SIGN.get(), new TechnologicaLocation("block/aspen_planks"), "cutout");
		sign(TechnologicaBlocks.AVOCADO_SIGN.get(), new TechnologicaLocation("block/avocado_planks"), "cutout");
		sign(TechnologicaBlocks.BANANA_SIGN.get(), new TechnologicaLocation("block/banana_planks"), "cutout");
		sign(TechnologicaBlocks.BENEVOLENT_SIGN.get(), new TechnologicaLocation("block/benevolent_planks"), "cutout");
		sign(TechnologicaBlocks.CHERRY_SIGN.get(), new TechnologicaLocation("block/cherry_planks"), "cutout");
		sign(TechnologicaBlocks.CHESTNUT_SIGN.get(), new TechnologicaLocation("block/chestnut_planks"), "cutout");
		sign(TechnologicaBlocks.CINNAMON_SIGN.get(), new TechnologicaLocation("block/cinnamon_planks"), "cutout");
		sign(TechnologicaBlocks.COCONUT_SIGN.get(), new TechnologicaLocation("block/coconut_planks"), "cutout");
		sign(TechnologicaBlocks.CONDUCTIVE_SIGN.get(), new TechnologicaLocation("block/conductive_planks"), "cutout");
		sign(TechnologicaBlocks.EBONY_SIGN.get(), new TechnologicaLocation("block/ebony_planks"), "cutout");
		sign(TechnologicaBlocks.FROSTBITTEN_SIGN.get(), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		sign(TechnologicaBlocks.FRUITFUL_SIGN.get(), new TechnologicaLocation("block/fruitful_planks"), "cutout");
		sign(TechnologicaBlocks.INFERNAL_SIGN.get(), new TechnologicaLocation("block/infernal_planks"), "cutout");
		sign(TechnologicaBlocks.KIWI_SIGN.get(), new TechnologicaLocation("block/kiwi_planks"), "cutout");
		sign(TechnologicaBlocks.LEMON_SIGN.get(), new TechnologicaLocation("block/lemon_planks"), "cutout");
		sign(TechnologicaBlocks.LIME_SIGN.get(), new TechnologicaLocation("block/lime_planks"), "cutout");
		sign(TechnologicaBlocks.MAHOGANY_SIGN.get(), new TechnologicaLocation("block/mahogany_planks"), "cutout");
		sign(TechnologicaBlocks.MALEVOLENT_SIGN.get(), new TechnologicaLocation("block/malevolent_planks"), "cutout");
		sign(TechnologicaBlocks.MAPLE_SIGN.get(), new TechnologicaLocation("block/maple_planks"), "cutout");
		sign(TechnologicaBlocks.NECROTIC_SIGN.get(), new TechnologicaLocation("block/necrotic_planks"), "cutout");
		sign(TechnologicaBlocks.OLIVE_SIGN.get(), new TechnologicaLocation("block/olive_planks"), "cutout");
		sign(TechnologicaBlocks.ORANGE_SIGN.get(), new TechnologicaLocation("block/orange_planks"), "cutout");
		sign(TechnologicaBlocks.PEACH_SIGN.get(), new TechnologicaLocation("block/peach_planks"), "cutout");
		sign(TechnologicaBlocks.PEAR_SIGN.get(), new TechnologicaLocation("block/pear_planks"), "cutout");
		sign(TechnologicaBlocks.PLUM_SIGN.get(), new TechnologicaLocation("block/plum_planks"), "cutout");
		sign(TechnologicaBlocks.REDWOOD_SIGN.get(), new TechnologicaLocation("block/redwood_planks"), "cutout");
		sign(TechnologicaBlocks.ROSEWOOD_SIGN.get(), new TechnologicaLocation("block/rosewood_planks"), "cutout");
		sign(TechnologicaBlocks.RUBBER_SIGN.get(), new TechnologicaLocation("block/rubber_planks"), "cutout");
		sign(TechnologicaBlocks.TEAK_SIGN.get(), new TechnologicaLocation("block/teak_planks"), "cutout");
		sign(TechnologicaBlocks.WALNUT_SIGN.get(), new TechnologicaLocation("block/walnut_planks"), "cutout");
		sign(TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), new TechnologicaLocation("block/zebrawood_planks"), "cutout");
	}

	private void slabs() {
		slabAll(TechnologicaBlocks.ALCHEMICAL_SLAB.get(), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), "solid");
		slabAll(TechnologicaBlocks.APRICOT_SLAB.get(), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), "solid");
		slabAll(TechnologicaBlocks.ASPEN_SLAB.get(), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), "solid");
		slabAll(TechnologicaBlocks.AVOCADO_SLAB.get(), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), "solid");
		slabAll(TechnologicaBlocks.BANANA_SLAB.get(), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), "solid");
		slabAll(TechnologicaBlocks.BENEVOLENT_SLAB.get(), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), "solid");
		slabAll(TechnologicaBlocks.CHERRY_SLAB.get(), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), "solid");
		slabAll(TechnologicaBlocks.CHESTNUT_SLAB.get(), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), "solid");
		slabAll(TechnologicaBlocks.CINNAMON_SLAB.get(), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		slabAll(TechnologicaBlocks.COCONUT_SLAB.get(), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), "solid");
		slabAll(TechnologicaBlocks.CONDUCTIVE_SLAB.get(), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), "solid");
		slabAll(TechnologicaBlocks.EBONY_SLAB.get(), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), "solid");
		slabAll(TechnologicaBlocks.FROSTBITTEN_SLAB.get(), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		slabAll(TechnologicaBlocks.FRUITFUL_SLAB.get(), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), "solid");
		slabAll(TechnologicaBlocks.INFERNAL_SLAB.get(), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), "solid");
		slabAll(TechnologicaBlocks.KIWI_SLAB.get(), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), "solid");
		slabAll(TechnologicaBlocks.LEMON_SLAB.get(), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), "solid");
		slabAll(TechnologicaBlocks.LIME_SLAB.get(), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), "solid");
		slabAll(TechnologicaBlocks.MAHOGANY_SLAB.get(), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), "solid");
		slabAll(TechnologicaBlocks.MALEVOLENT_SLAB.get(), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), "solid");
		slabAll(TechnologicaBlocks.MAPLE_SLAB.get(), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), "solid");
		slabAll(TechnologicaBlocks.NECROTIC_SLAB.get(), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), "solid");
		slabAll(TechnologicaBlocks.OLIVE_SLAB.get(), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), "solid");
		slabAll(TechnologicaBlocks.ORANGE_SLAB.get(), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), "solid");
		slabAll(TechnologicaBlocks.PEACH_SLAB.get(), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), "solid");
		slabAll(TechnologicaBlocks.PEAR_SLAB.get(), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), "solid");
		slabAll(TechnologicaBlocks.PLUM_SLAB.get(), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), "solid");
		slabAll(TechnologicaBlocks.REDWOOD_SLAB.get(), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), "solid");
		slabAll(TechnologicaBlocks.ROSEWOOD_SLAB.get(), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), "solid");
		slabAll(TechnologicaBlocks.RUBBER_SLAB.get(), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), "solid");
		slabAll(TechnologicaBlocks.TEAK_SLAB.get(), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), "solid");
		slabAll(TechnologicaBlocks.WALNUT_SLAB.get(), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), "solid");
		slabAll(TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void stairs() {
		stairsAll(TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), new TechnologicaLocation("block/alchemical_planks"), "solid");
		stairsAll(TechnologicaBlocks.APRICOT_STAIRS.get(), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), new TechnologicaLocation("block/apricot_planks"), "solid");
		stairsAll(TechnologicaBlocks.ASPEN_STAIRS.get(), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), new TechnologicaLocation("block/aspen_planks"), "solid");
		stairsAll(TechnologicaBlocks.AVOCADO_STAIRS.get(), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), new TechnologicaLocation("block/avocado_planks"), "solid");
		stairsAll(TechnologicaBlocks.BANANA_STAIRS.get(), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), new TechnologicaLocation("block/banana_planks"), "solid");
		stairsAll(TechnologicaBlocks.BENEVOLENT_STAIRS.get(), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), new TechnologicaLocation("block/benevolent_planks"), "solid");
		stairsAll(TechnologicaBlocks.CHERRY_STAIRS.get(), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), new TechnologicaLocation("block/cherry_planks"), "solid");
		stairsAll(TechnologicaBlocks.CHESTNUT_STAIRS.get(), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), new TechnologicaLocation("block/chestnut_planks"), "solid");
		stairsAll(TechnologicaBlocks.CINNAMON_STAIRS.get(), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), new TechnologicaLocation("block/cinnamon_planks"), "solid");
		stairsAll(TechnologicaBlocks.COCONUT_STAIRS.get(), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), new TechnologicaLocation("block/coconut_planks"), "solid");
		stairsAll(TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), new TechnologicaLocation("block/conductive_planks"), "solid");
		stairsAll(TechnologicaBlocks.EBONY_STAIRS.get(), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), new TechnologicaLocation("block/ebony_planks"), "solid");
		stairsAll(TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), new TechnologicaLocation("block/frostbitten_planks"), "translucent");
		stairsAll(TechnologicaBlocks.FRUITFUL_STAIRS.get(), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), new TechnologicaLocation("block/fruitful_planks"), "solid");
		stairsAll(TechnologicaBlocks.INFERNAL_STAIRS.get(), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), new TechnologicaLocation("block/infernal_planks"), "solid");
		stairsAll(TechnologicaBlocks.KIWI_STAIRS.get(), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), new TechnologicaLocation("block/kiwi_planks"), "solid");
		stairsAll(TechnologicaBlocks.LEMON_STAIRS.get(), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), new TechnologicaLocation("block/lemon_planks"), "solid");
		stairsAll(TechnologicaBlocks.LIME_STAIRS.get(), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), new TechnologicaLocation("block/lime_planks"), "solid");
		stairsAll(TechnologicaBlocks.MAHOGANY_STAIRS.get(), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), new TechnologicaLocation("block/mahogany_planks"), "solid");
		stairsAll(TechnologicaBlocks.MALEVOLENT_STAIRS.get(), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), new TechnologicaLocation("block/malevolent_planks"), "solid");
		stairsAll(TechnologicaBlocks.MAPLE_STAIRS.get(), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), new TechnologicaLocation("block/maple_planks"), "solid");
		stairsAll(TechnologicaBlocks.NECROTIC_STAIRS.get(), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), new TechnologicaLocation("block/necrotic_planks"), "solid");
		stairsAll(TechnologicaBlocks.OLIVE_STAIRS.get(), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), new TechnologicaLocation("block/olive_planks"), "solid");
		stairsAll(TechnologicaBlocks.ORANGE_STAIRS.get(), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), new TechnologicaLocation("block/orange_planks"), "solid");
		stairsAll(TechnologicaBlocks.PEACH_STAIRS.get(), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), new TechnologicaLocation("block/peach_planks"), "solid");
		stairsAll(TechnologicaBlocks.PEAR_STAIRS.get(), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), new TechnologicaLocation("block/pear_planks"), "solid");
		stairsAll(TechnologicaBlocks.PLUM_STAIRS.get(), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), new TechnologicaLocation("block/plum_planks"), "solid");
		stairsAll(TechnologicaBlocks.REDWOOD_STAIRS.get(), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), new TechnologicaLocation("block/redwood_planks"), "solid");
		stairsAll(TechnologicaBlocks.ROSEWOOD_STAIRS.get(), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), new TechnologicaLocation("block/rosewood_planks"), "solid");
		stairsAll(TechnologicaBlocks.RUBBER_STAIRS.get(), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), new TechnologicaLocation("block/rubber_planks"), "solid");
		stairsAll(TechnologicaBlocks.TEAK_STAIRS.get(), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), new TechnologicaLocation("block/teak_planks"), "solid");
		stairsAll(TechnologicaBlocks.WALNUT_STAIRS.get(), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), new TechnologicaLocation("block/walnut_planks"), "solid");
		stairsAll(TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), new TechnologicaLocation("block/zebrawood_planks"), "solid");
	}

	private void strippedLogs() {
		logAll(TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), new TechnologicaLocation("block/stripped_alchemical_log"), new TechnologicaLocation("block/stripped_alchemical_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), new TechnologicaLocation("block/stripped_apricot_log"), new TechnologicaLocation("block/stripped_apricot_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), new TechnologicaLocation("block/stripped_aspen_log"), new TechnologicaLocation("block/stripped_aspen_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), new TechnologicaLocation("block/stripped_avocado_log"), new TechnologicaLocation("block/stripped_avocado_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), new TechnologicaLocation("block/stripped_banana_log"), new TechnologicaLocation("block/stripped_banana_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_benevolent_log"), new TechnologicaLocation("block/stripped_benevolent_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), new TechnologicaLocation("block/stripped_cherry_log"), new TechnologicaLocation("block/stripped_cherry_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), new TechnologicaLocation("block/stripped_chestnut_log"), new TechnologicaLocation("block/stripped_chestnut_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), new TechnologicaLocation("block/stripped_cinnamon_log"), new TechnologicaLocation("block/stripped_cinnamon_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), new TechnologicaLocation("block/stripped_coconut_log"), new TechnologicaLocation("block/stripped_coconut_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), new TechnologicaLocation("block/stripped_conductive_log"), new TechnologicaLocation("block/stripped_conductive_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), new TechnologicaLocation("block/stripped_ebony_log"), new TechnologicaLocation("block/stripped_ebony_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), new TechnologicaLocation("block/stripped_frostbitten_log"), new TechnologicaLocation("block/stripped_frostbitten_log_top"), "translucent");
		logAll(TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), new TechnologicaLocation("block/stripped_fruitful_log"), new TechnologicaLocation("block/stripped_fruitful_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), new TechnologicaLocation("block/stripped_infernal_log"), new TechnologicaLocation("block/stripped_infernal_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), new TechnologicaLocation("block/stripped_kiwi_log"), new TechnologicaLocation("block/stripped_kiwi_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), new TechnologicaLocation("block/stripped_lemon_log"), new TechnologicaLocation("block/stripped_lemon_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_LIME_LOG.get(), new TechnologicaLocation("block/stripped_lime_log"), new TechnologicaLocation("block/stripped_lime_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), new TechnologicaLocation("block/stripped_mahogany_log"), new TechnologicaLocation("block/stripped_mahogany_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), new TechnologicaLocation("block/stripped_malevolent_log"), new TechnologicaLocation("block/stripped_malevolent_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), new TechnologicaLocation("block/stripped_maple_log"), new TechnologicaLocation("block/stripped_maple_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_NECROTIC_LOG.get(), new TechnologicaLocation("block/stripped_necrotic_log"), new TechnologicaLocation("block/stripped_necrotic_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), new TechnologicaLocation("block/stripped_olive_log"), new TechnologicaLocation("block/stripped_olive_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), new TechnologicaLocation("block/stripped_orange_log"), new TechnologicaLocation("block/stripped_orange_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), new TechnologicaLocation("block/stripped_peach_log"), new TechnologicaLocation("block/stripped_peach_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), new TechnologicaLocation("block/stripped_pear_log"), new TechnologicaLocation("block/stripped_pear_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), new TechnologicaLocation("block/stripped_plum_log"), new TechnologicaLocation("block/stripped_plum_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), new TechnologicaLocation("block/stripped_redwood_log"), new TechnologicaLocation("block/stripped_redwood_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), new TechnologicaLocation("block/stripped_rosewood_log"), new TechnologicaLocation("block/stripped_rosewood_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), new TechnologicaLocation("block/stripped_rubber_log"), new TechnologicaLocation("block/stripped_rubber_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), new TechnologicaLocation("block/stripped_teak_log"), new TechnologicaLocation("block/stripped_teak_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), new TechnologicaLocation("block/stripped_walnut_log"), new TechnologicaLocation("block/stripped_walnut_log_top"));
		logAll(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), new TechnologicaLocation("block/stripped_zebrawood_log"), new TechnologicaLocation("block/stripped_zebrawood_log_top"));
	}

	private void strippedWood() {
		logAll(TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/stripped_alchemical_log"), new TechnologicaLocation("block/stripped_alchemical_log"));
		logAll(TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get(), new TechnologicaLocation("block/stripped_apricot_log"), new TechnologicaLocation("block/stripped_apricot_log"));
		logAll(TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get(), new TechnologicaLocation("block/stripped_aspen_log"), new TechnologicaLocation("block/stripped_aspen_log"));
		logAll(TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get(), new TechnologicaLocation("block/stripped_avocado_log"), new TechnologicaLocation("block/stripped_avocado_log"));
		logAll(TechnologicaBlocks.STRIPPED_BANANA_WOOD.get(), new TechnologicaLocation("block/stripped_banana_log"), new TechnologicaLocation("block/stripped_banana_log"));
		logAll(TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_benevolent_log"), new TechnologicaLocation("block/stripped_benevolent_log"));
		logAll(TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get(), new TechnologicaLocation("block/stripped_cherry_log"), new TechnologicaLocation("block/stripped_cherry_log"));
		logAll(TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get(), new TechnologicaLocation("block/stripped_chestnut_log"), new TechnologicaLocation("block/stripped_chestnut_log"));
		logAll(TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get(), new TechnologicaLocation("block/stripped_cinnamon_log"), new TechnologicaLocation("block/stripped_cinnamon_log"));
		logAll(TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get(), new TechnologicaLocation("block/stripped_coconut_log"), new TechnologicaLocation("block/stripped_coconut_log"));
		logAll(TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/stripped_conductive_log"), new TechnologicaLocation("block/stripped_conductive_log"));
		logAll(TechnologicaBlocks.STRIPPED_EBONY_WOOD.get(), new TechnologicaLocation("block/stripped_ebony_log"), new TechnologicaLocation("block/stripped_ebony_log"));
		logAll(TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/stripped_frostbitten_log"), new TechnologicaLocation("block/stripped_frostbitten_log"), "translucent");
		logAll(TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get(), new TechnologicaLocation("block/stripped_fruitful_log"), new TechnologicaLocation("block/stripped_fruitful_log"));
		logAll(TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get(), new TechnologicaLocation("block/stripped_infernal_log"), new TechnologicaLocation("block/stripped_infernal_log"));
		logAll(TechnologicaBlocks.STRIPPED_KIWI_WOOD.get(), new TechnologicaLocation("block/stripped_kiwi_log"), new TechnologicaLocation("block/stripped_kiwi_log"));
		logAll(TechnologicaBlocks.STRIPPED_LEMON_WOOD.get(), new TechnologicaLocation("block/stripped_lemon_log"), new TechnologicaLocation("block/stripped_lemon_log"));
		logAll(TechnologicaBlocks.STRIPPED_LIME_WOOD.get(), new TechnologicaLocation("block/stripped_lime_log"), new TechnologicaLocation("block/stripped_lime_log"));
		logAll(TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get(), new TechnologicaLocation("block/stripped_mahogany_log"), new TechnologicaLocation("block/stripped_mahogany_log"));
		logAll(TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/stripped_malevolent_log"), new TechnologicaLocation("block/stripped_malevolent_log"));
		logAll(TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get(), new TechnologicaLocation("block/stripped_maple_log"), new TechnologicaLocation("block/stripped_maple_log"));
		logAll(TechnologicaBlocks.STRIPPED_NECROTIC_WOOD.get(), new TechnologicaLocation("block/stripped_necrotic_log"), new TechnologicaLocation("block/stripped_necrotic_log"));
		logAll(TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get(), new TechnologicaLocation("block/stripped_olive_log"), new TechnologicaLocation("block/stripped_olive_log"));
		logAll(TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get(), new TechnologicaLocation("block/stripped_orange_log"), new TechnologicaLocation("block/stripped_orange_log"));
		logAll(TechnologicaBlocks.STRIPPED_PEACH_WOOD.get(), new TechnologicaLocation("block/stripped_peach_log"), new TechnologicaLocation("block/stripped_peach_log"));
		logAll(TechnologicaBlocks.STRIPPED_PEAR_WOOD.get(), new TechnologicaLocation("block/stripped_pear_log"), new TechnologicaLocation("block/stripped_pear_log"));
		logAll(TechnologicaBlocks.STRIPPED_PLUM_WOOD.get(), new TechnologicaLocation("block/stripped_plum_log"), new TechnologicaLocation("block/stripped_plum_log"));
		logAll(TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_redwood_log"), new TechnologicaLocation("block/stripped_redwood_log"));
		logAll(TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_rosewood_log"), new TechnologicaLocation("block/stripped_rosewood_log"));
		logAll(TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get(), new TechnologicaLocation("block/stripped_rubber_log"), new TechnologicaLocation("block/stripped_rubber_log"));
		logAll(TechnologicaBlocks.STRIPPED_TEAK_WOOD.get(), new TechnologicaLocation("block/stripped_teak_log"), new TechnologicaLocation("block/stripped_teak_log"));
		logAll(TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get(), new TechnologicaLocation("block/stripped_walnut_log"), new TechnologicaLocation("block/stripped_walnut_log"));
		logAll(TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/stripped_zebrawood_log"), new TechnologicaLocation("block/stripped_zebrawood_log"));
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
		trapdoorAll(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), new TechnologicaLocation("block/alchemical_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), new TechnologicaLocation("block/apricot_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.ASPEN_TRAPDOOR.get(), new TechnologicaLocation("block/aspen_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), new TechnologicaLocation("block/avocado_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.BANANA_TRAPDOOR.get(), new TechnologicaLocation("block/banana_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), new TechnologicaLocation("block/benevolent_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.CHERRY_TRAPDOOR.get(), new TechnologicaLocation("block/cherry_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), new TechnologicaLocation("block/chestnut_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), new TechnologicaLocation("block/cinnamon_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.COCONUT_TRAPDOOR.get(), new TechnologicaLocation("block/coconut_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), new TechnologicaLocation("block/conductive_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.EBONY_TRAPDOOR.get(), new TechnologicaLocation("block/ebony_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), new TechnologicaLocation("block/frostbitten_trapdoor"), "translucent");
		trapdoorAll(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), new TechnologicaLocation("block/fruitful_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), new TechnologicaLocation("block/infernal_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.KIWI_TRAPDOOR.get(), new TechnologicaLocation("block/kiwi_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.LEMON_TRAPDOOR.get(), new TechnologicaLocation("block/lemon_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.LIME_TRAPDOOR.get(), new TechnologicaLocation("block/lime_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), new TechnologicaLocation("block/mahogany_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), new TechnologicaLocation("block/malevolent_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.MAPLE_TRAPDOOR.get(), new TechnologicaLocation("block/maple_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), new TechnologicaLocation("block/necrotic_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.OLIVE_TRAPDOOR.get(), new TechnologicaLocation("block/olive_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.ORANGE_TRAPDOOR.get(), new TechnologicaLocation("block/orange_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.PEACH_TRAPDOOR.get(), new TechnologicaLocation("block/peach_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.PEAR_TRAPDOOR.get(), new TechnologicaLocation("block/pear_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.PLUM_TRAPDOOR.get(), new TechnologicaLocation("block/plum_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/redwood_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/rosewood_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.RUBBER_TRAPDOOR.get(), new TechnologicaLocation("block/rubber_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.TEAK_TRAPDOOR.get(), new TechnologicaLocation("block/teak_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.WALNUT_TRAPDOOR.get(), new TechnologicaLocation("block/walnut_trapdoor"), "cutout_mipped");
		trapdoorAll(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), new TechnologicaLocation("block/zebrawood_trapdoor"), "cutout_mipped");
	}

	private void wood() {
		logAll(TechnologicaBlocks.ALCHEMICAL_WOOD.get(), new TechnologicaLocation("block/alchemical_log"), new TechnologicaLocation("block/alchemical_log"));
		logAll(TechnologicaBlocks.APRICOT_WOOD.get(), new TechnologicaLocation("block/apricot_log"), new TechnologicaLocation("block/apricot_log"));
		logAll(TechnologicaBlocks.ASPEN_WOOD.get(), new TechnologicaLocation("block/aspen_log"), new TechnologicaLocation("block/aspen_log"));
		logAll(TechnologicaBlocks.AVOCADO_WOOD.get(), new TechnologicaLocation("block/avocado_log"), new TechnologicaLocation("block/avocado_log"));
		logAll(TechnologicaBlocks.BANANA_WOOD.get(), new TechnologicaLocation("block/banana_log"), new TechnologicaLocation("block/banana_log"));
		logAll(TechnologicaBlocks.BENEVOLENT_WOOD.get(), new TechnologicaLocation("block/benevolent_log"), new TechnologicaLocation("block/benevolent_log"));
		logAll(TechnologicaBlocks.CHERRY_WOOD.get(), new TechnologicaLocation("block/cherry_log"), new TechnologicaLocation("block/cherry_log"));
		logAll(TechnologicaBlocks.CHESTNUT_WOOD.get(), new TechnologicaLocation("block/chestnut_log"), new TechnologicaLocation("block/chestnut_log"));
		logAll(TechnologicaBlocks.CINNAMON_WOOD.get(), new TechnologicaLocation("block/cinnamon_log"), new TechnologicaLocation("block/cinnamon_log"));
		logAll(TechnologicaBlocks.COCONUT_WOOD.get(), new TechnologicaLocation("block/coconut_log"), new TechnologicaLocation("block/coconut_log"));
		logAll(TechnologicaBlocks.CONDUCTIVE_WOOD.get(), new TechnologicaLocation("block/conductive_log"), new TechnologicaLocation("block/conductive_log"));
		logAll(TechnologicaBlocks.EBONY_WOOD.get(), new TechnologicaLocation("block/ebony_log"), new TechnologicaLocation("block/ebony_log"));
		logAll(TechnologicaBlocks.FROSTBITTEN_WOOD.get(), new TechnologicaLocation("block/frostbitten_log"), new TechnologicaLocation("block/frostbitten_log"));
		logAll(TechnologicaBlocks.FRUITFUL_WOOD.get(), new TechnologicaLocation("block/fruitful_log"), new TechnologicaLocation("block/fruitful_log"));
		logAll(TechnologicaBlocks.INFERNAL_WOOD.get(), new TechnologicaLocation("block/infernal_log"), new TechnologicaLocation("block/infernal_log"));
		logAll(TechnologicaBlocks.KIWI_WOOD.get(), new TechnologicaLocation("block/kiwi_log"), new TechnologicaLocation("block/kiwi_log"));
		logAll(TechnologicaBlocks.LEMON_WOOD.get(), new TechnologicaLocation("block/lemon_log"), new TechnologicaLocation("block/lemon_log"));
		logAll(TechnologicaBlocks.LIME_WOOD.get(), new TechnologicaLocation("block/lime_log"), new TechnologicaLocation("block/lime_log"));
		logAll(TechnologicaBlocks.MAHOGANY_WOOD.get(), new TechnologicaLocation("block/mahogany_log"), new TechnologicaLocation("block/mahogany_log"));
		logAll(TechnologicaBlocks.MALEVOLENT_WOOD.get(), new TechnologicaLocation("block/malevolent_log"), new TechnologicaLocation("block/malevolent_log"));
		logAll(TechnologicaBlocks.MAPLE_WOOD.get(), new TechnologicaLocation("block/maple_log"), new TechnologicaLocation("block/maple_log"));
		logAll(TechnologicaBlocks.NECROTIC_WOOD.get(), new TechnologicaLocation("block/necrotic_log"), new TechnologicaLocation("block/necrotic_log"));
		logAll(TechnologicaBlocks.OLIVE_WOOD.get(), new TechnologicaLocation("block/olive_log"), new TechnologicaLocation("block/olive_log"));
		logAll(TechnologicaBlocks.ORANGE_WOOD.get(), new TechnologicaLocation("block/orange_log"), new TechnologicaLocation("block/orange_log"));
		logAll(TechnologicaBlocks.PEACH_WOOD.get(), new TechnologicaLocation("block/peach_log"), new TechnologicaLocation("block/peach_log"));
		logAll(TechnologicaBlocks.PEAR_WOOD.get(), new TechnologicaLocation("block/pear_log"), new TechnologicaLocation("block/pear_log"));
		logAll(TechnologicaBlocks.PLUM_WOOD.get(), new TechnologicaLocation("block/plum_log"), new TechnologicaLocation("block/plum_log"));
		logAll(TechnologicaBlocks.REDWOOD_WOOD.get(), new TechnologicaLocation("block/redwood_log"), new TechnologicaLocation("block/redwood_log"));
		logAll(TechnologicaBlocks.ROSEWOOD_WOOD.get(), new TechnologicaLocation("block/rosewood_log"), new TechnologicaLocation("block/rosewood_log"));
		logAll(TechnologicaBlocks.RUBBER_WOOD.get(), new TechnologicaLocation("block/rubber_log"), new TechnologicaLocation("block/rubber_log"));
		logAll(TechnologicaBlocks.TEAK_WOOD.get(), new TechnologicaLocation("block/teak_log"), new TechnologicaLocation("block/teak_log"));
		logAll(TechnologicaBlocks.WALNUT_WOOD.get(), new TechnologicaLocation("block/walnut_log"), new TechnologicaLocation("block/walnut_log"));
		logAll(TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), new TechnologicaLocation("block/zebrawood_log"), new TechnologicaLocation("block/zebrawood_log"));
	}
}
