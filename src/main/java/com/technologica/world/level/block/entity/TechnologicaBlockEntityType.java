package com.technologica.world.level.block.entity;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaBlockEntityType {
	private static final DeferredRegister<BlockEntityType<?>> TILEENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

	public static void init() {
		TILEENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(TILEENTITIES.getEntries().size() + " TILE ENTITIES INITIALIZED");
	}
	
	public static final RegistryObject<BlockEntityType<VanillaSignTileEntity>> MOD_SIGN = TILEENTITIES.register("mod_sign",
			() -> BlockEntityType.Builder.of(VanillaSignTileEntity::new,
					TechnologicaBlocks.APRICOT_SIGN.get(),
					TechnologicaBlocks.ASPEN_SIGN.get(),
					TechnologicaBlocks.AVOCADO_SIGN.get(),
					TechnologicaBlocks.BANANA_SIGN.get(),
					TechnologicaBlocks.CHERRY_SIGN.get(),
					TechnologicaBlocks.CHESTNUT_SIGN.get(),
					TechnologicaBlocks.CINNAMON_SIGN.get(),
					TechnologicaBlocks.COCONUT_SIGN.get(),
					TechnologicaBlocks.EBONY_SIGN.get(),
					TechnologicaBlocks.KIWI_SIGN.get(),
					TechnologicaBlocks.LEMON_SIGN.get(), 
					TechnologicaBlocks.LIME_SIGN.get(),
					TechnologicaBlocks.MAHOGANY_SIGN.get(),
					TechnologicaBlocks.MAPLE_SIGN.get(),
					TechnologicaBlocks.OLIVE_SIGN.get(),
					TechnologicaBlocks.ORANGE_SIGN.get(),
					TechnologicaBlocks.PEACH_SIGN.get(), 
					TechnologicaBlocks.PEAR_SIGN.get(),
					TechnologicaBlocks.PLUM_SIGN.get(),
					TechnologicaBlocks.REDWOOD_SIGN.get(),
					TechnologicaBlocks.ROSEWOOD_SIGN.get(),
					TechnologicaBlocks.RUBBER_SIGN.get(),
					TechnologicaBlocks.TEAK_SIGN.get(),
					TechnologicaBlocks.WALNUT_SIGN.get(),
					TechnologicaBlocks.ZEBRAWOOD_SIGN.get(),
					TechnologicaBlocks.ALCHEMICAL_SIGN.get(),
					TechnologicaBlocks.BENEVOLENT_SIGN.get(),
					TechnologicaBlocks.CONDUCTIVE_SIGN.get(),
					TechnologicaBlocks.FROSTBITTEN_SIGN.get(),
					TechnologicaBlocks.FRUITFUL_SIGN.get(),
					TechnologicaBlocks.INFERNAL_SIGN.get(),
					TechnologicaBlocks.MALEVOLENT_SIGN.get(),
					TechnologicaBlocks.APRICOT_WALL_SIGN.get(),
					TechnologicaBlocks.ASPEN_WALL_SIGN.get(),
					TechnologicaBlocks.AVOCADO_WALL_SIGN.get(),
					TechnologicaBlocks.BANANA_WALL_SIGN.get(),
					TechnologicaBlocks.CHERRY_WALL_SIGN.get(),
					TechnologicaBlocks.CHESTNUT_WALL_SIGN.get(),
					TechnologicaBlocks.CINNAMON_WALL_SIGN.get(),
					TechnologicaBlocks.COCONUT_WALL_SIGN.get(),
					TechnologicaBlocks.EBONY_WALL_SIGN.get(),
					TechnologicaBlocks.KIWI_WALL_SIGN.get(),
					TechnologicaBlocks.LEMON_WALL_SIGN.get(), 
					TechnologicaBlocks.LIME_WALL_SIGN.get(),
					TechnologicaBlocks.MAHOGANY_WALL_SIGN.get(),
					TechnologicaBlocks.MAPLE_WALL_SIGN.get(),
					TechnologicaBlocks.OLIVE_WALL_SIGN.get(),
					TechnologicaBlocks.ORANGE_WALL_SIGN.get(),
					TechnologicaBlocks.PEACH_WALL_SIGN.get(), 
					TechnologicaBlocks.PEAR_WALL_SIGN.get(),
					TechnologicaBlocks.PLUM_WALL_SIGN.get(),
					TechnologicaBlocks.REDWOOD_WALL_SIGN.get(),
					TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get(),
					TechnologicaBlocks.RUBBER_WALL_SIGN.get(),
					TechnologicaBlocks.TEAK_WALL_SIGN.get(),
					TechnologicaBlocks.WALNUT_WALL_SIGN.get(),
					TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get(),
					TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get(),
					TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get(),
					TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get(),
					TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get(),
					TechnologicaBlocks.FRUITFUL_WALL_SIGN.get(),
					TechnologicaBlocks.INFERNAL_WALL_SIGN.get(),
					TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<FruitTileEntity>> FRUIT_CROP = TILEENTITIES.register("fruit_crop",
			() -> BlockEntityType.Builder.of(FruitTileEntity::new,
					TechnologicaBlocks.APRICOT_LEAVES.get(),
					TechnologicaBlocks.AVOCADO_LEAVES.get(),
					TechnologicaBlocks.BANANA_LEAVES.get(),
					TechnologicaBlocks.CHERRY_LEAVES.get(), 
					TechnologicaBlocks.CHESTNUT_LEAVES.get(),
					TechnologicaBlocks.COCONUT_LEAVES.get(), 
					TechnologicaBlocks.KIWI_LEAVES.get(),
					TechnologicaBlocks.LEMON_LEAVES.get(), 
					TechnologicaBlocks.LIME_LEAVES.get(), 
					TechnologicaBlocks.OLIVE_LEAVES.get(),
					TechnologicaBlocks.ORANGE_LEAVES.get(),
					TechnologicaBlocks.PEACH_LEAVES.get(), 
					TechnologicaBlocks.PEAR_LEAVES.get(),
					TechnologicaBlocks.PLUM_LEAVES.get(),
					TechnologicaBlocks.WALNUT_LEAVES.get(),
					TechnologicaBlocks.FRUITFUL_LEAVES.get(),
					TechnologicaBlocks.ALCHEMICAL_LEAVES.get()).build(null));
	public static final RegistryObject<BlockEntityType<PotionTileEntity>> POTION_CROP = TILEENTITIES.register("potion_crop",
			() -> BlockEntityType.Builder.of(PotionTileEntity::new, 
					TechnologicaBlocks.BENEVOLENT_LEAVES.get(), 
					TechnologicaBlocks.MALEVOLENT_LEAVES.get()).build(null));
	public static final RegistryObject<BlockEntityType<DisplayCaseTileEntity>> DISPLAY_TILE = TILEENTITIES.register("display_tile",
			() -> BlockEntityType.Builder.of(DisplayCaseTileEntity::new, 
					TechnologicaBlocks.DISPLAY_CASE.get()).build(null));
	public static final RegistryObject<BlockEntityType<LineShaftTileEntity>> LINE_SHAFT_TILE = TILEENTITIES.register("line_shaft_tile",
			() -> BlockEntityType.Builder.of(LineShaftTileEntity::new, 
					TechnologicaBlocks.LINE_SHAFT.get()).build(null));
	public static final RegistryObject<BlockEntityType<LineShaftHangerTileEntity>> LINE_SHAFT_HANGER_TILE = TILEENTITIES.register("line_shaft_hanger_tile", 
			() -> BlockEntityType.Builder.of(LineShaftHangerTileEntity::new, 
					TechnologicaBlocks.LINE_SHAFT_HANGER.get()).build(null));
	public static final RegistryObject<BlockEntityType<SawmillTileEntity>> SAWMILL_TILE = TILEENTITIES.register("sawmill_tile", 
			() -> BlockEntityType.Builder.of(SawmillTileEntity::new, 
					TechnologicaBlocks.SAWMILL.get()).build(null));
	public static final RegistryObject<BlockEntityType<AnnunciatorTileEntity>> ANNUNCIATOR_TILE = TILEENTITIES.register("annunciator_tile", 
			() -> BlockEntityType.Builder.of(AnnunciatorTileEntity::new, 
					TechnologicaBlocks.ANNUNCIATOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<MulchTileEntity>> MULCH_TILE = TILEENTITIES.register("mulch_tile", 
			() -> BlockEntityType.Builder.of(MulchTileEntity::new, 
					TechnologicaBlocks.MULCH.get()).build(null));
}
