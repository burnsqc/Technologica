package com.technologica.tileentity;

import static com.technologica.Technologica.MODID;

import com.technologica.block.ModBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
	private static final DeferredRegister<TileEntityType<?>> TILEENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
	
	public static final RegistryObject<TileEntityType<FruitTileEntity>> FRUIT_CROP = TILEENTITIES.register("fruit_crop", () -> TileEntityType.Builder.create(FruitTileEntity::new, ModBlocks.BANANA_LEAVES.get(), ModBlocks.CHERRY_LEAVES.get(), ModBlocks.COCONUT_LEAVES.get(), ModBlocks.KIWI_LEAVES.get(), ModBlocks.LEMON_LEAVES.get(), ModBlocks.LIME_LEAVES.get(), ModBlocks.ORANGE_LEAVES.get(), ModBlocks.PEACH_LEAVES.get(), ModBlocks.PEAR_LEAVES.get(), ModBlocks.FRUITFUL_LEAVES.get(), ModBlocks.ALCHEMICAL_LEAVES.get()).build(null));
    public static final RegistryObject<TileEntityType<PotionTileEntity>> POTION_CROP = TILEENTITIES.register("potion_crop", () -> TileEntityType.Builder.create(PotionTileEntity::new, ModBlocks.BENEVOLENT_LEAVES.get(), ModBlocks.MALEVOLENT_LEAVES.get()).build(null));
    public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_TILE = TILEENTITIES.register("display_tile", () -> TileEntityType.Builder.create(DisplayCaseTileEntity::new, ModBlocks.DISPLAY_CASE.get()).build(null));
	
	public static void register() 
    {
        TILEENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
