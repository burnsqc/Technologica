package com.technologica.tileentity;

import static com.technologica.Technologica.MODID;

import com.technologica.block.ModBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
	private static final DeferredRegister<TileEntityType<?>> TILEENTITIES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, MODID);

	public static final RegistryObject<TileEntityType<ModSignTileEntity>> MOD_SIGN = TILEENTITIES.register("mod_sign",
			() -> TileEntityType.Builder.create(ModSignTileEntity::new,
					ModBlocks.APRICOT_SIGN.get(),
					ModBlocks.ASPEN_SIGN.get(),
					ModBlocks.AVOCADO_SIGN.get(),
					ModBlocks.BANANA_SIGN.get(),
					ModBlocks.CHERRY_SIGN.get(),
					ModBlocks.CHESTNUT_SIGN.get(),
					ModBlocks.COCONUT_SIGN.get(),
					ModBlocks.EBONY_SIGN.get(),
					ModBlocks.KIWI_SIGN.get(),
					ModBlocks.LEMON_SIGN.get(), 
					ModBlocks.LIME_SIGN.get(),
					ModBlocks.MAHOGANY_SIGN.get(),
					ModBlocks.MAPLE_SIGN.get(),
					ModBlocks.ORANGE_SIGN.get(),
					ModBlocks.PEACH_SIGN.get(), 
					ModBlocks.PEAR_SIGN.get(),
					ModBlocks.PLUM_SIGN.get(),
					ModBlocks.REDWOOD_SIGN.get(),
					ModBlocks.ROSEWOOD_SIGN.get(),
					ModBlocks.RUBBER_SIGN.get(),
					ModBlocks.TEAK_SIGN.get(),
					ModBlocks.WALNUT_SIGN.get(),
					ModBlocks.ZEBRAWOOD_SIGN.get(),
					ModBlocks.ALCHEMICAL_SIGN.get(),
					ModBlocks.BENEVOLENT_SIGN.get(),
					ModBlocks.CONDUCTIVE_SIGN.get(),
					ModBlocks.FROSTBITTEN_SIGN.get(),
					ModBlocks.FRUITFUL_SIGN.get(),
					ModBlocks.INFERNAL_SIGN.get(),
					ModBlocks.MALEVOLENT_SIGN.get(),
					ModBlocks.APRICOT_WALL_SIGN.get(),
					ModBlocks.ASPEN_WALL_SIGN.get(),
					ModBlocks.AVOCADO_WALL_SIGN.get(),
					ModBlocks.BANANA_WALL_SIGN.get(),
					ModBlocks.CHERRY_WALL_SIGN.get(),
					ModBlocks.CHESTNUT_WALL_SIGN.get(),
					ModBlocks.COCONUT_WALL_SIGN.get(),
					ModBlocks.EBONY_WALL_SIGN.get(),
					ModBlocks.KIWI_WALL_SIGN.get(),
					ModBlocks.LEMON_WALL_SIGN.get(), 
					ModBlocks.LIME_WALL_SIGN.get(),
					ModBlocks.MAHOGANY_WALL_SIGN.get(),
					ModBlocks.MAPLE_WALL_SIGN.get(),
					ModBlocks.ORANGE_WALL_SIGN.get(),
					ModBlocks.PEACH_WALL_SIGN.get(), 
					ModBlocks.PEAR_WALL_SIGN.get(),
					ModBlocks.PLUM_WALL_SIGN.get(),
					ModBlocks.REDWOOD_WALL_SIGN.get(),
					ModBlocks.ROSEWOOD_WALL_SIGN.get(),
					ModBlocks.RUBBER_WALL_SIGN.get(),
					ModBlocks.TEAK_WALL_SIGN.get(),
					ModBlocks.WALNUT_WALL_SIGN.get(),
					ModBlocks.ZEBRAWOOD_WALL_SIGN.get(),
					ModBlocks.ALCHEMICAL_WALL_SIGN.get(),
					ModBlocks.BENEVOLENT_WALL_SIGN.get(),
					ModBlocks.CONDUCTIVE_WALL_SIGN.get(),
					ModBlocks.FROSTBITTEN_WALL_SIGN.get(),
					ModBlocks.FRUITFUL_WALL_SIGN.get(),
					ModBlocks.INFERNAL_WALL_SIGN.get(),
					ModBlocks.MALEVOLENT_WALL_SIGN.get()).build(null));
	public static final RegistryObject<TileEntityType<FruitTileEntity>> FRUIT_CROP = TILEENTITIES.register("fruit_crop",
			() -> TileEntityType.Builder.create(FruitTileEntity::new,
					ModBlocks.APRICOT_LEAVES.get(),
					ModBlocks.AVOCADO_LEAVES.get(),
					ModBlocks.BANANA_LEAVES.get(),
					ModBlocks.CHERRY_LEAVES.get(), 
					ModBlocks.CHESTNUT_LEAVES.get(),
					ModBlocks.COCONUT_LEAVES.get(), 
					ModBlocks.KIWI_LEAVES.get(),
					ModBlocks.LEMON_LEAVES.get(), 
					ModBlocks.LIME_LEAVES.get(), 
					ModBlocks.ORANGE_LEAVES.get(),
					ModBlocks.PEACH_LEAVES.get(), 
					ModBlocks.PEAR_LEAVES.get(),
					ModBlocks.PLUM_LEAVES.get(),
					ModBlocks.WALNUT_LEAVES.get(),
					ModBlocks.FRUITFUL_LEAVES.get(),
					ModBlocks.ALCHEMICAL_LEAVES.get()).build(null));
	public static final RegistryObject<TileEntityType<PotionTileEntity>> POTION_CROP = TILEENTITIES.register(
			"potion_crop",
			() -> TileEntityType.Builder
					.create(PotionTileEntity::new, ModBlocks.BENEVOLENT_LEAVES.get(), ModBlocks.MALEVOLENT_LEAVES.get())
					.build(null));
	public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_TILE = TILEENTITIES.register(
			"display_tile",
			() -> TileEntityType.Builder.create(DisplayCaseTileEntity::new, ModBlocks.DISPLAY_CASE.get()).build(null));
	public static final RegistryObject<TileEntityType<LineShaftTileEntity>> LINE_SHAFT_TILE = TILEENTITIES.register(
			"line_shaft_tile",
			() -> TileEntityType.Builder.create(LineShaftTileEntity::new, ModBlocks.LINE_SHAFT.get()).build(null));
	public static final RegistryObject<TileEntityType<LineShaftHangerTileEntity>> LINE_SHAFT_HANGER_TILE = TILEENTITIES
			.register("line_shaft_hanger_tile", () -> TileEntityType.Builder
					.create(LineShaftHangerTileEntity::new, ModBlocks.LINE_SHAFT_HANGER.get()).build(null));

	public static void register() {
		TILEENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
