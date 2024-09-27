package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;
import com.technologica.world.level.block.entity.CarpentryWorkbenchBlockEntity;
import com.technologica.world.level.block.entity.DisplayCaseBlockEntity;
import com.technologica.world.level.block.entity.FastHopperBlockEntity;
import com.technologica.world.level.block.entity.FruitBlockEntity;
import com.technologica.world.level.block.entity.LandMineBlockEntity;
import com.technologica.world.level.block.entity.LightBlockEntity;
import com.technologica.world.level.block.entity.LineShaftBlockEntity;
import com.technologica.world.level.block.entity.LineShaftHangerTileEntity;
import com.technologica.world.level.block.entity.MonitorBlockEntity;
import com.technologica.world.level.block.entity.MulchTileEntity;
import com.technologica.world.level.block.entity.PotionTileEntity;
import com.technologica.world.level.block.entity.RadioactiveOreBlockEntity;
import com.technologica.world.level.block.entity.SawmillBlockEntity;
import com.technologica.world.level.block.entity.TechnologicaSignBlockEntity;
import com.technologica.world.level.block.entity.TechnologicaSkullBlockEntity;
import com.technologica.world.level.block.entity.VanillaSignBlockEntity;
import com.technologica.world.level.block.entity.WindmillBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Block Entity Types. The
 * {@link #init} method is called by {@link Technologica#initDeferredRegisters}
 * and returns a head-count to later be checked during registration and other
 * setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaBlockEntityTypes extends MasterDeferredRegistrar {
	public static final RegistryObject<BlockEntityType<VanillaSignBlockEntity>> VANILLA_SIGN = BLOCK_ENTITY_TYPES.register("mod_sign", () -> BlockEntityType.Builder.of(VanillaSignBlockEntity::new, TechnologicaBlocks.APRICOT_SIGN.get(), TechnologicaBlocks.ASPEN_SIGN.get(), TechnologicaBlocks.AVOCADO_SIGN.get(), TechnologicaBlocks.BANANA_SIGN.get(), TechnologicaBlocks.CHERRY_SIGN.get(), TechnologicaBlocks.CHESTNUT_SIGN.get(), TechnologicaBlocks.CINNAMON_SIGN.get(), TechnologicaBlocks.COCONUT_SIGN.get(), TechnologicaBlocks.EBONY_SIGN.get(), TechnologicaBlocks.KIWI_SIGN.get(), TechnologicaBlocks.LEMON_SIGN.get(), TechnologicaBlocks.LIME_SIGN.get(), TechnologicaBlocks.MAHOGANY_SIGN.get(), TechnologicaBlocks.MAPLE_SIGN.get(), TechnologicaBlocks.OLIVE_SIGN.get(), TechnologicaBlocks.ORANGE_SIGN.get(), TechnologicaBlocks.PEACH_SIGN.get(), TechnologicaBlocks.PEAR_SIGN.get(), TechnologicaBlocks.PLUM_SIGN.get(), TechnologicaBlocks.REDWOOD_SIGN.get(), TechnologicaBlocks.ROSEWOOD_SIGN.get(), TechnologicaBlocks.RUBBER_SIGN.get(), TechnologicaBlocks.TEAK_SIGN.get(), TechnologicaBlocks.WALNUT_SIGN.get(), TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), TechnologicaBlocks.ALCHEMICAL_SIGN.get(), TechnologicaBlocks.BENEVOLENT_SIGN.get(), TechnologicaBlocks.CONDUCTIVE_SIGN.get(), TechnologicaBlocks.FRUITFUL_SIGN.get(), TechnologicaBlocks.INFERNAL_SIGN.get(), TechnologicaBlocks.MALEVOLENT_SIGN.get(), TechnologicaBlocks.APRICOT_WALL_SIGN.get(), TechnologicaBlocks.ASPEN_WALL_SIGN.get(), TechnologicaBlocks.AVOCADO_WALL_SIGN.get(), TechnologicaBlocks.BANANA_WALL_SIGN.get(), TechnologicaBlocks.CHERRY_WALL_SIGN.get(), TechnologicaBlocks.CHESTNUT_WALL_SIGN.get(), TechnologicaBlocks.CINNAMON_WALL_SIGN.get(), TechnologicaBlocks.COCONUT_WALL_SIGN.get(), TechnologicaBlocks.EBONY_WALL_SIGN.get(), TechnologicaBlocks.KIWI_WALL_SIGN.get(), TechnologicaBlocks.LEMON_WALL_SIGN.get(), TechnologicaBlocks.LIME_WALL_SIGN.get(), TechnologicaBlocks.MAHOGANY_WALL_SIGN.get(), TechnologicaBlocks.MAPLE_WALL_SIGN.get(), TechnologicaBlocks.OLIVE_WALL_SIGN.get(), TechnologicaBlocks.ORANGE_WALL_SIGN.get(), TechnologicaBlocks.PEACH_WALL_SIGN.get(), TechnologicaBlocks.PEAR_WALL_SIGN.get(), TechnologicaBlocks.PLUM_WALL_SIGN.get(), TechnologicaBlocks.REDWOOD_WALL_SIGN.get(), TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get(), TechnologicaBlocks.RUBBER_WALL_SIGN.get(), TechnologicaBlocks.TEAK_WALL_SIGN.get(), TechnologicaBlocks.WALNUT_WALL_SIGN.get(), TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get(), TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get(), TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get(), TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get(), TechnologicaBlocks.FRUITFUL_WALL_SIGN.get(), TechnologicaBlocks.INFERNAL_WALL_SIGN.get(), TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<TechnologicaSignBlockEntity>> TECHNOLOGICA_SIGN = BLOCK_ENTITY_TYPES.register("technologica_sign", () -> BlockEntityType.Builder.of(TechnologicaSignBlockEntity::new, TechnologicaBlocks.FROSTBITTEN_SIGN.get(), TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<FruitBlockEntity>> FRUIT_CROP = BLOCK_ENTITY_TYPES.register("fruit_crop", () -> BlockEntityType.Builder.of(FruitBlockEntity::new, TechnologicaBlocks.APRICOT_LEAVES.get(), TechnologicaBlocks.AVOCADO_LEAVES.get(), TechnologicaBlocks.BANANA_LEAVES.get(), TechnologicaBlocks.CHERRY_LEAVES.get(), TechnologicaBlocks.CHESTNUT_LEAVES.get(), TechnologicaBlocks.COCONUT_LEAVES.get(), TechnologicaBlocks.KIWI_LEAVES.get(), TechnologicaBlocks.LEMON_LEAVES.get(), TechnologicaBlocks.LIME_LEAVES.get(), TechnologicaBlocks.OLIVE_LEAVES.get(), TechnologicaBlocks.ORANGE_LEAVES.get(), TechnologicaBlocks.PEACH_LEAVES.get(), TechnologicaBlocks.PEAR_LEAVES.get(), TechnologicaBlocks.PLUM_LEAVES.get(), TechnologicaBlocks.WALNUT_LEAVES.get(), TechnologicaBlocks.FRUITFUL_LEAVES.get(), TechnologicaBlocks.ALCHEMICAL_LEAVES.get()).build(null));
	public static final RegistryObject<BlockEntityType<PotionTileEntity>> POTION_CROP = BLOCK_ENTITY_TYPES.register("potion_crop", () -> BlockEntityType.Builder.of(PotionTileEntity::new, TechnologicaBlocks.BENEVOLENT_LEAVES.get(), TechnologicaBlocks.MALEVOLENT_LEAVES.get()).build(null));
	public static final RegistryObject<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_TILE = BLOCK_ENTITY_TYPES.register("display_tile", () -> BlockEntityType.Builder.of(DisplayCaseBlockEntity::new, TechnologicaBlocks.DISPLAY_CASE.get()).build(null));
	public static final RegistryObject<BlockEntityType<LineShaftBlockEntity>> LINE_SHAFT_TILE = BLOCK_ENTITY_TYPES.register("line_shaft_tile", () -> BlockEntityType.Builder.of(LineShaftBlockEntity::new, TechnologicaBlocks.LINE_SHAFT.get()).build(null));
	public static final RegistryObject<BlockEntityType<LineShaftHangerTileEntity>> LINE_SHAFT_HANGER_TILE = BLOCK_ENTITY_TYPES.register("line_shaft_hanger_tile", () -> BlockEntityType.Builder.of(LineShaftHangerTileEntity::new, TechnologicaBlocks.LINE_SHAFT_HANGER.get()).build(null));
	public static final RegistryObject<BlockEntityType<SawmillBlockEntity>> SAWMILL_TILE = BLOCK_ENTITY_TYPES.register("sawmill_tile", () -> BlockEntityType.Builder.of(SawmillBlockEntity::new, TechnologicaBlocks.SAWMILL_CORE.get()).build(null));
	public static final RegistryObject<BlockEntityType<WindmillBlockEntity>> WINDMILL = BLOCK_ENTITY_TYPES.register("windmill", () -> BlockEntityType.Builder.of(WindmillBlockEntity::new, TechnologicaBlocks.WINDMILL.get()).build(null));
	public static final RegistryObject<BlockEntityType<AnnunciatorBlockEntity>> ANNUNCIATOR_TILE = BLOCK_ENTITY_TYPES.register("annunciator_tile", () -> BlockEntityType.Builder.of(AnnunciatorBlockEntity::new, TechnologicaBlocks.ANNUNCIATOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<MonitorBlockEntity>> MONITOR_TILE = BLOCK_ENTITY_TYPES.register("monitor_tile", () -> BlockEntityType.Builder.of(MonitorBlockEntity::new, TechnologicaBlocks.MONITOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<MulchTileEntity>> MULCH_TILE = BLOCK_ENTITY_TYPES.register("mulch_tile", () -> BlockEntityType.Builder.of(MulchTileEntity::new, TechnologicaBlocks.MULCH.get()).build(null));
	public static final RegistryObject<BlockEntityType<LandMineBlockEntity>> LAND_MINE_TILE = BLOCK_ENTITY_TYPES.register("land_mine_tile", () -> BlockEntityType.Builder.of(LandMineBlockEntity::new, TechnologicaBlocks.LAND_MINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<RadioactiveOreBlockEntity>> RADIOACTIVE_ORE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("radioactive_ore_block_entity", () -> BlockEntityType.Builder.of(RadioactiveOreBlockEntity::new, TechnologicaBlocks.THORIANITE_ORE.get(), TechnologicaBlocks.DEEPSLATE_THORIANITE_ORE.get(), TechnologicaBlocks.URANINITE_ORE.get(), TechnologicaBlocks.DEEPSLATE_URANINITE_ORE.get()).build(null));
	public static final RegistryObject<BlockEntityType<FastHopperBlockEntity>> FAST_HOPPER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("fast_hopper_block_entity", () -> BlockEntityType.Builder.of(FastHopperBlockEntity::new, TechnologicaBlocks.FAST_HOPPER.get()).build(null));
	public static final RegistryObject<BlockEntityType<LightBlockEntity>> LIGHT_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("light_block_entity", () -> BlockEntityType.Builder.of(LightBlockEntity::new, TechnologicaBlocks.LIGHT.get()).build(null));
	public static final RegistryObject<BlockEntityType<TechnologicaSkullBlockEntity>> SKULL = BLOCK_ENTITY_TYPES.register("technologica_skull", () -> BlockEntityType.Builder.of(TechnologicaSkullBlockEntity::new, TechnologicaBlocks.BEEPER_HEAD.get(), TechnologicaBlocks.PEEPER_HEAD.get(), TechnologicaBlocks.SLEEPER_HEAD.get(), TechnologicaBlocks.SWEEPER_HEAD.get(), TechnologicaBlocks.WEEPER_HEAD.get()).build(null));
	public static final RegistryObject<BlockEntityType<CarpentryWorkbenchBlockEntity>> CARPENTY_WORKBENCH = BLOCK_ENTITY_TYPES.register("carpentry_workbench", () -> BlockEntityType.Builder.of(CarpentryWorkbenchBlockEntity::new, TechnologicaBlocks.CARPENTRY_WORKBENCH.get()).build(null));
}
